package xeredi.integra.model.metamodelo.dao;

import java.util.List;

import xeredi.integra.model.metamodelo.vo.EntidadAccionCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadAccionVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface EntidadAccionDAO.
 */
public interface EntidadAccionDAO {

    /**
     * Exists.
     *
     * @param enacVO
     *            the enac vo
     * @return true, if successful
     */
    boolean exists(final EntidadAccionVO enacVO);

    /**
     * Insert.
     *
     * @param enacVO
     *            the enac vo
     */
    void insert(final EntidadAccionVO enacVO);

    /**
     * Update.
     *
     * @param enacVO
     *            the enac vo
     * @return the int
     */
    int update(final EntidadAccionVO enacVO);

    /**
     * Delete.
     *
     * @param enacId
     *            the enac id
     * @return the int
     */
    int delete(final Long enacId);

    /**
     * Select.
     *
     * @param enacCriterioVO
     *            the enac criterio vo
     * @return the entidad accion vo
     */
    EntidadAccionVO selectObject(final EntidadAccionCriterioVO enacCriterioVO);

    /**
     * Select list.
     *
     * @param enacCriterioVO
     *            the enac criterio vo
     * @return the list
     */
    List<EntidadAccionVO> selectList(final EntidadAccionCriterioVO enacCriterioVO);

    /**
     * Select all.
     *
     * @return the list
     */
    List<EntidadAccionVO> selectAll();
}
