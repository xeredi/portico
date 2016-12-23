package xeredi.argo.http.controller.action.seguridad;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.PuertoService;
import xeredi.argo.model.comun.service.SuperpuertoService;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.comun.vo.SuperpuertoCriterioVO;
import xeredi.argo.model.comun.vo.SuperpuertoVO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.model.seguridad.service.GrupoService;
import xeredi.argo.model.seguridad.service.UsuarioService;
import xeredi.argo.model.seguridad.vo.GrupoCriterioVO;
import xeredi.argo.model.seguridad.vo.GrupoVO;
import xeredi.argo.model.seguridad.vo.UsuarioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioEditAction.
 */
public final class UsuarioEditAction extends CrudEditAction<UsuarioVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4943518127497768526L;

	/** The grpo list. */
	@Getter
	private List<GrupoVO> grpoList;

	/** The sprt list. */
	@Getter
	private List<SuperpuertoVO> sprtList;

	/** The prto list. */
	@Getter
	private List<PuertoVO> prtoList;

	/** The orga enti id. */
	@Getter
	private final Long orgaEntiId = Entidad.ORGANIZACION.getId();

	/** The fref. */
	@Getter
	private final Date fref = Calendar.getInstance().getTime();

	/** The usro service. */
	@Inject
	private UsuarioService usroService;

	@Inject
	private GrupoService grpoService;

	@Inject
	private PuertoService prtoService;

	@Inject
	private SuperpuertoService sprtService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doEdit() throws ApplicationException {
		if (accion == AccionCodigo.create) {
			model = new UsuarioVO();
		} else {
			Preconditions.checkNotNull(model.getId());

			model = usroService.select(model.getId(), getIdioma());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doLoadDependencies() throws ApplicationException {
		final GrupoCriterioVO grpoCriterio = new GrupoCriterioVO();

		grpoList = grpoService.selectList(grpoCriterio);

		final SuperpuertoCriterioVO sprtCriterio = new SuperpuertoCriterioVO();

		sprtCriterio.setIdioma(getIdioma());

		sprtList = sprtService.selectList(sprtCriterio);

		final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

		prtoCriterio.setIdioma(getIdioma());

		prtoList = prtoService.selectList(prtoCriterio);
	}
}
