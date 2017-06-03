package xeredi.argo.http.controller.action.servicio;

import java.util.List;

import javax.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.item.ItemDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.ArchivoService;
import xeredi.argo.model.comun.vo.ArchivoCriterioVO;
import xeredi.argo.model.comun.vo.ArchivoInfoVO;
import xeredi.argo.model.item.service.ItemTramiteService;
import xeredi.argo.model.item.vo.ItemTramiteCriterioVO;
import xeredi.argo.model.item.vo.ItemTramiteVO;
import xeredi.argo.model.metamodelo.service.EntidadProxyService;
import xeredi.argo.model.metamodelo.vo.TipoServicioDetailVO;
import xeredi.argo.model.servicio.bo.ServicioBO;
import xeredi.argo.model.servicio.bo.ServicioBOFactory;
import xeredi.argo.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioDetailAction.
 */
public final class ServicioDetailAction extends ItemDetailAction<ServicioVO, TipoServicioDetailVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8504526234230863854L;

	/** The arin list. */
	@Getter
	private List<ArchivoInfoVO> arinList;

	/** The srtr list. */
	@Getter
	private List<ItemTramiteVO> ittrList;

	@Inject
	private ArchivoService archService;

	@Inject
	private ItemTramiteService ittrService;

	@Inject
	private EntidadProxyService entiProxy;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificDetail() throws ApplicationException {
		enti = entiProxy.selectTpsr(model.getEntiId());

		final ServicioBO srvcBO = ServicioBOFactory.newInstance(model.getEntiId(), usroId);

		model = srvcBO.select(model.getId(), getIdioma());

		final ArchivoCriterioVO archCriterio = new ArchivoCriterioVO();

		archCriterio.setSrvcId(model.getId());

		arinList = archService.selectList(archCriterio);

		if (enti.getEnti().getTpdtEstado() != null) {
			final ItemTramiteCriterioVO ittrCriterio = new ItemTramiteCriterioVO();

			ittrCriterio.setItemId(model.getId());
			ittrCriterio.setIdioma(getIdioma());

			ittrList = ittrService.selectList(ittrCriterio);
		}
	}
}
