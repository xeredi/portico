package xeredi.argo.http.controller.action.seguridad;

import java.util.List;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.seguridad.bo.AccionBO;
import xeredi.argo.model.seguridad.bo.GrupoBO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;
import xeredi.argo.model.seguridad.vo.AccionVO;
import xeredi.argo.model.seguridad.vo.GrupoCriterioVO;
import xeredi.argo.model.seguridad.vo.GrupoVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionEditAction.
 */
public final class AccionEditAction extends CrudEditAction<AccionVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3956096847895499243L;

    /** The prefix list. */
    @Getter
    private AccionPrefix[] prefixList;

    /** The grpo list. */
    @Getter
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

            model = accnBO.select(model.getId());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        prefixList = AccionPrefix.values();

        final GrupoBO grpoBO = new GrupoBO();
        final GrupoCriterioVO grpoCriterio = new GrupoCriterioVO();

        grpoList = grpoBO.selectList(grpoCriterio);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.accn;
    }
}
