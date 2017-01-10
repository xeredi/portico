package xeredi.argo.model.metamodelo.service;

import lombok.NonNull;
import xeredi.argo.model.metamodelo.vo.TipoParametroDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface TipoParametroProxyService.
 */
public interface TipoParametroProxyService {

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @return the tipo parametro detail VO
	 */
	TipoParametroDetailVO select(@NonNull final Long id);
}
