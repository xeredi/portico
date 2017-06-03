package xeredi.argo.http.controller.action.metamodelo;

import java.util.List;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.service.AccionEntidadBaseService;
import xeredi.argo.model.metamodelo.service.AccionEntidadService;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.AccionEntidadBaseCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadBaseVO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionEntidadEditAction.
 */
public final class AccionEntidadEditAction extends CrudEditAction<AccionEntidadVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6298953902914627135L;

	/** The accn list. */
	@Getter
	private List<AccionEntidadBaseVO> aebsList;

	@Inject
	private AccionEntidadService acenService;

	@Inject
	private AccionEntidadBaseService aebsService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doEdit() throws ApplicationException {
		if (accion == AccionCodigo.create) {
			Preconditions.checkNotNull(model.getEntiId());
		} else {
			Preconditions.checkNotNull(model.getId());

			final AccionEntidadCriterioVO acenCriterio = new AccionEntidadCriterioVO();

			acenCriterio.setId(model.getId());

			model = acenService.selectObject(acenCriterio);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doLoadDependencies() throws ApplicationException {
		final AccionEntidadBaseCriterioVO aebsCriterio = new AccionEntidadBaseCriterioVO();

		aebsList = aebsService.selectList(aebsCriterio);
	}
}
