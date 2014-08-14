package xeredi.integra.model.bo.facturacion;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.vo.facturacion.CargoVO;
import xeredi.integra.model.vo.facturacion.ValoracionImpuestoVO;
import xeredi.integra.model.vo.facturacion.ValoracionLineaVO;
import xeredi.integra.model.vo.facturacion.ValoracionVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionImpresionVO.
 */
public final class ValoracionImpresionVO {

    /** The vlrc. */
    private final transient ValoracionVO vlrc;

    /** The crgo list. */
    private final transient List<CargoVO> crgoList;

    /** The vlri list. */
    private final transient List<ValoracionImpuestoVO> vlriList;

    /** The vlrl list. */
    private final transient List<ValoracionLineaVO> vlrlList;

    /**
     * Instantiates a new valoracion impresion vo.
     *
     * @param avlrc
     *            the avlrc
     * @param acrgoList
     *            the acrgo list
     * @param avlriList
     *            the avlri list
     * @param avlrlList
     *            the avlrl list
     */
    public ValoracionImpresionVO(ValoracionVO avlrc, List<CargoVO> acrgoList, List<ValoracionImpuestoVO> avlriList,
            List<ValoracionLineaVO> avlrlList) {
        super();
        this.vlrc = avlrc;
        this.crgoList = acrgoList;
        this.vlriList = avlriList;
        this.vlrlList = avlrlList;
    }

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
     * Gets the crgo list.
     *
     * @return the crgo list
     */
    public List<CargoVO> getCrgoList() {
        return crgoList;
    }

    /**
     * Gets the vlri list.
     *
     * @return the vlri list
     */
    public List<ValoracionImpuestoVO> getVlriList() {
        return vlriList;
    }

    /**
     * Gets the vlrl list.
     *
     * @return the vlrl list
     */
    public List<ValoracionLineaVO> getVlrlList() {
        return vlrlList;
    }

}
