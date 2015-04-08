package xeredi.integra.http.controller.action.facturacion;

import java.util.Calendar;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.PaginableAction;
import xeredi.integra.model.facturacion.bo.AspectoBO;
import xeredi.integra.model.facturacion.vo.AspectoCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoVO;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.pagination.PaginatedList;

import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoListadoAction.
 */
public final class AspectoListadoAction extends PaginableAction implements ModelDriven<AspectoCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7615445979289765235L;

    /** The aspc list. */
    private PaginatedList<AspectoVO> aspcList;

    /** The aspc criterio. */
    private AspectoCriterioVO model;

    /** The tpsr list. */
    private List<LabelValueVO> tpsrList;

    // acciones web
    /**
     * Filter.
     *
     * @return the string
     */
    @Action("aspc-filter")
    public String filter() {
        tpsrList = TipoServicioProxy.selectLabelValues();

        return SUCCESS;
    }

    /**
     * Listado.
     *
     * @return the string
     */
    @Action("aspc-list")
    public String list() {
        if (model == null) {
            model = new AspectoCriterioVO();
        }

        if (model.getFechaVigencia() == null) {
            model.setFechaVigencia(Calendar.getInstance().getTime());
        }

        model.setIdioma(getIdioma());

        final AspectoBO aspcBO = new AspectoBO();

        aspcList = aspcBO.selectList(model, getOffset(), getLimit());

        return SUCCESS;
    }

    // get / set

    /**
     * {@inheritDoc}
     */
    @Override
    public AspectoCriterioVO getModel() {
        return model;
    }

    /**
     * Sets the aspc criterio.
     *
     * @param value
     *            the aspc criterio
     */
    public void setModel(final AspectoCriterioVO value) {
        model = value;
    }

    /**
     * Gets the aspc list.
     *
     * @return the aspc list
     */
    public PaginatedList<AspectoVO> getAspcList() {
        return aspcList;
    }

    /**
     * Gets the tpsr list.
     *
     * @return the tpsr list
     */
    public List<LabelValueVO> getTpsrList() {
        return tpsrList;
    }

}
