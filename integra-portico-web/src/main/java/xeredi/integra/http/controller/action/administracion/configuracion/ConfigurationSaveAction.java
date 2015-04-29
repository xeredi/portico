package xeredi.integra.http.controller.action.administracion.configuracion;

import xeredi.integra.http.controller.action.CrudSaveAction;
import xeredi.integra.model.comun.bo.ConfigurationBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.ConfigurationVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfigurationSaveAction.
 */
public final class ConfigurationSaveAction extends CrudSaveAction<ConfigurationVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6903870337366067759L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        switch (accion) {
        case edit:
            final ConfigurationBO confBO = new ConfigurationBO();

            confBO.update(model);

            break;
        default:
            throw new Error("Accion no valida: " + accion);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doValidate() throws ApplicationException {
        Preconditions.checkNotNull(model.getKey());
    }
}
