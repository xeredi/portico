package xeredi.integra.model.servicio.dao.manifiesto;

import javax.annotation.Nonnull;

import xeredi.integra.model.servicio.vo.SubservicioCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface BlDAO.
 */
public interface BlDAO {

    /**
     * Update recalcular estado.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the int
     */
    int updateRecalcularEstado(final @Nonnull SubservicioCriterioVO criterioVO);
}
