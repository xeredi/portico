package xeredi.argo.model.facturacion.bo;

import java.util.ArrayList;
import java.util.List;

import lombok.NonNull;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.argo.model.comun.bo.IgBO;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.OverlapException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.dao.ReglaDAO;
import xeredi.argo.model.facturacion.vo.ReglaCriterioVO;
import xeredi.argo.model.facturacion.vo.ReglaVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaBO.
 */
public class ReglaBO {
    /**
     * Select list.
     *
     * @param rglaCriterioVO
     *            the rgla criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public PaginatedList<ReglaVO> selectList(final ReglaCriterioVO rglaCriterioVO, final int offset, final int limit) {
        Preconditions.checkNotNull(rglaCriterioVO);
        Preconditions.checkArgument(offset >= 0);
        Preconditions.checkArgument(limit > 0);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ReglaDAO rglaDAO = session.getMapper(ReglaDAO.class);
            final int count = rglaDAO.count(rglaCriterioVO);
            final List<ReglaVO> rglaList = new ArrayList<>();

            if (count >= offset) {
                rglaList.addAll(rglaDAO.selectList(rglaCriterioVO, new RowBounds(offset, limit)));
            }

            return new PaginatedList<ReglaVO>(rglaList, offset, limit, count);
        }
    }

    /**
     * Select list.
     *
     * @param rglaCriterioVO
     *            the rgla criterio vo
     * @return the list
     */
    public List<ReglaVO> selectList(final ReglaCriterioVO rglaCriterioVO) {
        Preconditions.checkNotNull(rglaCriterioVO);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ReglaDAO rglaDAO = session.getMapper(ReglaDAO.class);

            return rglaDAO.selectList(rglaCriterioVO);
        }
    }

    /**
     * Select lupa list.
     *
     * @param rglaCriterio
     *            the rgla criterio
     * @param limit
     *            the limit
     * @return the list
     */
    public List<ReglaVO> selectList(final ReglaCriterioVO rglaCriterio, final int limit) {
        Preconditions.checkNotNull(rglaCriterio);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ReglaDAO rglaDAO = session.getMapper(ReglaDAO.class);

            return rglaDAO.selectList(rglaCriterio, new RowBounds(PaginatedList.MIN_OFFSET, limit));
        }
    }

    /**
     * Insert.
     *
     * @param rgla
     *            the rgla
     * @throws OverlapException
     *             the overlap exception
     */
    public void insert(final ReglaVO rgla) throws OverlapException {
        Preconditions.checkNotNull(rgla);
        Preconditions.checkNotNull(rgla.getVersion());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ReglaDAO rglaDAO = session.getMapper(ReglaDAO.class);
            final IgBO igBO = new IgBO();

            if (rglaDAO.exists(rgla)) {
                rgla.setId(rglaDAO.selectId(rgla));

                if (rglaDAO.existsOverlap(rgla)) {
                    throw new OverlapException(MessageI18nKey.rgla, rgla);
                }
            } else {
                rgla.setId(igBO.nextVal(IgBO.SQ_INTEGRA));

                rglaDAO.insert(rgla);
            }

            rgla.getVersion().setId(igBO.nextVal(IgBO.SQ_INTEGRA));

            rglaDAO.insertVersion(rgla);

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param rgla
     *            the rgla
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OverlapException
     *             the overlap exception
     */
    public void update(final ReglaVO rgla) throws InstanceNotFoundException, OverlapException {
        Preconditions.checkNotNull(rgla);
        Preconditions.checkNotNull(rgla.getVersion());
        Preconditions.checkNotNull(rgla.getVersion().getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ReglaDAO rglaDAO = session.getMapper(ReglaDAO.class);

            if (rglaDAO.existsOverlap(rgla)) {
                throw new OverlapException(MessageI18nKey.rgla, rgla);
            }

            final int updated = rglaDAO.updateVersion(rgla);

            if (updated == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.rgla, rgla);
            }

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param rgla the rgla
     * @throws InstanceNotFoundException             the instance not found exception
     */
    public void delete(final @NonNull ReglaVO rgla) throws InstanceNotFoundException {
        Preconditions.checkNotNull(rgla.getVersion());
        Preconditions.checkNotNull(rgla.getVersion().getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ReglaDAO rglaDAO = session.getMapper(ReglaDAO.class);
            final int updated = rglaDAO.deleteVersion(rgla);

            if (updated == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.rgla, rgla);
            }

            session.commit();
        }
    }

    /**
     * Select.
     *
     * @param rglaCriterio
     *            the rgla criterio
     * @return the regla vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public ReglaVO selectObject(final ReglaCriterioVO rglaCriterio) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ReglaDAO rglaDAO = session.getMapper(ReglaDAO.class);
            final ReglaVO rgla = rglaDAO.selectObject(rglaCriterio);

            if (rgla == null) {
                throw new InstanceNotFoundException(MessageI18nKey.rgla, rglaCriterio);
            }

            return rgla;
        }
    }
}