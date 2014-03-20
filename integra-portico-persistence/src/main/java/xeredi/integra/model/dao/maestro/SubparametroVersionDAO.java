package xeredi.integra.model.dao.maestro;

import xeredi.integra.model.vo.maestro.SubparametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface SubparametroVersionDAO.
 */
public interface SubparametroVersionDAO {

    /**
     * Insert.
     * 
     * @param sprmVO
     *            the sprm vo
     */
    void insert(final SubparametroVO sprmVO);

    /**
     * Update.
     * 
     * @param sprmVO
     *            the sprm vo
     * @return the int
     */
    int update(final SubparametroVO sprmVO);

    /**
     * Update delete.
     * 
     * @param sprmVO
     *            the sprm vo
     * @return the int
     */
    int updateDelete(final SubparametroVO sprmVO);

    /**
     * Exists solape.
     * 
     * @param sprmVO
     *            the sprm vo
     * @return true, if successful
     */
    boolean existsSolape(final SubparametroVO sprmVO);

    /**
     * Exists desborde.
     * 
     * @param sprmVO
     *            the sprm vo
     * @return true, if successful
     */
    boolean existsDesborde(final SubparametroVO sprmVO);
}
