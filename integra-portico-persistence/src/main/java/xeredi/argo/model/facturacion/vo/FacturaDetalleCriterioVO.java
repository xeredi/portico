package xeredi.argo.model.facturacion.vo;

import java.util.Set;

import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaDetalleCriterioVO.
 */
public final class FacturaDetalleCriterioVO extends BaseCriterioVO {

    /** The fctl. */
    private FacturaLineaCriterioVO fctl;

    /** The id. */
    private Long id;

    /** The ids. */
    private Set<Long> ids;

    /**
     * Gets the fctl.
     *
     * @return the fctl
     */
    public FacturaLineaCriterioVO getFctl() {
        return fctl;
    }

    /**
     * Sets the fctl.
     *
     * @param value
     *            the fctl
     */
    public void setFctl(final FacturaLineaCriterioVO value) {
        fctl = value;
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
