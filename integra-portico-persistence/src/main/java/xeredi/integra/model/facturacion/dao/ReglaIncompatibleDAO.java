package xeredi.integra.model.facturacion.dao;

import java.util.List;

import javax.annotation.Nonnull;

import xeredi.integra.model.facturacion.vo.ReglaIncompatibleCriterioVO;
import xeredi.integra.model.facturacion.vo.ReglaIncompatibleVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ReglaIncompatibleDAO.
 */
public interface ReglaIncompatibleDAO {

    /**
     * Select list.
     *
     * @param rginCriterioVO
     *            the rgin criterio vo
     * @return the list
     */
    List<ReglaIncompatibleVO> selectList(final @Nonnull ReglaIncompatibleCriterioVO rginCriterioVO);

    /**
     * Select object.
     *
     * @param rginCriterioVO
     *            the rgin criterio vo
     * @return the regla incompatible vo
     */
    ReglaIncompatibleVO selectObject(final @Nonnull ReglaIncompatibleCriterioVO rginCriterioVO);

    /**
     * Exists.
     *
     * @param rgin
     *            the rgin
     * @return true, if successful
     */
    boolean exists(final @Nonnull ReglaIncompatibleVO rgin);

    /**
     * Exists overlap.
     *
     * @param rgin
     *            the rgin
     * @return true, if successful
     */
    boolean existsOverlap(final @Nonnull ReglaIncompatibleVO rgin);

    /**
     * Select id.
     *
     * @param rgin
     *            the rgin
     * @return the long
     */
    Long selectId(final @Nonnull ReglaIncompatibleVO rgin);

    /**
     * Insert.
     *
     * @param rgin
     *            the rgin
     */
    void insert(final @Nonnull ReglaIncompatibleVO rgin);

    /**
     * Insert version.
     *
     * @param rgin
     *            the rgin
     */
    void insertVersion(final @Nonnull ReglaIncompatibleVO rgin);

    /**
     * Update version.
     *
     * @param rgin
     *            the rgin
     * @return the int
     */
    int updateVersion(final @Nonnull ReglaIncompatibleVO rgin);

    /**
     * Delete version.
     *
     * @param rgin
     *            the rgin
     * @return the int
     */
    int deleteVersion(final @Nonnull ReglaIncompatibleVO rgin);
}
