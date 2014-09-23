package xeredi.integra.model.facturacion.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.comun.exception.OverlapException;
import xeredi.integra.model.facturacion.dao.ReglaDAO;
import xeredi.integra.model.facturacion.vo.ReglaCriterioVO;
import xeredi.integra.model.facturacion.vo.ReglaVO;
import xeredi.integra.model.util.GlobalNames;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaBO.
 */
public class ReglaBO {

    /** The rgla dao. */
    ReglaDAO rglaDAO;

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

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        rglaDAO = session.getMapper(ReglaDAO.class);

        try {
            final int count = rglaDAO.count(rglaCriterioVO);
            final List<ReglaVO> rglaList = new ArrayList<>();

            if (count >= offset) {
                rglaList.addAll(rglaDAO.selectList(rglaCriterioVO, new RowBounds(offset, limit)));
            }

            return new PaginatedList<ReglaVO>(rglaList, offset, limit, count);
        } finally {
            session.close();
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

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        rglaDAO = session.getMapper(ReglaDAO.class);

        try {
            return rglaDAO.selectList(rglaCriterioVO);
        } finally {
            session.close();
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
        Preconditions.checkNotNull(rgla.getRglv());

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        rglaDAO = session.getMapper(ReglaDAO.class);

        try {
            final IgBO igBO = new IgBO();

            if (rglaDAO.exists(rgla)) {
                rgla.setId(rglaDAO.selectId(rgla));

                if (rglaDAO.existsOverlap(rgla)) {
                    throw new OverlapException(ReglaVO.class.getName(), rgla);
                }
            } else {
                rgla.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));

                rglaDAO.insert(rgla);
            }

            rgla.getRglv().setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));

            rglaDAO.insertVersion(rgla);

            session.commit();
        } finally {
            session.close();
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
        Preconditions.checkNotNull(rgla.getRglv());
        Preconditions.checkNotNull(rgla.getRglv().getId());

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        rglaDAO = session.getMapper(ReglaDAO.class);

        try {
            if (rglaDAO.existsOverlap(rgla)) {
                throw new OverlapException(ReglaVO.class.getName(), rgla);
            }

            final int updated = rglaDAO.updateVersion(rgla);

            if (updated == 0) {
                throw new InstanceNotFoundException(ReglaVO.class.getName(), rgla);
            }

            session.commit();
        } finally {
            session.close();
        }
    }

    /**
     * Delete.
     *
     * @param rgla
     *            the rgla
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(final ReglaVO rgla) throws InstanceNotFoundException {
        Preconditions.checkNotNull(rgla);
        Preconditions.checkNotNull(rgla.getRglv());
        Preconditions.checkNotNull(rgla.getRglv().getId());

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        rglaDAO = session.getMapper(ReglaDAO.class);

        try {
            final int updated = rglaDAO.deleteVersion(rgla);

            if (updated == 0) {
                throw new InstanceNotFoundException(ReglaVO.class.getName(), rgla);
            }

            session.commit();
        } finally {
            session.close();
        }
    }

    /**
     * Select.
     *
     * @param rglaCriterioVO
     *            the rgla criterio vo
     * @return the regla vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public ReglaVO select(final ReglaCriterioVO rglaCriterioVO) throws InstanceNotFoundException {
        Preconditions.checkNotNull(rglaCriterioVO);
        Preconditions.checkArgument(rglaCriterioVO.getRglvId() != null || rglaCriterioVO.getId() != null
                && rglaCriterioVO.getFechaVigencia() != null);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        rglaDAO = session.getMapper(ReglaDAO.class);

        try {
            final ReglaVO rgla = rglaDAO.selectObject(rglaCriterioVO);

            if (rgla == null) {
                throw new InstanceNotFoundException(ReglaVO.class.getName(), rglaCriterioVO);
            }

            return rgla;
        } finally {
            session.close();
        }
    }

}
