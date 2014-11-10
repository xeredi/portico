package xeredi.integra.model.facturacion.vo;

import java.util.Set;

import xeredi.integra.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioCargoCriterioVO.
 */
public final class ServicioCargoCriterioVO extends BaseCriterioVO {

    /** The vlrc ids. */
    private Set<Long> vlrcIds;

    /**
     * Gets the vlrc ids.
     *
     * @return the vlrc ids
     */
    public Set<Long> getVlrcIds() {
        return vlrcIds;
    }

    /**
     * Sets the vlrc ids.
     *
     * @param value
     *            the vlrc ids
     */
    public void setVlrcIds(final Set<Long> value) {
        vlrcIds = value;
    }

}
