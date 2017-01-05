package xeredi.argo.model.metamodelo.service;

import java.util.List;
import java.util.Map;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.metamodelo.vo.ModuloCriterioVO;
import xeredi.argo.model.metamodelo.vo.ModuloVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Interface ModuloService.
 */
public interface ModuloService {
	/**
	 * Insert.
	 *
	 * @param mdlo
	 *            the mdlo
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	public void insert(@NonNull final ModuloVO mdlo, @NonNull final Map<String, I18nVO> i18nMap)
			throws DuplicateInstanceException;

	/**
	 * Update.
	 *
	 * @param mdlo
	 *            the mdlo
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void update(@NonNull final ModuloVO mdlo, @NonNull final Map<String, I18nVO> i18nMap)
			throws InstanceNotFoundException;

	/**
	 * Delete.
	 *
	 * @param mdlo
	 *            the mdlo
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void delete(@NonNull final ModuloVO mdlo) throws InstanceNotFoundException;

	/**
	 * Select list.
	 *
	 * @param mdloCriterio
	 *            the mdlo criterio
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	public PaginatedList<ModuloVO> selectList(@NonNull final ModuloCriterioVO mdloCriterio, final int offset,
			final int limit);

	/**
	 * Select list.
	 *
	 * @param mdloCriterio
	 *            the mdlo criterio
	 * @return the list
	 */
	public List<ModuloVO> selectList(@NonNull final ModuloCriterioVO mdloCriterio);

	/**
	 * Select object.
	 *
	 * @param mdloCriterio
	 *            the mdlo criterio
	 * @return the modulo VO
	 */
	public ModuloVO selectObject(@NonNull final ModuloCriterioVO mdloCriterio);

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @param idioma
	 *            the idioma
	 * @return the modulo VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public ModuloVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException;
}
