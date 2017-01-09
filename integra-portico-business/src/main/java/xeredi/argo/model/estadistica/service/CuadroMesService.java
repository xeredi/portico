package xeredi.argo.model.estadistica.service;

import java.util.List;
import java.util.Map;

import xeredi.argo.model.estadistica.vo.CuadroMesVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface CuadroMesService.
 */
public interface CuadroMesService {

	/**
	 * Select map.
	 *
	 * @param peprId
	 *            the pepr id
	 * @return the map
	 */
	Map<String, List<CuadroMesVO>> selectMap(final Long peprId);
}
