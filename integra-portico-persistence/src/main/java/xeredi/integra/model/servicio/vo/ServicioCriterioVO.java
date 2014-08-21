package xeredi.integra.model.servicio.vo;

import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.comun.vo.ItemCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioCriterioVO.
 */
public final class ServicioCriterioVO extends ItemCriterioVO {

    /** The subp id. */
    private Long subpId;

    /** The anno. */
    private String anno;

    /** The numero. */
    private String numero;

    /** The estado. */
    private String estado;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void fillSpecificSearchLinks(Map<String, Object> map) {
        if (subpId != null) {
            map.put("subpId", subpId);
        }
        if (anno != null && !anno.isEmpty()) {
            map.put("anno", anno);
        }
        if (numero != null && !numero.isEmpty()) {
            map.put("numero", numero);
        }
        if (estado != null && !estado.isEmpty()) {
            map.put("estado", estado);
        }
    }

    /**
     * Gets the subp id.
     *
     * @return the subp id
     */
    public Long getSubpId() {
        return subpId;
    }

    /**
     * Sets the subp id.
     *
     * @param value
     *            the new subp id
     */
    public void setSubpId(final Long value) {
        subpId = value;
    }

    /**
     * Gets the anno.
     *
     * @return the anno
     */
    public String getAnno() {
        return anno;
    }

    /**
     * Sets the anno.
     *
     * @param value
     *            the new anno
     */
    public void setAnno(final String value) {
        anno = value;
    }

    /**
     * Gets the numero.
     *
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Sets the numero.
     *
     * @param value
     *            the new numero
     */
    public void setNumero(final String value) {
        numero = value;
    }

    /**
     * Gets the estado.
     * 
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Sets the estado.
     * 
     * @param value
     *            the new estado
     */
    public void setEstado(final String value) {
        estado = value;
    }

}
