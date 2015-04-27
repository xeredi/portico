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
     * @param enac
     *            the enac
     * @return true, if successful
     */
    boolean exists(final EntidadAccionVO enac);

    /**
     * Insert.
     *
     * @param enac
     *            the enac
     */
    void insert(final EntidadAccionVO enac);

    /**
     * Update.
     *
     * @param enac
     *            the enac
     * @return the int
     */
    int update(final EntidadAccionVO enac);

    /**
     * Delete.
     *
     * @param enac
     *            the enac
     * @return the int
     */
    int delete(final EntidadAccionVO enac);

    /**
     * Select.
     *
     * @param enacCriterio
     *            the enac criterio
     * @return the entidad accion vo
     */
    EntidadAccionVO selectObject(final EntidadAccionCriterioVO enacCriterio);

    /**
     * Select list.
     *
     * @param enacCriterio
     *            the enac criterio
     * @return the list
     */
    List<EntidadAccionVO> selectList(final EntidadAccionCriterioVO enacCriterio);

    /**
     * Select all.
     *
     * @return the list
     */
    List<EntidadAccionVO> selectAll();
}
