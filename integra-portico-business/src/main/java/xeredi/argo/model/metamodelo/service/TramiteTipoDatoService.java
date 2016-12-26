package xeredi.argo.model.metamodelo.service;

import java.util.List;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.metamodelo.vo.TramiteTipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.TramiteTipoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface TramiteTipoDatoService.
 */
public interface TramiteTipoDatoService {
	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	public List<TramiteTipoDatoVO> selectList(@NonNull final TramiteTipoDatoCriterioVO criterio);

	/**
	 * Select.
	 *
	 * @param trmtId
	 *            the trmt id
	 * @param tpdtId
	 *            the tpdt id
	 * @param idioma
	 *            the idioma
	 * @return the tramite tipo dato vo
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public TramiteTipoDatoVO select(@NonNull final Long trmtId, @NonNull final Long tpdtId, final String idioma)
			throws InstanceNotFoundException;

	/**
	 * Insert.
	 *
	 * @param trtd
	 *            the trtd
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	public void insert(@NonNull final TramiteTipoDatoVO trtd) throws DuplicateInstanceException;

	/**
	 * Update.
	 *
	 * @param trtd
	 *            the trtd
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void update(@NonNull final TramiteTipoDatoVO trtd) throws InstanceNotFoundException;

	/**
	 * Delete.
	 *
	 * @param trtd
	 *            the trtd
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void delete(@NonNull final TramiteTipoDatoVO trtd) throws InstanceNotFoundException;

}
