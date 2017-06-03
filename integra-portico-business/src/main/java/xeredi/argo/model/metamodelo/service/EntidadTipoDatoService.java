package xeredi.argo.model.metamodelo.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.ExecutorType;
import org.mybatis.guice.transactional.Transactional;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.service.I18nService;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.dao.EntidadTipoDatoDAO;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadTipoDatoServiceImpl.
 */
@Transactional(executorType = ExecutorType.REUSE)
public class EntidadTipoDatoService {

	/** The entd DAO. */
	@Inject
	private EntidadTipoDatoDAO entdDAO;

	/** The i 18 n DAO. */
	@Inject
	private I18nService i18nService;

	/**
	 * Insert.
	 *
	 * @param entdVO
	 *            the entd VO
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	public void insert(@NonNull final EntidadTipoDatoVO entdVO, @NonNull final Map<String, I18nVO> i18nMap)
			throws DuplicateInstanceException {
		Preconditions.checkNotNull(entdVO.getEntiId());
		Preconditions.checkNotNull(entdVO.getTpdt());
		Preconditions.checkNotNull(entdVO.getTpdt().getId());

		if (entdDAO.exists(entdVO)) {
			throw new DuplicateInstanceException(MessageI18nKey.entd, entdVO);
		}

		IgUtilBO.assignNextVal(entdVO);

		entdDAO.insert(entdVO);
		i18nService.insertMap(entdVO, i18nMap);
	}

	/**
	 * Update.
	 *
	 * @param entdVO
	 *            the entd VO
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void update(@NonNull final EntidadTipoDatoVO entdVO, @NonNull final Map<String, I18nVO> i18nMap)
			throws InstanceNotFoundException {
		Preconditions.checkNotNull(entdVO.getEntiId());
		Preconditions.checkNotNull(entdVO.getTpdt());
		Preconditions.checkNotNull(entdVO.getTpdt().getId());

		if (entdDAO.update(entdVO) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.entd, entdVO);
		}

		i18nService.updateMap(entdVO, i18nMap);
	}

	/**
	 * Delete.
	 *
	 * @param entdVO
	 *            the entd VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void delete(@NonNull final EntidadTipoDatoVO entdVO) throws InstanceNotFoundException {
		Preconditions.checkNotNull(entdVO.getId());

		if (entdDAO.delete(entdVO) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.entd, entdVO);
		}

		i18nService.deleteMap(entdVO);
	}

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @param idioma
	 *            the idioma
	 * @return the entidad tipo dato VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public EntidadTipoDatoVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException {
		final EntidadTipoDatoCriterioVO entdCriterioVO = new EntidadTipoDatoCriterioVO();

		entdCriterioVO.setId(id);
		entdCriterioVO.setIdioma(idioma);

		final EntidadTipoDatoVO entdVO = entdDAO.selectObject(entdCriterioVO);

		if (entdVO == null) {
			throw new InstanceNotFoundException(MessageI18nKey.entd, id);
		}

		return entdVO;
	}

	/**
	 * Select list.
	 *
	 * @param entdCriterio
	 *            the entd criterio
	 * @return the list
	 */
	public List<EntidadTipoDatoVO> selectList(@NonNull final EntidadTipoDatoCriterioVO entdCriterio) {
		return entdDAO.selectList(entdCriterio);
	}
}
