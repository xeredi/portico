package xeredi.integra.model.estadistica.vo;

import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticaAgregadoVO.
 */
public class EstadisticaAgregadoVO {

    /** The subp id. */
    private Long subpId;

    /** The esdt map. */
    private Map<String, Object> esdtMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the subp id.
     * 
     * @return the subp id
     */
    public Long getSubpId() {
        return subpId;
    }

    /**
     * Sets the subp id.
     * 
     * @param value
     *            the new subp id
     */
    public void setSubpId(final Long value) {
        subpId = value;
    }

    /**
     * Gets the esdt map.
     * 
     * @return the esdt map
     */
    public Map<String, Object> getEsdtMap() {
        return esdtMap;
    }

    /**
     * Sets the esdt map.
     * 
     * @param value
     *            the value
     */
    public void setEsdtMap(final Map<String, Object> value) {
        esdtMap = value;
    }

}
