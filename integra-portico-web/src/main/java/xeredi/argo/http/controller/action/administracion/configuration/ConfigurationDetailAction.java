package xeredi.argo.http.controller.action.administracion.configuration;

import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.bo.ConfigurationBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ConfigurationVO;
import xeredi.argo.model.metamodelo.vo.AccionPrefix;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfigurationDetailAction.
 */
public final class ConfigurationDetailAction extends CrudDetailAction<ConfigurationVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 614441828114934645L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getKey());

        final ConfigurationBO confBO = new ConfigurationBO();

        model = confBO.select(model.getKey());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.conf;
    }
}
