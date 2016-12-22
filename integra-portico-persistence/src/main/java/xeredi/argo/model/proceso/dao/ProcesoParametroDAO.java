package xeredi.argo.model.proceso.dao;

import java.util.List;

import xeredi.argo.model.proceso.vo.ProcesoCriterioVO;
import xeredi.argo.model.proceso.vo.ProcesoParametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ProcesoParametroDAO.
 */
public interface ProcesoParametroDAO {

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	List<ProcesoParametroVO> selectList(final ProcesoCriterioVO criterio);

	/**
	 * Insert.
	 *
	 * @param vo
	 *            the vo
	 */
	void insert(final ProcesoParametroVO vo);

	/**
	 * Delete list.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int deleteList(final ProcesoCriterioVO vo);
}
