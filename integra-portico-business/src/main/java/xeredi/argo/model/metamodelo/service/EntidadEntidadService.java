package xeredi.argo.model.metamodelo.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.ExecutorType;
import org.mybatis.guice.transactional.Transactional;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.dao.EntidadDAO;
import xeredi.argo.model.metamodelo.dao.EntidadEntidadDAO;
import xeredi.argo.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadEntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadEntidadVO;
import xeredi.argo.model.metamodelo.vo.EntidadVO;
import xeredi.argo.model.metamodelo.vo.TipoEntidad;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadEntidadServiceImpl.
 */
@Transactional(executorType = ExecutorType.REUSE)
public class EntidadEntidadService {

	/** The enen DAO. */
	@Inject
	private EntidadEntidadDAO enenDAO;

	/** The enti DAO. */
	@Inject
	private EntidadDAO entiDAO;

	/**
	 * Insert.
	 *
	 * @param enenVO
	 *            the enen VO
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	public void insert(@NonNull final EntidadEntidadVO enenVO) throws DuplicateInstanceException {
		Preconditions.checkNotNull(enenVO.getEntiPadreId());
		Preconditions.checkNotNull(enenVO.getEntiHija());
		Preconditions.checkNotNull(enenVO.getEntiHija().getId());
		Preconditions.checkNotNull(enenVO.getOrden());

		final EntidadCriterioVO entipadreCriterio = new EntidadCriterioVO();

		entipadreCriterio.setId(enenVO.getEntiPadreId());

		final EntidadVO entiPadreVO = entiDAO.selectObject(entipadreCriterio);

		final EntidadCriterioVO entihijaCriterio = new EntidadCriterioVO();

		entihijaCriterio.setId(enenVO.getEntiHija().getId());

		final EntidadVO entiHijaVO = entiDAO.selectObject(entihijaCriterio);

		if (entiPadreVO.getTipo() == TipoEntidad.P
				&& (entiHijaVO.getTipo() == TipoEntidad.T || entiHijaVO.getTipo() == TipoEntidad.S)) {
			throw new Error(
					"Una entidad de tipo maestro no puede ser padre de entidades asociadas a servicios: " + enenVO);
		}
		if (entiPadreVO.getTipo() == TipoEntidad.S && entiHijaVO.getTipo() == TipoEntidad.T) {
			throw new Error(
					"Una entidad de tipo subservicio no puede ser padre de entidades asociadas a tipos de servicio: "
							+ enenVO);
		}

		if (enenDAO.exists(enenVO)) {
			throw new DuplicateInstanceException(MessageI18nKey.enen, enenVO);
		}

		enenDAO.insert(enenVO);
	}

	/**
	 * Update.
	 *
	 * @param enenVO
	 *            the enen VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void update(@NonNull final EntidadEntidadVO enenVO) throws InstanceNotFoundException {
		Preconditions.checkNotNull(enenVO.getEntiPadreId());
		Preconditions.checkNotNull(enenVO.getEntiHija());
		Preconditions.checkNotNull(enenVO.getEntiHija().getId());
		Preconditions.checkNotNull(enenVO.getOrden());

		final int updated = enenDAO.update(enenVO);

		if (updated == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.enen, enenVO);
		}
	}

	/**
	 * Delete.
	 *
	 * @param enenVO
	 *            the enen VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void delete(@NonNull final EntidadEntidadVO enenVO) throws InstanceNotFoundException {
		Preconditions.checkNotNull(enenVO.getEntiPadreId());
		Preconditions.checkNotNull(enenVO.getEntiHija());
		Preconditions.checkNotNull(enenVO.getEntiHija().getId());

		final int updated = enenDAO.delete(enenVO);

		if (updated == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.enen, enenVO);
		}
	}

	/**
	 * Select list.
	 *
	 * @param enenCriterioVO
	 *            the enen criterio VO
	 * @return the list
	 */
	public List<EntidadEntidadVO> selectList(@NonNull final EntidadEntidadCriterioVO enenCriterioVO) {
		return enenDAO.selectList(enenCriterioVO);
	}

	/**
	 * Select.
	 *
	 * @param entipId
	 *            the entip id
	 * @param entihId
	 *            the entih id
	 * @return the entidad entidad VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public EntidadEntidadVO select(@NonNull final Long entipId, @NonNull final Long entihId)
			throws InstanceNotFoundException {
		final EntidadEntidadCriterioVO enenCriterio = new EntidadEntidadCriterioVO();

		enenCriterio.setEntiPadreId(entipId);
		enenCriterio.setEntiHijaId(entipId);

		final EntidadEntidadVO enen = selectObject(enenCriterio);

		if (enen == null) {
			throw new InstanceNotFoundException(MessageI18nKey.enen, entipId, entihId);
		}

		return enen;

	}

	/**
	 * Select object.
	 *
	 * @param enenCriterioVO
	 *            the enen criterio VO
	 * @return the entidad entidad VO
	 */
	public EntidadEntidadVO selectObject(@NonNull final EntidadEntidadCriterioVO enenCriterioVO) {
		return enenDAO.selectObject(enenCriterioVO);
	}

}
