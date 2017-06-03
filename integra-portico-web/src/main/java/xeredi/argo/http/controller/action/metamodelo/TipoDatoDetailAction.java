package xeredi.argo.http.controller.action.metamodelo;

import java.util.Map;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.I18nService;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.metamodelo.service.TipoDatoService;
import xeredi.argo.model.metamodelo.vo.TipoDatoVO;

/**
 * The Class TipoDatoDetailAction.
 */
public final class TipoDatoDetailAction extends CrudDetailAction<TipoDatoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6843746887292732660L;

	/** The i18n map. */
	@Getter
	private Map<String, I18nVO> i18nMap;

	/** The tpdt service. */
	@Inject
	private TipoDatoService tpdtService;

	@Inject
	private I18nService i18nService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doDetail() throws ApplicationException {
		Preconditions.checkNotNull(model.getId());

		model = tpdtService.select(model.getId(), getIdioma());
		i18nMap = i18nService.selectMap(model);
	}
}
