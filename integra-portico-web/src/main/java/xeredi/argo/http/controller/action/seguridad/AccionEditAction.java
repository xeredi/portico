package xeredi.argo.http.controller.action.seguridad;

import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.seguridad.bo.AccionBO;
import xeredi.argo.model.seguridad.vo.AccionCriterioVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;
import xeredi.argo.model.seguridad.vo.AccionVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionEditAction.
 */
public final class AccionEditAction extends CrudEditAction<AccionVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3956096847895499243L;

    /** The prefix list. */
    private AccionPrefix[] prefixList;

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
        prefixList = AccionPrefix.values();
    }

    /**
     * Gets the prefix list.
     *
     * @return the prefix list
     */
    public AccionPrefix[] getPrefixList() {
        return prefixList;
    }
}
