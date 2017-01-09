package xeredi.argo.model.metamodelo.service;

import java.util.List;

import lombok.NonNull;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface TipoServicioProxyService.
 */
public interface TipoServicioProxyService {

	/**
	 * Select.
	 *
	 * @param id
	 *            the id
	 * @return the tipo servicio detail VO
	 */
	TipoServicioDetailVO select(@NonNull final Long id);

	/**
	 * Select label values.
	 *
	 * @return the list
	 */
	List<LabelValueVO> selectLabelValues();
}
