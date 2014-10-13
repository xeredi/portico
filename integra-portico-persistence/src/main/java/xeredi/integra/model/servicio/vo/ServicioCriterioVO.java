package xeredi.integra.model.servicio.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.comun.vo.ItemCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioCriterioVO.
 */
public final class ServicioCriterioVO extends ItemCriterioVO {

    /** The subp id. */
    private ParametroVO subp;

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

    // /**
    // * Gets the url map.
    // *
    // * @return the url map
    // */
    // public Map<String, Object> getUrlMap() {
    // final Map<String, Object> map = new HashMap<>();
    //
    // fillUrlMap(map);
    //
    // if (subp != null && subp.getId() != null) {
    // map.put("itemCriterio.subp.id", subp.getId());
    // }
    // if (anno != null) {
    // map.put("itemCriterio.anno", anno);
    // }
    // if (numero != null) {
    // map.put("itemCriterio.numero", numero);
    // }
    // if (estado != null) {
    // map.put("itemCriterio.estado", estado);
    // }
    //
    // return map;
    // }

    /**
     * Gets the subp.
     *
     * @return the subp
     */
    public ParametroVO getSubp() {
        return subp;
    }

    /**
     * Sets the subp.
     *
     * @param value
     *            the new subp
     */
    public void setSubp(final ParametroVO value) {
        subp = value;
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
