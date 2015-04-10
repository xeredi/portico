package xeredi.integra.http.controller.action.facturacion;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.PaginableAction;
import xeredi.integra.model.facturacion.bo.ValoracionBO;
import xeredi.integra.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionVO;
import xeredi.integra.model.metamodelo.proxy.TipoDatoProxy;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.integra.model.metamodelo.vo.TipoDato;
import xeredi.integra.model.metamodelo.vo.TipoDatoVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.pagination.PaginatedList;

import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionListadoAction.
 */
public final class ValoracionListadoAction extends PaginableAction implements ModelDriven<ValoracionCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8684408096397399011L;

    /** The vlrc criterio. */
    private ValoracionCriterioVO model;

    /** The vlrc list. */
    private PaginatedList<ValoracionVO> vlrcList;

    /** The tpdt cod exencion. */
    private TipoDatoVO tpdtCodExencion;

    /** The tpsr list. */
    private List<LabelValueVO> tpsrList;

    // acciones web

    /**
     * Listado.
     *
     * @return the string
     */
    @Action("vlrc-list")
    public String listado() {
        if (model == null) {
            model = new ValoracionCriterioVO();
        }

        model.setIdioma(getIdioma());

        final ValoracionBO vlrcBO = new ValoracionBO();

        vlrcList = vlrcBO.selectList(model, getOffset(), getLimit());
        tpdtCodExencion = TipoDatoProxy.select(TipoDato.COD_EXEN.getId());

        return SUCCESS;
    }

    /**
     * Editar filtro.
     *
     * @return the string
     */
    @Action("vlrc-filter")
    public String editarFiltro() {
        tpsrList = TipoServicioProxy.selectLabelValues();
        tpdtCodExencion = TipoDatoProxy.select(TipoDato.COD_EXEN.getId());

        return SUCCESS;
    }

    // get / set

    /**
     * {@inheritDoc}
     */
    @Override
    public ValoracionCriterioVO getModel() {
        return model;
    }

    /**
     * Sets the vlrc criterio.
     *
     * @param value
     *            the vlrc criterio
     */
    public void setModel(final ValoracionCriterioVO value) {
        model = value;
    }

    /**
     * Gets the vlrc list.
     *
     * @return the vlrc list
     */
    public PaginatedList<ValoracionVO> getVlrcList() {
        return vlrcList;
    }

    /**
     * Gets the tpsr list.
     *
     * @return the tpsr list
     */
    public List<LabelValueVO> getTpsrList() {
        return tpsrList;
    }

    /**
     * Gets the tpdt cod exencion.
     *
     * @return the tpdt cod exencion
     */
    public TipoDatoVO getTpdtCodExencion() {
        return tpdtCodExencion;
    }
}
