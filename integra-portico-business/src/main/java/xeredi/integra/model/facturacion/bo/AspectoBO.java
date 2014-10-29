package xeredi.integra.model.facturacion.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.comun.exception.OverlapException;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.facturacion.dao.AspectoDAO;
import xeredi.integra.model.facturacion.vo.AspectoCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoVO;
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

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            aspcDAO = session.getMapper(AspectoDAO.class);

            final int count = aspcDAO.count(aspcCriterioVO);
            final List<AspectoVO> aspcList = new ArrayList<>();

            if (count >= offset) {
                aspcList.addAll(aspcDAO.selectList(aspcCriterioVO, new RowBounds(offset, limit)));
            }

            return new PaginatedList<AspectoVO>(aspcList, offset, limit, count);
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

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            aspcDAO = session.getMapper(AspectoDAO.class);

            final List<LabelValueVO> list = new ArrayList<>();

            for (final AspectoVO aspc : aspcDAO.selectList(aspcCriterioVO)) {
                list.add(new LabelValueVO(aspc.getEtiqueta(), aspc.getId()));
            }

            return list;
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

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            aspcDAO = session.getMapper(AspectoDAO.class);

            return aspcDAO.selectObject(aspcCriterioVO);
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
    public void insert(final AspectoVO aspc, final Map<String, I18nVO> i18nMap) throws OverlapException {
        Preconditions.checkNotNull(aspc);
        Preconditions.checkNotNull(aspc.getAspv());
        Preconditions.checkNotNull(aspc.getAspv().getFini());
        Preconditions.checkNotNull(aspc.getTpsr());
        Preconditions.checkNotNull(aspc.getTpsr().getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            aspcDAO = session.getMapper(AspectoDAO.class);

            final IgBO igBO = new IgBO();

            if (aspcDAO.exists(aspc)) {
                aspc.setId(aspcDAO.selectId(aspc));

                if (aspcDAO.existsOverlap(aspc)) {
                    throw new OverlapException(AspectoVO.class.getName(), aspc);
                }
            } else {
                aspc.setId(igBO.nextVal(IgBO.SQ_INTEGRA));

                aspcDAO.insert(aspc);
            }

            aspc.getAspv().setId(igBO.nextVal(IgBO.SQ_INTEGRA));

            aspcDAO.insertVersion(aspc);

            I18nBO.insertMap(session, I18nPrefix.aspv, aspc.getAspv().getId(), i18nMap);

            session.commit();
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
    public void duplicate(final AspectoVO aspc, final Map<String, I18nVO> i18nMap) throws DuplicateInstanceException {
        Preconditions.checkNotNull(aspc);
        Preconditions.checkNotNull(aspc.getAspv());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            aspcDAO = session.getMapper(AspectoDAO.class);

            if (aspcDAO.exists(aspc)) {
                throw new DuplicateInstanceException(AspectoVO.class.getName(), aspc);
            }

            final IgBO igBO = new IgBO();

            aspc.setId(igBO.nextVal(IgBO.SQ_INTEGRA));
            aspc.getAspv().setId(igBO.nextVal(IgBO.SQ_INTEGRA));

            aspcDAO.insert(aspc);
            aspcDAO.insertVersion(aspc);

            I18nBO.insertMap(session, I18nPrefix.aspv, aspc.getAspv().getId(), i18nMap);

            session.commit();
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
    public void update(final AspectoVO aspc, final Map<String, I18nVO> i18nMap) throws InstanceNotFoundException,
            OverlapException {
        Preconditions.checkNotNull(aspc);
        Preconditions.checkNotNull(aspc.getAspv());
        Preconditions.checkNotNull(aspc.getId());
        Preconditions.checkNotNull(aspc.getAspv().getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            aspcDAO = session.getMapper(AspectoDAO.class);

            if (aspcDAO.existsOverlap(aspc)) {
                throw new OverlapException(AspectoVO.class.getName(), aspc);
            }

            final int updated = aspcDAO.updateVersion(aspc);

            if (updated == 0) {
                throw new InstanceNotFoundException(AspectoVO.class.getName(), aspc);
            }

            I18nBO.updateMap(session, I18nPrefix.aspv, aspc.getAspv().getId(), i18nMap);

            session.commit();
        }
    }
}
