package xeredi.integra.proceso.estadistica.agregacionap;

import java.util.Calendar;
import java.util.List;

import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.estadistica.bo.PeriodoProcesoBO;
import xeredi.integra.model.estadistica.vo.PeriodoProcesoVO;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.vo.ParametroCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.proceso.vo.MensajeCodigo;
import xeredi.integra.model.proceso.vo.ProcesoModulo;
import xeredi.integra.model.proceso.vo.ProcesoTipo;
import xeredi.integra.proceso.ProcesoTemplate;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoAgregacionAp.
 */
public final class ProcesoAgregacionAp extends ProcesoTemplate {

    /** The Constant AUTP_PARAM. */
    public static final String AUTP_PARAM = "autp";

    /** The Constant MES_PARAM. */
    public static final String MES_PARAM = "mes";

    /** The Constant ANIO_PARAM. */
    public static final String ANIO_PARAM = "anio";

    /** The Constant SOBREESCRIBIR_PARAM. */
    public static final String SOBREESCRIBIR_PARAM = "sobreescribir";

    /**
     * {@inheritDoc}
     */
    @Override
    protected void ejecutar() {
        // Validacion de parametros
        Long autpId = null;
        Integer anio = null;
        Integer mes = null;
        Boolean sobreescribir = null;

        if (prbtVO.getPrpmMap().containsKey(AUTP_PARAM)) {
            try {
                autpId = Long.parseLong(prbtVO.getPrpmMap().get(AUTP_PARAM));
            } catch (final NumberFormatException ex) {
                addError(MensajeCodigo.G_013, AUTP_PARAM);
            }
        } else {
            addError(MensajeCodigo.G_012, AUTP_PARAM);
        }

        if (prbtVO.getPrpmMap().containsKey(ANIO_PARAM)) {
            try {
                anio = Integer.parseInt(prbtVO.getPrpmMap().get(ANIO_PARAM));
            } catch (final NumberFormatException ex) {
                addError(MensajeCodigo.G_013, ANIO_PARAM);
            }
        } else {
            addError(MensajeCodigo.G_012, ANIO_PARAM);
        }

        if (prbtVO.getPrpmMap().containsKey(MES_PARAM)) {
            try {
                mes = Integer.parseInt(prbtVO.getPrpmMap().get(MES_PARAM));
            } catch (final NumberFormatException ex) {
                addError(MensajeCodigo.G_013, MES_PARAM);
            }
        } else {
            addError(MensajeCodigo.G_012, MES_PARAM);
        }

        if (prbtVO.getPrpmMap().containsKey(SOBREESCRIBIR_PARAM)) {
            try {
                sobreescribir = Boolean.parseBoolean(prbtVO.getPrpmMap().get(SOBREESCRIBIR_PARAM));
            } catch (final NumberFormatException ex) {
                addError(MensajeCodigo.G_013, ANIO_PARAM);
            }
        } else {
            addError(MensajeCodigo.G_012, SOBREESCRIBIR_PARAM);
        }

        if (prbtVO.getPrmnList().isEmpty()) {
            try {
                // Comprobar que existe la AP
                final ParametroBO prmtBO = new ParametroBO();
                final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();
                final Calendar calendar = Calendar.getInstance();

                calendar.setTimeInMillis(0);
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                calendar.set(Calendar.MONTH, mes - 1);
                calendar.set(Calendar.YEAR, anio);

                prmtCriterioVO.setId(autpId);
                prmtCriterioVO.setFechaVigencia(calendar.getTime());

                final ParametroVO autp = prmtBO.selectObject(prmtCriterioVO);

                // Busqueda de los subpuertos de la AP

                final PeriodoProcesoBO peprBO = new PeriodoProcesoBO();
                final List<Long> subpIds = peprBO.selectSubpIds(autpId, calendar.getTime());

                if (subpIds.isEmpty()) {
                    addError(MensajeCodigo.E_002, Entidad.AUTORIDAD_PORTUARIA.name() + ": " + autpId);
                } else {
                    final PeriodoProcesoVO peprVO = new PeriodoProcesoVO();

                    peprVO.setAutp(autp);
                    peprVO.setAnio(anio);
                    peprVO.setMes(mes);
                    peprVO.setFreferencia(calendar.getTime());

                    try {
                        peprBO.agregarServicios(peprVO, subpIds, sobreescribir);
                    } catch (final DuplicateInstanceException ex) {
                        addError(MensajeCodigo.E_001, "Periodo de Proceso: " + peprVO.getAutp().getParametro() + " "
                                + peprVO.getAnio() + " " + peprVO.getMes());
                    }
                }
            } catch (final InstanceNotFoundException ex) {
                addError(MensajeCodigo.G_001, Entidad.AUTORIDAD_PORTUARIA.name() + ": " + autpId);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ProcesoTipo getProcesoTipo() {
        return ProcesoTipo.EST_CREACION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ProcesoModulo getProcesoModulo() {
        return ProcesoModulo.E;
    }

}