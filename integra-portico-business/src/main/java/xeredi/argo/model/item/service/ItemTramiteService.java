package xeredi.argo.model.item.service;

import java.util.List;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.item.vo.ItemTramiteCriterioVO;
import xeredi.argo.model.item.vo.ItemTramiteVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ItemTramiteService.
 */
public interface ItemTramiteService {
	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @param idioma
	 *            the idioma
	 * @return the item tramite VO
	 * @throws InstanceNotFoundException
	 *             the instance not found exception
	 */
	ItemTramiteVO select(@NonNull final Long id, final String idioma) throws InstanceNotFoundException;

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	List<ItemTramiteVO> selectList(@NonNull final ItemTramiteCriterioVO criterio);
}
