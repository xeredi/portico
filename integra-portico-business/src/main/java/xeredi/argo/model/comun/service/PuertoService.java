package xeredi.argo.model.comun.service;

import java.util.List;
import java.util.Map;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.util.PaginatedList;

public interface PuertoService {
	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @param idioma
	 *            the idioma
	 * @return the puerto vo
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public PuertoVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException;

	/**
	 * Select object.
	 *
	 * @param prtoCriterio
	 *            the prto criterio
	 * @return the puerto vo
	 */
	public PuertoVO selectObject(@NonNull final PuertoCriterioVO prtoCriterio);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	public List<PuertoVO> selectList(@NonNull final PuertoCriterioVO criterio);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	public PaginatedList<PuertoVO> selectList(@NonNull final PuertoCriterioVO criterio, final int offset,
			final int limit);

	/**
	 * Insert.
	 *
	 * @param prto
	 *            the prto
	 * @param i18nMap
	 *            the i18n map
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	public void insert(@NonNull final PuertoVO prto, @NonNull final Map<String, I18nVO> i18nMap)
			throws DuplicateInstanceException;

	/**
	 * Update.
	 *
	 * @param prto
	 *            the prto
	 * @param i18nMap
	 *            the i18n map
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void update(@NonNull final PuertoVO prto, @NonNull final Map<String, I18nVO> i18nMap)
			throws InstanceNotFoundException;

	/**
	 * Delette.
	 *
	 * @param prto
	 *            the prto
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	void delete(@NonNull final PuertoVO prto) throws InstanceNotFoundException;

}
