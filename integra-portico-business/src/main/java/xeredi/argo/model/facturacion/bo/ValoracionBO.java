package xeredi.argo.model.facturacion.bo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.argo.model.comun.bo.IgBO;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.dao.AspectoDAO;
import xeredi.argo.model.facturacion.dao.ReglaDAO;
import xeredi.argo.model.facturacion.dao.ValoracionCargoDAO;
import xeredi.argo.model.facturacion.dao.ValoracionDAO;
import xeredi.argo.model.facturacion.dao.ValoracionDetalleDAO;
import xeredi.argo.model.facturacion.dao.ValoracionImpuestoDAO;
import xeredi.argo.model.facturacion.dao.ValoracionLineaDAO;
import xeredi.argo.model.facturacion.vo.AspectoCriterioVO;
import xeredi.argo.model.facturacion.vo.AspectoVO;
import xeredi.argo.model.facturacion.vo.ReglaCriterioVO;
import xeredi.argo.model.facturacion.vo.ReglaTipo;
import xeredi.argo.model.facturacion.vo.ReglaVO;
import xeredi.argo.model.facturacion.vo.ValoracionCargoVO;
import xeredi.argo.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionDetalleCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionDetalleVO;
import xeredi.argo.model.facturacion.vo.ValoracionImpuestoVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaVO;
import xeredi.argo.model.facturacion.vo.ValoracionVO;
import xeredi.argo.model.metamodelo.vo.TipoEntidad;
import xeredi.argo.model.servicio.dao.SubservicioDAO;
import xeredi.argo.model.servicio.vo.SubservicioCriterioVO;
import xeredi.argo.model.servicio.vo.SubservicioVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionBO.
 */
public class ValoracionBO {

