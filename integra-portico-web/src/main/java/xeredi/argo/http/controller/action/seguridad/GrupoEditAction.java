package xeredi.argo.http.controller.action.seguridad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.AccionEntidadBO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionEntidadVO;
import xeredi.argo.model.seguridad.bo.AccionBO;
import xeredi.argo.model.seguridad.bo.GrupoBO;
import xeredi.argo.model.seguridad.vo.AccionCodigo;
import xeredi.argo.model.seguridad.vo.AccionCriterioVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;
import xeredi.argo.model.seguridad.vo.AccionVO;
import xeredi.argo.model.seguridad.vo.GrupoVO;

import com.google.common.base.Preconditions;

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
    private Map<AccionPrefix, List<AccionVO>> accnMap;

    /** The enti list. */
    @Getter
    private List<Long> entiList;

    /** The acen map. */
    @Getter
    private Map<Long, List<AccionEntidadVO>> acenMap;

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
        final AccionBO accnBO = new AccionBO();
        final AccionCriterioVO accnCriterio = new AccionCriterioVO();

        final List<AccionVO> accnList = accnBO.selectList(accnCriterio);

        prefixList = new ArrayList<>();
        accnMap = new HashMap<>();

        for (final AccionVO accn : accnList) {
            if (!accnMap.containsKey(accn.getPrefix())) {
                prefixList.add(accn.getPrefix());
                accnMap.put(accn.getPrefix(), new ArrayList<AccionVO>());
            }

            accnMap.get(accn.getPrefix()).add(accn);
        }

        final AccionEntidadBO acenBO = new AccionEntidadBO();
        final AccionEntidadCriterioVO acenCriterio = new AccionEntidadCriterioVO();

        acenCriterio.setIdioma(getIdioma());

        final List<AccionEntidadVO> acenList = acenBO.selectList(acenCriterio);

        entiList = new ArrayList<>();
        acenMap = new HashMap<>();

        for (final AccionEntidadVO acen : acenList) {
            if (!acenMap.containsKey(acen.getEntiId())) {
                entiList.add(acen.getEntiId());
                acenMap.put(acen.getEntiId(), new ArrayList<AccionEntidadVO>());
            }

            acenMap.get(acen.getEntiId()).add(acen);
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
