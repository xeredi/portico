package xeredi.integra.model.estadistica.vo;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.comun.vo.ItemVO;
import xeredi.integra.model.comun.vo.PuertoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticaVO.
 */
public final class EstadisticaVO extends ItemVO {
    /** The prpr id. */
    private PeriodoProcesoVO pepr;

    /** The autp. */
    private PuertoVO prto;

    /** The fref. */
    private Date fref;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getEtiqueta() {
        // FIXME Implementar
        return null;
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
     * Gets the pepr.
     *
     * @return the pepr
     */
    public PeriodoProcesoVO getPepr() {
        return pepr;
    }

    /**
     * Sets the pepr.
     *
     * @param value
     *            the new pepr
     */
    public void setPepr(final PeriodoProcesoVO value) {
        pepr = value;
    }

    /**
     * Gets the fref.
     *
     * @return the fref
     */
    public Date getFref() {
        return fref;
    }

    /**
     * Sets the fref.
     *
     * @param value
     *            the new fref
     */
    public void setFref(final Date value) {
        fref = value;
    }

}
