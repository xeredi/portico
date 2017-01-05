package xeredi.argo.model.metamodelo.service;

import java.util.List;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.metamodelo.vo.CampoAgregacionCriterioVO;
import xeredi.argo.model.metamodelo.vo.CampoAgregacionVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface CampoAgregacionService.
 */
public interface CampoAgregacionService {

	/**
	 * Insert.
	 *
	 * @param vo
	 *            the vo
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	void insert(@NonNull final CampoAgregacionVO vo) throws DuplicateInstanceException;

	/**
	 * Update.
	 *
	 * @param vo
	 *            the vo
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	void update(@NonNull final CampoAgregacionVO vo) throws InstanceNotFoundException;

	/**
	 * Delete.
	 *
	 * @param vo
	 *            the vo
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	void delete(@NonNull final CampoAgregacionVO vo) throws InstanceNotFoundException;

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
	CampoAgregacionVO select(final @NonNull Long tpesId, final @NonNull Long entdId, final String idioma)
			throws InstanceNotFoundException;

	/**
	 * Select list.
	 *
	 * @param criterioVO
	 *            the criterio VO
	 * @return the list
	 */
	List<CampoAgregacionVO> selectList(final @NonNull CampoAgregacionCriterioVO criterioVO);
}
