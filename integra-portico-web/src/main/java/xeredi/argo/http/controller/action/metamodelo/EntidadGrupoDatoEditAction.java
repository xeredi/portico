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
import xeredi.argo.model.metamodelo.bo.EntidadGrupoDatoBO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.EntidadGrupoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadGrupoDatoEditAction.
 */
public final class EntidadGrupoDatoEditAction extends CrudEditAction<EntidadGrupoDatoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1801325748314233476L;

	/** The i18n map. */
	@Getter
	private Map<String, I18nVO> i18nMap;

	@Inject
	private I18nService i18nService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doEdit() throws ApplicationException {
		Preconditions.checkNotNull(model.getEntiId());

		if (accion == AccionCodigo.create) {
			i18nMap = new HashMap<>();
		} else {
			Preconditions.checkNotNull(model.getId());

			final EntidadGrupoDatoBO engdBO = new EntidadGrupoDatoBO();

			model = engdBO.select(model.getId(), getIdioma());
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
