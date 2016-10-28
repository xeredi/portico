package xeredi.argo.http.controller.action.seguridad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.AccionBaseBO;
import xeredi.argo.model.metamodelo.bo.AccionEntidadBO;
import xeredi.argo.model.metamodelo.bo.AccionEspecialBO;
import xeredi.argo.model.metamodelo.bo.EntidadBO;
import xeredi.argo.model.metamodelo.bo.TramiteBO;
import xeredi.argo.model.metamodelo.vo.AccionBaseCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionBaseVO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.AccionEntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadVO;
import xeredi.argo.model.metamodelo.vo.AccionEspecialCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionEspecialVO;
import xeredi.argo.model.metamodelo.vo.AccionPrefix;
import xeredi.argo.model.metamodelo.vo.EntidadVO;
import xeredi.argo.model.metamodelo.vo.TramiteCriterioVO;
import xeredi.argo.model.metamodelo.vo.TramiteVO;
import xeredi.argo.model.seguridad.bo.GrupoBO;
import xeredi.argo.model.seguridad.vo.GrupoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class GrupoEditAction.
 */
public final class GrupoEditAction extends CrudEditAction<GrupoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5574343207861340756L;

    /** The prefix list. */
    @Getter
    private List<AccionPrefix> prefixList;

    /** The accn map. */
    @Getter
    private Map<AccionPrefix, List<AccionBaseVO>> acbsMap;

    /** The enti list. */
    @Getter
    private List<Long> entiList;

    /** The acen map. */
    @Getter
    private Map<Long, List<AccionEntidadVO>> acenMap;

    @Getter
    private Map<Long, List<AccionEspecialVO>> acesMap;

    @Getter
    private Map<Long, List<TramiteVO>> trmtMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        if (accion == AccionCodigo.create) {
            model = new GrupoVO();
        } else {
            Preconditions.checkNotNull(model.getId());

            final GrupoBO grpoBO = new GrupoBO();

            model = grpoBO.select(model.getId());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        // Entidades
        entiList = new ArrayList<>();

        for (final EntidadVO enti : new EntidadBO().selectList(null)) {
            entiList.add(enti.getId());
        }

        // Acciones base
        prefixList = new ArrayList<>();
        acbsMap = new HashMap<>();

        final AccionBaseCriterioVO acbsCriterio = new AccionBaseCriterioVO();

        acbsCriterio.setIdioma(getIdioma());

        for (final AccionBaseVO acbs : new AccionBaseBO().selectList(acbsCriterio)) {
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

        for (final AccionEntidadVO acen : new AccionEntidadBO().selectList(acenCriterio)) {
            if (!acenMap.containsKey(acen.getEntiId())) {
                acenMap.put(acen.getEntiId(), new ArrayList<AccionEntidadVO>());
            }

            acenMap.get(acen.getEntiId()).add(acen);
        }

        // Acciones especiales
        acesMap = new HashMap<>();

        final AccionEspecialCriterioVO acesCriterio = new AccionEspecialCriterioVO();

        acesCriterio.setIdioma(getIdioma());

        for (final AccionEspecialVO aces : new AccionEspecialBO().selectList(acesCriterio)) {
            if (!acesMap.containsKey(aces.getEntiId())) {
                acesMap.put(aces.getEntiId(), new ArrayList<AccionEspecialVO>());
            }

            acesMap.get(aces.getEntiId()).add(aces);
        }

        // Tramites
        trmtMap = new HashMap<>();

        final TramiteCriterioVO trmtCriterio = new TramiteCriterioVO();

        trmtCriterio.setIdioma(getIdioma());

        for (final TramiteVO trmt : new TramiteBO().selectList(trmtCriterio)) {
            if (!trmtMap.containsKey(trmt.getEntiId())) {
                trmtMap.put(trmt.getEntiId(), new ArrayList<TramiteVO>());
            }

            trmtMap.get(trmt.getEntiId()).add(trmt);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.grpo;
    }
}
