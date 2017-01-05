package xeredi.argo.model.metamodelo.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import lombok.NonNull;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.metamodelo.dao.TipoEstadisticaDAO;
import xeredi.argo.model.metamodelo.vo.TipoEstadisticaCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoEstadisticaVO;
import xeredi.argo.model.util.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoEstadisticaBO.
 */
public final class TipoEstadisticaBO {
	/**
	 * Select label values.
	 *
	 * @return the list
	 */
	public List<LabelValueVO> selectLabelValues() {
		final List<LabelValueVO> list = new ArrayList<>();

		for (final TipoEstadisticaVO tpes : selectList(new TipoEstadisticaCriterioVO())) {
			list.add(new LabelValueVO(tpes.getNombre(), tpes.getId()));
		}

		return list;
	}

	/**
	 * Select list.
	 *
	 * @param tpesCriterio
	 *            the tpes criterio
	 * @return the list
	 */
	public List<TipoEstadisticaVO> selectList(@NonNull final TipoEstadisticaCriterioVO tpesCriterio) {
		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final TipoEstadisticaDAO tpesDAO = session.getMapper(TipoEstadisticaDAO.class);

			return tpesDAO.selectList(tpesCriterio);
		}
	}
}
