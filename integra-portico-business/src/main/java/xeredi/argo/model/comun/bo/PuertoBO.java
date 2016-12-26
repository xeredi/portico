package xeredi.argo.model.comun.bo;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import lombok.NonNull;
import xeredi.argo.model.comun.dao.PuertoDAO;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.util.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class PuertoBO.
 */
public final class PuertoBO {
	/**
	 * Select object.
	 *
	 * @param prtoCriterio
	 *            the prto criterio
	 * @return the puerto vo
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public PuertoVO selectObject(@NonNull final PuertoCriterioVO prtoCriterio) throws InstanceNotFoundException {
		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final PuertoDAO prtoDAO = session.getMapper(PuertoDAO.class);
			final PuertoVO prto = prtoDAO.selectObject(prtoCriterio);

			if (prto == null) {
				throw new InstanceNotFoundException(MessageI18nKey.prto, prtoCriterio);
			}

			return prto;
		}
	}

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	public List<PuertoVO> selectList(@NonNull final PuertoCriterioVO criterio) {
		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final PuertoDAO prtoDAO = session.getMapper(PuertoDAO.class);

			return prtoDAO.selectList(criterio);
		}
	}
}
