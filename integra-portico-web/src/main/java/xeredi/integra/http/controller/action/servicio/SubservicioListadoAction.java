package xeredi.integra.http.controller.action.servicio;

import java.util.Calendar;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.comun.ItemListadoAction;
import xeredi.integra.model.bo.servicio.Subservicio;
import xeredi.integra.model.bo.util.BOFactory;
import xeredi.integra.model.proxy.metamodelo.TipoSubservicioProxy;
import xeredi.integra.model.vo.metamodelo.TipoSubservicioVO;
import xeredi.integra.model.vo.servicio.SubservicioCriterioVO;
import xeredi.integra.model.vo.servicio.SubservicioVO;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioListadoAction.
 */
public final class SubservicioListadoAction extends ItemListadoAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -325205517324020646L;

    /** The srvcs. */
    private PaginatedList<SubservicioVO> itemList;

    /** The srvc criterio form. */
    private SubservicioCriterioVO itemCriterio;

    /** The tpss. */
    private TipoSubservicioVO enti;

    /**
     * Instantiates a new subservicio listado action.
     */
    public SubservicioListadoAction() {
        super();

        itemCriterio = new SubservicioCriterioVO();

        itemCriterio.setIdioma(getIdioma());
        itemCriterio.setFechaVigencia(Calendar.getInstance().getTime());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    // Acciones web
    /**
     * Editar filtro.
     *
     * @return the string
     */
    @Actions({ @Action(value = "ssrv-filtro"),
            @Action(value = "ssrv-filtro-popup", results = { @Result(name = "success", location = "ssrv-filtro.jsp") }) })
    public String editarFiltro() {
        Preconditions.checkNotNull(itemCriterio);
        Preconditions.checkNotNull(itemCriterio.getEntiId());

        enti = TipoSubservicioProxy.select(itemCriterio.getEntiId());

        return SUCCESS;
    }

    /**
     * Listado.
     *
     * @return the string
     */
    @Actions({
            @Action(value = "ssrv-listado"),
            @Action(value = "ssrv-listado-grid", results = { @Result(name = "success", location = "ssrv-listado.jsp") }),
            @Action(value = "ssrv-listado-json", results = { @Result(name = "success", type = "json", params = {
                    "excludeNullProperties", "true" }) }) })
    public String listado() {
        Preconditions.checkNotNull(itemCriterio);
        Preconditions.checkNotNull(itemCriterio.getEntiId());

        final Subservicio ssrvBO = BOFactory.getInjector().getInstance(Subservicio.class);

        enti = TipoSubservicioProxy.select(itemCriterio.getEntiId());

        // Traemos solo los datos 'gridables' de los parametros (Minimiza el
        // trafico con la BD)
        itemCriterio.setSoloDatosGrid(true);

        itemList = ssrvBO.selectList(itemCriterio, PaginatedList.getOffset(getPage(), getLimit()), getLimit());

        return SUCCESS;
    }

    // get /set

    /**
     * {@inheritDoc}
     */
    @Override
    public final SubservicioCriterioVO getItemCriterio() {
        return itemCriterio;
    }

    /**
     * Sets the item criterio.
     *
     * @param value
     *            the new item criterio
     */
    public final void setItemCriterio(final SubservicioCriterioVO value) {
        itemCriterio = value;
    }

    /**
     * Gets the item list.
     *
     * @return the item list
     */
    public final PaginatedList<SubservicioVO> getItemList() {
        return itemList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final TipoSubservicioVO getEnti() {
        return enti;
    }

}
