package xeredi.argo.model.facturacion.bo;

import java.util.ArrayList;
import java.util.List;

import lombok.NonNull;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.argo.model.comun.bo.IgBO;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.dao.ValoracionDAO;
import xeredi.argo.model.facturacion.dao.ValoracionDetalleDAO;
import xeredi.argo.model.facturacion.dao.ValoracionLineaDAO;
import xeredi.argo.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionDetalleCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionBO.
 */
public class ValoracionBO {
    /**
     * Insert.
     *
     * @param vlrc
     *            the vlrc
     */
    public void insert(final @NonNull ValoracionVO vlrc) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ValoracionDAO vlrcDAO = session.getMapper(ValoracionDAO.class);
            final IgBO igBO = new IgBO();

            vlrc.setId(igBO.nextVal(IgBO.SQ_INTEGRA));

            vlrcDAO.insert(vlrc);
            vlrcDAO.updateImporte(vlrc.getId());

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param vlrc
     *            the vlrc
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void update(final @NonNull ValoracionVO vlrc) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ValoracionDAO vlrcDAO = session.getMapper(ValoracionDAO.class);

            if (vlrcDAO.update(vlrc) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.vlrc, vlrc.getId());
            }

            vlrcDAO.updateImporte(vlrc.getId());

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param ids
     *            the ids
     */
    public void delete(final @NonNull Long id) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ValoracionDetalleDAO vlrdDAO = session.getMapper(ValoracionDetalleDAO.class);
            final ValoracionDetalleCriterioVO vlrdCriterio = new ValoracionDetalleCriterioVO();

            vlrdCriterio.setVlrcId(id);
            vlrdDAO.deleteList(vlrdCriterio);

            final ValoracionLineaDAO vlrlDAO = session.getMapper(ValoracionLineaDAO.class);
            final ValoracionLineaCriterioVO vlrlCriterio = new ValoracionLineaCriterioVO();

            vlrlCriterio.setVlrcId(id);
            vlrlDAO.deleteList(vlrlCriterio);

            final ValoracionDAO vlrcDAO = session.getMapper(ValoracionDAO.class);
            final ValoracionCriterioVO vlrcCriterioVO = new ValoracionCriterioVO();

            vlrcCriterioVO.setId(id);
            vlrcDAO.deleteList(vlrcCriterioVO);

            session.commit();
        }
    }

    /**
     * Select.
     *
     * @param id
     *            the id
     * @param idioma
     *            the idioma
     * @return the valoracion vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public ValoracionVO select(final @NonNull Long id, final String idioma) throws InstanceNotFoundException {
        final ValoracionCriterioVO vlrcCriterio = new ValoracionCriterioVO();

        vlrcCriterio.setId(id);
        vlrcCriterio.setIdioma(idioma);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ValoracionDAO vlrcDAO = session.getMapper(ValoracionDAO.class);
            final ValoracionVO vlrc = vlrcDAO.selectObject(vlrcCriterio);

            if (vlrc == null) {
                throw new InstanceNotFoundException(MessageI18nKey.vlrc, id);
            }

            return vlrc;
        }
    }

    /**
     * Select list.
     *
     * @param vlrcCriterioVO
     *            the vlrc criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public PaginatedList<ValoracionVO> selectList(final @NonNull ValoracionCriterioVO vlrcCriterioVO, final int offset,
            final int limit) {
        Preconditions.checkArgument(offset >= 0);
        Preconditions.checkArgument(limit > 0);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ValoracionDAO vlrcDAO = session.getMapper(ValoracionDAO.class);
            final int count = vlrcDAO.count(vlrcCriterioVO);
            final List<ValoracionVO> vlrcList = new ArrayList<>();

            if (count >= offset) {
                vlrcList.addAll(vlrcDAO.selectList(vlrcCriterioVO, new RowBounds(offset, limit)));
            }

            return new PaginatedList<ValoracionVO>(vlrcList, offset, limit, count);
        }
    }
}
