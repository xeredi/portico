package xeredi.argo.model.metamodelo.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.argo.model.metamodelo.vo.AccionEntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface AccionEntidadDAO.
 */
public interface AccionEntidadDAO {

	/**
	 * Count.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the int
	 */
	int count(final AccionEntidadCriterioVO criterio);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @param bounds
	 *            the bounds
	 * @return the list
	 */
	List<AccionEntidadVO> selectList(final AccionEntidadCriterioVO criterio, final RowBounds bounds);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	List<AccionEntidadVO> selectList(final AccionEntidadCriterioVO criterio);

	/**
	 * Select object.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the accion entidad VO
	 */
	AccionEntidadVO selectObject(final AccionEntidadCriterioVO criterio);

	/**
	 * Exists.
	 *
	 * @param vo
	 *            the vo
	 * @return true, if successful
	 */
	boolean exists(final AccionEntidadVO vo);

	/**
	 * Insert.
	 *
	 * @param vo
	 *            the vo
	 */
	void insert(final AccionEntidadVO vo);

	/**
	 * Update.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int update(final AccionEntidadVO vo);

	/**
	 * Delete.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int delete(final AccionEntidadVO vo);
}
