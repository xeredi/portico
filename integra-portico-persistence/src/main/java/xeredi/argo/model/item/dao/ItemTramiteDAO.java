package xeredi.argo.model.item.dao;

import java.util.List;

import xeredi.argo.model.item.vo.ItemTramiteCriterioVO;
import xeredi.argo.model.item.vo.ItemTramiteVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ItemTramiteDAO.
 */
public interface ItemTramiteDAO {

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	List<ItemTramiteVO> selectList(final ItemTramiteCriterioVO criterio);

	/**
	 * Select object.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the item tramite VO
	 */
	ItemTramiteVO selectObject(final ItemTramiteCriterioVO criterio);

	/**
	 * Insert.
	 *
	 * @param vo
	 *            the vo
	 */
	void insert(final ItemTramiteVO vo);
}
