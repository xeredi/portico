package xeredi.integra.http.controller.action.test;

import java.util.Calendar;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.maestro.bo.Parametro;
import xeredi.integra.model.maestro.vo.ParametroCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoParametroProxy;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;
import xeredi.integra.model.util.GlobalNames;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class AngularAction.
 */
public final class AngularAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4845981059245486852L;

    /** The Constant ROWS. */
    private static final int ROWS = GlobalNames.ROWS_PER_PAGE_DEFAULT;

    /** The prmts. */
    private PaginatedList<ParametroVO> prmts;

    /** The tppr. */
    private TipoParametroVO tppr;

    /** The page. */
    private int page;

    /** The criterio vo. */
    private ParametroCriterioVO prmtCriterio;

    /**
     * Instantiates a new angular action.
     */
    public AngularAction() {
        prmtCriterio = new ParametroCriterioVO();

        prmtCriterio.setIdioma(getIdioma());
        prmtCriterio.setFechaVigencia(Calendar.getInstance().getTime());

        page = 1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    // web actions

    @Action(value = "prmt-list", results = { @Result(name = "success", type = "json", params = {
            "excludeNullProperties", "true", "enableGZIP", "true" }) })
    public String list() {
        final Parametro prmtBO = BOFactory.getInjector().getInstance(Parametro.class);

        if (prmtCriterio.getEntiId() == null) {
            throw new Error("Especifique un tipo de parametro: " + prmtCriterio);
        }

        tppr = TipoParametroProxy.select(prmtCriterio.getEntiId());

        if (hasErrors()) {
            return INPUT;
        }

        // Traemos solo los datos 'gridables' de los parametros (Minimiza el
        // trafico con la BD)
        prmtCriterio.setSoloDatosGrid(true);

        prmts = prmtBO.selectList(prmtCriterio, PaginatedList.getOffset(page, ROWS), ROWS);

        return SUCCESS;
    }

    // get / set
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
     *            the new page
     */
    public void setPage(final int value) {
        page = value;
    }

    /**
     * Gets the prmt criterio.
     *
     * @return the prmt criterio
     */
    public ParametroCriterioVO getPrmtCriterio() {
        return prmtCriterio;
    }

    /**
     * Sets the prmt criterio.
     *
     * @param value
     *            the new prmt criterio
     */
    public void setPrmtCriterio(final ParametroCriterioVO value) {
        prmtCriterio = value;
    }

    /**
     * Gets the prmts.
     *
     * @return the prmts
     */
    public PaginatedList<ParametroVO> getPrmts() {
        return prmts;
    }

    /**
     * Gets the tppr.
     *
     * @return the tppr
     */
    public TipoParametroVO getTppr() {
        return tppr;
    }

}
