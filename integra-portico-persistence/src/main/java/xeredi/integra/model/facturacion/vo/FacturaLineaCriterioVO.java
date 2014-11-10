package xeredi.integra.model.facturacion.vo;

import java.util.Set;

import xeredi.integra.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaLineaCriterioVO.
 */
public final class FacturaLineaCriterioVO extends BaseCriterioVO {

    /** The fctr. */
    private FacturaCriterioVO fctr;

    /** The id. */
    private Long id;

    /** The ids. */
    private Set<Long> ids;

    /**
     * Gets the fctr.
     *
     * @return the fctr
     */
    public FacturaCriterioVO getFctr() {
        return fctr;
    }

    /**
     * Sets the fctr.
     *
     * @param value
     *            the fctr
     */
    public void setFctr(final FacturaCriterioVO value) {
        fctr = value;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param value
     *            the id
     */
    public void setId(final Long value) {
        id = value;
    }

    /**
     * Gets the ids.
     *
     * @return the ids
     */
    public Set<Long> getIds() {
        return ids;
    }

    /**
     * Sets the ids.
     *
     * @param value
     *            the ids
     */
    public void setIds(final Set<Long> value) {
        ids = value;
    }

}
