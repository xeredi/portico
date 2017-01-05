package xeredi.argo.model.facturacion.service;

import java.util.Date;
import java.util.List;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.OverlapException;
import xeredi.argo.model.facturacion.vo.ReglaIncompatibleCriterioVO;
import xeredi.argo.model.facturacion.vo.ReglaIncompatibleVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ReglaIncompatibleService.
 */
public interface ReglaIncompatibleService {
	/**
	 * Insert.
	 *
	 * @param rgin
	 *            the rgin
	 * @throws OverlapException
	 *             the overlap exception
	 */
	void insert(@NonNull final ReglaIncompatibleVO rgin) throws OverlapException;

	/**
	 * Update.
	 *
	 * @param rgin
	 *            the rgin
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 * @throws OverlapException
	 *             the overlap exception
	 */
	void update(@NonNull final ReglaIncompatibleVO rgin) throws InstanceNotFoundException, OverlapException;

	/**
	 * Delete.
	 *
	 * @param rgin
	 *            the rgin
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	void delete(@NonNull final ReglaIncompatibleVO rgin) throws InstanceNotFoundException;

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @param fref
	 *            the fref
	 * @return the regla incompatible VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	ReglaIncompatibleVO select(@NonNull final Long id, @NonNull final Date fref) throws InstanceNotFoundException;

	/**
	 * Select object.
	 *
	 * @param rginCriterio
	 *            the rgin criterio
	 * @return the regla incompatible VO
	 */
	ReglaIncompatibleVO selectObject(@NonNull final ReglaIncompatibleCriterioVO rginCriterio);

	/**
	 * Select list.
	 *
	 * @param rginCriterio
	 *            the rgin criterio
	 * @return the list
	 */
	List<ReglaIncompatibleVO> selectList(@NonNull final ReglaIncompatibleCriterioVO rginCriterio);
}
