package xeredi.argo.http.controller.action.metamodelo;

import java.util.Map;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.I18nService;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.metamodelo.service.ModuloService;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.ModuloCriterioVO;
import xeredi.argo.model.metamodelo.vo.ModuloVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ModuloEditAction.
 */
public final class ModuloEditAction extends CrudEditAction<ModuloVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1589089304159063576L;

	/** The i18n map. */
	@Getter
	private Map<String, I18nVO> i18nMap;

	@Inject
	private ModuloService mdloService;

	@Inject
	private I18nService i18nService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doEdit() throws ApplicationException {
		if (accion == AccionCodigo.create) {
			model = new ModuloVO();
		} else {
			Preconditions.checkNotNull(model.getId());

			final ModuloCriterioVO mdloCriterio = new ModuloCriterioVO();

			mdloCriterio.setId(model.getId());

			model = mdloService.selectObject(mdloCriterio);
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
