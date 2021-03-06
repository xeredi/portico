package xeredi.argo.model.servicio.bo.escala;

import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.ModelException;
import xeredi.argo.model.comun.exception.OperacionNoPermitidaException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.item.vo.ItemDatoVO;
import xeredi.argo.model.item.vo.ItemTramiteVO;
import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.model.metamodelo.vo.TramiteDetailVO;
import xeredi.argo.model.servicio.bo.SubservicioBO;
import xeredi.argo.model.servicio.dao.SubservicioDAO;
import xeredi.argo.model.servicio.dao.SubservicioDatoDAO;
import xeredi.argo.model.servicio.dao.escala.AtraqueDAO;
import xeredi.argo.model.servicio.dao.escala.EscalaDAO;
import xeredi.argo.model.servicio.vo.SubservicioCriterioVO;
import xeredi.argo.model.servicio.vo.SubservicioVO;
import xeredi.argo.model.util.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class AtraqueBO.
 */
public final class AtraqueBO extends SubservicioBO {

    /**
     * Instantiates a new atraque BO.
     *
     * @param ausroId
     *            the ausro id
     */
    private AtraqueBO(@NonNull final Long ausroId) {
        super(Entidad.ATRAQUE.getId(), ausroId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void statechangePostOperations(@NonNull final SqlSession session, @NonNull final SubservicioVO ssrv,
            @NonNull final ItemTramiteVO ittr, @NonNull final TramiteDetailVO trmtDetail) throws ModelException {
        Preconditions.checkNotNull(ssrv.getId());
        Preconditions.checkNotNull(ssrv.getSrvc());
        Preconditions.checkNotNull(ssrv.getSrvc().getId());
        Preconditions.checkNotNull(trmtDetail.getTrmt());
        Preconditions.checkNotNull(trmtDetail.getTrmt().getId());
        Preconditions.checkNotNull(trmtDetail.getTrmt().getEstadoOrig());
        Preconditions.checkNotNull(trmtDetail.getTrmt().getEstadoDest());

        final EscalaDAO escaDAO = session.getMapper(EscalaDAO.class);

        if ("I".equals(trmtDetail.getTrmt().getEstadoOrig()) && !"F".equals(trmtDetail.getTrmt().getEstadoDest())) {
            // FIXME Decrementar contadores escala
        }

        if ("F".equals(trmtDetail.getTrmt().getEstadoDest())) {
            // FIXME Incrementar contadores escala
        }

        // FIXME Recalcular estancia escala
        escaDAO.updateRecalcularEstado(ssrv.getSrvc().getId());
        escaDAO.updateRecalcularFechas(ssrv.getSrvc().getId());
    }

    /**
     * Checks if is iniciable.
     *
     * @param ssrvId
     *            the ssrv id
     * @return true, if is iniciable
     */
    public boolean isIniciable(final Long ssrvId) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession();) {
            final AtraqueDAO atraDAO = session.getMapper(AtraqueDAO.class);

            return atraDAO.isIniciable(ssrvId);
        }
    }

    /**
     * Iniciar.
     *
     * @param ssrvId
     *            the ssrv id
     * @param itdtMap
     *            the itdt map
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OperacionNoPermitidaException
     *             the operacion no permitida exception
     */
    public void iniciar(final Long ssrvId, final Map<Long, ItemDatoVO> itdtMap)
            throws InstanceNotFoundException, OperacionNoPermitidaException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);) {
            final AtraqueDAO atraDAO = session.getMapper(AtraqueDAO.class);
            final EscalaDAO escaDAO = session.getMapper(EscalaDAO.class);
            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
            final SubservicioDatoDAO ssdtDAO = session.getMapper(SubservicioDatoDAO.class);

            final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

            ssrvCriterioVO.setId(ssrvId);
            ssrvCriterioVO.setEntiId(Entidad.ATRAQUE.getId());

            final SubservicioVO ssrvVO = ssrvDAO.selectObject(ssrvCriterioVO);

            if (ssrvVO == null) {
                throw new InstanceNotFoundException(Entidad.ATRAQUE.getId(), ssrvId);
            }

            if (atraDAO.updateIniciar(ssrvVO.getId()) == 0) {
                throw new OperacionNoPermitidaException(Entidad.ATRAQUE.getId(), MessageI18nKey.trmt, ssrvVO.getId());
            }

            for (final Long tpdtId : itdtMap.keySet()) {
                final ItemDatoVO itdtVO = ssrvVO.getItdtMap().get(tpdtId);

                itdtVO.setItemId(ssrvVO.getId());
                itdtVO.setTpdtId(tpdtId);

                ssdtDAO.update(itdtVO);
            }

            escaDAO.updateRecalcularEstado(ssrvVO.getSrvc().getId());
            escaDAO.updateRecalcularFechas(ssrvVO.getSrvc().getId());

            // FIXME Falta actualizar contadores escala, etc

            session.commit();
        }
    }

    /**
     * Checks if is cambio muelle.
     *
     * @param ssrvId
     *            the ssrv id
     * @return true, if is cambio muelle
     */
    public boolean isCambioMuelle(final Long ssrvId) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession();) {
            final AtraqueDAO atraDAO = session.getMapper(AtraqueDAO.class);

            return atraDAO.isCambioMuelle(ssrvId);
        }
    }

    /**
     * Checks if is autorizable f previo.
     *
     * @param ssrvId
     *            the ssrv id
     * @return true, if is autorizable f previo
     */
    public boolean isAutorizableFprevio(final Long ssrvId) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession();) {
            final AtraqueDAO atraDAO = session.getMapper(AtraqueDAO.class);

            return atraDAO.isAutorizableFprevio(ssrvId);
        }
    }

    /**
     * Autorizar fprevio.
     *
     * @param ssrvId
     *            the ssrv id
     * @param itdtMap
     *            the itdt map
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OperacionNoPermitidaException
     *             the operacion no permitida exception
     */
    public void autorizarFprevio(final Long ssrvId, final Map<Long, ItemDatoVO> itdtMap)
            throws InstanceNotFoundException, OperacionNoPermitidaException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);) {
            final AtraqueDAO atraDAO = session.getMapper(AtraqueDAO.class);
            final EscalaDAO escaDAO = session.getMapper(EscalaDAO.class);
            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
            final SubservicioDatoDAO ssdtDAO = session.getMapper(SubservicioDatoDAO.class);

            final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

            ssrvCriterioVO.setId(ssrvId);
            ssrvCriterioVO.setEntiId(Entidad.ATRAQUE.getId());

            final SubservicioVO ssrvVO = ssrvDAO.selectObject(ssrvCriterioVO);

            if (ssrvVO == null) {
                throw new InstanceNotFoundException(Entidad.ATRAQUE.getId(), ssrvId);
            }

            // TODO Alta del fondeo previo en estado autorizado (C)
            // TODO Modificacion de las fechas de inicio/fin del atraque actual

            session.commit();
        }
    }
}
