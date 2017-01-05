package xeredi.argo.model.metamodelo.service;

import java.util.List;
import java.util.Map;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface EntidadTipoDatoService.
 */
public interface EntidadTipoDatoService {

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
			throws DuplicateInstanceException;

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
			throws InstanceNotFoundException;

	/**
	 * Delete.
	 *
	 * @param entdVO
	 *            the entd VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void delete(@NonNull final EntidadTipoDatoVO entdVO) throws InstanceNotFoundException;

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
	public EntidadTipoDatoVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException;

	/**
	 * Select list.
	 *
	 * @param entdCriterio
	 *            the entd criterio
	 * @return the list
	 */
	public List<EntidadTipoDatoVO> selectList(@NonNull final EntidadTipoDatoCriterioVO entdCriterio);
}