    /**
     * Insert.
     *
     * @param vlrc
     *            the vlrc
     */
    public void insert(final ValoracionVO vlrc) {
        Preconditions.checkNotNull(vlrc);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ValoracionDAO vlrcDAO = session.getMapper(ValoracionDAO.class);
            final IgBO igBO = new IgBO();

            vlrc.setId(igBO.nextVal(IgBO.SQ_INTEGRA));

            vlrcDAO.insert(vlrc);

            session.commit();
        }
    }

    /**
     * Update.
     *
     * @param vlrc
     *            the vlrc
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void update(final ValoracionVO vlrc) throws InstanceNotFoundException {
        Preconditions.checkNotNull(vlrc);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ValoracionDAO vlrcDAO = session.getMapper(ValoracionDAO.class);

            if (vlrcDAO.update(vlrc) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.vlrc, vlrc.getId());
            }

            session.commit();
        }
    }

    /**
     * Delete.
     *
     * @param id
     *            the id
     */
    public void delete(final Long id) {
        Preconditions.checkNotNull(id);

        final Set<Long> vlrcIds = new HashSet<Long>();

        vlrcIds.add(id);
        delete(vlrcIds);
    }

    /**
     * Delete.
     *
     * @param ids
     *            the ids
     */
    public void delete(final Set<Long> ids) {
        Preconditions.checkNotNull(ids);
        Preconditions.checkArgument(!ids.isEmpty());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ValoracionDetalleDAO vlrdDAO = session.getMapper(ValoracionDetalleDAO.class);
            final ValoracionLineaDAO vlrlDAO = session.getMapper(ValoracionLineaDAO.class);
            final ValoracionDAO vlrcDAO = session.getMapper(ValoracionDAO.class);

            final ValoracionCriterioVO vlrcCriterioVO = new ValoracionCriterioVO();
            final ValoracionLineaCriterioVO vlrlCriterioVO = new ValoracionLineaCriterioVO();
            final ValoracionDetalleCriterioVO vlrdCriterioVO = new ValoracionDetalleCriterioVO();

            vlrcCriterioVO.setIds(ids);
            vlrlCriterioVO.setVlrc(vlrcCriterioVO);
            vlrdCriterioVO.setVlrl(vlrlCriterioVO);

            vlrdDAO.deleteList(vlrdCriterioVO);
            vlrlDAO.deleteList(vlrlCriterioVO);
            vlrcDAO.deleteList(vlrcCriterioVO);

            session.commit();
        }
    }

    /**
     * Select.
     *
     * @param vlrcCriterio
     *            the vlrc criterio
     * @return the valoracion vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public ValoracionVO selectObject(final ValoracionCriterioVO vlrcCriterio) throws InstanceNotFoundException {
        Preconditions.checkNotNull(vlrcCriterio);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ValoracionDAO vlrcDAO = session.getMapper(ValoracionDAO.class);
            final ValoracionVO vlrc = vlrcDAO.selectObject(vlrcCriterio);

            if (vlrc == null) {
                throw new InstanceNotFoundException(MessageI18nKey.vlrc, vlrcCriterio);
            }

            return vlrc;
        }
    }

    /**
     * Select list.
     *
     * @param vlrcCriterioVO
     *            the vlrc criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public PaginatedList<ValoracionVO> selectList(final ValoracionCriterioVO vlrcCriterioVO, final int offset,
            final int limit) {
        Preconditions.checkNotNull(vlrcCriterioVO);
        Preconditions.checkArgument(offset >= 0);
        Preconditions.checkArgument(limit > 0);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ValoracionDAO vlrcDAO = session.getMapper(ValoracionDAO.class);
            final int count = vlrcDAO.count(vlrcCriterioVO);
            final List<ValoracionVO> vlrcList = new ArrayList<>();

            if (count >= offset) {
                vlrcList.addAll(vlrcDAO.selectList(vlrcCriterioVO, new RowBounds(offset, limit)));
            }

            return new PaginatedList<ValoracionVO>(vlrcList, offset, limit, count);
        }
    }

    /**
     * Select vlri list.
     *
     * @param vlrcCriterio
     *            the vlrc criterio
     * @return the list
     */
    public List<ValoracionImpuestoVO> selectVlriList(final ValoracionCriterioVO vlrcCriterio) {
        Preconditions.checkNotNull(vlrcCriterio);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ValoracionImpuestoDAO vlriDAO = session.getMapper(ValoracionImpuestoDAO.class);

            return vlriDAO.selectList(vlrcCriterio);
        }
    }

    /**
     * Select vlrg list.
     *
     * @param vlrcCriterio
     *            the vlrc criterio
     * @return the list
     */
    public List<ValoracionCargoVO> selectVlrgList(final ValoracionCriterioVO vlrcCriterio) {
        Preconditions.checkNotNull(vlrcCriterio);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ValoracionCargoDAO vlrgDAO = session.getMapper(ValoracionCargoDAO.class);

            return vlrgDAO.selectList(vlrcCriterio);
        }
    }

    /**
     * Select vlrl.
     *
     * @param vlrlCriterio
     *            the vlrl criterio
     * @return the valoracion linea vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public ValoracionLineaVO selectVlrlObject(final ValoracionLineaCriterioVO vlrlCriterio)
            throws InstanceNotFoundException {
        Preconditions.checkNotNull(vlrlCriterio);

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
    public boolean existsVlrlHija(final Long vlrlId) {
        Preconditions.checkNotNull(vlrlId);

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
    public List<ValoracionLineaVO> selectVlrlList(final ValoracionLineaCriterioVO vlrlCriterio) {
        Preconditions.checkNotNull(vlrlCriterio);

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
    public PaginatedList<ValoracionLineaVO> selectVlrlList(final ValoracionLineaCriterioVO vlrlCriterio,
            final int offset, final int limit) {
        Preconditions.checkNotNull(vlrlCriterio);

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
    public void insertVlrl(final ValoracionLineaVO vlrl) {
        Preconditions.checkNotNull(vlrl);
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
            final IgBO igBO = new IgBO();

            vlrl.setId(igBO.nextVal(IgBO.SQ_INTEGRA));

            if (rgla.getTipo() == ReglaTipo.T) {
                vlrl.setPadreId(vlrl.getId());
            }

            vlrlDAO.insert(vlrl);

            session.commit();
        }
    }

    /**
     * Update vlrl.
     *
     * @param vlrl
     *            the vlrl
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void updateVlrl(final ValoracionLineaVO vlrl) throws InstanceNotFoundException {
        Preconditions.checkNotNull(vlrl);
        Preconditions.checkNotNull(vlrl.getId());
        Preconditions.checkNotNull(vlrl.getVlrcId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ValoracionLineaDAO vlrlDAO = session.getMapper(ValoracionLineaDAO.class);
            final int updated = vlrlDAO.update(vlrl);

            if (updated == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.vlrl, vlrl.getId());
            }

            session.commit();
        }
    }

    /**
     * Delete vlrl.
     *
     * @param vlrl
     *            the vlrl
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void deleteVlrl(final ValoracionLineaVO vlrl) throws InstanceNotFoundException {
        Preconditions.checkNotNull(vlrl);
        Preconditions.checkNotNull(vlrl.getId());
        Preconditions.checkNotNull(vlrl.getVlrcId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ValoracionLineaDAO vlrlDAO = session.getMapper(ValoracionLineaDAO.class);
            final ValoracionDetalleDAO vlrdDAO = session.getMapper(ValoracionDetalleDAO.class);

            if (vlrlDAO.existsDependencia(vlrl.getId())) {
                throw new Error("No se puede borrar la linea '" + vlrl.getId() + "' porque tiene lineas dependientes");
            }

            final ValoracionCriterioVO vlrcCriterio = new ValoracionCriterioVO();
            final ValoracionLineaCriterioVO vlrlCriterio = new ValoracionLineaCriterioVO();
            final ValoracionDetalleCriterioVO vlrdCriterio = new ValoracionDetalleCriterioVO();

            vlrcCriterio.setId(vlrl.getVlrcId());

            vlrlCriterio.setId(vlrl.getId());
            vlrlCriterio.setVlrc(vlrcCriterio);

            vlrdCriterio.setVlrl(vlrlCriterio);

            vlrdDAO.deleteList(vlrdCriterio);

            if (vlrlDAO.deleteList(vlrlCriterio) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.vlrl, vlrl.getId());
            }

            session.commit();
        }
    }

    /**
     * Select vlrd.
     *
     * @param vlrdId
     *            the vlrd id
     * @return the valoracion detalle vo
     * @throws InstanceNotFoundException
     *             Si no se encuentra la valoración.
     */
    public ValoracionDetalleVO selectVlrd(final Long vlrdId) throws InstanceNotFoundException {
        Preconditions.checkNotNull(vlrdId);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ValoracionDetalleDAO vlrdDAO = session.getMapper(ValoracionDetalleDAO.class);
            final ValoracionDetalleCriterioVO vlrdCriterio = new ValoracionDetalleCriterioVO();

            vlrdCriterio.setId(vlrdId);

            final ValoracionDetalleVO vlrd = vlrdDAO.selectObject(vlrdCriterio);

            if (vlrd == null) {
                throw new InstanceNotFoundException(MessageI18nKey.vlrd, vlrdId);
            }

            return vlrd;
        }
    }

    /**
     * Select vlrd list.
     *
     * @param vlrdCriterio
     *            the vlrd criterio
     * @param idioma
     *            the idioma
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public PaginatedList<ValoracionDetalleVO> selectVlrdList(final ValoracionDetalleCriterioVO vlrdCriterio,
            final String idioma, final int offset, final int limit) {
        Preconditions.checkNotNull(vlrdCriterio);
        Preconditions.checkNotNull(vlrdCriterio.getVlrl());
        Preconditions.checkNotNull(vlrdCriterio.getVlrl().getId());

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
     * Select vlrd list.
     *
     * @param vlrdCriterio
     *            the vlrd criterio
     * @return the list
     */
    public List<ValoracionDetalleVO> selectVlrdList(final ValoracionDetalleCriterioVO vlrdCriterio) {
        Preconditions.checkNotNull(vlrdCriterio);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ValoracionDetalleDAO vlrdDAO = session.getMapper(ValoracionDetalleDAO.class);

            return vlrdDAO.selectList(vlrdCriterio);
        }
    }

    /**
     * Insert vlrd.
     *
     * @param vlrd
     *            the vlrd
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void insertVlrd(final ValoracionDetalleVO vlrd) throws InstanceNotFoundException {
        Preconditions.checkNotNull(vlrd);
        Preconditions.checkNotNull(vlrd.getVlrlId());
        Preconditions.checkNotNull(vlrd.getVlrcId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ValoracionDetalleDAO vlrdDAO = session.getMapper(ValoracionDetalleDAO.class);
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

            vlrdDAO.insert(vlrd);

            session.commit();
        }
    }

    /**
     * Update vlrd.
     *
     * @param vlrd
     *            the vlrd
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void updateVlrd(final ValoracionDetalleVO vlrd) throws InstanceNotFoundException {
        Preconditions.checkNotNull(vlrd);
        Preconditions.checkNotNull(vlrd.getId());
        Preconditions.checkNotNull(vlrd.getVlrlId());
        Preconditions.checkNotNull(vlrd.getVlrcId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ValoracionDetalleDAO vlrdDAO = session.getMapper(ValoracionDetalleDAO.class);
            final int updated = vlrdDAO.update(vlrd);

            if (updated == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.vlrd, vlrd.getId());
            }

            session.commit();
        }
    }

    /**
     * Delete vlrd.
     *
     * @param vlrd
     *            the vlrd
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void deleteVlrd(final ValoracionDetalleVO vlrd) throws InstanceNotFoundException {
        Preconditions.checkNotNull(vlrd);
        Preconditions.checkNotNull(vlrd.getId());
        Preconditions.checkNotNull(vlrd.getVlrlId());
        Preconditions.checkNotNull(vlrd.getVlrcId());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ValoracionDetalleDAO vlrdDAO = session.getMapper(ValoracionDetalleDAO.class);
            final ValoracionLineaDAO vlrlDAO = session.getMapper(ValoracionLineaDAO.class);

            if (vlrdDAO.delete(vlrd) == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.vlrd, vlrd.getId());
            }

            final ValoracionDetalleCriterioVO vlrdCriterioVO = new ValoracionDetalleCriterioVO();
            final ValoracionLineaCriterioVO vlrlCriterioVO = new ValoracionLineaCriterioVO();

            vlrlCriterioVO.setId(vlrd.getVlrlId());
            vlrdCriterioVO.setVlrl(vlrlCriterioVO);

            if (vlrdDAO.count(vlrdCriterioVO) == 0) {
                vlrlDAO.deleteList(vlrlCriterioVO);
            }

            session.commit();
        }
    }
}
