package xeredi.argo.model.facturacion.service;

import java.util.Date;
import java.util.List;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.OverlapException;
import xeredi.argo.model.facturacion.vo.AspectoCargoCriterioVO;
import xeredi.argo.model.facturacion.vo.AspectoCargoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface AspectoCargoService.
 */
public interface AspectoCargoService {

	/**
	 * Select list.
	 *
	 * @param criterioVO
	 *            the criterio VO
	 * @return the list
	 */
	List<AspectoCargoVO> selectList(@NonNull final AspectoCargoCriterioVO criterioVO);

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @param fref
	 *            the fref
	 * @param idioma
	 *            the idioma
	 * @return the aspecto cargo VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	AspectoCargoVO select(@NonNull final Long id, @NonNull final Date fref, final String idioma)
			throws InstanceNotFoundException;

	/**
	 * Select object.
	 *
	 * @param ascrCriterio
	 *            the ascr criterio
	 * @return the aspecto cargo VO
	 */
	AspectoCargoVO selectObject(@NonNull final AspectoCargoCriterioVO ascrCriterio);

	/**
	 * Insert.
	 *
	 * @param ascr
	 *            the ascr
	 * @throws OverlapException
	 *             the overlap exception
	 */
	void insert(@NonNull final AspectoCargoVO ascr) throws OverlapException;

	/**
	 * Update.
	 *
	 * @param ascr
	 *            the ascr
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 * @throws OverlapException
	 *             the overlap exception
	 */
	void update(@NonNull final AspectoCargoVO ascr) throws InstanceNotFoundException, OverlapException;

	/**
	 * Delete.
	 *
	 * @param ascr
	 *            the ascr
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	void delete(@NonNull final AspectoCargoVO ascr) throws InstanceNotFoundException;
}
