package xeredi.integra.http.controller.action.maestro;

import xeredi.integra.http.controller.action.item.ItemSaveAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.maestro.bo.SubparametroBO;
import xeredi.integra.model.maestro.vo.SubparametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubparametroDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubparametroProxy;

import com.google.common.base.Preconditions;

/**
 * The Class SubparametroSaveAction.
 */
public final class SubparametroSaveAction extends ItemSaveAction<SubparametroVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1118698219019756413L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificValidate() throws ApplicationException {
        final TipoSubparametroDetailVO enti = TipoSubparametroProxy.select(model.getEntiId());

        if (accion != ACCION_EDICION.edit) {
            FieldValidator.validateRequired(this, getText("enti_" + enti.getEnti().getTpprAsociado().getId()),
                    model.getPrmtAsociado());
        }

        if (accion != ACCION_EDICION.create) {
            Preconditions.checkNotNull(model.getId());
            Preconditions.checkNotNull(model.getVersion());
            Preconditions.checkNotNull(model.getVersion().getId());
        }

        if (model.getVersion() == null) {
            FieldValidator.validateRequired(this, MessageI18nKey.fini, model.getVersion());
        } else {
            FieldValidator.validateRequired(this, MessageI18nKey.fini, model.getVersion().getFini());
            FieldValidator.validatePeriod(this, model.getVersion().getFini(), model.getVersion().getFfin());
        }

        FieldValidator.validateItem(this, enti, model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final SubparametroBO itemBO = new SubparametroBO();
        final TipoSubparametroDetailVO enti = TipoSubparametroProxy.select(model.getEntiId());

        switch (accion) {
        case create:
            itemBO.insert(model, enti);

            break;
        case edit:
            itemBO.update(model, enti);

            break;
        case duplicate:
            itemBO.duplicate(model, enti);

            break;
        default:
            throw new Error("Accion no valida: " + accion);
        }
    }
}
