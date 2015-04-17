package xeredi.integra.model.seguridad.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.seguridad.vo.UsuarioCriterioVO;
import xeredi.integra.model.seguridad.vo.UsuarioVO;

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
    boolean exists(final UsuarioVO usro);

    /**
     * Insert.
     *
     * @param usro
     *            the usro
     */
    void insert(final UsuarioVO usro);

    /**
     * Update.
     *
     * @param usro
     *            the usro
     * @return the int
     */
    int update(final UsuarioVO usro);

    /**
     * Delete.
     *
     * @param usro
     *            the usro
     * @return the int
     */
    int delete(final UsuarioVO usro);

    /**
     * Select object.
     *
     * @param usroCriterio
     *            the usro criterio
     * @return the usuario vo
     */
    UsuarioVO selectObject(final UsuarioCriterioVO usroCriterio);

    /**
     * Count.
     *
     * @param usroCriterio
     *            the usro criterio
     * @return the int
     */
    int count(final UsuarioCriterioVO usroCriterio);

    /**
     * Select list.
     *
     * @param usroCriterio
     *            the usro criterio
     * @param bounds
     *            the bounds
     * @return the usuario vo
     */
    List<UsuarioVO> selectList(final UsuarioCriterioVO usroCriterio, final RowBounds bounds);

    /**
     * Select list.
     *
     * @param usroCriterio
     *            the usro criterio
     * @return the usuario vo
     */
    List<UsuarioVO> selectList(final UsuarioCriterioVO usroCriterio);
}
