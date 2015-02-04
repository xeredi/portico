package xeredi.integra.proceso.servicio.manifiesto;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.IOUtils;

import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.proxy.ConfigurationProxy;
import xeredi.integra.model.comun.vo.ConfigurationKey;
import xeredi.integra.model.comun.vo.ItemDatoCriterioVO;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.bo.ParametroBOFactory;
import xeredi.integra.model.maestro.vo.ParametroCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.metamodelo.vo.TipoDato;
import xeredi.integra.model.proceso.vo.MensajeCodigo;
import xeredi.integra.model.proceso.vo.ProcesoArchivoVO;
import xeredi.integra.model.proceso.vo.ProcesoItemVO;
import xeredi.integra.model.proceso.vo.ProcesoModulo;
import xeredi.integra.model.proceso.vo.ProcesoTipo;
import xeredi.integra.model.servicio.bo.escala.EscalaBO;
import xeredi.integra.model.servicio.bo.manifiesto.ManifiestoBO;
import xeredi.integra.model.servicio.io.manifiesto.ManifiestoFileImport;
import xeredi.integra.model.servicio.io.manifiesto.ManifiestoMensaje;
import xeredi.integra.model.servicio.vo.ServicioCriterioVO;
import xeredi.integra.model.servicio.vo.ServicioVO;
import xeredi.integra.proceso.ProcesoTemplate;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoCargaManifiesto.
 */
public final class ProcesoCargaManifiesto extends ProcesoTemplate {
    /** The path entrada. */
    private static String PATH_ENTRADA;

    /** The path procesado. */
    private static String PATH_PROCESADO;

