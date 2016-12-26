package xeredi.argo.model.metamodelo.service;

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
import xeredi.argo.model.metamodelo.dao.CodigoReferenciaDAO;
import xeredi.argo.model.metamodelo.vo.CodigoReferenciaCriterioVO;
import xeredi.argo.model.metamodelo.vo.CodigoReferenciaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CodigoReferenciaServiceImpl.
 */
@Singleton
@Transactional
public class CodigoReferenciaServiceImpl implements CodigoReferenciaService {

	/** The cdrf DAO. */
	@Inject
	private CodigoReferenciaDAO cdrfDAO;

	/** The i 18 n DAO. */
	@Inject
	private I18nDAO i18nDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insert(@NonNull final CodigoReferenciaVO cdrf, @NonNull final Map<String, I18nVO> i18nMap)
			throws DuplicateInstanceException {
		if (cdrfDAO.exists(cdrf)) {
			throw new DuplicateInstanceException(MessageI18nKey.cdrf, cdrf);
		}

		IgUtilBO.assignNextVal(cdrf);
		cdrfDAO.insert(cdrf);
		I18nUtil.insertMap(i18nDAO, cdrf, i18nMap);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(@NonNull final CodigoReferenciaVO cdrf, @NonNull final Map<String, I18nVO> i18nMap)
			throws InstanceNotFoundException {
		final int updated = cdrfDAO.update(cdrf);

		if (updated == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.cdrf, cdrf);
		}

		I18nUtil.updateMap(i18nDAO, cdrf, i18nMap);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(@NonNull final CodigoReferenciaVO cdrf) throws InstanceNotFoundException {
		Preconditions.checkNotNull(cdrf.getId());

		I18nUtil.deleteMap(i18nDAO, cdrf);

		final int deleted = cdrfDAO.delete(cdrf);

		if (deleted == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.cdrf, cdrf);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CodigoReferenciaVO select(@NonNull final Long cdrfId, final String idioma) throws InstanceNotFoundException {
		final CodigoReferenciaCriterioVO cdrfCriterioVO = new CodigoReferenciaCriterioVO();

		cdrfCriterioVO.setId(cdrfId);
		cdrfCriterioVO.setIdioma(idioma);

		final CodigoReferenciaVO cdrf = cdrfDAO.selectObject(cdrfCriterioVO);

		if (cdrf == null) {
			throw new InstanceNotFoundException(MessageI18nKey.cdrf, cdrfId);
		}

		return cdrf;
	}
}
