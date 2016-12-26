package xeredi.argo.model.metamodelo.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import lombok.NonNull;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.metamodelo.dao.TipoParametroDAO;
import xeredi.argo.model.metamodelo.vo.TipoParametroCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoParametroVO;
import xeredi.argo.model.util.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroAdminBO.
 */
public final class TipoParametroBO {
	/**
	 * Select label values.
	 *
	 * @return the list
	 */
	public List<LabelValueVO> selectLabelValues() {
		final List<LabelValueVO> list = new ArrayList<>();

		for (final TipoParametroVO tppr : selectList(new TipoParametroCriterioVO())) {
			list.add(new LabelValueVO(tppr.getNombre(), tppr.getId()));
		}

		return list;
	}

	/**
	 * Select list.
	 *
	 * @param tpprCriterioVO
	 *            the tppr criterio vo
	 * @return the list
	 */
	public List<TipoParametroVO> selectList(@NonNull final TipoParametroCriterioVO tpprCriterioVO) {
		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final TipoParametroDAO tpprDAO = session.getMapper(TipoParametroDAO.class);

			return tpprDAO.selectList(tpprCriterioVO);
		}
	}

}
