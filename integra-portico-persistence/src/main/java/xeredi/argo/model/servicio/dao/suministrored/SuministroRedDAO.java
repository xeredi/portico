package xeredi.argo.model.servicio.dao.suministrored;

import java.util.List;

import lombok.NonNull;
import xeredi.argo.model.servicio.vo.ServicioMaestroCriterioVO;
import xeredi.argo.model.servicio.vo.ServicioMaestroVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ServicioRedDAO.
 */
public interface SuministroRedDAO {

	/**
	 * Select list.
	 *
	 * @param srmsCriterio
	 *            the srms criterio
	 * @return the list
	 */
	List<ServicioMaestroVO> selectGenerateList(final @NonNull ServicioMaestroCriterioVO srmsCriterio);
}
