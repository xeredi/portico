package xeredi.integra.model.vo.estadistica;

import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticaExportVO.
 */
public final class EstadisticaExportVO {

    /** The subpuerto. */
    private String autp;

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
     * Gets the subpuerto.
     * 
     * @return the subpuerto
     */
    public String getAutp() {
        return autp;
    }

    /**
     * Sets the subpuerto.
     * 
     * @param value
     *            the new subpuerto
     */
    public void setAutp(final String value) {
        autp = value;
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
