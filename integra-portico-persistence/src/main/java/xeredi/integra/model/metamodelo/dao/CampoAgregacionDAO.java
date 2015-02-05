package xeredi.integra.model.metamodelo.dao;

import java.util.List;

import javax.annotation.Nonnull;

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
    boolean exists(final @Nonnull CampoAgregacionVO vo);

    /**
     * Insert.
     *
     * @param vo
     *            the vo
     */
    void insert(final @Nonnull CampoAgregacionVO vo);

    /**
     * Update.
     *
     * @param vo
     *            the vo
     * @return the int
     */
    int update(final @Nonnull CampoAgregacionVO vo);

    /**
     * Delete.
     *
     * @param vo
     *            the vo
     * @return the int
     */
    int delete(final @Nonnull CampoAgregacionVO vo);

    /**
     * Select list.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the list
     */
    List<CampoAgregacionVO> selectList(final @Nonnull CampoAgregacionCriterioVO criterioVO);

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
    CampoAgregacionVO selectObject(final @Nonnull CampoAgregacionCriterioVO criterioVO);
}
