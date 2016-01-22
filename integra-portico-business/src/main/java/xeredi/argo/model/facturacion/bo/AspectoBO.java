package xeredi.argo.model.facturacion.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import lombok.NonNull;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.argo.model.comun.bo.I18nBO;
import xeredi.argo.model.comun.bo.IgBO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.OverlapException;
import xeredi.argo.model.comun.vo.I18nPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.dao.AspectoDAO;
import xeredi.argo.model.facturacion.vo.AspectoCriterioVO;
import xeredi.argo.model.facturacion.vo.AspectoVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoBO.
 */
public final class AspectoBO {
    /**
     * Select list.
     *
     * @param aspcCriterioVO
     *            the aspc criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public PaginatedList<AspectoVO> selectList(final AspectoCriterioVO aspcCriterioVO, final int offset, final int limit) {
        Preconditions.checkNotNull(aspcCriterioVO);
        Preconditions.checkArgument(offset >= 0);
        Preconditions.checkArgument(limit > 0);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AspectoDAO aspcDAO = session.getMapper(AspectoDAO.class);
            final int count = aspcDAO.count(aspcCriterioVO);
            final List<AspectoVO> aspcList = new ArrayList<>();

            if (count >= offset) {
                aspcList.addAll(aspcDAO.selectList(aspcCriterioVO, new RowBounds(offset, limit)));
            }

            return new PaginatedList<AspectoVO>(aspcList, offset, limit, count);
        }
    }

    /**
     * Select list.
     *
     * @param aspcCriterioVO
     *            the aspc criterio vo
     * @return the list
     */
    public List<AspectoVO> selectList(final AspectoCriterioVO aspcCriterioVO) {
        Preconditions.checkNotNull(aspcCriterioVO);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AspectoDAO aspcDAO = session.getMapper(AspectoDAO.class);

            return aspcDAO.selectList(aspcCriterioVO);
        }
    }

    /**
     * Select label value list.
     *
     * @param criterio
     *            the criterio
     * @param limit
     *            the limit
     * @return the list
     */
    public List<AspectoVO> selectList(final AspectoCriterioVO criterio, final int limit) {
        Preconditions.checkNotNull(criterio);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AspectoDAO aspcDAO = session.getMapper(AspectoDAO.class);

            return aspcDAO.selectList(criterio, new RowBounds(PaginatedList.MIN_OFFSET, limit));
        }
    }

    /**
     * Select.
     *
     * @param aspcCriterio
     *            the aspc criterio
     * @return the aspecto vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public AspectoVO selectObject(final AspectoCriterioVO aspcCriterio) throws InstanceNotFoundException {
        Preconditions.checkNotNull(aspcCriterio);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AspectoDAO aspcDAO = session.getMapper(AspectoDAO.class);
            final AspectoVO aspc = aspcDAO.selectObject(aspcCriterio);

            if (aspc == null) {
                throw new InstanceNotFoundException(MessageI18nKey.aspc, aspcCriterio);
            }

            return aspc;
        }
    }

    public AspectoVO select(final @NonNull Long id, final @NonNull Date fref, final String idioma)
            throws InstanceNotFoundException {
        final AspectoCriterioVO aspcCriterio = new AspectoCriterioVO();

        aspcCriterio.setId(id);
        aspcCriterio.setFechaVigencia(fref);
        aspcCriterio.setIdioma(idioma);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AspectoDAO aspcDAO = session.getMapper(AspectoDAO.class);
            final AspectoVO aspc = aspcDAO.selectObject(aspcCriterio);

            if (aspc == null) {
                throw new InstanceNotFoundException(MessageI18nKey.aspc, id, fref);
            }

            return aspc;
        }
    }

    /**
     * Insert.
     *
     * @param aspc
     *            the aspc
     * @param i18nMap
     *            the i18n map
     * @throws OverlapException
     *             the overlap exception
     */
    public void insert(final AspectoVO aspc, final Map<String, I18nVO> i18nMap) throws OverlapException {
        Preconditions.checkNotNull(aspc);
        Preconditions.checkNotNull(aspc.getVersion());
        Preconditions.checkNotNull(aspc.getVersion().getFini());
        Preconditions.checkNotNull(aspc.getTpsr());
        Preconditions.checkNotNull(aspc.getTpsr().getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final AspectoDAO aspcDAO = session.getMapper(AspectoDAO.class);
            final IgBO igBO = new IgBO();

            if (aspcDAO.exists(aspc)) {
                aspc.setId(aspcDAO.selectId(aspc));

                if (aspcDAO.existsOverlap(aspc)) {
                    throw new OverlapException(MessageI18nKey.aspc, aspc);
                }
            } else {
                aspc.setId(igBO.nextVal(IgBO.SQ_INTEGRA));

                aspcDAO.insert(aspc);
            }

            aspc.getVersion().setId(igBO.nextVal(IgBO.SQ_INTEGRA));

            aspcDAO.insertVersion(aspc);

            I18nBO.insertMap(session, I18nPrefix.aspv, aspc.getVersion().getId(), i18nMap);

            session.commit();
        }
    }

    /**
     * Duplicate.
     *
     * @param aspc
     *            the aspc
     * @param i18nMap
     *            the i18n map
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public void duplicate(final AspectoVO aspc, final Map<String, I18nVO> i18nMap) throws DuplicateInstanceException {
        Preconditions.checkNotNull(aspc);
        Preconditions.checkNotNull(aspc.getVersion());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final AspectoDAO aspcDAO = session.getMapper(AspectoDAO.class);

            if (aspcDAO.exists(aspc)) {
                throw new DuplicateInstanceException(MessageI18nKey.aspc, aspc);
            }

            final IgBO igBO = new IgBO();

            aspc.setId(igBO.nextVal(IgBO.SQ_INTEGRA));
            aspc.getVersion().setId(igBO.nextVal(IgBO.SQ_INTEGRA));

            aspcDAO.insert(aspc);
            aspcDAO.insertVersion(aspc);

            I18nBO.insertMap(session, I18nPrefix.aspv, aspc.getVersion().getId(), i18nMap);

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param aspc
     *            the aspc
     * @param i18nMap
     *            the i18n map
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OverlapException
     *             the overlap exception
     */
    public void update(final AspectoVO aspc, final Map<String, I18nVO> i18nMap) throws InstanceNotFoundException,
    OverlapException {
        Preconditions.checkNotNull(aspc);
        Preconditions.checkNotNull(aspc.getVersion());
        Preconditions.checkNotNull(aspc.getId());
        Preconditions.checkNotNull(aspc.getVersion().getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final AspectoDAO aspcDAO = session.getMapper(AspectoDAO.class);

            if (aspcDAO.existsOverlap(aspc)) {
                throw new OverlapException(MessageI18nKey.aspc, aspc);
            }

            final int updated = aspcDAO.updateVersion(aspc);

            if (updated == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.aspc, aspc);
            }

            I18nBO.updateMap(session, I18nPrefix.aspv, aspc.getVersion().getId(), i18nMap);

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param aspc
     *            the aspc
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(final AspectoVO aspc) throws InstanceNotFoundException {
        Preconditions.checkNotNull(aspc.getVersion());
        Preconditions.checkNotNull(aspc.getVersion().getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AspectoDAO aspcDAO = session.getMapper(AspectoDAO.class);

            I18nBO.deleteMap(session, I18nPrefix.aspv, aspc.getVersion().getId());

            if (aspcDAO.deleteVersion(aspc) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.aspc, aspc);
            }

            session.commit();
        }
    }
}
