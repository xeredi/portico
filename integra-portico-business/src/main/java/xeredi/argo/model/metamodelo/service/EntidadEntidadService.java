package xeredi.argo.model.metamodelo.service;

import java.util.List;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.metamodelo.vo.EntidadEntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadEntidadVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface EntidadEntidadService.
 */
public interface EntidadEntidadService {

	/**
	 * Insert.
	 *
	 * @param enenVO
	 *            the enen VO
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	public void insert(@NonNull final EntidadEntidadVO enenVO) throws DuplicateInstanceException;

	/**
	 * Update.
	 *
	 * @param enenVO
	 *            the enen VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void update(@NonNull final EntidadEntidadVO enenVO) throws InstanceNotFoundException;

	/**
	 * Delete.
	 *
	 * @param enenVO
	 *            the enen VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void delete(@NonNull final EntidadEntidadVO enenVO) throws InstanceNotFoundException;

	/**
	 * Select list.
	 *
	 * @param enenCriterioVO
	 *            the enen criterio VO
	 * @return the list
	 */
	public List<EntidadEntidadVO> selectList(@NonNull final EntidadEntidadCriterioVO enenCriterioVO);

	/**
	 * Select.
	 *
	 * @param entipId
	 *            the entip id
	 * @param entihId
	 *            the entih id
	 * @return the entidad entidad VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public EntidadEntidadVO select(@NonNull final Long entipId, @NonNull final Long entihId)
			throws InstanceNotFoundException;

	/**
	 * Select object.
	 *
	 * @param enenCriterioVO
	 *            the enen criterio VO
	 * @return the entidad entidad VO
	 */
	public EntidadEntidadVO selectObject(@NonNull final EntidadEntidadCriterioVO enenCriterioVO);
}
