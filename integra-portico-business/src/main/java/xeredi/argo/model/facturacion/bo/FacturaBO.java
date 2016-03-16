package xeredi.argo.model.facturacion.bo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.NonNull;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.argo.model.comun.bo.IgBO;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.dao.FacturaDAO;
import xeredi.argo.model.facturacion.dao.ValoracionCargoDAO;
import xeredi.argo.model.facturacion.dao.ValoracionDAO;
import xeredi.argo.model.facturacion.dao.ValoracionDetalleDAO;
import xeredi.argo.model.facturacion.dao.ValoracionImpuestoDAO;
import xeredi.argo.model.facturacion.dao.ValoracionLineaDAO;
import xeredi.argo.model.facturacion.vo.FacturaCriterioVO;
import xeredi.argo.model.facturacion.vo.FacturaVO;
import xeredi.argo.model.facturacion.vo.ValoracionCargoVO;
import xeredi.argo.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionDetalleCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionDetalleVO;
import xeredi.argo.model.facturacion.vo.ValoracionImpuestoVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaVO;
import xeredi.argo.model.facturacion.vo.ValoracionVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaBO.
 */
public class FacturaBO {
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
            final ValoracionDAO vlrcDAO = session.getMapper(ValoracionDAO.class);
            final ValoracionLineaDAO vlrlDAO = session.getMapper(ValoracionLineaDAO.class);
            final ValoracionDetalleDAO vlrdDAO = session.getMapper(ValoracionDetalleDAO.class);

            final FacturaCriterioVO fctrCriterio = new FacturaCriterioVO();

            fctrCriterio.setId(fctrId);

            final FacturaVO fctr = fctrDAO.selectObject(fctrCriterio);

            if (fctr == null) {
                throw new Error("Factura no encontrada");
            }

            final ValoracionCriterioVO vlrcCriterio = new ValoracionCriterioVO();

            vlrcCriterio.setId(vlrcId);

            final ValoracionVO vlrc = vlrcDAO.selectObject(vlrcCriterio);

            if (vlrc == null) {
                throw new Error("Valoracion no encontrada");
            }

            if (!vlrc.getFctr().getId().equals(fctr.getId())) {
                throw new Error("No coinciden los identificadores de factura de la factura y la valoracion");
            }

            // Creacion de la valoracion
            final IgBO igBO = new IgBO();
            final Map<Long, Long> idsMap = new HashMap<>();

            final ValoracionVO vlrcCopia = new ValoracionVO();

            vlrcCopia.setAspc(vlrc.getAspc());
            vlrcCopia.setCodExencion(vlrc.getCodExencion());
            vlrcCopia.setFalta(Calendar.getInstance().getTime());
            vlrcCopia.setFctr(null);
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
            vlrcCopia.setId(igBO.nextVal(IgBO.SQ_INTEGRA));

            idsMap.put(vlrc.getId(), vlrcCopia.getId());

            vlrcDAO.insert(vlrcCopia);

            if (duplicarDatos) {
                final ValoracionLineaCriterioVO vlrlCriterio = new ValoracionLineaCriterioVO();

                vlrlCriterio.setVlrcId(vlrcId);

                for (final ValoracionLineaVO vlrl : vlrlDAO.selectList(vlrlCriterio)) {
                    final ValoracionLineaVO vlrlCopia = new ValoracionLineaVO();

                    vlrlCopia.setVlrcId(vlrcCopia.getId());
                    vlrlCopia.setFini(vlrl.getFini());
                    vlrlCopia.setFfin(vlrl.getFfin());
                    vlrlCopia.setFref(vlrl.getFref());
                    vlrlCopia.setRgla(vlrl.getRgla());
                    vlrlCopia.setSrvcId(vlrl.getSrvcId());
                    vlrlCopia.setSsrv(vlrl.getSsrv());

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

                    vlrlCopia.setId(igBO.nextVal(IgBO.SQ_INTEGRA));

                    idsMap.put(vlrl.getId(), vlrlCopia.getId());

                    vlrlCopia.setPadreId(idsMap.get(vlrl.getPadreId()));

                    vlrlDAO.insert(vlrl);
                }

                final ValoracionDetalleCriterioVO vlrdCriterio = new ValoracionDetalleCriterioVO();

                vlrdCriterio.setVlrcId(vlrcId);

                for (final ValoracionDetalleVO vlrd : vlrdDAO.selectList(vlrdCriterio)) {
                    final ValoracionDetalleVO vlrdCopia = new ValoracionDetalleVO();

                    vlrdCopia.setFini(vlrd.getFini());
                    vlrdCopia.setFfin(vlrd.getFfin());
                    vlrdCopia.setFref(vlrd.getFref());
                    vlrdCopia.setImporteBase(vlrd.getImporteBase());
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

                    vlrdCopia.setVlrcId(vlrcId);
                    vlrdCopia.setVlrlId(idsMap.get(vlrd.getVlrlId()));
                    vlrdCopia.setId(igBO.nextVal(IgBO.SQ_INTEGRA));

                    idsMap.put(vlrd.getId(), vlrdCopia.getId());

                    vlrdCopia.setPadreId(idsMap.get(vlrd.getPadreId()));

                    vlrdDAO.insert(vlrd);
                }
            }

            vlrcDAO.updateImporte(vlrcCopia.getId());

            session.commit();

            return vlrcCopia.getId();
        }
    }

    /**
     * Select imprimir.
     *
     * @param fctrIds
     *            the fctr ids
     * @return the list
     */
    public List<FacturaImpresionVO> selectImprimir(final @NonNull Set<Long> fctrIds, final String idioma) {
        Preconditions.checkArgument(!fctrIds.isEmpty());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final List<FacturaImpresionVO> list = new ArrayList<>();

            for (final Long fctrId : fctrIds) {
                final FacturaDAO fctrDAO = session.getMapper(FacturaDAO.class);
                final FacturaCriterioVO fctrCriterio = new FacturaCriterioVO();

                fctrCriterio.setId(fctrId);
                fctrCriterio.setIdioma(idioma);

                final FacturaVO fctr = fctrDAO.selectObject(fctrCriterio);

                if (fctr != null) {
                    final ValoracionCriterioVO vlrcCriterio = new ValoracionCriterioVO();

                    vlrcCriterio.setFctr(fctr);
                    vlrcCriterio.setIdioma(idioma);

                    final ValoracionCargoDAO vlrgDAO = session.getMapper(ValoracionCargoDAO.class);
                    final List<ValoracionCargoVO> vlrgList = vlrgDAO.selectList(vlrcCriterio);

                    final ValoracionImpuestoDAO vlriDAO = session.getMapper(ValoracionImpuestoDAO.class);
                    final List<ValoracionImpuestoVO> vlriList = vlriDAO.selectList(vlrcCriterio);

                    final ValoracionLineaCriterioVO vlrlCriterio = new ValoracionLineaCriterioVO();

                    vlrlCriterio.setFctrId(fctr.getId());

                    final ValoracionLineaDAO vlrlDAO = session.getMapper(ValoracionLineaDAO.class);
                    final List<ValoracionLineaVO> vlrlList = vlrlDAO.selectList(vlrlCriterio);

                    final ValoracionDAO vlrcDAO = session.getMapper(ValoracionDAO.class);
                    final Map<Long, ValoracionVO> vlrcMap = new HashMap<>();

                    for (final ValoracionVO vlrc : vlrcDAO.selectList(vlrcCriterio)) {
                        vlrcMap.put(vlrc.getId(), vlrc);
                    }

                    list.add(new FacturaImpresionVO(fctr, vlrgList, vlriList, vlrlList, vlrcMap));
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
}
