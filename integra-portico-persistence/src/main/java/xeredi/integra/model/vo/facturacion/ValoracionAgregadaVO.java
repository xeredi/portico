package xeredi.integra.model.vo.facturacion;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionAgregadaVO.
 */
public final class ValoracionAgregadaVO {

    /** The vlrc. */
    private ValoracionVO vlrc;

    /** The vlrl list. */
    private List<ValoracionLineaVO> vlrlList;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the vlrc.
     *
     * @return the vlrc
     */
    public ValoracionVO getVlrc() {
        return vlrc;
    }

    /**
     * Sets the vlrc.
     *
     * @param value
     *            the vlrc
     */
    public void setVlrc(ValoracionVO value) {
        this.vlrc = value;
    }

    /**
     * Gets the vlrl list.
     *
     * @return the vlrl list
     */
    public List<ValoracionLineaVO> getVlrlList() {
        return vlrlList;
    }

    /**
     * Sets the vlrl list.
     *
     * @param value
     *            the vlrl list
     */
    public void setVlrlList(List<ValoracionLineaVO> value) {
        this.vlrlList = value;
    }
}
