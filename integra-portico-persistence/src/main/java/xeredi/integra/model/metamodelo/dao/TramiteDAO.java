package xeredi.integra.model.metamodelo.dao;

import java.util.List;

import xeredi.integra.model.metamodelo.vo.TramiteCriterioVO;
import xeredi.integra.model.metamodelo.vo.TramiteVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface TramiteDAO.
 */
public interface TramiteDAO {

    /**
     * Exists.
     *
     * @param trmt
     *            the trmt
     * @return true, if successful
     */
    boolean exists(final TramiteVO trmt);

    /**
     * Insert.
     *
     * @param trmt
     *            the trmt
     */
    void insert(final TramiteVO trmt);

    /**
     * Update.
     *
     * @param trmt
     *            the trmt
     * @return the int
     */
    int update(final TramiteVO trmt);

    /**
     * Delete.
     *
     * @param trmt
     *            the trmt
     * @return the int
     */
    int delete(final TramiteVO trmt);

    /**
     * Select object.
     *
     * @param criterio
     *            the criterio
     * @return the tramite vo
     */
    TramiteVO selectObject(final TramiteCriterioVO criterio);

    /**
     * Select list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    List<TramiteVO> selectList(final TramiteCriterioVO criterio);
}
