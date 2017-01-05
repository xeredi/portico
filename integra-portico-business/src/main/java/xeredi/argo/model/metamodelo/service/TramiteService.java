package xeredi.argo.model.metamodelo.service;

import java.util.List;
import java.util.Map;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.metamodelo.vo.TramiteCriterioVO;
import xeredi.argo.model.metamodelo.vo.TramiteVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface TramiteService.
 */
public interface TramiteService {
	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	public List<TramiteVO> selectList(@NonNull final TramiteCriterioVO criterio);

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @param idioma
	 *            the idioma
	 * @return the tramite vo
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public TramiteVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException;

	/**
	 * Insert.
	 *
	 * @param trmt
	 *            the trmt
	 * @param i18nMap
	 *            the i18n map
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	public void insert(@NonNull final TramiteVO trmt, @NonNull final Map<String, I18nVO> i18nMap)
			throws DuplicateInstanceException;

	/**
	 * Update.
	 *
	 * @param trmt
	 *            the trmt
	 * @param i18nMap
	 *            the i18n map
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void update(@NonNull final TramiteVO trmt, @NonNull final Map<String, I18nVO> i18nMap)
			throws InstanceNotFoundException;

	/**
	 * Delete.
	 *
	 * @param trmt
	 *            the trmt
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void delete(@NonNull final TramiteVO trmt) throws InstanceNotFoundException;

}
