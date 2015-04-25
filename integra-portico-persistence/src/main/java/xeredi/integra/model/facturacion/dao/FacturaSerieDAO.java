package xeredi.integra.model.facturacion.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.facturacion.vo.FacturaSerieCriterioVO;
import xeredi.integra.model.facturacion.vo.FacturaSerieVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface FacturaSerieDAO.
 */
public interface FacturaSerieDAO {

    /**
     * Select.
     *
     * @param id
     *            the id
     * @return the factura serie vo
     */
    FacturaSerieVO select(final Long id);

    /**
     * Update incrementar.
     *
     * @param id
     *            the id
     * @return the int
     */
    int updateIncrementar(final Long id);

    /**
     * Exists.
     *
     * @param fcsr
     *            the fcsr
     * @return true, if successful
     */
    boolean exists(final FacturaSerieVO fcsr);

    /**
     * Insert.
     *
     * @param fcsr
     *            the fcsr
     */
    void insert(final FacturaSerieVO fcsr);

    /**
     * Update.
     *
     * @param fcsr
     *            the fcsr
     * @return the int
     */
    int update(final FacturaSerieVO fcsr);

    /**
     * Delete.
     *
     * @param fcsrId
     *            the fcsr id
     * @return the int
     */
    int delete(final Long fcsrId);

    /**
     * Count.
     *
     * @param fcsrCriterio
     *            the fcsr criterio
     * @return the int
     */
    int count(final FacturaSerieCriterioVO fcsrCriterio);

    /**
     * Select list.
     *
     * @param fcsrCriterio
     *            the fcsr criterio
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<FacturaSerieVO> selectList(final FacturaSerieCriterioVO fcsrCriterio, final RowBounds bounds);

    /**
     * Select list.
     *
     * @param fcsrCriterio
     *            the fcsr criterio
     * @return the list
     */
    List<FacturaSerieVO> selectList(final FacturaSerieCriterioVO fcsrCriterio);
}
