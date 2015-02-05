package xeredi.integra.model.facturacion.dao;

import java.util.List;

import javax.annotation.Nonnull;

import xeredi.integra.model.facturacion.vo.AspectoCargoCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoCargoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface AspectoCargoDAO.
 */
public interface AspectoCargoDAO {

    /**
     * Select list.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the list
     */
    List<AspectoCargoVO> selectList(final @Nonnull AspectoCargoCriterioVO criterioVO);

    /**
     * Select object.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the aspecto cargo vo
     */
    AspectoCargoVO selectObject(final @Nonnull AspectoCargoCriterioVO criterioVO);

    /**
     * Exists.
     *
     * @param vo
     *            the vo
     * @return true, if successful
     */
    boolean exists(final @Nonnull AspectoCargoVO vo);

    /**
     * Exists overlap.
     *
     * @param vo
     *            the vo
     * @return true, if successful
     */
    boolean existsOverlap(final @Nonnull AspectoCargoVO vo);

    /**
     * Select id.
     *
     * @param vo
     *            the vo
     * @return the long
     */
    Long selectId(final @Nonnull AspectoCargoVO vo);

    /**
     * Insert.
     *
     * @param vo
     *            the vo
     */
    void insert(final @Nonnull AspectoCargoVO vo);

    /**
     * Insert version.
     *
     * @param vo
     *            the vo
     */
    void insertVersion(final @Nonnull AspectoCargoVO vo);

    /**
     * Update version.
     *
     * @param vo
     *            the vo
     * @return the int
     */
    int updateVersion(final @Nonnull AspectoCargoVO vo);

    /**
     * Delete version.
     *
     * @param vo
     *            the vo
     * @return the int
     */
    int deleteVersion(final @Nonnull AspectoCargoVO vo);

}
