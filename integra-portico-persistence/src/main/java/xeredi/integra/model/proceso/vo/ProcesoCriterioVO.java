package xeredi.integra.model.proceso.vo;

import java.util.Date;

import xeredi.integra.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoCriterioVO.
 */
public final class ProcesoCriterioVO extends BaseCriterioVO {

    /** The modulo. */
    private ProcesoModulo modulo;

    /** The tipo. */
    private ProcesoTipo tipo;

    /** The estado. */
    private ProcesoEstado estado;

    /** The falta min. */
    private Date faltaMin;

    /** The falta max. */
    private Date faltaMax;

    /**
     * Gets the modulo.
     *
     * @return the modulo
     */
    public ProcesoModulo getModulo() {
        return modulo;
    }

    /**
     * Sets the modulo.
     *
     * @param value
     *            the new modulo
     */
    public void setModulo(final ProcesoModulo value) {
        modulo = value;
    }

    /**
     * Gets the tipo.
     *
     * @return the tipo
     */
    public ProcesoTipo getTipo() {
        return tipo;
    }

    /**
     * Sets the tipo.
     *
     * @param value
     *            the new tipo
     */
    public void setTipo(final ProcesoTipo value) {
        tipo = value;
    }

    /**
     * Gets the estado.
     *
     * @return the estado
     */
    public ProcesoEstado getEstado() {
        return estado;
    }

    /**
     * Sets the estado.
     *
     * @param value
     *            the new estado
     */
    public void setEstado(final ProcesoEstado value) {
        estado = value;
    }

    /**
     * Gets the falta min.
     *
     * @return the falta min
     */
    public Date getFaltaMin() {
        return faltaMin;
    }

    /**
     * Sets the falta min.
     *
     * @param value
     *            the new falta min
     */
    public void setFaltaMin(final Date value) {
        faltaMin = value;
    }

    /**
     * Gets the falta max.
     *
     * @return the falta max
     */
    public Date getFaltaMax() {
        return faltaMax;
    }

    /**
     * Sets the falta max.
     *
     * @param value
     *            the new falta max
     */
    public void setFaltaMax(final Date value) {
        faltaMax = value;
    }

}
