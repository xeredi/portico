package xeredi.integra.model.facturacion.dao;

import java.util.List;

import javax.annotation.Nonnull;

import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.facturacion.vo.CargoCriterioVO;
import xeredi.integra.model.facturacion.vo.CargoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface CargoDAO.
 */
public interface CargoDAO {

    /**
     * Select object.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the cargo vo
     */
    CargoVO selectObject(final @Nonnull CargoCriterioVO criterioVO);

    /**
     * Select list.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the list
     */
    List<CargoVO> selectList(final @Nonnull CargoCriterioVO criterioVO);

    /**
     * Select list.
     *
     * @param criterioVO
     *            the criterio vo
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<CargoVO> selectPaginatedList(final @Nonnull CargoCriterioVO criterioVO, final @Nonnull RowBounds bounds);

    /**
     * Count.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the int
     */
    int count(final @Nonnull CargoCriterioVO criterioVO);

    /**
     * Exists.
     *
     * @param crgo
     *            the crgo
     * @return true, if successful
     */
    boolean exists(final @Nonnull CargoVO crgo);

    /**
     * Exists overlap.
     *
     * @param crgo
     *            the crgo
     * @return true, if successful
     */
    boolean existsOverlap(final @Nonnull CargoVO crgo);

    /**
     * Select id.
     *
     * @param crgo
     *            the crgo
     * @return the long
     */
    Long selectId(final @Nonnull CargoVO crgo);

    /**
     * Insert.
     *
     * @param crgo
     *            the crgo
     */
    void insert(final @Nonnull CargoVO crgo);

    /**
     * Insert version.
     *
     * @param crgo
     *            the crgo
     */
    void insertVersion(final @Nonnull CargoVO crgo);

    /**
     * Update version.
     *
     * @param crgo
     *            the crgo
     * @return the int
     */
    int updateVersion(final @Nonnull CargoVO crgo);

    /**
     * Delete version.
     *
     * @param crgo
     *            the crgo
     * @return the int
     */
    int deleteVersion(final @Nonnull CargoVO crgo);

}
