package xeredi.argo.model.metamodelo.bo;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import lombok.NonNull;
import xeredi.argo.model.metamodelo.dao.TramiteTipoDatoDAO;
import xeredi.argo.model.metamodelo.vo.TramiteTipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.TramiteTipoDatoVO;
import xeredi.argo.model.util.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class TramiteTipoDatoBO.
 */
public final class TramiteTipoDatoBO {

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	public List<TramiteTipoDatoVO> selectList(@NonNull final TramiteTipoDatoCriterioVO criterio) {
		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final TramiteTipoDatoDAO trtdDAO = session.getMapper(TramiteTipoDatoDAO.class);

			return trtdDAO.selectList(criterio);
		}
	}
}
