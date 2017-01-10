package xeredi.argo.model.metamodelo.service;

import java.util.Map;

import lombok.NonNull;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface TipoSubservicioProxyService.
 */
public interface TipoSubservicioProxyService {

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @return the tipo subservicio detail VO
	 */
	TipoSubservicioDetailVO select(@NonNull final Long id);

	Map<Long, TipoSubservicioDetailVO> selectMap();
}
