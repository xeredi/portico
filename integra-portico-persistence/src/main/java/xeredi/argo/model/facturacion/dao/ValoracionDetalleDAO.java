package xeredi.argo.model.facturacion.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.argo.model.facturacion.vo.ValoracionDetalleCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionDetalleVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ValoracionDetalleDAO.
 */
public interface ValoracionDetalleDAO {

	/**
	 * Count.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the int
	 */
	int count(final ValoracionDetalleCriterioVO criterio);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @param bounds
	 *            the bounds
	 * @return the list
	 */
	List<ValoracionDetalleVO> selectList(final ValoracionDetalleCriterioVO criterio, final RowBounds bounds);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	List<ValoracionDetalleVO> selectList(final ValoracionDetalleCriterioVO criterio);

	/**
	 * Select object.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the valoracion detalle VO
	 */
	ValoracionDetalleVO selectObject(final ValoracionDetalleCriterioVO criterio);

	/**
	 * Insert.
	 *
	 * @param vo
	 *            the vo
	 */
	void insert(final ValoracionDetalleVO vo);

	/**
	 * Update.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int update(final ValoracionDetalleVO vo);

	/**
	 * Delete.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int delete(final ValoracionDetalleVO vo);

	/**
	 * Delete list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the int
	 */
	int deleteList(final ValoracionDetalleCriterioVO criterio);
}
