package xeredi.argo.model.metamodelo.service;

import java.util.List;
import java.util.Map;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.metamodelo.vo.TipoParametroCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoParametroVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Interface TipoParametroService.
 */
public interface TipoParametroService {

	/**
	 * Select label values.
	 *
	 * @param tpprCriterio
	 *            the tppr criterio
	 * @return the list
	 */
	public List<LabelValueVO> selectLabelValues(final TipoParametroCriterioVO tpprCriterio);

	/**
	 * Select list.
	 *
	 * @param tpprCriterioVO
	 *            the tppr criterio vo
	 * @return the list
	 */
	public List<TipoParametroVO> selectList(@NonNull final TipoParametroCriterioVO tpprCriterioVO);

	/**
	 * Select list.
	 *
	 * @param tpprCriterioVO
	 *            the tppr criterio vo
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	public PaginatedList<TipoParametroVO> selectList(@NonNull final TipoParametroCriterioVO tpprCriterioVO,
			final int offset, final int limit);

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @param idioma
	 *            the idioma
	 * @return the tipo parametro vo
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public TipoParametroVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException;

	/**
	 * Insert.
	 *
	 * @param tppr
	 *            the tppr
	 * @param i18nMap
	 *            the i18n map
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	public void insert(@NonNull final TipoParametroVO tppr, @NonNull final Map<String, I18nVO> i18nMap)
			throws DuplicateInstanceException;

	/**
	 * Update.
	 *
	 * @param tppr
	 *            the tppr
	 * @param i18nMap
	 *            the i18n map
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void update(@NonNull final TipoParametroVO tppr, @NonNull final Map<String, I18nVO> i18nMap)
			throws InstanceNotFoundException;

	/**
	 * Delete.
	 *
	 * @param tppr
	 *            the tppr
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void delete(@NonNull final TipoParametroVO tppr) throws InstanceNotFoundException;
}
