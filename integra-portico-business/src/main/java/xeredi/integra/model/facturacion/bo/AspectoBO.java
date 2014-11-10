package xeredi.integra.model.facturacion.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.exception.OverlapException;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.facturacion.dao.AspectoDAO;
import xeredi.integra.model.facturacion.vo.AspectoCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoBO.
 */
public class AspectoBO {
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
                aspcList.addAll(aspcDAO.selectPaginatedList(aspcCriterioVO, new RowBounds(offset, limit)));
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
            final AspectoDAO aspcDAO = session.getMapper(AspectoDAO.class);
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
     * @param id
     *            the id
     * @param fechaVigencia
     *            the fecha vigencia
     * @param idioma
     *            the idioma
     * @return the aspecto vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public AspectoVO select(final Long id, final Date fechaVigencia, final String idioma)
            throws InstanceNotFoundException {
        Preconditions.checkNotNull(id);
        Preconditions.checkNotNull(fechaVigencia);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AspectoDAO aspcDAO = session.getMapper(AspectoDAO.class);
            final AspectoCriterioVO aspcCriterioVO = new AspectoCriterioVO();

            aspcCriterioVO.setId(id);
            aspcCriterioVO.setFechaVigencia(fechaVigencia);
            aspcCriterioVO.setIdioma(idioma);

            final AspectoVO aspc = aspcDAO.selectObject(aspcCriterioVO);

            if (aspc == null) {
                throw new InstanceNotFoundException(MessageI18nKey.aspc, id);
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
        Preconditions.checkNotNull(aspc.getAspv());
        Preconditions.checkNotNull(aspc.getAspv().getFini());
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
     * @param i18nMap
     *            the i18n map
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public void duplicate(final AspectoVO aspc, final Map<String, I18nVO> i18nMap) throws DuplicateInstanceException {
        Preconditions.checkNotNull(aspc);
        Preconditions.checkNotNull(aspc.getAspv());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final AspectoDAO aspcDAO = session.getMapper(AspectoDAO.class);

            if (aspcDAO.exists(aspc)) {
                throw new DuplicateInstanceException(MessageI18nKey.aspc, aspc);
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
        Preconditions.checkNotNull(aspc.getAspv());
        Preconditions.checkNotNull(aspc.getId());
        Preconditions.checkNotNull(aspc.getAspv().getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final AspectoDAO aspcDAO = session.getMapper(AspectoDAO.class);

            if (aspcDAO.existsOverlap(aspc)) {
                throw new OverlapException(MessageI18nKey.aspc, aspc);
            }

            final int updated = aspcDAO.updateVersion(aspc);

            if (updated == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.aspc, aspc);
            }

            I18nBO.updateMap(session, I18nPrefix.aspv, aspc.getAspv().getId(), i18nMap);

            session.commit();
        }
    }
}
