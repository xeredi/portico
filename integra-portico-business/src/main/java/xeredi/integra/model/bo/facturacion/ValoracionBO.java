package xeredi.integra.model.bo.facturacion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import xeredi.integra.model.dao.facturacion.ServicioCargoDAO;
import xeredi.integra.model.dao.facturacion.ValoracionCargoDAO;
import xeredi.integra.model.dao.facturacion.ValoracionDAO;
import xeredi.integra.model.dao.facturacion.ValoracionDetalleDAO;
import xeredi.integra.model.dao.facturacion.ValoracionImpuestoDAO;
import xeredi.integra.model.dao.facturacion.ValoracionLineaDAO;
import xeredi.integra.model.vo.facturacion.ServicioCargoCriterioVO;
import xeredi.integra.model.vo.facturacion.ValoracionCargoVO;
import xeredi.integra.model.vo.facturacion.ValoracionCriterioVO;
import xeredi.integra.model.vo.facturacion.ValoracionDetalleCriterioVO;
import xeredi.integra.model.vo.facturacion.ValoracionDetalleVO;
import xeredi.integra.model.vo.facturacion.ValoracionImpuestoVO;
import xeredi.integra.model.vo.facturacion.ValoracionLineaCriterioVO;
import xeredi.integra.model.vo.facturacion.ValoracionLineaVO;
import xeredi.integra.model.vo.facturacion.ValoracionVO;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionBO.
 */
@Singleton
public class ValoracionBO implements Valoracion {

    /** The vlrc dao. */
    @Inject
    ValoracionDAO vlrcDAO;

    /** The vlrl dao. */
    @Inject
    ValoracionLineaDAO vlrlDAO;

    /** The vlrd dao. */
    @Inject
    ValoracionDetalleDAO vlrdDAO;

    /** The vlri dao. */
    @Inject
    ValoracionImpuestoDAO vlriDAO;

    /** The vlrg dao. */
    @Inject
    ValoracionCargoDAO vlrgDAO;

    /** The srcr dao. */
    @Inject
    ServicioCargoDAO srcrDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(executorType = ExecutorType.BATCH)
    public void delete(final Long id) {
        Preconditions.checkNotNull(id);

        final Set<Long> vlrcIds = new HashSet<Long>();
        final ValoracionCriterioVO vlrcCriterioVO = new ValoracionCriterioVO();
        final ValoracionLineaCriterioVO vlrlCriterioVO = new ValoracionLineaCriterioVO();
        final ValoracionDetalleCriterioVO vlrdCriterioVO = new ValoracionDetalleCriterioVO();
        final ServicioCargoCriterioVO srcrCriterioVO = new ServicioCargoCriterioVO();

        vlrcIds.add(id);
        srcrCriterioVO.setVlrcIds(vlrcIds);
        vlrcCriterioVO.setId(id);
        vlrlCriterioVO.setVlrc(vlrcCriterioVO);
        vlrdCriterioVO.setVlrl(vlrlCriterioVO);

        srcrDAO.deleteValoracion(srcrCriterioVO);

        vlrdDAO.delete(vlrdCriterioVO);
        vlrlDAO.delete(vlrlCriterioVO);
        vlriDAO.delete(vlrcCriterioVO);
        vlrgDAO.delete(vlrcCriterioVO);
        vlrcDAO.delete(vlrcCriterioVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public ValoracionVO select(final Long id) {
        Preconditions.checkNotNull(id);

        final ValoracionVO vlrc = vlrcDAO.select(id);

        return vlrc;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<ValoracionImpuestoVO> selectImpuestosList(final ValoracionCriterioVO vlrcCriterioVO) {
        Preconditions.checkNotNull(vlrcCriterioVO);

        return vlriDAO.selectList(vlrcCriterioVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<ValoracionCargoVO> selectCargosList(final ValoracionCriterioVO vlrcCriterioVO) {
        Preconditions.checkNotNull(vlrcCriterioVO);

        return vlrgDAO.selectList(vlrcCriterioVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public ValoracionLineaVO selectLinea(final Long vlrlId) {
        Preconditions.checkNotNull(vlrlId);

        return vlrlDAO.select(vlrlId);
    }

    @Override
    @Transactional
    public boolean existsLineaDependencia(final Long vlrlId) {
        Preconditions.checkNotNull(vlrlId);

        return vlrlDAO.existsDependencia(vlrlId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void deleteLinea(final Long vlrlId) {
        Preconditions.checkNotNull(vlrlId);

        if (vlrlDAO.existsDependencia(vlrlId)) {
            throw new Error("No se puede borrar la linea '" + vlrlId + "' porque tiene lineas dependientes");
        }

        final ValoracionLineaVO vlrl = vlrlDAO.select(vlrlId);

        if (vlrl != null) {
            final ValoracionCriterioVO vlrcCriterioVO = new ValoracionCriterioVO();
            final ValoracionLineaCriterioVO vlrlCriterioVO = new ValoracionLineaCriterioVO();
            final ValoracionDetalleCriterioVO vlrdCriterioVO = new ValoracionDetalleCriterioVO();

            vlrcCriterioVO.setId(vlrl.getVlrcId());

            vlrlCriterioVO.setId(vlrlId);
            vlrlCriterioVO.setVlrc(vlrcCriterioVO);

            vlrdCriterioVO.setVlrl(vlrlCriterioVO);

            vlrdDAO.delete(vlrdCriterioVO);
            vlrlDAO.delete(vlrlCriterioVO);

            // Recalcular cargos e importes de IVA
            vlrgDAO.delete(vlrcCriterioVO);
            vlrgDAO.insertGenerate(vlrcCriterioVO);
            vlriDAO.delete(vlrcCriterioVO);

            final List<ValoracionImpuestoVO> vlriList = vlriDAO.selectGenerateList(vlrcCriterioVO);

            for (final ValoracionImpuestoVO vlri : vlriList) {
                vlriDAO.insert(vlri);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<ValoracionLineaVO> selectLineasList(final ValoracionLineaCriterioVO vlrlCriterioVO) {
        Preconditions.checkNotNull(vlrlCriterioVO);

        return vlrlDAO.selectList(vlrlCriterioVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public PaginatedList<ValoracionLineaVO> selectLineasList(final ValoracionLineaCriterioVO vlrlCriterioVO,
            final int offset, final int limit) {
        Preconditions.checkNotNull(vlrlCriterioVO);

        final int count = vlrlDAO.count(vlrlCriterioVO);
        final List<ValoracionLineaVO> vlrlList = new ArrayList<>();

        if (count >= offset) {
            vlrlList.addAll(vlrlDAO.selectList(vlrlCriterioVO, new RowBounds(offset, limit)));
        }

        return new PaginatedList<ValoracionLineaVO>(vlrlList, offset, limit, count);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public ValoracionDetalleVO selectDetalle(final Long vlrdId) {
        Preconditions.checkNotNull(vlrdId);

        return vlrdDAO.select(vlrdId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public PaginatedList<ValoracionDetalleVO> selectDetallesList(final ValoracionDetalleCriterioVO vlrdCriterioVO,
            final int offset, final int limit) {
        Preconditions.checkNotNull(vlrdCriterioVO);

        final int count = vlrdDAO.count(vlrdCriterioVO);
        final List<ValoracionDetalleVO> vlrdList = new ArrayList<>();

        if (count >= offset) {
            vlrdList.addAll(vlrdDAO.selectList(vlrdCriterioVO, new RowBounds(offset, limit)));
        }

        return new PaginatedList<ValoracionDetalleVO>(vlrdList, offset, limit, count);
    }

}
