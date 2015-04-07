package xeredi.integra.proceso.servicio.manifiesto;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xeredi.integra.model.comun.bo.ArchivoBO;
import xeredi.integra.model.comun.bo.PuertoBO;
import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.proxy.ConfigurationProxy;
import xeredi.integra.model.comun.vo.ArchivoInfoVO;
import xeredi.integra.model.comun.vo.ConfigurationKey;
import xeredi.integra.model.comun.vo.PuertoCriterioVO;
import xeredi.integra.model.comun.vo.PuertoVO;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.bo.ParametroBOFactory;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.metamodelo.vo.TipoDato;
import xeredi.integra.model.proceso.bo.ProcesoBO;
import xeredi.integra.model.proceso.vo.ItemTipo;
import xeredi.integra.model.proceso.vo.MensajeCodigo;
import xeredi.integra.model.proceso.vo.ProcesoTipo;
import xeredi.integra.model.servicio.bo.escala.EscalaBO;
import xeredi.integra.model.servicio.bo.manifiesto.ManifiestoBO;
import xeredi.integra.model.servicio.io.manifiesto.ManifiestoFileImport;
import xeredi.integra.model.servicio.io.manifiesto.ManifiestoMensaje;
import xeredi.integra.model.servicio.vo.ServicioCriterioVO;
import xeredi.integra.model.servicio.vo.ServicioVO;
import xeredi.integra.proceso.FiledateComparator;
import xeredi.integra.proceso.ProcesoTemplate;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoCargaManifiesto.
 */
public final class ProcesoCargaManifiesto extends ProcesoTemplate {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ProcesoCargaManifiesto.class);

    /**
     * {@inheritDoc}
     */
    @Override
    protected void prepararProcesos() {
        final ProcesoBO prbtBO = new ProcesoBO();

        final String folderPath = ConfigurationProxy.getString(ConfigurationKey.manifiesto_files_entrada_home);
        final File folder = new File(folderPath);
        final File[] files = folder.listFiles();

        if (files != null && files.length > 0) {
            Arrays.sort(files, new FiledateComparator());

            for (final File file : files) {
                try {
                    if (LOG.isInfoEnabled()) {
                        LOG.info("Crear proceso para archivo: " + file.getCanonicalPath());
                    }

                    prbtBO.crear(ProcesoTipo.MAN_CARGA, null, null, null, file);

                    file.delete();
                } catch (final IOException ex) {
                    LOG.fatal(ex, ex);
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void ejecutarProceso() {
        for (final ArchivoInfoVO arin : arinEntradaList) {
            LOG.info("Importar: " + arin.getNombre());

            final ArchivoBO flsrBO = new ArchivoBO();

            try (final InputStream stream = flsrBO.select(arin.getId())) {
                final ManifiestoFileImport fileImport = new ManifiestoFileImport(this);
                final List<String> lines = IOUtils.readLines(stream);
                final int primeraLinea = fileImport.findPrimeraLinea(lines);

                if (prmnList.isEmpty()) {
                    fileImport.validarSegmentos(lines, primeraLinea);
                }
                if (prmnList.isEmpty()) {
                    fileImport.readMaestros(lines, primeraLinea);
                }
                if (prmnList.isEmpty()) {
                    // FIXME Obtener la fecha de vigencia
                    final Date fechaVigencia = Calendar.getInstance().getTime();

                    buscarMaestros(fechaVigencia);
                    buscarOrganizaciones(fechaVigencia);

                    findEscala(fileImport, fechaVigencia);
                }
                if (prmnList.isEmpty()) {
                    fileImport.readFile(lines, primeraLinea);
                }
                if (prmnList.isEmpty()) {
                    final ManifiestoMensaje mensaje = fileImport.getMensaje();
                    final ManifiestoBO srvcBO = new ManifiestoBO();

                    switch (mensaje) {
                    case MANIFIESTO_ALTA:
                        try {
                            if (LOG.isDebugEnabled()) {
                                LOG.debug("Alta de un nuevo manifiesto");
                            }

                            srvcBO.insert(fileImport.getManifiestoVO(), fileImport.getSsrvList(),
                                    fileImport.getSsssList(), arin.getId());

                            itemSalidaList.add(fileImport.getManifiestoVO().getId());
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

                addError(MensajeCodigo.G_010, "archivo:" + arin.getNombre() + ", error:" + ex.getMessage());
            } catch (final InstanceNotFoundException ex) {
                LOG.error(ex, ex);

                addError(MensajeCodigo.G_000, "archivo:" + arin.getNombre() + ", error:" + ex.getMessage());
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
    protected ItemTipo getItemTipoSalida() {
        return ItemTipo.srvc;
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

        PuertoVO prto = null;
        ServicioVO escala = null;

        if (recintoAduaneroCode == null) {
            addError(MensajeCodigo.G_001, Entidad.RECINTO_ADUANERO.name() + ": " + recintoAduaneroCode);
        } else {
            final PuertoBO prtoBO = new PuertoBO();
            final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

            prtoCriterio.setRecAduanero(recintoAduaneroCode);

            try {
                prto = prtoBO.selectObject(prtoCriterio);

                if (prmnList.isEmpty()) {
                    // Busqueda de la escala
                    final EscalaBO escaBO = new EscalaBO();
                    final ServicioCriterioVO srvcCriterioVO = new ServicioCriterioVO();

                    srvcCriterioVO.setPrto(new PuertoCriterioVO());
                    srvcCriterioVO.getPrto().setId(prto.getId());

                    srvcCriterioVO.setAnno(fileImport.getEscalaVO().getAnno());
                    srvcCriterioVO.setNumero(fileImport.getEscalaVO().getNumero());
                    srvcCriterioVO.setEntiId(Entidad.ESCALA.getId());

                    try {
                        escala = escaBO.selectObject(srvcCriterioVO);

                        try {
                            // Busqueda del buque de la escala
                            final ParametroBO prmtBO = ParametroBOFactory.newInstance(Entidad.BUQUE.getId());
                            final ParametroVO buque = prmtBO.select(escala.getItdtMap().get(TipoDato.BUQUE.getId())
                                    .getPrmt().getId(), null, fechaVigencia);

                            escala.getItdtMap().get(TipoDato.BUQUE.getId()).setPrmt(buque);

                            fileImport.setEscalaVO(escala);
                        } catch (final InstanceNotFoundException ex) {
                            throw new Error(ex);
                        }
                    } catch (final InstanceNotFoundException ex) {
                        addError(MensajeCodigo.G_001, Entidad.ESCALA.name() + ": " + prto.getCodigoCorto() + '/'
                                + srvcCriterioVO.getAnno() + '/' + srvcCriterioVO.getNumero());
                    }
                }
            } catch (final InstanceNotFoundException ex) {
                addError(MensajeCodigo.G_001, Entidad.SUBPUERTO.name() + ": " + recintoAduaneroCode);
            }
        }

    }
}
