package xeredi.integra.http.controller.action.administracion.configuracion;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.ConfigurationBO;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.ConfigurationVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfigurationAction.
 */
public final class ConfigurationAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6648598250229270180L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The conf. */
    private ConfigurationVO conf;

    /**
     * Detail.
     *
     * @return the string
     */
    @Action("conf-detail")
    public String detail() throws InstanceNotFoundException {
        Preconditions.checkNotNull(conf);

        final ConfigurationBO confBO = new ConfigurationBO();

        conf = confBO.select(conf.getKey());

        return SUCCESS;
    }

    /**
     * Update.
     *
     * @return the string
     */
    @Action("conf-edit")
    public String edit() throws InstanceNotFoundException {
        Preconditions.checkNotNull(conf);

        accion = ACCION_EDICION.edit;

        final ConfigurationBO confBO = new ConfigurationBO();

        conf = confBO.select(conf.getKey());

        return SUCCESS;
    }

    /**
     * Save.
     *
     * @return the string
     */
    @Action("conf-save")
    public String save() throws InstanceNotFoundException {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(conf);
        Preconditions.checkNotNull(conf.getKey());

        final ConfigurationBO confBO = new ConfigurationBO();

        switch (accion) {
        case edit:
            confBO.update(conf);

            break;
        default:
            throw new Error("Accion " + accion + " no implementada");
        }

        return SUCCESS;
    }

    /**
     * Gets the conf.
     *
     * @return the conf
     */
    public ConfigurationVO getConf() {
        return conf;
    }

    /**
     * Sets the conf.
     *
     * @param value
     *            the new conf
     */
    public void setConf(final ConfigurationVO value) {
        conf = value;
    }

    /**
     * Gets the accion.
     *
     * @return the accion
     */
    public ACCION_EDICION getAccion() {
        return accion;
    }

    /**
     * Sets the accion.
     *
     * @param value
     *            the new accion
     */
    public void setAccion(final ACCION_EDICION value) {
        accion = value;
    }

}
