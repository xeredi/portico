package xeredi.argo.model.maestro.dao;

import java.util.List;

import xeredi.argo.model.item.vo.ItemDatoVO;
import xeredi.argo.model.maestro.vo.SubparametroCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface SubparametroDatoDAO.
 */
public interface SubparametroDatoDAO {

	/**
	 * Insert.
	 *
	 * @param vo
	 *            the vo
	 */
	void insert(final ItemDatoVO vo);

	/**
	 * Update.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int update(final ItemDatoVO vo);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	List<ItemDatoVO> selectList(final SubparametroCriterioVO criterio);

	/**
	 * Delete list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the int
	 */
	int deleteList(final SubparametroCriterioVO criterio);
}
