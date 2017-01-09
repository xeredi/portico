package xeredi.argo.model.metamodelo.service;

import java.util.Map;

import lombok.NonNull;
import xeredi.argo.model.metamodelo.vo.AbstractEntidadDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface EntidadProxyService.
 */
public interface EntidadProxyService {

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @return the abstract entidad detail VO
	 */
	AbstractEntidadDetailVO select(@NonNull final Long id);

	/**
	 * Fill dependencies.
	 *
	 * @param entiMap
	 *            the enti map
	 */
	void fillDependencies(@NonNull final Map<Long, ? extends AbstractEntidadDetailVO> entiMap);
}
