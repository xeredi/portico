package xeredi.integra.http.controller.action.seguridad;

import xeredi.integra.http.controller.action.CrudAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.seguridad.bo.AccionBO;
import xeredi.integra.model.seguridad.vo.AccionCriterioVO;
import xeredi.integra.model.seguridad.vo.AccionVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionAction.
 */
public final class AccionAction extends CrudAction<AccionVO> {
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2087143271224957828L;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final AccionBO accnBO = new AccionBO();
        final AccionCriterioVO accnCriterio = new AccionCriterioVO();

        accnCriterio.setId(model.getId());

        model = accnBO.selectObject(accnCriterio);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void doEdit() throws ApplicationException {
        if (model == null) {
            model = new AccionVO();
        }

        if (accion == ACCION_EDICION.edit) {
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
    protected void doSave() throws ApplicationException {
        if (model == null) {
            model = new AccionVO();
        }

        if (accion == ACCION_EDICION.edit) {
            Preconditions.checkNotNull(model.getId());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.accn_codigo, model.getCodigo());
        FieldValidator.validateRequired(this, MessageI18nKey.accn_nombre, model.getNombre());

        if (!hasErrors()) {
            final AccionBO accnBO = new AccionBO();

            switch (accion) {
            case create:
                accnBO.insert(model);

                break;
            case edit:
                accnBO.update(model);

                break;

            default:
                throw new Error("Accion no implementada: " + accion);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void doRemove() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final AccionBO accnBO = new AccionBO();

        accnBO.delete(model);
    }

}
