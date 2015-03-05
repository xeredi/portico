package xeredi.integra.model.facturacion.bo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.bo.IgBO;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.facturacion.dao.ReglaDAO;
import xeredi.integra.model.facturacion.dao.ServicioCargoDAO;
import xeredi.integra.model.facturacion.dao.ValoracionCargoDAO;
import xeredi.integra.model.facturacion.dao.ValoracionDAO;
import xeredi.integra.model.facturacion.dao.ValoracionDetalleDAO;
import xeredi.integra.model.facturacion.dao.ValoracionImpuestoDAO;
import xeredi.integra.model.facturacion.dao.ValoracionLineaDAO;
import xeredi.integra.model.facturacion.vo.AspectoVO;
import xeredi.integra.model.facturacion.vo.ReglaCriterioVO;
import xeredi.integra.model.facturacion.vo.ReglaTipo;
import xeredi.integra.model.facturacion.vo.ReglaVO;
import xeredi.integra.model.facturacion.vo.ServicioCargoCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionCargoVO;
import xeredi.integra.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionDetalleCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionDetalleVO;
import xeredi.integra.model.facturacion.vo.ValoracionImpuestoVO;
import xeredi.integra.model.facturacion.vo.ValoracionLineaCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionLineaVO;
import xeredi.integra.model.facturacion.vo.ValoracionVO;
import xeredi.integra.model.metamodelo.vo.TipoEntidad;
import xeredi.integra.model.servicio.dao.SubservicioDAO;
import xeredi.integra.model.servicio.vo.SubservicioCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionBO.
 */
public class ValoracionBO {
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
            final ServicioCargoDAO srcrDAO = session.getMapper(ServicioCargoDAO.class);
            final ValoracionDetalleDAO vlrdDAO = session.getMapper(ValoracionDetalleDAO.class);
            final ValoracionLineaDAO vlrlDAO = session.getMapper(ValoracionLineaDAO.class);
            final ValoracionImpuestoDAO vlriDAO = session.getMapper(ValoracionImpuestoDAO.class);
            final ValoracionCargoDAO vlrgDAO = session.getMapper(ValoracionCargoDAO.class);
            final ValoracionDAO vlrcDAO = session.getMapper(ValoracionDAO.class);

            final ValoracionCriterioVO vlrcCriterioVO = new ValoracionCriterioVO();
            final ValoracionLineaCriterioVO vlrlCriterioVO = new ValoracionLineaCriterioVO();
            final ValoracionDetalleCriterioVO vlrdCriterioVO = new ValoracionDetalleCriterioVO();
            final ServicioCargoCriterioVO srcrCriterioVO = new ServicioCargoCriterioVO();

            srcrCriterioVO.setVlrcIds(ids);
            vlrcCriterioVO.setIds(ids);
            vlrlCriterioVO.setVlrc(vlrcCriterioVO);
            vlrdCriterioVO.setVlrl(vlrlCriterioVO);

            srcrDAO.deleteValoracion(srcrCriterioVO);

            vlrdDAO.deleteList(vlrdCriterioVO);
            vlrlDAO.delete(vlrlCriterioVO);
            vlriDAO.delete(vlrcCriterioVO);
            vlrgDAO.delete(vlrcCriterioVO);
            vlrcDAO.delete(vlrcCriterioVO);

