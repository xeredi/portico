package xeredi.integra.model.seguridad.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.seguridad.vo.AccionCriterioVO;
import xeredi.integra.model.seguridad.vo.AccionVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface AccionDAO.
 */
public interface AccionDAO {

    /**
     * Exists.
     *
     * @param accn
     *            the accn
     * @return true, if successful
     */
    boolean exists(final AccionVO accn);

    /**
     * Exists.
     *
     * @param accnCriterio
     *            the accn criterio
     * @return true, if successful
     */
    boolean exists(final AccionCriterioVO accnCriterio);

    /**
     * Insert.
     *
     * @param accn
     *            the accn
     */
    void insert(final AccionVO accn);

    /**
     * Update.
     *
     * @param accn
     *            the accn
     * @return the int
     */
    int update(final AccionVO accn);

    /**
     * Delete.
     *
     * @param accn
     *            the accn
     * @return the int
     */
    int delete(final AccionVO accn);

    /**
     * Select object.
     *
     * @param accnCriterio
     *            the accn criterio
     * @return the accion vo
     */
    AccionVO selectObject(final AccionCriterioVO accnCriterio);

    /**
     * Select list.
     *
     * @param accnCriterio
     *            the accn criterio
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<AccionVO> selectList(final AccionCriterioVO accnCriterio, final RowBounds bounds);

    /**
     * Select list.
     *
     * @param accnCriterio
     *            the accn criterio
     * @return the list
     */
    List<AccionVO> selectList(final AccionCriterioVO accnCriterio);

    /**
     * Count.
     *
     * @param accnCriterio
     *            the accn criterio
     * @return the int
     */
    int count(final AccionCriterioVO accnCriterio);
}
