package xeredi.argo.http.controller.action.metamodelo;

import java.util.List;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.service.CampoAgregacionService;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.CampoAgregacionVO;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CampoAgregacionEditAction.
 */
public final class CampoAgregacionEditAction extends CrudEditAction<CampoAgregacionVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6163643952983909955L;

	/** The entd list. */
	@Getter
	private List<EntidadTipoDatoVO> entdList;

	@Inject
	private CampoAgregacionService cmagService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doEdit() throws ApplicationException {
		Preconditions.checkNotNull(model.getTpesId());

		if (accion == AccionCodigo.edit) {
			Preconditions.checkNotNull(model.getEntd());
			Preconditions.checkNotNull(model.getEntd().getId());

			model = cmagService.select(model.getTpesId(), model.getEntd().getId(), getIdioma());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doLoadDependencies() throws ApplicationException {
		// FIXME Hay que cargar dependencias??
	}
}