            session.commit();
        }
    }

    /**
     * Select.
     *
     * @param id
     *            the id
     * @return the valoracion vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public ValoracionVO select(final Long id, final String idioma) throws InstanceNotFoundException {
        Preconditions.checkNotNull(id);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ValoracionDAO vlrcDAO = session.getMapper(ValoracionDAO.class);
            final ValoracionCriterioVO vlrcCriterio = new ValoracionCriterioVO();

            vlrcCriterio.setId(id);
            vlrcCriterio.setIdioma(idioma);

            final ValoracionVO vlrc = vlrcDAO.selectObject(vlrcCriterio);

            if (vlrc == null) {
                throw new InstanceNotFoundException(MessageI18nKey.vlrc, id);
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
                vlrcList.addAll(vlrcDAO.selectPaginatedList(vlrcCriterioVO, new RowBounds(offset, limit)));
            }

            return new PaginatedList<ValoracionVO>(vlrcList, offset, limit, count);
        }
    }

    /**
     * Select imprimir.
     *
     * @param ids
     *            the ids
     * @return the list
     */
    public List<ValoracionImpresionVO> selectImprimir(final Set<Long> ids, final String idioma) {
        Preconditions.checkNotNull(ids);
        Preconditions.checkArgument(!ids.isEmpty());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ValoracionDAO vlrcDAO = session.getMapper(ValoracionDAO.class);
            final ValoracionCargoDAO vlrgDAO = session.getMapper(ValoracionCargoDAO.class);
            final ValoracionImpuestoDAO vlriDAO = session.getMapper(ValoracionImpuestoDAO.class);
            final ValoracionLineaDAO vlrlDAO = session.getMapper(ValoracionLineaDAO.class);

            final List<ValoracionImpresionVO> list = new ArrayList<>();

            for (final Long vlrcId : ids) {
                final ValoracionCriterioVO vlrcCriterioVO = new ValoracionCriterioVO();
                final ValoracionLineaCriterioVO vlrlCriterioVO = new ValoracionLineaCriterioVO();

                vlrcCriterioVO.setId(vlrcId);
                vlrcCriterioVO.setIdioma(idioma);

                vlrlCriterioVO.setVlrc(vlrcCriterioVO);

                final ValoracionVO vlrc = vlrcDAO.selectObject(vlrcCriterioVO);

                if (vlrc != null) {
                    final List<ValoracionCargoVO> vlrgList = vlrgDAO.selectList(vlrcCriterioVO);
                    final List<ValoracionImpuestoVO> vlriList = vlriDAO.selectList(vlrcCriterioVO);
                    final List<ValoracionLineaVO> vlrlList = vlrlDAO.selectList(vlrlCriterioVO);

                    list.add(new ValoracionImpresionVO(vlrc, vlrgList, vlriList, vlrlList));
                }
            }

            return list;
        }
    }

    /**
     * Select vlri list.
     *
     * @param vlrcCriterioVO
     *            the vlrc criterio vo
     * @return the list
     */
    public List<ValoracionImpuestoVO> selectVlriList(final ValoracionCriterioVO vlrcCriterioVO) {
        Preconditions.checkNotNull(vlrcCriterioVO);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ValoracionImpuestoDAO vlriDAO = session.getMapper(ValoracionImpuestoDAO.class);

            return vlriDAO.selectList(vlrcCriterioVO);
        }
    }

    /**
     * Select vlrg list.
     *
     * @param vlrcCriterioVO
     *            the vlrc criterio vo
     * @return the list
     */
    public List<ValoracionCargoVO> selectVlrgList(final ValoracionCriterioVO vlrcCriterioVO) {
        Preconditions.checkNotNull(vlrcCriterioVO);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ValoracionCargoDAO vlrgDAO = session.getMapper(ValoracionCargoDAO.class);

            return vlrgDAO.selectList(vlrcCriterioVO);
        }
    }

    /**
     * Select vlrl.
     *
     * @param vlrlId
     *            the vlrl id
     * @return the valoracion linea vo
     */
    public ValoracionLineaVO selectVlrl(final Long vlrlId) {
        Preconditions.checkNotNull(vlrlId);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ValoracionLineaDAO vlrlDAO = session.getMapper(ValoracionLineaDAO.class);

            return vlrlDAO.select(vlrlId);
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
     * @param vlrlCriterioVO
     *            the vlrl criterio vo
     * @return the list
     */
    public List<ValoracionLineaVO> selectVlrlList(final ValoracionLineaCriterioVO vlrlCriterioVO) {
        Preconditions.checkNotNull(vlrlCriterioVO);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ValoracionLineaDAO vlrlDAO = session.getMapper(ValoracionLineaDAO.class);

            return vlrlDAO.selectList(vlrlCriterioVO);
        }
    }

    /**
     * Select vlrl list.
     *
     * @param vlrlCriterioVO
     *            the vlrl criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public PaginatedList<ValoracionLineaVO> selectVlrlList(final ValoracionLineaCriterioVO vlrlCriterioVO,
            final int offset, final int limit) {
        Preconditions.checkNotNull(vlrlCriterioVO);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ValoracionLineaDAO vlrlDAO = session.getMapper(ValoracionLineaDAO.class);
            final int count = vlrlDAO.count(vlrlCriterioVO);
            final List<ValoracionLineaVO> vlrlList = new ArrayList<>();

            if (count >= offset) {
                vlrlList.addAll(vlrlDAO.selectPaginatedList(vlrlCriterioVO, new RowBounds(offset, limit)));
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
     * @param vlrd
     *            Datos de un detalle de valoracion.
     */
    public void insertVlrl(final ValoracionLineaVO vlrl, final ValoracionDetalleVO vlrd) {
        Preconditions.checkNotNull(vlrl);
        Preconditions.checkNotNull(vlrl.getVlrcId());
        Preconditions.checkNotNull(vlrl.getRgla());
        Preconditions.checkNotNull(vlrl.getRgla().getId());
        Preconditions.checkNotNull(vlrl.getImpuesto());
        Preconditions.checkNotNull(vlrl.getImpuesto().getId());

        Preconditions.checkNotNull(vlrd);
        Preconditions.checkNotNull(vlrd.getImporte());
        Preconditions.checkNotNull(vlrd.getImporteBase());

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            final ValoracionDAO vlrcDAO = session.getMapper(ValoracionDAO.class);
            final ValoracionLineaDAO vlrlDAO = session.getMapper(ValoracionLineaDAO.class);
            final ValoracionDetalleDAO vlrdDAO = session.getMapper(ValoracionDetalleDAO.class);
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

            if (rgla.getRglv().getTipo() != ReglaTipo.T) {
                Preconditions.checkNotNull(vlrl.getPadreId());
            }

            final AspectoVO aspc = vlrc.getAspc();
            final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

            // ssrvCriterioVO.setFechaVigencia(vlrc.getFref());

            if (rgla.getRglv().getEnti().getTipo() == TipoEntidad.S) {
                if (aspc.getAspv().isAgrupaDetalles()) {
                    Preconditions.checkNotNull(vlrd.getSsrv());
                    Preconditions.checkNotNull(vlrd.getSsrv().getId());

                    ssrvCriterioVO.setId(vlrd.getSsrv().getId());

                    final SubservicioVO ssrv = ssrvDAO.selectObject(ssrvCriterioVO);

                    if (ssrv.getEntiId() != rgla.getRglv().getEnti().getId()) {
                        throw new Error("Subservicio no valido para la regla");
                    }
                } else {
                    Preconditions.checkNotNull(vlrl.getSsrv());
                    Preconditions.checkNotNull(vlrl.getSsrv().getId());

                    ssrvCriterioVO.setId(vlrl.getSsrv().getId());

                    final SubservicioVO ssrv = ssrvDAO.selectObject(ssrvCriterioVO);

                    if (ssrv.getEntiId() != rgla.getRglv().getEnti().getId()) {
                        throw new Error("Subservicio no valido para la regla");
                    }
                }
            }

            // Grabacion de datos
            final IgBO igBO = new IgBO();

            vlrl.setId(igBO.nextVal(IgBO.SQ_INTEGRA));
            vlrd.setId(igBO.nextVal(IgBO.SQ_INTEGRA));
            vlrd.setVlrlId(vlrl.getId());
            vlrd.setVlrcId(vlrl.getVlrcId());

            vlrlDAO.insert(vlrl);
            vlrdDAO.insert(vlrd);

            recalcularVlrc(session, vlrl.getVlrcId());

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
     * @param vlrlId
     *            the vlrl id
     */
    public void deleteVlrl(final Long vlrlId) {
        Preconditions.checkNotNull(vlrlId);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ValoracionLineaDAO vlrlDAO = session.getMapper(ValoracionLineaDAO.class);
            final ValoracionDetalleDAO vlrdDAO = session.getMapper(ValoracionDetalleDAO.class);

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

                vlrdDAO.deleteList(vlrdCriterioVO);
                vlrlDAO.delete(vlrlCriterioVO);

                // Recalcular cargos e importes de IVA
                recalcularVlrc(session, vlrl.getVlrcId());
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
            final ValoracionDetalleVO vlrd = vlrdDAO.select(vlrdId);

            if (vlrd == null) {
                throw new InstanceNotFoundException(MessageI18nKey.vlrd, vlrdId);
            }

            return vlrd;
        }
    }

    /**
     * Select vlrd list.
     *
     * @param vlrdCriterioVO
     *            the vlrd criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    public PaginatedList<ValoracionDetalleVO> selectVlrdList(final ValoracionDetalleCriterioVO vlrdCriterioVO,
            final int offset, final int limit) {
        Preconditions.checkNotNull(vlrdCriterioVO);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ValoracionDetalleDAO vlrdDAO = session.getMapper(ValoracionDetalleDAO.class);
            final int count = vlrdDAO.count(vlrdCriterioVO);
            final List<ValoracionDetalleVO> vlrdList = new ArrayList<>();

            if (count >= offset) {
                vlrdList.addAll(vlrdDAO.selectPaginatedList(vlrdCriterioVO, new RowBounds(offset, limit)));
            }

            return new PaginatedList<ValoracionDetalleVO>(vlrdList, offset, limit, count);
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
            final ValoracionLineaVO vlrl = vlrlDAO.select(vlrd.getVlrlId());

            final IgBO igBO = new IgBO();

            if (vlrl == null) {
                throw new InstanceNotFoundException(MessageI18nKey.vlrl, vlrd.getVlrlId());
            }

            vlrd.setVlrcId(vlrl.getVlrcId());
            vlrd.setId(igBO.nextVal(IgBO.SQ_INTEGRA));

            vlrdDAO.insert(vlrd);

            recalcularVlrc(session, vlrd.getVlrcId());

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

            recalcularVlrc(session, vlrd.getVlrcId());

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
            final int updated = vlrdDAO.delete(vlrd);

            if (updated == 0) {
                throw new InstanceNotFoundException(MessageI18nKey.vlrd, vlrd.getId());
            }

            final ValoracionDetalleCriterioVO vlrdCriterioVO = new ValoracionDetalleCriterioVO();
            final ValoracionLineaCriterioVO vlrlCriterioVO = new ValoracionLineaCriterioVO();

            vlrlCriterioVO.setId(vlrd.getVlrlId());
            vlrdCriterioVO.setVlrl(vlrlCriterioVO);

            final int count = vlrdDAO.count(vlrdCriterioVO);

            if (count == 0) {
                vlrlDAO.delete(vlrlCriterioVO);
            }

            recalcularVlrc(session, vlrd.getVlrcId());

            session.commit();
        }
    }

    /**
     * Recalcular.
     *
     * @param session
     *            the session
     * @param vlrcId
     *            the vlrc id
     */
    private void recalcularVlrc(final SqlSession session, final Long vlrcId) {
        Preconditions.checkNotNull(vlrcId);

        final ValoracionCargoDAO vlrgDAO = session.getMapper(ValoracionCargoDAO.class);
        final ValoracionImpuestoDAO vlriDAO = session.getMapper(ValoracionImpuestoDAO.class);

        // Recalcular cargos e importes de IVA

        final ValoracionCriterioVO vlrcCriterioVO = new ValoracionCriterioVO();

        vlrcCriterioVO.setId(vlrcId);

        vlrgDAO.delete(vlrcCriterioVO);
        vlrgDAO.insertGenerate(vlrcCriterioVO);
        vlriDAO.delete(vlrcCriterioVO);

        final List<ValoracionImpuestoVO> vlriList = vlriDAO.selectGenerateList(vlrcCriterioVO);

        for (final ValoracionImpuestoVO vlri : vlriList) {
            vlriDAO.insert(vlri);
        }
    }

}
