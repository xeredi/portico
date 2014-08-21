package xeredi.integra.model.facturacion.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import xeredi.integra.model.facturacion.dao.FacturaCargoDAO;
import xeredi.integra.model.facturacion.dao.FacturaDAO;
import xeredi.integra.model.facturacion.dao.FacturaDetalleDAO;
import xeredi.integra.model.facturacion.dao.FacturaImpuestoDAO;
import xeredi.integra.model.facturacion.dao.FacturaLineaDAO;
import xeredi.integra.model.facturacion.dao.FacturaServicioDAO;
import xeredi.integra.model.facturacion.vo.FacturaCargoVO;
import xeredi.integra.model.facturacion.vo.FacturaCriterioVO;
import xeredi.integra.model.facturacion.vo.FacturaDetalleCriterioVO;
import xeredi.integra.model.facturacion.vo.FacturaDetalleVO;
import xeredi.integra.model.facturacion.vo.FacturaImpuestoVO;
import xeredi.integra.model.facturacion.vo.FacturaLineaCriterioVO;
import xeredi.integra.model.facturacion.vo.FacturaLineaVO;
import xeredi.integra.model.facturacion.vo.FacturaServicioVO;
import xeredi.integra.model.facturacion.vo.FacturaVO;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaBO.
 */
@Singleton
public class FacturaBO implements Factura {

    /** The fctr dao. */
    @Inject
    FacturaDAO fctrDAO;

    /** The fctg dao. */
    @Inject
    FacturaCargoDAO fctgDAO;

    /** The fcti dao. */
    @Inject
    FacturaImpuestoDAO fctiDAO;

    /** The fcts dao. */
    @Inject
    FacturaServicioDAO fctsDAO;

    /** The fctl dao. */
    @Inject
    FacturaLineaDAO fctlDAO;

    /** The fctd dao. */
    @Inject
    FacturaDetalleDAO fctdDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(executorType = ExecutorType.BATCH)
    public List<FacturaImpresionVO> selectImprimir(final Set<Long> fctrIds) {
        Preconditions.checkNotNull(fctrIds);
        Preconditions.checkArgument(!fctrIds.isEmpty());

        final List<FacturaImpresionVO> list = new ArrayList<>();

        for (final Long fctrId : fctrIds) {
            final FacturaCriterioVO fctrCriterioVO = new FacturaCriterioVO();
            final FacturaLineaCriterioVO fctlCriterioVO = new FacturaLineaCriterioVO();

            fctrCriterioVO.setId(fctrId);
            fctlCriterioVO.setFctr(fctrCriterioVO);

            final FacturaVO fctr = fctrDAO.select(fctrId);

            if (fctr != null) {
                final List<FacturaCargoVO> fctgList = fctgDAO.selectList(fctrCriterioVO);
                final List<FacturaImpuestoVO> fctiList = fctiDAO.selectList(fctrCriterioVO);
                final List<FacturaServicioVO> fctsList = fctsDAO.selectList(fctrCriterioVO);
                final List<FacturaLineaVO> fctlList = fctlDAO.selectList(fctlCriterioVO);

                final Map<Long, FacturaServicioVO> fctsMap = new HashMap<>();

                for (final FacturaServicioVO fcts : fctsList) {
                    fctsMap.put(fcts.getId(), fcts);
                }

                list.add(new FacturaImpresionVO(fctr, fctgList, fctiList, fctlList, fctsMap));
            }
        }

        return list;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FacturaVO select(final Long fctrId) {
        Preconditions.checkNotNull(fctrId);

        return fctrDAO.select(fctrId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginatedList<FacturaVO> selectList(final FacturaCriterioVO fctrCriterioVO, final int offset, final int limit) {
        Preconditions.checkNotNull(fctrCriterioVO);
        Preconditions.checkArgument(offset >= 0);
        Preconditions.checkArgument(limit > 0);

        final int count = fctrDAO.count(fctrCriterioVO);
        final List<FacturaVO> fctrList = new ArrayList<>();

        if (count >= offset) {
            fctrList.addAll(fctrDAO.selectList(fctrCriterioVO, new RowBounds(offset, limit)));
        }

        return new PaginatedList<FacturaVO>(fctrList, offset, limit, count);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<FacturaServicioVO> selectFctsList(Long fctrId) {
        Preconditions.checkNotNull(fctrId);

        final FacturaCriterioVO fctrCriterioVO = new FacturaCriterioVO();

        fctrCriterioVO.setId(fctrId);

        return fctsDAO.selectList(fctrCriterioVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<FacturaImpuestoVO> selectFctiList(Long fctrId) {
        Preconditions.checkNotNull(fctrId);

        final FacturaCriterioVO fctrCriterioVO = new FacturaCriterioVO();

        fctrCriterioVO.setId(fctrId);

        return fctiDAO.selectList(fctrCriterioVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<FacturaCargoVO> selectFctgList(Long fctrId) {
        Preconditions.checkNotNull(fctrId);

        final FacturaCriterioVO fctrCriterioVO = new FacturaCriterioVO();

        fctrCriterioVO.setId(fctrId);

        return fctgDAO.selectList(fctrCriterioVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginatedList<FacturaLineaVO> selectFctlList(Long fctrId, final int offset, final int limit) {
        Preconditions.checkNotNull(fctrId);
        Preconditions.checkArgument(offset >= 0);
        Preconditions.checkArgument(limit > 0);

        final FacturaLineaCriterioVO fctlCriterioVO = new FacturaLineaCriterioVO();
        final FacturaCriterioVO fctrCriterioVO = new FacturaCriterioVO();

        fctrCriterioVO.setId(fctrId);
        fctlCriterioVO.setFctr(fctrCriterioVO);

        final int count = fctlDAO.count(fctlCriterioVO);
        final List<FacturaLineaVO> fctlList = new ArrayList<>();

        if (count >= offset) {
            fctlList.addAll(fctlDAO.selectList(fctlCriterioVO, new RowBounds(offset, limit)));
        }

        return new PaginatedList<FacturaLineaVO>(fctlList, offset, limit, count);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FacturaLineaVO selectFctl(Long fctlId) {
        Preconditions.checkNotNull(fctlId);

        return fctlDAO.select(fctlId);
    }

    /**
     * {@inheritDoc}
     *
     * @see FacturaDetalleDAO#count(FacturaDetalleCriterioVO)
     * @see FacturaDetalleDAO#selectList(FacturaDetalleCriterioVO, RowBounds)
     */
    @Override
    public PaginatedList<FacturaDetalleVO> selectFctdList(Long fctlId, int offset, int limit) {
        Preconditions.checkNotNull(fctlId);
        Preconditions.checkArgument(offset >= 0);
        Preconditions.checkArgument(limit > 0);

        final FacturaDetalleCriterioVO fctdCriterioVO = new FacturaDetalleCriterioVO();
        final FacturaLineaCriterioVO fctlCriterioVO = new FacturaLineaCriterioVO();

        fctlCriterioVO.setId(fctlId);
        fctdCriterioVO.setFctl(fctlCriterioVO);

        final int count = fctdDAO.count(fctdCriterioVO);
        final List<FacturaDetalleVO> fctdList = new ArrayList<>();

        if (count >= offset) {
            fctdList.addAll(fctdDAO.selectList(fctdCriterioVO, new RowBounds(offset, limit)));
        }

        return new PaginatedList<FacturaDetalleVO>(fctdList, offset, limit, count);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FacturaDetalleVO selectFctd(Long fctdId) {
        Preconditions.checkNotNull(fctdId);

        return fctdDAO.select(fctdId);
    }

}
