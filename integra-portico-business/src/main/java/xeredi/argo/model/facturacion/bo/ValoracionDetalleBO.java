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
import xeredi.argo.model.facturacion.vo.ReglaTipo;
import xeredi.argo.model.facturacion.vo.ValoracionDetalleCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionDetalleVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionDetalleBO.
 */
public final class ValoracionDetalleBO {

    /**
     * Select vlrd.
     *
     * @param id
     *            the id
     * @param idioma
     *            the idioma
     * @return the valoracion detalle vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public ValoracionDetalleVO select(final @NonNull Long id, final String idioma) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ValoracionDetalleDAO vlrdDAO = session.getMapper(ValoracionDetalleDAO.class);
            final ValoracionDetalleCriterioVO vlrdCriterio = new ValoracionDetalleCriterioVO();

            vlrdCriterio.setId(id);
            vlrdCriterio.setIdioma(idioma);

            final ValoracionDetalleVO vlrd = vlrdDAO.selectObject(vlrdCriterio);

            if (vlrd == null) {
                throw new InstanceNotFoundException(MessageI18nKey.vlrd, id);
            }

            return vlrd;
        }
    }

    /**
     * Select list.
     *
     * @param vlrdCriterio
     *            the vlrd criterio
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public PaginatedList<ValoracionDetalleVO> selectList(final @NonNull ValoracionDetalleCriterioVO vlrdCriterio,
            final int offset, final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ValoracionDetalleDAO vlrdDAO = session.getMapper(ValoracionDetalleDAO.class);

            final int count = vlrdDAO.count(vlrdCriterio);
            final List<ValoracionDetalleVO> vlrdList = new ArrayList<>();

            if (count >= offset) {
                vlrdList.addAll(vlrdDAO.selectList(vlrdCriterio, new RowBounds(offset, limit)));
            }

            return new PaginatedList<ValoracionDetalleVO>(vlrdList, offset, limit, count);
        }
    }

    /**
     * Select list.
     *
     * @param vlrdCriterio
     *            the vlrd criterio
     * @return the list
     */
    public List<ValoracionDetalleVO> selectList(final @NonNull ValoracionDetalleCriterioVO vlrdCriterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ValoracionDetalleDAO vlrdDAO = session.getMapper(ValoracionDetalleDAO.class);

            return vlrdDAO.selectList(vlrdCriterio);
        }
    }

    /**
     * Insert.
     *
     * @param vlrd
     *            the vlrd
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void insert(final @NonNull ValoracionDetalleVO vlrd) throws InstanceNotFoundException {
        Preconditions.checkNotNull(vlrd.getVlrlId());
        Preconditions.checkNotNull(vlrd.getVlrcId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ValoracionLineaDAO vlrlDAO = session.getMapper(ValoracionLineaDAO.class);
            final ValoracionLineaCriterioVO vlrlCriterio = new ValoracionLineaCriterioVO();

            vlrlCriterio.setId(vlrd.getVlrlId());

            final ValoracionLineaVO vlrl = vlrlDAO.selectObject(vlrlCriterio);

            final IgBO igBO = new IgBO();

            if (vlrl == null) {
                throw new InstanceNotFoundException(MessageI18nKey.vlrl, vlrd.getVlrlId());
            }

            if (vlrl.getRgla().getTipo() != ReglaTipo.T) {
                Preconditions.checkNotNull(vlrd.getPadreId());
                Preconditions.checkNotNull(vlrd.getImporteBase());
            }

            vlrd.setVlrcId(vlrl.getVlrcId());
            vlrd.setId(igBO.nextVal(IgBO.SQ_INTEGRA));

            if (vlrl.getRgla().getTipo() == ReglaTipo.T) {
                vlrd.setPadreId(vlrd.getId());
                vlrd.setImporteBase(0.0);
            }

            final ValoracionDetalleDAO vlrdDAO = session.getMapper(ValoracionDetalleDAO.class);

            vlrdDAO.insert(vlrd);

            final ValoracionDAO vlrcDAO = session.getMapper(ValoracionDAO.class);

            vlrcDAO.updateImporte(vlrd.getVlrcId());

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param vlrd
     *            the vlrd
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void update(final @NonNull ValoracionDetalleVO vlrd) throws InstanceNotFoundException {
        Preconditions.checkNotNull(vlrd.getId());
        Preconditions.checkNotNull(vlrd.getVlrlId());
        Preconditions.checkNotNull(vlrd.getVlrcId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ValoracionDetalleDAO vlrdDAO = session.getMapper(ValoracionDetalleDAO.class);
            final int updated = vlrdDAO.update(vlrd);

            if (updated == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.vlrd, vlrd.getId());
            }

            final ValoracionDAO vlrcDAO = session.getMapper(ValoracionDAO.class);

            vlrcDAO.updateImporte(vlrd.getVlrcId());

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param vlrd
     *            the vlrd
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(final @NonNull ValoracionDetalleVO vlrd) throws InstanceNotFoundException {
        Preconditions.checkNotNull(vlrd.getId());
        Preconditions.checkNotNull(vlrd.getVlrlId());
        Preconditions.checkNotNull(vlrd.getVlrcId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ValoracionDetalleDAO vlrdDAO = session.getMapper(ValoracionDetalleDAO.class);

            if (vlrdDAO.delete(vlrd) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.vlrd, vlrd.getId());
            }

            // Si el detalle que se está borrando es el único de la línea, se borra dicha linea tambien.
            final ValoracionDetalleCriterioVO vlrdCriterioVO = new ValoracionDetalleCriterioVO();

            vlrdCriterioVO.setVlrlId(vlrd.getVlrlId());

            if (vlrdDAO.count(vlrdCriterioVO) == 0) {
                final ValoracionLineaDAO vlrlDAO = session.getMapper(ValoracionLineaDAO.class);
                final ValoracionLineaCriterioVO vlrlCriterioVO = new ValoracionLineaCriterioVO();

                vlrlCriterioVO.setId(vlrd.getVlrlId());

                vlrlDAO.deleteList(vlrlCriterioVO);
            }

            final ValoracionDAO vlrcDAO = session.getMapper(ValoracionDAO.class);

            vlrcDAO.updateImporte(vlrd.getVlrcId());

            session.commit();
        }
    }
}
