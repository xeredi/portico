package xeredi.argo.model.servicio.service.amarredep;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.ExecutorType;
import org.mybatis.guice.transactional.Transactional;

import xeredi.argo.model.item.dao.ItemTramiteDAO;
import xeredi.argo.model.item.dao.ItemTramiteDatoDAO;
import xeredi.argo.model.metamodelo.service.EntidadProxyService;
import xeredi.argo.model.metamodelo.service.TramiteProxyService;
import xeredi.argo.model.seguridad.dao.UsuarioDAO;
import xeredi.argo.model.servicio.dao.ServicioActorDAO;
import xeredi.argo.model.servicio.dao.ServicioArchivoDAO;
import xeredi.argo.model.servicio.dao.ServicioDAO;
import xeredi.argo.model.servicio.dao.ServicioDatoDAO;
import xeredi.argo.model.servicio.dao.ServicioSecuenciaDAO;
import xeredi.argo.model.servicio.dao.ServicioTramiteDAO;
import xeredi.argo.model.servicio.dao.SubservicioDAO;
import xeredi.argo.model.servicio.dao.SubservicioDatoDAO;
import xeredi.argo.model.servicio.dao.SubservicioSubservicioDAO;
import xeredi.argo.model.servicio.dao.amarredep.AmarreDeportivoServicioDAO;
import xeredi.argo.model.servicio.service.ServicioService;
import xeredi.argo.model.servicio.vo.ServicioCriterioVO;
import xeredi.argo.model.servicio.vo.ServicioMaestroVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AmarreDeportivoService.
 */
@Transactional(executorType = ExecutorType.REUSE)
public class AmarreDeportivoServicioService extends ServicioService {

	/** The samad DAO. */
	private final AmarreDeportivoServicioDAO samadDAO;

	/**
	 * Instantiates a new amarre deportivo service.
	 *
	 * @param srvcDAO
	 *            the srvc DAO
	 * @param srdtDAO
	 *            the srdt DAO
	 * @param ssrvDAO
	 *            the ssrv DAO
	 * @param ssdtDAO
	 *            the ssdt DAO
	 * @param ssssDAO
	 *            the ssss DAO
	 * @param ittrDAO
	 *            the ittr DAO
	 * @param srtrDAO
	 *            the srtr DAO
	 * @param ittdDAO
	 *            the ittd DAO
	 * @param sracDAO
	 *            the srac DAO
	 * @param srarDAO
	 *            the srar DAO
	 * @param srscDAO
	 *            the srsc DAO
	 * @param usroDAO
	 *            the usro DAO
	 * @param entiProxy
	 *            the enti proxy
	 * @param trmtProxy
	 *            the trmt proxy
	 * @param samadDAO
	 *            the samad DAO
	 */
	@Inject
	public AmarreDeportivoServicioService(final ServicioDAO srvcDAO, final ServicioDatoDAO srdtDAO,
			final SubservicioDAO ssrvDAO, final SubservicioDatoDAO ssdtDAO, final SubservicioSubservicioDAO ssssDAO,
			final ItemTramiteDAO ittrDAO, final ServicioTramiteDAO srtrDAO, final ItemTramiteDatoDAO ittdDAO,
			final ServicioActorDAO sracDAO, final ServicioArchivoDAO srarDAO, final ServicioSecuenciaDAO srscDAO,
			final UsuarioDAO usroDAO, final EntidadProxyService entiProxy, final TramiteProxyService trmtProxy,
			final AmarreDeportivoServicioDAO samadDAO) {
		super(srvcDAO, srdtDAO, ssrvDAO, ssdtDAO, ssssDAO, ittrDAO, srtrDAO, ittdDAO, sracDAO, srarDAO, srscDAO,
				usroDAO, entiProxy, trmtProxy);

		this.samadDAO = samadDAO;
	}

	/**
	 * Select generate.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	public List<ServicioMaestroVO> selectGenerate(final ServicioCriterioVO criterio) {
		return samadDAO.selectGenerateList(criterio);
	}
}
