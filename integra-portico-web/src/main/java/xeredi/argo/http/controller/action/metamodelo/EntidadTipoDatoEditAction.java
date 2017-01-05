package xeredi.argo.http.controller.action.metamodelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.I18nService;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.metamodelo.service.EntidadGrupoDatoService;
import xeredi.argo.model.metamodelo.service.EntidadTipoDatoService;
import xeredi.argo.model.metamodelo.service.TipoDatoService;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.EntidadGrupoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TipoDatoCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadTipoDatoEditAction.
 */
public final class EntidadTipoDatoEditAction extends CrudEditAction<EntidadTipoDatoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3500048499586562595L;

	/** The i18n map. */
	@Getter
	private Map<String, I18nVO> i18nMap;

	/** The engd list. */
	@Getter
	private final List<LabelValueVO> engdList = new ArrayList<>();

	/** The tpdt list. */
	@Getter
	private final List<LabelValueVO> tpdtList = new ArrayList<>();

	/** The tpdt service. */
	@Inject
	private TipoDatoService tpdtService;

	@Inject
	private I18nService i18nService;

	@Inject
	private EntidadTipoDatoService entdService;

	@Inject
	private EntidadGrupoDatoService engdService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doEdit() throws ApplicationException {
		Preconditions.checkNotNull(model.getEntiId());

		if (accion == AccionCodigo.create) {
			i18nMap = new HashMap<>();
		} else {
			Preconditions.checkNotNull(model.getId());

			model = entdService.select(model.getId(), getIdioma());
			i18nMap = i18nService.selectMap(model);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doLoadDependencies() throws ApplicationException {
		if (accion == AccionCodigo.create) {
			final EntidadGrupoDatoCriterioVO engdCriterio = new EntidadGrupoDatoCriterioVO();

			engdCriterio.setEntiId(model.getEntiId());
			engdCriterio.setIdioma(getIdioma());

			engdList.addAll(engdService.selectLabelValues(engdCriterio));

			final TipoDatoCriterioVO tpdtCriterioVO = new TipoDatoCriterioVO();

			tpdtCriterioVO.setIdioma(getIdioma());

			tpdtList.addAll(tpdtService.selectLabelValues(tpdtCriterioVO));
		}
	}
}
