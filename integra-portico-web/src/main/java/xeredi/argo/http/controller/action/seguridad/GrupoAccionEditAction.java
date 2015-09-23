package xeredi.argo.http.controller.action.seguridad;

import java.util.List;

import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.seguridad.bo.AccionBO;
import xeredi.argo.model.seguridad.bo.GrupoBO;
import xeredi.argo.model.seguridad.vo.AccionCriterioVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;
import xeredi.argo.model.seguridad.vo.AccionVO;
import xeredi.argo.model.seguridad.vo.GrupoAccionVO;
import xeredi.argo.model.seguridad.vo.GrupoCriterioVO;
import xeredi.argo.model.seguridad.vo.GrupoVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class GrupoAccionEditAction.
 */
public final class GrupoAccionEditAction extends CrudEditAction<GrupoAccionVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5523502920398476373L;

    /** The grpo list. */
    private List<GrupoVO> grpoList;

    /** The accn list. */
    private List<AccionVO> accnList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        Preconditions.checkArgument(model.getAccnId() != null || model.getGrpoId() != null);
        Preconditions.checkArgument(accion == ACCION_EDICION.create);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        if (model.getAccnId() != null) {
            final GrupoBO grpoBO = new GrupoBO();
            final GrupoCriterioVO grpoCriterio = new GrupoCriterioVO();

            grpoList = grpoBO.selectList(grpoCriterio);
        }

        if (model.getGrpoId() != null) {
            final AccionBO accnBO = new AccionBO();
            final AccionCriterioVO accnCriterio = new AccionCriterioVO();

            accnList = accnBO.selectList(accnCriterio);
        }
    }

    /**
     * Gets the grpo list.
     *
     * @return the grpo list
     */
    public List<GrupoVO> getGrpoList() {
        return grpoList;
    }

    /**
     * Gets the accn list.
     *
     * @return the accn list
     */
    public List<AccionVO> getAccnList() {
        return accnList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.grac;
    }
}
