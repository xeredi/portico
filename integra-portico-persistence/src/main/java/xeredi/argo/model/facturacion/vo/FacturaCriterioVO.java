package xeredi.argo.model.facturacion.vo;

import java.util.Set;

import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaCriterioVO.
 */
public final class FacturaCriterioVO extends BaseCriterioVO {

    /** The id. */
    private Long id;

    /** The ids. */
    private Set<Long> ids;

    /** The estado. */
    private FacturaEstado estado;

    /** The fcsr. */
    private FacturaServicioCriterioVO fcts;

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

    /**
     * Gets the fcsr.
     *
     * @return the fcsr
     */
    public FacturaServicioCriterioVO getFcts() {
        return fcts;
    }

    /**
     * Sets the fcsr.
     *
     * @param value
     *            the fcsr
     */
    public void setFcts(final FacturaServicioCriterioVO value) {
        fcts = value;
    }

    /**
     * Gets the estado.
     *
     * @return the estado
     */
    public FacturaEstado getEstado() {
        return estado;
    }

    /**
     * Sets the estado.
     *
     * @param value
     *            the estado
     */
    public void setEstado(final FacturaEstado value) {
        estado = value;
    }

}
