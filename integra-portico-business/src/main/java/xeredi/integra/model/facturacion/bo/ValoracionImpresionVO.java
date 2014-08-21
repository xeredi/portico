package xeredi.integra.model.facturacion.bo;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.common.base.Preconditions;

import xeredi.integra.model.facturacion.vo.ValoracionCargoVO;
import xeredi.integra.model.facturacion.vo.ValoracionImpuestoVO;
import xeredi.integra.model.facturacion.vo.ValoracionLineaVO;
import xeredi.integra.model.facturacion.vo.ValoracionVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionImpresionVO.
 */
public final class ValoracionImpresionVO {

    /** The vlrc. */
    private final transient ValoracionVO vlrc;

    /** The vlrg list. */
    private final transient List<ValoracionCargoVO> vlrgList;

    /** The vlri list. */
    private final transient List<ValoracionImpuestoVO> vlriList;

    /** The vlrl list. */
    private final transient List<ValoracionLineaVO> vlrlList;

    /**
     * The Constructor.
     *
     * @param avlrc
     *            the avlrc
     * @param avlrgList
     *            the avlrg list
     * @param avlriList
     *            the avlri list
     * @param avlrlList
     *            the avlrl list
     */
    public ValoracionImpresionVO(ValoracionVO avlrc, List<ValoracionCargoVO> avlrgList,
            List<ValoracionImpuestoVO> avlriList, List<ValoracionLineaVO> avlrlList) {
        super();

        Preconditions.checkNotNull(avlrc);
        Preconditions.checkNotNull(avlrgList);
        Preconditions.checkArgument(!avlrgList.isEmpty());
        Preconditions.checkNotNull(avlriList);
        Preconditions.checkArgument(!avlriList.isEmpty());
        Preconditions.checkNotNull(avlrlList);
        Preconditions.checkArgument(!avlrlList.isEmpty());

        this.vlrc = avlrc;
        this.vlrgList = avlrgList;
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
     * Gets the vlrg list.
     *
     * @return the vlrg list
     */
    public List<ValoracionCargoVO> getVlrgList() {
        return vlrgList;
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
