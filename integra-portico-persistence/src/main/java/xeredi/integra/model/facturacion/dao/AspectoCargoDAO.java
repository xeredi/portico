package xeredi.integra.model.facturacion.dao;

import java.util.List;

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
    List<AspectoCargoVO> selectList(final AspectoCargoCriterioVO criterioVO);

    /**
     * Select object.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the aspecto cargo vo
     */
    AspectoCargoVO selectObject(final AspectoCargoCriterioVO criterioVO);

    /**
     * Exists.
     *
     * @param vo
     *            the vo
     * @return true, if successful
     */
    boolean exists(final AspectoCargoVO vo);

    /**
     * Exists overlap.
     *
     * @param vo
     *            the vo
     * @return true, if successful
     */
    boolean existsOverlap(final AspectoCargoVO vo);

    /**
     * Select id.
     *
     * @param vo
     *            the vo
     * @return the long
     */
    Long selectId(final AspectoCargoVO vo);

    /**
     * Insert.
     *
     * @param vo
     *            the vo
     */
    void insert(final AspectoCargoVO vo);

    /**
     * Insert version.
     *
     * @param vo
     *            the vo
     */
    void insertVersion(final AspectoCargoVO vo);

    /**
     * Update version.
     *
     * @param vo
     *            the vo
     * @return the int
     */
    int updateVersion(final AspectoCargoVO vo);

    /**
     * Delete version.
     *
     * @param vo
     *            the vo
     * @return the int
     */
    int deleteVersion(final AspectoCargoVO vo);

}
