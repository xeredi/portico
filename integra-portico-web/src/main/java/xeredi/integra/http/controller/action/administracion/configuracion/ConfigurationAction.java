package xeredi.integra.http.controller.action.administracion.configuracion;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.ItemAction;
import xeredi.integra.model.comun.bo.ConfigurationBO;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.ConfigurationVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfigurationAction.
 */
public final class ConfigurationAction extends ItemAction implements ModelDriven<ConfigurationVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6648598250229270180L;

    /** The conf. */
    private ConfigurationVO model;

    /**
     * Detail.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("conf-detail")
    public String detail() throws InstanceNotFoundException {
        Preconditions.checkNotNull(model);

        final ConfigurationBO confBO = new ConfigurationBO();

        model = confBO.select(model.getKey());

        return SUCCESS;
    }

    /**
     * Update.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("conf-edit")
    public String edit() throws InstanceNotFoundException {
        Preconditions.checkNotNull(getAccion());

        if (getAccion() == ACCION_EDICION.edit) {
            Preconditions.checkNotNull(model);

            final ConfigurationBO confBO = new ConfigurationBO();

            model = confBO.select(model.getKey());
        }

        return SUCCESS;
    }

    /**
     * Save.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("conf-save")
    public String save() throws InstanceNotFoundException {
        Preconditions.checkNotNull(getAccion());
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getKey());

        final ConfigurationBO confBO = new ConfigurationBO();

        switch (getAccion()) {
        case edit:
            confBO.update(model);

            break;
        default:
            throw new Error("Accion " + getAccion() + " no implementada");
        }

        return SUCCESS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConfigurationVO getModel() {
        return model;
    }

    /**
     * Sets the conf.
     *
     * @param value
     *            the new conf
     */
    public void setModel(final ConfigurationVO value) {
        model = value;
    }

}
