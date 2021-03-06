package xeredi.argo.http.controller.action.servicio;

import java.util.List;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import lombok.Getter;
import xeredi.argo.http.controller.action.item.ItemDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.item.service.ItemTramiteService;
import xeredi.argo.model.item.vo.ItemTramiteCriterioVO;
import xeredi.argo.model.item.vo.ItemTramiteVO;
import xeredi.argo.model.metamodelo.service.EntidadProxyService;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioDetailVO;
import xeredi.argo.model.servicio.service.SubservicioService;
import xeredi.argo.model.servicio.service.SubservicioServiceFactory;
import xeredi.argo.model.servicio.vo.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioDetailAction.
 */
public final class SubservicioDetailAction extends ItemDetailAction<SubservicioVO, TipoSubservicioDetailVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2847090432750136391L;

	/** The sstr list. */
	@Getter
	private List<ItemTramiteVO> ittrList;

	@Inject
	private EntidadProxyService entiProxy;

	@Inject
	private SubservicioServiceFactory ssrvFactory;

	@Inject
	private ItemTramiteService ittrService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificDetail() throws ApplicationException {
		Preconditions.checkNotNull(model.getId());

		enti = entiProxy.selectTpss(model.getEntiId());

		final SubservicioService ssrvService = ssrvFactory.getInstance(model.getEntiId(), usroId);

		model = ssrvService.select(model.getId(), getIdioma());

		if (enti.getEnti().getTpdtEstado() != null) {
			final ItemTramiteCriterioVO ittrCriterio = new ItemTramiteCriterioVO();

			ittrCriterio.setItemId(model.getId());

			ittrList = ittrService.selectList(ittrCriterio);
		}
	}
}
