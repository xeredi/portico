package xeredi.argo.model.metamodelo.bo;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.argo.model.metamodelo.dao.EntidadTipoDatoDAO;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.argo.model.util.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadTipoDatoAdminBO.
 */
public final class EntidadTipoDatoBO {

	/**
	 * Select list.
	 *
	 * @param entdCriterio
	 *            the entd criterio
	 * @return the list
	 */
	public List<EntidadTipoDatoVO> selectList(final EntidadTipoDatoCriterioVO entdCriterio) {
		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final EntidadTipoDatoDAO entdDAO = session.getMapper(EntidadTipoDatoDAO.class);

			return entdDAO.selectList(entdCriterio);
		}
	}
}
