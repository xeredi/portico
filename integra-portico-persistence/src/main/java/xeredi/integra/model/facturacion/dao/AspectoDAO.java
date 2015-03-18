package xeredi.integra.model.facturacion.dao;

import java.util.List;

import javax.annotation.Nonnull;

import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.facturacion.vo.AspectoCriterioVO;
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
    List<AspectoVO> selectList(final @Nonnull AspectoCriterioVO criterioVO);

    /**
     * Select list.
     *
     * @param criterioVO
     *            the criterio vo
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<AspectoVO> selectList(final @Nonnull AspectoCriterioVO criterioVO, final @Nonnull RowBounds bounds);

    /**
     * Count.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the int
     */
    int count(final @Nonnull AspectoCriterioVO criterioVO);

    /**
     * Select object.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the aspecto vo
     */
    AspectoVO selectObject(final @Nonnull AspectoCriterioVO criterioVO);

    /**
     * Checks if is inaplicable.
     *
     * @param contextoVO
     *            the contexto vo
     * @return true, if checks if is inaplicable
     */
    boolean isInaplicable(final @Nonnull FacturadorContextoVO contextoVO);

    /**
     * Exists.
     *
     * @param aspc
     *            the aspc
     * @return true, if successful
     */
    boolean exists(final @Nonnull AspectoVO aspc);

    /**
     * Exists overlap.
     *
     * @param aspc
     *            the aspc
     * @return true, if successful
     */
    boolean existsOverlap(final @Nonnull AspectoVO aspc);

    /**
     * Select id.
     *
     * @param aspc
     *            the aspc
     * @return the long
     */
    Long selectId(final @Nonnull AspectoVO aspc);

    /**
     * Insert.
     *
     * @param aspc
     *            the aspc
     */
    void insert(final @Nonnull AspectoVO aspc);

    /**
     * Insert version.
     *
     * @param aspc
     *            the aspc
     */
    void insertVersion(final @Nonnull AspectoVO aspc);

    /**
     * Update version.
     *
     * @param aspc
     *            the aspc
     * @return the int
     */
    int updateVersion(final @Nonnull AspectoVO aspc);
}
