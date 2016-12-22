package xeredi.argo.model.facturacion.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.argo.model.facturacion.vo.FacturaCriterioVO;
import xeredi.argo.model.facturacion.vo.FacturaTypeaheadCriterioVO;
import xeredi.argo.model.facturacion.vo.FacturaVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface FacturaDAO.
 */
public interface FacturaDAO {

	/**
	 * Count.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the int
	 */
	int count(final FacturaCriterioVO criterio);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @param bounds
	 *            the bounds
	 * @return the list
	 */
	List<FacturaVO> selectList(final FacturaCriterioVO criterio, final RowBounds bounds);

	/**
	 * Select object.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the factura VO
	 */
	FacturaVO selectObject(final FacturaCriterioVO criterio);

	/**
	 * Insert.
	 *
	 * @param vo
	 *            the vo
	 */
	void insert(final FacturaVO vo);

	/**
	 * Update estado.
	 *
	 * @param fctr
	 *            the fctr
	 * @return the int
	 */
	int updateEstado(final FacturaVO fctr);

	/**
	 * Exists factura posterior.
	 *
	 * @param fctrId
	 *            the fctr id
	 * @return true, if successful
	 */
	boolean existsFacturaPosterior(final Long fctrId);

	/**
	 * Exists valoracion posterior.
	 *
	 * @param fctrId
	 *            the fctr id
	 * @return true, if successful
	 */
	boolean existsValoracionPosterior(final Long fctrId);

	/**
	 * Select typeahead list.
	 *
	 * @param criterio
	 *            the criterio
	 * @param bounds
	 *            the bounds
	 * @return the list
	 */
	List<FacturaVO> selectTypeaheadList(final FacturaTypeaheadCriterioVO criterio, final RowBounds bounds);
}
