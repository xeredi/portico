package xeredi.integra.model.maestro.vo;

import java.util.Date;

import xeredi.integra.model.comun.vo.ItemTypeaheadCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroTypeaheadCriterioVO.
 */
public final class ParametroTypeaheadCriterioVO extends ItemTypeaheadCriterioVO {

    /** The tpdt nombre id. */
    private Long tpdtNombreId;

    /** The prto id. */
    private Long prtoId;

    /** The fecha vigencia. */
    private Date fechaVigencia;

    /**
     * Gets the tpdt nombre id.
     *
     * @return the tpdt nombre id
     */
    public Long getTpdtNombreId() {
        return tpdtNombreId;
    }

    /**
     * Sets the tpdt nombre id.
     *
     * @param value
     *            the new tpdt nombre id
     */
    public final void setTpdtNombreId(final Long value) {
        tpdtNombreId = value;
    }

    /**
     * Gets the prto id.
     *
     * @return the prto id
     */
    public final Long getPrtoId() {
        return prtoId;
    }

    /**
     * Sets the prto id.
     *
     * @param value
     *            the new prto id
     */
    public final void setPrtoId(final Long value) {
        prtoId = value;
    }

    /**
     * Gets the fecha vigencia.
     *
     * @return the fecha vigencia
     */
    public final Date getFechaVigencia() {
        return fechaVigencia;
    }

    /**
     * Sets the fecha vigencia.
     *
     * @param value
     *            the new fecha vigencia
     */
    public final void setFechaVigencia(final Date value) {
        fechaVigencia = value;
    }

}
