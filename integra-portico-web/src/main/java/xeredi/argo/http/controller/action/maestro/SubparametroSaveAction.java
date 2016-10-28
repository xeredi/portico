package xeredi.argo.http.controller.action.maestro;

import java.util.Calendar;

import xeredi.argo.http.controller.action.item.ItemSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.maestro.bo.SubparametroBO;
import xeredi.argo.model.maestro.bo.SubparametroBOFactory;
import xeredi.argo.model.maestro.vo.SubparametroVO;
import xeredi.argo.model.metamodelo.proxy.TipoSubparametroProxy;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroDetailVO;
import xeredi.argo.model.util.DateUtil;

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

        if (accion != AccionCodigo.edit) {
            FieldValidator.validateRequired(this, getText("enti_" + enti.getEnti().getTpprAsociado().getId()),
                    model.getPrmtAsociado());
        }

        if (accion != AccionCodigo.create) {
            Preconditions.checkNotNull(model.getId());
            Preconditions.checkNotNull(model.getVersion());
            Preconditions.checkNotNull(model.getVersion().getId());
        }

        DateUtil.truncTime(model.getVersion().getFini(), Calendar.HOUR_OF_DAY);
        DateUtil.truncTime(model.getVersion().getFfin(), Calendar.HOUR_OF_DAY);

        FieldValidator.validateVersion(this, accion, model);

        FieldValidator.validateItem(this, enti, model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final SubparametroBO itemBO = SubparametroBOFactory.newInstance(model.getEntiId());
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
