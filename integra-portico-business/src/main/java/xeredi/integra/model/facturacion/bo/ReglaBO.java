package xeredi.integra.model.facturacion.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.exception.OverlapException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.facturacion.dao.ReglaDAO;
import xeredi.integra.model.facturacion.vo.ReglaCriterioVO;
import xeredi.integra.model.facturacion.vo.ReglaVO;
import xeredi.util.applicationobjects.LabelValueVO;
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
                rglaList.addAll(rglaDAO.selectPaginatedList(rglaCriterioVO, new RowBounds(offset, limit)));
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
     * Select label value list.
     *
     * @param rglaCriterioVO
     *            the rgla criterio vo
     * @return the list
     */
    public List<LabelValueVO> selectLabelValueList(final ReglaCriterioVO rglaCriterioVO) {
        Preconditions.checkNotNull(rglaCriterioVO);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ReglaDAO rglaDAO = session.getMapper(ReglaDAO.class);
            final List<LabelValueVO> list = new ArrayList<>();

            for (final ReglaVO reglaVO : rglaDAO.selectList(rglaCriterioVO)) {
                list.add(new LabelValueVO(reglaVO.getCodigo(), reglaVO.getId()));
            }

            return list;
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

            rgla.getRglv().setId(igBO.nextVal(IgBO.SQ_INTEGRA));

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
        Preconditions.checkNotNull(rgla.getRglv());
        Preconditions.checkNotNull(rgla.getRglv().getId());

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
     * @param rgla
     *            the rgla
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(final ReglaVO rgla) throws InstanceNotFoundException {
        Preconditions.checkNotNull(rgla);
        Preconditions.checkNotNull(rgla.getRglv());
        Preconditions.checkNotNull(rgla.getRglv().getId());

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
     * @param id
     *            the id
     * @param fechaVigencia
     *            the fecha vigencia
     * @return the regla vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public ReglaVO select(final Long id, final Date fechaVigencia) throws InstanceNotFoundException {
        Preconditions.checkNotNull(id);
        Preconditions.checkNotNull(fechaVigencia);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ReglaDAO rglaDAO = session.getMapper(ReglaDAO.class);
            final ReglaCriterioVO rglaCriterioVO = new ReglaCriterioVO();

            rglaCriterioVO.setId(id);
            rglaCriterioVO.setFechaVigencia(fechaVigencia);

            final ReglaVO rgla = rglaDAO.selectObject(rglaCriterioVO);

            if (rgla == null) {
                throw new InstanceNotFoundException(MessageI18nKey.rgla, rglaCriterioVO);
            }

            return rgla;
        }
    }
}
