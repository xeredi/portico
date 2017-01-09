package xeredi.argo.model.metamodelo.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import lombok.NonNull;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.metamodelo.dao.TipoSubparametroDAO;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroVO;
import xeredi.argo.model.util.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubparametroBO.
 */
public final class TipoSubparametroBO {
	/**
	 * Select label values.
	 *
	 * @return the list
	 */
	public List<LabelValueVO> selectLabelValues() {
		final List<LabelValueVO> list = new ArrayList<>();

		for (final TipoSubparametroVO tpsp : selectList(new TipoSubparametroCriterioVO())) {
			list.add(new LabelValueVO(tpsp.getNombre(), tpsp.getId()));
		}

		return list;
	}

	/**
	 * Select list.
	 *
	 * @param tpspCriterioVO
	 *            the tpsp criterio vo
	 * @return the list
	 */
	public List<TipoSubparametroVO> selectList(@NonNull final TipoSubparametroCriterioVO tpspCriterioVO) {
		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final TipoSubparametroDAO tpspDAO = session.getMapper(TipoSubparametroDAO.class);

			return tpspDAO.selectList(tpspCriterioVO);
		}
	}
}
