package xeredi.argo.model.facturacion.dao;

import java.util.List;

import xeredi.argo.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionImpuestoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ValoracionImpuestoDAO.
 */
public interface ValoracionImpuestoDAO {

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	List<ValoracionImpuestoVO> selectList(final ValoracionCriterioVO criterio);
}
