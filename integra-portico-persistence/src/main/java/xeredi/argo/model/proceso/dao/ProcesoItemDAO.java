package xeredi.argo.model.proceso.dao;

import java.util.List;

import xeredi.argo.model.proceso.vo.ProcesoItemCriterioVO;
import xeredi.argo.model.proceso.vo.ProcesoItemVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ProcesoItemDAO.
 */
public interface ProcesoItemDAO {

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	List<ProcesoItemVO> selectList(final ProcesoItemCriterioVO criterio);

	/**
	 * Insert.
	 *
	 * @param vo
	 *            the vo
	 */
	void insert(final ProcesoItemVO vo);

	/**
	 * Delete list.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int deleteList(final ProcesoItemCriterioVO vo);
}
