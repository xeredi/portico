package xeredi.argo.model.facturacion.service;

import java.util.List;

import lombok.NonNull;
import xeredi.argo.model.facturacion.vo.ValoracionCargoVO;
import xeredi.argo.model.facturacion.vo.ValoracionCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ValoracionCargoService.
 */
public interface ValoracionCargoService {

	/**
	 * Select list.
	 *
	 * @param vlrcCriterio
	 *            the vlrc criterio
	 * @return the list
	 */
	List<ValoracionCargoVO> selectList(@NonNull final ValoracionCriterioVO vlrcCriterio);
}
