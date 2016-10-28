package xeredi.argo.http.controller.action.administracion.configuration;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.bo.ConfigurationBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.ConfigurationVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfigurationDetailAction.
 */
@Data
public final class ConfigurationDetailAction extends CrudDetailAction<ConfigurationVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 614441828114934645L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.conf;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getKey());

        final ConfigurationBO confBO = new ConfigurationBO();

        model = confBO.select(model.getKey());
    }
}
