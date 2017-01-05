package xeredi.argo.model.metamodelo.service;

import java.util.List;
import java.util.Map;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.metamodelo.vo.AccionEspecialCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionEspecialVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface AccionEspecialService.
 */
public interface AccionEspecialService {

	/**
	 * Insert.
	 *
	 * @param aces
	 *            the aces
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	public void insert(@NonNull final AccionEspecialVO aces, final Map<String, I18nVO> i18nMap)
			throws DuplicateInstanceException;

	/**
	 * Update.
	 *
	 * @param aces
	 *            the aces
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void update(@NonNull final AccionEspecialVO aces, final Map<String, I18nVO> i18nMap)
			throws InstanceNotFoundException;

	/**
	 * Delete.
	 *
	 * @param aces
	 *            the aces
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void delete(@NonNull final AccionEspecialVO aces) throws InstanceNotFoundException;

	/**
	 * Select list.
	 *
	 * @param acesCriterio
	 *            the aces criterio
	 * @return the list
	 */
	public List<AccionEspecialVO> selectList(@NonNull final AccionEspecialCriterioVO acesCriterio);

	/**
	 * Select object.
	 *
	 * @param acesCriterio
	 *            the aces criterio
	 * @return the accion especial VO
	 */
	public AccionEspecialVO selectObject(@NonNull final AccionEspecialCriterioVO acesCriterio);

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @param idioma
	 *            the idioma
	 * @return the accion especial VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public AccionEspecialVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException;
}
