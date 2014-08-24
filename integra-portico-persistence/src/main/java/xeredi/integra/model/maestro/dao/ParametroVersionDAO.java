package xeredi.integra.model.maestro.dao;

import xeredi.integra.model.maestro.vo.ParametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ParametroVersionDAO.
 */
public interface ParametroVersionDAO {

    /**
     * Insert.
     * 
     * @param prmtVO
     *            the prmt vo
     */
    void insert(final ParametroVO prmtVO);

    /**
     * Update delete.
     * 
     * @param prmtVO
     *            the prmt vo
     * @return the int
     */
    int updateDelete(final ParametroVO prmtVO);

    /**
     * Exists solape.
     * 
     * @param prmtVO
     *            the prmt vo
     * @return true, if successful
     */
    boolean existsSolape(final ParametroVO prmtVO);
}