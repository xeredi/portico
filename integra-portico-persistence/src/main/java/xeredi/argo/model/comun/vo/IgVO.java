package xeredi.argo.model.comun.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class IgVO.
 */
public final class IgVO {

    /** The nombre. */
    private String nombre;

    /** The inicio. */
    private Long inicio;

    /** The fin. */
    private Long fin;

    /** The incremento. */
    private Long incremento;

    /** The cache. */
    private Long cache;

    /** The ultimo. */
    private Long ultimo;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the nombre.
     * 
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the nombre.
     * 
     * @param value
     *            the new nombre
     */
    public void setNombre(final String value) {
        nombre = value;
    }

    /**
     * Gets the inicio.
     * 
     * @return the inicio
     */
    public Long getInicio() {
        return inicio;
    }

    /**
     * Sets the inicio.
     * 
     * @param value
     *            the new inicio
     */
    public void setInicio(final Long value) {
        inicio = value;
    }

    /**
     * Gets the fin.
     * 
     * @return the fin
     */
    public Long getFin() {
        return fin;
    }

    /**
     * Sets the fin.
     * 
     * @param value
     *            the new fin
     */
    public void setFin(final Long value) {
        fin = value;
    }

    /**
     * Gets the incremento.
     * 
     * @return the incremento
     */
    public Long getIncremento() {
        return incremento;
    }

    /**
     * Sets the incremento.
     * 
     * @param value
     *            the new incremento
     */
    public void setIncremento(final Long value) {
        incremento = value;
    }

    /**
     * Gets the cache.
     * 
     * @return the cache
     */
    public Long getCache() {
        return cache;
    }

    /**
     * Sets the cache.
     * 
     * @param value
     *            the new cache
     */
    public void setCache(final Long value) {
        cache = value;
    }

    /**
     * Gets the ultimo.
     * 
     * @return the ultimo
     */
    public Long getUltimo() {
        return ultimo;
    }

    /**
     * Sets the ultimo.
     * 
     * @param value
     *            the new ultimo
     */
    public void setUltimo(final Long value) {
        ultimo = value;
    }

}
