package xeredi.argo.model.servicio.vo;

import java.util.Date;
import java.util.Map;

import lombok.Data;
import lombok.NonNull;
import xeredi.argo.model.maestro.vo.ParametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioMaestroVO.
 */

/**
 * Instantiates a new servicio maestro VO.
 */
@Data
public final class ServicioMaestroVO {

	/** The subp id. */
	private ParametroVO prmt;

	/** The fini. */
	private Date fini;

	/** The ffin. */
	private Date ffin;

	/** The esdt map. */
	private Map<String, Object> itdtMap;

	/**
	 * Gets the itdt prmt.
	 *
	 * @param key
	 *            the key
	 * @return the itdt prmt
	 */
	public ParametroVO getItdtPrmt(final @NonNull String key) {
		final ParametroVO prmt = new ParametroVO();

		prmt.setId(Long.valueOf(itdtMap.get(key).toString()));

		return prmt;
	}

	/**
	 * Gets the itdt double.
	 *
	 * @param key
	 *            the key
	 * @return the itdt double
	 */
	public Double getItdtDouble(final @NonNull String key) {
		return Double.valueOf(itdtMap.get(key).toString());
	}

	/**
	 * Gets the itdt long.
	 *
	 * @param key
	 *            the key
	 * @return the itdt long
	 */
	public Long getItdtLong(final @NonNull String key) {
		return Long.valueOf(itdtMap.get(key).toString());
	}

	public String getItdtString(final @NonNull String key) {
		return String.valueOf(itdtMap.get(key).toString());
	}
}
