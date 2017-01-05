package xeredi.argo.model.metamodelo.bo;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.argo.model.metamodelo.dao.CampoAgregacionDAO;
import xeredi.argo.model.metamodelo.vo.CampoAgregacionCriterioVO;
import xeredi.argo.model.metamodelo.vo.CampoAgregacionVO;
import xeredi.argo.model.util.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class CampoAgregacionBO.
 */
public final class CampoAgregacionBO {
	/**
	 * Select list.
	 *
	 * @param criterioVO
	 *            the criterio vo
	 * @return the list
	 */
	public List<CampoAgregacionVO> selectList(final CampoAgregacionCriterioVO criterioVO) {
		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final CampoAgregacionDAO cmapDAO = session.getMapper(CampoAgregacionDAO.class);

			return cmapDAO.selectList(criterioVO);
		}
	}

}
