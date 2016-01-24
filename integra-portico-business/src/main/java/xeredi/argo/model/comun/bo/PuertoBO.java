package xeredi.argo.model.comun.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.NonNull;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.argo.model.comun.dao.PuertoDAO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.I18nPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class PuertoBO.
 */
public final class PuertoBO {

    /**
     * Select.
     *
     * @param id
     *            the id
     * @param idioma
     *            the idioma
     * @return the puerto vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public PuertoVO select(final @NonNull Long id, final String idioma) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final PuertoDAO prtoDAO = session.getMapper(PuertoDAO.class);
            final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

            prtoCriterio.setId(id);
            prtoCriterio.setIdioma(idioma);

            final PuertoVO prto = prtoDAO.selectObject(prtoCriterio);

            if (prto == null) {
                throw new InstanceNotFoundException(MessageI18nKey.prto, id);
            }

            return prto;
        }
    }

    /**
     * Select object.
     *
     * @param prtoCriterio
     *            the prto criterio
     * @return the puerto vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public PuertoVO selectObject(final @NonNull PuertoCriterioVO prtoCriterio) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final PuertoDAO prtoDAO = session.getMapper(PuertoDAO.class);
            final PuertoVO prto = prtoDAO.selectObject(prtoCriterio);

            if (prto == null) {
                throw new InstanceNotFoundException(MessageI18nKey.prto, prtoCriterio);
            }

            return prto;
        }
    }

    /**
     * Select list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    public List<PuertoVO> selectList(final @NonNull PuertoCriterioVO criterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final PuertoDAO prtoDAO = session.getMapper(PuertoDAO.class);

            return prtoDAO.selectList(criterio);
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
    public PaginatedList<PuertoVO> selectList(final @NonNull PuertoCriterioVO criterio, final int offset,
            final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final PuertoDAO prtoDAO = session.getMapper(PuertoDAO.class);
            final int count = prtoDAO.count(criterio);
            final List<PuertoVO> prtoList = new ArrayList<>();

            if (count >= offset) {
                prtoList.addAll(prtoDAO.selectList(criterio, new RowBounds(offset, limit)));
            }

            return new PaginatedList<PuertoVO>(prtoList, offset, limit, count);
        }
    }

    /**
     * Insert.
     *
     * @param prto
     *            the prto
     * @param i18nMap
     *            the i18n map
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public void insert(final @NonNull PuertoVO prto, final @NonNull Map<String, I18nVO> i18nMap)
            throws DuplicateInstanceException {
        Preconditions.checkNotNull(prto.getCodigo());
        Preconditions.checkNotNull(prto.getCodigoCorto());
        Preconditions.checkNotNull(prto.getSprt());
        Preconditions.checkNotNull(prto.getSprt().getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final PuertoDAO prtoDAO = session.getMapper(PuertoDAO.class);

            if (prtoDAO.exists(prto)) {
                throw new DuplicateInstanceException(MessageI18nKey.prto, prto);
            }

            final IgBO igBO = new IgBO();

            prto.setId(igBO.nextVal(IgBO.SQ_INTEGRA));

            prtoDAO.insert(prto);
            I18nBO.insertMap(session, I18nPrefix.prto, prto.getId(), i18nMap);

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param prto
     *            the prto
     * @param i18nMap
     *            the i18n map
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void update(final @NonNull PuertoVO prto, final @NonNull Map<String, I18nVO> i18nMap)
            throws InstanceNotFoundException {
        Preconditions.checkNotNull(prto.getId());
        Preconditions.checkNotNull(prto.getCodigoCorto());
        Preconditions.checkNotNull(prto.getSprt());
        Preconditions.checkNotNull(prto.getSprt().getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final PuertoDAO prtoDAO = session.getMapper(PuertoDAO.class);

            if (prtoDAO.update(prto) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.prto, prto);
            }

            I18nBO.updateMap(session, I18nPrefix.prto, prto.getId(), i18nMap);

            session.commit();
        }
    }

    /**
     * Delette.
     *
     * @param prto
     *            the prto
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(final @NonNull PuertoVO prto) throws InstanceNotFoundException {
        Preconditions.checkNotNull(prto.getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final PuertoDAO prtoDAO = session.getMapper(PuertoDAO.class);

            if (prtoDAO.delete(prto) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.prto, prto);
            }

            I18nBO.deleteMap(session, I18nPrefix.prto, prto.getId());

            session.commit();
        }
    }
}
