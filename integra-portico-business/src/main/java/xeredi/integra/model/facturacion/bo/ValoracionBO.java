package xeredi.integra.model.facturacion.bo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.bo.IgBO;
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
import xeredi.integra.model.util.GlobalNames;
import xeredi.util.mybatis.SqlMapperLocator;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionBO.
 */
public class ValoracionBO {

    /** The vlrc dao. */
    ValoracionDAO vlrcDAO;

    /** The vlrl dao. */
    ValoracionLineaDAO vlrlDAO;

    /** The vlrd dao. */
    ValoracionDetalleDAO vlrdDAO;

    /** The vlri dao. */
    ValoracionImpuestoDAO vlriDAO;

    /** The vlrg dao. */
    ValoracionCargoDAO vlrgDAO;

    /** The srcr dao. */
    ServicioCargoDAO srcrDAO;

    /** The rgla dao. */
    ReglaDAO rglaDAO;

    /** The ssrv dao. */
    SubservicioDAO ssrvDAO;

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

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        srcrDAO = session.getMapper(ServicioCargoDAO.class);
        vlrdDAO = session.getMapper(ValoracionDetalleDAO.class);
        vlrlDAO = session.getMapper(ValoracionLineaDAO.class);
        vlriDAO = session.getMapper(ValoracionImpuestoDAO.class);
        vlrgDAO = session.getMapper(ValoracionCargoDAO.class);
        vlrcDAO = session.getMapper(ValoracionDAO.class);

