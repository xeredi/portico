package xeredi.argo.model.facturacion.vo;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionLineaAgregadaVO.
 */
public final class ValoracionLineaAgregadaVO {

    /** The vlrl. */
    private ValoracionLineaVO vlrl;

    /** The vlrd list. */
    private List<ValoracionDetalleVO> vlrdList;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the vlrl.
     *
     * @return the vlrl
     */
    public ValoracionLineaVO getVlrl() {
        return vlrl;
    }

    /**
     * Sets the vlrl.
     *
     * @param value
     *            the new vlrl
     */
    public void setVlrl(ValoracionLineaVO value) {
        this.vlrl = value;
    }

    /**
     * Gets the vlrd list.
     *
     * @return the vlrd list
     */
    public List<ValoracionDetalleVO> getVlrdList() {
        return vlrdList;
    }

    /**
     * Sets the vlrd list.
     *
     * @param value
     *            the new vlrd list
     */
    public void setVlrdList(List<ValoracionDetalleVO> value) {
        this.vlrdList = value;
    }

}
