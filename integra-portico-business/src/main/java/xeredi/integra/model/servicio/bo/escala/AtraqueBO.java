package xeredi.integra.model.servicio.bo.escala;

import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.servicio.bo.EstadoInvalidoException;
import xeredi.integra.model.servicio.dao.SubservicioDAO;
import xeredi.integra.model.servicio.dao.SubservicioDatoDAO;
import xeredi.integra.model.servicio.dao.escala.AtraqueDAO;
import xeredi.integra.model.servicio.dao.escala.EscalaDAO;
import xeredi.integra.model.servicio.vo.SubservicioCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;
import xeredi.integra.model.util.Entidad;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.mybatis.SqlMapperLocator;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class AtraqueBO.
 */
public final class AtraqueBO {

    /**
     * Checks if is autorizable.
     *
     * @param ssrvId
     *            the ssrv id
     * @return true, if is autorizable
     */
    public boolean isAutorizable(final Long ssrvId) {
        Preconditions.checkNotNull(ssrvId);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession();) {
            final AtraqueDAO atraDAO = session.getMapper(AtraqueDAO.class);

            return atraDAO.isAutorizable(ssrvId);
        }
    }

    /**
     * Autorizar.
     *
     * @param ssrvId
     *            the ssrv id
     * @param itdtMap
     *            the itdt map
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws EstadoInvalidoException
     *             the estado invalido exception
     */
    public void autorizar(final Long ssrvId, final Map<Long, ItemDatoVO> itdtMap) throws InstanceNotFoundException,
            EstadoInvalidoException {
        Preconditions.checkNotNull(ssrvId);
        Preconditions.checkNotNull(itdtMap);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);) {
            final AtraqueDAO atraDAO = session.getMapper(AtraqueDAO.class);
            final EscalaDAO escaDAO = session.getMapper(EscalaDAO.class);
            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
            final SubservicioDatoDAO ssdtDAO = session.getMapper(SubservicioDatoDAO.class);

            final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

            ssrvCriterioVO.setId(ssrvId);
            ssrvCriterioVO.setEntiId(Entidad.ATRAQUE.getId());

            final SubservicioVO ssrvVO = ssrvDAO.selectObject(ssrvCriterioVO);

            if (ssrvVO == null) {
                throw new InstanceNotFoundException(SubservicioVO.class.getName(), ssrvId);
            }

            if (atraDAO.updateAutorizar(ssrvVO.getId()) == 0) {
                throw new EstadoInvalidoException(SubservicioVO.class.getName(), ssrvVO.getId(), ssrvVO.getEstado(),
                        ssrvVO.getEtiqueta());
            }

            for (final Long tpdtId : itdtMap.keySet()) {
                final ItemDatoVO itdtVO = ssrvVO.getItdtMap().get(tpdtId);

                itdtVO.setItemId(ssrvVO.getId());
                itdtVO.setTpdtId(tpdtId);

                ssdtDAO.update(itdtVO);
            }

            escaDAO.updateEstado(ssrvVO.getSrvc().getId());
            escaDAO.updateFechaInicioFin(ssrvVO.getSrvc().getId());

            session.commit();
        }
    }

    /**
     * Checks if is denegable.
     *
     * @param ssrvId
     *            the ssrv id
     * @return true, if is denegable
     */
    public boolean isDenegable(final Long ssrvId) {
        Preconditions.checkNotNull(ssrvId);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession();) {
            final AtraqueDAO atraDAO = session.getMapper(AtraqueDAO.class);

            return atraDAO.isDenegable(ssrvId);
        }
    }

    /**
     * Denegar.
     *
     * @param ssrvId
     *            the ssrv id
     * @param itdtMap
     *            the itdt map
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws EstadoInvalidoException
     *             the estado invalido exception
     */
    public void denegar(final Long ssrvId, final Map<Long, ItemDatoVO> itdtMap) throws InstanceNotFoundException,
            EstadoInvalidoException {
        Preconditions.checkNotNull(ssrvId);
        Preconditions.checkNotNull(itdtMap);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);) {
            final AtraqueDAO atraDAO = session.getMapper(AtraqueDAO.class);
            final EscalaDAO escaDAO = session.getMapper(EscalaDAO.class);
            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
            final SubservicioDatoDAO ssdtDAO = session.getMapper(SubservicioDatoDAO.class);

            final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

            ssrvCriterioVO.setId(ssrvId);
            ssrvCriterioVO.setEntiId(Entidad.ATRAQUE.getId());

            final SubservicioVO ssrvVO = ssrvDAO.selectObject(ssrvCriterioVO);

            if (ssrvVO == null) {
                throw new InstanceNotFoundException(SubservicioVO.class.getName(), ssrvId);
            }

            if (atraDAO.updateDenegar(ssrvVO.getId()) == 0) {
                throw new EstadoInvalidoException(SubservicioVO.class.getName(), ssrvVO.getId(), ssrvVO.getEstado(),
                        ssrvVO.getEtiqueta());
            }

            for (final Long tpdtId : itdtMap.keySet()) {
                final ItemDatoVO itdtVO = ssrvVO.getItdtMap().get(tpdtId);

                itdtVO.setItemId(ssrvVO.getId());
                itdtVO.setTpdtId(tpdtId);

                ssdtDAO.update(itdtVO);
            }

            escaDAO.updateEstado(ssrvVO.getSrvc().getId());
            escaDAO.updateFechaInicioFin(ssrvVO.getSrvc().getId());

            session.commit();
        }
    }

    /**
     * Checks if is anulable.
     *
     * @param ssrvId
     *            the ssrv id
     * @return true, if is anulable
     */
    public boolean isAnulable(final Long ssrvId) {
        Preconditions.checkNotNull(ssrvId);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession();) {
            final AtraqueDAO atraDAO = session.getMapper(AtraqueDAO.class);

            return atraDAO.isAnulable(ssrvId);
        }
    }

    /**
     * Anular.
     *
     * @param ssrvId
     *            the ssrv id
     * @param itdtMap
     *            the itdt map
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws EstadoInvalidoException
     *             the estado invalido exception
     */
    public void anular(final Long ssrvId, final Map<Long, ItemDatoVO> itdtMap) throws InstanceNotFoundException,
            EstadoInvalidoException {
        Preconditions.checkNotNull(ssrvId);
        Preconditions.checkNotNull(itdtMap);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);) {
            final AtraqueDAO atraDAO = session.getMapper(AtraqueDAO.class);
            final EscalaDAO escaDAO = session.getMapper(EscalaDAO.class);
            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
            final SubservicioDatoDAO ssdtDAO = session.getMapper(SubservicioDatoDAO.class);

            final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

            ssrvCriterioVO.setId(ssrvId);
            ssrvCriterioVO.setEntiId(Entidad.ATRAQUE.getId());

            final SubservicioVO ssrvVO = ssrvDAO.selectObject(ssrvCriterioVO);

            if (ssrvVO == null) {
                throw new InstanceNotFoundException(SubservicioVO.class.getName(), ssrvId);
            }

            if (atraDAO.updateAnular(ssrvVO.getId()) == 0) {
                throw new EstadoInvalidoException(SubservicioVO.class.getName(), ssrvVO.getId(), ssrvVO.getEstado(),
                        ssrvVO.getEtiqueta());
            }

            for (final Long tpdtId : itdtMap.keySet()) {
                final ItemDatoVO itdtVO = ssrvVO.getItdtMap().get(tpdtId);

                itdtVO.setItemId(ssrvVO.getId());
                itdtVO.setTpdtId(tpdtId);

                ssdtDAO.update(itdtVO);
            }

            escaDAO.updateEstado(ssrvVO.getSrvc().getId());
            escaDAO.updateFechaInicioFin(ssrvVO.getSrvc().getId());

            session.commit();
        }
    }

    /**
     * Checks if is iniciable.
     *
     * @param ssrvId
     *            the ssrv id
     * @return true, if is iniciable
     */
    public boolean isIniciable(final Long ssrvId) {
        Preconditions.checkNotNull(ssrvId);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession();) {
            final AtraqueDAO atraDAO = session.getMapper(AtraqueDAO.class);

            return atraDAO.isIniciable(ssrvId);
        }
    }

    /**
     * Iniciar.
     *
     * @param ssrvId
     *            the ssrv id
     * @param itdtMap
     *            the itdt map
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws EstadoInvalidoException
     *             the estado invalido exception
     */
    public void iniciar(final Long ssrvId, final Map<Long, ItemDatoVO> itdtMap) throws InstanceNotFoundException,
            EstadoInvalidoException {
        Preconditions.checkNotNull(ssrvId);
        Preconditions.checkNotNull(itdtMap);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);) {
            final AtraqueDAO atraDAO = session.getMapper(AtraqueDAO.class);
            final EscalaDAO escaDAO = session.getMapper(EscalaDAO.class);
            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
            final SubservicioDatoDAO ssdtDAO = session.getMapper(SubservicioDatoDAO.class);

            final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

            ssrvCriterioVO.setId(ssrvId);
            ssrvCriterioVO.setEntiId(Entidad.ATRAQUE.getId());

            final SubservicioVO ssrvVO = ssrvDAO.selectObject(ssrvCriterioVO);

            if (ssrvVO == null) {
                throw new InstanceNotFoundException(SubservicioVO.class.getName(), ssrvId);
            }

            if (atraDAO.updateIniciar(ssrvVO.getId()) == 0) {
                throw new EstadoInvalidoException(SubservicioVO.class.getName(), ssrvVO.getId(), ssrvVO.getEstado(),
                        ssrvVO.getEtiqueta());
            }

            for (final Long tpdtId : itdtMap.keySet()) {
                final ItemDatoVO itdtVO = ssrvVO.getItdtMap().get(tpdtId);

                itdtVO.setItemId(ssrvVO.getId());
                itdtVO.setTpdtId(tpdtId);

                ssdtDAO.update(itdtVO);
            }

            escaDAO.updateEstado(ssrvVO.getSrvc().getId());
            escaDAO.updateFechaInicioFin(ssrvVO.getSrvc().getId());

            // FIXME Falta actualizar contadores escala, etc

            session.commit();
        }
    }

    /**
     * Checks if is finalizable.
     *
     * @param ssrvId
     *            the ssrv id
     * @return true, if is finalizable
     */
    public boolean isFinalizable(final Long ssrvId) {
        Preconditions.checkNotNull(ssrvId);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession();) {
            final AtraqueDAO atraDAO = session.getMapper(AtraqueDAO.class);

            return atraDAO.isFinalizable(ssrvId);
        }
    }

    /**
     * Finalizar.
     *
     * @param ssrvId
     *            the ssrv id
     * @param itdtMap
     *            the itdt map
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws EstadoInvalidoException
     *             the estado invalido exception
     */
    public void finalizar(final Long ssrvId, final Map<Long, ItemDatoVO> itdtMap) throws InstanceNotFoundException,
            EstadoInvalidoException {
        Preconditions.checkNotNull(ssrvId);
        Preconditions.checkNotNull(itdtMap);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);) {
            final AtraqueDAO atraDAO = session.getMapper(AtraqueDAO.class);
            final EscalaDAO escaDAO = session.getMapper(EscalaDAO.class);
            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
            final SubservicioDatoDAO ssdtDAO = session.getMapper(SubservicioDatoDAO.class);

            final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

            ssrvCriterioVO.setId(ssrvId);
            ssrvCriterioVO.setEntiId(Entidad.ATRAQUE.getId());

            final SubservicioVO ssrvVO = ssrvDAO.selectObject(ssrvCriterioVO);

            if (ssrvVO == null) {
                throw new InstanceNotFoundException(SubservicioVO.class.getName(), ssrvId);
            }

            if (atraDAO.updateFinalizar(ssrvVO.getId()) == 0) {
                throw new EstadoInvalidoException(SubservicioVO.class.getName(), ssrvVO.getId(), ssrvVO.getEstado(),
                        ssrvVO.getEtiqueta());
            }

            for (final Long tpdtId : itdtMap.keySet()) {
                final ItemDatoVO itdtVO = ssrvVO.getItdtMap().get(tpdtId);

                itdtVO.setItemId(ssrvVO.getId());
                itdtVO.setTpdtId(tpdtId);

                ssdtDAO.update(itdtVO);
            }

            escaDAO.updateEstado(ssrvVO.getSrvc().getId());
            escaDAO.updateFechaInicioFin(ssrvVO.getSrvc().getId());

            // FIXME Falta

            session.commit();
        }
    }

    /**
     * Checks if is cambio muelle.
     *
     * @param ssrvId
     *            the ssrv id
     * @return true, if is cambio muelle
     */
    public boolean isCambioMuelle(final Long ssrvId) {
        Preconditions.checkNotNull(ssrvId);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession();) {
            final AtraqueDAO atraDAO = session.getMapper(AtraqueDAO.class);

            return atraDAO.isCambioMuelle(ssrvId);
        }
    }

    /**
     * Checks if is autorizable f previo.
     *
     * @param ssrvId
     *            the ssrv id
     * @return true, if is autorizable f previo
     */
    public boolean isAutorizableFprevio(final Long ssrvId) {
        Preconditions.checkNotNull(ssrvId);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession();) {
            final AtraqueDAO atraDAO = session.getMapper(AtraqueDAO.class);

            return atraDAO.isAutorizableFprevio(ssrvId);
        }
    }

    /**
     * Autorizar fprevio.
     *
     * @param ssrvId
     *            the ssrv id
     * @param itdtMap
     *            the itdt map
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws EstadoInvalidoException
     *             the estado invalido exception
     */
    public void autorizarFprevio(final Long ssrvId, final Map<Long, ItemDatoVO> itdtMap)
            throws InstanceNotFoundException, EstadoInvalidoException {
        Preconditions.checkNotNull(ssrvId);
        Preconditions.checkNotNull(itdtMap);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);) {
            final AtraqueDAO atraDAO = session.getMapper(AtraqueDAO.class);
            final EscalaDAO escaDAO = session.getMapper(EscalaDAO.class);
            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
            final SubservicioDatoDAO ssdtDAO = session.getMapper(SubservicioDatoDAO.class);

            final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

            ssrvCriterioVO.setId(ssrvId);
            ssrvCriterioVO.setEntiId(Entidad.ATRAQUE.getId());

            final SubservicioVO ssrvVO = ssrvDAO.selectObject(ssrvCriterioVO);

            if (ssrvVO == null) {
                throw new InstanceNotFoundException(SubservicioVO.class.getName(), ssrvId);
            }

            // TODO Alta del fondeo previo en estado autorizado (C)
            // TODO Modificacion de las fechas de inicio/fin del atraque actual

            session.commit();
        }
    }

}
