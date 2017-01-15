package xeredi.argo.model.metamodelo.service;

import lombok.NonNull;
import xeredi.argo.model.metamodelo.vo.TipoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface TipoDatoProxyService.
 */
public interface TipoDatoProxyService {

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @return the tipo dato VO
	 */
	TipoDatoVO select(@NonNull final Long id);
}
