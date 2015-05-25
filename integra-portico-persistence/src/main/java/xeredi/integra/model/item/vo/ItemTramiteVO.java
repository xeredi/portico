package xeredi.integra.model.item.vo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.metamodelo.vo.TramiteVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemTramiteVO.
 */
public final class ItemTramiteVO {

    /** The id. */
    private Long id;

    /** The item id. */
    private Long itemId;

    /** The trmt. */
    private TramiteVO trmt;

    /** The fecha. */
    private Date fecha;

    /** The fref. */
    private Date fref;

    /** The oitem fini. */
    private Date oitemFini;

    /** The oitem ffin. */
    private Date oitemFfin;

    /** The ditem fini. */
    private Date ditemFini;

    /** The ditem ffin. */
    private Date ditemFfin;

    /** The itdt map. */
    private final Map<Long, ItemTramiteDatoVO> ittdMap;

    /**
     * Instantiates a new item tramite vo.
     */
    public ItemTramiteVO() {
        super();

        ittdMap = new HashMap<Long, ItemTramiteDatoVO>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public final Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param value
     *            the new id
     */
    public final void setId(final Long value) {
        id = value;
    }

    /**
     * Gets the item id.
     *
     * @return the item id
     */
    public final Long getItemId() {
        return itemId;
    }

    /**
     * Sets the item id.
     *
     * @param value
     *            the new item id
     */
    public final void setItemId(final Long value) {
        itemId = value;
    }

    /**
     * Gets the trmt.
     *
     * @return the trmt
     */
    public final TramiteVO getTrmt() {
        return trmt;
    }

    /**
     * Sets the trmt.
     *
     * @param value
     *            the new trmt
     */
    public final void setTrmt(final TramiteVO value) {
        trmt = value;
    }

    /**
     * Gets the fecha.
     *
     * @return the fecha
     */
    public final Date getFecha() {
        return fecha;
    }

    /**
     * Sets the fecha.
     *
     * @param value
     *            the new fecha
     */
    public final void setFecha(final Date value) {
        fecha = value;
    }

    /**
     * Gets the fref.
     *
     * @return the fref
     */
    public final Date getFref() {
        return fref;
    }

    /**
     * Sets the fref.
     *
     * @param value
     *            the new fref
     */
    public final void setFref(final Date value) {
        fref = value;
    }

    /**
     * Gets the ittd map.
     *
     * @return the ittd map
     */
    public final Map<Long, ItemTramiteDatoVO> getIttdMap() {
        return ittdMap;
    }

    /**
     * Gets the oitem fini.
     *
     * @return the oitem fini
     */
    public final Date getOitemFini() {
        return oitemFini;
    }

    /**
     * Sets the oitem fini.
     *
     * @param value
     *            the new oitem fini
     */
    public final void setOitemFini(final Date value) {
        oitemFini = value;
    }

    /**
     * Gets the oitem ffin.
     *
     * @return the oitem ffin
     */
    public final Date getOitemFfin() {
        return oitemFfin;
    }

    /**
     * Sets the oitem ffin.
     *
     * @param value
     *            the new oitem ffin
     */
    public final void setOitemFfin(final Date value) {
        oitemFfin = value;
    }

    /**
     * Gets the ditem fini.
     *
     * @return the ditem fini
     */
    public final Date getDitemFini() {
        return ditemFini;
    }

    /**
     * Sets the ditem fini.
     *
     * @param value
     *            the new ditem fini
     */
    public final void setDitemFini(final Date value) {
        ditemFini = value;
    }

    /**
     * Gets the ditem ffin.
     *
     * @return the ditem ffin
     */
    public final Date getDitemFfin() {
        return ditemFfin;
    }

    /**
     * Sets the ditem ffin.
     *
     * @param value
     *            the new ditem ffin
     */
    public final void setDitemFfin(final Date value) {
        ditemFfin = value;
    }
}
