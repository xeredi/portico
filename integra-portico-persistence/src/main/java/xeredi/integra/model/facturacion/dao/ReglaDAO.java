package xeredi.integra.model.facturacion.dao;

import java.util.List;

import javax.annotation.Nonnull;

import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.facturacion.vo.ReglaCriterioVO;
import xeredi.integra.model.facturacion.vo.ReglaVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ReglaDAO.
 */
public interface ReglaDAO {

    /**
     * Select object.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the regla vo
     */
    ReglaVO selectObject(final @Nonnull ReglaCriterioVO criterioVO);

    /**
     * Select list.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the list
     */
    List<ReglaVO> selectList(final @Nonnull ReglaCriterioVO criterioVO);

    /**
     * Select list.
     *
     * @param criterioVO
     *            the criterio vo
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<ReglaVO> selectPaginatedList(final @Nonnull ReglaCriterioVO criterioVO, final @Nonnull RowBounds bounds);

    /**
     * Count.
     *
     * @param rglaCriterioVO
     *            the rgla criterio vo
     * @return the int
     */
    int count(final @Nonnull ReglaCriterioVO rglaCriterioVO);

    /**
     * Exists.
     *
     * @param rgla
     *            the rgla
     * @return true, if successful
     */
    boolean exists(final @Nonnull ReglaVO rgla);

    /**
     * Exists overlap.
     *
     * @param rgla
     *            the rgla
     * @return true, if successful
     */
    boolean existsOverlap(final @Nonnull ReglaVO rgla);

    /**
     * Select id.
     *
     * @param rgla
     *            the rgla
     * @return the long
     */
    Long selectId(final @Nonnull ReglaVO rgla);

    /**
     * Insert.
     *
     * @param rgla
     *            the rgla
     */
    void insert(final @Nonnull ReglaVO rgla);

    /**
     * Insert version.
     *
     * @param rgla
     *            the rgla
     */
    void insertVersion(final @Nonnull ReglaVO rgla);

    /**
     * Update version.
     *
     * @param rgla
     *            the rgla
     * @return the int
     */
    int updateVersion(final @Nonnull ReglaVO rgla);

    /**
     * Delete version.
     *
     * @param rglvId
     *            the rglv id
     * @return the int
     */
    int deleteVersion(final @Nonnull Long rglvId);
}
