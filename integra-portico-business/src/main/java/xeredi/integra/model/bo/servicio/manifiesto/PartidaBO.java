package xeredi.integra.model.bo.servicio.manifiesto;

import org.mybatis.guice.transactional.Transactional;

import xeredi.integra.model.bo.servicio.EstadoInvalidoException;
import xeredi.integra.model.servicio.dao.SubservicioDAO;
import xeredi.integra.model.servicio.dao.manifiesto.BlDAO;
import xeredi.integra.model.servicio.dao.manifiesto.EquipamientoDAO;
import xeredi.integra.model.servicio.dao.manifiesto.ManifiestoServicioDAO;
import xeredi.integra.model.servicio.dao.manifiesto.ManifiestoSubservicioDAO;
import xeredi.integra.model.servicio.vo.ServicioVO;
import xeredi.integra.model.servicio.vo.SubservicioCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;
import xeredi.integra.model.util.Entidad;
import xeredi.util.exception.InstanceNotFoundException;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;

// TODO: Auto-generated Javadoc
/**
 * The Class PartidaBO.
 */
@Singleton
public class PartidaBO implements Partida {

    /** The ssrv dao. */
    @Inject
    SubservicioDAO ssrvDAO;

    /** The mani ssrv dao. */
    @Inject
    ManifiestoSubservicioDAO maniSsrvDAO;

    /** The equi dao. */
    @Inject
    EquipamientoDAO equiDAO;

    /** The bl dao. */
    @Inject
    BlDAO blDAO;

    /** The mani srvc dao. */
    @Inject
    ManifiestoServicioDAO maniSrvcDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void bloquear(final Long ssrvId) throws InstanceNotFoundException, EstadoInvalidoException {
        Preconditions.checkNotNull(ssrvId);

        final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

        ssrvCriterioVO.setId(ssrvId);
        ssrvCriterioVO.setEntiId(Entidad.PARTIDA.getId());

        final SubservicioVO ssrvVO = ssrvDAO.selectObject(ssrvCriterioVO);

        if (ssrvVO == null) {
            throw new InstanceNotFoundException(SubservicioVO.class.getName(), ssrvId);
        }

        // Bloqueo de la partida
        final int updatedRows = maniSsrvDAO.updateBloquear(ssrvCriterioVO);

        if (updatedRows == 0) {
            throw new EstadoInvalidoException(ServicioVO.class.getName(), ssrvId, ssrvVO.getEstado(),
                    ssrvVO.getEtiqueta());
        }

        // Bloqueo de los equipamientos asociados a la partida
        equiDAO.updateBloquearFromPartida(ssrvId);

        // Recalcular estado del BL
        final SubservicioCriterioVO blCriterioVO = new SubservicioCriterioVO();

        blCriterioVO.setEntiId(Entidad.BL.getId());
        blCriterioVO.setHijoId(ssrvId);

        final SubservicioVO blVO = ssrvDAO.selectObject(blCriterioVO);

        blDAO.updateRecalcularEstado(blVO.getId());

        // RecalcularEstado del manifiesto
        maniSrvcDAO.updateRecalcularEstado(ssrvVO.getSrvc().getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void iniciar(final Long ssrvId) throws InstanceNotFoundException, EstadoInvalidoException {
        Preconditions.checkNotNull(ssrvId);

        final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

        ssrvCriterioVO.setId(ssrvId);
        ssrvCriterioVO.setEntiId(Entidad.PARTIDA.getId());

        final SubservicioVO ssrvVO = ssrvDAO.selectObject(ssrvCriterioVO);

        if (ssrvVO == null) {
            throw new InstanceNotFoundException(SubservicioVO.class.getName(), ssrvId);
        }

        // Inicio de la partida
        final int updatedRows = maniSsrvDAO.updateIniciar(ssrvCriterioVO);

        if (updatedRows == 0) {
            throw new EstadoInvalidoException(ServicioVO.class.getName(), ssrvId, ssrvVO.getEstado(),
                    ssrvVO.getEtiqueta());
        }

        // Inicio de los equipamientos asociados a la partida
        equiDAO.updateIniciarFromPartida(ssrvId);

        // Recalcular estado del BL
        final SubservicioCriterioVO blCriterioVO = new SubservicioCriterioVO();

        blCriterioVO.setEntiId(Entidad.BL.getId());
        blCriterioVO.setHijoId(ssrvId);

        final SubservicioVO blVO = ssrvDAO.selectObject(blCriterioVO);

        blDAO.updateRecalcularEstado(blVO.getId());

        // RecalcularEstado del manifiesto
        maniSrvcDAO.updateRecalcularEstado(ssrvVO.getSrvc().getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void anular(final Long ssrvId) throws InstanceNotFoundException, EstadoInvalidoException {
        Preconditions.checkNotNull(ssrvId);

        final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

        ssrvCriterioVO.setId(ssrvId);
        ssrvCriterioVO.setEntiId(Entidad.PARTIDA.getId());

        final SubservicioVO ssrvVO = ssrvDAO.selectObject(ssrvCriterioVO);

        if (ssrvVO == null) {
            throw new InstanceNotFoundException(SubservicioVO.class.getName(), ssrvId);
        }

        // Anulacion de la partida
        final int updatedRows = maniSsrvDAO.updateAnular(ssrvCriterioVO);

        if (updatedRows == 0) {
            throw new EstadoInvalidoException(ServicioVO.class.getName(), ssrvId, ssrvVO.getEstado(),
                    ssrvVO.getEtiqueta());
        }

        // Borrado de las partida-equipamiento asociadas
        final SubservicioCriterioVO paeqCriterioVO = new SubservicioCriterioVO();

        paeqCriterioVO.setEntiId(Entidad.PARTIDA_EQUIPAMIENTO.getId());
        paeqCriterioVO.setPadreId(ssrvId);

        ssrvDAO.delete(paeqCriterioVO);

        // Recalcular estado del BL
        final SubservicioCriterioVO blCriterioVO = new SubservicioCriterioVO();

        blCriterioVO.setEntiId(Entidad.BL.getId());
        blCriterioVO.setHijoId(ssrvId);

        final SubservicioVO blVO = ssrvDAO.selectObject(blCriterioVO);

        blDAO.updateRecalcularEstado(blVO.getId());

        // RecalcularEstado del manifiesto
        maniSrvcDAO.updateRecalcularEstado(ssrvVO.getSrvc().getId());
    }

}
