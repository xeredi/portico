package xeredi.integra.model.facturacion.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.facturacion.vo.AspectoCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoTypeaheadCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoVO;
import xeredi.integra.model.facturacion.vo.FacturadorContextoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface AspectoDAO.
 */
public interface AspectoDAO {

    /**
     * Select list.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the list
     */
    List<AspectoVO> selectList(final AspectoCriterioVO criterioVO);

    /**
     * Select list.
     *
     * @param criterio
     *            the criterio
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<AspectoVO> selectList(final AspectoCriterioVO criterio, final RowBounds bounds);

    /**
     * Select list.
     *
     * @param criterio
     *            the criterio
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<AspectoVO> selectList(final AspectoTypeaheadCriterioVO criterio, final RowBounds bounds);

    /**
     * Count.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the int
     */
    int count(final AspectoCriterioVO criterioVO);

    /**
     * Select object.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the aspecto vo
     */
    AspectoVO selectObject(final AspectoCriterioVO criterioVO);

    /**
     * Checks if is inaplicable.
     *
     * @param contextoVO
     *            the contexto vo
     * @return true, if checks if is inaplicable
     */
    boolean isInaplicable(final FacturadorContextoVO contextoVO);

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
     * Select id.
     *
     * @param aspc
     *            the aspc
     * @return the long
     */
    Long selectId(final AspectoVO aspc);

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
}
