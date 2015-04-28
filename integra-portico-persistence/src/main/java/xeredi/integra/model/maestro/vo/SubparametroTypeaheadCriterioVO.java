package xeredi.integra.model.maestro.vo;

import java.util.Date;

import xeredi.integra.model.comun.vo.TypeaheadCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubparametroTypeaheadCriterioVO.
 */
public final class SubparametroTypeaheadCriterioVO extends TypeaheadCriterioVO {

    /** The tpsp id. */
    private Long tpspId;

    /** The fecha vigencia. */
    private Date fechaVigencia;

    /**
     * Gets the tpsp id.
     *
     * @return the tpsp id
     */
    public Long getTpspId() {
        return tpspId;
    }

    /**
     * Sets the tpsp id.
     *
     * @param value
     *            the new tpsp id
     */
    public void setTpspId(final Long value) {
        tpspId = value;
    }

    /**
     * Gets the fecha vigencia.
     *
     * @return the fecha vigencia
     */
    public Date getFechaVigencia() {
        return fechaVigencia;
    }

    /**
     * Sets the fecha vigencia.
     *
     * @param value
     *            the new fecha vigencia
     */
    public void setFechaVigencia(final Date value) {
        fechaVigencia = value;
    }
}