        try {
            final ValoracionCriterioVO vlrcCriterioVO = new ValoracionCriterioVO();
            final ValoracionLineaCriterioVO vlrlCriterioVO = new ValoracionLineaCriterioVO();
            final ValoracionDetalleCriterioVO vlrdCriterioVO = new ValoracionDetalleCriterioVO();
            final ServicioCargoCriterioVO srcrCriterioVO = new ServicioCargoCriterioVO();

            srcrCriterioVO.setVlrcIds(ids);
            vlrcCriterioVO.setIds(ids);
            vlrlCriterioVO.setVlrc(vlrcCriterioVO);
            vlrdCriterioVO.setVlrl(vlrlCriterioVO);

            srcrDAO.deleteValoracion(srcrCriterioVO);

            vlrdDAO.delete(vlrdCriterioVO);
            vlrlDAO.delete(vlrlCriterioVO);
            vlriDAO.delete(vlrcCriterioVO);
            vlrgDAO.delete(vlrcCriterioVO);
            vlrcDAO.delete(vlrcCriterioVO);

            session.commit();
        } finally {
            session.close();
        }
    }

    /**
     * Select.
     *
     * @param id
     *            the id
     * @return the valoracion vo
     */
    public ValoracionVO select(final Long id) {
        Preconditions.checkNotNull(id);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        vlrcDAO = session.getMapper(ValoracionDAO.class);

        try {
            final ValoracionVO vlrc = vlrcDAO.select(id);

            return vlrc;
        } finally {
            session.close();
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

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        vlrcDAO = session.getMapper(ValoracionDAO.class);

        try {
            final int count = vlrcDAO.count(vlrcCriterioVO);
            final List<ValoracionVO> vlrcList = new ArrayList<>();

            if (count >= offset) {
                vlrcList.addAll(vlrcDAO.selectList(vlrcCriterioVO, new RowBounds(offset, limit)));
            }

            return new PaginatedList<ValoracionVO>(vlrcList, offset, limit, count);
        } finally {
            session.close();
        }
    }

    /**
     * Select imprimir.
     *
     * @param ids
     *            the ids
     * @return the list
     */
    public List<ValoracionImpresionVO> selectImprimir(final Set<Long> ids) {
        Preconditions.checkNotNull(ids);
        Preconditions.checkArgument(!ids.isEmpty());

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        vlrcDAO = session.getMapper(ValoracionDAO.class);
        vlrgDAO = session.getMapper(ValoracionCargoDAO.class);
        vlriDAO = session.getMapper(ValoracionImpuestoDAO.class);
        vlrlDAO = session.getMapper(ValoracionLineaDAO.class);

        try {
            final List<ValoracionImpresionVO> list = new ArrayList<>();

            for (final Long vlrcId : ids) {
                final ValoracionCriterioVO vlrcCriterioVO = new ValoracionCriterioVO();
                final ValoracionLineaCriterioVO vlrlCriterioVO = new ValoracionLineaCriterioVO();

                vlrcCriterioVO.setId(vlrcId);
                vlrlCriterioVO.setVlrc(vlrcCriterioVO);

                final ValoracionVO vlrc = vlrcDAO.select(vlrcId);

                if (vlrc != null) {
                    final List<ValoracionCargoVO> vlrgList = vlrgDAO.selectList(vlrcCriterioVO);
                    final List<ValoracionImpuestoVO> vlriList = vlriDAO.selectList(vlrcCriterioVO);
                    final List<ValoracionLineaVO> vlrlList = vlrlDAO.selectList(vlrlCriterioVO);

                    list.add(new ValoracionImpresionVO(vlrc, vlrgList, vlriList, vlrlList));
                }
            }

            return list;
        } finally {
            session.close();
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

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        vlriDAO = session.getMapper(ValoracionImpuestoDAO.class);

        try {
            return vlriDAO.selectList(vlrcCriterioVO);
        } finally {
            session.close();
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

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        vlrgDAO = session.getMapper(ValoracionCargoDAO.class);

        try {
            return vlrgDAO.selectList(vlrcCriterioVO);
        } finally {
            session.close();
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

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        vlrlDAO = session.getMapper(ValoracionLineaDAO.class);

        try {
            return vlrlDAO.select(vlrlId);
        } finally {
            session.close();
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

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        vlrlDAO = session.getMapper(ValoracionLineaDAO.class);

        try {
            return vlrlDAO.existsDependencia(vlrlId);
        } finally {
            session.close();
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

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        vlrlDAO = session.getMapper(ValoracionLineaDAO.class);
        vlrdDAO = session.getMapper(ValoracionDetalleDAO.class);
        vlrgDAO = session.getMapper(ValoracionCargoDAO.class);
        vlriDAO = session.getMapper(ValoracionImpuestoDAO.class);

        try {
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

                vlrdDAO.delete(vlrdCriterioVO);
                vlrlDAO.delete(vlrlCriterioVO);

                // Recalcular cargos e importes de IVA
                vlrgDAO.delete(vlrcCriterioVO);
                vlrgDAO.insertGenerate(vlrcCriterioVO);
                vlriDAO.delete(vlrcCriterioVO);

                final List<ValoracionImpuestoVO> vlriList = vlriDAO.selectGenerateList(vlrcCriterioVO);

                for (final ValoracionImpuestoVO vlri : vlriList) {
                    vlriDAO.insert(vlri);
                }
            }

            session.commit();
        } finally {
            session.close();
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
     * <li>Si la regla está asociada a subservicios y el aspecto es de agrupacion, se comprueba que la linea tenga un
     * subservicio asociado, y que sea de la misma entidad que la regla</li>
     * <li>Si la regla está asociada a subservicios y el aspecto no es de agrupacion, se comprueba que el detalle tenga
     * un subservicio asociado, y que sea de la misma entidad que la regla</li>
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

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        vlrcDAO = session.getMapper(ValoracionDAO.class);
        vlrlDAO = session.getMapper(ValoracionLineaDAO.class);
        vlrdDAO = session.getMapper(ValoracionDetalleDAO.class);
        rglaDAO = session.getMapper(ReglaDAO.class);
        ssrvDAO = session.getMapper(SubservicioDAO.class);

        try {
            // Validacion de datos
            final ValoracionVO vlrc = vlrcDAO.select(vlrl.getVlrcId());

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

            ssrvCriterioVO.setFechaVigencia(vlrc.getFref());

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

            vlrl.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
            vlrd.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
            vlrd.setVlrlId(vlrl.getId());
            vlrd.setVlrcId(vlrl.getVlrcId());

            vlrlDAO.insert(vlrl);
            vlrdDAO.insert(vlrd);

            session.commit();
        } finally {
            session.close();
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

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        vlrlDAO = session.getMapper(ValoracionLineaDAO.class);

        try {
            return vlrlDAO.selectList(vlrlCriterioVO);
        } finally {
            session.close();
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

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        vlrlDAO = session.getMapper(ValoracionLineaDAO.class);

        try {
            final int count = vlrlDAO.count(vlrlCriterioVO);
            final List<ValoracionLineaVO> vlrlList = new ArrayList<>();

            if (count >= offset) {
                vlrlList.addAll(vlrlDAO.selectList(vlrlCriterioVO, new RowBounds(offset, limit)));
            }

            return new PaginatedList<ValoracionLineaVO>(vlrlList, offset, limit, count);
        } finally {
            session.close();
        }
    }

    /**
     * Select vlrd.
     *
     * @param vlrdId
     *            the vlrd id
     * @return the valoracion detalle vo
     */
    public ValoracionDetalleVO selectVlrd(final Long vlrdId) {
        Preconditions.checkNotNull(vlrdId);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        vlrdDAO = session.getMapper(ValoracionDetalleDAO.class);

        try {
            return vlrdDAO.select(vlrdId);
        } finally {
            session.close();
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

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        vlrdDAO = session.getMapper(ValoracionDetalleDAO.class);

        try {
            final int count = vlrdDAO.count(vlrdCriterioVO);
            final List<ValoracionDetalleVO> vlrdList = new ArrayList<>();

            if (count >= offset) {
                vlrdList.addAll(vlrdDAO.selectList(vlrdCriterioVO, new RowBounds(offset, limit)));
            }

            return new PaginatedList<ValoracionDetalleVO>(vlrdList, offset, limit, count);
        } finally {
            session.close();
        }
    }

}
