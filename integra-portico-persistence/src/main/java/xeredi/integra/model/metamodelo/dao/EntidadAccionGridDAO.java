package xeredi.integra.model.metamodelo.dao;

import java.util.List;

import xeredi.integra.model.metamodelo.vo.EntidadAccionGridCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadAccionGridVO;

// TODO: Auto-generated Javadoc
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
    boolean exists(final EntidadAccionGridVO enag);

    /**
     * Insert.
     *
     * @param enag
     *            the enag
     */
    void insert(final EntidadAccionGridVO enag);

    /**
     * Update.
     *
     * @param enag
     *            the enag
     * @return the int
     */
    int update(final EntidadAccionGridVO enag);

    /**
     * Delete.
     *
     * @param enag
     *            the enag
     * @return the int
     */
    int delete(final EntidadAccionGridVO enag);

    /**
     * Select object.
     *
     * @param enagCriterio
     *            the enag criterio
     * @return the entidad accion vo
     */
    EntidadAccionGridVO selectObject(final EntidadAccionGridCriterioVO enagCriterio);

    /**
     * Select list.
     *
     * @param enagCriterio
     *            the enag criterio
     * @return the list
     */
    List<EntidadAccionGridVO> selectList(final EntidadAccionGridCriterioVO enagCriterio);

    /**
     * Select all.
     *
     * @return the list
     */
    List<EntidadAccionGridVO> selectAll();

}
