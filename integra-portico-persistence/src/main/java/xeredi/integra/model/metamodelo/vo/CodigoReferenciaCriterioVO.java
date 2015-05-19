package xeredi.integra.model.metamodelo.vo;

import java.util.Set;

import xeredi.integra.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CodigoReferenciaCriterioVO.
 */
public final class CodigoReferenciaCriterioVO extends BaseCriterioVO {
    /** The id. */
    private Long id;

    /** The tpdt id. */
    private Long tpdtId;

    /** The tpdt ids. */
    private Set<Long> tpdtIds;

    /** The valor. */
    private String valor;

    /**
     * Gets the tpdt ids.
     *
     * @return the tpdt ids
     */
    public Set<Long> getTpdtIds() {
        return tpdtIds;
    }

    /**
     * Sets the tpdt ids.
     *
     * @param value
     *            the new tpdt ids
     */
    public void setTpdtIds(final Set<Long> value) {
        tpdtIds = value;
    }

    /**
     * Gets the tpdt id.
     *
     * @return the tpdt id
     */
    public Long getTpdtId() {
        return tpdtId;
    }

    /**
     * Sets the tpdt id.
     *
     * @param value
     *            the tpdt id
     */
    public void setTpdtId(final Long value) {
        tpdtId = value;
    }

    /**
     * Gets the valor.
     *
     * @return the valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * Sets the valor.
     *
     * @param value
     *            the valor
     */
    public void setValor(final String value) {
        valor = value;
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

}
