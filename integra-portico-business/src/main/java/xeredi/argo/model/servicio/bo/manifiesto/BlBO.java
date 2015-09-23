package xeredi.argo.model.servicio.bo.manifiesto;

import java.util.Set;

import lombok.NonNull;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

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
import xeredi.util.mybatis.SqlMapperLocator;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class BlBO.
 */
public final class BlBO extends SubservicioBO {
    /**
     * {@inheritDoc}
     */
    @Override
    protected void insertPostOperations(final @NonNull SqlSession session, final @NonNull SubservicioVO ssrvVO,
            final @NonNull TipoSubservicioDetailVO tpssDetail, final Set<Long> ssrvPadreIds)
                    throws DuplicateInstanceException {
        final ManifiestoServicioDAO maniDAO = session.getMapper(ManifiestoServicioDAO.class);

        maniDAO.updateRecalcularEstado(ssrvVO.getSrvc().getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void duplicatePostOperations(final @NonNull SqlSession session, final @NonNull SubservicioVO ssrvVO) {
        final ManifiestoServicioDAO maniDAO = session.getMapper(ManifiestoServicioDAO.class);

        maniDAO.updateRecalcularEstado(ssrvVO.getSrvc().getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void updatePostOperations(final @NonNull SqlSession session, final @NonNull SubservicioVO ssrvVO)
            throws InstanceNotFoundException {
        final ManifiestoServicioDAO maniDAO = session.getMapper(ManifiestoServicioDAO.class);

        maniDAO.updateRecalcularEstado(ssrvVO.getSrvc().getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void deletePostOperations(final @NonNull SqlSession session, final @NonNull SubservicioVO ssrv)
            throws InstanceNotFoundException {
        final ManifiestoServicioDAO maniDAO = session.getMapper(ManifiestoServicioDAO.class);

        maniDAO.updateRecalcularEstado(ssrv.getSrvc().getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void statechangePostOperations(final @NonNull SqlSession session, final @NonNull SubservicioVO ssrv,
            final @NonNull ItemTramiteVO ittr, final @NonNull TramiteDetailVO trmtDetail) throws ModelException {
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
    public ResumenTotalesVO selectResumen(final Long maniId, final Long blId) throws InstanceNotFoundException {
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