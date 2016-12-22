package xeredi.argo.model.estadistica.dao;

import java.util.List;

import xeredi.argo.model.estadistica.vo.EstadisticaCriterioVO;
import xeredi.argo.model.item.vo.ItemDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface EstadisticaDatoDAO.
 */
public interface EstadisticaDatoDAO {

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	List<ItemDatoVO> selectList(final EstadisticaCriterioVO criterio);

	void insert(final ItemDatoVO vo);

	int deleteList(final EstadisticaCriterioVO criterio);
}
