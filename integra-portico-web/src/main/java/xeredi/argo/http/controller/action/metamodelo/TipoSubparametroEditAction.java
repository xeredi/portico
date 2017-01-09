package xeredi.argo.http.controller.action.metamodelo;

import java.util.List;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import lombok.Getter;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.metamodelo.service.EntidadService;
import xeredi.argo.model.metamodelo.service.TipoSubparametroService;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoEntidad;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubparametroEditAction.
 */
public final class TipoSubparametroEditAction extends EntidadEditAction<TipoSubparametroVO> {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7770071461552035741L;

	/** The tppr list. */
	@Getter
	private List<LabelValueVO> tpprList;

	@Inject
	private EntidadService entiService;

	@Inject
	private TipoSubparametroService tpspService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificEdit() throws ApplicationException {
		if (accion == AccionCodigo.create) {
			Preconditions.checkNotNull(model.getTpprId());
		} else {
			Preconditions.checkNotNull(model.getId());

			model = tpspService.select(model.getId(), getIdioma());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificLoadDependencies() throws ApplicationException {
		final EntidadCriterioVO entiCriterioVO = new EntidadCriterioVO();

		entiCriterioVO.setTipo(TipoEntidad.P);
		entiCriterioVO.setIdioma(getIdioma());

		tpprList = entiService.selectLabelValues(entiCriterioVO);
	}
}
