package xeredi.integra.model.maestro.bo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.comun.exception.OverlapException;
import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.maestro.dao.ParametroDAO;
import xeredi.integra.model.maestro.dao.ParametroDatoDAO;
import xeredi.integra.model.maestro.dao.ParametroI18nDAO;
import xeredi.integra.model.maestro.dao.SubparametroDAO;
import xeredi.integra.model.maestro.dao.SubparametroDatoDAO;
import xeredi.integra.model.maestro.vo.ParametroCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroI18nVO;
import xeredi.integra.model.maestro.vo.ParametroLupaCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.maestro.vo.SubparametroCriterioVO;
import xeredi.integra.model.maestro.vo.SubparametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubparametroProxy;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroVO;
import xeredi.integra.model.util.GlobalNames;
import xeredi.util.applicationobjects.LabelValueVO;
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

    /** The prdt dao. */
    @Inject
    ParametroDatoDAO prdtDAO;

    /** The i18n dao. */
    @Inject
    ParametroI18nDAO p18nDAO;

    /** The sprm dao. */
    @Inject
    SubparametroDAO sprmDAO;

    /** The spdt dao. */
    @Inject
    SubparametroDatoDAO spdtDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(executorType = ExecutorType.BATCH)
    public final void insert(final ParametroVO prmt, final TipoParametroVO tpprVO,
            final Map<String, ParametroI18nVO> i18nMap) throws OverlapException {
        Preconditions.checkNotNull(prmt);
        Preconditions.checkNotNull(prmt.getParametro());
        Preconditions.checkNotNull(prmt.getPrvr());
        Preconditions.checkNotNull(prmt.getPrvr().getFini());
        Preconditions.checkNotNull(tpprVO);

        if (tpprVO.getI18n()) {
            Preconditions.checkNotNull(i18nMap);
        }

        if (tpprVO.getI18n()) {
            final Set<String> languages = GlobalNames.AVAILABLE_LANGUAGES;
            for (final String language : languages) {
                if (!i18nMap.containsKey(language)) {
                    throw new Error("No se ha pasado informacion de i18n para el idioma " + language
                            + " del parametro: " + prmt);
                }
            }
        }

        // Validar que los datos del parametro son correctos
        if (tpprVO.getEntdList() != null && !tpprVO.getEntdList().isEmpty()) {
            for (final Long tpdtId : tpprVO.getEntdList()) {
                if (!prmt.getItdtMap().containsKey(String.valueOf(tpdtId))) {
                    final ItemDatoVO itdt = new ItemDatoVO();

                    itdt.setTpdtId(tpdtId);
                    prmt.getItdtMap().put(tpdtId, itdt);

                    // throw new Error("No se ha pasado informacion del dato "
                    // + tpprVO.getEntdMap().get(tpdtId).getTpdt().getNombre() + " del parametro: " + prmt);
                }
            }
        }

        final IgBO igBO = new IgBO();

        if (prmtDAO.exists(prmt)) {
            prmt.setId(prmtDAO.selectId(prmt));
        } else {
            prmt.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));

            prmtDAO.insert(prmt);
        }

        prmt.getPrvr().setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));

        if (prmtDAO.existsOverlap(prmt)) {
            throw new OverlapException(ParametroVO.class.getName(), prmt);
        }

        prmtDAO.insertVersion(prmt);

        if (prmt.getItdtMap() != null) {
            for (final ItemDatoVO itdtVO : prmt.getItdtMap().values()) {
                itdtVO.setItemId(prmt.getPrvr().getId());
                prdtDAO.insert(itdtVO);
            }
        }

        if (tpprVO.getI18n()) {
            for (final ParametroI18nVO i18nVO : i18nMap.values()) {
                i18nVO.setPrvrId(prmt.getPrvr().getId());
                p18nDAO.insert(i18nVO);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(executorType = ExecutorType.BATCH)
    public void duplicate(final ParametroVO prmt, final TipoParametroVO tpprVO,
            final Map<String, ParametroI18nVO> i18nMap) throws OverlapException, InstanceNotFoundException {
        // TODO Implementar
        Preconditions.checkNotNull(prmt);
        Preconditions.checkNotNull(prmt.getId());
        Preconditions.checkNotNull(prmt.getParametro());
        Preconditions.checkNotNull(prmt.getPrvr());
        Preconditions.checkNotNull(prmt.getPrvr().getFini());
        Preconditions.checkNotNull(tpprVO);

        if (tpprVO.getI18n()) {
            Preconditions.checkNotNull(i18nMap);
        }

        if (tpprVO.getI18n()) {
            final Set<String> languages = GlobalNames.AVAILABLE_LANGUAGES;
            for (final String language : languages) {
                if (!i18nMap.containsKey(language)) {
                    throw new Error("No se ha pasado informacion de i18n para el idioma " + language
                            + " del parametro: " + prmt);
                }
            }
        }

        // Validar que los datos del parametro son correctos
        if (tpprVO.getEntdList() != null && !tpprVO.getEntdList().isEmpty()) {
            for (final Long tpdtId : tpprVO.getEntdList()) {
                if (!prmt.getItdtMap().containsKey(tpdtId.toString())) {
                    final ItemDatoVO itdt = new ItemDatoVO();

                    itdt.setTpdtId(tpdtId);
                    prmt.getItdtMap().put(tpdtId, itdt);

                    // throw new Error("No se ha pasado informacion del dato "
                    // + tpprVO.getEntdMap().get(tpdtId).getTpdt().getNombre() + " del parametro: " + prmt);
                }
            }
        }

        final IgBO igBO = new IgBO();

        // Busqueda del parametro a duplicar
        final ParametroCriterioVO prmtCriterio = new ParametroCriterioVO();

        prmtCriterio.setPrvrId(prmt.getPrvr().getId());

        final ParametroVO prmtActual = prmtDAO.selectObject(prmtCriterio);

        if (prmtActual == null) {
            throw new InstanceNotFoundException(ParametroVO.class.getName(), prmt);
        }

        // Alta del nuevo parametro
        if (prmtDAO.exists(prmt)) {
            prmt.setId(prmtDAO.selectId(prmt));
        } else {
            prmt.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));

            prmtDAO.insert(prmt);
        }

        prmt.getPrvr().setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));

        if (prmtDAO.existsOverlap(prmt)) {
            throw new OverlapException(ParametroVO.class.getName(), prmt);
        }

        prmtDAO.insertVersion(prmt);

        if (prmt.getItdtMap() != null) {
            for (final ItemDatoVO itdtVO : prmt.getItdtMap().values()) {
                itdtVO.setItemId(prmt.getPrvr().getId());

                prdtDAO.insert(itdtVO);
            }
        }

        if (tpprVO.getI18n()) {
            for (final ParametroI18nVO p18nVO : i18nMap.values()) {
                p18nVO.setPrvrId(prmt.getPrvr().getId());

                p18nDAO.insert(p18nVO);
            }
        }

        if (!prmtActual.getId().equals(prmt.getId())) {
            // Duplicado de subparametros

            if (tpprVO.getEntiHijasList() != null && !tpprVO.getEntiHijasList().isEmpty()) {
                final SubparametroCriterioVO sprmCriterioVO = new SubparametroCriterioVO();
                final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

                prmtCriterioVO.setId(prmtActual.getId());
                sprmCriterioVO.setPrmt(prmtCriterioVO);
                sprmCriterioVO.setFechaVigencia(prmtActual.getPrvr().getFini());

                final List<SubparametroVO> sprmList = sprmDAO.selectList(sprmCriterioVO);
                final Map<Long, SubparametroVO> sprmMap = new HashMap<>();
                final Set<Long> spvrIds = new HashSet<>();

                for (final SubparametroVO sprmVO : sprmList) {
                    final TipoSubparametroVO tpspVO = TipoSubparametroProxy.select(sprmVO.getEntiId());

                    if (tpspVO.getCmdDuplicado()) {
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
                        sprmVO.setPrmtId(prmt.getId());
                        sprmVO.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
                        sprmVO.getSpvr().setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
                        sprmVO.getSpvr().setFini(prmt.getPrvr().getFini());
                        sprmVO.getSpvr().setFfin(prmt.getPrvr().getFfin());

                        if (sprmVO.getItdtMap() != null) {
                            for (final ItemDatoVO itdtVO : sprmVO.getItdtMap().values()) {
                                itdtVO.setItemId(sprmVO.getSpvr().getId());
                            }
                        }
                    }

                    for (final SubparametroVO sprmVO : sprmMap.values()) {
                        sprmDAO.insert(sprmVO);
                    }

                    for (final SubparametroVO sprmVO : sprmMap.values()) {
                        sprmDAO.insertVersion(sprmVO);
                    }

                    for (final SubparametroVO sprmVO : sprmMap.values()) {
                        if (sprmVO.getItdtMap() != null) {
                            for (final ItemDatoVO itdtVO : sprmVO.getItdtMap().values()) {
                                spdtDAO.insert(itdtVO);
                            }
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
    public final void update(final ParametroVO prmt, final TipoParametroVO tpprVO,
            final Map<String, ParametroI18nVO> i18nMap) throws OverlapException, InstanceNotFoundException {
        Preconditions.checkNotNull(prmt);
        Preconditions.checkNotNull(tpprVO);
        Preconditions.checkNotNull(prmt.getPrvr());
        Preconditions.checkNotNull(prmt.getPrvr().getId());

        if (tpprVO.getI18n()) {
            Preconditions.checkNotNull(i18nMap);
        }

        if (tpprVO.getTempExp()) {
            Preconditions.checkNotNull(prmt.getPrvr().getFini());
        }

        // Validaciones
        if (tpprVO.getI18n()) {
            final Set<String> languages = GlobalNames.AVAILABLE_LANGUAGES;
            for (final String language : languages) {
                if (!i18nMap.containsKey(language)) {
                    throw new Error("No se ha pasado informacion de i18n para el idioma " + language
                            + " del parametro: " + prmt);
                }
            }
        }

        // Validar que los datos del parametro son correctos
        if (!tpprVO.getEntdList().isEmpty()) {
            for (final Long tpdtId : tpprVO.getEntdList()) {
                if (!prmt.getItdtMap().containsKey(tpdtId.toString())) {
                    throw new Error("No se ha pasado informacion del dato "
                            + tpprVO.getEntdMap().get(tpdtId).getTpdt().getNombre() + " del parametro: " + prmt);
                }
            }
        }

        if (prmtDAO.existsOverlap(prmt)) {
            throw new OverlapException(ParametroVO.class.getName(), prmt);
        }

        final int updated = prmtDAO.updateVersion(prmt);

        if (updated == 0) {
            throw new InstanceNotFoundException(ParametroVO.class.getName(), prmt);
        }

        if (prmt.getItdtMap() != null) {
            for (final ItemDatoVO itdtVO : prmt.getItdtMap().values()) {
                itdtVO.setItemId(prmt.getPrvr().getId());
                prdtDAO.update(itdtVO);
            }
        }

        if (i18nMap != null) {
            for (final ParametroI18nVO i18nVO : i18nMap.values()) {
                i18nVO.setPrvrId(prmt.getPrvr().getId());
                p18nDAO.update(i18nVO);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void delete(final ParametroVO prmt) throws InstanceNotFoundException {
        Preconditions.checkNotNull(prmt);
        Preconditions.checkNotNull(prmt.getPrvr());
        Preconditions.checkNotNull(prmt.getPrvr().getId());

        prdtDAO.deleteVersion(prmt);
        p18nDAO.deleteVersion(prmt);

        final int updated = prmtDAO.deleteVersion(prmt);

        if (updated == 0) {
            throw new InstanceNotFoundException(ParametroVO.class.getName(), prmt);
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
        final int count = prmtDAO.count(prmtCriterioVO);

        if (count > offset) {
            prmtList.addAll(prmtDAO.selectList(prmtCriterioVO, new RowBounds(offset, limit)));

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
    public ParametroVO select(final Long prvrId, final String idioma) throws InstanceNotFoundException {
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
    public final List<ParametroVO> selectLupaList(final ParametroLupaCriterioVO prmtLupaCriterioVO) {
        Preconditions.checkNotNull(prmtLupaCriterioVO);

        prmtLupaCriterioVO.setTextoBusqueda(prmtLupaCriterioVO.getTextoBusqueda().toUpperCase().trim() + '%');

        return prmtDAO.selectLupaList(prmtLupaCriterioVO, new RowBounds(RowBounds.NO_ROW_OFFSET,
                GlobalNames.LUPA_LIMIT_DEFAULT));
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
     *            Criterio de búsqueda de parámetros. Este criterio ha sido el utilizado para obtener la coleccion de
     *            parámetros pasada como argumento.
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
