package xeredi.integra.model.facturacion.dao;

import java.util.List;

import javax.annotation.Nonnull;

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
    void insert(final @Nonnull FacturaVO fctr);

    /**
     * Update estado.
     *
     * @param fctr
     *            the fctr
     * @return the int
     */
    int updateEstado(final @Nonnull FacturaVO fctr);

    /**
     * Select.
     *
     * @param id
     *            the id
     * @return the factura vo
     */
    FacturaVO select(final @Nonnull Long id);

    /**
     * Count.
     *
     * @param fctrCriterioVO
     *            the fctr criterio vo
     * @return the int
     */
    int count(final @Nonnull FacturaCriterioVO fctrCriterioVO);

    /**
     * Select list.
     *
     * @param fctrCriterioVO
     *            the fctr criterio vo
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<FacturaVO> selectList(final @Nonnull FacturaCriterioVO fctrCriterioVO, final RowBounds bounds);

    /**
     * Exists factura posterior.
     *
     * @param fctrId
     *            the fctr id
     * @return true, if successful
     */
    boolean existsFacturaPosterior(final @Nonnull Long fctrId);

    /**
     * Exists valoracion posterior.
     *
     * @param fctrId
     *            the fctr id
     * @return true, if successful
     */
    boolean existsValoracionPosterior(final @Nonnull Long fctrId);
}
