package xeredi.argo.model.facturacion.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.OverlapException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.facturacion.vo.CargoCriterioVO;
import xeredi.argo.model.facturacion.vo.CargoVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Interface CargoService.
 */
public interface CargoService {

	/**
	 * Select list.
	 *
	 * @param crgoCriterioVO
	 *            the crgo criterio VO
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	PaginatedList<CargoVO> selectList(@NonNull final CargoCriterioVO crgoCriterioVO, final int offset, final int limit);

	/**
	 * Select typeahead list.
	 *
	 * @param crgoCriterio
	 *            the crgo criterio
	 * @param limit
	 *            the limit
	 * @return the list
	 */
	List<CargoVO> selectTypeaheadList(@NonNull final CargoCriterioVO crgoCriterio, final int limit);

	/**
	 * Select list.
	 *
	 * @param crgoCriterioVO
	 *            the crgo criterio VO
	 * @return the list
	 */
	List<CargoVO> selectList(@NonNull final CargoCriterioVO crgoCriterioVO);

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @param fref
	 *            the fref
	 * @param idioma
	 *            the idioma
	 * @return the cargo VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	CargoVO select(@NonNull final Long id, @NonNull final Date fref, final String idioma)
			throws InstanceNotFoundException;

	/**
	 * Select.
	 *
	 * @param versionId
	 *            the version id
	 * @param idioma
	 *            the idioma
	 * @return the cargo VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	CargoVO select(@NonNull final Long versionId, final String idioma) throws InstanceNotFoundException;

	/**
	 * Select object.
	 *
	 * @param crgoCriterio
	 *            the crgo criterio
	 * @return the cargo VO
	 */
	CargoVO selectObject(@NonNull final CargoCriterioVO crgoCriterio);

	/**
	 * Insert.
	 *
	 * @param crgo
	 *            the crgo
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws OverlapException
	 *             the overlap exception
	 */
	void insert(@NonNull final CargoVO crgo, final Map<String, I18nVO> i18nMap) throws OverlapException;

	/**
	 * Update.
	 *
	 * @param crgo
	 *            the crgo
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 * @throws OverlapException
	 *             the overlap exception
	 */
	void update(@NonNull final CargoVO crgo, final Map<String, I18nVO> i18nMap)
			throws InstanceNotFoundException, OverlapException;

	/**
	 * Delete.
	 *
	 * @param crgo
	 *            the crgo
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	void delete(@NonNull final CargoVO crgo) throws InstanceNotFoundException;
}
