package xeredi.integra.http.controller.action.administracion.configuracion;

import xeredi.integra.http.controller.action.comun.CrudDetailAction;
import xeredi.integra.model.comun.bo.ConfigurationBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.ConfigurationVO;

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
}
