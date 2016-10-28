package xeredi.argo.http.controller.action.seguridad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.metamodelo.bo.AccionBaseBO;
import xeredi.argo.model.metamodelo.bo.AccionEntidadBO;
import xeredi.argo.model.metamodelo.bo.AccionEspecialBO;
import xeredi.argo.model.metamodelo.bo.EntidadBO;
import xeredi.argo.model.metamodelo.bo.TramiteBO;
import xeredi.argo.model.metamodelo.vo.AccionBaseCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionBaseVO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadVO;
import xeredi.argo.model.metamodelo.vo.AccionEspecialCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionEspecialVO;
import xeredi.argo.model.metamodelo.vo.EntidadVO;
import xeredi.argo.model.metamodelo.vo.TramiteCriterioVO;
import xeredi.argo.model.metamodelo.vo.TramiteVO;
import xeredi.argo.model.seguridad.bo.GrupoBO;
import xeredi.argo.model.seguridad.vo.GrupoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class GrupoDetailAction.
 */
@Data
public final class GrupoDetailAction extends CrudDetailAction<GrupoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1779406545837488228L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.grpo;

	/** The prefix list. */
	private List<ClassPrefix> prefixList;

	/** The accn map. */
	private Map<ClassPrefix, List<AccionBaseVO>> acbsMap;

	/** The enti list. */
	private List<Long> entiList;

	/** The acen map. */
	private Map<Long, List<AccionEntidadVO>> acenMap;

	private Map<Long, List<AccionEspecialVO>> acesMap;

	private Map<Long, List<TramiteVO>> trmtMap;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doDetail() throws ApplicationException {
		Preconditions.checkNotNull(model.getId());

		final GrupoBO grpoBO = new GrupoBO();

		model = grpoBO.select(model.getId());

		final AccionBaseBO acbsBO = new AccionBaseBO();
		final AccionBaseCriterioVO acbsCriterio = new AccionBaseCriterioVO();

		acbsCriterio.setGrpoId(model.getId());

		final List<AccionBaseVO> acbsList = acbsBO.selectList(acbsCriterio);

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
		final EntidadBO entiBO = new EntidadBO();

		entiList = new ArrayList<>();

		for (final EntidadVO enti : entiBO.selectList(null)) {
			entiList.add(enti.getId());
		}

		// Acciones asociadas a entidad
		final AccionEntidadBO acenBO = new AccionEntidadBO();
		final AccionEntidadCriterioVO acenCriterio = new AccionEntidadCriterioVO();

		acenCriterio.setGrpoId(model.getId());
		acenCriterio.setIdioma(getIdioma());

		acenMap = new HashMap<>();

		for (final AccionEntidadVO acen : acenBO.selectList(acenCriterio)) {
			if (!acenMap.containsKey(acen.getEntiId())) {
				acenMap.put(acen.getEntiId(), new ArrayList<AccionEntidadVO>());
			}

			acenMap.get(acen.getEntiId()).add(acen);
		}

		// Acciones especiales
		final AccionEspecialBO acesBO = new AccionEspecialBO();
		final AccionEspecialCriterioVO acesCriterio = new AccionEspecialCriterioVO();

		acesCriterio.setGrpoId(model.getId());
		acesCriterio.setIdioma(getIdioma());

		acesMap = new HashMap<>();

		for (final AccionEspecialVO aces : acesBO.selectList(acesCriterio)) {
			if (!acesMap.containsKey(aces.getEntiId())) {
				acesMap.put(aces.getEntiId(), new ArrayList<AccionEspecialVO>());
			}

			acesMap.get(aces.getEntiId()).add(aces);
		}

		// Tramites
		final TramiteBO trmtBO = new TramiteBO();
		final TramiteCriterioVO trmtCriterio = new TramiteCriterioVO();

		trmtCriterio.setGrpoId(model.getId());
		trmtCriterio.setIdioma(getIdioma());

		trmtMap = new HashMap<>();

		for (final TramiteVO trmt : trmtBO.selectList(trmtCriterio)) {
			if (!trmtMap.containsKey(trmt.getEntiId())) {
				trmtMap.put(trmt.getEntiId(), new ArrayList<TramiteVO>());
			}

			trmtMap.get(trmt.getEntiId()).add(trmt);
		}

	}
}
