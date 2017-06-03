package xeredi.argo.model.metamodelo.service;

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
import xeredi.argo.model.metamodelo.dao.CodigoReferenciaDAO;
import xeredi.argo.model.metamodelo.vo.CodigoReferenciaCriterioVO;
import xeredi.argo.model.metamodelo.vo.CodigoReferenciaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CodigoReferenciaServiceImpl.
 */
@Transactional(executorType = ExecutorType.REUSE)
public class CodigoReferenciaService {

	/** The cdrf DAO. */
	@Inject
	private CodigoReferenciaDAO cdrfDAO;

	/** The i 18 n DAO. */
	@Inject
	private I18nService i18nService;

	/**
	 * Insert.
	 *
	 * @param cdrf
	 *            the cdrf
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	public void insert(@NonNull final CodigoReferenciaVO cdrf, @NonNull final Map<String, I18nVO> i18nMap)
			throws DuplicateInstanceException {
		if (cdrfDAO.exists(cdrf)) {
			throw new DuplicateInstanceException(MessageI18nKey.cdrf, cdrf);
		}

		IgUtilBO.assignNextVal(cdrf);
		cdrfDAO.insert(cdrf);
		i18nService.insertMap(cdrf, i18nMap);
	}

	/**
	 * Update.
	 *
	 * @param cdrf
	 *            the cdrf
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void update(@NonNull final CodigoReferenciaVO cdrf, @NonNull final Map<String, I18nVO> i18nMap)
			throws InstanceNotFoundException {
		final int updated = cdrfDAO.update(cdrf);

		if (updated == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.cdrf, cdrf);
		}

		i18nService.updateMap(cdrf, i18nMap);
	}

	/**
	 * Delete.
	 *
	 * @param cdrf
	 *            the cdrf
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void delete(@NonNull final CodigoReferenciaVO cdrf) throws InstanceNotFoundException {
		Preconditions.checkNotNull(cdrf.getId());

		i18nService.deleteMap(cdrf);

		final int deleted = cdrfDAO.delete(cdrf);

		if (deleted == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.cdrf, cdrf);
		}
	}

	/**
	 * Select.
	 *
	 * @param cdrfId
	 *            the cdrf id
	 * @param idioma
	 *            the idioma
	 * @return the codigo referencia VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
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
