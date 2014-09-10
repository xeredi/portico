package xeredi.integra.model.metamodelo.dao;

import java.util.List;

import xeredi.integra.model.metamodelo.vo.EntidadEntidadCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadEntidadVO;

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
     * @param enenCriterioVO
     *            the enen criterio vo
     * @return the list
     */
    List<EntidadEntidadVO> selectList(final EntidadEntidadCriterioVO enenCriterioVO);

    /**
     * Select object.
     *
     * @param enenCriterioVO
     *            the enen criterio vo
     * @return the entidad entidad vo
     */
    EntidadEntidadVO selectObject(final EntidadEntidadCriterioVO enenCriterioVO);
}
