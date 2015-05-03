package xeredi.integra.model.metamodelo.dao;

import java.util.List;

import xeredi.integra.model.metamodelo.vo.TramiteTipoDatoCriterioVO;
import xeredi.integra.model.metamodelo.vo.TramiteTipoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface TramiteTipoDatoDAO.
 */
public interface TramiteTipoDatoDAO {

    /**
     * Exists.
     *
     * @param trtd
     *            the trtd
     * @return true, if successful
     */
    boolean exists(final TramiteTipoDatoVO trtd);

    /**
     * Insert.
     *
     * @param trtd
     *            the trtd
     */
    void insert(final TramiteTipoDatoVO trtd);

    /**
     * Update.
     *
     * @param trtd
     *            the trtd
     * @return the int
     */
    int update(final TramiteTipoDatoVO trtd);

    /**
     * Delete.
     *
     * @param trtd
     *            the trtd
     * @return the int
     */
    int delete(final TramiteTipoDatoVO trtd);

    /**
     * Select list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    List<TramiteTipoDatoVO> selectList(final TramiteTipoDatoCriterioVO criterio);

    /**
     * Select object.
     *
     * @param criterio
     *            the criterio
     * @return the tramite tipo dato vo
     */
    TramiteTipoDatoVO selectObject(final TramiteTipoDatoCriterioVO criterio);
}
