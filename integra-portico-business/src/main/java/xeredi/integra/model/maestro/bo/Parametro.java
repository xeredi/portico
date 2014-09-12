package xeredi.integra.model.maestro.bo;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import xeredi.integra.model.maestro.vo.ParametroCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroI18nVO;
import xeredi.integra.model.maestro.vo.ParametroLupaCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * Servicio de Gestión de parámetros.
 */
public interface Parametro {

    /**
     * Alta de los datos de un nuevo parámetro.
     *
     * @param prmtVO
     *            Datos de un parámetro
     * @param tpprVO
     *            Tipo de parámetro al que pertenece el parámetro.
     * @param i18nMap
     *            Datos de internacionalizacion del parámetro.
     * @throws DuplicateInstanceException
     *             Si ya existe un parámetro con los mismos datos.
     */
    void insert(final ParametroVO prmtVO, final TipoParametroVO tpprVO, final Map<String, ParametroI18nVO> i18nMap)
            throws DuplicateInstanceException;

    /**
     * Duplicado de los datos de un parámetro.
     *
     * @param prmtVO
     *            Nuevos datos del parámetro.
     * @param tpprVO
     *            Tipo de parámetro al que pertenece el parámetro.
     * @param i18nMap
     *            Datos de internacionalizacion del parámetro.
     * @throws DuplicateInstanceException
     *             Si ya existe un parámetro con los mismos datos.
     */
    void duplicate(final ParametroVO prmtVO, final TipoParametroVO tpprVO, final Map<String, ParametroI18nVO> i18nMap)
            throws DuplicateInstanceException;

    /**
     * Modificación de los datos de un parámetro existente.
     *
     * @param prmtVO
     *            Nuevos datos del parámetro.
     * @param tpprVO
     *            Tipo de parámetro al que pertenece el parámetro.
     * @param i18nMap
     *            Datos de internacionalizacion del parámetro.
     * @throws DuplicateInstanceException
     *             Si ya existe un parámetro con los mismos datos.
     */
    void update(final ParametroVO prmtVO, final TipoParametroVO tpprVO, final Map<String, ParametroI18nVO> i18nMap)
            throws DuplicateInstanceException;

    /**
     * Borrado de los datos de una version de un parametro.
     *
     * @param prvrId
     *            Identificador de la version de un parámetro.
     * @param tpprVO
     *            Tipo de parámetro al que pertenece el parámetro.
     * @throws InstanceNotFoundException
     *             Si no se encuentra la versión del parámetro a eliminar.
     */
    void delete(final Long prvrId, final TipoParametroVO tpprVO) throws InstanceNotFoundException;

    /**
     * Búsqueda de parámetros que cumplan un criterio de búsqueda.
     *
     * @param prmtCriterioVO
     *            Criterio de búsqueda de parámetros.
     * @return {@link List} de parametros que cumplen el criterio de busqueda.
     */
    List<ParametroVO> selectList(final ParametroCriterioVO prmtCriterioVO);

    /**
     * Búsqueda paginada de parámetros que cumplan un criterio de búsqueda.
     *
     * @param prmtCriterioVO
     *            Criterio de búsqueda de parámetros.
     * @param offset
     *            Posición desde la que se empieza a devolver resultados.
     * @param limit
     *            Número máximo de resultados.
     * @return {@link PaginatedList} de parametros que cumplen el criterio de busqueda.
     */
    PaginatedList<ParametroVO> selectList(final ParametroCriterioVO prmtCriterioVO, final int offset, final int limit);

    /**
     * Búsqueda de parámetros que cumplan un criterio de búsqueda.
     *
     * @param prmtCriterioVO
     *            Criterio de búsqueda de parámetros.
     * @return {@link Map} de parametros que cumplen el criterio de busqueda, indexados por identificador de parámetro.
     */
    Map<Long, ParametroVO> selectMap(final ParametroCriterioVO prmtCriterioVO);

    /**
     * Búsqueda de parámetros que cumplan un criterio de búsqueda.
     *
     * @param prmtCriterioVO
     *            Criterio de búsqueda de parámetros.
     * @return {@link Map} de parametros que cumplen el criterio de busqueda, indexados por código de parámetro.
     */
    Map<String, ParametroVO> selectMapByCodigo(final ParametroCriterioVO prmtCriterioVO);

