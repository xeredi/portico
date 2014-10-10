package xeredi.integra.http.controller.action.facturacion;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.facturacion.bo.AspectoBO;
import xeredi.integra.model.facturacion.vo.AspectoLupaCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoVO;
import xeredi.integra.model.util.GlobalNames;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoLupaAction.
 */
public final class AspectoLupaAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -764613729784237979L;

    /** The aspc criterio vo. */
    private AspectoLupaCriterioVO aspcCriterio;

    /** The aspc list. */
    private List<AspectoVO> aspcList;

    /**
     * List.
     *
     * @return the string
     */
    @Action("aspc-lupa")
    public String list() {
        Preconditions.checkNotNull(aspcCriterio);

        if (aspcCriterio.getTextoBusqueda() != null) {
            aspcCriterio.setTextoBusqueda(aspcCriterio.getTextoBusqueda().toUpperCase() + "%");
        }

        final AspectoBO aspcBO = new AspectoBO();

        aspcList = aspcBO.selectLupaList(aspcCriterio, GlobalNames.LUPA_LIMIT_DEFAULT);

        return SUCCESS;
    }

    /**
     * Gets the aspc criterio vo.
     *
     * @return the aspc criterio vo
     */
    public AspectoLupaCriterioVO getAspcCriterio() {
        return aspcCriterio;
    }

    /**
     * Sets the aspc criterio vo.
     *
     * @param value
     *            the new aspc criterio vo
     */
    public void setAspcCriterio(final AspectoLupaCriterioVO value) {
        aspcCriterio = value;
    }

    /**
     * Gets the aspc list.
     *
     * @return the aspc list
     */
    public List<AspectoVO> getAspcList() {
        return aspcList;
    }
}
