package xeredi.argo.model.metamodelo.bo;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.argo.model.metamodelo.dao.EntidadGrupoDatoDAO;
import xeredi.argo.model.metamodelo.vo.EntidadGrupoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadGrupoDatoVO;
import xeredi.argo.model.util.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadGrupoDatoBO.
 */
public final class EntidadGrupoDatoBO {
	/**
	 * Select list.
	 *
	 * @param engdCriterio
	 *            the engd criterio
	 * @return the list
	 */
	public List<EntidadGrupoDatoVO> selectList(final EntidadGrupoDatoCriterioVO engdCriterio) {
		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final EntidadGrupoDatoDAO engdDAO = session.getMapper(EntidadGrupoDatoDAO.class);

			return engdDAO.selectList(engdCriterio);
		}
	}
}
