package xeredi.argo.http.controller.action.metamodelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.I18nService;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.metamodelo.service.TipoDatoService;
import xeredi.argo.model.metamodelo.service.TipoParametroService;
import xeredi.argo.model.metamodelo.service.TipoServicioService;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.TipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TipoElemento;
import xeredi.argo.model.metamodelo.vo.TipoHtml;
import xeredi.argo.model.metamodelo.vo.TipoParametroCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoParametroVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoDatoEditAction.
 */
public final class TipoDatoEditAction extends CrudEditAction<TipoDatoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6202167642910897080L;

	/** The i18n map. */
	@Getter
	private Map<String, I18nVO> i18nMap;

	/** The tpht list. */
	@Getter
	private TipoHtml[] tphtList;

	/** The tpel list. */
	@Getter
	private TipoElemento[] tpelList;

	/** The tppr list. */
	@Getter
	private List<TipoParametroVO> tpprList;

	/** The tpsr list. */
	@Getter
	private List<TipoServicioVO> tpsrList;

	/** The tpdt service. */
	@Inject
	private TipoDatoService tpdtService;

	/** The i 18 n service. */
	@Inject
	private I18nService i18nService;

	/** The tppr service. */
	@Inject
	private TipoParametroService tpprService;

	@Inject
	private TipoServicioService tpsrService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doEdit() throws ApplicationException {
		if (accion == AccionCodigo.create) {
			model = new TipoDatoVO();
			i18nMap = new HashMap<>();
		} else {
			Preconditions.checkNotNull(model.getId());

			model = tpdtService.select(model.getId(), getIdioma());
			i18nMap = i18nService.selectMap(model);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doLoadDependencies() throws ApplicationException {
		tpelList = TipoElemento.values();
		tphtList = TipoHtml.values();

		final TipoParametroCriterioVO tpprCriterio = new TipoParametroCriterioVO();

		tpprCriterio.setIdioma(getIdioma());

		tpprList = tpprService.selectList(tpprCriterio);

		final TipoServicioCriterioVO tpsrCriterio = new TipoServicioCriterioVO();

		tpsrCriterio.setIdioma(getIdioma());

		tpsrList = tpsrService.selectList(tpsrCriterio);
	}
}
