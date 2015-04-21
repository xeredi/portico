package xeredi.integra.http.controller.action.metamodelo;

import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.metamodelo.bo.TipoEstadisticaBO;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoEstadisticaSaveAction.
 */
public final class TipoEstadisticaSaveAction extends EntidadSaveAction<TipoEstadisticaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4043292220180385996L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificValidate() throws ApplicationException {
        // noop
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final TipoEstadisticaBO tpesBO = new TipoEstadisticaBO();

        switch (accion) {
        case create:
            tpesBO.insert(model, i18nMap);

            break;
        case edit:
            tpesBO.update(model, i18nMap);

            break;
        default:
            throw new Error("Accion no soportada: " + accion);
        }
    }
}
