package xeredi.argo.model.metamodelo.service;

import java.util.List;
import java.util.Map;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface TipoSubparametroService.
 */
public interface TipoSubparametroService {

	/**
	 * Select label values.
	 *
	 * @return the list
	 */
	List<LabelValueVO> selectLabelValues();

	/**
	 * Select list.
	 *
	 * @param tpspCriterioVO
	 *            the tpsp criterio VO
	 * @return the list
	 */
	List<TipoSubparametroVO> selectList(@NonNull final TipoSubparametroCriterioVO tpspCriterioVO);

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @param idioma
	 *            the idioma
	 * @return the tipo subparametro VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	TipoSubparametroVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException;

	/**
	 * Insert.
	 *
	 * @param enti
	 *            the enti
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	void insert(@NonNull final TipoSubparametroVO enti, @NonNull final Map<String, I18nVO> i18nMap)
			throws DuplicateInstanceException;

	/**
	 * Update.
	 *
	 * @param tpsp
	 *            the tpsp
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	void update(@NonNull final TipoSubparametroVO tpsp, @NonNull final Map<String, I18nVO> i18nMap)
			throws InstanceNotFoundException;

	/**
	 * Delete.
	 *
	 * @param enti
	 *            the enti
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	void delete(@NonNull final TipoSubparametroVO enti) throws InstanceNotFoundException;
}
