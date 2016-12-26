package xeredi.argo.model.seguridad.service;

import lombok.NonNull;

// TODO: Auto-generated Javadoc
/**
 * The Interface UsuarioPermisoService.
 */
public interface UsuarioPermisoService {

	/**
	 * Checks for fncd.
	 *
	 * @param usroId
	 *            the usro id
	 * @param fncdId
	 *            the fncd id
	 * @return true, if successful
	 */
	boolean hasFncd(@NonNull final Long usroId, @NonNull final Long fncdId);

	/**
	 * Checks for acbs.
	 *
	 * @param usroId
	 *            the usro id
	 * @param prefix
	 *            the prefix
	 * @param codigo
	 *            the codigo
	 * @return true, if successful
	 */
	boolean hasAcbs(@NonNull final Long usroId, @NonNull final String prefix, @NonNull final String codigo);

	/**
	 * Checks for acen.
	 *
	 * @param usroId
	 *            the usro id
	 * @param prefix
	 *            the prefix
	 * @param codigo
	 *            the codigo
	 * @param entiId
	 *            the enti id
	 * @return true, if successful
	 */
	boolean hasAcen(@NonNull final Long usroId, @NonNull final String prefix, @NonNull final String codigo,
			@NonNull final Long entiId);
}
