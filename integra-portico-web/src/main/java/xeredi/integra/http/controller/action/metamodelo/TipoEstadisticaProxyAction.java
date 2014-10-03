package xeredi.integra.http.controller.action.metamodelo;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.metamodelo.proxy.TipoEstadisticaProxy;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoEstadisticaProxyAction.
 */
public final class TipoEstadisticaProxyAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5072652541076622495L;

    /** The tppr. */
    private TipoEstadisticaVO enti;

    /**
     * Detalle.
     *
     * @return the string
     */
    @Action("tpes-proxy-detail")
    public String detalle() {
        Preconditions.checkNotNull(enti);
        Preconditions.checkNotNull(enti.getId());

        enti = TipoEstadisticaProxy.select(enti.getId());

        return SUCCESS;
    }

    /**
     * Gets the enti.
     *
     * @return the enti
     */
    public TipoEstadisticaVO getEnti() {
        return enti;
    }

    /**
     * Sets the enti.
     *
     * @param value
     *            the new enti
     */
    public void setEnti(final TipoEstadisticaVO value) {
        enti = value;
    }

}
