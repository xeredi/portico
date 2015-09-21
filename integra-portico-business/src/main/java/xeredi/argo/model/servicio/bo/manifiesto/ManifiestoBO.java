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
import xeredi.util.mybatis.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class ManifiestoBO.
 */
public final class ManifiestoBO extends ServicioBO {

    /**
     * {@inheritDoc}
     */
    @Override
    protected final void insertPostOperations(final SqlSession session, final ServicioVO srvc,
            final List<SubservicioVO> ssrvList, final List<SubservicioSubservicioVO> ssssList) {
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
    protected final void statechangePostOperations(final @NonNull SqlSession session, final @NonNull ServicioVO srvc,
            final @NonNull ItemTramiteVO ittr, final @NonNull TramiteDetailVO trmtDetail) throws ModelException {
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
    public final ResumenTotalesVO selectResumen(final Long maniId) throws InstanceNotFoundException {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final ManifiestoResumenDAO resumenDAO = session.getMapper(ManifiestoResumenDAO.class);
            final ResumenTotalesCriterioVO totalCriterioVO = new ResumenTotalesCriterioVO();

            totalCriterioVO.setManiId(maniId);

            final ResumenTotalesVO totalVO = resumenDAO.selectObject(totalCriterioVO);

            if (totalVO == null) {
                throw new InstanceNotFoundException(Entidad.MANIFIESTO.getId(), totalCriterioVO);
            }

            return totalVO;
        }
    }
}
