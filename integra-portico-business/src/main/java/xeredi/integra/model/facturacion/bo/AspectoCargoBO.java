package xeredi.integra.model.facturacion.bo;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.exception.OverlapException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.facturacion.dao.AspectoCargoDAO;
import xeredi.integra.model.facturacion.vo.AspectoCargoCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoCargoVO;
import xeredi.util.mybatis.SqlMapperLocator;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoCargoBO.
 */
public final class AspectoCargoBO {
    /**
     * Select list.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the list
     */
    public List<AspectoCargoVO> selectList(final AspectoCargoCriterioVO criterioVO) {
        Preconditions.checkNotNull(criterioVO);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AspectoCargoDAO ascrDAO = session.getMapper(AspectoCargoDAO.class);

            return ascrDAO.selectList(criterioVO);
        }
    }

    /**
     * Select.
     *
     * @param ascrCriterio
     *            the ascr criterio
     * @return the aspecto cargo vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public AspectoCargoVO selectObject(final AspectoCargoCriterioVO ascrCriterio) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AspectoCargoDAO ascrDAO = session.getMapper(AspectoCargoDAO.class);
            final AspectoCargoVO ascr = ascrDAO.selectObject(ascrCriterio);

            if (ascr == null) {
                throw new InstanceNotFoundException(MessageI18nKey.ascr, ascrCriterio);
            }

            return ascr;
        }
    }

    /**
     * Insert.
     *
     * @param vo
     *            the vo
     * @throws OverlapException
     *             the overlap exception
     */
    public void insert(final AspectoCargoVO vo) throws OverlapException {
        Preconditions.checkNotNull(vo);
        Preconditions.checkNotNull(vo.getVersion());
        Preconditions.checkNotNull(vo.getVersion().getFini());
        Preconditions.checkNotNull(vo.getAspcId());
        Preconditions.checkNotNull(vo.getCrgo());
        Preconditions.checkNotNull(vo.getCrgo().getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AspectoCargoDAO ascrDAO = session.getMapper(AspectoCargoDAO.class);

            final IgBO igBO = new IgBO();

            if (ascrDAO.exists(vo)) {
                vo.setId(ascrDAO.selectId(vo));

                if (ascrDAO.existsOverlap(vo)) {
                    throw new OverlapException(MessageI18nKey.ascr, vo);
                }
            } else {
                vo.setId(igBO.nextVal(IgBO.SQ_INTEGRA));

                ascrDAO.insert(vo);
            }

            vo.getVersion().setId(igBO.nextVal(IgBO.SQ_INTEGRA));

            ascrDAO.insertVersion(vo);

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param vo
     *            the vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OverlapException
     *             the overlap exception
     */
    public void update(final AspectoCargoVO vo) throws InstanceNotFoundException, OverlapException {
        Preconditions.checkNotNull(vo);
        Preconditions.checkNotNull(vo.getId());
        Preconditions.checkNotNull(vo.getVersion());
        Preconditions.checkNotNull(vo.getVersion().getId());
        Preconditions.checkNotNull(vo.getVersion().getFini());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AspectoCargoDAO ascrDAO = session.getMapper(AspectoCargoDAO.class);

            if (ascrDAO.existsOverlap(vo)) {
                throw new OverlapException(MessageI18nKey.ascr, vo);
            }

            if (ascrDAO.updateVersion(vo) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.ascr, vo);
            }

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param ascvId
     *            the ascv id
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(final Long ascvId) throws InstanceNotFoundException {
        Preconditions.checkNotNull(ascvId);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AspectoCargoDAO ascrDAO = session.getMapper(AspectoCargoDAO.class);

            if (ascrDAO.deleteVersion(ascvId) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.ascr, ascvId);
            }

            session.commit();
        }
    }
}
