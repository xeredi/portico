package xeredi.argo.http.controller.action.metamodelo;

import com.google.inject.Inject;

import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.service.TipoServicioService;
import xeredi.argo.model.metamodelo.vo.TipoServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoServicioSaveAction.
 */
public final class TipoServicioSaveAction extends EntidadSaveAction<TipoServicioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6958390432394107987L;

	@Inject
	private TipoServicioService tpsrService;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificValidate() throws ApplicationException {
        FieldValidator.validateRequired(this, MessageI18nKey.enti_temporal, model.isTemporal());
        FieldValidator.validateRequired(this, MessageI18nKey.enti_exencionable, model.isExencionable());
        FieldValidator.validateRequired(this, MessageI18nKey.enti_facturable, model.isFacturable());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        switch (accion) {
        case create:
            tpsrService.insert(model, i18nMap);

            break;
        case edit:
            tpsrService.update(model, i18nMap);

            break;
        default:
            throw new Error("Accion no soportada: " + accion);
        }
    }
}
