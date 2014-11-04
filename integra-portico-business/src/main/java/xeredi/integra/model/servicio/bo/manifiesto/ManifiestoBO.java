package xeredi.integra.model.servicio.bo.manifiesto;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.exception.OperacionNoPermitidaException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.servicio.dao.ServicioDAO;
import xeredi.integra.model.servicio.dao.manifiesto.ManifiestoResumenDAO;
import xeredi.integra.model.servicio.dao.manifiesto.ManifiestoServicioDAO;
import xeredi.integra.model.servicio.dao.manifiesto.ManifiestoSubservicioDAO;
import xeredi.integra.model.servicio.vo.ServicioCriterioVO;
import xeredi.integra.model.servicio.vo.ServicioVO;
import xeredi.integra.model.servicio.vo.SubservicioCriterioVO;
import xeredi.integra.model.servicio.vo.manifiesto.ResumenTotalesCriterioVO;
import xeredi.integra.model.servicio.vo.manifiesto.ResumenTotalesVO;
import xeredi.integra.model.util.Entidad;
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
    public final void bloquear(final Long srvcId) throws InstanceNotFoundException, OperacionNoPermitidaException {
        Preconditions.checkNotNull(srvcId);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            srvcDAO = session.getMapper(ServicioDAO.class);
            maniDAO = session.getMapper(ManifiestoServicioDAO.class);
            maniSsrvDAO = session.getMapper(ManifiestoSubservicioDAO.class);

            final ServicioCriterioVO srvcCriterioVO = new ServicioCriterioVO();

            srvcCriterioVO.setId(srvcId);

            final ServicioVO srvcVO = srvcDAO.selectObject(srvcCriterioVO);

            if (srvcVO == null) {
                throw new InstanceNotFoundException(Entidad.MANIFIESTO.getId(), srvcId);
            }

            final int updatedRows = maniDAO.updateBloquear(srvcId);

            if (updatedRows == 0) {
                throw new OperacionNoPermitidaException(Entidad.MANIFIESTO.getId(), MessageI18nKey.mani_bloquear,
                        srvcId);
            }

            // Bloqueo de los Subservicios del Manifiesto (Bls, Partidas y Equipamientos)
            final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

            ssrvCriterioVO.setSrvc(srvcCriterioVO);
            maniSsrvDAO.updateBloquear(ssrvCriterioVO);

            session.commit();
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
    public final void completar(final Long srvcId) throws InstanceNotFoundException, OperacionNoPermitidaException {
        Preconditions.checkNotNull(srvcId);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            srvcDAO = session.getMapper(ServicioDAO.class);
            maniDAO = session.getMapper(ManifiestoServicioDAO.class);
            maniSsrvDAO = session.getMapper(ManifiestoSubservicioDAO.class);

            final ServicioCriterioVO srvcCriterioVO = new ServicioCriterioVO();

            srvcCriterioVO.setId(srvcId);

            final ServicioVO srvcVO = srvcDAO.selectObject(srvcCriterioVO);

            if (srvcVO == null) {
                throw new InstanceNotFoundException(Entidad.MANIFIESTO.getId(), srvcId);
            }

            final int updatedRows = maniDAO.updateCompletar(srvcId);

            if (updatedRows == 0) {
                throw new OperacionNoPermitidaException(Entidad.MANIFIESTO.getId(), MessageI18nKey.mani_completar,
                        srvcId);
            }

            // Completado de los Subservicios del Manifiesto (Bls, Partidas y Equipamientos)
            final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

            ssrvCriterioVO.setSrvc(srvcCriterioVO);
            maniSsrvDAO.updateCompletar(ssrvCriterioVO);

            session.commit();
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
    public final void iniciar(final Long srvcId) throws InstanceNotFoundException, OperacionNoPermitidaException {
        Preconditions.checkNotNull(srvcId);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            srvcDAO = session.getMapper(ServicioDAO.class);
            maniDAO = session.getMapper(ManifiestoServicioDAO.class);
            maniSsrvDAO = session.getMapper(ManifiestoSubservicioDAO.class);

            final ServicioCriterioVO srvcCriterioVO = new ServicioCriterioVO();

            srvcCriterioVO.setId(srvcId);

            final ServicioVO srvcVO = srvcDAO.selectObject(srvcCriterioVO);

            if (srvcVO == null) {
                throw new InstanceNotFoundException(Entidad.MANIFIESTO.getId(), srvcId);
            }

            final int updatedRows = maniDAO.updateIniciar(srvcId);

            if (updatedRows == 0) {
                throw new OperacionNoPermitidaException(Entidad.MANIFIESTO.getId(), MessageI18nKey.mani_iniciar, srvcId);
            }

            // Inicio de los Subservicios del Manifiesto (Bls, Partidas y Equipamientos)
            final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

            ssrvCriterioVO.setSrvc(srvcCriterioVO);
            maniSsrvDAO.updateIniciar(ssrvCriterioVO);

            session.commit();
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
    public final void anular(final Long srvcId) throws InstanceNotFoundException, OperacionNoPermitidaException {
        Preconditions.checkNotNull(srvcId);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            srvcDAO = session.getMapper(ServicioDAO.class);
            maniDAO = session.getMapper(ManifiestoServicioDAO.class);
            maniSsrvDAO = session.getMapper(ManifiestoSubservicioDAO.class);

            final ServicioCriterioVO srvcCriterioVO = new ServicioCriterioVO();

            srvcCriterioVO.setId(srvcId);

            final ServicioVO srvcVO = srvcDAO.selectObject(srvcCriterioVO);

            if (srvcVO == null) {
                throw new InstanceNotFoundException(Entidad.MANIFIESTO.getId(), srvcId);
            }

            final int updatedRows = maniDAO.updateAnular(srvcId);

            if (updatedRows == 0) {
                throw new OperacionNoPermitidaException(Entidad.MANIFIESTO.getId(), MessageI18nKey.mani_anular, srvcId);
            }

            // Anulacion de los Subservicios del Manifiesto (Bls, Partidas y Equipamientos)
            final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

            ssrvCriterioVO.setSrvc(srvcCriterioVO);
            maniSsrvDAO.updateAnular(ssrvCriterioVO);

            session.commit();
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

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            resumenDAO = session.getMapper(ManifiestoResumenDAO.class);

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
