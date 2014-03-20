package xeredi.integra.http.controller.action.configuracion;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.controller.action.PaginableAction;
import xeredi.integra.model.bo.configuracion.Clave;
import xeredi.integra.model.bo.configuracion.Entorno;
import xeredi.integra.model.bo.util.BOFactory;
import xeredi.integra.model.util.GlobalNames;
import xeredi.integra.model.vo.configuracion.ClaveCriterioVO;
import xeredi.integra.model.vo.configuracion.ClaveVO;
import xeredi.integra.model.vo.configuracion.EntornoVO;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class ClaveListadoAction.
 */
public final class ClaveListadoAction extends BaseAction implements PaginableAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2047436698656146812L;

    /** The Constant ROWS. */
    private static final int ROWS = GlobalNames.ROWS_PER_PAGE_DEFAULT;

    /** The cncls. */
    private PaginatedList<ClaveVO> cncls;

    /** The cnen codigos. */
    private List<EntornoVO> cnens;

    /** The page. */
    private int page;

    /** The cncl criterio. */
    private ClaveCriterioVO cnclCriterio;

    /**
     * Instantiates a new clave listado action.
     */
    public ClaveListadoAction() {
        super();

        page = PaginatedList.FIRST_PAGE;
        cnclCriterio = new ClaveCriterioVO();
    }

    // Acciones web
    /**
     * Filtro.
     * 
     * @return the string
     */
    @Actions({ @Action(value = "cncl-filtro"),
        @Action(value = "cncl-filtro-popup", results = { @Result(name = "success", location = "cncl-filtro.jsp") }) })
    public String filtro() {
        return SUCCESS;
    }

    /**
     * Listado.
     * 
     * @return the string
     */
    @Action(value = "cncl-listado")
    public String listado() {
        final Clave cnclBO = BOFactory.getInjector().getInstance(Clave.class);
        final Entorno cnenBO = BOFactory.getInjector().getInstance(Entorno.class);

        cnens = cnenBO.selectAll();
        cncls = cnclBO.selectList(cnclCriterio, PaginatedList.getOffset(page, ROWS), ROWS);

        return SUCCESS;
    }

    // get / set

    /**
     * Gets the page.
     * 
     * @return the page
     */
    @Override
    public int getPage() {
        return page;
    }

    /**
     * Sets the page.
     * 
     * @param value
     *            the new page
     */
    @Override
    public void setPage(final int value) {
        page = value;
    }

    /**
     * Gets the cncl criterio.
     * 
     * @return the cncl criterio
     */
    public ClaveCriterioVO getCnclCriterio() {
        return cnclCriterio;
    }

    /**
     * Sets the cncl criterio.
     * 
     * @param value
     *            the new cncl criterio
     */
    public void setCnclCriterio(final ClaveCriterioVO value) {
        cnclCriterio = value;
    }

    /**
     * Gets the cncls.
     * 
     * @return the cncls
     */
    public PaginatedList<ClaveVO> getCncls() {
        return cncls;
    }

    /**
     * Gets the cnens.
     * 
     * @return the cnens
     */
    public List<EntornoVO> getCnens() {
        return cnens;
    }

}
