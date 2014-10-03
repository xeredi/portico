package xeredi.integra.http.controller.action.metamodelo;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubservicioProxyAction.
 */
public final class TipoSubservicioProxyAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7408964177012160343L;

    /** The tppr. */
    private TipoSubservicioVO enti;

    /** The include dependencies. */
    private boolean includeDependencies;

    /** The tpsp list. */
    private final List<TipoSubservicioVO> subentiList = new ArrayList<>();

    /** The superenti map. */
    private final List<TipoSubservicioVO> superentiList = new ArrayList<>();

    /**
     * Detalle.
     *
     * @return the string
     */
    @Action("tpss-proxy-detail")
    public String detalle() {
        Preconditions.checkNotNull(enti);
        Preconditions.checkNotNull(enti.getId());

        enti = TipoSubservicioProxy.select(enti.getId());

        if (includeDependencies && enti.getEntiHijasList() != null) {
            for (final Long tpspId : enti.getEntiHijasList()) {
                subentiList.add(TipoSubservicioProxy.select(tpspId));
            }
        }

        if (includeDependencies && enti.getEntiPadresList() != null) {
            for (final Long entiId : enti.getEntiPadresList()) {
                if (!entiId.equals(enti.getTpsrId())) {
                    superentiList.add(TipoSubservicioProxy.select(entiId));
                }
            }
        }

        return SUCCESS;
    }

    /**
     * Gets the enti.
     *
     * @return the enti
     */
    public TipoSubservicioVO getEnti() {
        return enti;
    }

    /**
     * Sets the enti.
     *
     * @param value
     *            the new enti
     */
    public void setEnti(final TipoSubservicioVO value) {
        enti = value;
    }

    /**
     * Checks if is include dependencies.
     *
     * @return true, if is include dependencies
     */
    public boolean isIncludeDependencies() {
        return includeDependencies;
    }

    /**
     * Sets the include dependencies.
     *
     * @param value
     *            the new include dependencies
     */
    public void setIncludeDependencies(final boolean value) {
        includeDependencies = value;
    }

    /**
     * Gets the subenti list.
     *
     * @return the subenti list
     */
    public List<TipoSubservicioVO> getSubentiList() {
        return subentiList;
    }

    /**
     * Gets the superenti list.
     *
     * @return the superenti list
     */
    public List<TipoSubservicioVO> getSuperentiList() {
        return superentiList;
    }

}
