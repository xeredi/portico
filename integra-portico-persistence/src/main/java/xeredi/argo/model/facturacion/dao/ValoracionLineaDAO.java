package xeredi.argo.model.facturacion.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.argo.model.facturacion.vo.ValoracionLineaCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ValoracionLineaDAO.
 */
public interface ValoracionLineaDAO {

	/**
	 * Count.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the int
	 */
	int count(final ValoracionLineaCriterioVO criterio);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @param bounds
	 *            the bounds
	 * @return the list
	 */
	List<ValoracionLineaVO> selectList(final ValoracionLineaCriterioVO criterio, final RowBounds bounds);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	List<ValoracionLineaVO> selectList(final ValoracionLineaCriterioVO criterio);

	/**
	 * Select object.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the valoracion linea VO
	 */
	ValoracionLineaVO selectObject(final ValoracionLineaCriterioVO criterio);

	/**
	 * Insert.
	 *
	 * @param vo
	 *            the vo
	 */
	void insert(final ValoracionLineaVO vo);

	/**
	 * Update.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int update(final ValoracionLineaVO vo);

	/**
	 * Delete list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the int
	 */
	int deleteList(final ValoracionLineaCriterioVO criterio);

	/**
	 * Exists dependencia.
	 *
	 * @param vlrlId
	 *            the vlrl id
	 * @return true, if successful
	 */
	boolean existsDependencia(final Long vlrlId);

	/**
	 * Checks if is regla valida.
	 *
	 * @param vlrl
	 *            the vlrl
	 * @return true, if is regla valida
	 */
	boolean isRglaValida(final ValoracionLineaVO vlrl);
}
