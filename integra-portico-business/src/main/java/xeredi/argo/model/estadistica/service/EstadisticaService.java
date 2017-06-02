package xeredi.argo.model.estadistica.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.estadistica.dao.EstadisticaDAO;
import xeredi.argo.model.estadistica.dao.EstadisticaDatoDAO;
import xeredi.argo.model.estadistica.vo.EstadisticaCriterioVO;
import xeredi.argo.model.estadistica.vo.EstadisticaVO;
import xeredi.argo.model.item.vo.ItemDatoVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticaServiceImpl.
 */
@Singleton
@Transactional
public class EstadisticaService {

	/** The estd DAO. */
	@Inject
	private EstadisticaDAO estdDAO;

	/** The esdt DAO. */
	@Inject
	private EstadisticaDatoDAO esdtDAO;

	/**
	 * Select list.
	 *
	 * @param estdCriterioVO
	 *            the estd criterio VO
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	public PaginatedList<EstadisticaVO> selectList(EstadisticaCriterioVO estdCriterioVO, int offset, int limit) {
		final int count = estdDAO.count(estdCriterioVO);
		final List<EstadisticaVO> estdList = new ArrayList<>();

		if (count > offset) {
			estdList.addAll(estdDAO.selectList(estdCriterioVO, new RowBounds(offset, limit)));

			fillDependencies(estdList, estdCriterioVO, true);
		}

		return new PaginatedList<>(estdList, offset, limit, count);
	}

	/**
	 * Select list.
	 *
	 * @param estdCriterioVO
	 *            the estd criterio VO
	 * @return the list
	 */
	public List<EstadisticaVO> selectList(EstadisticaCriterioVO estdCriterioVO) {
		final List<EstadisticaVO> estdList = estdDAO.selectList(estdCriterioVO);

		fillDependencies(estdList, estdCriterioVO, false);

		return estdList;
	}

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @param idioma
	 *            the idioma
	 * @return the estadistica VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public EstadisticaVO select(Long id, String idioma) throws InstanceNotFoundException {
		final EstadisticaCriterioVO estdCriterio = new EstadisticaCriterioVO();

		estdCriterio.setId(id);
		estdCriterio.setIdioma(idioma);

		final EstadisticaVO estd = selectObject(estdCriterio);

		if (estd == null) {
			throw new InstanceNotFoundException(MessageI18nKey.estd, id);
		}

		return estd;
	}

	/**
	 * Select object.
	 *
	 * @param estdCriterio
	 *            the estd criterio
	 * @return the estadistica VO
	 */
	public EstadisticaVO selectObject(EstadisticaCriterioVO estdCriterio) {
		final EstadisticaVO estd = estdDAO.selectObject(estdCriterio);

		if (estd != null) {
			fillDependencies(Arrays.asList(new EstadisticaVO[] { estd }), estdCriterio, true);
		}

		return estd;
	}

	/**
	 * Fill dependencies.
	 *
	 * @param estdList
	 *            the estd list
	 * @param estdCriterio
	 *            the estd criterio
	 * @param useIds
	 *            the use ids
	 */
	private void fillDependencies(@NonNull final List<EstadisticaVO> estdList,
			@NonNull final EstadisticaCriterioVO estdCriterio, final boolean useIds) {
		if (!estdList.isEmpty()) {
			if (useIds) {
				final Set<Long> ids = new HashSet<>();

				for (final EstadisticaVO estd : estdList) {
					ids.add(estd.getId());
				}

				estdCriterio.setIds(ids);
			}

			final Map<Long, Map<Long, ItemDatoVO>> itdtMap = new HashMap<>();

			for (final ItemDatoVO itdt : esdtDAO.selectList(estdCriterio)) {
				if (!itdtMap.containsKey(itdt.getItemId())) {
					itdtMap.put(itdt.getItemId(), new HashMap<Long, ItemDatoVO>());
				}

				itdtMap.get(itdt.getItemId()).put(itdt.getTpdtId(), itdt);

				itdt.setItemId(null);
				itdt.setTpdtId(null);
			}

			for (final EstadisticaVO estd : estdList) {
				estd.setItdtMap(itdtMap.get(estd.getId()));
			}

			if (useIds) {
				estdCriterio.setIds(null);
			}
		}
	}
}
