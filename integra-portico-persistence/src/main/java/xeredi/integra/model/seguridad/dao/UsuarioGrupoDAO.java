package xeredi.integra.model.seguridad.dao;

import xeredi.integra.model.seguridad.vo.UsuarioGrupoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface UsuarioGrupoDAO.
 */
public interface UsuarioGrupoDAO {

    /**
     * Exists.
     *
     * @param usgr
     *            the usgr
     * @return true, if successful
     */
    boolean exists(final UsuarioGrupoVO usgr);

    /**
     * Insert.
     *
     * @param usgr
     *            the usgr
     */
    void insert(final UsuarioGrupoVO usgr);

    /**
     * Delete.
     *
     * @param usgr
     *            the usgr
     * @return the int
     */
    int delete(final UsuarioGrupoVO usgr);
}
