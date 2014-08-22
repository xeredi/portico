package xeredi.integra.model.facturacion.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.facturacion.vo.FacturaCriterioVO;
import xeredi.integra.model.facturacion.vo.FacturaVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface FacturaDAO.
 */
public interface FacturaDAO {

    /**
     * Insert.
     *
     * @param fctr
     *            the fctr
     */
    void insert(final FacturaVO fctr);

    /**
     * Update estado.
     *
     * @param fctr
     *            the fctr
     * @return the int
     */
    int updateEstado(final FacturaVO fctr);

    /**
     * Select.
     *
     * @param id
     *            the id
     * @return the factura vo
     */
    FacturaVO select(final Long id);

    /**
     * Count.
     *
     * @param fctrCriterioVO
     *            the fctr criterio vo
     * @return the int
     */
    int count(final FacturaCriterioVO fctrCriterioVO);

    /**
     * Select list.
     *
     * @param fctrCriterioVO
     *            the fctr criterio vo
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<FacturaVO> selectList(final FacturaCriterioVO fctrCriterioVO, final RowBounds bounds);

    /**
     * Exists factura posterior.
     *
     * @param fctrId
     *            the fctr id
     * @return true, if successful
     */
    boolean existsFacturaPosterior(final Long fctrId);

    /**
     * Exists valoracion posterior.
     *
     * @param fctrId
     *            the fctr id
     * @return true, if successful
     */
    boolean existsValoracionPosterior(final Long fctrId);
}
