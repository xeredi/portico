package xeredi.integra.http.controller.action.metamodelo;

import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.bo.TipoSubparametroBO;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubparametroSaveAction.
 */
public final class TipoSubparametroSaveAction extends EntidadSaveAction<TipoSubparametroVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3409997803363715915L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificValidate() throws ApplicationException {
        Preconditions.checkNotNull(model.getTpprId());

        FieldValidator.validateRequired(this, MessageI18nKey.enti_i18n, model.isI18n());
        FieldValidator.validateRequired(this, MessageI18nKey.enti_tempExp, model.isTempExp());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final TipoSubparametroBO tpspBO = new TipoSubparametroBO();

        switch (accion) {
        case create:
            tpspBO.insert(model, i18nMap);

            break;
        case edit:
            tpspBO.update(model, i18nMap);

            break;
        default:
            throw new Error("Accion no soportada: " + accion);
        }
    }

}
