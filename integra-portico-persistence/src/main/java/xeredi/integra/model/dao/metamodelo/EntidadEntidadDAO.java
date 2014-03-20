package xeredi.integra.model.dao.metamodelo;

import java.util.List;

import xeredi.integra.model.vo.metamodelo.EntidadEntidadVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface EntidadEntidadDAO.
 */
public interface EntidadEntidadDAO {

    /**
     * Exists.
     * 
     * @param enenVO
     *            the enen vo
     * @return true, if successful
     */
    boolean exists(final EntidadEntidadVO enenVO);

    /**
     * Insert.
     * 
     * @param enenVO
     *            the enen vo
     */
    void insert(final EntidadEntidadVO enenVO);

    /**
     * Update.
     * 
     * @param enenVO
     *            the enen vo
     * @return the int
     */
    int update(final EntidadEntidadVO enenVO);

    /**
     * Delete.
     * 
     * @param enenVO
     *            the enen vo
     * @return the int
     */
    int delete(final EntidadEntidadVO enenVO);

    /**
     * Select list.
     * 
     * @return the list
     */
    List<EntidadEntidadVO> selectList();
}
