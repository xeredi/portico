package xeredi.integra.http.controller.action.metamodelo;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.metamodelo.bo.Entidad;
import xeredi.integra.model.metamodelo.bo.EntidadBO;
import xeredi.integra.model.metamodelo.vo.TipoEntidad;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadAction.
 */
public final class EntidadAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5675312476405724624L;

    /** The id. */
    private Long entiId;

    /** The tipo. */
    private TipoEntidad tipo;

    // Acciones Web
    /**
     * Detalle.
     *
     * @return the string
     */
    @Action("enti-detail")
    public String detail() {
        Preconditions.checkNotNull(entiId);

        final Entidad entiBO = BOFactory.getInjector().getInstance(EntidadBO.class);

        tipo = entiBO.selectTipoEntidad(entiId);

        return SUCCESS;
    }

    // get/set
    /**
     * Gets the tipo.
     *
     * @return the tipo
     */
    public TipoEntidad getTipo() {
        return tipo;
    }

    /**
     * Gets the enti id.
     *
     * @return the enti id
     */
    public Long getEntiId() {
        return entiId;
    }

    /**
     * Sets the enti id.
     *
     * @param value
     *            the enti id
     */
    public void setEntiId(final Long value) {
        entiId = value;
    }

}
