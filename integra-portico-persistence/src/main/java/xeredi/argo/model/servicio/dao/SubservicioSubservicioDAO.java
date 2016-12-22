package xeredi.argo.model.servicio.dao;

import java.util.List;

import xeredi.argo.model.servicio.vo.SubservicioSubservicioCriterioVO;
import xeredi.argo.model.servicio.vo.SubservicioSubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface SubservicioSubservicioDAO.
 */
public interface SubservicioSubservicioDAO {

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	List<SubservicioSubservicioVO> selectList(final SubservicioSubservicioCriterioVO criterio);

	/**
	 * Insert.
	 *
	 * @param vo
	 *            the vo
	 */
	void insert(final SubservicioSubservicioVO vo);

	/**
	 * Delete list.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int deleteList(final SubservicioSubservicioCriterioVO vo);
}
