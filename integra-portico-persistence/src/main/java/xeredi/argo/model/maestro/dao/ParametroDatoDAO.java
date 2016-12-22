package xeredi.argo.model.maestro.dao;

import java.util.List;

import xeredi.argo.model.item.vo.ItemDatoVO;
import xeredi.argo.model.maestro.vo.ParametroCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ParametroDatoDAO.
 */
public interface ParametroDatoDAO {

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	List<ItemDatoVO> selectList(final ParametroCriterioVO criterio);

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
	 * Delete list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the int
	 */
	int deleteList(final ParametroCriterioVO criterio);
}
