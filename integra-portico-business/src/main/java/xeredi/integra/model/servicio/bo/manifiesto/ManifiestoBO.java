package xeredi.integra.model.servicio.bo.manifiesto;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.servicio.bo.EstadoInvalidoException;
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
import xeredi.util.mybatis.SqlMapperLocator;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ManifiestoBO.
 */
public class ManifiestoBO {

    /** The srvc dao. */
    ServicioDAO srvcDAO;

    /** The mani dao. */
    ManifiestoServicioDAO maniDAO;

    /** The mani ssrv dao. */
    ManifiestoSubservicioDAO maniSsrvDAO;

    /** The resumen dao. */
    ManifiestoResumenDAO resumenDAO;

    /**
     * Bloquear.
     *
     * @param srvcId
     *            the srvc id
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws EstadoInvalidoException
     *             the estado invalido exception
     */
    public final void bloquear(final Long srvcId) throws InstanceNotFoundException, EstadoInvalidoException {
        Preconditions.checkNotNull(srvcId);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE);

        srvcDAO = session.getMapper(ServicioDAO.class);
        maniDAO = session.getMapper(ManifiestoServicioDAO.class);
        maniSsrvDAO = session.getMapper(ManifiestoSubservicioDAO.class);

        try {
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

            session.commit();
        } finally {
            session.close();
        }
    }

    /**
     * Completar.
     *
     * @param srvcId
     *            the srvc id
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws EstadoInvalidoException
     *             the estado invalido exception
     */
    public final void completar(final Long srvcId) throws InstanceNotFoundException, EstadoInvalidoException {
        Preconditions.checkNotNull(srvcId);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE);

        srvcDAO = session.getMapper(ServicioDAO.class);
        maniDAO = session.getMapper(ManifiestoServicioDAO.class);
        maniSsrvDAO = session.getMapper(ManifiestoSubservicioDAO.class);

        try {
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

            session.commit();
        } finally {
            session.close();
        }
    }

    /**
     * Iniciar.
     *
     * @param srvcId
     *            the srvc id
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws EstadoInvalidoException
     *             the estado invalido exception
     */
    public final void iniciar(final Long srvcId) throws InstanceNotFoundException, EstadoInvalidoException {
        Preconditions.checkNotNull(srvcId);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE);

        srvcDAO = session.getMapper(ServicioDAO.class);
        maniDAO = session.getMapper(ManifiestoServicioDAO.class);
        maniSsrvDAO = session.getMapper(ManifiestoSubservicioDAO.class);

        try {
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

            session.commit();
        } finally {
            session.close();
        }
    }

    /**
     * Anular.
     *
     * @param srvcId
     *            the srvc id
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws EstadoInvalidoException
     *             the estado invalido exception
     */
    public final void anular(final Long srvcId) throws InstanceNotFoundException, EstadoInvalidoException {
        Preconditions.checkNotNull(srvcId);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE);

        srvcDAO = session.getMapper(ServicioDAO.class);
        maniDAO = session.getMapper(ManifiestoServicioDAO.class);
        maniSsrvDAO = session.getMapper(ManifiestoSubservicioDAO.class);

        try {
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

            session.commit();
        } finally {
            session.close();
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
        Preconditions.checkNotNull(maniId);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        resumenDAO = session.getMapper(ManifiestoResumenDAO.class);

        try {
            final ResumenTotalesCriterioVO totalCriterioVO = new ResumenTotalesCriterioVO();

            totalCriterioVO.setManiId(maniId);

            final ResumenTotalesVO totalVO = resumenDAO.selectObject(totalCriterioVO);

            if (totalVO == null) {
                throw new InstanceNotFoundException(ResumenTotalesVO.class.getName(), totalCriterioVO);
            }

            return totalVO;
        } finally {
            session.close();
        }
    }

}
