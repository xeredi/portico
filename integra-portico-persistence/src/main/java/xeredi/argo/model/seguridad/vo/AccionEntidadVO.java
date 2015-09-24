package xeredi.argo.model.seguridad.vo;

import java.util.Set;

import xeredi.argo.model.metamodelo.vo.EntidadVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionEntidadVO.
 */
public final class AccionEntidadVO {
    /** The id. */
    private Long id;

    /** The accn id. */
    private AccionVO accn;

    /** The enti id. */
    private EntidadVO enti;

    /** The grpo ids. */
    private Set<Long> grpoIds;

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
     *            the new id
     */
    public void setId(final Long value) {
        id = value;
    }

    /**
     * Gets the accn.
     *
     * @return the accn
     */
    public AccionVO getAccn() {
        return accn;
    }

    /**
     * Sets the accn.
     *
     * @param value the new accn
     */
    public void setAccn(AccionVO value) {
        this.accn = value;
    }

    /**
     * Gets the enti.
     *
     * @return the enti
     */
    public EntidadVO getEnti() {
        return enti;
    }

    /**
     * Sets the enti.
     *
     * @param value the new enti
     */
    public void setEnti(EntidadVO value) {
        this.enti = value;
    }

    /**
     * Gets the grpo ids.
     *
     * @return the grpo ids
     */
    public Set<Long> getGrpoIds() {
        return grpoIds;
    }

    /**
     * Sets the grpo ids.
     *
     * @param value the new grpo ids
     */
    public void setGrpoIds(Set<Long> value) {
        this.grpoIds = value;
    }
}
