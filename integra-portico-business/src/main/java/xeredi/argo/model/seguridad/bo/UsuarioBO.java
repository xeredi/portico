package xeredi.argo.model.seguridad.bo;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.seguridad.dao.UsuarioDAO;
import xeredi.argo.model.seguridad.vo.UsuarioCriterioVO;
import xeredi.argo.model.seguridad.vo.UsuarioVO;
import xeredi.argo.model.util.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioBO.
 */
public final class UsuarioBO {
	/**
	 * Select object.
	 *
	 * @param usroCriterio
	 *            the usro criterio
	 * @return the usuario vo
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public UsuarioVO selectObject(@NonNull final UsuarioCriterioVO usroCriterio) throws InstanceNotFoundException {
		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final UsuarioDAO usroDAO = session.getMapper(UsuarioDAO.class);

			final UsuarioVO usro = usroDAO.selectObject(usroCriterio);

			if (usro == null) {
				throw new InstanceNotFoundException(MessageI18nKey.usro, usroCriterio);
			}

			return usro;
		}
	}
}
