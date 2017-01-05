package xeredi.argo.model.metamodelo.bo;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import lombok.NonNull;
import xeredi.argo.model.metamodelo.dao.AccionEntidadDAO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadVO;
import xeredi.argo.model.util.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionEntidadBO.
 */
public final class AccionEntidadBO {
	/**
	 * Select list.
	 *
	 * @param acenCriterio
	 *            the acen criterio
	 * @return the list
	 */
	public List<AccionEntidadVO> selectList(@NonNull final AccionEntidadCriterioVO acenCriterio) {
		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final AccionEntidadDAO acenDAO = session.getMapper(AccionEntidadDAO.class);

			return acenDAO.selectList(acenCriterio);
		}
	}
}
