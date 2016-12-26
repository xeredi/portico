package xeredi.argo.model.seguridad.service;

import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import lombok.NonNull;
import xeredi.argo.model.seguridad.dao.UsuarioPermisoDAO;
import xeredi.argo.model.seguridad.vo.UsuarioPermisoCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioPermisoServiceImpl.
 */
@Singleton
@Transactional
public class UsuarioPermisoServiceImpl implements UsuarioPermisoService {

	/** The uspr DAO. */
	@Inject
	private UsuarioPermisoDAO usprDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasFncd(@NonNull final Long usroId, @NonNull final Long fncdId) {
		final UsuarioPermisoCriterioVO usprCriterio = new UsuarioPermisoCriterioVO();

		usprCriterio.setUsroId(usroId);
		usprCriterio.setFncdId(fncdId);

		return usprDAO.exists(usprCriterio);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasAcbs(@NonNull final Long usroId, @NonNull final String prefix, @NonNull final String codigo) {
		final UsuarioPermisoCriterioVO usprCriterio = new UsuarioPermisoCriterioVO();

		usprCriterio.setUsroId(usroId);
		usprCriterio.setAcbsPrefix(prefix);
		usprCriterio.setAcbsCodigo(codigo);

		return usprDAO.exists(usprCriterio);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
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
