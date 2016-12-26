package xeredi.argo.model.metamodelo.service;

import java.util.List;
import java.util.Map;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioVO;
import xeredi.argo.model.util.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Interface TipoServicioService.
 */
public interface TipoServicioService {
	/**
	 * Select label values.
	 *
	 * @param criterioVO
	 *            the criterio vo
	 * @return the list
	 */
	public List<LabelValueVO> selectLabelValues(@NonNull final TipoServicioCriterioVO criterioVO);

	/**
	 * Select list.
	 *
	 * @param tpsrCriterio
	 *            the tpsr criterio
	 * @return the list
	 */
	public List<TipoServicioVO> selectList(@NonNull final TipoServicioCriterioVO tpsrCriterio);

	/**
	 * Select list.
	 *
	 * @param tpsrCriterio
	 *            the tpsr criterio
	 * @param offset
	 *            the offset
	 * @param limit
	 *            the limit
	 * @return the paginated list
	 */
	public PaginatedList<TipoServicioVO> selectList(@NonNull final TipoServicioCriterioVO tpsrCriterio,
			final int offset, final int limit);

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @param idioma
	 *            the idioma
	 * @return the tipo servicio vo
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public TipoServicioVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException;

	/**
	 * Insert.
	 *
	 * @param tpsr
	 *            the tpsr
	 * @param i18nMap
	 *            the i18n map
	 * @throws DuplicateInstanceException
	 *             the duplicate instance exception
	 */
	public void insert(@NonNull final TipoServicioVO tpsr, @NonNull final Map<String, I18nVO> i18nMap)
			throws DuplicateInstanceException;

	/**
	 * Update.
	 *
	 * @param tpsr
	 *            the tpsr
	 * @param i18nMap
	 *            the i18n map
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void update(@NonNull final TipoServicioVO tpsr, @NonNull final Map<String, I18nVO> i18nMap)
			throws InstanceNotFoundException;

	/**
	 * Delete.
	 *
	 * @param tpsr
	 *            the tpsr
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	public void delete(@NonNull final TipoServicioVO tpsr) throws InstanceNotFoundException;
}
