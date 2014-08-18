package xeredi.integra.model.vo.facturacion;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaAgregadaVO.
 */
public final class FacturaAgregadaVO {

    /** The fctr. */
    private FacturaVO fctr;

    /** The fcts list. */
    private List<FacturaServicioAgregadaVO> fctsList;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the fctr.
     *
     * @return the fctr
     */
    public FacturaVO getFctr() {
        return fctr;
    }

    /**
     * Sets the fctr.
     *
     * @param value
     *            the new fctr
     */
    public void setFctr(final FacturaVO value) {
        fctr = value;
    }

    /**
     * Gets the fcts list.
     *
     * @return the fcts list
     */
    public List<FacturaServicioAgregadaVO> getFctsList() {
        return fctsList;
    }

    /**
     * Sets the fcts list.
     *
     * @param value
     *            the new fcts list
     */
    public void setFctsList(final List<FacturaServicioAgregadaVO> value) {
        fctsList = value;
    }

}
