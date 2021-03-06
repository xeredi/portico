package xeredi.argo.http.controller.action.metamodelo;

import java.util.List;

import javax.inject.Inject;

import lombok.Getter;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.service.TipoParametroService;
import xeredi.argo.model.metamodelo.service.TipoSubparametroService;
import xeredi.argo.model.metamodelo.vo.TipoParametroVO;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroDetailAction.
 */
public final class TipoParametroDetailAction extends EntidadDetailAction<TipoParametroVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 9182419626664730526L;

	/** The tpsp list. */
	@Getter
	private List<TipoSubparametroVO> subentiList;

	@Inject
	private TipoParametroService tpprService;

	@Inject
	private TipoSubparametroService tpspService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificDetail() throws ApplicationException {
		model = tpprService.select(model.getId(), getIdioma());

		final TipoSubparametroCriterioVO tpspCriterio = new TipoSubparametroCriterioVO();

		tpspCriterio.setTpprId(model.getId());
		tpspCriterio.setIdioma(getIdioma());

		subentiList = tpspService.selectList(tpspCriterio);
	}
}
