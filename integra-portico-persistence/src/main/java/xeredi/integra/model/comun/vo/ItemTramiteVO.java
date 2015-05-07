package xeredi.integra.model.comun.vo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.metamodelo.vo.TramiteVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemTramiteVO.
 */
public abstract class ItemTramiteVO {

    /** The id. */
    private Long id;

    /** The trmt. */
    private TramiteVO trmt;

    /** The fecha. */
    private Date fecha;

    /** The fref. */
    private Date fref;

    /** The itdt map. */
    private final Map<Long, ItemTramiteDatoVO> itdtMap;

    /**
     * Instantiates a new item tramite vo.
     */
    public ItemTramiteVO() {
        super();

        itdtMap = new HashMap<Long, ItemTramiteDatoVO>();
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
     * Sets the fecha.
     *
     * @param value
     *            the new fecha
     */
    public final void setFecha(final Date value) {
        fecha = value;
    }

    /**
     * Gets the itdt map.
     *
     * @return the itdt map
     */
    public final Map<Long, ItemTramiteDatoVO> getItdtMap() {
        return itdtMap;
    }
}
