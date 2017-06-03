package xeredi.argo.http.controller.action.metamodelo;

import java.util.Map;

import javax.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.I18nService;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.metamodelo.service.CodigoReferenciaService;
import xeredi.argo.model.metamodelo.vo.CodigoReferenciaVO;

// TODO: Auto-generated Javadoc
/**
 * Visualización de un Código de Referencia.
 */
public final class CodigoReferenciaDetailAction extends CrudDetailAction<CodigoReferenciaVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2272224842467117453L;

	/** The cdri map. */
	@Getter
	private Map<String, I18nVO> i18nMap;

	@Inject
	private CodigoReferenciaService cdrfService;

	@Inject
	private I18nService i18nService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doDetail() throws ApplicationException {
		model = cdrfService.select(model.getId(), getIdioma());
		i18nMap = i18nService.selectMap(model);
	}
}
