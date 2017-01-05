package xeredi.argo.model.metamodelo.service;

import java.util.List;
import java.util.Map;

import org.mybatis.guice.transactional.Transactional;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import lombok.NonNull;
import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.dao.I18nDAO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.service.I18nUtil;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.dao.EntidadTipoDatoDAO;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadTipoDatoServiceImpl.
 */
@Singleton
@Transactional
public class EntidadTipoDatoServiceImpl implements EntidadTipoDatoService {

	/** The entd DAO. */
	@Inject
	private EntidadTipoDatoDAO entdDAO;

	/** The i 18 n DAO. */
	@Inject
	private I18nDAO i18nDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
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
		I18nUtil.insertMap(i18nDAO, entdVO, i18nMap);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(@NonNull final EntidadTipoDatoVO entdVO, @NonNull final Map<String, I18nVO> i18nMap)
			throws InstanceNotFoundException {
		Preconditions.checkNotNull(entdVO.getEntiId());
		Preconditions.checkNotNull(entdVO.getTpdt());
		Preconditions.checkNotNull(entdVO.getTpdt().getId());

		if (entdDAO.update(entdVO) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.entd, entdVO);
		}

		I18nUtil.updateMap(i18nDAO, entdVO, i18nMap);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(@NonNull final EntidadTipoDatoVO entdVO) throws InstanceNotFoundException {
		Preconditions.checkNotNull(entdVO.getId());

		if (entdDAO.delete(entdVO) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.entd, entdVO);
		}

		I18nUtil.deleteMap(i18nDAO, entdVO);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
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
	 * {@inheritDoc}
	 */
	@Override
	public List<EntidadTipoDatoVO> selectList(@NonNull final EntidadTipoDatoCriterioVO entdCriterio) {
		return entdDAO.selectList(entdCriterio);
	}
}
