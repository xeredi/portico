package xeredi.argo.model.comun.dao;

import xeredi.argo.model.comun.vo.IgVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface IgDAO.
 */
public interface IgDAO {

    /**
     * Select.
     *
     * @param nombre
     *            the nombre
     * @return the ig vo
     */
    public IgVO select(final String nombre);

    /**
     * Update.
     *
     * @param nombre
     *            the nombre
     * @return the int
     */
    public int update(final String nombre);
}
