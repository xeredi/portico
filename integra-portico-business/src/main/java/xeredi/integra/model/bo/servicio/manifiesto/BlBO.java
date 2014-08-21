package xeredi.integra.model.bo.servicio.manifiesto;

import org.mybatis.guice.transactional.Transactional;

import xeredi.integra.model.bo.servicio.EstadoInvalidoException;
import xeredi.integra.model.servicio.dao.SubservicioDAO;
import xeredi.integra.model.servicio.dao.manifiesto.ManifiestoResumenDAO;
import xeredi.integra.model.servicio.dao.manifiesto.ManifiestoServicioDAO;
import xeredi.integra.model.servicio.dao.manifiesto.ManifiestoSubservicioDAO;
import xeredi.integra.model.servicio.vo.ServicioCriterioVO;
import xeredi.integra.model.servicio.vo.ServicioVO;
import xeredi.integra.model.servicio.vo.SubservicioCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;
import xeredi.integra.model.servicio.vo.manifiesto.ResumenTotalesCriterioVO;
import xeredi.integra.model.servicio.vo.manifiesto.ResumenTotalesVO;
import xeredi.integra.model.util.Entidad;
import xeredi.util.exception.InstanceNotFoundException;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;

// TODO: Auto-generated Javadoc
/**
 * The Class BlBO.
 */
@Singleton
public class BlBO implements Bl {

    /** The ssrv dao. */
    @Inject
    SubservicioDAO ssrvDAO;

    /** The mani ssrv dao. */
    @Inject
    ManifiestoSubservicioDAO maniSsrvDAO;

    /** The mani srvc dao. */
    @Inject
    ManifiestoServicioDAO maniSrvcDAO;

