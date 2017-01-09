package xeredi.argo.model.metamodelo.service;

import java.util.List;
import java.util.Map;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface TipoSubservicioService.
 */
public interface TipoSubservicioService {

	/**
	 * Select label values.
	 *
	 * @param tpssCriterio
	 *            the tpss criterio
	 * @return the list
	 */
	List<LabelValueVO> selectLabelValues(@NonNull final TipoSubservicioCriterioVO tpssCriterio);

	/**
	 * Select list.
	 *
	 * @param tpssCriterio
	 *            the tpss criterio
	 * @return the list
	 */
	List<TipoSubservicioVO> selectList(@NonNull final TipoSubservicioCriterioVO tpssCriterio);

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @param idioma
	 *            the idioma
	 * @return the tipo subservicio VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	TipoSubservicioVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException;

	/**
	 * Insert.
	 *
	 * @param tpss
	 *            the tpss
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	void insert(@NonNull final TipoSubservicioVO tpss, @NonNull final Map<String, I18nVO> i18nMap)
			throws DuplicateInstanceException;

	/**
	 * Update.
	 *
	 * @param tpss
	 *            the tpss
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	void update(@NonNull final TipoSubservicioVO tpss, @NonNull final Map<String, I18nVO> i18nMap)
			throws InstanceNotFoundException;

	/**
	 * Delete.
	 *
	 * @param tpss
	 *            the tpss
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	void delete(@NonNull final TipoSubservicioVO tpss) throws InstanceNotFoundException;
}
