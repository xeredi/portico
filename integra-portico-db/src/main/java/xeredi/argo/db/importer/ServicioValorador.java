package xeredi.argo.db.importer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import xeredi.argo.model.comun.vo.OrderByElement.OrderByType;
import xeredi.argo.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.model.metamodelo.vo.TipoServicioDetailVO;
import xeredi.argo.model.proceso.bo.ProcesoBO;
import xeredi.argo.model.proceso.vo.ItemTipo;
import xeredi.argo.model.proceso.vo.ProcesoTipo;
import xeredi.argo.model.proceso.vo.ProcesoVO;
import xeredi.argo.model.servicio.bo.ServicioBO;
import xeredi.argo.model.servicio.bo.ServicioBOFactory;
import xeredi.argo.model.servicio.vo.ServicioCriterioVO;
import xeredi.argo.model.servicio.vo.ServicioVO;
import xeredi.argo.proceso.facturacion.ProcesoValorador;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioValorador.
 */
public final class ServicioValorador {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(final String[] args) {
		final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		final Long usroId = 1000L;
		final Long entiId = Entidad.MANIFIESTO.getId();
		final Date fliq = Calendar.getInstance().getTime();

		final TipoServicioDetailVO tpsrDetail = TipoServicioProxy.select(entiId);
		final ServicioBO srvcBO = ServicioBOFactory.newInstance(entiId, usroId);
		final ServicioCriterioVO srvcCriterio = new ServicioCriterioVO();

		srvcCriterio.setEntiId(entiId);
		srvcCriterio.addOrderBy(ServicioCriterioVO.OrderByColumn.srvc_fref.name(), OrderByType.ASC);

		for (final ServicioVO srvc : srvcBO.selectList(srvcCriterio)) {
			if (tpsrDetail.getEnti().getEstadosVlrcSet().contains(srvc.getEstado())) {
				final ProcesoBO prbtBO = new ProcesoBO();
				final Map<String, String> parametroMap = new HashMap<>();

				parametroMap.put(ProcesoValorador.Params.fliq.name(), dateFormat.format(fliq));

				final ProcesoVO prbt = prbtBO.crear(usroId, ProcesoTipo.VALORADOR, parametroMap, ItemTipo.srvc,
						Arrays.asList(srvc.getId()));
			}
		}
	}
}
