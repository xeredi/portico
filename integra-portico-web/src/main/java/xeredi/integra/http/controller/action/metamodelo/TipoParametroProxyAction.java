package xeredi.integra.http.controller.action.metamodelo;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.metamodelo.proxy.TipoParametroProxy;
import xeredi.integra.model.metamodelo.proxy.TipoSubparametroProxy;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroProxyAction.
 */
public final class TipoParametroProxyAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -756347154813875782L;

    /** The tppr. */
    private TipoParametroVO enti;

    /** The tpsp list. */
    private final List<TipoSubparametroVO> subentiList = new ArrayList<>();

    /**
     * Detalle.
     *
     * @return the string
     */
    @Action("tppr-proxy-detail")
    public String detalle() {
        enti = TipoParametroProxy.select(enti.getId());

        if (enti.getEntiHijasList() != null) {
            for (final Long tpspId : enti.getEntiHijasList()) {
                subentiList.add(TipoSubparametroProxy.select(tpspId));
            }
        }

        return SUCCESS;
    }

    // get / set
    /**
     * Gets the enti.
     *
     * @return the enti
     */
    public TipoParametroVO getEnti() {
        return enti;
    }

    /**
     * Sets the enti.
     *
     * @param value
     *            the enti
     */
    public void setEnti(final TipoParametroVO value) {
        enti = value;
    }

    /**
     * Gets the subenti list.
     *
     * @return the subenti list
     */
    public List<TipoSubparametroVO> getSubentiList() {
        return subentiList;
    }

}
