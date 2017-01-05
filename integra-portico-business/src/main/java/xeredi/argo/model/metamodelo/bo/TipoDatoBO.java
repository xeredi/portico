package xeredi.argo.model.metamodelo.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import lombok.NonNull;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.metamodelo.dao.CodigoReferenciaDAO;
import xeredi.argo.model.metamodelo.dao.TipoDatoDAO;
import xeredi.argo.model.metamodelo.vo.CodigoReferenciaCriterioVO;
import xeredi.argo.model.metamodelo.vo.CodigoReferenciaVO;
import xeredi.argo.model.metamodelo.vo.TipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoDatoVO;
import xeredi.argo.model.util.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoDatoAdminBO.
 */
public final class TipoDatoBO {
	/**
	 * Select list.
	 *
	 * @param tpdtCriterio
	 *            the tpdt criterio
	 * @return the list
	 */
	public List<TipoDatoVO> selectList(@NonNull final TipoDatoCriterioVO tpdtCriterio) {
		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final TipoDatoDAO tpdtDAO = session.getMapper(TipoDatoDAO.class);

			return tpdtDAO.selectList(tpdtCriterio);
		}
	}

	/**
	 * Select label values.
	 *
	 * @param tpdtCriterio
	 *            the tpdt criterio
	 * @return the list
	 */
	public List<LabelValueVO> selectLabelValues(@NonNull final TipoDatoCriterioVO tpdtCriterio) {
		final List<LabelValueVO> list = new ArrayList<>();

		for (final TipoDatoVO tpdt : selectList(tpdtCriterio)) {
			list.add(new LabelValueVO(tpdt.getNombre(), tpdt.getId()));
		}

		return list;
	}

	/**
	 * Select map.
	 *
	 * @param tpdtCriterio
	 *            the tpdt criterio
	 * @return the map
	 */
	public Map<Long, TipoDatoVO> selectMap(@NonNull final TipoDatoCriterioVO tpdtCriterio) {
		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final TipoDatoDAO tpdtDAO = session.getMapper(TipoDatoDAO.class);
			final CodigoReferenciaDAO cdrfDAO = session.getMapper(CodigoReferenciaDAO.class);

			final Map<Long, TipoDatoVO> tpdtMap = tpdtDAO.selectMap(tpdtCriterio);
			final Map<Long, List<CodigoReferenciaVO>> cdrfMap = new HashMap<>();

			for (final CodigoReferenciaVO cdrf : cdrfDAO.selectList(new CodigoReferenciaCriterioVO())) {
				if (!cdrfMap.containsKey(cdrf.getTpdtId())) {
					cdrfMap.put(cdrf.getTpdtId(), new ArrayList<CodigoReferenciaVO>());
				}

				cdrfMap.get(cdrf.getTpdtId()).add(cdrf);

				cdrf.setTpdtId(null);
				cdrf.setOrden(null);
			}

			for (final TipoDatoVO tpdt : tpdtMap.values()) {
				if (cdrfMap.containsKey(tpdt.getId())) {
					tpdt.setCdrfList(cdrfMap.get(tpdt.getId()));

					final Set<String> cdrfCodeSet = new HashSet<>();

					for (final CodigoReferenciaVO cdrf : cdrfMap.get(tpdt.getId())) {
						cdrfCodeSet.add(cdrf.getValor());
					}

					tpdt.setCdrfCodeSet(cdrfCodeSet);
				}

				tpdtMap.put(tpdt.getId(), tpdt);
			}

			return tpdtMap;
		}
	}
}
