package xeredi.integra.model.estadistica.vo;

import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.comun.vo.PuertoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticaAgregadoVO.
 */
public class EstadisticaAgregadoVO {

    /** The subp id. */
    private PuertoVO prto;

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
     * Gets the prto.
     *
     * @return the prto
     */
    public PuertoVO getPrto() {
        return prto;
    }

    /**
     * Sets the prto.
     *
     * @param value
     *            the new prto
     */
    public void setPrto(final PuertoVO value) {
        prto = value;
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
