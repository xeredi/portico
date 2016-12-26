package xeredi.argo.model.metamodelo.service;

import lombok.NonNull;
import xeredi.argo.model.metamodelo.vo.TramiteDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface TramiteProxyService.
 */
public interface TramiteProxyService {

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @return the tramite detail VO
	 */
	TramiteDetailVO select(@NonNull final Long id);
}
