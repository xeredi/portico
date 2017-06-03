package xeredi.argo.model.seguridad.service;

import javax.inject.Inject;

import org.mybatis.guice.transactional.Transactional;

import lombok.NonNull;
import xeredi.argo.model.seguridad.dao.UsuarioPermisoDAO;
import xeredi.argo.model.seguridad.vo.UsuarioPermisoCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioPermisoServiceImpl.
 */
@Transactional
public class UsuarioPermisoService {

	/** The uspr DAO. */
	private final UsuarioPermisoDAO usprDAO;

	/**
	 * Instantiates a new usuario permiso service.
	 *
	 * @param usprDAO
	 *            the uspr DAO
	 */
	@Inject
	public UsuarioPermisoService(final UsuarioPermisoDAO usprDAO) {
		super();
		this.usprDAO = usprDAO;
	}

	/**
	 * Checks for fncd.
	 *
	 * @param usroId
	 *            the usro id
	 * @param fncdId
	 *            the fncd id
	 * @return true, if successful
	 */
	public boolean hasFncd(@NonNull final Long usroId, @NonNull final Long fncdId) {
		final UsuarioPermisoCriterioVO usprCriterio = new UsuarioPermisoCriterioVO();

		usprCriterio.setUsroId(usroId);
		usprCriterio.setFncdId(fncdId);

		return usprDAO.exists(usprCriterio);
	}

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
	public boolean hasAcbs(@NonNull final Long usroId, @NonNull final String prefix, @NonNull final String codigo) {
		final UsuarioPermisoCriterioVO usprCriterio = new UsuarioPermisoCriterioVO();

		usprCriterio.setUsroId(usroId);
		usprCriterio.setAcbsPrefix(prefix);
		usprCriterio.setAcbsCodigo(codigo);

		return usprDAO.exists(usprCriterio);
	}

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
	public boolean hasAcen(@NonNull final Long usroId, @NonNull final String prefix, @NonNull final String codigo,
			@NonNull final Long entiId) {
		final UsuarioPermisoCriterioVO usprCriterio = new UsuarioPermisoCriterioVO();

		usprCriterio.setUsroId(usroId);
		usprCriterio.setAcenPrefix(prefix);
		usprCriterio.setAcenCodigo(codigo);
		usprCriterio.setEntiId(entiId);

		return usprDAO.exists(usprCriterio);
	}
}
