package xeredi.integra.model.facturacion.bo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.guice.transactional.Transactional;

import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.facturacion.dao.FacturaCargoDAO;
import xeredi.integra.model.facturacion.dao.FacturaDAO;
import xeredi.integra.model.facturacion.dao.FacturaDetalleDAO;
import xeredi.integra.model.facturacion.dao.FacturaImpuestoDAO;
import xeredi.integra.model.facturacion.dao.FacturaLineaDAO;
import xeredi.integra.model.facturacion.dao.FacturaSerieDAO;
import xeredi.integra.model.facturacion.dao.FacturaServicioDAO;
import xeredi.integra.model.facturacion.vo.FacturaCargoVO;
import xeredi.integra.model.facturacion.vo.FacturaCriterioVO;
import xeredi.integra.model.facturacion.vo.FacturaDetalleCriterioVO;
import xeredi.integra.model.facturacion.vo.FacturaDetalleVO;
import xeredi.integra.model.facturacion.vo.FacturaEstado;
import xeredi.integra.model.facturacion.vo.FacturaImpuestoVO;
import xeredi.integra.model.facturacion.vo.FacturaLineaCriterioVO;
import xeredi.integra.model.facturacion.vo.FacturaLineaVO;
import xeredi.integra.model.facturacion.vo.FacturaSerieVO;
import xeredi.integra.model.facturacion.vo.FacturaServicioCriterioVO;
import xeredi.integra.model.facturacion.vo.FacturaServicioVO;
import xeredi.integra.model.facturacion.vo.FacturaVO;
import xeredi.integra.model.facturacion.vo.ValoracionVO;
import xeredi.integra.model.util.GlobalNames;
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

    /** The fcsr dao. */
    @Inject
    FacturaSerieDAO fcsrDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(executorType = ExecutorType.BATCH)
    public void anular(final Long fctrId, final Date fechaAnulacion, final Long fcsrId, final String observaciones) {
        Preconditions.checkNotNull(fctrId);
        Preconditions.checkNotNull(fechaAnulacion);
        Preconditions.checkNotNull(fcsrId);

        final boolean existsValoracionPosterior = fctrDAO.existsValoracionPosterior(fctrId);
        final boolean existsFacturaPosterior = fctrDAO.existsFacturaPosterior(fctrId);

        if (existsValoracionPosterior && !existsFacturaPosterior) {
            throw new Error("No se puede eliminar una factura con valoraciones posteriores");
        }

        final FacturaCriterioVO fctrCriterioVO = new FacturaCriterioVO();
        final FacturaLineaCriterioVO fctlCriterioVO = new FacturaLineaCriterioVO();
        final FacturaDetalleCriterioVO fctdCriterioVO = new FacturaDetalleCriterioVO();

        fctrCriterioVO.setId(fctrId);
        fctlCriterioVO.setFctr(fctrCriterioVO);
        fctdCriterioVO.setFctl(fctlCriterioVO);

        final FacturaVO fctr = fctrDAO.select(fctrId);

        if (fctr == null) {
            throw new Error("No se encuentra la factura a anular");
        }

        if (fctr.getEstado() != FacturaEstado.NO) {
            throw new Error("Estado de factura no valido para anulacion: " + fctr.getEstado());
        }

        if (fcsrDAO.updateIncrementar(fcsrId) == 0) {
            throw new Error("No se encuentra serie de anulacion");
        }

        final FacturaSerieVO fcsr = fcsrDAO.select(fcsrId);
        final List<FacturaServicioVO> fctsList = fctsDAO.selectList(fctrCriterioVO);
        final List<FacturaCargoVO> fctgList = fctgDAO.selectList(fctrCriterioVO);
        final List<FacturaImpuestoVO> fctiList = fctiDAO.selectList(fctrCriterioVO);
        final List<FacturaLineaVO> fctlList = fctlDAO.selectList(fctlCriterioVO);
        final List<FacturaDetalleVO> fctdList = fctdDAO.selectList(fctdCriterioVO);

        final Map<Long, Long> generatedIds = new HashMap<>();
        final IgBO igBO = new IgBO();

        generatedIds.put(fctr.getId(), igBO.nextVal(GlobalNames.SQ_INTEGRA));

        fctr.setId(generatedIds.get(fctr.getId()));
        fctr.setFcsr(fcsr);
        fctr.setNumero(fcsr.getNumeroUltimo());
        fctr.setFalta(Calendar.getInstance().getTime());

        // FIXME Donde guardo la fecha de anulacion

        fctrDAO.insert(fctr);

        for (final FacturaServicioVO fcts : fctsList) {
            generatedIds.put(fcts.getId(), igBO.nextVal(GlobalNames.SQ_INTEGRA));

            fcts.setId(generatedIds.get(fcts.getId()));
            fcts.setFctrId(generatedIds.get(fcts.getFctrId()));

            fctsDAO.insert(fcts);
        }

        for (final FacturaCargoVO fctg : fctgList) {
            fctg.setFctrId(generatedIds.get(fctg.getFctrId()));

            fctgDAO.insert(fctg);
        }

        for (final FacturaImpuestoVO fcti : fctiList) {
            fcti.setFctrId(generatedIds.get(fcti.getFctrId()));
            fcti.setImporteBase(-fcti.getImporteBase());
            fcti.setImporteImpuesto(-fcti.getImporteImpuesto());

            fctiDAO.insert(fcti);
        }

        for (final FacturaLineaVO fctl : fctlList) {
            generatedIds.put(fctl.getId(), igBO.nextVal(GlobalNames.SQ_INTEGRA));

            fctl.setId(generatedIds.get(fctl.getId()));
            fctl.setFctrId(generatedIds.get(fctl.getFctrId()));

            fctlDAO.insert(fctl);
        }

        for (final FacturaDetalleVO fctd : fctdList) {
            generatedIds.put(fctd.getId(), igBO.nextVal(GlobalNames.SQ_INTEGRA));

            fctd.setId(generatedIds.get(fctd.getId()));
            fctd.setFctrId(generatedIds.get(fctd.getFctrId()));
            fctd.setFctlId(generatedIds.get(fctd.getFctlId()));
            fctd.setImporteBase(-fctd.getImporteBase());
            fctd.setImporte(-fctd.getImporte());

            fctdDAO.insert(fctd);
        }

        // FIXME Acabar
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(executorType = ExecutorType.BATCH)
    public Long rectificar(final Long fctrId, final Long fctsId, final boolean duplicarDatos) {
        Preconditions.checkNotNull(fctrId);
        Preconditions.checkNotNull(fctsId);

        final FacturaVO fctr = fctrDAO.select(fctrId);

        if (fctr == null) {
            throw new Error("Factura no encontrada");
        }

        final FacturaServicioVO fcts = fctsDAO.select(fctsId);

        if (fcts == null) {
            throw new Error("Servicio de Factura no encontrado");
        }

        if (fcts.getFctrId() != fctr.getId()) {
            throw new Error("No coinciden los identificadores de factura de la factura y el servicio de la factura");
        }

        // Busqueda de los datos de la factura que se van a copiar.
        final FacturaCriterioVO fctrCriterioVO = new FacturaCriterioVO();
        final FacturaServicioCriterioVO fctsCriterioVO = new FacturaServicioCriterioVO();
        final FacturaLineaCriterioVO fctlCriterioVO = new FacturaLineaCriterioVO();
        final FacturaDetalleCriterioVO fctdCriterioVO = new FacturaDetalleCriterioVO();

        fctrCriterioVO.setId(fctrId);
        fctsCriterioVO.setId(fctsId);

        fctrCriterioVO.setFcts(fctsCriterioVO);
        fctlCriterioVO.setFctr(fctrCriterioVO);
        fctdCriterioVO.setFctl(fctlCriterioVO);

        final List<FacturaImpuestoVO> fctiList = fctiDAO.selectList(fctrCriterioVO);
        final List<FacturaLineaVO> fctlList = fctlDAO.selectList(fctlCriterioVO);
        final List<FacturaDetalleVO> fctdList = fctdDAO.selectList(fctdCriterioVO);

        // Creacion de la valoracion
        final IgBO igBO = new IgBO();

        final ValoracionVO vlrc = new ValoracionVO();

        vlrc.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));

        vlrc.setAspc(fcts.getAspc());
        // vlrc.setCodExencion(fctr.get); // FIXME
        vlrc.setFalta(Calendar.getInstance().getTime());
        vlrc.setFini(fcts.getFini());
        vlrc.setFfin(fcts.getFfin());
        vlrc.setFliq(Calendar.getInstance().getTime());
        vlrc.setFref(fcts.getFref());
        vlrc.setPagador(fctr.getPagador());
        vlrc.setSrvc(fcts.getSrvc());
        // vlrc.setSujPasivo(value); // FIXME
        vlrc.setInfo1(fctr.getInfo1());
        vlrc.setInfo2(fctr.getInfo2());
        vlrc.setInfo3(fctr.getInfo3());
        vlrc.setInfo4(fctr.getInfo4());
        vlrc.setInfo5(fctr.getInfo5());
        vlrc.setInfo6(fctr.getInfo6());

        // FIXME Acabar
        return null;
    }

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
    public List<FacturaServicioVO> selectFctsList(final Long fctrId) {
        Preconditions.checkNotNull(fctrId);

        final FacturaCriterioVO fctrCriterioVO = new FacturaCriterioVO();

        fctrCriterioVO.setId(fctrId);

        return fctsDAO.selectList(fctrCriterioVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<FacturaImpuestoVO> selectFctiList(final Long fctrId) {
        Preconditions.checkNotNull(fctrId);

        final FacturaCriterioVO fctrCriterioVO = new FacturaCriterioVO();

        fctrCriterioVO.setId(fctrId);

        return fctiDAO.selectList(fctrCriterioVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<FacturaCargoVO> selectFctgList(final Long fctrId) {
        Preconditions.checkNotNull(fctrId);

        final FacturaCriterioVO fctrCriterioVO = new FacturaCriterioVO();

        fctrCriterioVO.setId(fctrId);

        return fctgDAO.selectList(fctrCriterioVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginatedList<FacturaLineaVO> selectFctlList(final Long fctrId, final int offset, final int limit) {
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
    public FacturaLineaVO selectFctl(final Long fctlId) {
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
    public PaginatedList<FacturaDetalleVO> selectFctdList(final Long fctlId, final int offset, final int limit) {
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
    public FacturaDetalleVO selectFctd(final Long fctdId) {
        Preconditions.checkNotNull(fctdId);

        return fctdDAO.select(fctdId);
    }

}
