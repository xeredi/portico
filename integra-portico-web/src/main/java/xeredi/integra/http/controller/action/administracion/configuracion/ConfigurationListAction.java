package xeredi.integra.http.controller.action.administracion.configuracion;

import xeredi.integra.http.controller.action.ListAction;
import xeredi.integra.model.comun.bo.ConfigurationBO;
import xeredi.integra.model.comun.vo.ConfigurationVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfigurationListAction.
 */
public final class ConfigurationListAction extends ListAction<ConfigurationVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4157882341228986446L;

    @Override
    public void doList() {
        final ConfigurationBO confBO = new ConfigurationBO();

        resultList = confBO.selectList();
    }

    // @Action("conf-reload")
    // public String reload() {
    // ConfigurationProxy.reload();
    //
    // return SUCCESS;
    // }
}
