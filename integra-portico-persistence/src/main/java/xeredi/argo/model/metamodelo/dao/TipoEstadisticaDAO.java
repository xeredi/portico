package xeredi.argo.model.metamodelo.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.argo.model.metamodelo.vo.TipoEstadisticaCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoEstadisticaVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface TipoEstadisticaDAO.
 */
public interface TipoEstadisticaDAO {

	/**
	 * Count.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the int
	 */
	int count(final TipoEstadisticaCriterioVO criterio);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @param bounds
	 *            the bounds
	 * @return the list
	 */
	List<TipoEstadisticaVO> selectList(final TipoEstadisticaCriterioVO criterio, final RowBounds bounds);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	List<TipoEstadisticaVO> selectList(final TipoEstadisticaCriterioVO criterio);

	/**
	 * Select object.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the tipo estadistica VO
	 */
	TipoEstadisticaVO selectObject(final TipoEstadisticaCriterioVO criterio);

	/**
	 * Insert.
	 *
	 * @param vo
	 *            the vo
	 */
	void insert(final TipoEstadisticaVO vo);

	/**
	 * Delete.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int delete(final TipoEstadisticaVO vo);
}
