package xeredi.integra.model.bo.maestro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.ExecutorType;
import org.mybatis.guice.transactional.Transactional;

import xeredi.integra.model.bo.comun.IgBO;
import xeredi.integra.model.dao.maestro.ParametroDAO;
import xeredi.integra.model.dao.maestro.ParametroDatoDAO;
import xeredi.integra.model.dao.maestro.ParametroI18nDAO;
import xeredi.integra.model.dao.maestro.ParametroVersionDAO;
import xeredi.integra.model.dao.maestro.SubparametroDAO;
import xeredi.integra.model.dao.maestro.SubparametroDatoDAO;
import xeredi.integra.model.dao.maestro.SubparametroVersionDAO;
import xeredi.integra.model.proxy.metamodelo.TipoSubparametroProxy;
import xeredi.integra.model.util.GlobalNames;
import xeredi.integra.model.vo.comun.ItemDatoVO;
import xeredi.integra.model.vo.maestro.ParametroCriterioVO;
import xeredi.integra.model.vo.maestro.ParametroI18nVO;
import xeredi.integra.model.vo.maestro.ParametroLupaCriterioVO;
import xeredi.integra.model.vo.maestro.ParametroVO;
import xeredi.integra.model.vo.maestro.ParametroVersionVO;
import xeredi.integra.model.vo.maestro.SubparametroCriterioVO;
import xeredi.integra.model.vo.maestro.SubparametroVO;
import xeredi.integra.model.vo.metamodelo.TipoParametroVO;
import xeredi.integra.model.vo.metamodelo.TipoSubparametroVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;

// TODO: Auto-generated Javadoc
/**
 * Implementación del servicio de gestión de maestros de la aplicación.
 */
@Singleton
public class ParametroBO implements Parametro {

    /** The prmt dao. */
    @Inject
    ParametroDAO prmtDAO;

    /** The prvr dao. */
    @Inject
    ParametroVersionDAO prvrDAO;

    /** The prdt dao. */
    @Inject
    ParametroDatoDAO prdtDAO;

    /** The i18n dao. */
    @Inject
    ParametroI18nDAO p18nDAO;

    /** The sprm dao. */
    @Inject
    SubparametroDAO sprmDAO;

    /** The spvr dao. */
    @Inject
    SubparametroVersionDAO spvrDAO;

