package xeredi.argo.model.facturacion.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.argo.model.facturacion.vo.AspectoCriterioVO;
import xeredi.argo.model.facturacion.vo.AspectoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface AspectoDAO.
 */
public interface AspectoDAO {

    /**
     * Count.
     *
     * @param aspcCriterio
     *            the aspc criterio
     * @return the int
     */
    int count(final AspectoCriterioVO aspcCriterio);

    /**
     * Select list.
     *
     * @param aspcCriterio
     *            the aspc criterio
     * @return the list
     */
    List<AspectoVO> selectList(final AspectoCriterioVO aspcCriterio);

    /**
     * Select list.
     *
     * @param aspcCriterio
     *            the aspc criterio
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<AspectoVO> selectList(final AspectoCriterioVO aspcCriterio, final RowBounds bounds);

    /**
     * Select object.
     *
     * @param aspcCriterio
     *            the aspc criterio
     * @return the aspecto VO
     */
    AspectoVO selectObject(final AspectoCriterioVO aspcCriterio);

    /**
     * Exists.
     *
     * @param aspc
     *            the aspc
     * @return true, if successful
     */
    boolean exists(final AspectoVO aspc);

    /**
     * Exists overlap.
     *
     * @param aspc
     *            the aspc
     * @return true, if successful
     */
    boolean existsOverlap(final AspectoVO aspc);

    /**
     * Insert.
     *
     * @param aspc
     *            the aspc
     */
    void insert(final AspectoVO aspc);

    /**
     * Insert version.
     *
     * @param aspc
     *            the aspc
     */
    void insertVersion(final AspectoVO aspc);

    /**
     * Update version.
     *
     * @param aspc
     *            the aspc
     * @return the int
     */
    int updateVersion(final AspectoVO aspc);

    /**
     * Delete version.
     *
     * @param aspc
     *            the aspc
     * @return the int
     */
    int deleteVersion(final AspectoVO aspc);

    /**
     * Select id.
     *
     * @param aspc
     *            the aspc
     * @return the long
     */
    Long selectId(final AspectoVO aspc);
}
