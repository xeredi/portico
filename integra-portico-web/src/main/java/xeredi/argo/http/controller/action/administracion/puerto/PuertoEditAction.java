package xeredi.argo.http.controller.action.administracion.puerto;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.I18nService;
import xeredi.argo.model.comun.service.PuertoService;
import xeredi.argo.model.comun.service.SuperpuertoService;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.comun.vo.SuperpuertoCriterioVO;
import xeredi.argo.model.comun.vo.SuperpuertoVO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;

// TODO: Auto-generated Javadoc
/**
 * The Class PuertoEditAction.
 */
public final class PuertoEditAction extends CrudEditAction<PuertoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2800418654791205407L;

	/** The i18n map. */
	@Getter
	private Map<String, I18nVO> i18nMap;

	/** The sprt list. */
	@Getter
	private List<SuperpuertoVO> sprtList;

	@Inject
	private PuertoService prtoService;

	@Inject
	private I18nService i18nService;

	@Inject
	private SuperpuertoService sprtService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doEdit() throws ApplicationException {
		if (accion == AccionCodigo.edit) {
			Preconditions.checkNotNull(model.getId());

			model = prtoService.select(model.getId(), getIdioma());
			i18nMap = i18nService.selectMap(model);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doLoadDependencies() throws ApplicationException {
		final SuperpuertoCriterioVO sprtCriterio = new SuperpuertoCriterioVO();

		sprtCriterio.setIdioma(getIdioma());

		sprtList = sprtService.selectList(sprtCriterio);
	}
}
