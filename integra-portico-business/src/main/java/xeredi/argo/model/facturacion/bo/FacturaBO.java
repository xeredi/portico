package xeredi.argo.model.facturacion.bo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.comun.bo.IgBO;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.dao.FacturaCargoDAO;
import xeredi.argo.model.facturacion.dao.FacturaDAO;
import xeredi.argo.model.facturacion.dao.FacturaDetalleDAO;
import xeredi.argo.model.facturacion.dao.FacturaImpuestoDAO;
import xeredi.argo.model.facturacion.dao.FacturaLineaDAO;
import xeredi.argo.model.facturacion.dao.FacturaSerieDAO;
import xeredi.argo.model.facturacion.dao.FacturaServicioDAO;
import xeredi.argo.model.facturacion.dao.ValoracionDAO;
import xeredi.argo.model.facturacion.dao.ValoracionDetalleDAO;
import xeredi.argo.model.facturacion.dao.ValoracionLineaDAO;
import xeredi.argo.model.facturacion.vo.FacturaCargoVO;
import xeredi.argo.model.facturacion.vo.FacturaCriterioVO;
import xeredi.argo.model.facturacion.vo.FacturaDetalleCriterioVO;
import xeredi.argo.model.facturacion.vo.FacturaDetalleVO;
import xeredi.argo.model.facturacion.vo.FacturaEstado;
import xeredi.argo.model.facturacion.vo.FacturaImpuestoVO;
import xeredi.argo.model.facturacion.vo.FacturaLineaCriterioVO;
import xeredi.argo.model.facturacion.vo.FacturaLineaVO;
import xeredi.argo.model.facturacion.vo.FacturaSerieCriterioVO;
import xeredi.argo.model.facturacion.vo.FacturaSerieVO;
import xeredi.argo.model.facturacion.vo.FacturaServicioCriterioVO;
import xeredi.argo.model.facturacion.vo.FacturaServicioVO;
import xeredi.argo.model.facturacion.vo.FacturaVO;
import xeredi.argo.model.facturacion.vo.ValoracionDetalleVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaVO;
import xeredi.argo.model.facturacion.vo.ValoracionVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaBO.
 */
