package xeredi.integra.model.facturacion.dao;

import java.util.List;

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
     * @param rglaCriterio
     *            the rgla criterio
     * @return the regla vo
     */
    ReglaVO selectObject(final ReglaCriterioVO rglaCriterio);

    /**
     * Select list.
     *
     * @param rglaCriterio
     *            the rgla criterio
     * @return the list
     */
    List<ReglaVO> selectList(final ReglaCriterioVO rglaCriterio);

    /**
     * Select list.
     *
     * @param rglaCriterio
     *            the rgla criterio
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<ReglaVO> selectList(final ReglaCriterioVO rglaCriterio, final RowBounds bounds);

    /**
     * Count.
     *
     * @param rglaCriterio
     *            the rgla criterio
     * @return the int
     */
    int count(final ReglaCriterioVO rglaCriterio);

    /**
     * Exists.
     *
     * @param rgla
     *            the rgla
     * @return true, if successful
     */
    boolean exists(final ReglaVO rgla);

    /**
     * Exists overlap.
     *
     * @param rgla
     *            the rgla
     * @return true, if successful
     */
    boolean existsOverlap(final ReglaVO rgla);

    /**
     * Select id.
     *
     * @param rgla
     *            the rgla
     * @return the long
     */
    Long selectId(final ReglaVO rgla);

    /**
     * Insert.
     *
     * @param rgla
     *            the rgla
     */
    void insert(final ReglaVO rgla);

    /**
     * Insert version.
     *
     * @param rgla
     *            the rgla
     */
    void insertVersion(final ReglaVO rgla);

    /**
     * Update version.
     *
     * @param rgla
     *            the rgla
     * @return the int
     */
    int updateVersion(final ReglaVO rgla);

    /**
     * Delete version.
     *
     * @param rgla
     *            the rgla
     * @return the int
     */
    int deleteVersion(final ReglaVO rgla);
}
