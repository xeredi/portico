package xeredi.argo.model.facturacion.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.dao.AspectoDAO;
import xeredi.argo.model.facturacion.dao.ReglaDAO;
import xeredi.argo.model.facturacion.dao.ValoracionDAO;
import xeredi.argo.model.facturacion.dao.ValoracionDetalleDAO;
import xeredi.argo.model.facturacion.dao.ValoracionLineaDAO;
import xeredi.argo.model.facturacion.vo.AspectoCriterioVO;
import xeredi.argo.model.facturacion.vo.AspectoVO;
import xeredi.argo.model.facturacion.vo.ReglaCriterioVO;
import xeredi.argo.model.facturacion.vo.ReglaTipo;
import xeredi.argo.model.facturacion.vo.ReglaVO;
import xeredi.argo.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionDetalleCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaVO;
import xeredi.argo.model.facturacion.vo.ValoracionVO;
import xeredi.argo.model.metamodelo.vo.TipoEntidad;
import xeredi.argo.model.servicio.dao.SubservicioDAO;
import xeredi.argo.model.servicio.vo.SubservicioCriterioVO;
import xeredi.argo.model.servicio.vo.SubservicioVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionLineaBO.
 */
public final class ValoracionLineaBO {

    /**
     * Select vlrl.
     *
     * @param vlrlCriterio
     *            the vlrl criterio
     * @return the valoracion linea vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public ValoracionLineaVO selectObject(final @NonNull ValoracionLineaCriterioVO vlrlCriterio)
            throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ValoracionLineaDAO vlrlDAO = session.getMapper(ValoracionLineaDAO.class);
            final ValoracionLineaVO vlrl = vlrlDAO.selectObject(vlrlCriterio);

            if (vlrl == null) {
                throw new InstanceNotFoundException(MessageI18nKey.vlrl, vlrlCriterio);
            }

            return vlrl;
        }
    }

    /**
     * Exists vlrl hija.
     *
     * @param vlrlId
     *            the vlrl id
     * @return true, if successful
     */
    public boolean existsHija(final @NonNull Long vlrlId) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ValoracionLineaDAO vlrlDAO = session.getMapper(ValoracionLineaDAO.class);

