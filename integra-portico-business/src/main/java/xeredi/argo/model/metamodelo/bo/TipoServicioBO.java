package xeredi.argo.model.metamodelo.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import lombok.NonNull;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.metamodelo.dao.TipoServicioDAO;
import xeredi.argo.model.metamodelo.vo.TipoServicioCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioVO;
import xeredi.argo.model.util.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoServicioAdminBO.
 */
public final class TipoServicioBO {
	/**
	 * Select label values.
	 *
	 * @param criterioVO
	 *            the criterio vo
	 * @return the list
	 */
	public List<LabelValueVO> selectLabelValues(@NonNull final TipoServicioCriterioVO criterioVO) {
		final List<LabelValueVO> list = new ArrayList<>();

		for (final TipoServicioVO tpsr : selectList(criterioVO)) {
			list.add(new LabelValueVO(tpsr.getNombre(), tpsr.getId()));
		}

		return list;
	}

	/**
	 * Select list.
	 *
	 * @param tpsrCriterio
	 *            the tpsr criterio
	 * @return the list
	 */
	public List<TipoServicioVO> selectList(@NonNull final TipoServicioCriterioVO tpsrCriterio) {
		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final TipoServicioDAO tpsrDAO = session.getMapper(TipoServicioDAO.class);

			return tpsrDAO.selectList(tpsrCriterio);
		}
	}
}
