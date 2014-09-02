package xeredi.integra.http.controller.action.configuracion;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.controller.action.PaginableAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.configuracion.bo.ClaveIdioma;
import xeredi.integra.model.configuracion.bo.ClaveIdiomaBO;
import xeredi.integra.model.configuracion.bo.Idioma;
import xeredi.integra.model.configuracion.bo.IdiomaBO;
import xeredi.integra.model.configuracion.vo.ClaveIdiomaCriterioVO;
import xeredi.integra.model.configuracion.vo.ClaveIdiomaVO;
import xeredi.integra.model.configuracion.vo.IdiomaVO;
import xeredi.integra.model.util.GlobalNames;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class ClaveIdiomaListadoAction.
 */
public final class ClaveIdiomaListadoAction extends BaseAction implements PaginableAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6821265040249929101L;

    /** The Constant ROWS. */
    private static final int ROWS = GlobalNames.ROWS_PER_PAGE_DEFAULT;

    /** The cncis. */
    private PaginatedList<ClaveIdiomaVO> cncis;

    /** The cnid codigos. */
    private List<IdiomaVO> cnids;

    /** The page. */
    private int page;

    /** The cnci criterio. */
    private ClaveIdiomaCriterioVO cnciCriterio;

    /**
     * Instantiates a new clave idioma listado action.
     */
    public ClaveIdiomaListadoAction() {
        super();

        page = PaginatedList.FIRST_PAGE;
        cnciCriterio = new ClaveIdiomaCriterioVO();
    }

    // Acciones web
    /**
     * Filtro.
     *
     * @return the string
     */
    @Actions({ @Action(value = "cnci-filtro"),
        @Action(value = "cnci-filtro-popup", results = { @Result(name = "success", location = "cnci-filtro.jsp") }) })
    public String filtro() {
        return SUCCESS;
    }

    /**
     * Listado.
     *
     * @return the string
     */
    @Action(value = "cnci-listado")
    public String listado() {
        final ClaveIdioma cnciBO = BOFactory.getInjector().getInstance(ClaveIdiomaBO.class);
        final Idioma cnidBO = BOFactory.getInjector().getInstance(IdiomaBO.class);

        cnids = cnidBO.selectAll();
        cncis = cnciBO.selectList(cnciCriterio, PaginatedList.getOffset(page, ROWS), ROWS);

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
     * Gets the cnci criterio.
     *
     * @return the cnci criterio
     */
    public ClaveIdiomaCriterioVO getCnciCriterio() {
        return cnciCriterio;
    }

    /**
     * Sets the cnci criterio.
     *
     * @param value
     *            the new cnci criterio
     */
    public void setCnciCriterio(final ClaveIdiomaCriterioVO value) {
        cnciCriterio = value;
    }

    /**
     * Gets the cncis.
     *
     * @return the cncis
     */
    public PaginatedList<ClaveIdiomaVO> getCncis() {
        return cncis;
    }

    /**
     * Gets the cnids.
     *
     * @return the cnids
     */
    public List<IdiomaVO> getCnids() {
        return cnids;
    }


}
