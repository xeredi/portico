package xeredi.integra.model.facturacion.dao;

import xeredi.integra.model.comun.dao.CrudDAO;
import xeredi.integra.model.facturacion.vo.ValoracionLineaCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionLineaVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ValoracionLineaDAO.
 */
public interface ValoracionLineaDAO extends CrudDAO<ValoracionLineaVO, ValoracionLineaCriterioVO> {
    /**
     * Exists dependencia.
     *
     * @param vlrlId
     *            the vlrl id
     * @return true, if successful
     */
    boolean existsDependencia(final Long vlrlId);

    /**
     * Checks if is regla valida.
     *
     * @param vlrl
     *            the vlrl
     * @return true, if is regla valida
     */
    boolean isRglaValida(final ValoracionLineaVO vlrl);
}