    /**
     * Búsqueda de pares (codigo de parámetro, identificador de parámetro) de parámetros que cumplan un criterio de
     * búsqueda.
     *
     * @param prmtCriterioVO
     *            Criterio de búsqueda de parámetros.
     * @return {@link Map} de identificadores de parametros que cumplen el criterio de busqueda, indexados por código de
     *         parámetro.
     */
    Map<String, Long> selectMapCodigoId(final ParametroCriterioVO prmtCriterioVO);

    /**
     * Búsqueda de pares (identificador de parámetro, codigo de parámetro) de parámetros que cumplan un criterio de
     * búsqueda.
     *
     * @param prmtCriterioVO
     *            Criterio de búsqueda de parámetros.
     * @return {@link Map} de códigos de parametros que cumplen el criterio de busqueda, indexados por identificador de
     *         parámetro.
     */
    Map<Long, String> selectMapIdCodigo(final ParametroCriterioVO prmtCriterioVO);

    /**
     * Map de Listas de pares (etiqueta de parametro, identificador de parametro), para una lista de tipos de parámetro,
     * una fecha de referencia y un idioma.
     *
     * @param tpprIds
     *            Lista de identificadores de tipo de parámetro.
     * @param fechaReferencia
     *            Fecha de referencia. Utilizada para obtener la versión correcta de cada parámetro.
     * @param idioma
     *            Idioma. Utilizado para obtener la etiqueta correcta de cada parámetro internacionalizado.
     * @return {@link Map} de listas de pares (etiqueta de parametro, identificador de parametro) que cumplen el
     *         criterio de busqueda, indexados por identificador de tipo de parámetro.
     */
    Map<Long, List<LabelValueVO>> selectLabelValues(final Set<Long> tpprIds, final Date fechaReferencia,
            final String idioma);

    /**
     * Búsqueda de un parámetro que cumpla un criterio de búsqueda.
     *
     * @param prmtCriterioVO
     *            Criterio de búsqueda de parámetros.
     * @return Datos del parámetro buscado.
     * @throws InstanceNotFoundException
     *             Si no se encuentra un parámetro que cumpla el criterio de búsqueda.
     */
    ParametroVO selectObject(final ParametroCriterioVO prmtCriterioVO) throws InstanceNotFoundException;

    /**
     * Búsqueda de un parámetro a partir de su identificador.
     *
     * @param prmtId
     *            Identificador de un parámetro.
     * @param idioma
     *            Idioma para obtener la parte internacionalizada.
     * @param fechaVigencia
     *            Fecha de vigencia para obtener la versión del parámetro.
     * @return Datos del parámetro buscado.
     * @throws InstanceNotFoundException
     *             Si no se encuentra un parámetro.
     */
    ParametroVO select(final Long prmtId, final String idioma, final Date fechaVigencia)
            throws InstanceNotFoundException;

    /**
     * Select.
     *
     * @param prvrId
     *            the prvr id
     * @param idioma
     *            the idioma
     * @return the parametro vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    ParametroVO select(final Long prvrId, final String idioma) throws InstanceNotFoundException;

    /**
     * Búsqueda de Lista de pares (etiqueta de parametro, identificador de parametro) de parámetros que cumplan un
     * criterio de búsqueda.
     *
     * @param prmtLupaCriterioVO
     *            the prmt lupa criterio vo
     * @return {@link List} de pares (etiqueta de parametro, identificador de parametro) que cumplen el criterio de
     *         busqueda.
     */
    List<ParametroVO> selectLupaList(final ParametroLupaCriterioVO prmtLupaCriterioVO);

    /**
     * Búsqueda de los textos internacionalizados para una versión de un parámetro.
     *
     * @param prvrId
     *            Identificador de la versión de un parámetro.
     * @return {@link Map} de textos internacionalizados de la versión de un parámetro, indexados por código de idioma.
     */
    Map<String, ParametroI18nVO> selectI18nMap(final Long prvrId);
}
