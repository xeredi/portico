package xeredi.integra.db.importer;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.util.Entidad;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadVO.
 */
public final class ServicioNodoVO {
	/** The entidad. */
	private final Entidad entidad;

	/** The sql query. */
	private final StringBuffer sqlQuery;

	/**
	 * Instantiates a new entidad vo.
	 * 
	 * @param aentidad
	 *            the aentidad
	 * @param asqlQuery
	 *            the asql query
	 */
	public ServicioNodoVO(final Entidad aentidad, final StringBuffer asqlQuery) {
		super();
		this.entidad = aentidad;
		this.sqlQuery = asqlQuery;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	/**
	 * Gets the entidad.
	 * 
	 * @return the entidad
	 */
	public Entidad getEntidad() {
		return entidad;
	}

	/**
	 * Gets the sql query.
	 * 
	 * @return the sql query
	 */
	public StringBuffer getSqlQuery() {
		return sqlQuery;
	}

}
