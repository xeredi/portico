package xeredi.argo.model.facturacion.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.OverlapException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.facturacion.vo.ReglaCriterioVO;
import xeredi.argo.model.facturacion.vo.ReglaVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Interface ReglaService.
 */
public interface ReglaService {
	/**
	 * Select list.
	 *
	 * @param rglaCriterioVO
	 *            the rgla criterio VO
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	PaginatedList<ReglaVO> selectList(@NonNull final ReglaCriterioVO rglaCriterioVO, final int offset, final int limit);

	/**
	 * Select list.
	 *
	 * @param rglaCriterioVO
	 *            the rgla criterio VO
	 * @return the list
	 */
	List<ReglaVO> selectList(@NonNull final ReglaCriterioVO rglaCriterioVO);

	/**
	 * Select typeahead list.
	 *
	 * @param rglaCriterio
	 *            the rgla criterio
	 * @param limit
	 *            the limit
	 * @return the list
	 */
	List<ReglaVO> selectTypeaheadList(@NonNull final ReglaCriterioVO rglaCriterio, final int limit);

	/**
	 * Insert.
	 *
	 * @param rgla
	 *            the rgla
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws OverlapException
	 *             the overlap exception
	 */
	void insert(@NonNull final ReglaVO rgla, final Map<String, I18nVO> i18nMap) throws OverlapException;

	/**
	 * Update.
	 *
	 * @param rgla
	 *            the rgla
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 * @throws OverlapException
	 *             the overlap exception
	 */
	void update(@NonNull final ReglaVO rgla, final Map<String, I18nVO> i18nMap)
			throws InstanceNotFoundException, OverlapException;

	/**
	 * Delete.
	 *
	 * @param rgla
	 *            the rgla
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	void delete(@NonNull final ReglaVO rgla) throws InstanceNotFoundException;

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @param fref
	 *            the fref
	 * @param idioma
	 *            the idioma
	 * @return the regla VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	ReglaVO select(@NonNull final Long id, @NonNull final Date fref, final String idioma)
			throws InstanceNotFoundException;

	/**
	 * Select object.
	 *
	 * @param rglaCriterio
	 *            the rgla criterio
	 * @return the regla VO
	 */
	ReglaVO selectObject(@NonNull final ReglaCriterioVO rglaCriterio);
}
