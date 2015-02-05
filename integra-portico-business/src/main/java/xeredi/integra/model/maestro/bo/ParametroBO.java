package xeredi.integra.model.maestro.bo;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nonnull;

import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.exception.OverlapException;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.maestro.vo.ParametroCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroLupaCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;
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
     * @param tpprVO
     *            the tppr vo
     * @param i18nMap
     *            the i18n map
     * @throws OverlapException
     *             the overlap exception
     */
    void insert(final @Nonnull ParametroVO prmt, final @Nonnull TipoParametroVO tpprVO,
            final Map<String, I18nVO> i18nMap) throws OverlapException;

    /**
     * Duplicate.
     *
     * @param prmt
     *            the prmt
     * @param tpprVO
     *            the tppr vo
     * @param i18nMap
     *            the i18n map
     * @throws OverlapException
     *             the overlap exception
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    void duplicate(final @Nonnull ParametroVO prmt, final @Nonnull TipoParametroVO tpprVO,
            final Map<String, I18nVO> i18nMap) throws OverlapException, InstanceNotFoundException;

    /**
     * Update.
     *
     * @param prmt
     *            the prmt
     * @param tpprVO
     *            the tppr vo
     * @param i18nMap
     *            the i18n map
     * @throws OverlapException
     *             the overlap exception
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    void update(final @Nonnull ParametroVO prmt, final @Nonnull TipoParametroVO tpprVO,
            final Map<String, I18nVO> i18nMap) throws OverlapException, InstanceNotFoundException;

    /**
     * Delete.
     *
     * @param prmt
     *            the prmt
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    void delete(final @Nonnull ParametroVO prmt) throws InstanceNotFoundException;

    /**
     * Select list.
     *
     * @param prmtCriterioVO
     *            the prmt criterio vo
     * @return the list
     */
    List<ParametroVO> selectList(final @Nonnull ParametroCriterioVO prmtCriterioVO);

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
    PaginatedList<ParametroVO> selectList(final @Nonnull ParametroCriterioVO prmtCriterioVO, final int offset,
            final int limit);

    /**
     * Select map.
     *
     * @param prmtCriterioVO
     *            the prmt criterio vo
     * @return the map
     */
    Map<Long, ParametroVO> selectMap(final @Nonnull ParametroCriterioVO prmtCriterioVO);

    /**
     * Select map by codigo.
     *
     * @param prmtCriterioVO
     *            the prmt criterio vo
     * @return the map
     */
    Map<String, ParametroVO> selectMapByCodigo(final @Nonnull ParametroCriterioVO prmtCriterioVO);

    /**
     * Select map codigo id.
     *
     * @param prmtCriterioVO
     *            the prmt criterio vo
     * @return the map
     */
    Map<String, Long> selectMapCodigoId(final @Nonnull ParametroCriterioVO prmtCriterioVO);

    /**
     * Select map id codigo.
     *
     * @param prmtCriterioVO
     *            the prmt criterio vo
     * @return the map
     */
    Map<Long, String> selectMapIdCodigo(final @Nonnull ParametroCriterioVO prmtCriterioVO);

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
    Map<Long, List<LabelValueVO>> selectLabelValues(final @Nonnull Set<Long> tpprIds, final Date fechaReferencia,
            final String idioma);

    /**
     * Select label values.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the list
     */
    List<LabelValueVO> selectLabelValues(final @Nonnull ParametroCriterioVO criterioVO);

    /**
     * Select object.
     *
     * @param prmtCriterioVO
     *            the prmt criterio vo
     * @return the parametro vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    ParametroVO selectObject(final @Nonnull ParametroCriterioVO prmtCriterioVO) throws InstanceNotFoundException;

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
    ParametroVO select(final @Nonnull Long prmtId, final String idioma, final Date fechaVigencia)
            throws InstanceNotFoundException;

    /**
     * Select lupa list.
     *
     * @param prmtLupaCriterioVO
     *            the prmt lupa criterio vo
     * @param limit
     *            the limit
     * @return the list
     */
    List<ParametroVO> selectLupaList(final @Nonnull ParametroLupaCriterioVO prmtLupaCriterioVO, final int limit);

}
