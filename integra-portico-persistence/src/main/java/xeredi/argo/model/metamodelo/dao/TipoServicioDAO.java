package xeredi.argo.model.metamodelo.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.argo.model.metamodelo.vo.TipoServicioCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface TipoServicioDAO.
 */
public interface TipoServicioDAO {

	/**
	 * Count.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the int
	 */
	int count(final TipoServicioCriterioVO criterio);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @param bounds
	 *            the bounds
	 * @return the list
	 */
	List<TipoServicioVO> selectList(final TipoServicioCriterioVO criterio, final RowBounds bounds);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	List<TipoServicioVO> selectList(final TipoServicioCriterioVO criterio);

	/**
	 * Select object.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the tipo servicio VO
	 */
	TipoServicioVO selectObject(final TipoServicioCriterioVO criterio);

	/**
	 * Insert.
	 *
	 * @param vo
	 *            the vo
	 */
	void insert(final TipoServicioVO vo);

	/**
	 * Update.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int update(final TipoServicioVO vo);

	/**
	 * Delete.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int delete(final TipoServicioVO vo);
}
