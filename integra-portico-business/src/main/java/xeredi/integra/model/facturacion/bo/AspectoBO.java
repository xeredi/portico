package xeredi.integra.model.facturacion.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.comun.exception.OverlapException;
import xeredi.integra.model.facturacion.dao.AspectoDAO;
import xeredi.integra.model.facturacion.vo.AspectoCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoVO;
import xeredi.integra.model.util.GlobalNames;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoBO.
 */
public class AspectoBO {

    /** The aspc dao. */
    AspectoDAO aspcDAO;

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

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE);

        aspcDAO = session.getMapper(AspectoDAO.class);

        try {
            final int count = aspcDAO.count(aspcCriterioVO);
            final List<AspectoVO> aspcList = new ArrayList<>();

            if (count >= offset) {
                aspcList.addAll(aspcDAO.selectList(aspcCriterioVO, new RowBounds(offset, limit)));
            }

            return new PaginatedList<AspectoVO>(aspcList, offset, limit, count);
        } finally {
            session.close();
        }
    }

    /**
     * Select label value list.
     *
     * @param aspcCriterioVO
     *            the aspc criterio vo
     * @return the list
     */
    public List<LabelValueVO> selectLabelValueList(final AspectoCriterioVO aspcCriterioVO) {
        Preconditions.checkNotNull(aspcCriterioVO);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE);

        aspcDAO = session.getMapper(AspectoDAO.class);

        try {
            final List<LabelValueVO> list = new ArrayList<>();

            for (final AspectoVO aspc : aspcDAO.selectList(aspcCriterioVO)) {
                list.add(new LabelValueVO(aspc.getEtiqueta(), aspc.getId()));
            }

            return list;
        } finally {
            session.close();
        }
    }

    /**
     * Select.
     *
     * @param aspcCriterioVO
     *            the aspc criterio vo
     * @return the aspecto vo
     */
    public AspectoVO select(final AspectoCriterioVO aspcCriterioVO) {
        Preconditions.checkNotNull(aspcCriterioVO);
        Preconditions.checkArgument(aspcCriterioVO.getAspvId() != null || aspcCriterioVO.getId() != null
                && aspcCriterioVO.getFechaVigencia() != null);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        aspcDAO = session.getMapper(AspectoDAO.class);

        try {
            return aspcDAO.selectObject(aspcCriterioVO);
        } finally {
            session.close();
        }
    }

    /**
     * Insert.
     *
     * @param aspc
     *            the aspc
     * @throws OverlapException
     *             the overlap exception
     */
    public void insert(final AspectoVO aspc) throws OverlapException {
        Preconditions.checkNotNull(aspc);
        Preconditions.checkNotNull(aspc.getAspv());
        Preconditions.checkNotNull(aspc.getAspv().getFini());
        Preconditions.checkNotNull(aspc.getTpsr());
        Preconditions.checkNotNull(aspc.getTpsr().getId());

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        aspcDAO = session.getMapper(AspectoDAO.class);

        try {
            final IgBO igBO = new IgBO();

            if (aspcDAO.exists(aspc)) {
                aspc.setId(aspcDAO.selectId(aspc));

                if (aspcDAO.existsOverlap(aspc)) {
                    throw new OverlapException(AspectoVO.class.getName(), aspc);
                }
            } else {
                aspc.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));

                aspcDAO.insert(aspc);
            }

            aspc.getAspv().setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));

            aspcDAO.insertVersion(aspc);

            session.commit();
        } finally {
            session.close();
        }
    }

    /**
     * Duplicate.
     *
     * @param aspc
     *            the aspc
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public void duplicate(final AspectoVO aspc) throws DuplicateInstanceException {
        Preconditions.checkNotNull(aspc);
        Preconditions.checkNotNull(aspc.getAspv());

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        aspcDAO = session.getMapper(AspectoDAO.class);

        try {
            if (aspcDAO.exists(aspc)) {
                throw new DuplicateInstanceException(AspectoVO.class.getName(), aspc);
            }

            final IgBO igBO = new IgBO();

            aspc.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
            aspc.getAspv().setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));

            aspcDAO.insert(aspc);
            aspcDAO.insertVersion(aspc);

            session.commit();
        } finally {
            session.close();
        }
    }

    /**
     * Update.
     *
     * @param aspc
     *            the aspc
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OverlapException
     *             the overlap exception
     */
    public void update(final AspectoVO aspc) throws InstanceNotFoundException, OverlapException {
        Preconditions.checkNotNull(aspc);
        Preconditions.checkNotNull(aspc.getAspv());
        Preconditions.checkNotNull(aspc.getId());
        Preconditions.checkNotNull(aspc.getAspv().getId());

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        aspcDAO = session.getMapper(AspectoDAO.class);

        try {
            if (aspcDAO.existsOverlap(aspc)) {
                throw new OverlapException(AspectoVO.class.getName(), aspc);
            }

            final int updated = aspcDAO.updateVersion(aspc);

            if (updated == 0) {
                throw new InstanceNotFoundException(AspectoVO.class.getName(), aspc);
            }

            session.commit();
        } finally {
            session.close();
        }
    }

}
