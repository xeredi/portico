package xeredi.argo.model.facturacion.dao;

import java.util.List;

import xeredi.argo.model.facturacion.vo.ValoracionCargoVO;
import xeredi.argo.model.facturacion.vo.ValoracionCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ValoracionCargoDAO.
 */
public interface ValoracionCargoDAO {

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	List<ValoracionCargoVO> selectList(final ValoracionCriterioVO criterio);
}
