package xeredi.argo.http.controller.action.seguridad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.metamodelo.service.AccionBaseService;
import xeredi.argo.model.metamodelo.service.AccionEntidadService;
import xeredi.argo.model.metamodelo.service.AccionEspecialService;
import xeredi.argo.model.metamodelo.service.EntidadService;
import xeredi.argo.model.metamodelo.service.ModuloService;
import xeredi.argo.model.metamodelo.service.TramiteService;
import xeredi.argo.model.metamodelo.vo.AccionBaseCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionBaseVO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.AccionEntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadVO;
import xeredi.argo.model.metamodelo.vo.AccionEspecialCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionEspecialVO;
import xeredi.argo.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadVO;
import xeredi.argo.model.metamodelo.vo.ModuloCriterioVO;
import xeredi.argo.model.metamodelo.vo.ModuloVO;
import xeredi.argo.model.metamodelo.vo.TramiteCriterioVO;
import xeredi.argo.model.metamodelo.vo.TramiteVO;
import xeredi.argo.model.seguridad.service.GrupoService;
import xeredi.argo.model.seguridad.vo.GrupoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class GrupoEditAction.
 */

/**
 * Instantiates a new grupo edit action.
 */
public final class GrupoEditAction extends CrudEditAction<GrupoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5574343207861340756L;

	/** The mdlo list. */
	@Getter
	private List<ModuloVO> mdloList;

	/** The prefix list. */
	@Getter
	private List<ClassPrefix> prefixList;

	/** The accn map. */
	@Getter
	private Map<ClassPrefix, List<AccionBaseVO>> acbsMap;

	/** The enti list. */
	@Getter
	private List<Long> entiList;

	/** The acen map. */
	@Getter
	private Map<Long, List<AccionEntidadVO>> acenMap;

	/** The aces map. */
	@Getter
	private Map<Long, List<AccionEspecialVO>> acesMap;

	/** The trmt map. */
	@Getter
	private Map<Long, List<TramiteVO>> trmtMap;

	@Inject
	private GrupoService grpoService;

	@Inject
	private EntidadService entiService;

	@Inject
	private ModuloService mdloService;

	@Inject
	private TramiteService trmtService;

	@Inject
	private AccionEspecialService acesService;

	@Inject
	private AccionEntidadService acenService;

	@Inject
	private AccionBaseService acbsService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doEdit() throws ApplicationException {
		if (accion == AccionCodigo.create) {
			model = new GrupoVO();
		} else {
			Preconditions.checkNotNull(model.getId());

			model = grpoService.select(model.getId());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doLoadDependencies() throws ApplicationException {
		// Modulos
		final ModuloCriterioVO mdloCriterio = new ModuloCriterioVO();

		mdloCriterio.setIdioma(getIdioma());

		mdloList = mdloService.selectList(mdloCriterio);

		// Entidades
		entiList = new ArrayList<>();

		for (final EntidadVO enti : entiService.selectList(new EntidadCriterioVO())) {
			entiList.add(enti.getId());
		}

		// Acciones base
		prefixList = new ArrayList<>();
		acbsMap = new HashMap<>();

		final AccionBaseCriterioVO acbsCriterio = new AccionBaseCriterioVO();

		acbsCriterio.setIdioma(getIdioma());

		for (final AccionBaseVO acbs : acbsService.selectList(acbsCriterio)) {
			if (!acbsMap.containsKey(acbs.getPrefix())) {
				prefixList.add(acbs.getPrefix());
				acbsMap.put(acbs.getPrefix(), new ArrayList<AccionBaseVO>());
			}

			acbsMap.get(acbs.getPrefix()).add(acbs);
		}

		// Acciones asociadas a entidad
		acenMap = new HashMap<>();

		final AccionEntidadCriterioVO acenCriterio = new AccionEntidadCriterioVO();

		acenCriterio.setIdioma(getIdioma());

		for (final AccionEntidadVO acen : acenService.selectList(acenCriterio)) {
			if (!acenMap.containsKey(acen.getEntiId())) {
				acenMap.put(acen.getEntiId(), new ArrayList<AccionEntidadVO>());
			}

			acenMap.get(acen.getEntiId()).add(acen);
		}

		// Acciones especiales
		acesMap = new HashMap<>();

		final AccionEspecialCriterioVO acesCriterio = new AccionEspecialCriterioVO();

		acesCriterio.setIdioma(getIdioma());

		for (final AccionEspecialVO aces : acesService.selectList(acesCriterio)) {
			if (!acesMap.containsKey(aces.getEntiId())) {
				acesMap.put(aces.getEntiId(), new ArrayList<AccionEspecialVO>());
			}

			acesMap.get(aces.getEntiId()).add(aces);
		}

		// Tramites
		trmtMap = new HashMap<>();

		final TramiteCriterioVO trmtCriterio = new TramiteCriterioVO();

		trmtCriterio.setIdioma(getIdioma());

		for (final TramiteVO trmt : trmtService.selectList(trmtCriterio)) {
			if (!trmtMap.containsKey(trmt.getEntiId())) {
				trmtMap.put(trmt.getEntiId(), new ArrayList<TramiteVO>());
			}

			trmtMap.get(trmt.getEntiId()).add(trmt);
		}
	}
}
