package xeredi.argo.model.metamodelo.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.ExecutorType;
import org.mybatis.guice.transactional.Transactional;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.dao.CampoAgregacionDAO;
import xeredi.argo.model.metamodelo.vo.CampoAgregacionCriterioVO;
import xeredi.argo.model.metamodelo.vo.CampoAgregacionVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CampoAgregacionServiceImpl.
 */
@Transactional(executorType = ExecutorType.REUSE)
public class CampoAgregacionService {

	/** The cmag DAO. */
	@Inject
	private CampoAgregacionDAO cmagDAO;

	/**
	 * Insert.
	 *
	 * @param vo
	 *            the vo
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	public void insert(@NonNull final CampoAgregacionVO vo) throws DuplicateInstanceException {
		if (cmagDAO.exists(vo)) {
			throw new DuplicateInstanceException(MessageI18nKey.cmag, vo);
		}

		cmagDAO.insert(vo);
	}

	/**
	 * Update.
	 *
	 * @param vo
	 *            the vo
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void update(@NonNull final CampoAgregacionVO vo) throws InstanceNotFoundException {
		if (cmagDAO.update(vo) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.cmag, vo);
		}
	}

	/**
	 * Delete.
	 *
	 * @param vo
	 *            the vo
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void delete(@NonNull final CampoAgregacionVO vo) throws InstanceNotFoundException {
		if (cmagDAO.delete(vo) == 0) {
			throw new InstanceNotFoundException(MessageI18nKey.cmag, vo);
		}
	}

	/**
	 * Select.
	 *
	 * @param tpesId
	 *            the tpes id
	 * @param entdId
	 *            the entd id
	 * @param idioma
	 *            the idioma
	 * @return the campo agregacion VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public CampoAgregacionVO select(@NonNull final Long tpesId, @NonNull final Long entdId, final String idioma)
			throws InstanceNotFoundException {
		final CampoAgregacionCriterioVO cmagCriterioVO = new CampoAgregacionCriterioVO();

		cmagCriterioVO.setTpesId(tpesId);
		cmagCriterioVO.setEntdId(entdId);
		cmagCriterioVO.setIdioma(idioma);

		final CampoAgregacionVO cmagVO = cmagDAO.selectObject(cmagCriterioVO);

		if (cmagVO == null) {
			throw new InstanceNotFoundException(MessageI18nKey.cmag, cmagCriterioVO);
		}

		return cmagVO;
	}

	/**
	 * Select list.
	 *
	 * @param criterioVO
	 *            the criterio VO
	 * @return the list
	 */
	public List<CampoAgregacionVO> selectList(@NonNull final CampoAgregacionCriterioVO criterioVO) {
		return cmagDAO.selectList(criterioVO);
	}

}