            return vlrlDAO.existsDependencia(vlrlId);
        }
    }

    /**
     * Select vlrl list.
     *
     * @param vlrlCriterio
     *            the vlrl criterio
     * @return the list
     */
    public List<ValoracionLineaVO> selectList(final @NonNull ValoracionLineaCriterioVO vlrlCriterio) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ValoracionLineaDAO vlrlDAO = session.getMapper(ValoracionLineaDAO.class);

            return vlrlDAO.selectList(vlrlCriterio);
        }
    }

    /**
     * Select vlrl list.
     *
     * @param vlrlCriterio
     *            the vlrl criterio
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public PaginatedList<ValoracionLineaVO> selectList(final @NonNull ValoracionLineaCriterioVO vlrlCriterio,
            final int offset, final int limit) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ValoracionLineaDAO vlrlDAO = session.getMapper(ValoracionLineaDAO.class);
            final int count = vlrlDAO.count(vlrlCriterio);
            final List<ValoracionLineaVO> vlrlList = new ArrayList<>();

            if (count >= offset) {
                vlrlList.addAll(vlrlDAO.selectList(vlrlCriterio, new RowBounds(offset, limit)));
            }

            return new PaginatedList<ValoracionLineaVO>(vlrlList, offset, limit, count);
        }
    }

    /**
     * Alta de una linea de valoracion y su primer detalle de valoracion asociado. Validaciones de negocio:
     *
     * <ul>
     * <li>La linea ha de estar asociada a una valoracion</li>
     * <li>La linea ha de tener una regla</li>
     * <li>La linea ha de tener un impuesto</li>
     * <li>El detalle ha de tener importe base e importe</li>
     * <li>La valoracion asociada a la linea debe existir</li>
     * <li>La regla ha de ser valida para el aspecto de la valoracion asociada a la linea</li>
     * <li>Si la regla está asociada a subservicios y el aspecto es de agrupacion, se comprueba que la linea
     * tenga un subservicio asociado, y que sea de la misma entidad que la regla</li>
     * <li>Si la regla está asociada a subservicios y el aspecto no es de agrupacion, se comprueba que el
     * detalle tenga un subservicio asociado, y que sea de la misma entidad que la regla</li>
     * <li>Si la regla no es de tipo precio, la linea ha de estar asociada a una linea padre</li>
     * </ul>
     *
     * @param vlrl
     *            Datos de una linea de valoracion.
     */
    public void insert(final @NonNull ValoracionLineaVO vlrl) {
        Preconditions.checkNotNull(vlrl.getVlrcId());
        Preconditions.checkNotNull(vlrl.getRgla());
        Preconditions.checkNotNull(vlrl.getRgla().getId());
        Preconditions.checkNotNull(vlrl.getImpuesto());
        Preconditions.checkNotNull(vlrl.getImpuesto().getId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ValoracionDAO vlrcDAO = session.getMapper(ValoracionDAO.class);
            final ValoracionLineaDAO vlrlDAO = session.getMapper(ValoracionLineaDAO.class);
            final ReglaDAO rglaDAO = session.getMapper(ReglaDAO.class);
            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);

            // Validacion de datos
            final ValoracionCriterioVO vlrcCriterio = new ValoracionCriterioVO();

            vlrcCriterio.setId(vlrl.getVlrcId());

            final ValoracionVO vlrc = vlrcDAO.selectObject(vlrcCriterio);

            if (vlrc == null) {
                throw new Error("Valoracion no encontrada: " + vlrl.getVlrcId());
            }

            if (!vlrlDAO.isRglaValida(vlrl)) {
                throw new Error("Regla no valida para el aspecto de la valoracion");
            }

            final ReglaCriterioVO rglaCriterioVO = new ReglaCriterioVO();

            rglaCriterioVO.setId(vlrl.getRgla().getId());
            rglaCriterioVO.setFechaVigencia(vlrc.getFref());

            final ReglaVO rgla = rglaDAO.selectObject(rglaCriterioVO);

            if (rgla == null) {
                throw new Error("Regla no encontrada: " + vlrl.getRgla());
            }

            if (rgla.getTipo() != ReglaTipo.T) {
                Preconditions.checkNotNull(vlrl.getPadreId());
            }

            final AspectoDAO aspcDAO = session.getMapper(AspectoDAO.class);
            final AspectoCriterioVO aspcCriterio = new AspectoCriterioVO();

            aspcCriterio.setId(vlrc.getAspc().getId());
            aspcCriterio.setFechaVigencia(vlrc.getFref());

            final AspectoVO aspc = aspcDAO.selectObject(aspcCriterio);
            final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

            // ssrvCriterioVO.setFechaVigencia(vlrc.getFref());

            if (rgla.getEnti().getTipo() == TipoEntidad.S) {
                if (!aspc.getVersion().isAgrupaDetalles()) {
                    Preconditions.checkNotNull(vlrl.getSsrv());
                    Preconditions.checkNotNull(vlrl.getSsrv().getId());

                    ssrvCriterioVO.setId(vlrl.getSsrv().getId());

                    final SubservicioVO ssrv = ssrvDAO.selectObject(ssrvCriterioVO);

                    if (ssrv.getEntiId() != rgla.getEnti().getId()) {
                        throw new Error("Subservicio no valido para la regla");
                    }
                }
            }

            // Grabacion de datos

            IgUtilBO.assignNextVal(vlrl);

            if (rgla.getTipo() == ReglaTipo.T) {
                vlrl.setPadreId(vlrl.getId());
            }

            vlrlDAO.insert(vlrl);
            vlrcDAO.updateImporte(vlrl.getVlrcId());

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param vlrl
     *            the vlrl
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void update(final @NonNull ValoracionLineaVO vlrl) throws InstanceNotFoundException {
        Preconditions.checkNotNull(vlrl.getId());
        Preconditions.checkNotNull(vlrl.getVlrcId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ValoracionLineaDAO vlrlDAO = session.getMapper(ValoracionLineaDAO.class);
            final int updated = vlrlDAO.update(vlrl);

            if (updated == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.vlrl, vlrl.getId());
            }

            final ValoracionDAO vlrcDAO = session.getMapper(ValoracionDAO.class);

            vlrcDAO.updateImporte(vlrl.getVlrcId());

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param vlrl
     *            the vlrl
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void delete(final @NonNull ValoracionLineaVO vlrl) throws InstanceNotFoundException {
        Preconditions.checkNotNull(vlrl.getId());
        Preconditions.checkNotNull(vlrl.getVlrcId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ValoracionLineaDAO vlrlDAO = session.getMapper(ValoracionLineaDAO.class);
            final ValoracionDetalleDAO vlrdDAO = session.getMapper(ValoracionDetalleDAO.class);

            if (vlrlDAO.existsDependencia(vlrl.getId())) {
                throw new Error("No se puede borrar la linea '" + vlrl.getId() + "' porque tiene lineas dependientes");
            }

            final ValoracionDetalleCriterioVO vlrdCriterio = new ValoracionDetalleCriterioVO();

            vlrdCriterio.setVlrlId(vlrl.getId());
            vlrdCriterio.setVlrcId(vlrl.getVlrcId());

            vlrdDAO.deleteList(vlrdCriterio);

            final ValoracionLineaCriterioVO vlrlCriterio = new ValoracionLineaCriterioVO();

            vlrlCriterio.setId(vlrl.getId());
            vlrlCriterio.setVlrcId(vlrl.getVlrcId());

            if (vlrlDAO.deleteList(vlrlCriterio) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.vlrl, vlrl.getId());
            }

            final ValoracionDAO vlrcDAO = session.getMapper(ValoracionDAO.class);

            vlrcDAO.updateImporte(vlrl.getVlrcId());

            session.commit();
        }
    }
}
