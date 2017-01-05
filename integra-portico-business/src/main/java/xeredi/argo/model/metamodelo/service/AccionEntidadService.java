package xeredi.argo.model.metamodelo.service;

import java.util.List;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.metamodelo.vo.AccionEntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface AccionEntidadService.
 */
public interface AccionEntidadService {

	/**
	 * Insert.
	 *
	 * @param acen
	 *            the acen
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	public void insert(@NonNull final AccionEntidadVO acen) throws DuplicateInstanceException;

	/**
	 * Update.
	 *
	 * @param acen
	 *            the acen
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void update(@NonNull final AccionEntidadVO acen) throws InstanceNotFoundException;

	/**
	 * Delete.
	 *
	 * @param acen
	 *            the acen
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void delete(@NonNull final AccionEntidadVO acen) throws InstanceNotFoundException;

	/**
	 * Select list.
	 *
	 * @param acenCriterio
	 *            the acen criterio
	 * @return the list
	 */
	public List<AccionEntidadVO> selectList(@NonNull final AccionEntidadCriterioVO acenCriterio);

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @param idioma
	 *            the idioma
	 * @return the accion entidad VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public AccionEntidadVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException;

	/**
	 * Select object.
	 *
	 * @param acenCriterio
	 *            the acen criterio
	 * @return the accion entidad VO
	 */
	public AccionEntidadVO selectObject(@NonNull final AccionEntidadCriterioVO acenCriterio);
}
