package xeredi.argo.model.servicio.vo;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.argo.model.comun.vo.PuertoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioMaestroVO.
 */
public final class ServicioMaestroVO {

    /** The subp id. */
    private PuertoVO prto;

    /** The fini. */
    private Date fini;

    /** The ffin. */
    private Date ffin;

    /** The esdt map. */
    private Map<String, Object> itdtMap;

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
    public Map<String, Object> getItdtMap() {
        return itdtMap;
    }

    /**
     * Sets the esdt map.
     *
     * @param value
     *            the value
     */
    public void setItdtMap(final Map<String, Object> value) {
        itdtMap = value;
    }

    /**
     * Gets the fini.
     *
     * @return the fini
     */
    public Date getFini() {
        return fini;
    }

    /**
     * Sets the fini.
     *
     * @param value
     *            the new fini
     */
    public void setFini(final Date value) {
        fini = value;
    }

    /**
     * Gets the ffin.
     *
     * @return the ffin
     */
    public Date getFfin() {
        return ffin;
    }

    /**
     * Sets the ffin.
     *
     * @param value
     *            the new ffin
     */
    public void setFfin(final Date value) {
        ffin = value;
    }
}
