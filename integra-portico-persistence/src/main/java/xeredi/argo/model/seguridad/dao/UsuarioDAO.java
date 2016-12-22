package xeredi.argo.model.seguridad.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import lombok.NonNull;
import xeredi.argo.model.seguridad.vo.UsuarioCriterioVO;
import xeredi.argo.model.seguridad.vo.UsuarioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface UsuarioDAO.
 */
public interface UsuarioDAO {

	/**
	 * Exists.
	 *
	 * @param usro
	 *            the usro
	 * @return true, if successful
	 */
	boolean exists(@NonNull final UsuarioVO usro);

	/**
	 * Insert.
	 *
	 * @param usro
	 *            the usro
	 */
	void insert(@NonNull final UsuarioVO usro);

	/**
	 * Update.
	 *
	 * @param usro
	 *            the usro
	 * @return the int
	 */
	int update(@NonNull final UsuarioVO usro);

	/**
	 * Delete.
	 *
	 * @param usro
	 *            the usro
	 * @return the int
	 */
	int delete(@NonNull final UsuarioVO usro);

	/**
	 * Count.
	 *
	 * @param usroCriterio
	 *            the usro criterio
	 * @return the int
	 */
	int count(@NonNull final UsuarioCriterioVO usroCriterio);

	/**
	 * Select list.
	 *
	 * @param usroCriterio
	 *            the usro criterio
	 * @param bounds
	 *            the bounds
	 * @return the list
	 */
	List<UsuarioVO> selectList(@NonNull final UsuarioCriterioVO usroCriterio, @NonNull final RowBounds bounds);

	/**
	 * Select object.
	 *
	 * @param usroCriterio
	 *            the usro criterio
	 * @return the usuario VO
	 */
	UsuarioVO selectObject(@NonNull final UsuarioCriterioVO usroCriterio);
}
