package xeredi.argo.model.facturacion.bo;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import lombok.NonNull;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.argo.model.comun.bo.IgBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.dao.FacturaDAO;
import xeredi.argo.model.facturacion.dao.FacturaSerieDAO;
import xeredi.argo.model.facturacion.dao.ValoracionDAO;
import xeredi.argo.model.facturacion.dao.ValoracionDetalleDAO;
import xeredi.argo.model.facturacion.dao.ValoracionLineaDAO;
import xeredi.argo.model.facturacion.vo.FacturaAnulacionVO;
import xeredi.argo.model.facturacion.vo.FacturaCriterioVO;
import xeredi.argo.model.facturacion.vo.FacturaEstado;
import xeredi.argo.model.facturacion.vo.FacturaSerieCriterioVO;
import xeredi.argo.model.facturacion.vo.FacturaSerieVO;
import xeredi.argo.model.facturacion.vo.FacturaVO;
import xeredi.argo.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionDetalleCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionDetalleVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaVO;
import xeredi.argo.model.facturacion.vo.ValoracionVO;
import xeredi.util.mybatis.SqlMapperLocator;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaAnulacionBO.
 */
public final class FacturaAnulacionBO {

    /**
     * Anular.
     *
     * @param fcan
     *            the fcan
     * @throws ApplicationException
     *             the application exception
     */
    public void anular(final @NonNull FacturaAnulacionVO fcan) throws ApplicationException {
        Preconditions.checkNotNull(fcan.getFctrId());
        Preconditions.checkNotNull(fcan.getFecha());
        Preconditions.checkNotNull(fcan.getFcsrId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final FacturaDAO fctrDAO = session.getMapper(FacturaDAO.class);
            final FacturaSerieDAO fcsrDAO = session.getMapper(FacturaSerieDAO.class);

            final boolean existsValoracionPosterior = fctrDAO.existsValoracionPosterior(fcan.getFctrId());
            final boolean existsFacturaPosterior = fctrDAO.existsFacturaPosterior(fcan.getFctrId());

            if (existsValoracionPosterior && !existsFacturaPosterior) {
                throw new Error("No se puede eliminar una factura con valoraciones posteriores");
            }

            final FacturaCriterioVO fctrCriterioVO = new FacturaCriterioVO();

            fctrCriterioVO.setId(fcan.getFctrId());

            final FacturaVO fctr = fctrDAO.selectObject(fctrCriterioVO);

            if (fctr == null) {
                throw new InstanceNotFoundException(MessageI18nKey.fctr, fcan.getFctrId());
            }

            if (fctr.getEstado() != FacturaEstado.NO) {
                throw new Error("Estado de factura no valido para anulacion: " + fctr.getEstado());
            }

            if (fcsrDAO.updateIncrementar(fcan.getFcsrId()) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.fcsr, fcan.getFcsrId());
            }

            // Modificar el estado de la factura original - Pasa a Anulada
            fctr.setEstado(FacturaEstado.AN);

            fctrDAO.updateEstado(fctr);

            // Crear nueva factura a partir de los datos de la factura anulada.
            final Map<Long, Long> idsMap = new HashMap<>();
            final IgBO igBO = new IgBO();

            final FacturaSerieCriterioVO fcsrCriterio = new FacturaSerieCriterioVO();

            fcsrCriterio.setId(fcan.getFcsrId());

            final FacturaSerieVO fcsr = fcsrDAO.selectObject(fcsrCriterio);
            final FacturaVO fctrCopia = new FacturaVO();

            fctrCopia.setAspc(fctr.getAspc());
            fctrCopia.setEstado(fctr.getImporte() > 0 ? FacturaEstado.RN : FacturaEstado.RP);
            fctrCopia.setFalta(Calendar.getInstance().getTime());
            fctrCopia.setFcsr(fcsr);
            fctrCopia.setFini(fctr.getFini());
            fctrCopia.setFfin(fctr.getFfin());
            fctrCopia.setFref(fctr.getFref());
            fctrCopia.setImporte(-fctr.getImporte());
            fctrCopia.setImpuesto(-fctr.getImpuesto());
            fctrCopia.setPagador(fctr.getPagador());
            fctrCopia.setSujPasivo(fctr.getSujPasivo());

            fctrCopia.setInfo1(fctr.getInfo1());
            fctrCopia.setInfo2(fctr.getInfo2());
            fctrCopia.setInfo3(fctr.getInfo3());
            fctrCopia.setInfo4(fctr.getInfo4());
            fctrCopia.setInfo5(fctr.getInfo5());
            fctrCopia.setInfo6(fctr.getInfo6());

            idsMap.put(fctr.getId(), igBO.nextVal(IgBO.SQ_INTEGRA));

            fctrCopia.setId(idsMap.get(fctr.getId()));
            fctrCopia.setNumero(fcsr.getNumeroUltimo());

            fcsr.setNumeroUltimo(fcsr.getNumeroUltimo() + 1);

            fctrDAO.insert(fctrCopia);
            fcsrDAO.update(fcsr);

            final ValoracionDAO vlrcDAO = session.getMapper(ValoracionDAO.class);
            final ValoracionCriterioVO vlrcCriterio = new ValoracionCriterioVO();

            vlrcCriterio.setFctr(fctr);

            for (final ValoracionVO vlrc : vlrcDAO.selectList(vlrcCriterio)) {
                final ValoracionVO vlrcCopia = new ValoracionVO();

                idsMap.put(vlrc.getId(), igBO.nextVal(IgBO.SQ_INTEGRA));

                vlrcCopia.setId(idsMap.get(vlrc.getId()));
                vlrcCopia.setAspc(vlrc.getAspc());
                vlrcCopia.setCodExencion(vlrc.getCodExencion());
                vlrcCopia.setFalta(Calendar.getInstance().getTime());
                vlrcCopia.setFctr(fctrCopia);
                vlrcCopia.setFini(vlrc.getFini());
                vlrcCopia.setFfin(vlrc.getFfin());
                vlrcCopia.setFref(vlrc.getFref());
                vlrcCopia.setFliq(vlrc.getFliq());
                vlrcCopia.setImporte(-vlrc.getImporte());
                vlrcCopia.setImpuesto(-vlrc.getImpuesto());
                vlrcCopia.setPagador(vlrc.getPagador());
                vlrcCopia.setSrvc(vlrc.getSrvc());
                vlrcCopia.setSujPasivo(vlrc.getSujPasivo());

                vlrcCopia.setInfo1(vlrc.getInfo1());
                vlrcCopia.setInfo2(vlrc.getInfo2());
                vlrcCopia.setInfo3(vlrc.getInfo3());
                vlrcCopia.setInfo4(vlrc.getInfo4());
                vlrcCopia.setInfo5(vlrc.getInfo5());
                vlrcCopia.setInfo6(vlrc.getInfo6());

                vlrcDAO.insert(vlrcCopia);
            }

            final ValoracionLineaDAO vlrlDAO = session.getMapper(ValoracionLineaDAO.class);
            final ValoracionLineaCriterioVO vlrlCriterio = new ValoracionLineaCriterioVO();

            vlrlCriterio.setFctrId(fctr.getId());

            for (final ValoracionLineaVO vlrl : vlrlDAO.selectList(vlrlCriterio)) {
                final ValoracionLineaVO vlrlCopia = new ValoracionLineaVO();

                idsMap.put(vlrl.getId(), igBO.nextVal(IgBO.SQ_INTEGRA));

                vlrlCopia.setId(idsMap.get(vlrl.getId()));
                vlrlCopia.setPadreId(idsMap.get(vlrl.getPadreId()));
                vlrlCopia.setVlrcId(idsMap.get(vlrl.getVlrcId()));

                vlrlCopia.setInfo1(vlrl.getInfo1());
                vlrlCopia.setInfo2(vlrl.getInfo2());
                vlrlCopia.setInfo3(vlrl.getInfo3());
                vlrlCopia.setInfo4(vlrl.getInfo4());
                vlrlCopia.setInfo5(vlrl.getInfo5());
                vlrlCopia.setInfo6(vlrl.getInfo6());

                vlrlCopia.setFini(vlrl.getFini());
                vlrlCopia.setFfin(vlrl.getFfin());
                vlrlCopia.setImpuesto(vlrl.getImpuesto());
                vlrlCopia.setRgla(vlrl.getRgla());
                vlrlCopia.setSsrv(vlrl.getSsrv());

                vlrlDAO.insert(vlrlCopia);
            }

            final ValoracionDetalleDAO vlrdDAO = session.getMapper(ValoracionDetalleDAO.class);
            final ValoracionDetalleCriterioVO vlrdCriterio = new ValoracionDetalleCriterioVO();

            vlrdCriterio.setFctrId(fctr.getId());

            for (final ValoracionDetalleVO vlrd : vlrdDAO.selectList(vlrdCriterio)) {
                final ValoracionDetalleVO vlrdCopia = new ValoracionDetalleVO();

                idsMap.put(vlrd.getId(), igBO.nextVal(IgBO.SQ_INTEGRA));

                vlrdCopia.setId(idsMap.get(vlrd.getId()));
                vlrdCopia.setPadreId(idsMap.get(vlrd.getPadreId()));
                vlrdCopia.setVlrcId(idsMap.get(vlrd.getVlrcId()));
                vlrdCopia.setVlrlId(idsMap.get(vlrd.getVlrlId()));

                vlrdCopia.setCuant1(vlrd.getCuant1());
                vlrdCopia.setCuant2(vlrd.getCuant2());
                vlrdCopia.setCuant3(vlrd.getCuant3());
                vlrdCopia.setCuant4(vlrd.getCuant4());
                vlrdCopia.setCuant5(vlrd.getCuant5());
                vlrdCopia.setCuant6(vlrd.getCuant6());

                vlrdCopia.setInfo1(vlrd.getInfo1());
                vlrdCopia.setInfo2(vlrd.getInfo2());
                vlrdCopia.setInfo3(vlrd.getInfo3());
                vlrdCopia.setInfo4(vlrd.getInfo4());
                vlrdCopia.setInfo5(vlrd.getInfo5());
                vlrdCopia.setInfo6(vlrd.getInfo6());

                vlrdCopia.setFini(vlrd.getFini());
                vlrdCopia.setFfin(vlrd.getFfin());
                vlrdCopia.setImporte(-vlrd.getImporte());
                vlrdCopia.setImporteBase(-vlrd.getImporteBase());
                vlrdCopia.setSsrv(vlrd.getSsrv());
                vlrdCopia.setValorBase(vlrd.getValorBase());

                vlrdDAO.insert(vlrdCopia);
            }

            fcan.setFctrAnulacionId(fctrCopia.getId());

            session.commit();
        }
    }
}
