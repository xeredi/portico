package xeredi.integra.model.facturacion.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.comun.exception.OverlapException;
import xeredi.integra.model.facturacion.dao.CargoDAO;
import xeredi.integra.model.facturacion.vo.CargoCriterioVO;
import xeredi.integra.model.facturacion.vo.CargoVO;
import xeredi.integra.model.util.GlobalNames;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoBO.
 */
public class CargoBO {

    /** The crgo dao. */
    CargoDAO crgoDAO;

    /**
     * Select list.
     *
     * @param crgoCriterioVO
     *            the crgo criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public PaginatedList<CargoVO> selectList(final CargoCriterioVO crgoCriterioVO, final int offset, final int limit) {
        Preconditions.checkNotNull(crgoCriterioVO);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE);

        crgoDAO = session.getMapper(CargoDAO.class);

        try {
            final int count = crgoDAO.count(crgoCriterioVO);
            final List<CargoVO> crgoList = new ArrayList<>();

            if (count >= offset) {
                crgoList.addAll(crgoDAO.selectList(crgoCriterioVO, new RowBounds(offset, limit)));
            }

            return new PaginatedList<CargoVO>(crgoList, offset, limit, count);
        } finally {
            session.close();
        }
    }

    /**
     * Select label value list.
     *
     * @param crgoCriterioVO
     *            the crgo criterio vo
     * @return the list
     */
    public List<LabelValueVO> selectLabelValueList(final CargoCriterioVO crgoCriterioVO) {
        Preconditions.checkNotNull(crgoCriterioVO);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE);

        crgoDAO = session.getMapper(CargoDAO.class);

        try {
            return crgoDAO.selectLabelValueList(crgoCriterioVO);
        } finally {
            session.close();
        }
    }

    /**
     * Select.
     *
     * @param crgoCriterioVO
     *            the crgo criterio vo
     * @return the cargo vo
     */
    public CargoVO select(final CargoCriterioVO crgoCriterioVO) {
        Preconditions.checkNotNull(crgoCriterioVO);
        Preconditions.checkArgument(crgoCriterioVO.getCrgvId() != null || crgoCriterioVO.getId() != null
                && crgoCriterioVO.getFechaVigencia() != null);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        crgoDAO = session.getMapper(CargoDAO.class);

        try {
            return crgoDAO.selectObject(crgoCriterioVO);
        } finally {
            session.close();
        }
    }

    /**
     * Insert.
     *
     * @param crgo
     *            the crgo
     * @throws OverlapException
     *             the overlap exception
     */
    public void insert(final CargoVO crgo) throws OverlapException {
        Preconditions.checkNotNull(crgo);
        Preconditions.checkNotNull(crgo.getCrgv());
        Preconditions.checkNotNull(crgo.getCrgv().getFini());
        Preconditions.checkNotNull(crgo.getTpsr());
        Preconditions.checkNotNull(crgo.getTpsr().getId());

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        crgoDAO = session.getMapper(CargoDAO.class);

        try {
            final IgBO igBO = new IgBO();

            if (crgoDAO.exists(crgo)) {
                crgo.setId(crgoDAO.selectId(crgo));

                if (crgoDAO.existsOverlap(crgo)) {
                    throw new OverlapException(CargoVO.class.getName(), crgo);
                }
            } else {
                crgo.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));

                crgoDAO.insert(crgo);
            }

            crgo.getCrgv().setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));

            crgoDAO.insertVersion(crgo);

            session.commit();
        } finally {
            session.close();
        }
    }

    /**
     * Update.
     *
     * @param crgo
     *            the crgo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OverlapException
     *             the overlap exception
     */
    public void update(final CargoVO crgo) throws InstanceNotFoundException, OverlapException {
        Preconditions.checkNotNull(crgo);
        Preconditions.checkNotNull(crgo.getCrgv());
        Preconditions.checkNotNull(crgo.getCrgv().getId());

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        crgoDAO = session.getMapper(CargoDAO.class);

        try {
            if (crgoDAO.existsOverlap(crgo)) {
                throw new OverlapException(CargoVO.class.getName(), crgo);
            }

            final int updated = crgoDAO.updateVersion(crgo);

            if (updated == 0) {
                throw new InstanceNotFoundException(CargoVO.class.getName(), crgo);
            }

            session.commit();
        } finally {
            session.close();
        }
    }

    /**
     * Delete.
     *
     * @param crgo
     *            the crgo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(final CargoVO crgo) throws InstanceNotFoundException {
        Preconditions.checkNotNull(crgo);
        Preconditions.checkNotNull(crgo.getCrgv());
        Preconditions.checkNotNull(crgo.getCrgv().getId());

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        crgoDAO = session.getMapper(CargoDAO.class);

        try {
            final int updated = crgoDAO.deleteVersion(crgo);

            if (updated == 0) {
                throw new InstanceNotFoundException(CargoVO.class.getName(), crgo);
            }

            session.commit();
        } finally {
            session.close();
        }
    }

}
