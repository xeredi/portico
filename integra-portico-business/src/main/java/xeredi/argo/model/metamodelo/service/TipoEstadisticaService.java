package xeredi.argo.model.metamodelo.service;

import java.util.List;
import java.util.Map;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.metamodelo.vo.TipoEstadisticaCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoEstadisticaVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Interface TipoEstadisticaService.
 */
public interface TipoEstadisticaService {

	/**
	 * Select label values.
	 *
	 * @param tpesCriterio
	 *            the tpes criterio
	 * @return the list
	 */
	public List<LabelValueVO> selectLabelValues(final TipoEstadisticaCriterioVO tpesCriterio);

	/**
	 * Select list.
	 *
	 * @param tpesCriterio
	 *            the tpes criterio
	 * @return the list
	 */
	public List<TipoEstadisticaVO> selectList(@NonNull final TipoEstadisticaCriterioVO tpesCriterio);

	/**
	 * Select list.
	 *
	 * @param tpesCriterio
	 *            the tpes criterio
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	public PaginatedList<TipoEstadisticaVO> selectList(@NonNull final TipoEstadisticaCriterioVO tpesCriterio,
			final int offset, final int limit);

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @param idioma
	 *            the idioma
	 * @return the tipo estadistica VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public TipoEstadisticaVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException;

	/**
	 * Insert.
	 *
	 * @param tpes
	 *            the tpes
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	public void insert(@NonNull final TipoEstadisticaVO tpes, @NonNull final Map<String, I18nVO> i18nMap)
			throws DuplicateInstanceException;

	/**
	 * Update.
	 *
	 * @param tpes
	 *            the tpes
	 * @param i18nMap
	 *            the i 18 n map
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void update(@NonNull final TipoEstadisticaVO tpes, @NonNull final Map<String, I18nVO> i18nMap)
			throws InstanceNotFoundException;

	/**
	 * Delete.
	 *
	 * @param tpes
	 *            the tpes
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void delete(@NonNull final TipoEstadisticaVO tpes) throws InstanceNotFoundException;
}
