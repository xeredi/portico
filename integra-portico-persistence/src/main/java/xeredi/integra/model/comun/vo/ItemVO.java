package xeredi.integra.model.comun.vo;

import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemVO.
 */
public abstract class ItemVO implements ItemEntidad {

    /** The id. */
    private Long id;

    /** The enti id. */
    private Long entiId;

    /** The itdt map. */
    private Map<String, ItemDatoVO> itdtMap;

    /**
     * Gets the id.
     *
     * @return the id
     */
    @Override
    public final Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param value
     *            the new id
     */
    @Override
    public final void setId(final Long value) {
        id = value;
    }

    /**
     * Gets the enti id.
     *
     * @return the enti id
     */
    public final Long getEntiId() {
        return entiId;
    }

    /**
     * Sets the enti id.
     *
     * @param value
     *            the new enti id
     */
    public final void setEntiId(final Long value) {
        entiId = value;
    }

    /**
     * Gets the itdt map.
     *
     * @return the itdt map
     */
    public final Map<String, ItemDatoVO> getItdtMap() {
        return itdtMap;
    }

    /**
     * Sets the itdt map.
     *
     * @param value
     *            the value
     */
    public final void setItdtMap(final Map<String, ItemDatoVO> value) {
        itdtMap = value;
    }

}
