package xeredi.integra.model.bo.facturacion;

import java.util.List;

import xeredi.integra.model.vo.facturacion.ValoracionLineaCriterioVO;
import xeredi.integra.model.vo.facturacion.ValoracionLineaVO;
import xeredi.integra.model.vo.facturacion.ValoracionVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface Valoracion.
 */
public interface Valoracion {

    /**
     * Delete.
     *
     * @param id
     *            the id
     */
    void delete(final Long id);

    /**
     * Select.
     *
     * @param id
     *            the id
     * @return the valoracion vo
     */
    ValoracionVO select(final Long id);

    /**
     * Select lineas list.
     *
     * @param vlrlCriterioVO
     *            the vlrl criterio vo
     * @return the list
     */
    List<ValoracionLineaVO> selectLineasList(final ValoracionLineaCriterioVO vlrlCriterioVO);
}
