package xeredi.argo.model.metamodelo.service;

import java.util.List;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.metamodelo.vo.AccionBaseCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionBaseVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Interface AccionBaseService.
 */
public interface AccionBaseService {

	/**
	 * Insert.
	 *
	 * @param acbs
	 *            the acbs
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	void insert(@NonNull final AccionBaseVO acbs) throws DuplicateInstanceException;

	/**
	 * Update.
	 *
	 * @param acbs
	 *            the acbs
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	void update(@NonNull final AccionBaseVO acbs) throws InstanceNotFoundException;

	/**
	 * Delete.
	 *
	 * @param acbs
	 *            the acbs
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	void delete(@NonNull final AccionBaseVO acbs) throws InstanceNotFoundException;

	/**
	 * Select list.
	 *
	 * @param acbsCriterio
	 *            the acbs criterio
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	PaginatedList<AccionBaseVO> selectList(@NonNull final AccionBaseCriterioVO acbsCriterio, final int offset,
			final int limit);

	/**
	 * Select list.
	 *
	 * @param acbsCriterio
	 *            the acbs criterio
	 * @return the list
	 */
	List<AccionBaseVO> selectList(@NonNull final AccionBaseCriterioVO acbsCriterio);

	/**
	 * Select object.
	 *
	 * @param acbsCriterio
	 *            the acbs criterio
	 * @return the accion base VO
	 */
	AccionBaseVO selectObject(@NonNull final AccionBaseCriterioVO acbsCriterio);

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @return the accion base VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	AccionBaseVO select(@NonNull final Long id) throws InstanceNotFoundException;
}
