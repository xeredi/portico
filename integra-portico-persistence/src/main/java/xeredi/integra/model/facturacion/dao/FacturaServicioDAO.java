package xeredi.integra.model.facturacion.dao;

import java.util.List;

import xeredi.integra.model.facturacion.vo.FacturaCriterioVO;
import xeredi.integra.model.facturacion.vo.FacturaServicioVO;

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
     * @return the list
     */
    List<FacturaServicioVO> selectList(final FacturaCriterioVO fctrCriterioVO);
}
