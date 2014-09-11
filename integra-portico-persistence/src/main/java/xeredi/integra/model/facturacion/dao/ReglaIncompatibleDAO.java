package xeredi.integra.model.facturacion.dao;

import java.util.List;

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
    List<ReglaIncompatibleVO> selectList(final ReglaIncompatibleCriterioVO rginCriterioVO);

    /**
     * Select object.
     *
     * @param rginCriterioVO
     *            the rgin criterio vo
     * @return the regla incompatible vo
     */
    ReglaIncompatibleVO selectObject(final ReglaIncompatibleCriterioVO rginCriterioVO);

    /**
     * Exists.
     *
     * @param rgin
     *            the rgin
     * @return true, if successful
     */
    boolean exists(final ReglaIncompatibleVO rgin);

    /**
     * Exists overlap.
     *
     * @param rgin
     *            the rgin
     * @return true, if successful
     */
    boolean existsOverlap(final ReglaIncompatibleVO rgin);

    /**
     * Select id.
     *
     * @param rgin
     *            the rgin
     * @return the long
     */
    Long selectId(final ReglaIncompatibleVO rgin);

    /**
     * Insert.
     *
     * @param rgin
     *            the rgin
     */
    void insert(final ReglaIncompatibleVO rgin);

    /**
     * Insert version.
     *
     * @param rgin
     *            the rgin
     */
    void insertVersion(final ReglaIncompatibleVO rgin);

    /**
     * Update version.
     *
     * @param rgin
     *            the rgin
     * @return the int
     */
    int updateVersion(final ReglaIncompatibleVO rgin);

    /**
     * Delete version.
     *
     * @param rgin
     *            the rgin
     * @return the int
     */
    int deleteVersion(final ReglaIncompatibleVO rgin);
}
