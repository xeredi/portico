package xeredi.argo.model.servicio.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioSubservicioVO.
 */
public final class SubservicioSubservicioVO {

	/** The ssrv padre id. */
	private final Long ssrvPadreId;

	/** The ssrv hijo id. */
	private final Long ssrvHijoId;

	/**
	 * Instantiates a new subservicio subservicio vo.
	 * 
	 * @param assrvPadreId
	 *            the assrv padre id
	 * @param assrvHijoId
	 *            the assrv hijo id
	 */
	public SubservicioSubservicioVO(final Long assrvPadreId,
			final Long assrvHijoId) {
		super();
		this.ssrvPadreId = assrvPadreId;
		this.ssrvHijoId = assrvHijoId;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	/**
	 * Gets the ssrv padre id.
	 * 
	 * @return the ssrv padre id
	 */
	public Long getSsrvPadreId() {
		return ssrvPadreId;
	}

	/**
	 * Gets the ssrv hijo id.
	 * 
	 * @return the ssrv hijo id
	 */
	public Long getSsrvHijoId() {
		return ssrvHijoId;
	}

}
