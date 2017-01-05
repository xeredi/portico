package xeredi.argo.http.controller.action.item;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.opensymphony.xwork2.ModelDriven;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.BaseAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.item.vo.ItemDatoVO;
import xeredi.argo.model.item.vo.ItemTramiteDatoVO;
import xeredi.argo.model.item.vo.ItemTramiteVO;
import xeredi.argo.model.item.vo.ItemVO;
import xeredi.argo.model.maestro.service.ParametroService;
import xeredi.argo.model.metamodelo.proxy.EntidadProxy;
import xeredi.argo.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.argo.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.argo.model.metamodelo.service.TramiteProxyService;
import xeredi.argo.model.metamodelo.vo.AbstractEntidadDetailVO;
import xeredi.argo.model.metamodelo.vo.TipoEntidad;
import xeredi.argo.model.metamodelo.vo.TipoHtml;
import xeredi.argo.model.metamodelo.vo.TipoServicioDetailVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioDetailVO;
import xeredi.argo.model.metamodelo.vo.TramiteDetailVO;
import xeredi.argo.model.metamodelo.vo.TramiteTipoDatoVO;
import xeredi.argo.model.servicio.bo.ServicioBO;
import xeredi.argo.model.servicio.bo.ServicioBOFactory;
import xeredi.argo.model.servicio.bo.SubservicioBO;
import xeredi.argo.model.servicio.bo.SubservicioBOFactory;
import xeredi.argo.model.servicio.vo.ServicioVO;
import xeredi.argo.model.servicio.vo.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemTramiteEditAction.
 */
public final class ItemTramiteEditAction extends BaseAction implements ModelDriven<ItemTramiteVO>, FuncionalidadAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7371401403513787913L;

	/** The model. */
	@Getter
	protected ItemTramiteVO model;

	/** The trmt. */
	@Getter
	protected TramiteDetailVO trmt;

	/** The item. */
	@Getter
	private ItemVO item;

	/** The enti. */
	@Getter
	private AbstractEntidadDetailVO enti;

	/** The label values map. */
	@Getter
	private HashMap<Long, List<LabelValueVO>> labelValuesMap;

	/** The prto id. */
	@Getter
	private Long prtoId;

	@Inject
	private TramiteProxyService trmtProxy;

	@Inject
	private ParametroService prmtService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void doExecute() throws ApplicationException {
		Preconditions.checkNotNull(model.getItemId());
		Preconditions.checkNotNull(model.getTrmt().getId());

		trmt = trmtProxy.select(model.getTrmt().getId());

		model.setTrmt(trmt.getTrmt());

		final TipoEntidad tipoEntidad = EntidadProxy.select(model.getTrmt().getEntiId()).getEnti().getTipo();

		switch (tipoEntidad) {
		case T:
			final TipoServicioDetailVO tpsr = TipoServicioProxy.select(model.getTrmt().getEntiId());
			final ServicioBO srvcBO = ServicioBOFactory.newInstance(tpsr.getEnti().getId(), usroId);
			final ServicioVO srvc = srvcBO.select(model.getItemId(), getIdioma());

			prtoId = srvc.getPrto().getId();

			item = srvc;
			enti = tpsr;

			break;
		case S:
			final TipoSubservicioDetailVO tpss = TipoSubservicioProxy.select(model.getTrmt().getEntiId());
			final SubservicioBO ssrvBO = SubservicioBOFactory.newInstance(model.getTrmt().getEntiId(), usroId);
			final SubservicioVO ssrv = ssrvBO.select(model.getItemId(), getIdioma());

			prtoId = ssrv.getSrvc().getPrto().getId();

			model.setOitemFini(ssrv.getFini());
			model.setOitemFfin(ssrv.getFfin());
			model.setDitemFini(ssrv.getFini());
			model.setDitemFfin(ssrv.getFfin());

			item = ssrv;
			enti = tpss;

			break;
		case P:
			throw new Error("No implementado!!");
		default:
			throw new Error("Invalid entity type: " + tipoEntidad);
		}

		if (!trmt.getTpdtList().isEmpty()) {
			for (final Long tpdtId : trmt.getTpdtList()) {
				final ItemTramiteDatoVO ittd = new ItemTramiteDatoVO();

				ittd.setTpdtId(tpdtId);

				if (item.getItdtMap().containsKey(tpdtId)) {
					final ItemDatoVO itdt = item.getItdtMap().get(tpdtId);

					ittd.setOcadena(itdt.getCadena());
					ittd.setOnentero(itdt.getCantidadEntera());
					ittd.setOndecimal(itdt.getCantidadDecimal());
					ittd.setOfecha(itdt.getFecha());
					ittd.setOprmt(itdt.getPrmt());
					ittd.setOsrvc(itdt.getSrvc());

					ittd.setDcadena(itdt.getCadena());
					ittd.setDnentero(itdt.getCantidadEntera());
					ittd.setDndecimal(itdt.getCantidadDecimal());
					ittd.setDfecha(itdt.getFecha());
					ittd.setDprmt(itdt.getPrmt());
					ittd.setDsrvc(itdt.getSrvc());
				}

				model.getIttdMap().put(tpdtId, ittd);
			}
		}

		doLoadDependencies();
	}

	/**
	 * Do load dependencies.
	 *
	 * @throws ApplicationException
	 *             the application exception
	 */
	public final void doLoadDependencies() throws ApplicationException {
		Preconditions.checkNotNull(model.getTrmt().getEntiId());

		labelValuesMap = new HashMap<Long, List<LabelValueVO>>();

		final Set<Long> tpprIds = new HashSet<>();

		for (final TramiteTipoDatoVO trtd : trmt.getTrtdMap().values()) {
			if (trtd.getEntd().getTpdt().getTpht() != TipoHtml.F && trtd.getEntd().getTpdt().getEnti() != null
					&& trtd.getEntd().getTpdt().getEnti().getId() != null) {
				tpprIds.add(trtd.getEntd().getTpdt().getEnti().getId());
			}
		}

		if (!tpprIds.isEmpty()) {
			labelValuesMap.putAll(prmtService.selectLabelValues(tpprIds, model.getFref(), getIdioma()));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long getFncdId() {
		Preconditions.checkNotNull(model);
		Preconditions.checkNotNull(model.getTrmt());
		Preconditions.checkNotNull(model.getTrmt().getId());

		return model.getTrmt().getId();
	}
}
