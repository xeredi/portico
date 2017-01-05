package xeredi.argo.model.metamodelo.service;

import java.util.List;

import lombok.NonNull;
import xeredi.argo.model.metamodelo.vo.AccionEntidadBaseCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadBaseVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface AccionEntidadBaseService.
 */
public interface AccionEntidadBaseService {

	/**
	 * Select list.
	 *
	 * @param aebsCriterio
	 *            the aebs criterio
	 * @return the list
	 */
	List<AccionEntidadBaseVO> selectList(@NonNull final AccionEntidadBaseCriterioVO aebsCriterio);
}
