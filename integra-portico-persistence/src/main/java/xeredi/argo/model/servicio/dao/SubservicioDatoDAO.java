package xeredi.argo.model.servicio.dao;

import java.util.List;

import xeredi.argo.model.item.vo.ItemDatoVO;
import xeredi.argo.model.servicio.vo.SubservicioCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface SubservicioDatoDAO.
 */
public interface SubservicioDatoDAO {

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	List<ItemDatoVO> selectList(final SubservicioCriterioVO criterio);

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
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int deleteList(final SubservicioCriterioVO vo);
}