    /** The path erroneo. */
    private static String PATH_ERRONEO;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void ejecutar() {
        PATH_ENTRADA = ConfigurationProxy.getString(ConfigurationKey.manifiesto_files_entrada_home);
        PATH_PROCESADO = ConfigurationProxy.getString(ConfigurationKey.manifiesto_files_procesado_home);
        PATH_ERRONEO = ConfigurationProxy.getString(ConfigurationKey.manifiesto_files_erroneo_home);

        for (final ProcesoArchivoVO prarVO : prbtVO.getPrarEntradaList()) {
            final String pathArchivo = PATH_ENTRADA + "/" + prarVO.getNombre();

            LOG.info("Importar: " + pathArchivo);

            try (final Reader reader = new FileReader(pathArchivo)) {
                final ManifiestoFileImport fileImport = new ManifiestoFileImport(prbtVO);
                final List<String> lines = IOUtils.readLines(reader);
                final int primeraLinea = fileImport.findPrimeraLinea(lines);

                if (prbtVO.getPrmnList().isEmpty()) {
                    fileImport.validarSegmentos(lines, primeraLinea);
                }
                if (prbtVO.getPrmnList().isEmpty()) {
                    fileImport.readMaestros(lines, primeraLinea);
                }
                if (prbtVO.getPrmnList().isEmpty()) {
                    // FIXME Obtener la fecha de vigencia
                    final Date fechaVigencia = Calendar.getInstance().getTime();

                    buscarMaestros(fileImport.getCodigoMaestroMap(), fechaVigencia);
                    buscarOrganizaciones(fileImport.getNifSet(), fechaVigencia);

                    findEscala(fileImport, fechaVigencia);

                    fileImport.setMaestroMap(maestroMap);
                    fileImport.setOrganizacionesMap(organizacionesMap);
                }
                if (prbtVO.getPrmnList().isEmpty()) {
                    fileImport.readFile(lines, primeraLinea);
                }
                if (prbtVO.getPrmnList().isEmpty()) {
                    final ManifiestoMensaje mensaje = fileImport.getMensaje();
                    final ManifiestoBO srvcBO = new ManifiestoBO();

                    switch (mensaje) {
                    case MANIFIESTO_ALTA:
                        try {
                            if (LOG.isDebugEnabled()) {
                                LOG.debug("Alta de un nuevo manifiesto");
                            }

                            srvcBO.insert(fileImport.getManifiestoVO(), fileImport.getSsrvList(),
                                    fileImport.getSsssList());

                            final ProcesoItemVO pritSalidaVO = new ProcesoItemVO();

                            pritSalidaVO.setItemId(fileImport.getManifiestoVO().getId());
                            prbtVO.getPritSalidaList().add(pritSalidaVO);
                        } catch (final DuplicateInstanceException ex) {
                            throw new Error(ex);
                        }

                        break;

                    default:
                        break;
                    }
                }
            } catch (final IOException ex) {
                LOG.error(ex, ex);

                addError(MensajeCodigo.G_010, "archivo:" + pathArchivo + ", error:" + ex.getMessage());
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ProcesoTipo getProcesoTipo() {
        return ProcesoTipo.MAN_CARGA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ProcesoModulo getProcesoModulo() {
        return ProcesoModulo.S;
    }

    /**
     * Find escala.
     *
     * @param fileImport
     *            the file import
     * @param fechaVigencia
     *            the fecha vigencia
     */
    private void findEscala(final ManifiestoFileImport fileImport, final Date fechaVigencia) {
        final String recintoAduaneroCode = fileImport.getRecintoAduanero();
        final ParametroVO recintoAduanero = maestroMap.get(Entidad.RECINTO_ADUANERO).get(recintoAduaneroCode);

        ParametroVO subpuerto = null;
        ServicioVO escalaVO = null;
        ParametroVO buque = null;

        if (recintoAduanero == null) {
            addError(MensajeCodigo.G_001, Entidad.RECINTO_ADUANERO.name() + ": " + recintoAduaneroCode);
        }

        if (prbtVO.getPrmnList().isEmpty()) {
            // Busqueda del subpuerto
            final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

            prmtCriterioVO.setEntiId(Entidad.SUBPUERTO.getId());
            prmtCriterioVO.setFechaVigencia(fechaVigencia);
            prmtCriterioVO.setItdtMap(new HashMap<Long, ItemDatoCriterioVO>());

            final ItemDatoCriterioVO itdtCriterioVO = new ItemDatoCriterioVO();

            itdtCriterioVO.setTpdtId(TipoDato.UNLOCODE.getId());
            itdtCriterioVO.setPrmt(recintoAduanero.getItdtMap().get(TipoDato.UNLOCODE.getId()).getPrmt());

            prmtCriterioVO.getItdtMap().put(itdtCriterioVO.getTpdtId(), itdtCriterioVO);

            try {
                final ParametroBO prmtBO = ParametroBOFactory.newInstance(prmtCriterioVO.getEntiId());

                subpuerto = prmtBO.selectObject(prmtCriterioVO);
            } catch (final InstanceNotFoundException ex) {
                addError(MensajeCodigo.G_001,
                        Entidad.SUBPUERTO.name() + ": "
                                + recintoAduanero.getItdtMap().get(TipoDato.UNLOCODE.getId()).getPrmt().getParametro());
            }
        }

        if (subpuerto != null) {
            // Busqueda de la escala
            final EscalaBO escaBO = new EscalaBO();
            final ServicioCriterioVO srvcCriterioVO = new ServicioCriterioVO();

            srvcCriterioVO.setSubp(subpuerto);
            srvcCriterioVO.setAnno(fileImport.getEscalaVO().getAnno());
            srvcCriterioVO.setNumero(fileImport.getEscalaVO().getNumero());

            try {
                escalaVO = escaBO.selectObject(srvcCriterioVO);
            } catch (final InstanceNotFoundException ex) {
                addError(MensajeCodigo.G_001, Entidad.ESCALA.name() + ": " + srvcCriterioVO.getSubp().getParametro()
                        + '/' + srvcCriterioVO.getAnno() + '/' + srvcCriterioVO.getNumero());
            }
        }

        if (escalaVO != null) {
            try {
                // Busqueda del buque de la escala
                final ParametroBO prmtBO = ParametroBOFactory.newInstance(Entidad.BUQUE.getId());

                buque = prmtBO.select(escalaVO.getItdtMap().get(TipoDato.BUQUE.getId()).getPrmt().getId(), null,
                        fechaVigencia);

                escalaVO.getItdtMap().get(TipoDato.BUQUE.getId()).setPrmt(buque);
            } catch (final InstanceNotFoundException ex) {
                throw new Error(ex);
            }
        }

        fileImport.setEscalaVO(escalaVO);
    }
}
