package xeredi.argo.http.controller.action.administracion.configuration;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.ListAction;
import xeredi.argo.model.comun.bo.ConfigurationBO;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.ConfigurationVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfigurationListAction.
 */
@Data
public final class ConfigurationListAction extends ListAction<ConfigurationVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4157882341228986446L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.conf;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() {
        final ConfigurationBO confBO = new ConfigurationBO();

        resultList = confBO.selectList();
    }
}