public class FacturaBO {
    /**
     * Anular.
     *
     * @param fctrId
     *            the fctr id
     * @param fechaAnulacion
     *            the fecha anulacion
     * @param fcsrId
     *            the fcsr id
     * @param observaciones
     *            the observaciones
     */
    public void anular(final Long fctrId, final Date fechaAnulacion, final Long fcsrId, final String observaciones) {
        Preconditions.checkNotNull(fctrId);
        Preconditions.checkNotNull(fechaAnulacion);
        Preconditions.checkNotNull(fcsrId);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final FacturaDAO fctrDAO = session.getMapper(FacturaDAO.class);
            final FacturaSerieDAO fcsrDAO = session.getMapper(FacturaSerieDAO.class);
            final FacturaServicioDAO fctsDAO = session.getMapper(FacturaServicioDAO.class);
            final FacturaLineaDAO fctlDAO = session.getMapper(FacturaLineaDAO.class);
            final FacturaDetalleDAO fctdDAO = session.getMapper(FacturaDetalleDAO.class);

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

            fctdCriterioVO.setFctrId(fctrId);

            final FacturaVO fctr = fctrDAO.selectObject(fctrCriterioVO);

            if (fctr == null) {
                throw new Error("No se encuentra la factura a anular");
            }

            if (fctr.getEstado() != FacturaEstado.NO) {
                throw new Error("Estado de factura no valido para anulacion: " + fctr.getEstado());
            }

            if (fcsrDAO.updateIncrementar(fcsrId) == 0) {
                throw new Error("No se encuentra serie de anulacion");
            }

            // Modificar el estado de la factura original - Pasa a Anulada
            fctr.setEstado(FacturaEstado.AN);
            fctrDAO.updateEstado(fctr);

            // Crear nueva factura a partir de los datos de la factura anulada.
            final FacturaSerieCriterioVO fcsrCriterio = new FacturaSerieCriterioVO();

            fcsrCriterio.setId(fcsrId);

            final FacturaSerieVO fcsr = fcsrDAO.selectObject(fcsrCriterio);

            final FacturaServicioCriterioVO fctsCriterio = new FacturaServicioCriterioVO();

            fctsCriterio.setFctrId(fctrId);

            final List<FacturaServicioVO> fctsList = fctsDAO.selectList(fctsCriterio);
            final List<FacturaLineaVO> fctlList = fctlDAO.selectList(fctlCriterioVO);
            final List<FacturaDetalleVO> fctdList = fctdDAO.selectList(fctdCriterioVO);

            final Map<Long, Long> generatedIds = new HashMap<>();
            final IgBO igBO = new IgBO();

            generatedIds.put(fctr.getId(), igBO.nextVal(IgBO.SQ_INTEGRA));

            fctr.setId(generatedIds.get(fctr.getId()));
            fctr.setFcsr(fcsr);
            fctr.setNumero(fcsr.getNumeroUltimo());
            fctr.setFalta(Calendar.getInstance().getTime());
            fctr.setEstado(fctr.getImporte() > 0 ? FacturaEstado.RN : FacturaEstado.RP);

            // FIXME Donde guardo la fecha de anulacion

            fctrDAO.insert(fctr);

            for (final FacturaServicioVO fcts : fctsList) {
                generatedIds.put(fcts.getId(), igBO.nextVal(IgBO.SQ_INTEGRA));

                fcts.setId(generatedIds.get(fcts.getId()));
                fcts.setFctrId(generatedIds.get(fcts.getFctrId()));

                fctsDAO.insert(fcts);
            }

            for (final FacturaLineaVO fctl : fctlList) {
                generatedIds.put(fctl.getId(), igBO.nextVal(IgBO.SQ_INTEGRA));

                fctl.setId(generatedIds.get(fctl.getId()));
                fctl.setPadreId(generatedIds.get(fctl.getPadreId()));
                fctl.setFctrId(generatedIds.get(fctl.getFctrId()));

                fctlDAO.insert(fctl);
            }

            for (final FacturaDetalleVO fctd : fctdList) {
                generatedIds.put(fctd.getId(), igBO.nextVal(IgBO.SQ_INTEGRA));

                fctd.setId(generatedIds.get(fctd.getId()));
                fctd.setFctrId(generatedIds.get(fctd.getFctrId()));
                fctd.setFctlId(generatedIds.get(fctd.getFctlId()));
                fctd.setImporteBase(-fctd.getImporteBase());
                fctd.setImporte(-fctd.getImporte());

                fctdDAO.insert(fctd);
            }

            // FIXME Acabar

            session.commit();
        }
    }

    /**
     * Rectificar.
     *
     * @param fctrId
     *            the fctr id
     * @param vlrcId
     *            the vlrc id
     * @param duplicarDatos
     *            the duplicar datos
     * @return the long
     */
    public Long rectificar(final @NonNull Long fctrId, final @NonNull Long vlrcId, final boolean duplicarDatos) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final FacturaDAO fctrDAO = session.getMapper(FacturaDAO.class);
            final FacturaServicioDAO fctsDAO = session.getMapper(FacturaServicioDAO.class);
            final FacturaLineaDAO fctlDAO = session.getMapper(FacturaLineaDAO.class);
            final FacturaDetalleDAO fctdDAO = session.getMapper(FacturaDetalleDAO.class);
            final ValoracionDAO vlrcDAO = session.getMapper(ValoracionDAO.class);
            final ValoracionLineaDAO vlrlDAO = session.getMapper(ValoracionLineaDAO.class);
            final ValoracionDetalleDAO vlrdDAO = session.getMapper(ValoracionDetalleDAO.class);

            final FacturaCriterioVO fctrCriterio = new FacturaCriterioVO();

            fctrCriterio.setId(fctrId);

            final FacturaVO fctr = fctrDAO.selectObject(fctrCriterio);

            if (fctr == null) {
                throw new Error("Factura no encontrada");
            }

            final FacturaServicioCriterioVO fctsCriterio = new FacturaServicioCriterioVO();

            fctsCriterio.setId(fctsId);

            final FacturaServicioVO fcts = fctsDAO.selectObject(fctsCriterio);

            if (fcts == null) {
                throw new Error("Servicio de Factura no encontrado");
            }

            if (!fcts.getFctrId().equals(fctr.getId())) {
                throw new Error(
                        "No coinciden los identificadores de factura de la factura y el servicio de la factura");
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

            fctdCriterioVO.setVlrcId(vlrcId);

            // Creacion de la valoracion
            final IgBO igBO = new IgBO();

            final ValoracionVO vlrc = new ValoracionVO();
            final List<ValoracionLineaVO> vlrlList = new ArrayList<>();
            final List<ValoracionDetalleVO> vlrdList = new ArrayList<>();

            vlrc.setId(igBO.nextVal(IgBO.SQ_INTEGRA));

            vlrc.setAspc(fcts.getAspc());
            vlrc.setFalta(Calendar.getInstance().getTime());
            vlrc.setFini(fcts.getFini());
            vlrc.setFfin(fcts.getFfin());
            vlrc.setFliq(Calendar.getInstance().getTime());
            vlrc.setFref(fcts.getFref());
            vlrc.setPagador(fctr.getPagador());
            vlrc.setSrvc(fcts.getSrvc());

            // vlrc.setCodExencion(fctr.get); // FIXME
            // vlrc.setSujPasivo(value); // FIXME

            vlrc.setInfo1(fctr.getInfo1());
            vlrc.setInfo2(fctr.getInfo2());
            vlrc.setInfo3(fctr.getInfo3());
            vlrc.setInfo4(fctr.getInfo4());
            vlrc.setInfo5(fctr.getInfo5());
            vlrc.setInfo6(fctr.getInfo6());

            final Map<Long, Long> generatedIds = new HashMap<>();

            if (duplicarDatos) {
                final List<FacturaLineaVO> fctlList = fctlDAO.selectList(fctlCriterioVO);
                final List<FacturaDetalleVO> fctdList = fctdDAO.selectList(fctdCriterioVO);

                for (final FacturaLineaVO fctl : fctlList) {
                    generatedIds.put(fctl.getId(), igBO.nextVal(IgBO.SQ_INTEGRA));

                    final ValoracionLineaVO vlrl = new ValoracionLineaVO();

                    vlrl.setId(generatedIds.get(fctl.getId()));
                    vlrl.setPadreId(generatedIds.get(fctl.getPadreId()));
                    vlrl.setVlrcId(vlrc.getId());

                    vlrl.setImpuesto(fctl.getImpuesto());
                    vlrl.setRgla(fctl.getRgla());
                    vlrl.setSsrv(fctl.getSsrv());
                    vlrl.setFini(fctl.getFini());
                    vlrl.setFfin(fctl.getFfin());

                    vlrl.setCuant1(fctl.getCuant1());
                    vlrl.setCuant2(fctl.getCuant2());
                    vlrl.setCuant3(fctl.getCuant3());
                    vlrl.setCuant4(fctl.getCuant4());
                    vlrl.setCuant5(fctl.getCuant5());
                    vlrl.setCuant6(fctl.getCuant6());
                    vlrl.setInfo1(fctl.getInfo1());
                    vlrl.setInfo2(fctl.getInfo2());
                    vlrl.setInfo3(fctl.getInfo3());
                    vlrl.setInfo4(fctl.getInfo4());
                    vlrl.setInfo5(fctl.getInfo5());
                    vlrl.setInfo6(fctl.getInfo6());

                    vlrlList.add(vlrl);
                }

                for (final FacturaDetalleVO fctd : fctdList) {
                    generatedIds.put(fctd.getId(), igBO.nextVal(IgBO.SQ_INTEGRA));

                    final ValoracionDetalleVO vlrd = new ValoracionDetalleVO();

                    vlrd.setId(generatedIds.get(fctd.getId()));
                    vlrd.setVlrcId(vlrc.getId());
                    vlrd.setVlrlId(generatedIds.get(fctd.getFctlId()));

                    vlrd.setSsrv(fctd.getSsrv());
                    vlrd.setFini(fctd.getFini());
                    vlrd.setFfin(fctd.getFfin());
                    vlrd.setImporte(-fctd.getImporte());
                    vlrd.setImporteBase(-fctd.getImporteBase());

                    vlrd.setCuant1(fctd.getCuant1());
                    vlrd.setCuant2(fctd.getCuant2());
                    vlrd.setCuant3(fctd.getCuant3());
                    vlrd.setCuant4(fctd.getCuant4());
                    vlrd.setCuant5(fctd.getCuant5());
                    vlrd.setCuant6(fctd.getCuant6());
                    vlrd.setInfo1(fctd.getInfo1());
                    vlrd.setInfo2(fctd.getInfo2());
                    vlrd.setInfo3(fctd.getInfo3());
                    vlrd.setInfo4(fctd.getInfo4());
                    vlrd.setInfo5(fctd.getInfo5());
                    vlrd.setInfo6(fctd.getInfo6());

                    vlrdList.add(vlrd);
                }
            }

            // Guardar datos de la valoracion de rectificacion
            vlrcDAO.insert(vlrc);

            for (final ValoracionLineaVO vlrl : vlrlList) {
                vlrlDAO.insert(vlrl);
            }

            for (final ValoracionDetalleVO vlrd : vlrdList) {
                vlrdDAO.insert(vlrd);
            }

            session.commit();

            return vlrc.getId();
        }
    }

    /**
     * Select imprimir.
     *
     * @param fctrIds
     *            the fctr ids
     * @return the list
     */
    public List<FacturaImpresionVO> selectImprimir(final Set<Long> fctrIds) {
        Preconditions.checkNotNull(fctrIds);
        Preconditions.checkArgument(!fctrIds.isEmpty());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final FacturaDAO fctrDAO = session.getMapper(FacturaDAO.class);
            final FacturaServicioDAO fctsDAO = session.getMapper(FacturaServicioDAO.class);
            final FacturaCargoDAO fctgDAO = session.getMapper(FacturaCargoDAO.class);
            final FacturaImpuestoDAO fctiDAO = session.getMapper(FacturaImpuestoDAO.class);
            final FacturaLineaDAO fctlDAO = session.getMapper(FacturaLineaDAO.class);

            final List<FacturaImpresionVO> list = new ArrayList<>();

            for (final Long fctrId : fctrIds) {
                final FacturaCriterioVO fctrCriterioVO = new FacturaCriterioVO();
                final FacturaLineaCriterioVO fctlCriterioVO = new FacturaLineaCriterioVO();

                fctrCriterioVO.setId(fctrId);
                fctlCriterioVO.setFctr(fctrCriterioVO);

                final FacturaVO fctr = fctrDAO.selectObject(fctrCriterioVO);

                if (fctr != null) {
                    final List<FacturaCargoVO> fctgList = fctgDAO.selectList(fctrCriterioVO);
                    final List<FacturaImpuestoVO> fctiList = fctiDAO.selectList(fctrCriterioVO);

                    final FacturaServicioCriterioVO fctsCriterio = new FacturaServicioCriterioVO();

                    fctsCriterio.setFctrId(fctrId);

                    final List<FacturaServicioVO> fctsList = fctsDAO.selectList(fctsCriterio);
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
    }

    /**
     * Select.
     *
     * @param fctrId
     *            the fctr id
     * @param idioma
     *            the idioma
     * @return the factura vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public FacturaVO select(final @NonNull Long fctrId, final String idioma) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final FacturaDAO fctrDAO = session.getMapper(FacturaDAO.class);
            final FacturaCriterioVO fctrCriterio = new FacturaCriterioVO();

            fctrCriterio.setId(fctrId);
            fctrCriterio.setIdioma(idioma);

            final FacturaVO fctr = fctrDAO.selectObject(fctrCriterio);

            if (fctr == null) {
                throw new InstanceNotFoundException(MessageI18nKey.fctr, fctrId);
            }

            return fctr;
        }
    }

    /**
     * Select list.
     *
     * @param fctrCriterio
     *            the fctr criterio
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public PaginatedList<FacturaVO> selectList(final @NonNull FacturaCriterioVO fctrCriterio, final int offset,
            final int limit) {
        Preconditions.checkArgument(offset >= 0);
        Preconditions.checkArgument(limit > 0);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final FacturaDAO fctrDAO = session.getMapper(FacturaDAO.class);
            final int count = fctrDAO.count(fctrCriterio);
            final List<FacturaVO> fctrList = new ArrayList<>();

            if (count >= offset) {
                fctrList.addAll(fctrDAO.selectList(fctrCriterio, new RowBounds(offset, limit)));
            }

            return new PaginatedList<FacturaVO>(fctrList, offset, limit, count);
        }
    }

    /**
     * Select fcts list.
     *
     * @param fctrId
     *            the fctr id
     * @param idioma
     *            the idioma
     * @return the list
     */
    public List<FacturaServicioVO> selectFctsList(final @NonNull Long fctrId, final String idioma) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final FacturaServicioDAO fctsDAO = session.getMapper(FacturaServicioDAO.class);
            final FacturaServicioCriterioVO fctsCriterio = new FacturaServicioCriterioVO();

            fctsCriterio.setFctrId(fctrId);
            fctsCriterio.setIdioma(idioma);

            return fctsDAO.selectList(fctsCriterio);
        }
    }

    /**
     * Select fcti list.
     *
     * @param fctrId
     *            the fctr id
     * @param idioma
     *            the idioma
     * @return the list
     */
    public List<FacturaImpuestoVO> selectFctiList(final @NonNull Long fctrId, final String idioma) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final FacturaImpuestoDAO fctiDAO = session.getMapper(FacturaImpuestoDAO.class);
            final FacturaCriterioVO fctrCriterio = new FacturaCriterioVO();

            fctrCriterio.setId(fctrId);
            fctrCriterio.setIdioma(idioma);

            return fctiDAO.selectList(fctrCriterio);
        }
    }

    /**
     * Select fctg list.
     *
     * @param fctrId
     *            the fctr id
     * @param idioma
     *            the idioma
     * @return the list
     */
    public List<FacturaCargoVO> selectFctgList(final @NonNull Long fctrId, final String idioma) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final FacturaCargoDAO fctgDAO = session.getMapper(FacturaCargoDAO.class);
            final FacturaCriterioVO fctrCriterio = new FacturaCriterioVO();

            fctrCriterio.setId(fctrId);
            fctrCriterio.setIdioma(idioma);

            return fctgDAO.selectList(fctrCriterio);
        }
    }

    /**
     * Select fctl list.
     *
     * @param fctrId
     *            the fctr id
     * @param idioma
     *            the idioma
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public PaginatedList<FacturaLineaVO> selectFctlList(final @NonNull Long fctrId, final String idioma,
            final int offset, final int limit) {
        Preconditions.checkArgument(offset >= 0);
        Preconditions.checkArgument(limit > 0);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final FacturaLineaDAO fctlDAO = session.getMapper(FacturaLineaDAO.class);
            final FacturaLineaCriterioVO fctlCriterio = new FacturaLineaCriterioVO();
            final FacturaCriterioVO fctrCriterio = new FacturaCriterioVO();

            fctrCriterio.setId(fctrId);
            fctlCriterio.setFctr(fctrCriterio);
            fctlCriterio.setIdioma(idioma);

            final int count = fctlDAO.count(fctlCriterio);
            final List<FacturaLineaVO> fctlList = new ArrayList<>();

            if (count >= offset) {
                fctlList.addAll(fctlDAO.selectList(fctlCriterio, new RowBounds(offset, limit)));
            }

            return new PaginatedList<FacturaLineaVO>(fctlList, offset, limit, count);
        }
    }

    /**
     * Select fctl.
     *
     * @param fctlId
     *            the fctl id
     * @param idioma
     *            the idioma
     * @return the factura linea vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public FacturaLineaVO selectFctl(final @NonNull Long fctlId, final String idioma) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final FacturaLineaDAO fctlDAO = session.getMapper(FacturaLineaDAO.class);
            final FacturaLineaCriterioVO fctlCriterio = new FacturaLineaCriterioVO();

            fctlCriterio.setId(fctlId);
            fctlCriterio.setIdioma(idioma);

            final FacturaLineaVO fctl = fctlDAO.selectObject(fctlCriterio);

            if (fctl == null) {
                throw new InstanceNotFoundException(MessageI18nKey.fctl, fctlId);
            }

            return fctl;
        }
    }
}
