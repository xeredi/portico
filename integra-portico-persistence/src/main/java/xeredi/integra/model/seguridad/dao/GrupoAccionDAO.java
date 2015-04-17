package xeredi.integra.model.seguridad.dao;

import xeredi.integra.model.seguridad.vo.GrupoAccionVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface GrupoAccionDAO.
 */
public interface GrupoAccionDAO {

    /**
     * Exists.
     *
     * @param grac
     *            the grac
     * @return true, if successful
     */
    boolean exists(final GrupoAccionVO grac);

    /**
     * Insert.
     *
     * @param grac
     *            the grac
     */
    void insert(final GrupoAccionVO grac);

    /**
     * Delete.
     *
     * @param grac
     *            the grac
     * @return the int
     */
    int delete(final GrupoAccionVO grac);
}
