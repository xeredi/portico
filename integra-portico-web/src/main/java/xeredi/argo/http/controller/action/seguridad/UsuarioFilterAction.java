package xeredi.argo.http.controller.action.seguridad;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.google.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.GridFilterAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.I18nService;
import xeredi.argo.model.comun.service.PuertoService;
import xeredi.argo.model.comun.service.SuperpuertoService;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.comun.vo.SuperpuertoCriterioVO;
import xeredi.argo.model.comun.vo.SuperpuertoVO;
import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.model.seguridad.service.GrupoService;
import xeredi.argo.model.seguridad.vo.GrupoCriterioVO;
import xeredi.argo.model.seguridad.vo.GrupoVO;
import xeredi.argo.model.seguridad.vo.UsuarioCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioFilterAction.
 */
public final class UsuarioFilterAction extends GridFilterAction<UsuarioCriterioVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6193819984435577729L;

	/** The sprt list. */
	@Getter
	private List<SuperpuertoVO> sprtList;

	/** The prto list. */
	@Getter
	private List<PuertoVO> prtoList;

	/** The grpo list. */
	@Getter
	private List<GrupoVO> grpoList;

	/** The orga enti id. */
	@Getter
	private final Long orgaEntiId = Entidad.ORGANIZACION.getId();

	/** The fref. */
	@Getter
	private final Date fref = Calendar.getInstance().getTime();

	@Inject
	private GrupoService grpoService;

	@Inject
	private PuertoService prtoService;

	@Inject
	private SuperpuertoService sprtService;

	@Inject
	private I18nService i18nService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doPrepareFilter() throws ApplicationException {
		// noop
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doLoadDependencies() throws ApplicationException {
		final SuperpuertoCriterioVO sprtCriterio = new SuperpuertoCriterioVO();

		sprtCriterio.setIdioma(getIdioma());

		sprtList = sprtService.selectList(sprtCriterio);

		final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

		prtoCriterio.setIdioma(getIdioma());

		prtoList = prtoService.selectList(prtoCriterio);

		final GrupoCriterioVO grpoCriterio = new GrupoCriterioVO();

		grpoCriterio.setIdioma(getIdioma());

		grpoList = grpoService.selectList(grpoCriterio);
	}
}
