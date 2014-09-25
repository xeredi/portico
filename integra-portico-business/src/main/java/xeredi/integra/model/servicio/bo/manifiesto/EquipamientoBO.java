package xeredi.integra.model.servicio.bo.manifiesto;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.servicio.bo.EstadoInvalidoException;
import xeredi.integra.model.servicio.dao.SubservicioDAO;
import xeredi.integra.model.servicio.dao.manifiesto.BlDAO;
import xeredi.integra.model.servicio.dao.manifiesto.ManifiestoServicioDAO;
import xeredi.integra.model.servicio.dao.manifiesto.ManifiestoSubservicioDAO;
import xeredi.integra.model.servicio.dao.manifiesto.PartidaDAO;
import xeredi.integra.model.servicio.vo.ServicioVO;
import xeredi.integra.model.servicio.vo.SubservicioCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;
import xeredi.integra.model.util.Entidad;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.mybatis.SqlMapperLocator;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EquipamientoBO.
 */
public class EquipamientoBO {

    /** The ssrv dao. */
    SubservicioDAO ssrvDAO;

    /** The mani ssrv dao. */
    ManifiestoSubservicioDAO maniSsrvDAO;

    /** The part dao. */
    PartidaDAO partDAO;

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
    public final void bloquear(final Long ssrvId) throws InstanceNotFoundException, EstadoInvalidoException {
        Preconditions.checkNotNull(ssrvId);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        ssrvDAO = session.getMapper(SubservicioDAO.class);
        maniSrvcDAO = session.getMapper(ManifiestoServicioDAO.class);
        maniSsrvDAO = session.getMapper(ManifiestoSubservicioDAO.class);
        partDAO = session.getMapper(PartidaDAO.class);
        blDAO = session.getMapper(BlDAO.class);

        try {
            final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

            ssrvCriterioVO.setId(ssrvId);
            ssrvCriterioVO.setEntiId(Entidad.EQUIPAMIENTO.getId());

            final SubservicioVO ssrvVO = ssrvDAO.selectObject(ssrvCriterioVO);

            if (ssrvVO == null) {
                throw new InstanceNotFoundException(SubservicioVO.class.getName(), ssrvId);
            }

            // Bloqueo del equipamiento
            final int updatedRows = maniSsrvDAO.updateBloquear(ssrvCriterioVO);

            if (updatedRows == 0) {
                throw new EstadoInvalidoException(ServicioVO.class.getName(), ssrvId, ssrvVO.getEstado(),
                        ssrvVO.getEtiqueta());
            }

            // Bloqueo de las partidas asociadas al equipamiento
            partDAO.updateBloquearFromEquipamiento(ssrvId);

            // Recalcular estado del BL
            final SubservicioCriterioVO blCriterioVO = new SubservicioCriterioVO();

            blCriterioVO.setEntiId(Entidad.BL.getId());
            blCriterioVO.setHijoId(ssrvId);

            final SubservicioVO blVO = ssrvDAO.selectObject(blCriterioVO);

            blDAO.updateRecalcularEstado(blVO.getId());

            // RecalcularEstado del manifiesto
            maniSrvcDAO.updateRecalcularEstado(ssrvVO.getSrvc().getId());

            session.commit();
        } finally {
            session.close();
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
    public final void iniciar(final Long ssrvId) throws InstanceNotFoundException, EstadoInvalidoException {
        Preconditions.checkNotNull(ssrvId);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        ssrvDAO = session.getMapper(SubservicioDAO.class);
        maniSrvcDAO = session.getMapper(ManifiestoServicioDAO.class);
        maniSsrvDAO = session.getMapper(ManifiestoSubservicioDAO.class);
        partDAO = session.getMapper(PartidaDAO.class);
        blDAO = session.getMapper(BlDAO.class);

        try {
            final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

            ssrvCriterioVO.setId(ssrvId);
            ssrvCriterioVO.setEntiId(Entidad.EQUIPAMIENTO.getId());

            final SubservicioVO ssrvVO = ssrvDAO.selectObject(ssrvCriterioVO);

            if (ssrvVO == null) {
                throw new InstanceNotFoundException(SubservicioVO.class.getName(), ssrvId);
            }

            // Inicio del equipamiento
            final int updatedRows = maniSsrvDAO.updateIniciar(ssrvCriterioVO);

            if (updatedRows == 0) {
                throw new EstadoInvalidoException(ServicioVO.class.getName(), ssrvId, ssrvVO.getEstado(),
                        ssrvVO.getEtiqueta());
            }

            // Inicio de las partidas asociadas al equipamiento
            partDAO.updateIniciarFromEquipamiento(ssrvId);

            // Recalcular estado del BL
            final SubservicioCriterioVO blCriterioVO = new SubservicioCriterioVO();

            blCriterioVO.setEntiId(Entidad.BL.getId());
            blCriterioVO.setHijoId(ssrvId);

            final SubservicioVO blVO = ssrvDAO.selectObject(blCriterioVO);

            blDAO.updateRecalcularEstado(blVO.getId());

            // RecalcularEstado del manifiesto
            maniSrvcDAO.updateRecalcularEstado(ssrvVO.getSrvc().getId());

            session.commit();
        } finally {
            session.close();
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
    public final void anular(final Long ssrvId) throws InstanceNotFoundException, EstadoInvalidoException {
        Preconditions.checkNotNull(ssrvId);

        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        ssrvDAO = session.getMapper(SubservicioDAO.class);
        maniSrvcDAO = session.getMapper(ManifiestoServicioDAO.class);
        maniSsrvDAO = session.getMapper(ManifiestoSubservicioDAO.class);
        partDAO = session.getMapper(PartidaDAO.class);
        blDAO = session.getMapper(BlDAO.class);

        try {
            final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

            ssrvCriterioVO.setId(ssrvId);
            ssrvCriterioVO.setEntiId(Entidad.EQUIPAMIENTO.getId());

            final SubservicioVO ssrvVO = ssrvDAO.selectObject(ssrvCriterioVO);

            if (ssrvVO == null) {
                throw new InstanceNotFoundException(SubservicioVO.class.getName(), ssrvId);
            }

            // Anulacion del equipamiento
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

            session.commit();
        } finally {
            session.close();
        }
    }

}
