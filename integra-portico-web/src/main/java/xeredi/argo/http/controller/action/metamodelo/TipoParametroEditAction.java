package xeredi.argo.http.controller.action.metamodelo;

import java.util.List;

import javax.inject.Inject;

import lombok.Getter;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.metamodelo.service.TipoDatoService;
import xeredi.argo.model.metamodelo.service.TipoParametroService;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.TipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoElemento;
import xeredi.argo.model.metamodelo.vo.TipoParametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroEditAction.
 */
public final class TipoParametroEditAction extends EntidadEditAction<TipoParametroVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8635600431187631918L;

	/** The tpdt nombre list. */
	@Getter
	private List<LabelValueVO> tpdtNombreList;

	/** The tpdt service. */
	@Inject
	private TipoDatoService tpdtService;

	/** The tppr service. */
	@Inject
	private TipoParametroService tpprService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificEdit() throws ApplicationException {
		if (accion == AccionCodigo.edit) {
			model = tpprService.select(model.getId(), getIdioma());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificLoadDependencies() throws ApplicationException {
		final TipoDatoCriterioVO tpdtCriterio = new TipoDatoCriterioVO();

		tpdtCriterio.setTipoElemento(TipoElemento.TX);
		tpdtCriterio.setIdioma(getIdioma());

		tpdtNombreList = tpdtService.selectLabelValues(tpdtCriterio);
	}
}
