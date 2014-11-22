package xeredi.integra.model.servicio.bo.manifiesto;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.exception.OperacionNoPermitidaException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.servicio.dao.SubservicioDAO;
import xeredi.integra.model.servicio.dao.manifiesto.ManifiestoResumenDAO;
import xeredi.integra.model.servicio.dao.manifiesto.ManifiestoServicioDAO;
import xeredi.integra.model.servicio.dao.manifiesto.ManifiestoSubservicioDAO;
import xeredi.integra.model.servicio.vo.ServicioCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;
import xeredi.integra.model.servicio.vo.manifiesto.ResumenTotalesCriterioVO;
import xeredi.integra.model.servicio.vo.manifiesto.ResumenTotalesVO;
import xeredi.util.mybatis.SqlMapperLocator;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class BlBO.
 */
public class BlBO {

    /**
     * Completar.
     *
     * @param ssrvId
     *            the ssrv id
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OperacionNoPermitidaException
     *             the operacion no permitida exception
     */
    public final void completar(final Long ssrvId) throws InstanceNotFoundException, OperacionNoPermitidaException {
        Preconditions.checkNotNull(ssrvId);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
            final ManifiestoSubservicioDAO maniSsrvDAO = session.getMapper(ManifiestoSubservicioDAO.class);
            final ManifiestoServicioDAO maniSrvcDAO = session.getMapper(ManifiestoServicioDAO.class);

            final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

            ssrvCriterioVO.setId(ssrvId);
            ssrvCriterioVO.setEntiId(Entidad.BL.getId());

            final SubservicioVO ssrvVO = ssrvDAO.selectObject(ssrvCriterioVO);

            if (ssrvVO == null) {
                throw new InstanceNotFoundException(Entidad.BL.getId(), ssrvId);
            }

            // Completar el Bl
            final int updatedRows = maniSsrvDAO.updateCompletar(ssrvCriterioVO);

            if (updatedRows == 0) {
                throw new OperacionNoPermitidaException(Entidad.BL.getId(), MessageI18nKey.mabl_completar,
                        ssrvVO.getId());
            }

            // Recalcular Estado del manifiesto
            maniSrvcDAO.updateRecalcularEstado(ssrvVO.getSrvc().getId());

            session.commit();
        }
    }

    /**
     * Bloquear.
     *
     * @param ssrvId
     *            the ssrv id
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OperacionNoPermitidaException
     *             the operacion no permitida exception
     */
    public final void bloquear(final Long ssrvId) throws InstanceNotFoundException, OperacionNoPermitidaException {
        Preconditions.checkNotNull(ssrvId);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
            final ManifiestoSubservicioDAO maniSsrvDAO = session.getMapper(ManifiestoSubservicioDAO.class);
            final ManifiestoServicioDAO maniSrvcDAO = session.getMapper(ManifiestoServicioDAO.class);

            final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

            ssrvCriterioVO.setId(ssrvId);
            ssrvCriterioVO.setEntiId(Entidad.BL.getId());

            final SubservicioVO ssrvVO = ssrvDAO.selectObject(ssrvCriterioVO);

            if (ssrvVO == null) {
                throw new InstanceNotFoundException(Entidad.BL.getId(), ssrvId);
            }

            final ServicioCriterioVO srvcCriterioVO = new ServicioCriterioVO();

            srvcCriterioVO.setId(ssrvVO.getSrvc().getId());

            // Bloqueo del Bl
            final int updatedRows = maniSsrvDAO.updateBloquear(ssrvCriterioVO);

            if (updatedRows == 0) {
                throw new OperacionNoPermitidaException(Entidad.BL.getId(), MessageI18nKey.mabl_bloquear, ssrvId);
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

            session.commit();
        }
    }

    /**
     * Iniciar.
     *
     * @param ssrvId
     *            the ssrv id
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OperacionNoPermitidaException
     *             the operacion no permitida exception
     */
    public final void iniciar(final Long ssrvId) throws InstanceNotFoundException, OperacionNoPermitidaException {
        Preconditions.checkNotNull(ssrvId);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
            final ManifiestoSubservicioDAO maniSsrvDAO = session.getMapper(ManifiestoSubservicioDAO.class);
            final ManifiestoServicioDAO maniSrvcDAO = session.getMapper(ManifiestoServicioDAO.class);

            final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

            ssrvCriterioVO.setId(ssrvId);
            ssrvCriterioVO.setEntiId(Entidad.BL.getId());

            final SubservicioVO ssrvVO = ssrvDAO.selectObject(ssrvCriterioVO);

            if (ssrvVO == null) {
                throw new InstanceNotFoundException(Entidad.BL.getId(), ssrvId);
            }

            final ServicioCriterioVO srvcCriterioVO = new ServicioCriterioVO();

            srvcCriterioVO.setId(ssrvVO.getSrvc().getId());
            ssrvCriterioVO.setSrvc(srvcCriterioVO);

            // Inicio del Bl
            final int updatedRows = maniSsrvDAO.updateIniciar(ssrvCriterioVO);

            if (updatedRows == 0) {
                throw new OperacionNoPermitidaException(Entidad.BL.getId(), MessageI18nKey.mabl_iniciar, ssrvId);
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

            session.commit();
        }
    }

    /**
     * Anular.
     *
     * @param ssrvId
     *            the ssrv id
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OperacionNoPermitidaException
     *             the operacion no permitida exception
     */
    public final void anular(final Long ssrvId) throws InstanceNotFoundException, OperacionNoPermitidaException {
        Preconditions.checkNotNull(ssrvId);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
            final ManifiestoSubservicioDAO maniSsrvDAO = session.getMapper(ManifiestoSubservicioDAO.class);
            final ManifiestoServicioDAO maniSrvcDAO = session.getMapper(ManifiestoServicioDAO.class);

            final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

            ssrvCriterioVO.setId(ssrvId);
            ssrvCriterioVO.setEntiId(Entidad.BL.getId());

            final SubservicioVO ssrvVO = ssrvDAO.selectObject(ssrvCriterioVO);

            if (ssrvVO == null) {
                throw new InstanceNotFoundException(Entidad.BL.getId(), ssrvId);
            }

            final ServicioCriterioVO srvcCriterioVO = new ServicioCriterioVO();

            srvcCriterioVO.setId(ssrvVO.getSrvc().getId());

            // Anular del Bl
            final int updatedRows = maniSsrvDAO.updateAnular(ssrvCriterioVO);

            if (updatedRows == 0) {
                throw new OperacionNoPermitidaException(Entidad.BL.getId(), MessageI18nKey.mabl_anular, ssrvId);
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

            session.commit();
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
    public final ResumenTotalesVO selectResumen(final Long maniId, final Long blId) throws InstanceNotFoundException {
        Preconditions.checkNotNull(maniId);
        Preconditions.checkNotNull(blId);

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
