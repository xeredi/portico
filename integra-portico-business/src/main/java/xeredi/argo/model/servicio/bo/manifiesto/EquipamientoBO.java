package xeredi.argo.model.servicio.bo.manifiesto;

import java.util.Set;

import lombok.NonNull;

import org.apache.ibatis.session.SqlSession;

import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.ModelException;
import xeredi.argo.model.item.vo.ItemTramiteVO;
import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioDetailVO;
import xeredi.argo.model.metamodelo.vo.TramiteDetailVO;
import xeredi.argo.model.servicio.bo.SubservicioBO;
import xeredi.argo.model.servicio.dao.SubservicioDAO;
import xeredi.argo.model.servicio.dao.manifiesto.BlDAO;
import xeredi.argo.model.servicio.dao.manifiesto.ManifiestoServicioDAO;
import xeredi.argo.model.servicio.dao.manifiesto.PartidaDAO;
import xeredi.argo.model.servicio.vo.ServicioCriterioVO;
import xeredi.argo.model.servicio.vo.SubservicioCriterioVO;
import xeredi.argo.model.servicio.vo.SubservicioVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EquipamientoBO.
 */
public final class EquipamientoBO extends SubservicioBO {

    /**
     * Instantiates a new equipamiento BO.
     *
     * @param ausroId
     *            the ausro id
     */
    private EquipamientoBO(@NonNull final Long ausroId) {
        super(Entidad.EQUIPAMIENTO.getId(), ausroId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void insertPostOperations(final SqlSession session, final SubservicioVO ssrvVO,
            final TipoSubservicioDetailVO tpssDetail, final Set<Long> ssrvPadreIds) throws DuplicateInstanceException {
        final BlDAO blDAO = session.getMapper(BlDAO.class);
        final ManifiestoServicioDAO maniDAO = session.getMapper(ManifiestoServicioDAO.class);

        final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();
        final ServicioCriterioVO srvcCriterioVO = new ServicioCriterioVO();

        srvcCriterioVO.setId(ssrvVO.getSrvc().getId());

        ssrvCriterioVO.setSrvc(srvcCriterioVO);
        ssrvCriterioVO.setEntiId(Entidad.BL.getId());
        ssrvCriterioVO.setHijoId(ssrvVO.getId());

        blDAO.updateRecalcularEstado(ssrvCriterioVO);

        maniDAO.updateRecalcularEstado(ssrvVO.getSrvc().getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void duplicatePostOperations(final SqlSession session, final SubservicioVO ssrvVO) {
        final BlDAO blDAO = session.getMapper(BlDAO.class);
        final ManifiestoServicioDAO maniDAO = session.getMapper(ManifiestoServicioDAO.class);

        final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();
        final ServicioCriterioVO srvcCriterioVO = new ServicioCriterioVO();

        srvcCriterioVO.setId(ssrvVO.getSrvc().getId());

        ssrvCriterioVO.setSrvc(srvcCriterioVO);
        ssrvCriterioVO.setEntiId(Entidad.BL.getId());
        ssrvCriterioVO.setHijoId(ssrvVO.getId());

        blDAO.updateRecalcularEstado(ssrvCriterioVO);

        maniDAO.updateRecalcularEstado(ssrvVO.getSrvc().getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void updatePostOperations(final SqlSession session, final SubservicioVO ssrvVO)
            throws InstanceNotFoundException {
        final BlDAO blDAO = session.getMapper(BlDAO.class);
        final ManifiestoServicioDAO maniDAO = session.getMapper(ManifiestoServicioDAO.class);

        final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();
        final ServicioCriterioVO srvcCriterioVO = new ServicioCriterioVO();

        srvcCriterioVO.setId(ssrvVO.getSrvc().getId());

        ssrvCriterioVO.setSrvc(srvcCriterioVO);
        ssrvCriterioVO.setEntiId(Entidad.BL.getId());
        ssrvCriterioVO.setHijoId(ssrvVO.getId());

        blDAO.updateRecalcularEstado(ssrvCriterioVO);

        maniDAO.updateRecalcularEstado(ssrvVO.getSrvc().getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void deletePostOperations(final SqlSession session, final SubservicioVO ssrv)
            throws InstanceNotFoundException {
        final BlDAO blDAO = session.getMapper(BlDAO.class);
        final ManifiestoServicioDAO maniDAO = session.getMapper(ManifiestoServicioDAO.class);

        final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();
        final ServicioCriterioVO srvcCriterioVO = new ServicioCriterioVO();

        srvcCriterioVO.setId(ssrv.getSrvc().getId());

        ssrvCriterioVO.setSrvc(srvcCriterioVO);
        ssrvCriterioVO.setEntiId(Entidad.BL.getId());
        ssrvCriterioVO.setHijoId(ssrv.getId());

        blDAO.updateRecalcularEstado(ssrvCriterioVO);

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

        // Propagaciones a hermanos
        final PartidaDAO partDAO = session.getMapper(PartidaDAO.class);
        final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);

        switch (trmtDetail.getTrmt().getEstadoDest()) {
        case "B":
            // Bloqueo de los hermanos
            partDAO.updateBloquearFromEquipamiento(ssrv.getId());

            break;
        case "R":
            // Inicio de los hermanos
            partDAO.updateIniciarFromEquipamiento(ssrv.getId());

            break;
        case "A":
            // Borrado de los Partida-Equipamiento asociados
            final SubservicioCriterioVO paeqCriterioVO = new SubservicioCriterioVO();

            paeqCriterioVO.setEntiId(Entidad.PARTIDA_EQUIPAMIENTO.getId());
            paeqCriterioVO.setPadreId(ssrv.getId());

            ssrvDAO.deleteList(paeqCriterioVO);

            break;
        default:
            throw new Error("Estado desconocido de equipamiento: " + trmtDetail.getTrmt().getEstadoDest());
        }

        // Recalcular Estado del BL
        final BlDAO blDAO = session.getMapper(BlDAO.class);
        final SubservicioCriterioVO blCriterio = new SubservicioCriterioVO();
        final ServicioCriterioVO srvcCriterio = new ServicioCriterioVO();

        srvcCriterio.setId(ssrv.getSrvc().getId());
        blCriterio.setSrvc(srvcCriterio);
        blCriterio.setEntiId(Entidad.BL.getId());
        blCriterio.setHijoId(ssrv.getId());

        blDAO.updateRecalcularEstado(blCriterio);

        // Recalcular Estado del Servicio
        final ManifiestoServicioDAO maniSrvcDAO = session.getMapper(ManifiestoServicioDAO.class);

        maniSrvcDAO.updateRecalcularEstado(ssrv.getSrvc().getId());
    }
}
