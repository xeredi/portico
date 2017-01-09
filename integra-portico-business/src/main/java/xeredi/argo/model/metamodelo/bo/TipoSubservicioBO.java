package xeredi.argo.model.metamodelo.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import lombok.NonNull;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.metamodelo.dao.TipoSubservicioDAO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.argo.model.util.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubservicioAdminBO.
 */
public final class TipoSubservicioBO {

	/**
	 * Select label values.
	 *
	 * @param tpssCriterio
	 *            the tpss criterio
	 * @return the list
	 */
	public List<LabelValueVO> selectLabelValues(@NonNull final TipoSubservicioCriterioVO tpssCriterio) {
		final List<LabelValueVO> list = new ArrayList<>();

		for (final TipoSubservicioVO tpss : selectList(tpssCriterio)) {
			list.add(new LabelValueVO(tpss.getNombre(), tpss.getId()));
		}

		return list;
	}

	/**
	 * Select list.
	 *
	 * @param tpssCriterio
	 *            the tpss criterio
	 * @return the list
	 */
	public List<TipoSubservicioVO> selectList(@NonNull final TipoSubservicioCriterioVO tpssCriterio) {
		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final TipoSubservicioDAO tpssDAO = session.getMapper(TipoSubservicioDAO.class);

			return tpssDAO.selectList(tpssCriterio);
		}
	}
}
