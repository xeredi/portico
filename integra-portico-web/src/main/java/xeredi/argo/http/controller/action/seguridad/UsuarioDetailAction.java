package xeredi.argo.http.controller.action.seguridad;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.google.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.model.seguridad.service.GrupoService;
import xeredi.argo.model.seguridad.service.UsuarioService;
import xeredi.argo.model.seguridad.vo.GrupoCriterioVO;
import xeredi.argo.model.seguridad.vo.GrupoVO;
import xeredi.argo.model.seguridad.vo.UsuarioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioDetailAction.
 */
public final class UsuarioDetailAction extends CrudDetailAction<UsuarioVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6846870204891602906L;

	/** The grpo list. */
	@Getter
	private List<GrupoVO> grpoList;

	/** The orga enti id. */
	@Getter
	private final Long orgaEntiId = Entidad.ORGANIZACION.getId();

	/** The fref. */
	@Getter
	private final Date fref = Calendar.getInstance().getTime();

	/** The usro service. */
	@Inject
	private UsuarioService usroService;

	/** The grpo service. */
	@Inject
	private GrupoService grpoService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doDetail() throws ApplicationException {
		model = usroService.select(model.getId(), getIdioma());

		final GrupoCriterioVO grpoCriterio = new GrupoCriterioVO();

		grpoCriterio.setUsroId(model.getId());

		grpoList = grpoService.selectList(grpoCriterio);
	}
}
