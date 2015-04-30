package xeredi.integra.model.maestro.bo;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.exception.OverlapException;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.maestro.vo.ParametroCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.maestro.vo.SubparametroCriterioVO;
import xeredi.integra.model.metamodelo.proxy.TipoParametroDetailVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * Implementación del servicio de gestión de maestros de la aplicación.
 */
public interface ParametroBO {

    /**
     * Insert.
     *
     * @param prmt
     *            the prmt
     * @param tpprDetail
     *            the tppr detail
     * @param i18nMap
     *            the i18n map
     * @throws OverlapException
     *             the overlap exception
     */
    void insert(final ParametroVO prmt, final TipoParametroDetailVO tpprDetail, final Map<String, I18nVO> i18nMap)
            throws OverlapException;

    /**
     * Duplicate.
     *
     * @param prmt
     *            the prmt
     * @param tpprDetail
     *            the tppr detail
     * @param i18nMap
     *            the i18n map
     * @throws OverlapException
     *             the overlap exception
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    void duplicate(final ParametroVO prmt, final TipoParametroDetailVO tpprDetail, final Map<String, I18nVO> i18nMap)
            throws OverlapException, InstanceNotFoundException;

    /**
     * Update.
     *
     * @param prmt
     *            the prmt
     * @param tpprDetail
     *            the tppr detail
     * @param i18nMap
     *            the i18n map
     * @throws OverlapException
     *             the overlap exception
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    void update(final ParametroVO prmt, final TipoParametroDetailVO tpprDetail, final Map<String, I18nVO> i18nMap)
            throws OverlapException, InstanceNotFoundException;

    /**
     * Delete.
     *
     * @param prmt
     *            the prmt
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    void delete(final ParametroVO prmt) throws InstanceNotFoundException;

    /**
     * Select list.
     *
     * @param prmtCriterioVO
     *            the prmt criterio vo
     * @return the list
     */
    List<ParametroVO> selectList(final ParametroCriterioVO prmtCriterioVO);

    /**
     * Select list.
     *
     * @param prmtCriterioVO
     *            the prmt criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    PaginatedList<ParametroVO> selectList(final ParametroCriterioVO prmtCriterioVO, final int offset, final int limit);

    /**
     * Select map.
     *
     * @param prmtCriterioVO
     *            the prmt criterio vo
     * @return the map
     */
    Map<Long, ParametroVO> selectMap(final ParametroCriterioVO prmtCriterioVO);

    /**
     * Select map by codigo.
     *
     * @param prmtCriterioVO
     *            the prmt criterio vo
     * @return the map
     */
    Map<String, ParametroVO> selectMapByCodigo(final ParametroCriterioVO prmtCriterioVO);

    /**
     * Select map codigo id.
     *
     * @param prmtCriterioVO
     *            the prmt criterio vo
     * @return the map
     */
    Map<String, Long> selectMapCodigoId(final ParametroCriterioVO prmtCriterioVO);

    /**
     * Select map id codigo.
     *
     * @param prmtCriterioVO
     *            the prmt criterio vo
     * @return the map
     */
    Map<Long, String> selectMapIdCodigo(final ParametroCriterioVO prmtCriterioVO);

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
    Map<Long, List<LabelValueVO>> selectLabelValues(final Set<Long> tpprIds, final Date fechaReferencia,
            final String idioma);

    /**
     * Select label values.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the list
     */
    List<LabelValueVO> selectLabelValues(final ParametroCriterioVO criterioVO);

    /**
     * Select object.
     *
     * @param prmtCriterioVO
     *            the prmt criterio vo
     * @return the parametro vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    ParametroVO selectObject(final ParametroCriterioVO prmtCriterioVO) throws InstanceNotFoundException;

    /**
     * Select.
     *
     * @param prmtId
     *            the prmt id
     * @param idioma
     *            the idioma
     * @param fechaVigencia
     *            the fecha vigencia
     * @return the parametro vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    ParametroVO select(final Long prmtId, final String idioma, final Date fechaVigencia)
            throws InstanceNotFoundException;

    /**
     * Select lupa list.
     *
     * @param criterio
     *            the criterio
     * @param limit
     *            the limit
     * @return the list
     */
    List<ParametroVO> selectLupaList(final ParametroCriterioVO criterio, final int limit);

    /**
     * Select typeahead sprm list.
     *
     * @param criterio
     *            the criterio
     * @param limit
     *            the limit
     * @return the list
     */
    List<ParametroVO> selectTypeaheadSprmList(final SubparametroCriterioVO criterio, final int limit);

}
