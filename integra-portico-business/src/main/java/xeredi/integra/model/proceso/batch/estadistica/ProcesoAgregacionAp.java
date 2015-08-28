package xeredi.integra.model.proceso.batch.estadistica;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import xeredi.integra.model.comun.bo.PuertoBO;
import xeredi.integra.model.comun.bo.SuperpuertoBO;
import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.PuertoCriterioVO;
import xeredi.integra.model.comun.vo.PuertoVO;
import xeredi.integra.model.comun.vo.SuperpuertoCriterioVO;
import xeredi.integra.model.comun.vo.SuperpuertoVO;
import xeredi.integra.model.estadistica.bo.PeriodoProcesoBO;
import xeredi.integra.model.estadistica.vo.PeriodoProcesoVO;
import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.proceso.vo.MensajeCodigo;
import xeredi.integra.model.proceso.vo.ProcesoTipo;
import xeredi.integra.proceso.ProcesoTemplate;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoAgregacionAp.
 */
public final class ProcesoAgregacionAp extends ProcesoTemplate {

    /**
     * The Enum params.
     */
    public enum params {
        /** The autp. */
        autp,

        /** The mes. */
        mes,

        /** The anio. */
        anio,

        /** The sobreescribir. */
        sobreescribir
    }

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
        String autpCodigo = null;
        Integer anio = null;
        Integer mes = null;
        Boolean sobreescribir = null;

        if (prpmMap.containsKey(params.autp.name())) {
            autpCodigo = prpmMap.get(params.autp.name()).getValor();
        } else {
            addError(MensajeCodigo.G_012, params.autp.name());
        }

        if (prpmMap.containsKey(params.anio.name())) {
            try {
                anio = Integer.parseInt(prpmMap.get(params.anio.name()).getValor());
            } catch (final NumberFormatException ex) {
                addError(MensajeCodigo.G_013, params.anio.name());
            }
        } else {
            addError(MensajeCodigo.G_012, params.anio.name());
        }

        if (prpmMap.containsKey(params.mes.name())) {
            try {
                mes = Integer.parseInt(prpmMap.get(params.mes.name()).getValor());
            } catch (final NumberFormatException ex) {
                addError(MensajeCodigo.G_013, params.mes.name());
            }
        } else {
            addError(MensajeCodigo.G_012, params.mes.name());
        }

        if (prpmMap.containsKey(params.sobreescribir.name())) {
            try {
                sobreescribir = Boolean.parseBoolean(prpmMap.get(params.sobreescribir.name()).getValor());
            } catch (final NumberFormatException ex) {
                addError(MensajeCodigo.G_013, params.sobreescribir.name());
            }
        } else {
            addError(MensajeCodigo.G_012, params.sobreescribir.name());
        }

        if (prmnList.isEmpty()) {
            try {
                // Comprobar que existe la AP
                final SuperpuertoBO sprtBO = new SuperpuertoBO();
                final SuperpuertoCriterioVO sprtCriterio = new SuperpuertoCriterioVO();

                sprtCriterio.setCodigo(autpCodigo);

                final SuperpuertoVO sprt = sprtBO.selectObject(sprtCriterio);

                final Calendar calendar = Calendar.getInstance();

                calendar.setTimeInMillis(0);
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                calendar.set(Calendar.MONTH, mes - 1);
                calendar.set(Calendar.YEAR, anio);

                // Busqueda de los subpuertos de la AP
                final PuertoBO prtoBO = new PuertoBO();
                final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

                prtoCriterio.setSprtId(sprt.getId());

                final List<PuertoVO> prtoList = prtoBO.selectList(prtoCriterio);

                final PeriodoProcesoBO peprBO = new PeriodoProcesoBO();

                if (prtoList.isEmpty()) {
                    addError(MensajeCodigo.E_002, Entidad.AUTORIDAD_PORTUARIA.name() + ": " + autpCodigo);
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
                        addError(MensajeCodigo.E_001, "Periodo de Proceso: " + pepr.getSprt().getCodigo() + " "
                                + pepr.getAnio() + " " + pepr.getMes());
                    } catch (final IOException ex) {
                        addError(MensajeCodigo.G_000, ex.getMessage());
                    }
                }
            } catch (final InstanceNotFoundException ex) {
                addError(MensajeCodigo.G_001, Entidad.AUTORIDAD_PORTUARIA.name() + ": " + autpCodigo);
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

}
