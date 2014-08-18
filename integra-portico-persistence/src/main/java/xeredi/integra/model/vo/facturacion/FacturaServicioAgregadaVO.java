package xeredi.integra.model.vo.facturacion;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaServicioAgregadaVO.
 */
public final class FacturaServicioAgregadaVO {

    /** The fcts. */
    private FacturaServicioVO fcts;

    /** The fctl list. */
    private List<FacturaLineaAgregadaVO> fctlList;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the fcts.
     *
     * @return the fcts
     */
    public FacturaServicioVO getFcts() {
        return fcts;
    }

    /**
     * Sets the fcts.
     *
     * @param value
     *            the new fcts
     */
    public void setFcts(final FacturaServicioVO value) {
        fcts = value;
    }

    /**
     * Gets the fctl list.
     *
     * @return the fctl list
     */
    public List<FacturaLineaAgregadaVO> getFctlList() {
        return fctlList;
    }

    /**
     * Sets the fctl list.
     *
     * @param value
     *            the new fctl list
     */
    public void setFctlList(final List<FacturaLineaAgregadaVO> value) {
        fctlList = value;
    }

}
