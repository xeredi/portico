package xeredi.argo.model.estadistica.service;

import java.util.List;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.estadistica.vo.EstadisticaCriterioVO;
import xeredi.argo.model.estadistica.vo.EstadisticaVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Interface EstadisticaService.
 */
public interface EstadisticaService {

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
	PaginatedList<EstadisticaVO> selectList(@NonNull final EstadisticaCriterioVO estdCriterioVO, final int offset,
			final int limit);

	/**
	 * Select list.
	 *
	 * @param estdCriterioVO
	 *            the estd criterio VO
	 * @return the list
	 */
	List<EstadisticaVO> selectList(@NonNull final EstadisticaCriterioVO estdCriterioVO);

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
	EstadisticaVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException;

	/**
	 * Select object.
	 *
	 * @param estdCriterio
	 *            the estd criterio
	 * @return the estadistica VO
	 */
	EstadisticaVO selectObject(@NonNull final EstadisticaCriterioVO estdCriterio);
}
