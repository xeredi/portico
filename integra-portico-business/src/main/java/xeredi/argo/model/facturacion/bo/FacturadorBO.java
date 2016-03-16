package xeredi.argo.model.facturacion.bo;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import lombok.NonNull;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.argo.model.comun.bo.IgBO;
import xeredi.argo.model.facturacion.dao.FacturaDAO;
import xeredi.argo.model.facturacion.dao.FacturaSerieDAO;
import xeredi.argo.model.facturacion.dao.ValoracionDAO;
import xeredi.argo.model.facturacion.dao.ValoracionGrupoDAO;
import xeredi.argo.model.facturacion.vo.FacturaEstado;
import xeredi.argo.model.facturacion.vo.FacturaSerieCriterioVO;
import xeredi.argo.model.facturacion.vo.FacturaSerieVO;
import xeredi.argo.model.facturacion.vo.FacturaVO;
import xeredi.argo.model.facturacion.vo.ValoracionGrupoCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionGrupoVO;
import xeredi.argo.model.facturacion.vo.ValoracionVO;
import xeredi.argo.model.proceso.vo.MensajeCodigo;
import xeredi.argo.proceso.ProcesoTemplate;
import xeredi.util.mybatis.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturadorBO.
 */
public class FacturadorBO {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(FacturadorBO.class);

    /** The proceso template. */
    private final ProcesoTemplate procesoTemplate;

    /**
     * Instantiates a new facturador bo.
     *
     * @param aprocesoTemplate
     *            the aproceso template
     */
    public FacturadorBO(final ProcesoTemplate aprocesoTemplate) {
        super();
        procesoTemplate = aprocesoTemplate;
    }

    /**
     * Facturar valoraciones.
     *
     * @param vgrpCriterio
     *            the vgrp criterio
     * @param fcsrId
     *            the fcsr id
     * @param fechaFacturacion
     *            the fecha facturacion
     */
    public void facturarValoraciones(final @NonNull ValoracionGrupoCriterioVO vgrpCriterio, final @NonNull Long fcsrId,
            final @NonNull Date fechaFacturacion) {
        LOG.info("Facturacion de las valoraciones: " + vgrpCriterio);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final FacturaSerieDAO fcsrDAO = session.getMapper(FacturaSerieDAO.class);
            final FacturaSerieCriterioVO fcsrCriterio = new FacturaSerieCriterioVO();

            fcsrCriterio.setId(fcsrId);

            final FacturaSerieVO fcsr = fcsrDAO.selectObject(fcsrCriterio);

            if (fcsr == null) {
                LOG.fatal("Serie de factura no encontrada: " + fcsrId);

                procesoTemplate.addError(MensajeCodigo.G_001, FacturaSerieVO.class.getName());
            } else {
                LOG.info("Busqueda de Facturas");

                final ValoracionGrupoDAO vgrpDAO = session.getMapper(ValoracionGrupoDAO.class);
                final List<ValoracionGrupoVO> vgrpList = vgrpDAO.selectList(vgrpCriterio);

                final IgBO igBO = new IgBO();

                LOG.info("Inserción de Facturas");

                for (final ValoracionGrupoVO vgrp : vgrpList) {
                    final FacturaDAO fctrDAO = session.getMapper(FacturaDAO.class);
                    final FacturaVO fctr = new FacturaVO();

                    double importe = 0;
                    double impuesto = 0;

                    fctr.setId(igBO.nextVal(IgBO.SQ_INTEGRA));

                    fctr.setEstado(FacturaEstado.NO);
                    fctr.setFalta(Calendar.getInstance().getTime());
                    fctr.setFref(fechaFacturacion);
                    fctr.setFcsr(fcsr);
                    fctr.setAspc(vgrp.getAspc());
                    fctr.setPagador(vgrp.getPagador());
                    fctr.setSujPasivo(vgrp.getEsSujPasivo());

                    for (final ValoracionVO vlrc : vgrp.getVlrcList()) {
                        importe += vlrc.getImporte();
                        impuesto += vlrc.getImpuesto();

                        vlrc.setFctr(fctr);
                    }

                    fctr.setImporte(importe);
                    fctr.setImpuesto(impuesto);
                    fctr.setNumero(fcsr.getNumeroUltimo());

                    fcsr.setNumeroUltimo(fcsr.getNumeroUltimo() + 1);

                    fctrDAO.insert(fctr);
                    fcsrDAO.update(fcsr);

                    procesoTemplate.getPrbtData().getItemSalidaList().add(fctr.getId());
                }

                LOG.info("Modificación de Valoraciones");

                final ValoracionDAO vlrcDAO = session.getMapper(ValoracionDAO.class);

                for (final ValoracionGrupoVO vgrp : vgrpList) {
                    for (final ValoracionVO vlrc : vgrp.getVlrcList()) {
                        vlrcDAO.updateFctr(vlrc);
                    }
                }

                session.commit();
            }
        }
    }
}
