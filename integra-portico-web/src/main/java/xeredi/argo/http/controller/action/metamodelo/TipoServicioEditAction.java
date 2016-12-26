package xeredi.argo.http.controller.action.metamodelo;

import java.util.List;

import com.google.inject.Inject;

import lombok.Getter;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.metamodelo.service.TipoDatoService;
import xeredi.argo.model.metamodelo.service.TipoServicioService;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.TipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoElemento;
import xeredi.argo.model.metamodelo.vo.TipoServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoServicioEditAction.
 */
public final class TipoServicioEditAction extends EntidadEditAction<TipoServicioVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7056943059440927593L;

	/** The tpdt estado list. */
	@Getter
	private List<LabelValueVO> tpdtEstadoList;

	@Inject
	private TipoDatoService tpdtService;

	@Inject
	private TipoServicioService tpsrService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificEdit() throws ApplicationException {
		if (accion == AccionCodigo.edit) {
			model = tpsrService.select(model.getId(), getIdioma());
		} else {
			model = new TipoServicioVO();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificLoadDependencies() throws ApplicationException {
		final TipoDatoCriterioVO tpdtCriterio = new TipoDatoCriterioVO();

		tpdtCriterio.setTipoElemento(TipoElemento.CR);
		tpdtCriterio.setIdioma(getIdioma());

		tpdtEstadoList = tpdtService.selectLabelValues(tpdtCriterio);
	}
}
