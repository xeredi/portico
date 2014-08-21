package xeredi.integra.model.bo.servicio.manifiesto;

import org.mybatis.guice.transactional.Transactional;

import xeredi.integra.model.bo.servicio.EstadoInvalidoException;
import xeredi.integra.model.servicio.dao.ServicioDAO;
import xeredi.integra.model.servicio.dao.manifiesto.ManifiestoResumenDAO;
import xeredi.integra.model.servicio.dao.manifiesto.ManifiestoServicioDAO;
import xeredi.integra.model.servicio.dao.manifiesto.ManifiestoSubservicioDAO;
import xeredi.integra.model.servicio.vo.ServicioCriterioVO;
import xeredi.integra.model.servicio.vo.ServicioVO;
import xeredi.integra.model.servicio.vo.SubservicioCriterioVO;
import xeredi.integra.model.servicio.vo.manifiesto.ResumenTotalesCriterioVO;
import xeredi.integra.model.servicio.vo.manifiesto.ResumenTotalesVO;
import xeredi.util.exception.InstanceNotFoundException;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;

// TODO: Auto-generated Javadoc
/**
 * The Class ManifiestoBO.
 */
@Singleton
public class ManifiestoBO implements Manifiesto {
    @Inject
    ServicioDAO srvcDAO;

    @Inject
    ManifiestoServicioDAO maniDAO;

    @Inject
    ManifiestoSubservicioDAO maniSsrvDAO;

    @Inject
    ManifiestoResumenDAO resumenDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void bloquear(final Long srvcId) throws InstanceNotFoundException, EstadoInvalidoException {
        Preconditions.checkNotNull(srvcId);

        final ServicioCriterioVO srvcCriterioVO = new ServicioCriterioVO();

        srvcCriterioVO.setId(srvcId);

        final ServicioVO srvcVO = srvcDAO.selectObject(srvcCriterioVO);

        if (srvcVO == null) {
            throw new InstanceNotFoundException(ServicioVO.class.getName(), srvcId);
        }

        final int updatedRows = maniDAO.updateBloquear(srvcId);

        if (updatedRows == 0) {
            throw new EstadoInvalidoException(ServicioVO.class.getName(), srvcId, srvcVO.getEstado(),
                    srvcVO.getEtiqueta());
        }

        // Bloqueo de los Subservicios del Manifiesto (Bls, Partidas y Equipamientos)
        final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

        ssrvCriterioVO.setSrvc(srvcCriterioVO);
        maniSsrvDAO.updateBloquear(ssrvCriterioVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void completar(final Long srvcId) throws InstanceNotFoundException, EstadoInvalidoException {
        Preconditions.checkNotNull(srvcId);

        final ServicioCriterioVO srvcCriterioVO = new ServicioCriterioVO();

        srvcCriterioVO.setId(srvcId);

        final ServicioVO srvcVO = srvcDAO.selectObject(srvcCriterioVO);

        if (srvcVO == null) {
            throw new InstanceNotFoundException(ServicioVO.class.getName(), srvcId);
        }

        final int updatedRows = maniDAO.updateCompletar(srvcId);

        if (updatedRows == 0) {
            throw new EstadoInvalidoException(ServicioVO.class.getName(), srvcId, srvcVO.getEstado(),
                    srvcVO.getEtiqueta());
        }

        // Completado de los Subservicios del Manifiesto (Bls, Partidas y Equipamientos)
        final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

        ssrvCriterioVO.setSrvc(srvcCriterioVO);
        maniSsrvDAO.updateCompletar(ssrvCriterioVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void iniciar(final Long srvcId) throws InstanceNotFoundException, EstadoInvalidoException {
        Preconditions.checkNotNull(srvcId);

        final ServicioCriterioVO srvcCriterioVO = new ServicioCriterioVO();

        srvcCriterioVO.setId(srvcId);

        final ServicioVO srvcVO = srvcDAO.selectObject(srvcCriterioVO);

        if (srvcVO == null) {
            throw new InstanceNotFoundException(ServicioVO.class.getName(), srvcId);
        }

        final int updatedRows = maniDAO.updateIniciar(srvcId);

        if (updatedRows == 0) {
            throw new EstadoInvalidoException(ServicioVO.class.getName(), srvcId, srvcVO.getEstado(),
                    srvcVO.getEtiqueta());
        }

        // Inicio de los Subservicios del Manifiesto (Bls, Partidas y Equipamientos)
        final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

        ssrvCriterioVO.setSrvc(srvcCriterioVO);
        maniSsrvDAO.updateIniciar(ssrvCriterioVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final void anular(final Long srvcId) throws InstanceNotFoundException, EstadoInvalidoException {
        Preconditions.checkNotNull(srvcId);

        final ServicioCriterioVO srvcCriterioVO = new ServicioCriterioVO();

        srvcCriterioVO.setId(srvcId);

        final ServicioVO srvcVO = srvcDAO.selectObject(srvcCriterioVO);

        if (srvcVO == null) {
            throw new InstanceNotFoundException(ServicioVO.class.getName(), srvcId);
        }

        final int updatedRows = maniDAO.updateAnular(srvcId);

        if (updatedRows == 0) {
            throw new EstadoInvalidoException(ServicioVO.class.getName(), srvcId, srvcVO.getEstado(),
                    srvcVO.getEtiqueta());
        }

        // Anulacion de los Subservicios del Manifiesto (Bls, Partidas y Equipamientos)
        final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

        ssrvCriterioVO.setSrvc(srvcCriterioVO);
        maniSsrvDAO.updateAnular(ssrvCriterioVO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public final ResumenTotalesVO selectResumen(final Long maniId) throws InstanceNotFoundException {
        Preconditions.checkNotNull(maniId);

        final ResumenTotalesCriterioVO totalCriterioVO = new ResumenTotalesCriterioVO();

        totalCriterioVO.setManiId(maniId);

        final ResumenTotalesVO totalVO = resumenDAO.selectObject(totalCriterioVO);

        if (totalVO == null) {
            throw new InstanceNotFoundException(ResumenTotalesVO.class.getName(), totalCriterioVO);
        }

        return totalVO;
    }

}
