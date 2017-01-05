package xeredi.argo.http.controller.action.metamodelo;

import java.util.List;
import java.util.Map;

import com.google.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.I18nService;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.metamodelo.service.AccionEntidadService;
import xeredi.argo.model.metamodelo.service.AccionEspecialService;
import xeredi.argo.model.metamodelo.service.EntidadGrupoDatoService;
import xeredi.argo.model.metamodelo.service.EntidadTipoDatoService;
import xeredi.argo.model.metamodelo.vo.AccionEntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadVO;
import xeredi.argo.model.metamodelo.vo.AccionEspecialCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionEspecialVO;
import xeredi.argo.model.metamodelo.vo.EntidadGrupoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadGrupoDatoVO;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.argo.model.metamodelo.vo.EntidadVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadDetailAction.
 *
 * @param <T>
 *            the generic type
 */
public abstract class EntidadDetailAction<T extends EntidadVO> extends CrudDetailAction<T> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2541307413836565323L;

	/** The i18n map. */
	@Getter
	protected Map<String, I18nVO> i18nMap;

	/** The entd list. */
	@Getter
	protected List<EntidadTipoDatoVO> entdList;

	/** The engd list. */
	@Getter
	protected List<EntidadGrupoDatoVO> engdList;

	/** The enac list. */
	@Getter
	protected List<AccionEspecialVO> acesList;

	/** The acen list. */
	@Getter
	protected List<AccionEntidadVO> acenList;

	@Inject
	private I18nService i18nService;

	@Inject
	private AccionEspecialService acesService;

	@Inject
	private AccionEntidadService acenService;

	@Inject
	private EntidadTipoDatoService entdService;

	@Inject
	private EntidadGrupoDatoService engdService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void doDetail() throws ApplicationException {
		doSpecificDetail();

		i18nMap = i18nService.selectMap(model);

		final EntidadTipoDatoCriterioVO entdCriterio = new EntidadTipoDatoCriterioVO();

		entdCriterio.setEntiId(model.getId());
		entdCriterio.setIdioma(getIdioma());

		entdList = entdService.selectList(entdCriterio);

		final EntidadGrupoDatoCriterioVO engdCriterio = new EntidadGrupoDatoCriterioVO();

		engdCriterio.setEntiId(model.getId());
		engdCriterio.setIdioma(getIdioma());

		engdList = engdService.selectList(engdCriterio);

		final AccionEspecialCriterioVO acesCriterio = new AccionEspecialCriterioVO();

		acesCriterio.setEntiId(model.getId());
		acesCriterio.setIdioma(getIdioma());

		acesList = acesService.selectList(acesCriterio);

		final AccionEntidadCriterioVO acenCriterio = new AccionEntidadCriterioVO();

		acenCriterio.setEntiId(model.getId());

		acenList = acenService.selectList(acenCriterio);
	}

	/**
	 * Do specific detail.
	 *
	 * @throws ApplicationException
	 *             the application exception
	 */
	public abstract void doSpecificDetail() throws ApplicationException;
}
