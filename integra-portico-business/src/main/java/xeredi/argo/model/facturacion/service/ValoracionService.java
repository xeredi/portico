package xeredi.argo.model.facturacion.service;

import java.util.List;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Interface ValoracionService.
 */
public interface ValoracionService {

	/**
	 * Insert.
	 *
	 * @param vlrc
	 *            the vlrc
	 */
	void insert(@NonNull final ValoracionVO vlrc);

	/**
	 * Update.
	 *
	 * @param vlrc
	 *            the vlrc
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	void update(@NonNull final ValoracionVO vlrc) throws InstanceNotFoundException;

	/**
	 * Delete.
	 *
	 * @param id
	 *            the id
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	void delete(@NonNull final Long id) throws InstanceNotFoundException;

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @param idioma
	 *            the idioma
	 * @return the valoracion VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	ValoracionVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException;

	/**
	 * Select list.
	 *
	 * @param vlrcCriterioVO
	 *            the vlrc criterio VO
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	PaginatedList<ValoracionVO> selectList(@NonNull final ValoracionCriterioVO vlrcCriterioVO, final int offset,
			final int limit);

	/**
	 * Select list.
	 *
	 * @param vlrcCriterioVO
	 *            the vlrc criterio VO
	 * @return the list
	 */
	List<ValoracionVO> selectList(@NonNull final ValoracionCriterioVO vlrcCriterioVO);
}
