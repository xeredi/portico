package xeredi.integra.model.facturacion.vo;

import java.util.Date;

import xeredi.integra.model.comun.vo.TypeaheadCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoTypeaheadCriterioVO.
 */
public final class AspectoTypeaheadCriterioVO extends TypeaheadCriterioVO {

    /** The fecha vigencia. */
    private Date fechaVigencia;

    /** The tpsr id. */
    private Long tpsrId;

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

    /**
     * Gets the tpsr id.
     *
     * @return the tpsr id
     */
    public Long getTpsrId() {
        return tpsrId;
    }

    /**
     * Sets the tpsr id.
     *
     * @param value
     *            the new tpsr id
     */
    public void setTpsrId(final Long value) {
        tpsrId = value;
    }
}
