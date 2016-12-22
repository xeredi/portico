package xeredi.argo.model.item.dao;

import java.util.List;

import xeredi.argo.model.item.vo.ItemTramiteCriterioVO;
import xeredi.argo.model.item.vo.ItemTramiteDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ItemTramiteDatoDAO.
 */
public interface ItemTramiteDatoDAO {

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	List<ItemTramiteDatoVO> selectList(final ItemTramiteCriterioVO criterio);

	/**
	 * Insert.
	 *
	 * @param vo
	 *            the vo
	 */
	void insert(final ItemTramiteDatoVO vo);
}
