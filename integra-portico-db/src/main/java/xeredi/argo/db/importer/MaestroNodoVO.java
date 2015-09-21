package xeredi.argo.db.importer;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.argo.model.metamodelo.vo.Entidad;

// TODO: Auto-generated Javadoc
/**
 * The Class MaestroVO.
 */
public final class MaestroNodoVO {

	/** The entidad. */
	private final Entidad entidad;

	/** The temp imp. */
	private final boolean tempImp;

	/** The sql query. */
	private final StringBuffer sqlQuery;

	/**
	 * Instantiates a new maestro vo.
	 *
	 * @param aentidad
	 *            the aentidad
	 * @param atempImp
	 *            the atemp imp
	 * @param asqlQuery
	 *            the asql query
	 */
	public MaestroNodoVO(final Entidad aentidad, final boolean atempImp,
			final StringBuffer asqlQuery) {
		super();
		this.entidad = aentidad;
		this.tempImp = atempImp;
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
	 * Checks if is temp imp.
	 *
	 * @return true, if is temp imp
	 */
	public boolean isTempImp() {
		return tempImp;
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
