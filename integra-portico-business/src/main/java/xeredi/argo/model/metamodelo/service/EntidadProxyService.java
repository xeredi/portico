package xeredi.argo.model.metamodelo.service;

import lombok.NonNull;
import xeredi.argo.model.metamodelo.vo.AbstractEntidadDetailVO;
import xeredi.argo.model.metamodelo.vo.TipoEstadisticaDetailVO;
import xeredi.argo.model.metamodelo.vo.TipoParametroDetailVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioDetailVO;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroDetailVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioDetailVO;

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
	 * Select tppr.
	 *
	 * @param id
	 *            the id
	 * @return the tipo parametro detail VO
	 */
	TipoParametroDetailVO selectTppr(@NonNull final Long id);

	/**
	 * Select tpsp.
	 *
	 * @param id
	 *            the id
	 * @return the tipo subparametro detail VO
	 */
	TipoSubparametroDetailVO selectTpsp(@NonNull final Long id);

	/**
	 * Select tpsr.
	 *
	 * @param id
	 *            the id
	 * @return the tipo servicio detail VO
	 */
	TipoServicioDetailVO selectTpsr(@NonNull final Long id);

	/**
	 * Select tpss.
	 *
	 * @param id
	 *            the id
	 * @return the tipo subservicio detail VO
	 */
	TipoSubservicioDetailVO selectTpss(@NonNull final Long id);

	/**
	 * Select tpes.
	 *
	 * @param id
	 *            the id
	 * @return the tipo estadistica detail VO
	 */
	TipoEstadisticaDetailVO selectTpes(@NonNull final Long id);
}
