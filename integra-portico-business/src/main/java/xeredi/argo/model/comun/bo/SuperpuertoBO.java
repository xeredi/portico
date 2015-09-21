package xeredi.argo.model.comun.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.NonNull;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.argo.model.comun.dao.SuperpuertoDAO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.I18nPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.comun.vo.SuperpuertoCriterioVO;
import xeredi.argo.model.comun.vo.SuperpuertoVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class SuperpuertoBO.
 */
public final class SuperpuertoBO {

    /**
     * Select object.
     *
     * @param id
     *            the id
     * @param idioma
     *            the idioma
     * @return the superpuerto vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public SuperpuertoVO select(final @NonNull Long id, final String idioma) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final SuperpuertoDAO sprtDAO = session.getMapper(SuperpuertoDAO.class);
            final SuperpuertoCriterioVO sprtCriterio = new SuperpuertoCriterioVO();

            sprtCriterio.setId(id);
            sprtCriterio.setIdioma(idioma);

            final SuperpuertoVO sprt = sprtDAO.selectObject(sprtCriterio);

            if (sprt == null) {
                throw new InstanceNotFoundException(MessageI18nKey.sprt, sprtCriterio);
            }

            return sprt;
        }
    }

    /**
     * Select object.
     *
     * @param sprtCriterio
     *            the sprt criterio
     * @return the superpuerto vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public SuperpuertoVO selectObject(final @NonNull SuperpuertoCriterioVO sprtCriterio)
            throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final SuperpuertoDAO sprtDAO = session.getMapper(SuperpuertoDAO.class);
            final SuperpuertoVO sprt = sprtDAO.selectObject(sprtCriterio);

            if (sprt == null) {
                throw new InstanceNotFoundException(MessageI18nKey.sprt, sprtCriterio);
            }

            return sprt;
        }
    }

    /**
     * Select list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    public List<SuperpuertoVO> selectList(final @NonNull SuperpuertoCriterioVO criterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final SuperpuertoDAO sprtDAO = session.getMapper(SuperpuertoDAO.class);

            return sprtDAO.selectList(criterio);
        }
    }

    /**
     * Select list.
     *
     * @param criterio
     *            the criterio
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public PaginatedList<SuperpuertoVO> selectList(final @NonNull SuperpuertoCriterioVO criterio, final int offset,
            final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final SuperpuertoDAO sprtDAO = session.getMapper(SuperpuertoDAO.class);
            final int count = sprtDAO.count(criterio);
            final List<SuperpuertoVO> sprtList = new ArrayList<>();

            if (count >= offset) {
                sprtList.addAll(sprtDAO.selectList(criterio, new RowBounds(offset, limit)));
            }

            return new PaginatedList<SuperpuertoVO>(sprtList, offset, limit, count);
        }
    }

    /**
     * Insert.
     *
     * @param sprt
     *            the sprt
     * @param i18nMap
     *            the i18n map
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public void insert(final @NonNull SuperpuertoVO sprt, final @NonNull Map<String, I18nVO> i18nMap)
            throws DuplicateInstanceException {
        Preconditions.checkNotNull(sprt.getCodigo());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final SuperpuertoDAO sprtDAO = session.getMapper(SuperpuertoDAO.class);

            if (sprtDAO.exists(sprt)) {
                throw new DuplicateInstanceException(MessageI18nKey.sprt, sprt);
            }

            final IgBO igBO = new IgBO();

            sprt.setId(igBO.nextVal(IgBO.SQ_INTEGRA));

            sprtDAO.insert(sprt);

            I18nBO.insertMap(session, I18nPrefix.sprt, sprt.getId(), i18nMap);

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param sprt
     *            the sprt
     * @param i18nMap
     *            the i18n map
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void update(final @NonNull SuperpuertoVO sprt, final @NonNull Map<String, I18nVO> i18nMap)
            throws InstanceNotFoundException {
        Preconditions.checkNotNull(sprt.getId());
        Preconditions.checkNotNull(sprt.getCodigo());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final SuperpuertoDAO sprtDAO = session.getMapper(SuperpuertoDAO.class);

            if (!sprtDAO.exists(sprt)) {
                throw new InstanceNotFoundException(MessageI18nKey.sprt, sprt);
            }

            I18nBO.updateMap(session, I18nPrefix.sprt, sprt.getId(), i18nMap);

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param sprt
     *            the sprt
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(final @NonNull SuperpuertoVO sprt) throws InstanceNotFoundException {
        Preconditions.checkNotNull(sprt.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final SuperpuertoDAO sprtDAO = session.getMapper(SuperpuertoDAO.class);

            if (sprtDAO.delete(sprt) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.sprt, sprt);
            }

            I18nBO.deleteMap(session, I18nPrefix.sprt, sprt.getId());

            session.commit();
        }
    }

}
