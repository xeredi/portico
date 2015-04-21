package xeredi.integra.http.controller.action.metamodelo;

import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.bo.TipoParametroBO;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroSaveAction.
 */
public final class TipoParametroSaveAction extends EntidadSaveAction<TipoParametroVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5259207976545583053L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificValidate() throws ApplicationException {
        FieldValidator.validateRequired(this, MessageI18nKey.enti_i18n, model.isI18n());
        FieldValidator.validateRequired(this, MessageI18nKey.enti_tempExp, model.isTempExp());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final TipoParametroBO tpprBO = new TipoParametroBO();

        switch (accion) {
        case create:
            tpprBO.insert(model, i18nMap);

            break;
        case edit:
            tpprBO.update(model, i18nMap);

            break;
        default:
            throw new Error("Accion no soportada: " + accion);
        }
    }
}
