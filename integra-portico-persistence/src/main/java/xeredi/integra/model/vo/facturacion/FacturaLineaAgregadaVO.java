package xeredi.integra.model.vo.facturacion;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaLineaAgregadaVO.
 */
public final class FacturaLineaAgregadaVO {

    /** The fctl. */
    private FacturaLineaVO fctl;

    /** The fctd list. */
    private List<FacturaDetalleVO> fctdList;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the fctl.
     *
     * @return the fctl
     */
    public FacturaLineaVO getFctl() {
        return fctl;
    }

    /**
     * Sets the fctl.
     *
     * @param value
     *            the new fctl
     */
    public void setFctl(final FacturaLineaVO value) {
        fctl = value;
    }

    /**
     * Gets the fctd list.
     *
     * @return the fctd list
     */
    public List<FacturaDetalleVO> getFctdList() {
        return fctdList;
    }

    /**
     * Sets the fctd list.
     *
     * @param value
     *            the new fctd list
     */
    public void setFctdList(final List<FacturaDetalleVO> value) {
        fctdList = value;
    }

}
