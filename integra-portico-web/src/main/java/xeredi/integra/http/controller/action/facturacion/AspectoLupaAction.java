package xeredi.integra.http.controller.action.facturacion;

import java.util.Calendar;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.proxy.ConfigurationProxy;
import xeredi.integra.model.comun.vo.ConfigurationKey;
import xeredi.integra.model.facturacion.bo.AspectoBO;
import xeredi.integra.model.facturacion.vo.AspectoCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoLupaAction.
 */
public final class AspectoLupaAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -764613729784237979L;

    /** The Constant ROWS. */
    private static final int ROWS = ConfigurationProxy.getInt(ConfigurationKey.filter_limit);

    /** The crgo criterio. */
    private AspectoCriterioVO aspcCriterio;

    /** The crgo list. */
    private List<AspectoVO> aspcList;

    /**
     * Lupa.
     *
     * @return the string
     */
    @Action("aspc-lupa")
    public String lupa() {
        Preconditions.checkNotNull(aspcCriterio);
        Preconditions.checkNotNull(aspcCriterio.getTpsrId());
        Preconditions.checkNotNull(aspcCriterio.getTextoBusqueda());

        aspcCriterio.setIdioma(getIdioma());

        if (aspcCriterio.getFechaVigencia() == null) {
            aspcCriterio.setFechaVigencia(Calendar.getInstance().getTime());
        }

        final AspectoBO aspcBO = new AspectoBO();

        aspcList = aspcBO.selectLupaList(aspcCriterio, ROWS);

        return SUCCESS;
    }

    /**
     * Gets the aspc list.
     *
     * @return the aspc list
     */
    public List<AspectoVO> getAspcList() {
        return aspcList;
    }

    /**
     * Sets the aspc criterio.
     *
     * @param value
     *            the new aspc criterio
     */
    public void setAspcCriterio(final AspectoCriterioVO value) {
        aspcCriterio = value;
    }

}
