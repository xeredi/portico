package xeredi.integra.model.maestro.bo;

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
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

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
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * Implementación del servicio de gestión de maestros de la aplicación.
 */
public class ParametroBO {

    /** The prmt dao. */
    ParametroDAO prmtDAO;

    /** The prdt dao. */
    ParametroDatoDAO prdtDAO;

    /** The i18n dao. */
    ParametroI18nDAO p18nDAO;

    /** The sprm dao. */
    SubparametroDAO sprmDAO;

    /** The spdt dao. */
    SubparametroDatoDAO spdtDAO;

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
                if (!prmt.getItdtMap().containsKey(tpdtId) && !prmt.getItdtMap().containsKey(tpdtId.toString())) {
                    final ItemDatoVO itdt = new ItemDatoVO();

                    itdt.setTpdtId(tpdtId);
                    prmt.getItdtMap().put(tpdtId, itdt);
                }
            }
        }

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        prmtDAO = session.getMapper(ParametroDAO.class);
        prdtDAO = session.getMapper(ParametroDatoDAO.class);
        p18nDAO = session.getMapper(ParametroI18nDAO.class);

        try {
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

            session.commit();
        } finally {
            session.close();
        }
    }

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

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        prmtDAO = session.getMapper(ParametroDAO.class);
        prdtDAO = session.getMapper(ParametroDatoDAO.class);
        p18nDAO = session.getMapper(ParametroI18nDAO.class);
        sprmDAO = session.getMapper(SubparametroDAO.class);
        spdtDAO = session.getMapper(SubparametroDatoDAO.class);

        try {
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
                    sprmCriterioVO.setFechaVigencia(prmtActual.getPrvr().getFfin() == null ? Calendar.getInstance()
                            .getTime() : prmtActual.getPrvr().getFfin());

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

            session.commit();
        } finally {
            session.close();
        }
    }

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
        if (tpprVO.getEntdList() != null && !tpprVO.getEntdList().isEmpty()) {
            for (final Long tpdtId : tpprVO.getEntdList()) {
                if (!prmt.getItdtMap().containsKey(tpdtId.toString())) {
                    throw new Error("No se ha pasado informacion del dato "
                            + tpprVO.getEntdMap().get(tpdtId).getTpdt().getNombre() + " del parametro: " + prmt);
                }
            }
        }

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        prmtDAO = session.getMapper(ParametroDAO.class);
        prdtDAO = session.getMapper(ParametroDatoDAO.class);
        p18nDAO = session.getMapper(ParametroI18nDAO.class);

        try {
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

            session.commit();
        } finally {
            session.close();
        }
    }

    /**
     * Delete.
     *
     * @param prmt
     *            the prmt
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public final void delete(final ParametroVO prmt) throws InstanceNotFoundException {
        Preconditions.checkNotNull(prmt);
        Preconditions.checkNotNull(prmt.getPrvr());
        Preconditions.checkNotNull(prmt.getPrvr().getId());

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        prmtDAO = session.getMapper(ParametroDAO.class);
        prdtDAO = session.getMapper(ParametroDatoDAO.class);
        p18nDAO = session.getMapper(ParametroI18nDAO.class);

        try {
            prdtDAO.deleteVersion(prmt);
            p18nDAO.deleteVersion(prmt);

            final int updated = prmtDAO.deleteVersion(prmt);

            if (updated == 0) {
                throw new InstanceNotFoundException(ParametroVO.class.getName(), prmt);
            }

            session.commit();
        } finally {
            session.close();
        }
    }

    /**
     * Select list.
     *
     * @param prmtCriterioVO
     *            the prmt criterio vo
     * @return the list
     */
    public final List<ParametroVO> selectList(final ParametroCriterioVO prmtCriterioVO) {
        Preconditions.checkNotNull(prmtCriterioVO);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        prmtDAO = session.getMapper(ParametroDAO.class);

        try {
            final List<ParametroVO> prmtList = prmtDAO.selectList(prmtCriterioVO);

            fillDependencies(session, prmtList, prmtCriterioVO, false);

            return prmtList;
        } finally {
            session.close();
        }
    }

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
    public final PaginatedList<ParametroVO> selectList(final ParametroCriterioVO prmtCriterioVO, final int offset,
            final int limit) {
        Preconditions.checkNotNull(prmtCriterioVO);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        prmtDAO = session.getMapper(ParametroDAO.class);

        try {
            final List<ParametroVO> prmtList = new ArrayList<>();
            final int count = prmtDAO.count(prmtCriterioVO);

            if (count > offset) {
                prmtCriterioVO.setOffset(offset);
                prmtCriterioVO.setLimit(limit);

                prmtList.addAll(prmtDAO.selectPaginatedList(prmtCriterioVO));
                fillDependencies(session, prmtList, prmtCriterioVO, true);
            }

            return new PaginatedList<>(prmtList, offset, limit, count);
        } finally {
            session.close();
        }
    }

    /**
     * Select map.
     *
     * @param prmtCriterioVO
     *            the prmt criterio vo
     * @return the map
     */
    public final Map<Long, ParametroVO> selectMap(final ParametroCriterioVO prmtCriterioVO) {
        Preconditions.checkNotNull(prmtCriterioVO);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        prmtDAO = session.getMapper(ParametroDAO.class);

        try {
            final Map<Long, ParametroVO> prmtMap = prmtDAO.selectMap(prmtCriterioVO);

            fillDependencies(session, prmtMap.values(), prmtCriterioVO, false);

            return prmtMap;
        } finally {
            session.close();
        }
    }

    /**
     * Select map by codigo.
     *
     * @param prmtCriterioVO
     *            the prmt criterio vo
     * @return the map
     */
    public final Map<String, ParametroVO> selectMapByCodigo(final ParametroCriterioVO prmtCriterioVO) {
        Preconditions.checkNotNull(prmtCriterioVO);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        prmtDAO = session.getMapper(ParametroDAO.class);

        try {
            final Map<String, ParametroVO> prmtMap = prmtDAO.selectMapByCodigo(prmtCriterioVO);

            fillDependencies(session, prmtMap.values(), prmtCriterioVO, false);

            return prmtMap;
        } finally {
            session.close();
        }
    }

    /**
     * Select map codigo id.
     *
     * @param prmtCriterioVO
     *            the prmt criterio vo
     * @return the map
     */
    public final Map<String, Long> selectMapCodigoId(final ParametroCriterioVO prmtCriterioVO) {
        Preconditions.checkNotNull(prmtCriterioVO);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        prmtDAO = session.getMapper(ParametroDAO.class);

        try {
            final Map<String, Long> map = new HashMap<>();

            for (final ParametroVO prmtVO : prmtDAO.selectList(prmtCriterioVO)) {
                map.put(prmtVO.getParametro(), prmtVO.getId());
            }

            return map;
        } finally {
            session.close();
        }
    }

    /**
     * Select map id codigo.
     *
     * @param prmtCriterioVO
     *            the prmt criterio vo
     * @return the map
     */
    public final Map<Long, String> selectMapIdCodigo(final ParametroCriterioVO prmtCriterioVO) {
        Preconditions.checkNotNull(prmtCriterioVO);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        prmtDAO = session.getMapper(ParametroDAO.class);

        try {
            final Map<Long, String> map = new HashMap<>();

            for (final ParametroVO prmtVO : prmtDAO.selectList(prmtCriterioVO)) {
                map.put(prmtVO.getId(), prmtVO.getParametro());
            }

            return map;
        } finally {
            session.close();
        }
    }

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
    public final Map<Long, List<LabelValueVO>> selectLabelValues(final Set<Long> tpprIds, final Date fechaReferencia,
            final String idioma) {
        Preconditions.checkNotNull(tpprIds);
        Preconditions.checkNotNull(fechaReferencia);
        Preconditions.checkNotNull(idioma);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE);

        prmtDAO = session.getMapper(ParametroDAO.class);

        try {
            final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

            prmtCriterioVO.setEntiIds(tpprIds);
            prmtCriterioVO.setIdioma(idioma);
            prmtCriterioVO.setFechaVigencia(fechaReferencia);

            final Map<Long, List<LabelValueVO>> map = new HashMap<>();

            for (final ParametroVO prmtVO : prmtDAO.selectList(prmtCriterioVO)) {
                if (!map.containsKey(prmtVO.getEntiId())) {
                    map.put(prmtVO.getEntiId(), new ArrayList<LabelValueVO>());
                }

                map.get(prmtVO.getEntiId()).add(new LabelValueVO(prmtVO.getEtiqueta(), prmtVO.getId()));
            }

            return map;
        } finally {
            session.close();
        }
    }

    /**
     * Select label values.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the list
     */
    public final List<LabelValueVO> selectLabelValues(final ParametroCriterioVO criterioVO) {
        Preconditions.checkNotNull(criterioVO);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE);

        prmtDAO = session.getMapper(ParametroDAO.class);

        try {
            final List<LabelValueVO> list = new ArrayList<>();

            for (final ParametroVO prmtVO : prmtDAO.selectList(criterioVO)) {
                list.add(new LabelValueVO(prmtVO.getEtiqueta(), prmtVO.getId()));
            }

            return list;
        } finally {
            session.close();
        }
    }

    /**
     * Select object.
     *
     * @param prmtCriterioVO
     *            the prmt criterio vo
     * @return the parametro vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public final ParametroVO selectObject(final ParametroCriterioVO prmtCriterioVO) throws InstanceNotFoundException {
        Preconditions.checkNotNull(prmtCriterioVO);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        prmtDAO = session.getMapper(ParametroDAO.class);

        try {
            final ParametroVO prmtVO = prmtDAO.selectObject(prmtCriterioVO);

            if (prmtVO == null) {
                throw new InstanceNotFoundException(ParametroVO.class.getName(), prmtCriterioVO);
            }

            fillDependencies(session, Arrays.asList(new ParametroVO[] { prmtVO }), prmtCriterioVO, true);

            return prmtVO;
        } finally {
            session.close();
        }
    }

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
    public final ParametroVO select(final Long prmtId, final String idioma, final Date fechaVigencia)
            throws InstanceNotFoundException {
        Preconditions.checkNotNull(prmtId);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        prmtDAO = session.getMapper(ParametroDAO.class);

        try {
            final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

            prmtCriterioVO.setId(prmtId);
            prmtCriterioVO.setIdioma(idioma);
            prmtCriterioVO.setFechaVigencia(fechaVigencia);

            final ParametroVO prmtVO = prmtDAO.selectObject(prmtCriterioVO);

            if (prmtVO == null) {
                throw new InstanceNotFoundException(ParametroVO.class.getName(), prmtCriterioVO);
            }

            fillDependencies(session, Arrays.asList(new ParametroVO[] { prmtVO }), prmtCriterioVO, true);

            return prmtVO;
        } finally {
            session.close();
        }
    }

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
    public ParametroVO select(final Long prvrId, final String idioma) throws InstanceNotFoundException {
        Preconditions.checkNotNull(prvrId);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        prmtDAO = session.getMapper(ParametroDAO.class);

        try {
            final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();
            final Set<Long> prvrIds = new HashSet<>();

            prvrIds.add(prvrId);

            prmtCriterioVO.setPrvrIds(prvrIds);
            prmtCriterioVO.setIdioma(idioma);

            final ParametroVO prmtVO = prmtDAO.selectObject(prmtCriterioVO);

            if (prmtVO == null) {
                throw new InstanceNotFoundException(ParametroVO.class.getName(), prmtCriterioVO);
            }

            fillDependencies(session, Arrays.asList(new ParametroVO[] { prmtVO }), prmtCriterioVO, true);

            return prmtVO;
        } finally {
            session.close();
        }
    }

    /**
     * Select lupa list.
     *
     * @param prmtLupaCriterioVO
     *            the prmt lupa criterio vo
     * @return the list
     */
    public final List<ParametroVO> selectLupaList(final ParametroLupaCriterioVO prmtLupaCriterioVO) {
        Preconditions.checkNotNull(prmtLupaCriterioVO);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        prmtDAO = session.getMapper(ParametroDAO.class);

        try {
            prmtLupaCriterioVO.setTextoBusqueda(prmtLupaCriterioVO.getTextoBusqueda().toUpperCase().trim() + '%');

            return prmtDAO.selectLupaList(prmtLupaCriterioVO, new RowBounds(RowBounds.NO_ROW_OFFSET,
                    GlobalNames.LUPA_LIMIT_DEFAULT));
        } finally {
            session.close();
        }
    }

    /**
     * Select i18n map.
     *
     * @param prvrId
     *            the prvr id
     * @return the map
     */
    public final Map<String, ParametroI18nVO> selectI18nMap(final Long prvrId) {
        Preconditions.checkNotNull(prvrId);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        p18nDAO = session.getMapper(ParametroI18nDAO.class);

        try {
            final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();
            final Set<Long> prvrIds = new HashSet<>();

            prvrIds.add(prvrId);
            prmtCriterioVO.setPrvrIds(prvrIds);

            final Map<String, ParametroI18nVO> p18nMap = new HashMap<>();

            for (final ParametroI18nVO p18nVO : p18nDAO.selectList(prmtCriterioVO)) {
                p18nMap.put(p18nVO.getIdioma(), p18nVO);
            }

            return p18nMap;
        } finally {
            session.close();
        }
    }

    /**
     * Rellenado de los datos asociados a una lista de parametros. Búsqueda en parámetro dato.
     *
     * @param session
     *            the session
     * @param prmtList
     *            Colleccion de parámetros de los que se desea obtener sus datos asociados.
     * @param prmtCriterioVO
     *            Criterio de búsqueda de parámetros. Este criterio ha sido el utilizado para obtener la coleccion de
     *            parámetros pasada como argumento.
     * @param useIds
     *            the use ids
     */
    private void fillDependencies(final SqlSession session, final Collection<ParametroVO> prmtList,
            final ParametroCriterioVO prmtCriterioVO, final boolean useIds) {
        Preconditions.checkNotNull(prmtList);
        Preconditions.checkNotNull(prmtCriterioVO);

        prdtDAO = session.getMapper(ParametroDatoDAO.class);

        if (!prmtList.isEmpty()) {
            if (useIds) {
                final Set<Long> prvrIds = new HashSet<>();

                for (final ParametroVO prmtVO : prmtList) {
                    prvrIds.add(prmtVO.getPrvr().getId());
                }

                prmtCriterioVO.setPrvrIds(prvrIds);
            }

            final Map<Long, Map<Long, ItemDatoVO>> map = new HashMap<>();

            for (final ItemDatoVO itdtVO : prdtDAO.selectList(prmtCriterioVO)) {
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
