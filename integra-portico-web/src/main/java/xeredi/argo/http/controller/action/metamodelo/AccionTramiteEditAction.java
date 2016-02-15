package xeredi.argo.http.controller.action.metamodelo;

import java.util.List;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.AccionTramiteBO;
import xeredi.argo.model.metamodelo.vo.AccionTramiteCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionTramiteVO;
import xeredi.argo.model.seguridad.bo.AccionBO;
import xeredi.argo.model.seguridad.bo.GrupoBO;
import xeredi.argo.model.seguridad.vo.AccionCodigo;
import xeredi.argo.model.seguridad.vo.AccionCriterioVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;
import xeredi.argo.model.seguridad.vo.AccionVO;
import xeredi.argo.model.seguridad.vo.GrupoCriterioVO;
import xeredi.argo.model.seguridad.vo.GrupoVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionTramiteEditAction.
 */
public final class AccionTramiteEditAction extends CrudEditAction<AccionTramiteVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6768277735619352592L;

    /** Prefijo de acción. */
    @Getter
    private final AccionPrefix accnPrefix = AccionPrefix.actr;

    /** The accn list. */
    @Getter
    private List<AccionVO> accnList;

    /** The grpo list. */
    @Getter
    private List<GrupoVO> grpoList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        if (accion == AccionCodigo.create) {
            Preconditions.checkNotNull(model.getTrmtId());
        } else {
            Preconditions.checkNotNull(model.getId());

            final AccionTramiteBO actrBO = new AccionTramiteBO();
            final AccionTramiteCriterioVO actrCriterio = new AccionTramiteCriterioVO();

            actrCriterio.setId(model.getId());

            model = actrBO.selectObject(actrCriterio);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        final AccionBO accnBO = new AccionBO();
        final AccionCriterioVO accnCriterio = new AccionCriterioVO();

        accnCriterio.setPrefix(AccionPrefix.ittr);

        accnList = accnBO.selectList(accnCriterio);

        final GrupoBO grpoBO = new GrupoBO();
        final GrupoCriterioVO grpoCriterio = new GrupoCriterioVO();

        grpoList = grpoBO.selectList(grpoCriterio);
    }
}
