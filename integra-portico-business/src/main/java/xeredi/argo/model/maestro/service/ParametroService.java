package xeredi.argo.model.maestro.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.OverlapException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.maestro.vo.ParametroCriterioVO;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.metamodelo.vo.TipoParametroDetailVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Interface ParametroService.
 */
public interface ParametroService {

	/**
	 * Insert.
	 *
	 * @param prmt
	 *            the prmt
	 * @param tpprDetail
	 *            the tppr detail
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws OverlapException
	 *             the overlap exception
	 */
	void insert(@NonNull final ParametroVO prmt, @NonNull final TipoParametroDetailVO tpprDetail,
			final Map<String, I18nVO> i18nMap) throws OverlapException;

	/**
	 * Duplicate.
	 *
	 * @param prmt
	 *            the prmt
	 * @param tpprDetail
	 *            the tppr detail
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws OverlapException
	 *             the overlap exception
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	void duplicate(@NonNull final ParametroVO prmt, @NonNull final TipoParametroDetailVO tpprDetail,
			final Map<String, I18nVO> i18nMap) throws OverlapException, InstanceNotFoundException;

	/**
	 * Duplicate version.
	 *
	 * @param prmt
	 *            the prmt
	 * @param tpprDetail
	 *            the tppr detail
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws OverlapException
	 *             the overlap exception
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	void duplicateVersion(@NonNull final ParametroVO prmt, @NonNull final TipoParametroDetailVO tpprDetail,
			final Map<String, I18nVO> i18nMap) throws OverlapException, InstanceNotFoundException;

	/**
	 * Update.
	 *
	 * @param prmt
	 *            the prmt
	 * @param tpprDetail
	 *            the tppr detail
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws OverlapException
	 *             the overlap exception
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	void update(@NonNull final ParametroVO prmt, @NonNull final TipoParametroDetailVO tpprDetail,
			final Map<String, I18nVO> i18nMap) throws OverlapException, InstanceNotFoundException;

	/**
	 * Delete.
	 *
	 * @param prmt
	 *            the prmt
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	void delete(@NonNull final ParametroVO prmt) throws InstanceNotFoundException;

	/**
	 * Select list.
	 *
	 * @param prmtCriterioVO
	 *            the prmt criterio VO
	 * @return the list
	 */
	List<ParametroVO> selectList(@NonNull final ParametroCriterioVO prmtCriterioVO);

	/**
	 * Select list.
	 *
	 * @param prmtCriterioVO
	 *            the prmt criterio VO
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	PaginatedList<ParametroVO> selectList(@NonNull final ParametroCriterioVO prmtCriterioVO, final int offset,
			final int limit);

	/**
	 * Select map.
	 *
	 * @param prmtCriterioVO
	 *            the prmt criterio VO
	 * @return the map
	 */
	Map<Long, ParametroVO> selectMap(@NonNull final ParametroCriterioVO prmtCriterioVO);

	/**
	 * Select map by codigo.
	 *
	 * @param prmtCriterioVO
	 *            the prmt criterio VO
	 * @return the map
	 */
	Map<String, ParametroVO> selectMapByCodigo(@NonNull final ParametroCriterioVO prmtCriterioVO);

	/**
	 * Select map codigo id.
	 *
	 * @param prmtCriterioVO
	 *            the prmt criterio VO
	 * @return the map
	 */
	Map<String, Long> selectMapCodigoId(@NonNull final ParametroCriterioVO prmtCriterioVO);

	/**
	 * Select map id codigo.
	 *
	 * @param prmtCriterioVO
	 *            the prmt criterio VO
	 * @return the map
	 */
	Map<Long, String> selectMapIdCodigo(@NonNull final ParametroCriterioVO prmtCriterioVO);

	/**
	 * Select label values.
	 *
	 * @param tpprIds
	 *            the tppr ids
	 * @param fechaReferencia
	 *            the fecha referencia
	 * @param idioma
	 *            the idioma
	 * @return the map
	 */
	Map<Long, List<LabelValueVO>> selectLabelValues(@NonNull final Set<Long> tpprIds,
			@NonNull final Date fechaReferencia, final String idioma);

	/**
	 * Select label values.
	 *
	 * @param criterioVO
	 *            the criterio VO
	 * @return the list
	 */
	List<LabelValueVO> selectLabelValues(@NonNull final ParametroCriterioVO criterioVO);

	/**
	 * Select object.
	 *
	 * @param prmtCriterioVO
	 *            the prmt criterio VO
	 * @return the parametro VO
	 */
	ParametroVO selectObject(@NonNull final ParametroCriterioVO prmtCriterioVO);

	/**
	 * Select.
	 *
	 * @param prmtId
	 *            the prmt id
	 * @param idioma
	 *            the idioma
	 * @param fechaVigencia
	 *            the fecha vigencia
	 * @return the parametro VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	ParametroVO select(@NonNull final Long prmtId, final String idioma, final Date fechaVigencia)
			throws InstanceNotFoundException;

	/**
	 * Select typeahead list.
	 *
	 * @param criterio
	 *            the criterio
	 * @param limit
	 *            the limit
	 * @return the list
	 */
	List<ParametroVO> selectTypeaheadList(@NonNull final ParametroCriterioVO criterio, final int limit);
}
