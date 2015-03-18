package xeredi.integra.http.controller.action.facturacion;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.controller.action.PaginatedGrid;
import xeredi.integra.model.facturacion.bo.ValoracionBO;
import xeredi.integra.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionVO;
import xeredi.integra.model.metamodelo.proxy.TipoDatoProxy;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.integra.model.metamodelo.vo.TipoDato;
import xeredi.integra.model.metamodelo.vo.TipoDatoVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionListadoAction.
 */
public final class ValoracionListadoAction extends BaseAction implements PaginatedGrid {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8684408096397399011L;

    /** The vlrc list. */
    private PaginatedList<ValoracionVO> vlrcList;

    /** The vlrc criterio. */
    private ValoracionCriterioVO vlrcCriterio;

    /** The page. */
    private int page = 1;

    /** The fecha vigencia. */
    private final Date fechaVigencia = Calendar.getInstance().getTime();

    /** The limit. */
    private int limit = ROWS_PER_PAGE_DEFAULT;

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
        if (vlrcCriterio == null) {
            vlrcCriterio = new ValoracionCriterioVO();
        }

        vlrcCriterio.setIdioma(getIdioma());

        final ValoracionBO vlrcBO = new ValoracionBO();

        vlrcList = vlrcBO.selectList(vlrcCriterio, PaginatedList.getOffset(getPage(), getLimit()), getLimit());
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
     * Gets the vlrc criterio.
     *
     * @return the vlrc criterio
     */
    public ValoracionCriterioVO getVlrcCriterio() {
        return vlrcCriterio;
    }

    /**
     * Sets the vlrc criterio.
     *
     * @param value
     *            the vlrc criterio
     */
    public void setVlrcCriterio(final ValoracionCriterioVO value) {
        vlrcCriterio = value;
    }

    /**
     * Gets the page.
     *
     * @return the page
     */
    public int getPage() {
        return page;
    }

    /**
     * Sets the page.
     *
     * @param value
     *            the page
     */
    public void setPage(final int value) {
        page = value;
    }

    /**
     * Gets the limit.
     *
     * @return the limit
     */
    public int getLimit() {
        return limit;
    }

    /**
     * Sets the limit.
     *
     * @param value
     *            the limit
     */
    public void setLimit(final int value) {
        limit = value;
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
