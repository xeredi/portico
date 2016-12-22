package xeredi.argo.model.facturacion.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.argo.model.facturacion.vo.FacturaSerieCriterioVO;
import xeredi.argo.model.facturacion.vo.FacturaSerieVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface FacturaSerieDAO.
 */
public interface FacturaSerieDAO {

	/**
	 * Count.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the int
	 */
	int count(final FacturaSerieCriterioVO criterio);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @param bounds
	 *            the bounds
	 * @return the list
	 */
	List<FacturaSerieVO> selectList(final FacturaSerieCriterioVO criterio, final RowBounds bounds);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	List<FacturaSerieVO> selectList(final FacturaSerieCriterioVO criterio);

	/**
	 * Select object.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the factura serie VO
	 */
	FacturaSerieVO selectObject(final FacturaSerieCriterioVO criterio);

	/**
	 * Exists.
	 *
	 * @param vo
	 *            the vo
	 * @return true, if successful
	 */
	boolean exists(final FacturaSerieVO vo);

	/**
	 * Insert.
	 *
	 * @param vo
	 *            the vo
	 */
	void insert(final FacturaSerieVO vo);

	/**
	 * Update.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int update(final FacturaSerieVO vo);

	/**
	 * Delete.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int delete(final FacturaSerieVO vo);

	/**
	 * Update incrementar.
	 *
	 * @param id
	 *            the id
	 * @return the int
	 */
	int updateIncrementar(final Long id);
}
