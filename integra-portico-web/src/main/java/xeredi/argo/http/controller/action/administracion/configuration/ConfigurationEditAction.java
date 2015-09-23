package xeredi.argo.http.controller.action.administracion.configuration;

import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.bo.ConfigurationBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ConfigurationVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

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

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.conf;
    }
}
