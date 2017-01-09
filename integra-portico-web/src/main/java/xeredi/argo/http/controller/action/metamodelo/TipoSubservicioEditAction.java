package xeredi.argo.http.controller.action.metamodelo;

import java.util.List;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import lombok.Getter;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.metamodelo.service.TipoDatoService;
import xeredi.argo.model.metamodelo.service.TipoSubservicioService;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.TipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoElemento;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubservicioEditAction.
 */
public final class TipoSubservicioEditAction extends EntidadEditAction<TipoSubservicioVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5529476683109631764L;

	/** The tpdt estado list. */
	@Getter
	private List<LabelValueVO> tpdtEstadoList;

	@Inject
	private TipoDatoService tpdtService;

	@Inject
	private TipoSubservicioService tpssService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificEdit() throws ApplicationException {
		if (accion == AccionCodigo.create) {
			Preconditions.checkNotNull(model.getTpsrId());
		} else {
			model = tpssService.select(model.getId(), getIdioma());
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
