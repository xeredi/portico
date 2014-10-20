package xeredi.integra.http.controller.action.administracion.configuracion;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.ConfigurationBO;
import xeredi.integra.model.comun.vo.ConfigurationVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfigurationListAction.
 */
public final class ConfigurationListAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4157882341228986446L;

    /** The conf list. */
    private List<ConfigurationVO> confList;

    /**
     * List.
     *
     * @return the string
     */
    @Action("conf-grid")
    public String list() {
        final ConfigurationBO confBO = new ConfigurationBO();

        confList = confBO.selectList();

        return SUCCESS;
    }

    /**
     * Gets the conf list.
     *
     * @return the conf list
     */
    public List<ConfigurationVO> getConfList() {
        return confList;
    }
}
