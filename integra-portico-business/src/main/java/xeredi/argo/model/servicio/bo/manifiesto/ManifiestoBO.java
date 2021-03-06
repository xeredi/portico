package xeredi.argo.model.servicio.bo.manifiesto;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.ModelException;
import xeredi.argo.model.item.vo.ItemTramiteVO;
import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.model.metamodelo.vo.TramiteDetailVO;
import xeredi.argo.model.servicio.bo.ServicioBO;
import xeredi.argo.model.servicio.dao.manifiesto.BlDAO;
import xeredi.argo.model.servicio.dao.manifiesto.ManifiestoResumenDAO;
import xeredi.argo.model.servicio.dao.manifiesto.ManifiestoServicioDAO;
import xeredi.argo.model.servicio.dao.manifiesto.ManifiestoSubservicioDAO;
import xeredi.argo.model.servicio.vo.ServicioCriterioVO;
import xeredi.argo.model.servicio.vo.ServicioVO;
import xeredi.argo.model.servicio.vo.SubservicioCriterioVO;
import xeredi.argo.model.servicio.vo.SubservicioSubservicioVO;
import xeredi.argo.model.servicio.vo.SubservicioVO;
import xeredi.argo.model.servicio.vo.manifiesto.ResumenTotalesCriterioVO;
import xeredi.argo.model.servicio.vo.manifiesto.ResumenTotalesVO;
import xeredi.argo.model.util.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class ManifiestoBO.
 */
public final class ManifiestoBO extends ServicioBO {

    /**
     * Instantiates a new manifiesto BO.
     *
     * @param ausroId
     *            the ausro id
     */
    public ManifiestoBO(@NonNull final Long ausroId) {
        super(Entidad.MANIFIESTO.getId(), ausroId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void insertPostOperations(@NonNull final SqlSession session, @NonNull final ServicioVO srvc,
            final List<SubservicioVO> ssrvList, final List<SubservicioSubservicioVO> ssssList) {
        Preconditions.checkNotNull(srvc.getId());

        final BlDAO blDAO = session.getMapper(BlDAO.class);

        final SubservicioCriterioVO ssrvCriterio = new SubservicioCriterioVO();
        final ServicioCriterioVO srvcCriterio = new ServicioCriterioVO();

        srvcCriterio.setId(srvc.getId());
        ssrvCriterio.setSrvc(srvcCriterio);

        // FIXME
        // blDAO.updateRecalcularEstado(ssrvCriterio);
        // blDAO.updateRecalcularTipoIva(ssrvCriterio);

        final ManifiestoServicioDAO maniDAO = session.getMapper(ManifiestoServicioDAO.class);

        maniDAO.updateRecalcularEstado(srvc.getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void statechangePostOperations(@NonNull final SqlSession session, @NonNull final ServicioVO srvc,
            @NonNull final ItemTramiteVO ittr, @NonNull final TramiteDetailVO trmtDetail) throws ModelException {
        Preconditions.checkNotNull(srvc.getId());
        Preconditions.checkNotNull(trmtDetail.getTrmt());
        Preconditions.checkNotNull(trmtDetail.getTrmt().getEstadoDest());

        final ManifiestoSubservicioDAO maniSsrvDAO = session.getMapper(ManifiestoSubservicioDAO.class);
        final SubservicioCriterioVO ssrvCriterio = new SubservicioCriterioVO();
        final ServicioCriterioVO srvcCriterio = new ServicioCriterioVO();

        srvcCriterio.setId(srvc.getId());
        ssrvCriterio.setSrvc(srvcCriterio);

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
            throw new Error("Estado desconocido de manifiesto: " + trmtDetail.getTrmt().getEstadoDest());
        }
    }

    /**
     * Select resumen.
     *
     * @param maniId
     *            the mani id
     * @return the resumen totales vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public ResumenTotalesVO selectResumen(@NonNull final Long maniId) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ManifiestoResumenDAO resumenDAO = session.getMapper(ManifiestoResumenDAO.class);
            final ResumenTotalesCriterioVO totalCriterioVO = new ResumenTotalesCriterioVO();

            totalCriterioVO.setManiId(maniId);

            final ResumenTotalesVO totalVO = resumenDAO.selectObject(totalCriterioVO);

            if (totalVO == null) {
                throw new InstanceNotFoundException(entiId, totalCriterioVO);
            }

            return totalVO;
        }
    }
}
