package xeredi.argo.http.controller.action.maestro;

import java.util.Map;

import xeredi.argo.http.controller.action.item.ItemSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.maestro.bo.ParametroBO;
import xeredi.argo.model.maestro.bo.ParametroBOFactory;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.metamodelo.proxy.TipoParametroProxy;
import xeredi.argo.model.metamodelo.vo.TipoParametroDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroSaveAction.
 */
public final class ParametroSaveAction extends ItemSaveAction<ParametroVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8612808873765455744L;

    /** The p18n map. */
    private Map<String, I18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificValidate() throws ApplicationException {
        final TipoParametroDetailVO enti = TipoParametroProxy.select(model.getEntiId());

        if (enti.getEnti().isPuerto()) {
            FieldValidator.validateRequired(this, MessageI18nKey.prto, model.getPrto());

            if (!hasErrors()) {
                FieldValidator.validateRequired(this, MessageI18nKey.prto, model.getPrto().getId());
            }
        }

        FieldValidator.validateRequired(this, MessageI18nKey.prmt_parametro, model.getParametro());
        FieldValidator.validateRequired(this, MessageI18nKey.fini, model.getVersion());

        if (!hasErrors()) {
            FieldValidator.validateRequired(this, MessageI18nKey.fini, model.getVersion().getFini());
        }

        if (enti.getEnti().isGis()) {
            FieldValidator.validateRequired(this, MessageI18nKey.prmt_lat, model.getVersion().getLat());
            FieldValidator.validateRequired(this, MessageI18nKey.prmt_lon, model.getVersion().getLon());
        }

        if (enti.getEnti().isI18n()) {
            FieldValidator.validateI18n(this, i18nMap);
        }

        FieldValidator.validateItem(this, enti, model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final ParametroBO itemBO = ParametroBOFactory.newInstance(model.getEntiId());
        final TipoParametroDetailVO enti = TipoParametroProxy.select(model.getEntiId());

        switch (accion) {
        case create:
            itemBO.insert(model, enti, i18nMap);

            break;
        case edit:
            itemBO.update(model, enti, i18nMap);

            break;
        case duplicate:
            itemBO.duplicate(model, enti, i18nMap);

            break;
        case duplicate_version:
            itemBO.duplicateVersion(model, enti, i18nMap);

            break;
        default:
            throw new Error("Accion no valida: " + accion);
        }
    }

    /**
     * Sets the i18n map.
     *
     * @param value
     *            the value
     */
    public void setI18nMap(final Map<String, I18nVO> value) {
        i18nMap = value;
    }
}
