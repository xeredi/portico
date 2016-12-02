package xeredi.argo.model.facturacion.bo;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.dao.FacturaDAO;
import xeredi.argo.model.facturacion.dao.ValoracionDAO;
import xeredi.argo.model.facturacion.dao.ValoracionDetalleDAO;
import xeredi.argo.model.facturacion.dao.ValoracionLineaDAO;
import xeredi.argo.model.facturacion.vo.FacturaCriterioVO;
import xeredi.argo.model.facturacion.vo.FacturaRectificacionVO;
import xeredi.argo.model.facturacion.vo.FacturaVO;
import xeredi.argo.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionDetalleCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionDetalleVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaVO;
import xeredi.argo.model.facturacion.vo.ValoracionVO;
import xeredi.argo.model.util.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaRectificacionBO.
 */
public final class FacturaRectificacionBO {

    /**
     * Rectificar.
     *
     * @param fcrc
     *            the fcrc
     * @throws ApplicationException
     *             the application exception
     */
    public void rectificar(@NonNull final FacturaRectificacionVO fcrc) throws ApplicationException {
        Preconditions.checkNotNull(fcrc.getFctrId());
        Preconditions.checkNotNull(fcrc.getVlrcId());
        Preconditions.checkNotNull(fcrc.getDuplicar());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final FacturaDAO fctrDAO = session.getMapper(FacturaDAO.class);
            final ValoracionDAO vlrcDAO = session.getMapper(ValoracionDAO.class);
            final ValoracionLineaDAO vlrlDAO = session.getMapper(ValoracionLineaDAO.class);
            final ValoracionDetalleDAO vlrdDAO = session.getMapper(ValoracionDetalleDAO.class);

            final FacturaCriterioVO fctrCriterio = new FacturaCriterioVO();

            fctrCriterio.setId(fcrc.getFctrId());

            final FacturaVO fctr = fctrDAO.selectObject(fctrCriterio);

            if (fctr == null) {
                throw new InstanceNotFoundException(MessageI18nKey.fctr, fcrc.getFctrId());
            }

            final ValoracionCriterioVO vlrcCriterio = new ValoracionCriterioVO();

            vlrcCriterio.setId(fcrc.getVlrcId());

            final ValoracionVO vlrc = vlrcDAO.selectObject(vlrcCriterio);

            if (vlrc == null) {
                throw new InstanceNotFoundException(MessageI18nKey.vlrc, fcrc.getVlrcId());
            }

            if (!vlrc.getFctr().getId().equals(fctr.getId())) {
                throw new Error("No coinciden los identificadores de factura de la factura y la valoracion");
            }

            // Creacion de la valoracion
            final Map<Long, Long> idsMap = new HashMap<>();

            final ValoracionVO vlrcCopia = new ValoracionVO();

            vlrcCopia.setAspc(vlrc.getAspc());
            vlrcCopia.setCodExencion(vlrc.getCodExencion());
            vlrcCopia.setFalta(Calendar.getInstance().getTime());
            vlrcCopia.setFctr(null);
            vlrcCopia.setFctrRectificada(fctr);
            vlrcCopia.setFini(vlrc.getFini());
            vlrcCopia.setFfin(vlrc.getFfin());
            vlrcCopia.setFliq(vlrc.getFliq());
            vlrcCopia.setFref(vlrc.getFref());
            vlrcCopia.setImporte(vlrc.getImporte());
            vlrcCopia.setImpuesto(vlrc.getImpuesto());
            vlrcCopia.setPagador(vlrc.getPagador());
            vlrcCopia.setSrvc(vlrc.getSrvc());
            vlrcCopia.setSujPasivo(vlrc.getSujPasivo());
            vlrcCopia.setInfo1(vlrc.getInfo1());
            vlrcCopia.setInfo2(vlrc.getInfo2());
            vlrcCopia.setInfo3(vlrc.getInfo3());
            vlrcCopia.setInfo4(vlrc.getInfo4());
            vlrcCopia.setInfo5(vlrc.getInfo5());
            vlrcCopia.setInfo6(vlrc.getInfo6());

            IgUtilBO.assignNextVal(vlrcCopia);

            idsMap.put(vlrc.getId(), vlrcCopia.getId());

            vlrcDAO.insert(vlrcCopia);

            if (fcrc.getDuplicar()) {
                final ValoracionLineaCriterioVO vlrlCriterio = new ValoracionLineaCriterioVO();

                vlrlCriterio.setVlrcId(fcrc.getVlrcId());

                for (final ValoracionLineaVO vlrl : vlrlDAO.selectList(vlrlCriterio)) {
                    final ValoracionLineaVO vlrlCopia = new ValoracionLineaVO();

                    vlrlCopia.setFini(vlrl.getFini());
                    vlrlCopia.setFfin(vlrl.getFfin());
                    vlrlCopia.setFref(vlrl.getFref());
                    vlrlCopia.setRgla(vlrl.getRgla());
                    vlrlCopia.setSrvcId(vlrl.getSrvcId());
                    vlrlCopia.setSsrv(vlrl.getSsrv());
                    vlrlCopia.setImpuesto(vlrl.getImpuesto());

                    vlrlCopia.setInfo1(vlrl.getInfo1());
                    vlrlCopia.setInfo2(vlrl.getInfo2());
                    vlrlCopia.setInfo3(vlrl.getInfo3());
                    vlrlCopia.setInfo4(vlrl.getInfo4());
                    vlrlCopia.setInfo5(vlrl.getInfo5());
                    vlrlCopia.setInfo6(vlrl.getInfo6());

                    vlrlCopia.setCuant1(vlrl.getCuant1());
                    vlrlCopia.setCuant2(vlrl.getCuant2());
                    vlrlCopia.setCuant3(vlrl.getCuant3());
                    vlrlCopia.setCuant4(vlrl.getCuant4());
                    vlrlCopia.setCuant5(vlrl.getCuant5());
                    vlrlCopia.setCuant6(vlrl.getCuant6());

                    IgUtilBO.assignNextVal(vlrlCopia);

                    idsMap.put(vlrl.getId(), vlrlCopia.getId());

                    vlrlCopia.setPadreId(idsMap.get(vlrl.getPadreId()));
                    vlrlCopia.setVlrcId(vlrcCopia.getId());

                    vlrlDAO.insert(vlrlCopia);
                }

                final ValoracionDetalleCriterioVO vlrdCriterio = new ValoracionDetalleCriterioVO();

                vlrdCriterio.setVlrcId(fcrc.getVlrcId());

                for (final ValoracionDetalleVO vlrd : vlrdDAO.selectList(vlrdCriterio)) {
                    final ValoracionDetalleVO vlrdCopia = new ValoracionDetalleVO();

                    IgUtilBO.assignNextVal(vlrdCopia);

                    idsMap.put(vlrd.getId(), vlrdCopia.getId());

                    vlrdCopia.setPadreId(idsMap.get(vlrd.getPadreId()));
                    vlrdCopia.setVlrlId(idsMap.get(vlrd.getVlrlId()));
                    vlrdCopia.setVlrcId(vlrcCopia.getId());
                    vlrdCopia.setFini(vlrd.getFini());
                    vlrdCopia.setFfin(vlrd.getFfin());
                    vlrdCopia.setFref(vlrd.getFref());
                    vlrdCopia.setImporteBase(vlrd.getImporteBase());
                    vlrdCopia.setImporte(vlrd.getImporte());
                    vlrdCopia.setValorBase(vlrd.getValorBase());
                    vlrdCopia.setRgla(vlrd.getRgla());
                    vlrdCopia.setSsrv(vlrd.getSsrv());

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

                    vlrdDAO.insert(vlrdCopia);
                }
            }

            vlrcDAO.updateImporte(vlrcCopia.getId());

            session.commit();

            fcrc.setVlrcRectificacionId(vlrcCopia.getId());
        }
    }
}
