package xeredi.argo.http.controller.action.seguridad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
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
 * The Class GrupoDetailAction.
 */
public final class GrupoDetailAction extends CrudDetailAction<GrupoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1779406545837488228L;

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
	public void doDetail() throws ApplicationException {
		model = grpoService.select(model.getId());

		// Modulos
		final ModuloCriterioVO mdloCriterio = new ModuloCriterioVO();

		mdloCriterio.setGrpoId(model.getId());

		mdloList = mdloService.selectList(mdloCriterio);

		// Acciones Base
		final AccionBaseCriterioVO acbsCriterio = new AccionBaseCriterioVO();

		acbsCriterio.setGrpoId(model.getId());

		final List<AccionBaseVO> acbsList = acbsService.selectList(acbsCriterio);

		prefixList = new ArrayList<>();
		acbsMap = new HashMap<>();

		for (final AccionBaseVO acbs : acbsList) {
			if (!acbsMap.containsKey(acbs.getPrefix())) {
				prefixList.add(acbs.getPrefix());
				acbsMap.put(acbs.getPrefix(), new ArrayList<AccionBaseVO>());
			}

			acbsMap.get(acbs.getPrefix()).add(acbs);
		}

		// Entidades
		entiList = new ArrayList<>();

		for (final EntidadVO enti : entiService.selectList(new EntidadCriterioVO())) {
			entiList.add(enti.getId());
		}

		// Acciones asociadas a entidad
		final AccionEntidadCriterioVO acenCriterio = new AccionEntidadCriterioVO();

		acenCriterio.setGrpoId(model.getId());
		acenCriterio.setIdioma(getIdioma());

		acenMap = new HashMap<>();

		for (final AccionEntidadVO acen : acenService.selectList(acenCriterio)) {
			if (!acenMap.containsKey(acen.getEntiId())) {
				acenMap.put(acen.getEntiId(), new ArrayList<AccionEntidadVO>());
			}

			acenMap.get(acen.getEntiId()).add(acen);
		}

		// Acciones especiales
		final AccionEspecialCriterioVO acesCriterio = new AccionEspecialCriterioVO();

		acesCriterio.setGrpoId(model.getId());
		acesCriterio.setIdioma(getIdioma());

		acesMap = new HashMap<>();

		for (final AccionEspecialVO aces : acesService.selectList(acesCriterio)) {
			if (!acesMap.containsKey(aces.getEntiId())) {
				acesMap.put(aces.getEntiId(), new ArrayList<AccionEspecialVO>());
			}

			acesMap.get(aces.getEntiId()).add(aces);
		}

		// Tramites
		final TramiteCriterioVO trmtCriterio = new TramiteCriterioVO();

		trmtCriterio.setGrpoId(model.getId());
		trmtCriterio.setIdioma(getIdioma());

		trmtMap = new HashMap<>();

		for (final TramiteVO trmt : trmtService.selectList(trmtCriterio)) {
			if (!trmtMap.containsKey(trmt.getEntiId())) {
				trmtMap.put(trmt.getEntiId(), new ArrayList<TramiteVO>());
			}

			trmtMap.get(trmt.getEntiId()).add(trmt);
		}

	}
}
