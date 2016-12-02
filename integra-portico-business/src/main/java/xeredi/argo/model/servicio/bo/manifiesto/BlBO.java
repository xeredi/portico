package xeredi.argo.model.servicio.bo.manifiesto;

import java.util.Set;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.ModelException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.item.vo.ItemTramiteVO;
import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioDetailVO;
import xeredi.argo.model.metamodelo.vo.TramiteDetailVO;
import xeredi.argo.model.servicio.bo.SubservicioBO;
import xeredi.argo.model.servicio.dao.manifiesto.ManifiestoResumenDAO;
import xeredi.argo.model.servicio.dao.manifiesto.ManifiestoServicioDAO;
import xeredi.argo.model.servicio.dao.manifiesto.ManifiestoSubservicioDAO;
import xeredi.argo.model.servicio.vo.ServicioCriterioVO;
import xeredi.argo.model.servicio.vo.SubservicioCriterioVO;
import xeredi.argo.model.servicio.vo.SubservicioVO;
import xeredi.argo.model.servicio.vo.manifiesto.ResumenTotalesCriterioVO;
import xeredi.argo.model.servicio.vo.manifiesto.ResumenTotalesVO;
import xeredi.argo.model.util.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class BlBO.
 */
public final class BlBO extends SubservicioBO {

    /**
     * Instantiates a new bl BO.
     *
     * @param ausroId
     *            the ausro id
     */
    public BlBO(@NonNull final Long ausroId) {
        super(Entidad.BL.getId(), ausroId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void insertPostOperations(@NonNull final SqlSession session, @NonNull final SubservicioVO ssrv,
            @NonNull final TipoSubservicioDetailVO tpssDetail, final Set<Long> ssrvPadreIds)
            throws DuplicateInstanceException {
        Preconditions.checkNotNull(ssrv.getSrvc());
        Preconditions.checkNotNull(ssrv.getSrvc().getId());

        final ManifiestoServicioDAO maniDAO = session.getMapper(ManifiestoServicioDAO.class);

        maniDAO.updateRecalcularEstado(ssrv.getSrvc().getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void duplicatePostOperations(@NonNull final SqlSession session, @NonNull final SubservicioVO ssrv) {
        Preconditions.checkNotNull(ssrv.getSrvc());
        Preconditions.checkNotNull(ssrv.getSrvc().getId());

        final ManifiestoServicioDAO maniDAO = session.getMapper(ManifiestoServicioDAO.class);

        maniDAO.updateRecalcularEstado(ssrv.getSrvc().getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void updatePostOperations(@NonNull final SqlSession session, @NonNull final SubservicioVO ssrv)
            throws InstanceNotFoundException {
        Preconditions.checkNotNull(ssrv.getSrvc());
        Preconditions.checkNotNull(ssrv.getSrvc().getId());

        final ManifiestoServicioDAO maniDAO = session.getMapper(ManifiestoServicioDAO.class);

        maniDAO.updateRecalcularEstado(ssrv.getSrvc().getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void deletePostOperations(@NonNull final SqlSession session, @NonNull final SubservicioVO ssrv)
            throws InstanceNotFoundException {
        Preconditions.checkNotNull(ssrv.getSrvc());
        Preconditions.checkNotNull(ssrv.getSrvc().getId());

        final ManifiestoServicioDAO maniDAO = session.getMapper(ManifiestoServicioDAO.class);

        maniDAO.updateRecalcularEstado(ssrv.getSrvc().getId());
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
        Preconditions.checkNotNull(trmtDetail.getTrmt().getEstadoDest());

        // Propagar el estado del BL a sus hijos
        final ManifiestoSubservicioDAO maniSsrvDAO = session.getMapper(ManifiestoSubservicioDAO.class);
        final SubservicioCriterioVO ssrvCriterio = new SubservicioCriterioVO();
        final ServicioCriterioVO srvcCriterio = new ServicioCriterioVO();

        srvcCriterio.setId(ssrv.getSrvc().getId());
        ssrvCriterio.setSrvc(srvcCriterio);
        ssrvCriterio.setPadreId(ssrv.getId());

        switch (trmtDetail.getTrmt().getEstadoDest()) {
        case "B":
            maniSsrvDAO.updateBloquear(ssrvCriterio);

            break;
        case "C":
            maniSsrvDAO.updateCompletar(ssrvCriterio);

            break;
        case "I":
            maniSsrvDAO.updateIniciar(ssrvCriterio);

            break;
        case "A":
            maniSsrvDAO.updateAnular(ssrvCriterio);

            break;
        default:
            throw new Error("Estado desconocido de bl: " + trmtDetail.getTrmt().getEstadoDest());
        }

        // Recalcular estado del servicio
        final ManifiestoServicioDAO maniSrvcDAO = session.getMapper(ManifiestoServicioDAO.class);

        if (maniSrvcDAO.updateRecalcularEstado(ssrv.getSrvc().getId()) == 0) {
            throw new InstanceNotFoundException(MessageI18nKey.srvc, ssrv.getSrvc().getId());
        }
    }

    /**
     * Select resumen.
     *
     * @param maniId
     *            the mani id
     * @param blId
     *            the bl id
     * @return the resumen totales vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public ResumenTotalesVO selectResumen(@NonNull final Long maniId, @NonNull final Long blId)
            throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ManifiestoResumenDAO resumenDAO = session.getMapper(ManifiestoResumenDAO.class);

            final ResumenTotalesCriterioVO totalCriterioVO = new ResumenTotalesCriterioVO();

            totalCriterioVO.setManiId(maniId);
            totalCriterioVO.setBlId(blId);

            final ResumenTotalesVO totalVO = resumenDAO.selectObject(totalCriterioVO);

            if (totalVO == null) {
                throw new InstanceNotFoundException(Entidad.BL.getId(), totalCriterioVO);
            }

            return totalVO;
        }
    }
}
