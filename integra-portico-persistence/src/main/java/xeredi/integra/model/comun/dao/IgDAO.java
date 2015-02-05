package xeredi.integra.model.comun.dao;

import javax.annotation.Nonnull;

import xeredi.integra.model.comun.vo.IgVO;

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
    public IgVO select(final @Nonnull String nombre);

    /**
     * Update.
     *
     * @param nombre
     *            the nombre
     * @return the int
     */
    public int update(final @Nonnull String nombre);
}
