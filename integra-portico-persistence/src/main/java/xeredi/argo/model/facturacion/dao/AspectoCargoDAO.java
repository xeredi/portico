package xeredi.argo.model.facturacion.dao;

import java.util.List;

import xeredi.argo.model.facturacion.vo.AspectoCargoCriterioVO;
import xeredi.argo.model.facturacion.vo.AspectoCargoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface AspectoCargoDAO.
 */
public interface AspectoCargoDAO {

    /**
     * Select list.
     *
     * @param ascrCriterio
     *            the ascr criterio
     * @return the list
     */
    List<AspectoCargoVO> selectList(final AspectoCargoCriterioVO ascrCriterio);

    /**
     * Select object.
     *
     * @param ascrCriterio
     *            the ascr criterio
     * @return the aspecto cargo VO
     */
    AspectoCargoVO selectObject(final AspectoCargoCriterioVO ascrCriterio);

    /**
     * Exists.
     *
     * @param ascr
     *            the ascr
     * @return true, if successful
     */
    boolean exists(final AspectoCargoVO ascr);

    /**
     * Exists overlap.
     *
     * @param ascr
     *            the ascr
     * @return true, if successful
     */
    boolean existsOverlap(final AspectoCargoVO ascr);

    /**
     * Insert.
     *
     * @param ascr
     *            the ascr
     */
    void insert(final AspectoCargoVO ascr);

    /**
     * Insert version.
     *
     * @param ascr
     *            the ascr
     */
    void insertVersion(final AspectoCargoVO ascr);

    /**
     * Update version.
     *
     * @param ascr
     *            the ascr
     * @return the int
     */
    int updateVersion(final AspectoCargoVO ascr);

    /**
     * Delete version.
     *
     * @param ascr
     *            the ascr
     * @return the int
     */
    int deleteVersion(final AspectoCargoVO ascr);

    /**
     * Select id.
     *
     * @param vo
     *            the vo
     * @return the long
     */
    Long selectId(final AspectoCargoVO vo);
}
