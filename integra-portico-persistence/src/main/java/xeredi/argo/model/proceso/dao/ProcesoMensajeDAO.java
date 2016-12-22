package xeredi.argo.model.proceso.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.argo.model.proceso.vo.ProcesoMensajeCriterioVO;
import xeredi.argo.model.proceso.vo.ProcesoMensajeVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ProcesoMensajeDAO.
 */
public interface ProcesoMensajeDAO {

	/**
	 * Count.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the int
	 */
	int count(final ProcesoMensajeCriterioVO criterio);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @param bounds
	 *            the bounds
	 * @return the list
	 */
	List<ProcesoMensajeVO> selectList(final ProcesoMensajeCriterioVO criterio, final RowBounds bounds);

	/**
	 * Insert.
	 *
	 * @param vo
	 *            the vo
	 */
	void insert(final ProcesoMensajeVO vo);

	/**
	 * Delete list.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int deleteList(final ProcesoMensajeCriterioVO vo);
}
