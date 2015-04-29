package xeredi.integra.http.controller.action.administracion.configuracion;

import xeredi.integra.http.controller.action.CrudEditAction;
import xeredi.integra.model.comun.bo.ConfigurationBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.ConfigurationVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfigurationEditAction.
 */
public final class ConfigurationEditAction extends CrudEditAction<ConfigurationVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7232090855025643651L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        Preconditions.checkNotNull(model.getKey());

        switch (accion) {
        case edit:
            final ConfigurationBO confBO = new ConfigurationBO();

            model = confBO.select(model.getKey());

            break;
        default:
            throw new Error("Accion no valida: " + accion);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        // noop
    }
}
