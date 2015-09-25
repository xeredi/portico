package xeredi.argo.model.seguridad.vo;

import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionCriterioVO.
 */
public final class AccionCriterioVO extends BaseCriterioVO {

    /** The id. */
    private Long id;

    /** The prefix. */
    private AccionPrefix prefix;

    /** The codigo. */
    private String codigo;

    /** The enti id. */
    private Long entiId;

    /** The grpo id. */
    private Long grpoId;

    /** The usro id. */
    private Long usroId;

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
     * Gets the codigo.
     *
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Sets the codigo.
     *
     * @param value
     *            the new codigo
     */
    public void setCodigo(final String value) {
        codigo = value;
    }

    /**
     * Gets the grpo id.
     *
     * @return the grpo id
     */
    public Long getGrpoId() {
        return grpoId;
    }

    /**
     * Sets the grpo id.
     *
     * @param value
     *            the new grpo id
     */
    public void setGrpoId(final Long value) {
        grpoId = value;
    }

    /**
     * Gets the usro id.
     *
     * @return the usro id
     */
    public Long getUsroId() {
        return usroId;
    }

    /**
     * Sets the usro id.
     *
     * @param value
     *            the new usro id
     */
    public void setUsroId(final Long value) {
        usroId = value;
    }

    /**
     * Gets the prefix.
     *
     * @return the prefix
     */
    public AccionPrefix getPrefix() {
        return prefix;
    }

    /**
     * Sets the prefix.
     *
     * @param value
     *            the new prefix
     */
    public void setPrefix(AccionPrefix value) {
        this.prefix = value;
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
     * @param value
     *            the new enti id
     */
    public void setEntiId(Long value) {
        this.entiId = value;
    }
}
