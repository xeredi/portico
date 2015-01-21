package xeredi.integra.model.metamodelo.dao;

import java.util.List;

import xeredi.integra.model.metamodelo.vo.CampoAgregacionCriterioVO;
import xeredi.integra.model.metamodelo.vo.CampoAgregacionVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface CampoAgregacionDAO.
 */
public interface CampoAgregacionDAO {

    /**
     * Exists.
     *
     * @param vo
     *            the vo
     * @return true, if successful
     */
    boolean exists(final CampoAgregacionVO vo);

    /**
     * Insert.
     *
     * @param vo
     *            the vo
     */
    void insert(final CampoAgregacionVO vo);

    /**
     * Update.
     *
     * @param vo
     *            the vo
     * @return the int
     */
    int update(final CampoAgregacionVO vo);

    /**
     * Delete.
     *
     * @param vo
     *            the vo
     * @return the int
     */
    int delete(final CampoAgregacionVO vo);

    /**
     * Select list.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the list
     */
    List<CampoAgregacionVO> selectList(final CampoAgregacionCriterioVO criterioVO);

    /**
     * Select all.
     *
     * @return the list
     */
    List<CampoAgregacionVO> selectAll();

    /**
     * Select object.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the campo agregacion vo
     */
    CampoAgregacionVO selectObject(final CampoAgregacionCriterioVO criterioVO);
}
