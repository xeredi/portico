package xeredi.argo.model.facturacion.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.OverlapException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.facturacion.vo.AspectoCriterioVO;
import xeredi.argo.model.facturacion.vo.AspectoVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Interface AspectoService.
 */
public interface AspectoService {

	/**
	 * Select list.
	 *
	 * @param aspcCriterioVO
	 *            the aspc criterio VO
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	PaginatedList<AspectoVO> selectList(@NonNull final AspectoCriterioVO aspcCriterioVO, final int offset,
			final int limit);

	/**
	 * Select list.
	 *
	 * @param aspcCriterioVO
	 *            the aspc criterio VO
	 * @return the list
	 */
	List<AspectoVO> selectList(@NonNull final AspectoCriterioVO aspcCriterioVO);

	/**
	 * Select typeahead list.
	 *
	 * @param criterio
	 *            the criterio
	 * @param limit
	 *            the limit
	 * @return the list
	 */
	List<AspectoVO> selectTypeaheadList(@NonNull final AspectoCriterioVO criterio, final int limit);

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @param fref
	 *            the fref
	 * @param idioma
	 *            the idioma
	 * @return the aspecto VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	AspectoVO select(@NonNull final Long id, @NonNull final Date fref, final String idioma)
			throws InstanceNotFoundException;

	/**
	 * Select object.
	 *
	 * @param aspcCriterio
	 *            the aspc criterio
	 * @return the aspecto VO
	 */
	AspectoVO selectObject(@NonNull final AspectoCriterioVO aspcCriterio);

	/**
	 * Insert.
	 *
	 * @param aspc
	 *            the aspc
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws OverlapException
	 *             the overlap exception
	 */
	void insert(@NonNull final AspectoVO aspc, @NonNull final Map<String, I18nVO> i18nMap) throws OverlapException;

	/**
	 * Duplicate.
	 *
	 * @param aspc
	 *            the aspc
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	void duplicate(@NonNull final AspectoVO aspc, @NonNull final Map<String, I18nVO> i18nMap)
			throws DuplicateInstanceException;

	/**
	 * Update.
	 *
	 * @param aspc
	 *            the aspc
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 * @throws OverlapException
	 *             the overlap exception
	 */
	void update(@NonNull final AspectoVO aspc, @NonNull final Map<String, I18nVO> i18nMap)
			throws InstanceNotFoundException, OverlapException;

	/**
	 * Delete.
	 *
	 * @param aspc
	 *            the aspc
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	void delete(@NonNull final AspectoVO aspc) throws InstanceNotFoundException;

}
