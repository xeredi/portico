package xeredi.integra.model.servicio.bo.manifiesto;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.exception.OperacionNoPermitidaException;
import xeredi.integra.model.servicio.dao.SubservicioDAO;
import xeredi.integra.model.servicio.dao.manifiesto.BlDAO;
import xeredi.integra.model.servicio.dao.manifiesto.EquipamientoDAO;
import xeredi.integra.model.servicio.dao.manifiesto.ManifiestoServicioDAO;
import xeredi.integra.model.servicio.dao.manifiesto.ManifiestoSubservicioDAO;
import xeredi.integra.model.servicio.vo.SubservicioCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;
import xeredi.integra.model.util.Entidad;
import xeredi.util.mybatis.SqlMapperLocator;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class PartidaBO.
 */
public class PartidaBO {

    /** The ssrv dao. */
    SubservicioDAO ssrvDAO;

    /** The mani ssrv dao. */
    ManifiestoSubservicioDAO maniSsrvDAO;

    /** The equi dao. */
    EquipamientoDAO equiDAO;

    /** The bl dao. */
    BlDAO blDAO;

    /** The mani srvc dao. */
    ManifiestoServicioDAO maniSrvcDAO;

    /**
     * Bloquear.
     *
     * @param ssrvId
     *            the ssrv id
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws EstadoInvalidoException
     *             the estado invalido exception
     */
    public final void bloquear(final Long ssrvId) throws InstanceNotFoundException, OperacionNoPermitidaException {
        Preconditions.checkNotNull(ssrvId);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            ssrvDAO = session.getMapper(SubservicioDAO.class);
            maniSrvcDAO = session.getMapper(ManifiestoServicioDAO.class);
            maniSsrvDAO = session.getMapper(ManifiestoSubservicioDAO.class);
            equiDAO = session.getMapper(EquipamientoDAO.class);
            blDAO = session.getMapper(BlDAO.class);

            final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

            ssrvCriterioVO.setId(ssrvId);
            ssrvCriterioVO.setEntiId(Entidad.PARTIDA.getId());

            final SubservicioVO ssrvVO = ssrvDAO.selectObject(ssrvCriterioVO);

            if (ssrvVO == null) {
                throw new InstanceNotFoundException(Entidad.PARTIDA.getId(), ssrvId);
            }

            // Bloqueo de la partida
            final int updatedRows = maniSsrvDAO.updateBloquear(ssrvCriterioVO);

            if (updatedRows == 0) {
                throw new OperacionNoPermitidaException(Entidad.PARTIDA.getId(), ssrvId);
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
     * @throws EstadoInvalidoException
     *             the estado invalido exception
     */
    public final void iniciar(final Long ssrvId) throws InstanceNotFoundException, OperacionNoPermitidaException {
        Preconditions.checkNotNull(ssrvId);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            ssrvDAO = session.getMapper(SubservicioDAO.class);
            maniSrvcDAO = session.getMapper(ManifiestoServicioDAO.class);
            maniSsrvDAO = session.getMapper(ManifiestoSubservicioDAO.class);
            equiDAO = session.getMapper(EquipamientoDAO.class);
            blDAO = session.getMapper(BlDAO.class);

            final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

            ssrvCriterioVO.setId(ssrvId);
            ssrvCriterioVO.setEntiId(Entidad.PARTIDA.getId());

            final SubservicioVO ssrvVO = ssrvDAO.selectObject(ssrvCriterioVO);

            if (ssrvVO == null) {
                throw new InstanceNotFoundException(Entidad.PARTIDA.getId(), ssrvId);
            }

            // Inicio de la partida
            final int updatedRows = maniSsrvDAO.updateIniciar(ssrvCriterioVO);

            if (updatedRows == 0) {
                throw new OperacionNoPermitidaException(Entidad.PARTIDA.getId(), ssrvId);
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
     * @throws EstadoInvalidoException
     *             the estado invalido exception
     */
    public final void anular(final Long ssrvId) throws InstanceNotFoundException, OperacionNoPermitidaException {
        Preconditions.checkNotNull(ssrvId);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH)) {
            ssrvDAO = session.getMapper(SubservicioDAO.class);
            maniSrvcDAO = session.getMapper(ManifiestoServicioDAO.class);
            maniSsrvDAO = session.getMapper(ManifiestoSubservicioDAO.class);
            equiDAO = session.getMapper(EquipamientoDAO.class);
            blDAO = session.getMapper(BlDAO.class);

            final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

            ssrvCriterioVO.setId(ssrvId);
            ssrvCriterioVO.setEntiId(Entidad.PARTIDA.getId());

            final SubservicioVO ssrvVO = ssrvDAO.selectObject(ssrvCriterioVO);

            if (ssrvVO == null) {
                throw new InstanceNotFoundException(Entidad.PARTIDA.getId(), ssrvId);
            }

            // Anulacion de la partida
            final int updatedRows = maniSsrvDAO.updateAnular(ssrvCriterioVO);

            if (updatedRows == 0) {
                throw new OperacionNoPermitidaException(Entidad.PARTIDA.getId(), ssrvId);
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

            session.commit();
        }
    }

}
