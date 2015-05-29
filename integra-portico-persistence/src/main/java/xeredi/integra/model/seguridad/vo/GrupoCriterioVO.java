package xeredi.integra.model.seguridad.vo;

import xeredi.integra.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class GrupoCriterioVO.
 */
public final class GrupoCriterioVO extends BaseCriterioVO {

    /** The id. */
    private Long id;

    /** The usro id. */
    private Long usroId;

    /** The accn id. */
    private Long accnId;

    /** The nombre. */
    private String nombre;

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
     * Gets the accn id.
     *
     * @return the accn id
     */
    public Long getAccnId() {
        return accnId;
    }

    /**
     * Sets the accn id.
     *
     * @param value
     *            the new accn id
     */
    public void setAccnId(final Long value) {
        accnId = value;
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
	 * @param value the new nombre
	 */
	public void setNombre(String value) {
		this.nombre = value;
	}
}
