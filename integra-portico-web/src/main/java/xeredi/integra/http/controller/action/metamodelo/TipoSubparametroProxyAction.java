package xeredi.integra.http.controller.action.metamodelo;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.metamodelo.proxy.TipoSubparametroProxy;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubparametroProxyAction.
 */
public final class TipoSubparametroProxyAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5954065110559183731L;

    /** The enti. */
    private TipoSubparametroVO enti;

    /**
     * Detalle.
     *
     * @return the string
     */
    @Action("tpsp-proxy-detail")
    public String detalle() {
        Preconditions.checkNotNull(enti);
        Preconditions.checkNotNull(enti.getId());

        enti = TipoSubparametroProxy.select(enti.getId());

        return SUCCESS;
    }

    /**
     * Gets the enti.
     *
     * @return the enti
     */
    public TipoSubparametroVO getEnti() {
        return enti;
    }

    /**
     * Sets the enti.
     *
     * @param value
     *            the new enti
     */
    public void setEnti(final TipoSubparametroVO value) {
        enti = value;
    }

}
