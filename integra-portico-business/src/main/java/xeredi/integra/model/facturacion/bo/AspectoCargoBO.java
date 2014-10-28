package xeredi.integra.model.facturacion.bo;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.comun.exception.OverlapException;
import xeredi.integra.model.facturacion.dao.AspectoCargoDAO;
import xeredi.integra.model.facturacion.vo.AspectoCargoCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoCargoVO;
import xeredi.integra.model.util.GlobalNames;
import xeredi.util.exception.InstanceNotFoundException;
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
     * @param criterioVO
     *            the criterio vo
     * @return the aspecto cargo vo
     */
    public AspectoCargoVO select(final AspectoCargoCriterioVO criterioVO) {
        Preconditions.checkNotNull(criterioVO);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AspectoCargoDAO ascrDAO = session.getMapper(AspectoCargoDAO.class);

            return ascrDAO.selectObject(criterioVO);
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
        Preconditions.checkNotNull(vo.getAscv());
        Preconditions.checkNotNull(vo.getAscv().getFini());
        Preconditions.checkNotNull(vo.getAspcId());
        Preconditions.checkNotNull(vo.getCrgo());
        Preconditions.checkNotNull(vo.getCrgo().getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AspectoCargoDAO ascrDAO = session.getMapper(AspectoCargoDAO.class);

            final IgBO igBO = new IgBO();

            if (ascrDAO.exists(vo)) {
                vo.setId(ascrDAO.selectId(vo));

                if (ascrDAO.existsOverlap(vo)) {
                    throw new OverlapException(AspectoCargoVO.class.getName(), vo);
                }
            } else {
                vo.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));

                ascrDAO.insert(vo);
            }

            vo.getAscv().setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));

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
        Preconditions.checkNotNull(vo.getAscv());
        Preconditions.checkNotNull(vo.getAscv().getId());
        Preconditions.checkNotNull(vo.getAscv().getFini());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AspectoCargoDAO ascrDAO = session.getMapper(AspectoCargoDAO.class);

            if (ascrDAO.existsOverlap(vo)) {
                throw new OverlapException(AspectoCargoVO.class.getName(), vo);
            }

            final int updated = ascrDAO.updateVersion(vo);

            if (updated == 0) {
                throw new InstanceNotFoundException(AspectoCargoVO.class.getName(), vo);
            }

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param vo
     *            the vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(final AspectoCargoVO vo) throws InstanceNotFoundException {
        Preconditions.checkNotNull(vo);
        Preconditions.checkNotNull(vo.getAscv());
        Preconditions.checkNotNull(vo.getAscv().getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final AspectoCargoDAO ascrDAO = session.getMapper(AspectoCargoDAO.class);

            final int updated = ascrDAO.deleteVersion(vo);

            if (updated == 0) {
                throw new InstanceNotFoundException(AspectoCargoVO.class.getName(), vo);
            }

            session.commit();
        }
    }
}
