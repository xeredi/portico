package xeredi.integra.model.dao.facturacion;

import java.util.List;

import xeredi.integra.model.vo.facturacion.FacturaCargoVO;
import xeredi.integra.model.vo.facturacion.FacturaCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface FacturaCargoDAO.
 */
public interface FacturaCargoDAO {

    /**
     * Insert.
     *
     * @param fctc
     *            the fctc
     */
    void insert(final FacturaCargoVO fctc);

    /**
     * Insert generate.
     *
     * @param fctrCriterioVO
     *            the fctr criterio vo
     */
    void insertGenerate(final FacturaCriterioVO fctrCriterioVO);

    /**
     * Select list.
     *
     * @param fctrCriterioVO
     *            the fctr criterio vo
     * @return the list< factura cargo v o>
     */
    List<FacturaCargoVO> selectList(final FacturaCriterioVO fctrCriterioVO);
}