    /** The spdt dao. */
    @Inject
    SubparametroDatoDAO spdtDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(executorType = ExecutorType.BATCH)
    public final void insert(final ParametroVO prmtVO, final TipoParametroVO tpprVO,
            final Map<String, ParametroI18nVO> i18nMap) throws DuplicateInstanceException {
        Preconditions.checkNotNull(prmtVO);
        Preconditions.checkNotNull(prmtVO.getParametro());
        Preconditions.checkNotNull(tpprVO);

        if (tpprVO.isTempExp()) {
            Preconditions.checkNotNull(prmtVO.getPrvr());
            Preconditions.checkNotNull(prmtVO.getPrvr().getFinicio());
        }

        if (tpprVO.isI18n()) {
            Preconditions.checkNotNull(i18nMap);
        }

        final IgBO igBO = new IgBO();

        if (!tpprVO.isTempExp()) {
            // FIXME Esto lo meto para poder dar de alta datos en maestros
            // 'Sobre la marcha'
            final Calendar calendar = Calendar.getInstance();

            calendar.add(Calendar.YEAR, -10);
            prmtVO.getPrvr().setFinicio(calendar.getTime());
        }

        if (tpprVO.isI18n()) {
            final Set<String> languages = GlobalNames.AVAILABLE_LANGUAGES;
            for (final String language : languages) {
                if (!i18nMap.containsKey(language)) {
                    throw new Error("No se ha pasado informacion de i18n para el idioma " + language
                            + " del parametro: " + prmtVO);
                }
            }
        }

        // Validar que los datos del parametro son correctos
        if (tpprVO.getEntdList() != null && !tpprVO.getEntdList().isEmpty()) {
            for (final Long tpdtId : tpprVO.getEntdList()) {
                if (!prmtVO.getItdtMap().containsKey(tpdtId)) {
                    throw new Error("No se ha pasado informacion del dato "
                            + tpprVO.getEntdMap().get(tpdtId).getTpdt().getNombre() + " del parametro: " + prmtVO);
                }
            }
        }

        if (prmtDAO.exists(prmtVO)) {
            if (prmtDAO.intersects(prmtVO)) {
                throw new DuplicateInstanceException(ParametroVO.class.getName(), prmtVO);
            }

            final Long id = prmtDAO.selectId(prmtVO);

            prmtVO.setId(id);
        } else {
            prmtVO.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
            prmtDAO.insert(prmtVO);
        }

        prmtVO.getPrvr().setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
        prvrDAO.insert(prmtVO);

        if (prmtVO.getItdtMap() != null) {
            for (final ItemDatoVO itdtVO : prmtVO.getItdtMap().values()) {
                itdtVO.setItemId(prmtVO.getPrvr().getId());
                prdtDAO.insert(itdtVO);
            }
        }

        if (tpprVO.isI18n()) {
            for (final ParametroI18nVO i18nVO : i18nMap.values()) {
                i18nVO.setPrvrId(prmtVO.getPrvr().getId());
                p18nDAO.insert(i18nVO);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(executorType = ExecutorType.BATCH)
    public void duplicate(final ParametroVO prmtVO, final TipoParametroVO tpprVO,
            final Map<String, ParametroI18nVO> i18nMap) throws DuplicateInstanceException {
        // TODO Implementar
        Preconditions.checkNotNull(prmtVO);
        Preconditions.checkNotNull(prmtVO.getId());
        Preconditions.checkNotNull(prmtVO.getParametro());
        Preconditions.checkNotNull(tpprVO);

        if (tpprVO.isI18n()) {
            Preconditions.checkNotNull(i18nMap);
        }

        if (tpprVO.isTempExp()) {
            Preconditions.checkNotNull(prmtVO.getPrvr());
            Preconditions.checkNotNull(prmtVO.getPrvr().getFinicio());
        } else {
            if (prmtVO.getPrvr() == null) {
                prmtVO.setPrvr(new ParametroVersionVO());
            }

            if (prmtVO.getPrvr().getFinicio() == null) {
                prmtVO.getPrvr().setFinicio(Calendar.getInstance().getTime());
            }
        }

        final IgBO igBO = new IgBO();
        final Long prmtActualId = prmtVO.getId();

        if (prmtDAO.exists(prmtVO)) {
            if (prmtDAO.intersects(prmtVO)) {
                throw new DuplicateInstanceException(ParametroVO.class.getName(), prmtVO);
            }

            final Long id = prmtDAO.selectId(prmtVO);

            prmtVO.setId(id);
        } else {
            prmtVO.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
            prmtDAO.insert(prmtVO);
        }

        prmtVO.getPrvr().setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
        prvrDAO.insert(prmtVO);

        if (prmtVO.getItdtMap() != null) {
            for (final ItemDatoVO itdtVO : prmtVO.getItdtMap().values()) {
                itdtVO.setItemId(prmtVO.getPrvr().getId());

                prdtDAO.insert(itdtVO);
            }
        }

        if (tpprVO.isI18n()) {
            for (final ParametroI18nVO p18nVO : i18nMap.values()) {
                p18nVO.setPrvrId(prmtVO.getPrvr().getId());

                p18nDAO.insert(p18nVO);
            }
        }

        if (tpprVO.getEntiHijasList() != null && !tpprVO.getEntiHijasList().isEmpty()) {
            final SubparametroCriterioVO sprmCriterioVO = new SubparametroCriterioVO();
            final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

            prmtCriterioVO.setId(prmtActualId);
            sprmCriterioVO.setPrmt(prmtCriterioVO);
            sprmCriterioVO.setFechaVigencia(prmtVO.getPrvr().getFinicio());

            final List<SubparametroVO> sprmList = sprmDAO.selectList(sprmCriterioVO);
            final Map<Long, SubparametroVO> sprmMap = new HashMap<>();
            final Set<Long> spvrIds = new HashSet<>();

            for (final SubparametroVO sprmVO : sprmList) {
                final TipoSubparametroVO tpspVO = TipoSubparametroProxy.select(sprmVO.getEntiId());

                if (tpspVO.isCmdDuplicado()) {
                    sprmMap.put(sprmVO.getSpvr().getId(), sprmVO);
                    spvrIds.add(sprmVO.getSpvr().getId());
                }
            }

            if (!spvrIds.isEmpty()) {
                sprmCriterioVO.setSpvrIds(spvrIds);

                final List<ItemDatoVO> spdtList = spdtDAO.selectList(sprmCriterioVO);

                for (final ItemDatoVO itdtVO : spdtList) {
                    final SubparametroVO sprmVO = sprmMap.get(itdtVO.getItemId());

                    if (sprmVO != null) {
                        if (sprmVO.getItdtMap() == null) {
                            sprmVO.setItdtMap(new HashMap<Long, ItemDatoVO>());
                        }

                        sprmVO.getItdtMap().put(itdtVO.getTpdtId(), itdtVO);
                    }
                }

                for (final SubparametroVO sprmVO : sprmMap.values()) {
                    sprmVO.setPrmtId(prmtVO.getId());
                    sprmVO.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
                    sprmVO.getSpvr().setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
                    sprmVO.getSpvr().setFinicio(prmtVO.getPrvr().getFinicio());
                    sprmVO.getSpvr().setFfin(prmtVO.getPrvr().getFfin());

                    sprmDAO.insert(sprmVO);
                }

                for (final SubparametroVO sprmVO : sprmMap.values()) {
                    spvrDAO.insert(sprmVO);
                }

                for (final SubparametroVO sprmVO : sprmMap.values()) {
                    if (sprmVO.getItdtMap() != null) {
                        for (final ItemDatoVO itdtVO : sprmVO.getItdtMap().values()) {
                            itdtVO.setItemId(sprmVO.getSpvr().getId());

                            spdtDAO.insert(itdtVO);
                        }
                    }
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(executorType = ExecutorType.BATCH)
    public final void update(final ParametroVO prmtVO, final TipoParametroVO tpprVO,
            final Map<String, ParametroI18nVO> i18nMap) throws DuplicateInstanceException {
        Preconditions.checkNotNull(prmtVO);
        Preconditions.checkNotNull(tpprVO);
        Preconditions.checkNotNull(prmtVO.getPrvr());
        Preconditions.checkNotNull(prmtVO.getPrvr().getId());

        if (tpprVO.isI18n()) {
            Preconditions.checkNotNull(i18nMap);
        }

        if (tpprVO.isTempExp()) {
            Preconditions.checkNotNull(prmtVO.getPrvr().getFinicio());
        }

        final IgBO igBO = new IgBO();

        // Validaciones
        if (tpprVO.isI18n()) {
            final Set<String> languages = GlobalNames.AVAILABLE_LANGUAGES;
            for (final String language : languages) {
                if (!i18nMap.containsKey(language)) {
                    throw new Error("No se ha pasado informacion de i18n para el idioma " + language
                            + " del parametro: " + prmtVO);
                }
            }
        }

        // Validar que los datos del parametro son correctos
        if (!tpprVO.getEntdList().isEmpty()) {
            for (final Long tpdtId : tpprVO.getEntdList()) {
                if (!prmtVO.getItdtMap().containsKey(tpdtId)) {
                    throw new Error("No se ha pasado informacion del dato "
                            + tpprVO.getEntdMap().get(tpdtId).getTpdt().getNombre() + " del parametro: " + prmtVO);
                }
            }
        }

        if (tpprVO.isTempExp()) {
            prmtVO.getPrvr().setFinicio(Calendar.getInstance().getTime());

            throw new Error("No implementado!");
            // TODO Implementar
        } else {
            // Si no es temporalidad eplicita, se cierra la version actual y
            // se crea una version nueva
            final Date fechaCambioPeriodo = Calendar.getInstance().getTime();

            prmtVO.getPrvr().setFfin(fechaCambioPeriodo);

            final int updatedRows = prvrDAO.updateDelete(prmtVO);

            if (updatedRows == 0) {
                throw new Error("No hay version que cerrar para el parametro: " + prmtVO);
            }

            prmtVO.getPrvr().setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
            prmtVO.getPrvr().setFinicio(fechaCambioPeriodo);
            prmtVO.getPrvr().setFfin(null);
            prvrDAO.insert(prmtVO);

            if (prmtVO.getItdtMap() != null) {
                for (final ItemDatoVO itdtVO : prmtVO.getItdtMap().values()) {
                    itdtVO.setItemId(prmtVO.getPrvr().getId());
                    prdtDAO.insert(itdtVO);
                }
            }

            if (i18nMap != null) {
                for (final ParametroI18nVO i18nVO : i18nMap.values()) {
                    i18nVO.setPrvrId(prmtVO.getPrvr().getId());
                    p18nDAO.insert(i18nVO);
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void delete(final Long prvrId, final TipoParametroVO tpprVO) throws InstanceNotFoundException {
        Preconditions.checkNotNull(prvrId);
        Preconditions.checkNotNull(tpprVO);

        // Un parametro con temporalidad explicita NO SE PUEDE BORRAR
        if (tpprVO.isTempExp()) {
            throw new Error("El parametro con versionId: " + prvrId + " de la entidad: " + tpprVO
                    + " no se puede borrar debido a que tiene temporalidad explicita");
        }

        final ParametroVO prmtVO = new ParametroVO();
        final ParametroVersionVO prvrVO = new ParametroVersionVO();

        prvrVO.setId(prvrId);
        prvrVO.setFfin(Calendar.getInstance().getTime());
        prmtVO.setPrvr(prvrVO);

        // FIXME Pasar el tipo de parametro para asegurarnos de que el tipo
        // pasado por argumento
        // corresponde con el tipo de prvrId
        final int updatedRows = prvrDAO.updateDelete(prmtVO);

        if (updatedRows == 0) {
            throw new InstanceNotFoundException(ParametroVersionVO.class.getName(), prvrId);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final List<ParametroVO> selectList(final ParametroCriterioVO prmtCriterioVO) {
        Preconditions.checkNotNull(prmtCriterioVO);

        final List<ParametroVO> prmtList = prmtDAO.selectList(prmtCriterioVO);

        fillDependencies(prmtList, prmtCriterioVO, prmtCriterioVO.getLimit() != null);

        return prmtList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final PaginatedList<ParametroVO> selectList(final ParametroCriterioVO prmtCriterioVO, final int offset,
            final int limit) {
        Preconditions.checkNotNull(prmtCriterioVO);

        final List<ParametroVO> prmtList = new ArrayList<>();
        final int count = prmtDAO.selectCount(prmtCriterioVO);

        if (count > offset) {
            prmtCriterioVO.setOffset(offset);
            prmtCriterioVO.setLimit(limit);

            prmtList.addAll(prmtDAO.selectList(prmtCriterioVO));

            prmtCriterioVO.setOffset(null);
            prmtCriterioVO.setLimit(null);

            // FIXME Ojo en la paginacion, puede traer una barbaridad de
            // dependencias
            fillDependencies(prmtList, prmtCriterioVO, true);
        }

        return new PaginatedList<>(prmtList, offset, limit, count);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final Map<Long, ParametroVO> selectMap(final ParametroCriterioVO prmtCriterioVO) {
        Preconditions.checkNotNull(prmtCriterioVO);

        final Map<Long, ParametroVO> prmtMap = prmtDAO.selectMap(prmtCriterioVO);

        fillDependencies(prmtMap.values(), prmtCriterioVO, prmtCriterioVO.getLimit() != null);

        return prmtMap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final Map<String, ParametroVO> selectMapByCodigo(final ParametroCriterioVO prmtCriterioVO) {
        Preconditions.checkNotNull(prmtCriterioVO);

        final Map<String, ParametroVO> prmtMap = prmtDAO.selectMapByCodigo(prmtCriterioVO);

        fillDependencies(prmtMap.values(), prmtCriterioVO, prmtCriterioVO.getLimit() != null);

        return prmtMap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final Map<String, Long> selectMapCodigoId(final ParametroCriterioVO prmtCriterioVO) {
        Preconditions.checkNotNull(prmtCriterioVO);

        final List<ParametroVO> prmtList = prmtDAO.selectList(prmtCriterioVO);
        final Map<String, Long> map = new HashMap<>();

        for (final ParametroVO prmtVO : prmtList) {
            map.put(prmtVO.getParametro(), prmtVO.getId());
        }

        return map;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final Map<Long, String> selectMapIdCodigo(final ParametroCriterioVO prmtCriterioVO) {
        Preconditions.checkNotNull(prmtCriterioVO);

        final List<ParametroVO> prmtList = prmtDAO.selectList(prmtCriterioVO);
        final Map<Long, String> map = new HashMap<>();

        for (final ParametroVO prmtVO : prmtList) {
            map.put(prmtVO.getId(), prmtVO.getParametro());
        }

        return map;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final Map<Long, List<LabelValueVO>> selectLabelValues(final Set<Long> tpprIds, final Date fechaReferencia,
            final String idioma) {
        Preconditions.checkNotNull(tpprIds);
        Preconditions.checkNotNull(fechaReferencia);
        Preconditions.checkNotNull(idioma);

        final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

        prmtCriterioVO.setEntiIds(tpprIds);
        prmtCriterioVO.setIdioma(idioma);
        prmtCriterioVO.setFechaVigencia(fechaReferencia);

        final List<ParametroVO> prmtList = prmtDAO.selectList(prmtCriterioVO);
        final Map<Long, List<LabelValueVO>> map = new HashMap<>();

        for (final ParametroVO prmtVO : prmtList) {
            if (!map.containsKey(prmtVO.getEntiId())) {
                map.put(prmtVO.getEntiId(), new ArrayList<LabelValueVO>());
            }

            String label = prmtVO.getParametro();

            if (prmtVO.getI18n() != null && prmtVO.getI18n().getTexto() != null) {
                label += " - " + prmtVO.getI18n().getTexto();
            }

            map.get(prmtVO.getEntiId()).add(new LabelValueVO(label, prmtVO.getId()));
        }

        return map;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final ParametroVO selectObject(final ParametroCriterioVO prmtCriterioVO) throws InstanceNotFoundException {
        Preconditions.checkNotNull(prmtCriterioVO);

        final ParametroVO prmtVO = prmtDAO.selectObject(prmtCriterioVO);

        if (prmtVO == null) {
            throw new InstanceNotFoundException(ParametroVO.class.getName(), prmtCriterioVO);
        }

        fillDependencies(Arrays.asList(new ParametroVO[] { prmtVO }), prmtCriterioVO, true);

        return prmtVO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final ParametroVO select(final Long prmtId, final String idioma, final Date fechaVigencia)
            throws InstanceNotFoundException {
        Preconditions.checkNotNull(prmtId);

        final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

        prmtCriterioVO.setId(prmtId);
        prmtCriterioVO.setIdioma(idioma);
        prmtCriterioVO.setFechaVigencia(fechaVigencia);

        final ParametroVO prmtVO = prmtDAO.selectObject(prmtCriterioVO);

        if (prmtVO == null) {
            throw new InstanceNotFoundException(ParametroVO.class.getName(), prmtCriterioVO);
        }

        fillDependencies(Arrays.asList(new ParametroVO[] { prmtVO }), prmtCriterioVO, true);

        return prmtVO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public ParametroVO select(Long prvrId, String idioma) throws InstanceNotFoundException {
        Preconditions.checkNotNull(prvrId);

        final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();
        final Set<Long> prvrIds = new HashSet<>();

        prvrIds.add(prvrId);

        prmtCriterioVO.setPrvrIds(prvrIds);
        prmtCriterioVO.setIdioma(idioma);

        final ParametroVO prmtVO = prmtDAO.selectObject(prmtCriterioVO);

        if (prmtVO == null) {
            throw new InstanceNotFoundException(ParametroVO.class.getName(), prmtCriterioVO);
        }

        fillDependencies(Arrays.asList(new ParametroVO[] { prmtVO }), prmtCriterioVO, true);

        return prmtVO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final List<LabelValueVO> selectLupaList(final ParametroLupaCriterioVO prmtLupaCriterioVO) {
        Preconditions.checkNotNull(prmtLupaCriterioVO);

        prmtLupaCriterioVO.setTextoBusqueda(prmtLupaCriterioVO.getTextoBusqueda().toUpperCase().trim() + '%');

        return prmtDAO.selectLupaList(prmtLupaCriterioVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final Map<String, ParametroI18nVO> selectI18nMap(final Long prvrId) {
        Preconditions.checkNotNull(prvrId);

        final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();
        final Set<Long> prvrIds = new HashSet<>();

        prvrIds.add(prvrId);
        prmtCriterioVO.setPrvrIds(prvrIds);

        final List<ParametroI18nVO> p18nList = p18nDAO.selectList(prmtCriterioVO);
        final Map<String, ParametroI18nVO> p18nMap = new HashMap<>();

        for (final ParametroI18nVO p18nVO : p18nList) {
            p18nMap.put(p18nVO.getIdioma(), p18nVO);
        }

        return p18nMap;
    }

    /**
     * Rellenado de los datos asociados a una lista de parametros. Búsqueda en parámetro dato.
     *
     * @param prmtList
     *            Colleccion de parámetros de los que se desea obtener sus datos asociados.
     * @param prmtCriterioVO
     *            Criterio de búsqueda de parámetros. Este criterio ha sido el utilizado para
     *            obtener la coleccion de parámetros pasada como argumento.
     * @param useIds
     *            the use ids
     */
    private void fillDependencies(final Collection<ParametroVO> prmtList, final ParametroCriterioVO prmtCriterioVO,
            final boolean useIds) {
        Preconditions.checkNotNull(prmtList);
        Preconditions.checkNotNull(prmtCriterioVO);

        if (!prmtList.isEmpty()) {
            if (useIds) {
                final Set<Long> prvrIds = new HashSet<>();

                for (final ParametroVO prmtVO : prmtList) {
                    prvrIds.add(prmtVO.getPrvr().getId());
                }

                prmtCriterioVO.setPrvrIds(prvrIds);
            }

            final List<ItemDatoVO> itdtList = prdtDAO.selectList(prmtCriterioVO);
            final Map<Long, Map<Long, ItemDatoVO>> map = new HashMap<>();

            for (final ItemDatoVO itdtVO : itdtList) {
                if (!map.containsKey(itdtVO.getItemId())) {
                    map.put(itdtVO.getItemId(), new HashMap<Long, ItemDatoVO>());
                }

                map.get(itdtVO.getItemId()).put(itdtVO.getTpdtId(), itdtVO);
            }

            for (final ParametroVO prmtVO : prmtList) {
                prmtVO.setItdtMap(map.get(prmtVO.getPrvr().getId()));
            }

            if (useIds) {
                prmtCriterioVO.setPrvrIds(null);
            }
        }
    }
}
