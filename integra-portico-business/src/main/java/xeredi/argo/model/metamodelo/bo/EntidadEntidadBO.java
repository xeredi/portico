package xeredi.argo.model.metamodelo.bo;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.argo.model.metamodelo.dao.EntidadEntidadDAO;
import xeredi.argo.model.metamodelo.vo.EntidadEntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadEntidadVO;
import xeredi.argo.model.util.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadEntidadAdminBO.
 */
public final class EntidadEntidadBO {
	/**
	 * Select list.
	 *
	 * @param enenCriterioVO
	 *            the enen criterio vo
	 * @return the list
	 */
	public List<EntidadEntidadVO> selectList(final EntidadEntidadCriterioVO enenCriterioVO) {
		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final EntidadEntidadDAO enenDAO = session.getMapper(EntidadEntidadDAO.class);

			return enenDAO.selectList(enenCriterioVO);
		}
	}
}
