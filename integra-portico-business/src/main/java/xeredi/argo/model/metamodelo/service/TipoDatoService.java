package xeredi.argo.model.metamodelo.service;

import java.util.List;
import java.util.Map;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.metamodelo.vo.TipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoDatoVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Interface TipoDatoService.
 */
public interface TipoDatoService {
	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @param idioma
	 *            the idioma
	 * @return the tipo dato VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	TipoDatoVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException;

	/**
	 * Insert.
	 *
	 * @param tpdt
	 *            the tpdt
	 * @param i18nMap
	 *            the i18n map
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	void insert(@NonNull final TipoDatoVO tpdt, @NonNull final Map<String, I18nVO> i18nMap)
			throws DuplicateInstanceException;

	/**
	 * Update.
	 *
	 * @param tpdt
	 *            the tpdt
	 * @param i18nMap
	 *            the i18n map
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	void update(@NonNull final TipoDatoVO tpdt, @NonNull final Map<String, I18nVO> i18nMap)
			throws InstanceNotFoundException;

	/**
	 * Delete.
	 *
	 * @param tpdt
	 *            the tpdt
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	void delete(@NonNull final TipoDatoVO tpdt) throws InstanceNotFoundException;

	/**
	 * Select list.
	 *
	 * @param tpdtCriterio
	 *            the tpdt criterio
	 * @return the list
	 */
	List<TipoDatoVO> selectList(@NonNull final TipoDatoCriterioVO tpdtCriterio);

	/**
	 * Select list.
	 *
	 * @param tpdtCriterio
	 *            the tpdt criterio
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	PaginatedList<TipoDatoVO> selectList(@NonNull final TipoDatoCriterioVO tpdtCriterio, final int offset,
			final int limit);

	/**
	 * Select label values.
	 *
	 * @param tpdtCriterio
	 *            the tpdt criterio
	 * @return the list
	 */
	List<LabelValueVO> selectLabelValues(@NonNull final TipoDatoCriterioVO tpdtCriterio);
}
