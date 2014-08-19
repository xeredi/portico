package xeredi.integra.model.dao.facturacion;

import java.util.List;

import xeredi.integra.model.vo.facturacion.FacturaCriterioVO;
import xeredi.integra.model.vo.facturacion.FacturaServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface FacturaServicioDAO.
 */
public interface FacturaServicioDAO {

    /**
     * Insert.
     *
     * @param fcts
     *            the fcts
     */
    void insert(final FacturaServicioVO fcts);

    /**
     * Select list.
     *
     * @param fctrCriterioVO
     *            the fctr criterio vo
     * @return the list< factura servicio v o>
     */
    List<FacturaServicioVO> selectList(final FacturaCriterioVO fctrCriterioVO);
}
