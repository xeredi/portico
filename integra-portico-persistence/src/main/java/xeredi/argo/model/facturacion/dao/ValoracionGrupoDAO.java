package xeredi.argo.model.facturacion.dao;

import java.util.List;

import xeredi.argo.model.facturacion.vo.ValoracionGrupoCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionGrupoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ValoracionGrupoDAO.
 */
public interface ValoracionGrupoDAO {

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	List<ValoracionGrupoVO> selectList(final ValoracionGrupoCriterioVO criterio);
}
