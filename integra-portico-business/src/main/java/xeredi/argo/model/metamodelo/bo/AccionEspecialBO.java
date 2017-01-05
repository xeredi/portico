package xeredi.argo.model.metamodelo.bo;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import lombok.NonNull;
import xeredi.argo.model.metamodelo.dao.AccionEspecialDAO;
import xeredi.argo.model.metamodelo.vo.AccionEspecialCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionEspecialVO;
import xeredi.argo.model.util.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionEspecialBO.
 */
public final class AccionEspecialBO {

	/**
	 * Select list.
	 *
	 * @param acesCriterio
	 *            the aces criterio
	 * @return the list
	 */
	public List<AccionEspecialVO> selectList(@NonNull final AccionEspecialCriterioVO acesCriterio) {
		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final AccionEspecialDAO acesDAO = session.getMapper(AccionEspecialDAO.class);

			return acesDAO.selectList(acesCriterio);
		}
	}

}
