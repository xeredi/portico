package xeredi.integra.model.metamodelo.dao;

import java.util.List;

import javax.annotation.Nonnull;

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
    boolean exists(final @Nonnull EntidadEntidadVO enenVO);

    /**
     * Insert.
     *
     * @param enenVO
     *            the enen vo
     */
    void insert(final @Nonnull EntidadEntidadVO enenVO);

    /**
     * Update.
     *
     * @param enenVO
     *            the enen vo
     * @return the int
     */
    int update(final @Nonnull EntidadEntidadVO enenVO);

    /**
     * Delete.
     *
     * @param enenVO
     *            the enen vo
     * @return the int
     */
    int delete(final @Nonnull EntidadEntidadVO enenVO);

    /**
     * Select list.
     *
     * @param enenCriterioVO
     *            the enen criterio vo
     * @return the list
     */
    List<EntidadEntidadVO> selectList(final @Nonnull EntidadEntidadCriterioVO enenCriterioVO);

    /**
     * Select object.
     *
     * @param enenCriterioVO
     *            the enen criterio vo
     * @return the entidad entidad vo
     */
    EntidadEntidadVO selectObject(final @Nonnull EntidadEntidadCriterioVO enenCriterioVO);
}
