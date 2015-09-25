package xeredi.argo.model.metamodelo.vo;

import java.util.HashSet;
import java.util.Set;

import xeredi.argo.model.seguridad.vo.AccionVO;

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
    private Long entiId;

    /** The grpo ids. */
    private Set<Long> grpoIds;

    /**
     * Instantiates a new accion entidad vo.
     */
    public AccionEntidadVO() {
        super();

        grpoIds = new HashSet<>();
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
     * @param value
     *            the new accn
     */
    public void setAccn(AccionVO value) {
        this.accn = value;
    }

    /**
     * Gets the enti id.
     *
     * @return the enti id
     */
    public Long getEntiId() {
        return entiId;
    }

    /**
     * Sets the enti id.
     *
     * @param value the new enti id
     */
    public void setEntiId(Long value) {
        this.entiId = value;
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
     * @param value
     *            the new grpo ids
     */
    public void setGrpoIds(Set<Long> value) {
        this.grpoIds = value;
    }
}
