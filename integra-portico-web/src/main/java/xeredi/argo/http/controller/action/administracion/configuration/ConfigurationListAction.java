package xeredi.argo.http.controller.action.administracion.configuration;

import xeredi.argo.http.controller.action.comun.ListAction;
import xeredi.argo.model.comun.bo.ConfigurationBO;
import xeredi.argo.model.comun.vo.ConfigurationVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfigurationListAction.
 */
public final class ConfigurationListAction extends ListAction<ConfigurationVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4157882341228986446L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() {
        final ConfigurationBO confBO = new ConfigurationBO();

        resultList = confBO.selectList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.conf;
    }
}
