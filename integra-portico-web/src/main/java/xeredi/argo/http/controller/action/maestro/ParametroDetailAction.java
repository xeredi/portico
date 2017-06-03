package xeredi.argo.http.controller.action.maestro;

import java.util.Map;

import javax.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.item.ItemDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.I18nService;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.maestro.service.ParametroServiceFactory;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.metamodelo.service.EntidadProxyService;
import xeredi.argo.model.metamodelo.vo.TipoParametroDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroDetailAction.
 */
public final class ParametroDetailAction extends ItemDetailAction<ParametroVO, TipoParametroDetailVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6639690925171727021L;

	/** The i18n map. */
	@Getter
	private Map<String, I18nVO> i18nMap;

	@Inject
	private ParametroServiceFactory prmtFactory;

	@Inject
	private I18nService i18nService;

	@Inject
	private EntidadProxyService entiProxy;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificDetail() throws ApplicationException {
		enti = entiProxy.selectTppr(model.getEntiId());
		model = prmtFactory.getInstance(model.getEntiId()).select(model.getId(), getIdioma(), model.getFref());

		if (enti.getEnti().isI18n()) {
			i18nMap = i18nService.selectMap(model);
		}
	}
}
