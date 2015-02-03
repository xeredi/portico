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

import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.exception.OverlapException;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.maestro.dao.ParametroDAO;
import xeredi.integra.model.maestro.dao.ParametroDatoDAO;
import xeredi.integra.model.maestro.dao.SubparametroDAO;
import xeredi.integra.model.maestro.dao.SubparametroDatoDAO;
import xeredi.integra.model.maestro.vo.ParametroCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroLupaCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.maestro.vo.SubparametroCriterioVO;
import xeredi.integra.model.maestro.vo.SubparametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubparametroProxy;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractParametroBO.
 */
public abstract class AbstractParametroBO {
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
    public final void insert(final ParametroVO prmt, final TipoParametroVO tpprVO, final Map<String, I18nVO> i18nMap)
            throws OverlapException {
        Preconditions.checkNotNull(prmt);
        Preconditions.checkNotNull(prmt.getParametro());
        Preconditions.checkNotNull(prmt.getPrvr());
        Preconditions.checkNotNull(prmt.getPrvr().getFini());
        Preconditions.checkNotNull(tpprVO);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            if (tpprVO.getI18n()) {
                Preconditions.checkNotNull(i18nMap);
            }

            // Validar que los datos del parametro son correctos
            if (tpprVO.getEntdList() != null && !tpprVO.getEntdList().isEmpty()) {
                for (final EntidadTipoDatoVO entd : tpprVO.getEntdList()) {
                    if (!prmt.getItdtMap().containsKey(entd.getTpdt().getId())
                            && !prmt.getItdtMap().containsKey(entd.getTpdt().getId().toString())) {
                        final ItemDatoVO itdt = new ItemDatoVO();

                        itdt.setTpdtId(entd.getTpdt().getId());
                        prmt.getItdtMap().put(entd.getTpdt().getId(), itdt);
                    }
                }
            }

            final ParametroDAO prmtDAO = session.getMapper(ParametroDAO.class);
            final ParametroDatoDAO prdtDAO = session.getMapper(ParametroDatoDAO.class);
            final IgBO igBO = new IgBO();

            if (prmtDAO.exists(prmt)) {
                prmt.setId(prmtDAO.selectId(prmt));
            } else {
                prmt.setId(igBO.nextVal(IgBO.SQ_INTEGRA));

                prmtDAO.insert(prmt);
            }

            prmt.getPrvr().setId(igBO.nextVal(IgBO.SQ_INTEGRA));

            if (prmtDAO.existsOverlap(prmt)) {
                throw new OverlapException(MessageI18nKey.prmt, prmt);
            }

            prmtDAO.insertVersion(prmt);

            if (tpprVO.getI18n()) {
                I18nBO.insertMap(session, I18nPrefix.prvr, prmt.getPrvr().getId(), i18nMap);
            }

            if (prmt.getItdtMap() != null) {
                for (final ItemDatoVO itdtVO : prmt.getItdtMap().values()) {
                    itdtVO.setItemId(prmt.getPrvr().getId());
                    prdtDAO.insert(itdtVO);
                }
            }

            insertPostOperations(session, prmt, tpprVO, i18nMap);

            session.commit();
        }
    }

    /**
     * Insert.
     *
     * @param session
     *            the session
     * @param prmt
     *            the prmt
     * @param tpprVO
     *            the tppr vo
     * @param i18nMap
     *            the i18n map
     */
    protected abstract void insertPostOperations(final SqlSession session, final ParametroVO prmt,
            final TipoParametroVO tpprVO, final Map<String, I18nVO> i18nMap);

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
    public final void duplicate(final ParametroVO prmt, final TipoParametroVO tpprVO, final Map<String, I18nVO> i18nMap)
            throws OverlapException, InstanceNotFoundException {
        Preconditions.checkNotNull(prmt);
        Preconditions.checkNotNull(prmt.getId());
        Preconditions.checkNotNull(prmt.getParametro());
        Preconditions.checkNotNull(prmt.getPrvr());
        Preconditions.checkNotNull(prmt.getPrvr().getFini());
        Preconditions.checkNotNull(tpprVO);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            if (tpprVO.getI18n()) {
                Preconditions.checkNotNull(i18nMap);
            }

            // Validar que los datos del parametro son correctos
            if (tpprVO.getEntdList() != null && !tpprVO.getEntdList().isEmpty()) {
                for (final EntidadTipoDatoVO entd : tpprVO.getEntdList()) {
                    final Long tpdtId = entd.getTpdt().getId();

                    if (!prmt.getItdtMap().containsKey(tpdtId.toString())) {
                        final ItemDatoVO itdt = new ItemDatoVO();

                        itdt.setTpdtId(tpdtId);
                        prmt.getItdtMap().put(tpdtId, itdt);

                        // throw new Error("No se ha pasado informacion del dato "
                        // + tpprVO.getEntdMap().get(tpdtId).getTpdt().getNombre() + " del parametro: " +
                        // prmt);
                    }
                }
            }

            final ParametroDAO prmtDAO = session.getMapper(ParametroDAO.class);
            final ParametroDatoDAO prdtDAO = session.getMapper(ParametroDatoDAO.class);
            final SubparametroDAO sprmDAO = session.getMapper(SubparametroDAO.class);
            final SubparametroDatoDAO spdtDAO = session.getMapper(SubparametroDatoDAO.class);

            final IgBO igBO = new IgBO();

            // Busqueda del parametro a duplicar
            final ParametroCriterioVO prmtCriterio = new ParametroCriterioVO();

            prmtCriterio.setPrvrId(prmt.getPrvr().getId());

            final ParametroVO prmtActual = prmtDAO.selectObject(prmtCriterio);

            if (prmtActual == null) {
                throw new InstanceNotFoundException(MessageI18nKey.prmt, prmt);
            }

            // Alta del nuevo parametro
            if (prmtDAO.exists(prmt)) {
                prmt.setId(prmtDAO.selectId(prmt));
            } else {
                prmt.setId(igBO.nextVal(IgBO.SQ_INTEGRA));

                prmtDAO.insert(prmt);
            }

            prmt.getPrvr().setId(igBO.nextVal(IgBO.SQ_INTEGRA));

            if (prmtDAO.existsOverlap(prmt)) {
                throw new OverlapException(MessageI18nKey.prmt, prmt);
            }

            prmtDAO.insertVersion(prmt);

            if (tpprVO.getI18n()) {
                I18nBO.duplicateMap(session, I18nPrefix.prvr, prmt.getPrvr().getId(), i18nMap);
            }

            if (prmt.getItdtMap() != null) {
                for (final ItemDatoVO itdtVO : prmt.getItdtMap().values()) {
                    itdtVO.setItemId(prmt.getPrvr().getId());

                    prdtDAO.insert(itdtVO);
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
                            sprmVO.setId(igBO.nextVal(IgBO.SQ_INTEGRA));
                            sprmVO.getSpvr().setId(igBO.nextVal(IgBO.SQ_INTEGRA));
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

            duplicatePostOperations(session, prmtActual, tpprVO, i18nMap);

            session.commit();
        }
    }

    /**
     * Duplicate.
     *
     * @param session
     *            the session
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
    protected abstract void duplicatePostOperations(final SqlSession session, final ParametroVO prmt,
            final TipoParametroVO tpprVO, final Map<String, I18nVO> i18nMap) throws OverlapException,
            InstanceNotFoundException;

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
    public final void update(final ParametroVO prmt, final TipoParametroVO tpprVO, final Map<String, I18nVO> i18nMap)
            throws OverlapException, InstanceNotFoundException {
        Preconditions.checkNotNull(prmt);
        Preconditions.checkNotNull(tpprVO);
        Preconditions.checkNotNull(prmt.getPrvr());
        Preconditions.checkNotNull(prmt.getPrvr().getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            if (tpprVO.getI18n()) {
                Preconditions.checkNotNull(i18nMap);
            }

            if (tpprVO.getTempExp()) {
                Preconditions.checkNotNull(prmt.getPrvr().getFini());
            }

            // Validar que los datos del parametro son correctos
            if (tpprVO.getEntdList() != null && !tpprVO.getEntdList().isEmpty()) {
                for (final EntidadTipoDatoVO entd : tpprVO.getEntdList()) {
                    if (!prmt.getItdtMap().containsKey(entd.getTpdt().getId().toString())) {
                        throw new Error("No se ha pasado informacion del dato " + entd.getTpdt().getNombre()
                                + " del parametro: " + prmt);
                    }
                }
            }

            final ParametroDAO prmtDAO = session.getMapper(ParametroDAO.class);
            final ParametroDatoDAO prdtDAO = session.getMapper(ParametroDatoDAO.class);

            if (prmtDAO.existsOverlap(prmt)) {
                throw new OverlapException(MessageI18nKey.prmt, prmt);
            }

            final int updated = prmtDAO.updateVersion(prmt);

            if (updated == 0) {
                throw new InstanceNotFoundException(prmt.getEntiId(), prmt);
            }

            if (tpprVO.getI18n()) {
                I18nBO.updateMap(session, I18nPrefix.prvr, prmt.getPrvr().getId(), i18nMap);
            }

            if (prmt.getItdtMap() != null) {
                for (final ItemDatoVO itdtVO : prmt.getItdtMap().values()) {
                    itdtVO.setItemId(prmt.getPrvr().getId());
                    prdtDAO.update(itdtVO);
                }
            }

            updatePostOperations(session, prmt, tpprVO, i18nMap);

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param session
     *            the session
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
    protected abstract void updatePostOperations(final SqlSession session, final ParametroVO prmt,
            final TipoParametroVO tpprVO, final Map<String, I18nVO> i18nMap) throws OverlapException,
            InstanceNotFoundException;

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

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ParametroDAO prmtDAO = session.getMapper(ParametroDAO.class);
            final ParametroDatoDAO prdtDAO = session.getMapper(ParametroDatoDAO.class);

            prdtDAO.deleteVersion(prmt);

            I18nBO.deleteMap(session, I18nPrefix.prvr, prmt.getPrvr().getId());

            final int updated = prmtDAO.deleteVersion(prmt);

            if (updated == 0) {
                throw new InstanceNotFoundException(prmt.getEntiId(), prmt);
            }

            deletePostOperations(session, prmt);

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param session
     *            the session
     * @param prmt
     *            the prmt
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    protected abstract void deletePostOperations(final SqlSession session, final ParametroVO prmt)
            throws InstanceNotFoundException;

    /**
     * Select list.
     *
     * @param prmtCriterioVO
     *            the prmt criterio vo
     * @return the list
     */
    public final List<ParametroVO> selectList(final ParametroCriterioVO prmtCriterioVO) {
        Preconditions.checkNotNull(prmtCriterioVO);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ParametroDAO prmtDAO = session.getMapper(ParametroDAO.class);
            final List<ParametroVO> prmtList = prmtDAO.selectList(prmtCriterioVO);

            fillDependencies(session, prmtList, prmtCriterioVO, false);

            return prmtList;
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

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ParametroDAO prmtDAO = session.getMapper(ParametroDAO.class);
            final List<ParametroVO> prmtList = new ArrayList<>();
            final int count = prmtDAO.count(prmtCriterioVO);

            if (count > offset) {
                prmtCriterioVO.setOffset(offset);
                prmtCriterioVO.setLimit(limit);

                prmtList.addAll(prmtDAO.selectPaginatedList(prmtCriterioVO));
                fillDependencies(session, prmtList, prmtCriterioVO, true);
            }

            return new PaginatedList<>(prmtList, offset, limit, count);
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

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ParametroDAO prmtDAO = session.getMapper(ParametroDAO.class);
            final Map<Long, ParametroVO> prmtMap = prmtDAO.selectMap(prmtCriterioVO);

            fillDependencies(session, prmtMap.values(), prmtCriterioVO, false);

            return prmtMap;
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

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ParametroDAO prmtDAO = session.getMapper(ParametroDAO.class);
            final Map<String, ParametroVO> prmtMap = prmtDAO.selectMapByCodigo(prmtCriterioVO);

            fillDependencies(session, prmtMap.values(), prmtCriterioVO, false);

            return prmtMap;
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

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ParametroDAO prmtDAO = session.getMapper(ParametroDAO.class);
            final Map<String, Long> map = new HashMap<>();

            for (final ParametroVO prmtVO : prmtDAO.selectList(prmtCriterioVO)) {
                map.put(prmtVO.getParametro(), prmtVO.getId());
            }

            return map;
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

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ParametroDAO prmtDAO = session.getMapper(ParametroDAO.class);
            final Map<Long, String> map = new HashMap<>();

            for (final ParametroVO prmtVO : prmtDAO.selectList(prmtCriterioVO)) {
                map.put(prmtVO.getId(), prmtVO.getParametro());
            }

            return map;
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

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ParametroDAO prmtDAO = session.getMapper(ParametroDAO.class);
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

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ParametroDAO prmtDAO = session.getMapper(ParametroDAO.class);
            final List<LabelValueVO> list = new ArrayList<>();

            for (final ParametroVO prmtVO : prmtDAO.selectList(criterioVO)) {
                list.add(new LabelValueVO(prmtVO.getEtiqueta(), prmtVO.getId()));
            }

            return list;
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

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ParametroDAO prmtDAO = session.getMapper(ParametroDAO.class);
            final ParametroVO prmtVO = prmtDAO.selectObject(prmtCriterioVO);

            if (prmtVO == null) {
                throw new InstanceNotFoundException(MessageI18nKey.prmt, prmtCriterioVO);
            }

            fillDependencies(session, Arrays.asList(new ParametroVO[] { prmtVO }), prmtCriterioVO, true);

            return prmtVO;
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

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ParametroDAO prmtDAO = session.getMapper(ParametroDAO.class);
            final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

            prmtCriterioVO.setId(prmtId);
            prmtCriterioVO.setIdioma(idioma);
            prmtCriterioVO.setFechaVigencia(fechaVigencia);

            final ParametroVO prmtVO = prmtDAO.selectObject(prmtCriterioVO);

            if (prmtVO == null) {
                throw new InstanceNotFoundException(MessageI18nKey.prmt, prmtId);
            }

            fillDependencies(session, Arrays.asList(new ParametroVO[] { prmtVO }), prmtCriterioVO, true);

            return prmtVO;
        }
    }

    /**
     * Select lupa list.
     *
     * @param prmtLupaCriterioVO
     *            the prmt lupa criterio vo
     * @param limit
     *            the limit
     * @return the list
     */
    public final List<ParametroVO> selectLupaList(final ParametroLupaCriterioVO prmtLupaCriterioVO, final int limit) {
        Preconditions.checkNotNull(prmtLupaCriterioVO);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            prmtLupaCriterioVO.setTextoBusqueda(prmtLupaCriterioVO.getTextoBusqueda().toUpperCase().trim() + '%');

            final ParametroDAO prmtDAO = session.getMapper(ParametroDAO.class);

            return prmtDAO.selectLupaList(prmtLupaCriterioVO, new RowBounds(RowBounds.NO_ROW_OFFSET, limit));
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
     *            Criterio de búsqueda de parámetros. Este criterio ha sido el utilizado para obtener la
     *            coleccion de parámetros pasada como argumento.
     * @param useIds
     *            the use ids
     */
    private void fillDependencies(final SqlSession session, final Collection<ParametroVO> prmtList,
            final ParametroCriterioVO prmtCriterioVO, final boolean useIds) {
        Preconditions.checkNotNull(prmtList);
        Preconditions.checkNotNull(prmtCriterioVO);

        final ParametroDatoDAO prdtDAO = session.getMapper(ParametroDatoDAO.class);

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

                itdtVO.setItemId(null);
                itdtVO.setTpdtId(null);
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
