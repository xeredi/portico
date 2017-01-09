package xeredi.argo.model.facturacion.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.ModelException;
import xeredi.argo.model.proceso.vo.ProcesoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ValoradorService.
 */
public interface ValoradorService {

	/**
	 * Valorar servicio.
	 *
	 * @param prbt
	 *            the prbt
	 * @param srvcId
	 *            the srvc id
	 * @param crgoIds
	 *            the crgo ids
	 * @param fechaLiquidacion
	 *            the fecha liquidacion
	 * @return the list
	 * @throws ModelException
	 *             the model exception
	 */
	List<Long> valorarServicio(@NonNull final ProcesoVO prbt, @NonNull final Long srvcId,
			@NonNull final Set<Long> crgoIds, @NonNull final Date fechaLiquidacion) throws ModelException;
}
