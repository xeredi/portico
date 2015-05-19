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
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.exception.OverlapException;
import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.maestro.dao.SubparametroDAO;
import xeredi.integra.model.maestro.dao.SubparametroDatoDAO;
import xeredi.integra.model.maestro.vo.SubparametroCriterioVO;
import xeredi.integra.model.maestro.vo.SubparametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubparametroDetailVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class SubparametroBO.
 */
public class SubparametroBO {

    /**
     * Insert.
     *
     * @param sprm
     *            the sprm
     * @param tpspDetail
     *            the tpsp detail
     * @throws OverlapException
     *             the overlap exception
     */
    public void insert(final SubparametroVO sprm, final TipoSubparametroDetailVO tpspDetail) throws OverlapException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            insert(session, sprm, tpspDetail);

            session.commit();
        }
    }

    /**
     * Insert.
     *
     * @param session
     *            the session
     * @param sprm
     *            the sprm
     * @param tpspDetail
     *            the tpsp detail
     * @throws OverlapException
     *             the overlap exception
     */
    protected final void insert(final SqlSession session, final SubparametroVO sprm,
            final TipoSubparametroDetailVO tpspDetail) throws OverlapException {
        Preconditions.checkNotNull(sprm.getVersion());

        // Validar que los datos del subparametro son correctos
        if (tpspDetail.getEntdList() != null) {
            for (final Long tpdtId : tpspDetail.getEntdList()) {
                if (!sprm.getItdtMap().containsKey(tpdtId)) {
                    final ItemDatoVO itdt = new ItemDatoVO();

                    itdt.setTpdtId(tpdtId);
                    sprm.getItdtMap().put(tpdtId, itdt);
                }
            }
        }

        final SubparametroDAO sprmDAO = session.getMapper(SubparametroDAO.class);
        final SubparametroDatoDAO spdtDAO = session.getMapper(SubparametroDatoDAO.class);
        final IgBO igBO = new IgBO();

        if (sprmDAO.exists(sprm)) {
            sprm.setId(sprmDAO.selectId(sprm));
        } else {
            sprm.setId(igBO.nextVal(IgBO.SQ_INTEGRA));

            sprmDAO.insert(sprm);
        }

        sprm.getVersion().setId(igBO.nextVal(IgBO.SQ_INTEGRA));

        if (sprmDAO.existsOverlap(sprm)) {
            throw new OverlapException(sprm.getEntiId(), sprm);
        }

        sprmDAO.insertVersion(sprm);

        if (sprm.getItdtMap() != null) {
            for (final ItemDatoVO itdtVO : sprm.getItdtMap().values()) {
                itdtVO.setItemId(sprm.getVersion().getId());
                spdtDAO.insert(itdtVO);
            }
        }
    }

    /**
     * Duplicate.
     *
     * @param sprm
     *            the sprm
     * @param tpspDetail
     *            the tpsp detail
     * @throws OverlapException
     *             the overlap exception
     */
    public void duplicate(final SubparametroVO sprm, final TipoSubparametroDetailVO tpspDetail) throws OverlapException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            duplicate(session, sprm, tpspDetail);

            session.commit();
        }
    }

    /**
     * Duplicate.
     *
     * @param session
     *            the session
     * @param sprm
     *            the sprm
     * @param tpspDetail
     *            the tpsp detail
     * @throws OverlapException
     *             the overlap exception
     */
    protected final void duplicate(final SqlSession session, final SubparametroVO sprm,
            final TipoSubparametroDetailVO tpspDetail) throws OverlapException {
        // TODO Implementar
        Preconditions.checkNotNull(sprm.getId());

        final SubparametroDAO sprmDAO = session.getMapper(SubparametroDAO.class);
        final SubparametroDatoDAO spdtDAO = session.getMapper(SubparametroDatoDAO.class);
        final IgBO igBO = new IgBO();

        if (sprmDAO.exists(sprm)) {
            sprm.setId(sprmDAO.selectId(sprm));
        } else {
            sprm.setId(igBO.nextVal(IgBO.SQ_INTEGRA));

            sprmDAO.insert(sprm);
        }

        sprm.getVersion().setId(igBO.nextVal(IgBO.SQ_INTEGRA));

        if (sprmDAO.existsOverlap(sprm)) {
            throw new OverlapException(sprm.getEntiId(), sprm);
        }

        sprmDAO.insertVersion(sprm);

        if (sprm.getItdtMap() != null) {
            for (final ItemDatoVO itdtVO : sprm.getItdtMap().values()) {
                itdtVO.setItemId(sprm.getVersion().getId());
                spdtDAO.insert(itdtVO);
            }
        }
    }

    /**
     * Update.
     *
     * @param sprm
     *            the sprm
     * @param tpspDetail
     *            the tpsp detail
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OverlapException
     *             the overlap exception
     */
    public void update(final SubparametroVO sprm, final TipoSubparametroDetailVO tpspDetail)
            throws InstanceNotFoundException, OverlapException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            update(session, sprm, tpspDetail);

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param session
     *            the session
     * @param sprm
     *            the sprm
     * @param tpspDetail
     *            the tpsp detail
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OverlapException
     *             the overlap exception
     */
    protected final void update(final SqlSession session, final SubparametroVO sprm,
            final TipoSubparametroDetailVO tpspDetail) throws InstanceNotFoundException, OverlapException {
        Preconditions.checkNotNull(sprm.getVersion());
        Preconditions.checkNotNull(sprm.getVersion().getId());
        Preconditions.checkNotNull(sprm.getVersion().getFini());

        // Validaciones

        // Validar que los datos del parametro son correctos
        if (tpspDetail.getEntdList() != null) {
            for (final Long tpdtId : tpspDetail.getEntdList()) {
                if (!sprm.getItdtMap().containsKey(tpdtId)) {
                    final ItemDatoVO itdt = new ItemDatoVO();

                    itdt.setTpdtId(tpdtId);
                    sprm.getItdtMap().put(tpdtId, itdt);

                    // throw new Error("No se ha pasado informacion del dato "
                    // + tpspVO.getEntdMap().get(tpdtId).getTpdt().getNombre() + " del subparametro: " +
                    // sprm);
                }
            }
        }

        final SubparametroDAO sprmDAO = session.getMapper(SubparametroDAO.class);
        final SubparametroDatoDAO spdtDAO = session.getMapper(SubparametroDatoDAO.class);

        if (sprmDAO.existsOverlap(sprm)) {
            throw new OverlapException(sprm.getEntiId(), sprm);
        }

        final int updated = sprmDAO.updateVersion(sprm);

        if (updated == 0) {
            throw new InstanceNotFoundException(sprm.getEntiId(), sprm);
        }

        if (sprm.getItdtMap() != null) {
            for (final ItemDatoVO itdtVO : sprm.getItdtMap().values()) {
                itdtVO.setItemId(sprm.getVersion().getId());
                spdtDAO.update(itdtVO);
            }
        }
    }

    /**
     * Delete.
     *
     * @param sprm
     *            the sprm
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public final void delete(final SubparametroVO sprm) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            delete(session, sprm);

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param session
     *            the session
     * @param sprm
     *            the sprm
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    protected final void delete(final SqlSession session, final SubparametroVO sprm) throws InstanceNotFoundException {
        Preconditions.checkNotNull(sprm.getVersion());
        Preconditions.checkNotNull(sprm.getVersion().getId());

        final SubparametroDAO sprmDAO = session.getMapper(SubparametroDAO.class);
        final SubparametroDatoDAO spdtDAO = session.getMapper(SubparametroDatoDAO.class);

        spdtDAO.deleteVersion(sprm);

        final int updated = sprmDAO.deleteVersion(sprm);

        if (updated == 0) {
            throw new InstanceNotFoundException(MessageI18nKey.sprm, sprm);
        }
    }

    /**
     * Select list.
     *
     * @param sprmCriterioVO
     *            the sprm criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public final PaginatedList<SubparametroVO> selectList(final SubparametroCriterioVO sprmCriterioVO,
            final int offset, final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final SubparametroDAO sprmDAO = session.getMapper(SubparametroDAO.class);
            final List<SubparametroVO> sprmList = new ArrayList<>();
            final int count = sprmDAO.count(sprmCriterioVO);

            if (count > offset) {
                sprmList.addAll(sprmDAO.selectList(sprmCriterioVO, new RowBounds(offset, limit)));

                fillDependencies(session, sprmList, sprmCriterioVO);
            }

            return new PaginatedList<>(sprmList, offset, limit, count);
        }
    }

    /**
     * Select list.
     *
     * @param sprmCriterioVO
     *            the sprm criterio vo
     * @return the list
     */
    public final List<SubparametroVO> selectList(final SubparametroCriterioVO sprmCriterioVO) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final SubparametroDAO sprmDAO = session.getMapper(SubparametroDAO.class);
            final List<SubparametroVO> sprmList = sprmDAO.selectList(sprmCriterioVO);

            if (!sprmList.isEmpty()) {
                fillDependencies(session, sprmList, sprmCriterioVO);
            }

            return sprmList;
        }
    }

    /**
     * Select object.
     *
     * @param sprmId
     *            the sprm id
     * @param idioma
     *            the idioma
     * @param fechaVigencia
     *            the fecha vigencia
     * @return the subparametro vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public final SubparametroVO selectObject(final Long sprmId, final String idioma, final Date fechaVigencia)
            throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final SubparametroDAO sprmDAO = session.getMapper(SubparametroDAO.class);
            final SubparametroCriterioVO sprmCriterioVO = new SubparametroCriterioVO();

            sprmCriterioVO.setId(sprmId);
            sprmCriterioVO.setIdioma(idioma);
            sprmCriterioVO.setFechaVigencia(fechaVigencia);

            final SubparametroVO sprmVO = sprmDAO.selectObject(sprmCriterioVO);

            if (sprmVO == null) {
                throw new InstanceNotFoundException(MessageI18nKey.sprm, sprmId);
            }

            fillDependencies(session, Arrays.asList(new SubparametroVO[] { sprmVO }), sprmCriterioVO);

            return sprmVO;
        }
    }

    /**
     * Fill dependencies.
     *
     * @param session
     *            the session
     * @param sprmList
     *            the sprm list
     * @param sprmCriterioVO
     *            the sprm criterio vo
     */
    private void fillDependencies(final SqlSession session, final Collection<SubparametroVO> sprmList,
            final SubparametroCriterioVO sprmCriterioVO) {
        final SubparametroDatoDAO spdtDAO = session.getMapper(SubparametroDatoDAO.class);

        if (!sprmList.isEmpty()) {
            final Set<Long> spvrIds = new HashSet<>();

            for (final SubparametroVO sprmVO : sprmList) {
                spvrIds.add(sprmVO.getVersion().getId());
            }

            sprmCriterioVO.setVersionIds(spvrIds);

            final Map<Long, Map<Long, ItemDatoVO>> map = new HashMap<>();

            for (final ItemDatoVO itdtVO : spdtDAO.selectList(sprmCriterioVO)) {
                if (!map.containsKey(itdtVO.getItemId())) {
                    map.put(itdtVO.getItemId(), new HashMap<Long, ItemDatoVO>());
                }

                map.get(itdtVO.getItemId()).put(itdtVO.getTpdtId(), itdtVO);

                itdtVO.setItemId(null);
                itdtVO.setTpdtId(null);
            }

            for (final SubparametroVO sprmVO : sprmList) {
                sprmVO.setItdtMap(map.get(sprmVO.getVersion().getId()));
            }

            sprmCriterioVO.setVersionIds(null);
        }
    }
}
