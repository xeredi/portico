package xeredi.argo.model.metamodelo.bo;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import lombok.NonNull;
import xeredi.argo.model.metamodelo.dao.AccionEntidadBaseDAO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadBaseCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadBaseVO;
import xeredi.argo.model.util.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionEntidadBaseBO.
 */
public final class AccionEntidadBaseBO {
	/**
	 * Select list.
	 *
	 * @param aebsCriterio
	 *            the aebs criterio
	 * @return the list
	 */
	public List<AccionEntidadBaseVO> selectList(@NonNull final AccionEntidadBaseCriterioVO aebsCriterio) {
		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final AccionEntidadBaseDAO aebsDAO = session.getMapper(AccionEntidadBaseDAO.class);

			return aebsDAO.selectList(aebsCriterio);
		}
	}
}
