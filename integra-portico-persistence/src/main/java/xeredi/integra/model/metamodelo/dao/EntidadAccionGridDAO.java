package xeredi.integra.model.metamodelo.dao;

import java.util.List;

import javax.annotation.Nonnull;

import xeredi.integra.model.metamodelo.vo.EntidadAccionGridCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadAccionGridVO;

/**
 * The Interface EntidadAccionGridDAO.
 */
public interface EntidadAccionGridDAO {

    /**
     * Exists.
     *
     * @param enag
     *            the enag
     * @return true, if successful
     */
    boolean exists(final @Nonnull EntidadAccionGridVO enag);

    /**
     * Insert.
     *
     * @param enag
     *            the enag
     */
    void insert(final @Nonnull EntidadAccionGridVO enag);

    /**
     * Update.
     *
     * @param enag
     *            the enag
     * @return the int
     */
    int update(final @Nonnull EntidadAccionGridVO enag);

    /**
     * Delete.
     *
     * @param enagId
     *            the enag id
     * @return the int
     */
    int delete(final @Nonnull Long enagId);

    /**
     * Select object.
     *
     * @param enagCriterio
     *            the enag criterio
     * @return the entidad accion vo
     */
    EntidadAccionGridVO selectObject(final @Nonnull EntidadAccionGridCriterioVO enagCriterio);

    /**
     * Select list.
     *
     * @param enagCriterio
     *            the enag criterio
     * @return the list
     */
    List<EntidadAccionGridVO> selectList(final @Nonnull EntidadAccionGridCriterioVO enagCriterio);

    /**
     * Select all.
     *
     * @return the list
     */
    List<EntidadAccionGridVO> selectAll();

}
