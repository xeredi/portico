package xeredi.integra.model.servicio.bo.manifiesto;

import java.util.List;

import javax.annotation.Nonnull;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.exception.ModelException;
import xeredi.integra.model.comun.exception.OperacionNoPermitidaException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.servicio.bo.AbstractServicioBO;
import xeredi.integra.model.servicio.dao.ServicioDAO;
import xeredi.integra.model.servicio.dao.manifiesto.BlDAO;
import xeredi.integra.model.servicio.dao.manifiesto.ManifiestoResumenDAO;
import xeredi.integra.model.servicio.dao.manifiesto.ManifiestoServicioDAO;
import xeredi.integra.model.servicio.dao.manifiesto.ManifiestoSubservicioDAO;
import xeredi.integra.model.servicio.vo.ServicioCriterioVO;
import xeredi.integra.model.servicio.vo.ServicioVO;
import xeredi.integra.model.servicio.vo.SubservicioCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioSubservicioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;
import xeredi.integra.model.servicio.vo.manifiesto.ResumenTotalesCriterioVO;
import xeredi.integra.model.servicio.vo.manifiesto.ResumenTotalesVO;
import xeredi.util.mybatis.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class ManifiestoBO.
 */
public final class ManifiestoBO extends AbstractServicioBO {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void insertPostOperations(final @Nonnull SqlSession session,
			final @Nonnull ServicioVO srvcVO,
			final List<SubservicioVO> ssrvList,
			final List<SubservicioSubservicioVO> ssssList) {
		final BlDAO blDAO = session.getMapper(BlDAO.class);

		final SubservicioCriterioVO ssrvCriterio = new SubservicioCriterioVO();
		final ServicioCriterioVO srvcCriterio = new ServicioCriterioVO();

		srvcCriterio.setId(srvcVO.getId());
		ssrvCriterio.setSrvc(srvcCriterio);

//		blDAO.updateRecalcularEstado(ssrvCriterio);
//		blDAO.updateRecalcularTipoIva(ssrvCriterio);

		// TODO Recalcular estado manifiesto
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void updatePostOperations(final @Nonnull SqlSession session,
			final @Nonnull ServicioVO srvcVO) throws ModelException {
		// noop
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void duplicatePostOperations(final @Nonnull SqlSession session,
			final @Nonnull ServicioVO srvcVO) throws ModelException {
		// noop
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void deletePostOperations(final @Nonnull SqlSession session,
			final @Nonnull Long srvcId) throws ModelException {
		// noop
	}

	/**
	 * Bloquear.
	 *
	 * @param srvcId
	 *            the srvc id
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 * @throws OperacionNoPermitidaException
	 *             the operacion no permitida exception
	 */
	public void bloquear(final @Nonnull Long srvcId)
			throws InstanceNotFoundException, OperacionNoPermitidaException {
		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory()
				.openSession(ExecutorType.REUSE)) {
			final ServicioDAO srvcDAO = session.getMapper(ServicioDAO.class);
			final ManifiestoServicioDAO maniDAO = session
					.getMapper(ManifiestoServicioDAO.class);
			final ManifiestoSubservicioDAO maniSsrvDAO = session
					.getMapper(ManifiestoSubservicioDAO.class);

			final ServicioCriterioVO srvcCriterioVO = new ServicioCriterioVO();

			srvcCriterioVO.setId(srvcId);

			final ServicioVO srvcVO = srvcDAO.selectObject(srvcCriterioVO);

			if (srvcVO == null) {
				throw new InstanceNotFoundException(Entidad.MANIFIESTO.getId(),
						srvcId);
			}

			final int updatedRows = maniDAO.updateBloquear(srvcId);

			if (updatedRows == 0) {
				throw new OperacionNoPermitidaException(
						Entidad.MANIFIESTO.getId(),
						MessageI18nKey.mani_bloquear, srvcId);
			}

			// Bloqueo de los Subservicios del Manifiesto (Bls, Partidas y
			// Equipamientos)
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
	 * @throws OperacionNoPermitidaException
	 *             the operacion no permitida exception
	 */
	public void completar(final @Nonnull Long srvcId)
			throws InstanceNotFoundException, OperacionNoPermitidaException {
		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory()
				.openSession(ExecutorType.REUSE)) {
			final ServicioDAO srvcDAO = session.getMapper(ServicioDAO.class);
			final ManifiestoServicioDAO maniDAO = session
					.getMapper(ManifiestoServicioDAO.class);
			final ManifiestoSubservicioDAO maniSsrvDAO = session
					.getMapper(ManifiestoSubservicioDAO.class);

			final ServicioCriterioVO srvcCriterioVO = new ServicioCriterioVO();

			srvcCriterioVO.setId(srvcId);

			final ServicioVO srvcVO = srvcDAO.selectObject(srvcCriterioVO);

			if (srvcVO == null) {
				throw new InstanceNotFoundException(Entidad.MANIFIESTO.getId(),
						srvcId);
			}

			final int updatedRows = maniDAO.updateCompletar(srvcId);

			if (updatedRows == 0) {
				throw new OperacionNoPermitidaException(
						Entidad.MANIFIESTO.getId(),
						MessageI18nKey.mani_completar, srvcId);
			}

			// Completado de los Subservicios del Manifiesto (Bls, Partidas y
			// Equipamientos)
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
	 * @throws OperacionNoPermitidaException
	 *             the operacion no permitida exception
	 */
	public void iniciar(final @Nonnull Long srvcId)
			throws InstanceNotFoundException, OperacionNoPermitidaException {
		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory()
				.openSession(ExecutorType.REUSE)) {
			final ServicioDAO srvcDAO = session.getMapper(ServicioDAO.class);
			final ManifiestoServicioDAO maniDAO = session
					.getMapper(ManifiestoServicioDAO.class);
			final ManifiestoSubservicioDAO maniSsrvDAO = session
					.getMapper(ManifiestoSubservicioDAO.class);

			final ServicioCriterioVO srvcCriterioVO = new ServicioCriterioVO();

			srvcCriterioVO.setId(srvcId);

			final ServicioVO srvcVO = srvcDAO.selectObject(srvcCriterioVO);

			if (srvcVO == null) {
				throw new InstanceNotFoundException(Entidad.MANIFIESTO.getId(),
						srvcId);
			}

			final int updatedRows = maniDAO.updateIniciar(srvcId);

			if (updatedRows == 0) {
				throw new OperacionNoPermitidaException(
						Entidad.MANIFIESTO.getId(),
						MessageI18nKey.mani_iniciar, srvcId);
			}

			// Inicio de los Subservicios del Manifiesto (Bls, Partidas y
			// Equipamientos)
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
	 * @throws OperacionNoPermitidaException
	 *             the operacion no permitida exception
	 */
	public void anular(final @Nonnull Long srvcId)
			throws InstanceNotFoundException, OperacionNoPermitidaException {
		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory()
				.openSession(ExecutorType.REUSE)) {
			final ServicioDAO srvcDAO = session.getMapper(ServicioDAO.class);
			final ManifiestoServicioDAO maniDAO = session
					.getMapper(ManifiestoServicioDAO.class);
			final ManifiestoSubservicioDAO maniSsrvDAO = session
					.getMapper(ManifiestoSubservicioDAO.class);

			final ServicioCriterioVO srvcCriterioVO = new ServicioCriterioVO();

			srvcCriterioVO.setId(srvcId);

			final ServicioVO srvcVO = srvcDAO.selectObject(srvcCriterioVO);

			if (srvcVO == null) {
				throw new InstanceNotFoundException(Entidad.MANIFIESTO.getId(),
						srvcId);
			}

			final int updatedRows = maniDAO.updateAnular(srvcId);

			if (updatedRows == 0) {
				throw new OperacionNoPermitidaException(
						Entidad.MANIFIESTO.getId(), MessageI18nKey.mani_anular,
						srvcId);
			}

			// Anulacion de los Subservicios del Manifiesto (Bls, Partidas y
			// Equipamientos)
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
	public ResumenTotalesVO selectResumen(final @Nonnull Long maniId)
			throws InstanceNotFoundException {
		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory()
				.openSession(ExecutorType.REUSE)) {
			final ManifiestoResumenDAO resumenDAO = session
					.getMapper(ManifiestoResumenDAO.class);
			final ResumenTotalesCriterioVO totalCriterioVO = new ResumenTotalesCriterioVO();

			totalCriterioVO.setManiId(maniId);

			final ResumenTotalesVO totalVO = resumenDAO
					.selectObject(totalCriterioVO);

			if (totalVO == null) {
				throw new InstanceNotFoundException(Entidad.MANIFIESTO.getId(),
						totalCriterioVO);
			}

			return totalVO;
		}
	}
}