    /** The resumen dao. */
    @Inject
    ManifiestoResumenDAO resumenDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void completar(final Long ssrvId) throws InstanceNotFoundException, EstadoInvalidoException {
        Preconditions.checkNotNull(ssrvId);

        final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

        ssrvCriterioVO.setId(ssrvId);
        ssrvCriterioVO.setEntiId(Entidad.BL.getId());

        final SubservicioVO ssrvVO = ssrvDAO.selectObject(ssrvCriterioVO);

        if (ssrvVO == null) {
            throw new InstanceNotFoundException(SubservicioVO.class.getName(), ssrvId);
        }

        // Completar el Bl
        final int updatedRows = maniSsrvDAO.updateCompletar(ssrvCriterioVO);

        if (updatedRows == 0) {
            throw new EstadoInvalidoException(ServicioVO.class.getName(), ssrvId, ssrvVO.getEstado(),
                    ssrvVO.getEtiqueta());
        }

        // Recalcular Estado del manifiesto
        maniSrvcDAO.updateRecalcularEstado(ssrvVO.getSrvc().getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void bloquear(final Long ssrvId) throws InstanceNotFoundException, EstadoInvalidoException {
        Preconditions.checkNotNull(ssrvId);

        final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

        ssrvCriterioVO.setId(ssrvId);
        ssrvCriterioVO.setEntiId(Entidad.BL.getId());

        final SubservicioVO ssrvVO = ssrvDAO.selectObject(ssrvCriterioVO);

        if (ssrvVO == null) {
            throw new InstanceNotFoundException(SubservicioVO.class.getName(), ssrvId);
        }

        final ServicioCriterioVO srvcCriterioVO = new ServicioCriterioVO();

        srvcCriterioVO.setId(ssrvVO.getSrvc().getId());

        // Bloqueo del Bl
        final int updatedRows = maniSsrvDAO.updateBloquear(ssrvCriterioVO);

        if (updatedRows == 0) {
            throw new EstadoInvalidoException(ServicioVO.class.getName(), ssrvId, ssrvVO.getEstado(),
                    ssrvVO.getEtiqueta());
        }

        // Bloqueo de los equipamientos y partidas del BL
        final SubservicioCriterioVO equiCriterioVO = new SubservicioCriterioVO();

        equiCriterioVO.setEntiId(Entidad.EQUIPAMIENTO.getId());
        equiCriterioVO.setPadreId(ssrvId);
        equiCriterioVO.setSrvc(srvcCriterioVO);

        maniSsrvDAO.updateBloquear(equiCriterioVO);

        final SubservicioCriterioVO partCriterioVO = new SubservicioCriterioVO();

        partCriterioVO.setEntiId(Entidad.PARTIDA.getId());
        partCriterioVO.setPadreId(ssrvId);
        partCriterioVO.setSrvc(srvcCriterioVO);

        maniSsrvDAO.updateBloquear(partCriterioVO);

        // Recalcular Estado del manifiesto
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
        ssrvCriterioVO.setEntiId(Entidad.BL.getId());

        final SubservicioVO ssrvVO = ssrvDAO.selectObject(ssrvCriterioVO);

        if (ssrvVO == null) {
            throw new InstanceNotFoundException(SubservicioVO.class.getName(), ssrvId);
        }

        final ServicioCriterioVO srvcCriterioVO = new ServicioCriterioVO();

        srvcCriterioVO.setId(ssrvVO.getSrvc().getId());
        ssrvCriterioVO.setSrvc(srvcCriterioVO);

        // Inicio del Bl
        final int updatedRows = maniSsrvDAO.updateIniciar(ssrvCriterioVO);

        if (updatedRows == 0) {
            throw new EstadoInvalidoException(ServicioVO.class.getName(), ssrvId, ssrvVO.getEstado(),
                    ssrvVO.getEtiqueta());
        }

        // Inicio de los equipamientos y partidas del BL
        final SubservicioCriterioVO equiCriterioVO = new SubservicioCriterioVO();

        equiCriterioVO.setEntiId(Entidad.EQUIPAMIENTO.getId());
        equiCriterioVO.setPadreId(ssrvId);
        equiCriterioVO.setSrvc(srvcCriterioVO);

        maniSsrvDAO.updateIniciar(equiCriterioVO);

        final SubservicioCriterioVO partCriterioVO = new SubservicioCriterioVO();

        partCriterioVO.setEntiId(Entidad.PARTIDA.getId());
        partCriterioVO.setPadreId(ssrvId);
        partCriterioVO.setSrvc(srvcCriterioVO);

        maniSsrvDAO.updateIniciar(partCriterioVO);

        // Recalcular Estado del manifiesto
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
        ssrvCriterioVO.setEntiId(Entidad.BL.getId());

        final SubservicioVO ssrvVO = ssrvDAO.selectObject(ssrvCriterioVO);

        if (ssrvVO == null) {
            throw new InstanceNotFoundException(SubservicioVO.class.getName(), ssrvId);
        }

        final ServicioCriterioVO srvcCriterioVO = new ServicioCriterioVO();

        srvcCriterioVO.setId(ssrvVO.getSrvc().getId());

        // Anular del Bl
        final int updatedRows = maniSsrvDAO.updateAnular(ssrvCriterioVO);

        if (updatedRows == 0) {
            throw new EstadoInvalidoException(ServicioVO.class.getName(), ssrvId, ssrvVO.getEstado(),
                    ssrvVO.getEtiqueta());
        }

        // Anular de los equipamientos y partidas del BL
        final SubservicioCriterioVO equiCriterioVO = new SubservicioCriterioVO();

        equiCriterioVO.setEntiId(Entidad.EQUIPAMIENTO.getId());
        equiCriterioVO.setPadreId(ssrvId);
        equiCriterioVO.setSrvc(srvcCriterioVO);

        maniSsrvDAO.updateAnular(equiCriterioVO);

        final SubservicioCriterioVO partCriterioVO = new SubservicioCriterioVO();

        partCriterioVO.setEntiId(Entidad.PARTIDA.getId());
        partCriterioVO.setPadreId(ssrvId);
        partCriterioVO.setSrvc(srvcCriterioVO);

        maniSsrvDAO.updateAnular(partCriterioVO);

        // Recalcular Estado del manifiesto
        maniSrvcDAO.updateRecalcularEstado(ssrvVO.getSrvc().getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final ResumenTotalesVO selectResumen(final Long maniId, final Long blId) throws InstanceNotFoundException {
        Preconditions.checkNotNull(maniId);
        Preconditions.checkNotNull(blId);

        final ResumenTotalesCriterioVO totalCriterioVO = new ResumenTotalesCriterioVO();

        totalCriterioVO.setManiId(maniId);
        totalCriterioVO.setBlId(blId);

        final ResumenTotalesVO totalVO = resumenDAO.selectObject(totalCriterioVO);

        if (totalVO == null) {
            throw new InstanceNotFoundException(ResumenTotalesVO.class.getName(), totalCriterioVO);
        }

        return totalVO;
    }
}
