package xeredi.integra.model.facturacion.dao;

import java.util.List;

import javax.annotation.Nonnull;

import xeredi.integra.model.facturacion.vo.FacturaCriterioVO;
import xeredi.integra.model.facturacion.vo.FacturaImpuestoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface FacturaImpuestoDAO.
 */
public interface FacturaImpuestoDAO {

    /**
     * Select generate list.
     *
     * @param fctrCriterioVO
     *            the fctr criterio vo
     * @return the list
     */
    List<FacturaImpuestoVO> selectGenerateList(final @Nonnull FacturaCriterioVO fctrCriterioVO);

    /**
     * Insert.
     *
     * @param fcti
     *            the fcti
     */
    void insert(final @Nonnull FacturaImpuestoVO fcti);

    /**
     * Select list.
     *
     * @param fctrCriterioVO
     *            the fctr criterio vo
     * @return the list
     */
    List<FacturaImpuestoVO> selectList(final @Nonnull FacturaCriterioVO fctrCriterioVO);
}
