package xeredi.integra.proceso.estadistica.agregacionap;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import xeredi.integra.model.comun.bo.PuertoBO;
import xeredi.integra.model.comun.bo.SuperpuertoBO;
import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.PuertoCriterioVO;
import xeredi.integra.model.comun.vo.PuertoVO;
import xeredi.integra.model.comun.vo.SuperpuertoVO;
import xeredi.integra.model.estadistica.bo.PeriodoProcesoBO;
import xeredi.integra.model.estadistica.vo.PeriodoProcesoVO;
import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.proceso.vo.ItemTipo;
import xeredi.integra.model.proceso.vo.MensajeCodigo;
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
    protected void prepararProcesos() {
        // noop
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void ejecutarProceso() {
        // Validacion de parametros
        Long autpId = null;
        Integer anio = null;
        Integer mes = null;
        Boolean sobreescribir = null;

        if (prpmMap.containsKey(AUTP_PARAM)) {
            try {
                autpId = Long.parseLong(prpmMap.get(AUTP_PARAM).getValor());
            } catch (final NumberFormatException ex) {
                addError(MensajeCodigo.G_013, AUTP_PARAM);
            }
        } else {
            addError(MensajeCodigo.G_012, AUTP_PARAM);
        }

        if (prpmMap.containsKey(ANIO_PARAM)) {
            try {
                anio = Integer.parseInt(prpmMap.get(ANIO_PARAM).getValor());
            } catch (final NumberFormatException ex) {
                addError(MensajeCodigo.G_013, ANIO_PARAM);
            }
        } else {
            addError(MensajeCodigo.G_012, ANIO_PARAM);
        }

        if (prpmMap.containsKey(MES_PARAM)) {
            try {
                mes = Integer.parseInt(prpmMap.get(MES_PARAM).getValor());
            } catch (final NumberFormatException ex) {
                addError(MensajeCodigo.G_013, MES_PARAM);
            }
        } else {
            addError(MensajeCodigo.G_012, MES_PARAM);
        }

        if (prpmMap.containsKey(SOBREESCRIBIR_PARAM)) {
            try {
                sobreescribir = Boolean.parseBoolean(prpmMap.get(SOBREESCRIBIR_PARAM).getValor());
            } catch (final NumberFormatException ex) {
                addError(MensajeCodigo.G_013, ANIO_PARAM);
            }
        } else {
            addError(MensajeCodigo.G_012, SOBREESCRIBIR_PARAM);
        }

        if (prmnList.isEmpty()) {
            try {
                // Comprobar que existe la AP
                final SuperpuertoBO sprtBO = new SuperpuertoBO();
                final SuperpuertoVO sprt = sprtBO.select(autpId, null);

                final Calendar calendar = Calendar.getInstance();

                calendar.setTimeInMillis(0);
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                calendar.set(Calendar.MONTH, mes - 1);
                calendar.set(Calendar.YEAR, anio);

                // Busqueda de los subpuertos de la AP
                final PuertoBO prtoBO = new PuertoBO();
                final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

                prtoCriterio.setSprtId(autpId);

                final List<PuertoVO> prtoList = prtoBO.selectList(prtoCriterio);

                final PeriodoProcesoBO peprBO = new PeriodoProcesoBO();

                if (prtoList.isEmpty()) {
                    addError(MensajeCodigo.E_002, Entidad.AUTORIDAD_PORTUARIA.name() + ": " + autpId);
                } else {
                    final PeriodoProcesoVO pepr = new PeriodoProcesoVO();

                    pepr.setSprt(sprt);
                    pepr.setAnio(anio);
                    pepr.setMes(mes);
                    pepr.setFreferencia(calendar.getTime());

                    try {
                        peprBO.agregarServicios(pepr, sobreescribir);

                        itemSalidaList.add(pepr.getId());
                    } catch (final DuplicateInstanceException ex) {
                        addError(
                                MensajeCodigo.E_001,
                                "Periodo de Proceso: " + pepr.getSprt().getCodigo() + " " + pepr.getAnio() + " "
                                        + pepr.getMes());
                    } catch (final IOException ex) {
                        addError(MensajeCodigo.G_000, ex.getMessage());
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
    protected ItemTipo getItemTipoSalida() {
        return ItemTipo.pepr;
    }

}
