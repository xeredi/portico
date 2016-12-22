package xeredi.argo.model.facturacion.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.argo.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionVO;

// TODO: Auto-generated Javadoc
/**
 * DAO de acceso a las valoraciones de la aplicacion.
 */
public interface ValoracionDAO {

	/**
	 * Count.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the int
	 */
	int count(final ValoracionCriterioVO criterio);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @param bounds
	 *            the bounds
	 * @return the list
	 */
	List<ValoracionVO> selectList(final ValoracionCriterioVO criterio, final RowBounds bounds);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	List<ValoracionVO> selectList(final ValoracionCriterioVO criterio);

	/**
	 * Select object.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the valoracion VO
	 */
	ValoracionVO selectObject(final ValoracionCriterioVO criterio);

	/**
	 * Insert.
	 *
	 * @param vo
	 *            the vo
	 */
	void insert(final ValoracionVO vo);

	/**
	 * Update.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int update(final ValoracionVO vo);

	/**
	 * Delete list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the int
	 */
	int deleteList(final ValoracionCriterioVO criterio);

	/**
	 * Update fctr.
	 *
	 * @param vlrc
	 *            the vlrc
	 * @return the int
	 */
	int updateFctr(final ValoracionVO vlrc);

	/**
	 * Update importe.
	 *
	 * @param id
	 *            the id
	 * @return the int
	 */
	int updateImporte(final Long id);
}
