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
    boolean exists(final @NonNull UsuarioVO usro);

    /**
     * Insert.
     *
     * @param usro
     *            the usro
     */
    void insert(final @NonNull UsuarioVO usro);

    /**
     * Update.
     *
     * @param usro
     *            the usro
     * @return the int
     */
    int update(final @NonNull UsuarioVO usro);

    /**
     * Delete.
     *
     * @param usro
     *            the usro
     * @return the int
     */
    int delete(final @NonNull UsuarioVO usro);

    /**
     * Count.
     *
     * @param usroCriterio
     *            the usro criterio
     * @return the int
     */
    int count(final @NonNull UsuarioCriterioVO usroCriterio);

    /**
     * Select list.
     *
     * @param usroCriterio
     *            the usro criterio
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<UsuarioVO> selectList(final @NonNull UsuarioCriterioVO usroCriterio, final @NonNull RowBounds bounds);

    /**
     * Select object.
     *
     * @param usroCriterio
     *            the usro criterio
     * @return the usuario VO
     */
    UsuarioVO selectObject(final @NonNull UsuarioCriterioVO usroCriterio);
}
