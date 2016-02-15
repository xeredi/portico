package xeredi.argo.http.controller.action.metamodelo;

import java.util.List;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.AccionTramiteBO;
import xeredi.argo.model.metamodelo.vo.AccionTramiteCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionTramiteVO;
import xeredi.argo.model.seguridad.bo.GrupoBO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;
import xeredi.argo.model.seguridad.vo.GrupoCriterioVO;
import xeredi.argo.model.seguridad.vo.GrupoVO;

import com.google.common.base.Preconditions;

/**
 * The Class AccionTramiteDetailAction.
 */
public final class AccionTramiteDetailAction extends CrudDetailAction<AccionTramiteVO> {

    /** serialVersionUID. */
    private static final long serialVersionUID = 2544857640890739119L;

    /** Prefijo de accion. */
    @Getter
    private final AccionPrefix accnPrefix = AccionPrefix.actr;

    /** The grpo list. */
    @Getter
    private List<GrupoVO> grpoList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final AccionTramiteBO actrBO = new AccionTramiteBO();
        final AccionTramiteCriterioVO actrCriterio = new AccionTramiteCriterioVO();

        actrCriterio.setId(model.getId());
        actrCriterio.setIdioma(getIdioma());

        model = actrBO.selectObject(actrCriterio);

        final GrupoBO grpoBO = new GrupoBO();
        final GrupoCriterioVO grpoCriterio = new GrupoCriterioVO();

        grpoCriterio.setActrId(model.getId());

        grpoList = grpoBO.selectList(grpoCriterio);
    }
}
