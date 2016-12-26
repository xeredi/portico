package xeredi.argo.model.metamodelo.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import lombok.NonNull;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.metamodelo.dao.EntidadDAO;
import xeredi.argo.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadVO;
import xeredi.argo.model.util.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadAdminBO.
 */
public final class EntidadBO {

	/**
	 * Select list.
	 *
	 * @param entiCriterio
	 *            the enti criterio vo
	 * @return the list
	 */
	public List<EntidadVO> selectList(@NonNull final EntidadCriterioVO entiCriterio) {
		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final EntidadDAO entiDAO = session.getMapper(EntidadDAO.class);

			return entiDAO.selectList(entiCriterio);
		}
	}

	/**
	 * Select label values.
	 *
	 * @param entiCriterio
	 *            the enti criterio vo
	 * @return the list
	 */
	public List<LabelValueVO> selectLabelValues(@NonNull final EntidadCriterioVO entiCriterio) {
		final List<LabelValueVO> list = new ArrayList<>();

		for (final EntidadVO enti : selectList(entiCriterio)) {
			list.add(new LabelValueVO(enti.getNombre(), enti.getId()));
		}

		return list;
	}
}
