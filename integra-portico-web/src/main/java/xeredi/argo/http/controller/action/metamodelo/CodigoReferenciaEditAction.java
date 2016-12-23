package xeredi.argo.http.controller.action.metamodelo;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.I18nService;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.metamodelo.service.CodigoReferenciaService;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.CodigoReferenciaVO;

/**
 * Edición de un Código de Referencia.
 */
public final class CodigoReferenciaEditAction extends CrudEditAction<CodigoReferenciaVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2714107460618528962L;

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
	public void doEdit() throws ApplicationException {
		if (accion == AccionCodigo.create) {
			Preconditions.checkNotNull(model.getTpdtId());

			i18nMap = new HashMap<>();
		} else {
			Preconditions.checkNotNull(model.getId());

			model = cdrfService.select(model.getId(), getIdioma());
			i18nMap = i18nService.selectMap(model);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doLoadDependencies() throws ApplicationException {
		// noop
	}
}
