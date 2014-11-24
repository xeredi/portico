package xeredi.integra.http.controller.action.metamodelo;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.integra.model.metamodelo.vo.TipoServicioVO;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoServicioProxyAction.
 */
public final class TipoServicioProxyAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8493685261172580773L;

    /** The tppr. */
    private TipoServicioVO enti;

    /** The include dependencies. */
    private boolean includeDependencies;

    /** The tpsp list. */
    private final List<TipoSubservicioVO> subentiList = new ArrayList<>();

    /**
     * Detalle.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("tpsr-proxy-detail")
    public String detalle() throws ApplicationException {
        Preconditions.checkNotNull(enti);
        Preconditions.checkNotNull(enti.getId());

        enti = TipoServicioProxy.select(enti.getId());

        if (includeDependencies && enti.getEntiHijasList() != null) {
            for (final Long tpspId : enti.getEntiHijasList()) {
                subentiList.add(TipoSubservicioProxy.select(tpspId));
            }
        }

        return SUCCESS;
    }

    /**
     * Gets the enti.
     *
     * @return the enti
     */
    public TipoServicioVO getEnti() {
        return enti;
    }

    /**
     * Sets the enti.
     *
     * @param value
     *            the new enti
     */
    public void setEnti(final TipoServicioVO value) {
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

}
