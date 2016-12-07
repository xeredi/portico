package xeredi.argo.model.metamodelo.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import lombok.NonNull;
import xeredi.argo.model.metamodelo.vo.AccionEspecialCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionEspecialVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface AccionEspecialDAO.
 */
public interface AccionEspecialDAO {

	/**
	 * Count.
	 *
	 * @param acesCriterio
	 *            the aces criterio
	 * @return the int
	 */
	int count(final @NonNull AccionEspecialCriterioVO acesCriterio);

	/**
	 * Select list.
	 *
	 * @param acesCriterio
	 *            the aces criterio
	 * @return the list
	 */
	List<AccionEspecialVO> selectList(final @NonNull AccionEspecialCriterioVO acesCriterio);

	/**
	 * Select list.
	 *
	 * @param acesCriterio
	 *            the aces criterio
	 * @param bounds
	 *            the bounds
	 * @return the list
	 */
	List<AccionEspecialVO> selectList(final @NonNull AccionEspecialCriterioVO acesCriterio, final RowBounds bounds);

	/**
	 * Select object.
	 *
	 * @param acesCriterio
	 *            the aces criterio
	 * @return the accion especial VO
	 */
	AccionEspecialVO selectObject(final @NonNull AccionEspecialCriterioVO acesCriterio);

	/**
	 * Exists.
	 *
	 * @param aces
	 *            the aces
	 * @return true, if successful
	 */
	boolean exists(final @NonNull AccionEspecialVO aces);

	/**
	 * Insert.
	 *
	 * @param aces
	 *            the aces
	 */
	void insert(final @NonNull AccionEspecialVO aces);

	/**
	 * Update.
	 *
	 * @param aces
	 *            the aces
	 * @return the int
	 */
	int update(final @NonNull AccionEspecialVO aces);

	/**
	 * Delete.
	 *
	 * @param aces
	 *            the aces
	 * @return the int
	 */
	int delete(final @NonNull AccionEspecialVO aces);
}
