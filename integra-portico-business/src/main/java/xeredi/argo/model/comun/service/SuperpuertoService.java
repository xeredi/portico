package xeredi.argo.model.comun.service;

import java.util.List;
import java.util.Map;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.SuperpuertoCriterioVO;
import xeredi.argo.model.comun.vo.SuperpuertoVO;
import xeredi.argo.model.util.PaginatedList;

public interface SuperpuertoService {
	/**
	 * Select object.
	 *
	 * @param id
	 *            the id
	 * @param idioma
	 *            the idioma
	 * @return the superpuerto vo
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public SuperpuertoVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException;

	/**
	 * Select object.
	 *
	 * @param sprtCriterio
	 *            the sprt criterio
	 * @return the superpuerto vo
	 */
	public SuperpuertoVO selectObject(@NonNull final SuperpuertoCriterioVO sprtCriterio);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	public List<SuperpuertoVO> selectList(@NonNull final SuperpuertoCriterioVO criterio);

	/**
	 * Select list.
	 *
	 * <img src="doc-files/SuperpuertoBO_selectList.png" alt="Sequence Diagram">
	 *
	 * @param criterio
	 *            the criterio
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	public PaginatedList<SuperpuertoVO> selectList(@NonNull final SuperpuertoCriterioVO criterio, final int offset,
			final int limit);

	/**
	 * Insert.
	 *
	 * @param sprt
	 *            the sprt
	 * @param i18nMap
	 *            the i18n map
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	public void insert(@NonNull final SuperpuertoVO sprt, @NonNull final Map<String, I18nVO> i18nMap)
			throws DuplicateInstanceException;

	/**
	 * Update.
	 *
	 * @param sprt
	 *            the sprt
	 * @param i18nMap
	 *            the i18n map
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void update(@NonNull final SuperpuertoVO sprt, @NonNull final Map<String, I18nVO> i18nMap)
			throws InstanceNotFoundException;

	/**
	 * Delete.
	 *
	 * @param sprt
	 *            the sprt
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void delete(@NonNull final SuperpuertoVO sprt) throws InstanceNotFoundException;
}
