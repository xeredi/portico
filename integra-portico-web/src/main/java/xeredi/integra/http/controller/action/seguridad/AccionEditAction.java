package xeredi.integra.http.controller.action.seguridad;

import java.util.List;

import xeredi.integra.http.controller.action.comun.CrudEditAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.seguridad.bo.AccionBO;
import xeredi.integra.model.seguridad.bo.GrupoBO;
import xeredi.integra.model.seguridad.vo.AccionCriterioVO;
import xeredi.integra.model.seguridad.vo.AccionVO;
import xeredi.integra.model.seguridad.vo.GrupoCriterioVO;
import xeredi.integra.model.seguridad.vo.GrupoVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionEditAction.
 */
public final class AccionEditAction extends CrudEditAction<AccionVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3956096847895499243L;

    /** The grpo ids. */
    private List<GrupoVO> grpoList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        if (accion == ACCION_EDICION.create) {
            model = new AccionVO();
        } else {
            Preconditions.checkNotNull(model.getId());

            final AccionBO accnBO = new AccionBO();
            final AccionCriterioVO accnCriterio = new AccionCriterioVO();

            accnCriterio.setId(model.getId());

            model = accnBO.selectObject(accnCriterio);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        final GrupoBO grpoBO = new GrupoBO();
        final GrupoCriterioVO grpoCriterio = new GrupoCriterioVO();

        grpoList = grpoBO.selectList(grpoCriterio);
    }

    /**
     * Gets the grpo list.
     *
     * @return the grpo list
     */
    public List<GrupoVO> getGrpoList() {
        return grpoList;
    }
}
