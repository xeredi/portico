package xeredi.integra.http.controller.action.metamodelo;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.metamodelo.proxy.TipoParametroProxy;
import xeredi.integra.model.metamodelo.proxy.TipoSubparametroProxy;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroVO;
import xeredi.util.exception.InstanceNotFoundException;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroProxyAction.
 */
public final class TipoParametroProxyAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -756347154813875782L;

    /** The tppr. */
    private TipoParametroVO tppr;

    /** The tpsp list. */
    private List<TipoSubparametroVO> tpspList;

    /**
     * Detalle.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("tppr-proxy-detalle")
    public String detalle() throws InstanceNotFoundException {
        tppr = TipoParametroProxy.select(tppr.getId());
        tpspList = new ArrayList<>();

        if (tppr.getEntiHijasList() != null) {
            for (final Long tpspId : tppr.getEntiHijasList()) {
                tpspList.add(TipoSubparametroProxy.select(tpspId));
            }
        }

        return SUCCESS;
    }

    /**
     * Gets the tppr.
     *
     * @return the tppr
     */
    public TipoParametroVO getTppr() {
        return tppr;
    }

    /**
     * Sets the tppr.
     *
     * @param value
     *            the new tppr
     */
    public void setTppr(final TipoParametroVO value) {
        tppr = value;
    }

    /**
     * Gets the tpsp list.
     *
     * @return the tpsp list
     */
    public List<TipoSubparametroVO> getTpspList() {
        return tpspList;
    }

}
