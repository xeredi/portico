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

import javax.annotation.Nonnull;

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
import xeredi.integra.model.maestro.vo.ParametroTypeaheadCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.maestro.vo.SubparametroCriterioVO;
import xeredi.integra.model.maestro.vo.SubparametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoParametroDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubparametroDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubparametroProxy;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractParametroBO.
 */
public abstract class AbstractParametroBO implements ParametroBO {
    /**
     * {@inheritDoc}
     */
    @Override
    public final void insert(final @Nonnull ParametroVO prmt, final @Nonnull TipoParametroDetailVO tpprDetail,
            final Map<String, I18nVO> i18nMap) throws OverlapException {
        Preconditions.checkNotNull(prmt.getParametro());
        Preconditions.checkNotNull(prmt.getVersion());
        Preconditions.checkNotNull(prmt.getVersion().getFini());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            if (tpprDetail.getEnti().isI18n()) {
                Preconditions.checkNotNull(i18nMap);
            }

            // Validar que los datos del parametro son correctos
            if (tpprDetail.getEntdList() != null && !tpprDetail.getEntdList().isEmpty()) {
                for (final EntidadTipoDatoVO entd : tpprDetail.getEntdList()) {
                    if (!prmt.getItdtMap().containsKey(entd.getTpdt().getId())) {
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

            prmt.getVersion().setId(igBO.nextVal(IgBO.SQ_INTEGRA));

            if (prmtDAO.existsOverlap(prmt)) {
                throw new OverlapException(MessageI18nKey.prmt, prmt);
            }

            prmtDAO.insertVersion(prmt);

            if (tpprDetail.getEnti().isI18n()) {
                I18nBO.insertMap(session, I18nPrefix.prvr, prmt.getVersion().getId(), i18nMap);
            }

            if (prmt.getItdtMap() != null) {
                for (final ItemDatoVO itdtVO : prmt.getItdtMap().values()) {
                    itdtVO.setItemId(prmt.getVersion().getId());
                    prdtDAO.insert(itdtVO);
                }
            }

            insertPostOperations(session, prmt, tpprDetail, i18nMap);

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
    protected abstract void insertPostOperations(final @Nonnull SqlSession session, final @Nonnull ParametroVO prmt,
            final @Nonnull TipoParametroDetailVO tpprDetail, final Map<String, I18nVO> i18nMap);

    /**
     * {@inheritDoc}
     */
    @Override
    public final void duplicate(final @Nonnull ParametroVO prmt, final @Nonnull TipoParametroDetailVO tpprDetail,
            final Map<String, I18nVO> i18nMap) throws OverlapException, InstanceNotFoundException {
        Preconditions.checkNotNull(prmt.getId());
        Preconditions.checkNotNull(prmt.getParametro());
        Preconditions.checkNotNull(prmt.getVersion());
        Preconditions.checkNotNull(prmt.getVersion().getFini());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            if (tpprDetail.getEnti().isI18n()) {
                Preconditions.checkNotNull(i18nMap);
            }

            // Validar que los datos del parametro son correctos
            if (tpprDetail.getEntdList() != null && !tpprDetail.getEntdList().isEmpty()) {
                for (final EntidadTipoDatoVO entd : tpprDetail.getEntdList()) {
                    final Long tpdtId = entd.getTpdt().getId();

                    if (!prmt.getItdtMap().containsKey(tpdtId)) {
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

            prmtCriterio.setVersionId(prmt.getVersion().getId());

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

            prmt.getVersion().setId(igBO.nextVal(IgBO.SQ_INTEGRA));

            if (prmtDAO.existsOverlap(prmt)) {
                throw new OverlapException(MessageI18nKey.prmt, prmt);
            }

            prmtDAO.insertVersion(prmt);

            if (tpprDetail.getEnti().isI18n()) {
                I18nBO.duplicateMap(session, I18nPrefix.prvr, prmt.getVersion().getId(), i18nMap);
            }

            if (prmt.getItdtMap() != null) {
                for (final ItemDatoVO itdtVO : prmt.getItdtMap().values()) {
                    itdtVO.setItemId(prmt.getVersion().getId());

                    prdtDAO.insert(itdtVO);
                }
            }

            if (!prmtActual.getId().equals(prmt.getId())) {
                // Duplicado de subparametros

                if (tpprDetail.getEntiHijasList() != null && !tpprDetail.getEntiHijasList().isEmpty()) {
                    final SubparametroCriterioVO sprmCriterioVO = new SubparametroCriterioVO();
                    final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

                    prmtCriterioVO.setId(prmtActual.getId());
                    sprmCriterioVO.setPrmt(prmtCriterioVO);
                    sprmCriterioVO.setFechaVigencia(prmtActual.getVersion().getFfin() == null ? Calendar.getInstance()
                            .getTime() : prmtActual.getVersion().getFfin());

                    final List<SubparametroVO> sprmList = sprmDAO.selectList(sprmCriterioVO);
                    final Map<Long, SubparametroVO> sprmMap = new HashMap<>();
                    final Set<Long> spvrIds = new HashSet<>();

                    for (final SubparametroVO sprmVO : sprmList) {
                        final TipoSubparametroDetailVO tpspDetail = TipoSubparametroProxy.select(sprmVO.getEntiId());

                        if (tpspDetail.getEnti().isCmdDuplicado()) {
                            sprmMap.put(sprmVO.getVersion().getId(), sprmVO);
                            spvrIds.add(sprmVO.getVersion().getId());
                        }
                    }

                    if (!spvrIds.isEmpty()) {
                        sprmCriterioVO.setVersionIds(spvrIds);

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
                            sprmVO.getVersion().setId(igBO.nextVal(IgBO.SQ_INTEGRA));
                            sprmVO.getVersion().setFini(prmt.getVersion().getFini());
                            sprmVO.getVersion().setFfin(prmt.getVersion().getFfin());

                            if (sprmVO.getItdtMap() != null) {
                                for (final ItemDatoVO itdtVO : sprmVO.getItdtMap().values()) {
                                    itdtVO.setItemId(sprmVO.getVersion().getId());
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

            duplicatePostOperations(session, prmtActual, tpprDetail, i18nMap);

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
    protected abstract void duplicatePostOperations(final @Nonnull SqlSession session, final @Nonnull ParametroVO prmt,
            final @Nonnull TipoParametroDetailVO tpprDetail, final Map<String, I18nVO> i18nMap)
            throws OverlapException, InstanceNotFoundException;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void update(final @Nonnull ParametroVO prmt, final @Nonnull TipoParametroDetailVO tpprDetail,
            final Map<String, I18nVO> i18nMap) throws OverlapException, InstanceNotFoundException {
        Preconditions.checkNotNull(prmt.getVersion());
        Preconditions.checkNotNull(prmt.getVersion().getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            if (tpprDetail.getEnti().isI18n()) {
                Preconditions.checkNotNull(i18nMap);
            }

            if (tpprDetail.getEnti().isTempExp()) {
                Preconditions.checkNotNull(prmt.getVersion().getFini());
            }

            // Validar que los datos del parametro son correctos
            if (tpprDetail.getEntdList() != null && !tpprDetail.getEntdList().isEmpty()) {
                for (final EntidadTipoDatoVO entd : tpprDetail.getEntdList()) {
                    if (!prmt.getItdtMap().containsKey(entd.getTpdt().getId())) {
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

            if (prmtDAO.updateVersion(prmt) == 0) {
                throw new InstanceNotFoundException(prmt.getEntiId(), prmt);
            }

            if (tpprDetail.getEnti().isI18n()) {
                I18nBO.updateMap(session, I18nPrefix.prvr, prmt.getVersion().getId(), i18nMap);
            }

            if (prmt.getItdtMap() != null) {
                for (final ItemDatoVO itdtVO : prmt.getItdtMap().values()) {
                    itdtVO.setItemId(prmt.getVersion().getId());
                    prdtDAO.update(itdtVO);
                }
            }

            updatePostOperations(session, prmt, tpprDetail, i18nMap);

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
    protected abstract void updatePostOperations(final @Nonnull SqlSession session, final @Nonnull ParametroVO prmt,
            final @Nonnull TipoParametroDetailVO tpprDetail, final Map<String, I18nVO> i18nMap)
            throws OverlapException, InstanceNotFoundException;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void delete(final @Nonnull ParametroVO prmt) throws InstanceNotFoundException {
        Preconditions.checkNotNull(prmt.getVersion());
        Preconditions.checkNotNull(prmt.getVersion().getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ParametroDAO prmtDAO = session.getMapper(ParametroDAO.class);
            final ParametroDatoDAO prdtDAO = session.getMapper(ParametroDatoDAO.class);

            prdtDAO.deleteVersion(prmt);

            I18nBO.deleteMap(session, I18nPrefix.prvr, prmt.getVersion().getId());

            if (prmtDAO.deleteVersion(prmt) == 0) {
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
    protected abstract void deletePostOperations(final @Nonnull SqlSession session, final @Nonnull ParametroVO prmt)
            throws InstanceNotFoundException;

    /**
     * {@inheritDoc}
     */
    @Override
    public final List<ParametroVO> selectList(final @Nonnull ParametroCriterioVO prmtCriterioVO) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ParametroDAO prmtDAO = session.getMapper(ParametroDAO.class);
            final List<ParametroVO> prmtList = prmtDAO.selectList(prmtCriterioVO);

            fillDependencies(session, prmtList, prmtCriterioVO, false);

            return prmtList;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final PaginatedList<ParametroVO> selectList(final @Nonnull ParametroCriterioVO prmtCriterioVO,
            final int offset, final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ParametroDAO prmtDAO = session.getMapper(ParametroDAO.class);
            final List<ParametroVO> prmtList = new ArrayList<>();
            final int count = prmtDAO.count(prmtCriterioVO);

            if (count > offset) {
                prmtList.addAll(prmtDAO.selectList(prmtCriterioVO, new RowBounds(offset, limit)));

                fillDependencies(session, prmtList, prmtCriterioVO, true);
            }

            return new PaginatedList<>(prmtList, offset, limit, count);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final Map<Long, ParametroVO> selectMap(final @Nonnull ParametroCriterioVO prmtCriterioVO) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ParametroDAO prmtDAO = session.getMapper(ParametroDAO.class);
            final Map<Long, ParametroVO> prmtMap = prmtDAO.selectMap(prmtCriterioVO);

            fillDependencies(session, prmtMap.values(), prmtCriterioVO, false);

            return prmtMap;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final Map<String, ParametroVO> selectMapByCodigo(final @Nonnull ParametroCriterioVO prmtCriterioVO) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ParametroDAO prmtDAO = session.getMapper(ParametroDAO.class);
            final Map<String, ParametroVO> prmtMap = prmtDAO.selectMapByCodigo(prmtCriterioVO);

            fillDependencies(session, prmtMap.values(), prmtCriterioVO, false);

            return prmtMap;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final Map<String, Long> selectMapCodigoId(final @Nonnull ParametroCriterioVO prmtCriterioVO) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ParametroDAO prmtDAO = session.getMapper(ParametroDAO.class);
            final Map<String, Long> map = new HashMap<>();

            for (final ParametroVO prmtVO : prmtDAO.selectList(prmtCriterioVO)) {
                final StringBuffer code = new StringBuffer();

                if (prmtVO.getPrto() != null) {
                    code.append(prmtVO.getPrto().getCodigoCorto());
                }

                code.append(prmtVO.getParametro());

                map.put(code.toString(), prmtVO.getId());
            }

            return map;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final Map<Long, String> selectMapIdCodigo(final @Nonnull ParametroCriterioVO prmtCriterioVO) {
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
     * {@inheritDoc}
     */
    @Override
    public final Map<Long, List<LabelValueVO>> selectLabelValues(final @Nonnull Set<Long> tpprIds,
            final @Nonnull Date fechaReferencia, final @Nonnull String idioma) {
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
     * {@inheritDoc}
     */
    @Override
    public final List<LabelValueVO> selectLabelValues(final @Nonnull ParametroCriterioVO criterioVO) {
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
     * {@inheritDoc}
     */
    @Override
    public final ParametroVO selectObject(final @Nonnull ParametroCriterioVO prmtCriterioVO)
            throws InstanceNotFoundException {
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
     * {@inheritDoc}
     */
    @Override
    public final ParametroVO select(final @Nonnull Long prmtId, final String idioma, final Date fechaVigencia)
            throws InstanceNotFoundException {
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
     * {@inheritDoc}
     */
    @Override
    public final List<ParametroVO> selectLupaList(final @Nonnull ParametroTypeaheadCriterioVO criterio, final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ParametroDAO prmtDAO = session.getMapper(ParametroDAO.class);

            return prmtDAO.selectLupaList(criterio, new RowBounds(RowBounds.NO_ROW_OFFSET, limit));
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
    private void fillDependencies(final @Nonnull SqlSession session, final @Nonnull Collection<ParametroVO> prmtList,
            final @Nonnull ParametroCriterioVO prmtCriterioVO, final boolean useIds) {
        final ParametroDatoDAO prdtDAO = session.getMapper(ParametroDatoDAO.class);

        if (!prmtList.isEmpty()) {
            if (useIds) {
                final Set<Long> prvrIds = new HashSet<>();

                for (final ParametroVO prmtVO : prmtList) {
                    prvrIds.add(prmtVO.getVersion().getId());
                }

                prmtCriterioVO.setVersionIds(prvrIds);
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
                prmtVO.setItdtMap(map.get(prmtVO.getVersion().getId()));
            }

            if (useIds) {
                prmtCriterioVO.setVersionIds(null);
            }
        }
    }
}
