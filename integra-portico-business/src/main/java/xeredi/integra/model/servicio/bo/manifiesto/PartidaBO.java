package xeredi.integra.model.servicio.bo.manifiesto;

import java.util.Set;

import lombok.NonNull;

import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.exception.ModelException;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioDetailVO;
import xeredi.integra.model.metamodelo.proxy.TramiteDetailVO;
import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.servicio.bo.AbstractSubservicioBO;
import xeredi.integra.model.servicio.dao.SubservicioDAO;
import xeredi.integra.model.servicio.dao.manifiesto.BlDAO;
import xeredi.integra.model.servicio.dao.manifiesto.EquipamientoDAO;
import xeredi.integra.model.servicio.dao.manifiesto.ManifiestoServicioDAO;
import xeredi.integra.model.servicio.vo.ServicioCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioTramiteVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class PartidaBO.
 */
public final class PartidaBO extends AbstractSubservicioBO {
    /**
     * {@inheritDoc}
     */
    @Override
    protected void insertPostOperations(final @NonNull SqlSession session, final @NonNull SubservicioVO ssrvVO,
            final @NonNull TipoSubservicioDetailVO tpssSubservicioDetail, final Set<Long> ssrvPadreIds)
                    throws DuplicateInstanceException {
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
    protected void duplicatePostOperations(final @NonNull SqlSession session, final @NonNull SubservicioVO ssrvVO) {
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
    protected void updatePostOperations(final @NonNull SqlSession session, final @NonNull SubservicioVO ssrvVO)
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
    protected void deletePostOperations(final @NonNull SqlSession session, final @NonNull SubservicioVO ssrv)
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
    protected void statechangePostOperations(final @NonNull SqlSession session, final @NonNull SubservicioVO ssrv,
            final @NonNull SubservicioTramiteVO sstr, final @NonNull TramiteDetailVO trmtDetail) throws ModelException {
        Preconditions.checkNotNull(ssrv.getId());
        Preconditions.checkNotNull(ssrv.getSrvc());
        Preconditions.checkNotNull(ssrv.getSrvc().getId());
        Preconditions.checkNotNull(trmtDetail.getTrmt());
        Preconditions.checkNotNull(trmtDetail.getTrmt().getEstadoDest());

        // Propagaciones a hermanos
        final EquipamientoDAO equiDAO = session.getMapper(EquipamientoDAO.class);
        final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);

        switch (trmtDetail.getTrmt().getEstadoDest()) {
        case "B":
            // Bloqueo de los hermanos
            equiDAO.updateBloquearFromPartida(ssrv.getId());

            break;
        case "R":
            // Inicio de los hermanos
            equiDAO.updateIniciarFromPartida(ssrv.getId());

            break;
        case "A":
            // Borrado de los Partida-Equipamiento asociados
            final SubservicioCriterioVO paeqCriterioVO = new SubservicioCriterioVO();

            paeqCriterioVO.setEntiId(Entidad.PARTIDA_EQUIPAMIENTO.getId());
            paeqCriterioVO.setPadreId(ssrv.getId());

            ssrvDAO.deleteList(paeqCriterioVO);

            break;
        default:
            throw new Error("Estado desconocido de la partida: " + trmtDetail.getTrmt().getEstadoDest());
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
