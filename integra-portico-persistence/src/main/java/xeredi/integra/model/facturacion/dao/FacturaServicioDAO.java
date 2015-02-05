package xeredi.integra.model.facturacion.dao;

import java.util.List;

import javax.annotation.Nonnull;

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
    void insert(final @Nonnull FacturaServicioVO fcts);

    /**
     * Select.
     *
     * @param fctsId
     *            the fcts id
     * @return the factura servicio vo
     */
    FacturaServicioVO select(final @Nonnull Long fctsId);

    /**
     * Select list.
     *
     * @param fctrCriterioVO
     *            the fctr criterio vo
     * @return the list
     */
    List<FacturaServicioVO> selectList(final @Nonnull FacturaCriterioVO fctrCriterioVO);
}
