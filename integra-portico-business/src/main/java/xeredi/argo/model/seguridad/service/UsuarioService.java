package xeredi.argo.model.seguridad.service;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.seguridad.vo.UsuarioCriterioVO;
import xeredi.argo.model.seguridad.vo.UsuarioVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Interface UsuarioService.
 */
public interface UsuarioService {

	/**
	 * Insert.
	 *
	 * @param usro
	 *            the usro
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	void insert(@NonNull final UsuarioVO usro) throws DuplicateInstanceException;

	/**
	 * Update.
	 *
	 * @param usro
	 *            the usro
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	void update(@NonNull final UsuarioVO usro) throws InstanceNotFoundException;

	/**
	 * Delete.
	 *
	 * @param usro
	 *            the usro
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	void delete(@NonNull final UsuarioVO usro) throws InstanceNotFoundException;

	/**
	 * Select list.
	 *
	 * @param usroCriterio
	 *            the usro criterio
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	PaginatedList<UsuarioVO> selectList(@NonNull final UsuarioCriterioVO usroCriterio, final int offset,
			final int limit);

	/**
	 * Select object.
	 *
	 * @param usroCriterio
	 *            the usro criterio
	 * @return the usuario VO
	 */
	UsuarioVO selectObject(@NonNull final UsuarioCriterioVO usroCriterio);

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @param idioma
	 *            the idioma
	 * @return the usuario VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	UsuarioVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException;
}
