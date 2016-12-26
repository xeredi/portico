package xeredi.argo.model.metamodelo.service;

import java.util.Map;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.metamodelo.vo.CodigoReferenciaVO;

public interface CodigoReferenciaService {
	/**
	 * Insert.
	 *
	 * @param cdrf
	 *            the cdrf
	 * @param i18nMap
	 *            the i18n map
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	public void insert(@NonNull final CodigoReferenciaVO cdrf, @NonNull final Map<String, I18nVO> i18nMap)
			throws DuplicateInstanceException;

	/**
	 * Update.
	 *
	 * @param cdrf
	 *            the cdrf
	 * @param i18nMap
	 *            the i18n map
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void update(@NonNull final CodigoReferenciaVO cdrf, @NonNull final Map<String, I18nVO> i18nMap)
			throws InstanceNotFoundException;

	/**
	 * Delete.
	 *
	 * @param cdrf
	 *            the cdrf
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void delete(@NonNull final CodigoReferenciaVO cdrf) throws InstanceNotFoundException;

	/**
	 * Select.
	 *
	 * @param cdrfId
	 *            the cdrf id
	 * @param idioma
	 *            the idioma
	 * @return the codigo referencia vo
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public CodigoReferenciaVO select(@NonNull final Long cdrfId, final String idioma) throws InstanceNotFoundException;
}
