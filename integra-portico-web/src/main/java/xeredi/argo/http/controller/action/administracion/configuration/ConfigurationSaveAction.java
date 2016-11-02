package xeredi.argo.http.controller.action.administracion.configuration;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.model.comun.bo.ConfigurationBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ConfigurationVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfigurationSaveAction.
 */
@Data
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
