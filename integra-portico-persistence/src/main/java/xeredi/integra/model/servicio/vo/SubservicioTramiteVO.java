package xeredi.integra.model.servicio.vo;

import java.util.Date;

import xeredi.integra.model.comun.vo.ItemTramiteVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioTramiteVO.
 */
public final class SubservicioTramiteVO extends ItemTramiteVO {
    /** The ssrv id. */
    private Long ssrvId;

    /** The ofini. */
    private Date ossrvFini;

    /** The offin. */
    private Date ossrvFfin;

    /** The dfini. */
    private Date dssrvFini;

    /** The dffin. */
    private Date dssrvFfin;

    /**
     * Gets the ssrv id.
     *
     * @return the ssrv id
     */
    public Long getSsrvId() {
        return ssrvId;
    }

    /**
     * Sets the ssrv id.
     *
     * @param value
     *            the new ssrv id
     */
    public void setSsrvId(final Long value) {
        ssrvId = value;
    }

    /**
     * Gets the ossrv fini.
     *
     * @return the ossrv fini
     */
    public final Date getOssrvFini() {
        return ossrvFini;
    }

    /**
     * Sets the ossrv fini.
     *
     * @param value
     *            the new ossrv fini
     */
    public final void setOssrvFini(final Date value) {
        ossrvFini = value;
    }

    /**
     * Gets the ossrv ffin.
     *
     * @return the ossrv ffin
     */
    public final Date getOssrvFfin() {
        return ossrvFfin;
    }

    /**
     * Sets the ossrv ffin.
     *
     * @param value
     *            the new ossrv ffin
     */
    public final void setOssrvFfin(final Date value) {
        ossrvFfin = value;
    }

    /**
     * Gets the dssrv fini.
     *
     * @return the dssrv fini
     */
    public final Date getDssrvFini() {
        return dssrvFini;
    }

    /**
     * Sets the dssrv fini.
     *
     * @param value
     *            the new dssrv fini
     */
    public final void setDssrvFini(final Date value) {
        dssrvFini = value;
    }

    /**
     * Gets the dssrv ffin.
     *
     * @return the dssrv ffin
     */
    public final Date getDssrvFfin() {
        return dssrvFfin;
    }

    /**
     * Sets the dssrv ffin.
     *
     * @param value
     *            the new dssrv ffin
     */
    public final void setDssrvFfin(final Date value) {
        dssrvFfin = value;
    }
}
