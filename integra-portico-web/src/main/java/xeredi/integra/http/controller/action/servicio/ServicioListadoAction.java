package xeredi.integra.http.controller.action.servicio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.comun.ItemListadoAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.maestro.bo.Parametro;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.integra.model.metamodelo.vo.TipoServicioVO;
import xeredi.integra.model.servicio.bo.Servicio;
import xeredi.integra.model.servicio.vo.ServicioCriterioVO;
import xeredi.integra.model.servicio.vo.ServicioVO;
import xeredi.integra.model.util.Entidad;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioListadoAction.
 */
public final class ServicioListadoAction extends ItemListadoAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6459367626812047036L;

    /** The srvcs. */
    private PaginatedList<ServicioVO> itemList;

    /** The tpsr. */
    private TipoServicioVO enti;

    /** The srvc criterio form. */
    private ServicioCriterioVO itemCriterio;

    /** The subps. */
    private List<LabelValueVO> subpList;

    /**
     * Instantiates a new servicio listado action.
     */
    public ServicioListadoAction() {
        super();

        itemCriterio = new ServicioCriterioVO();

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
    @Actions({
            @Action(value = "srvc-filtro"),
            @Action(value = "srvc-filtro-popup", results = { @Result(name = "success", location = "srvc-filtro.jsp") }),
            @Action(value = "srvc-filtro-ftl-popup", results = { @Result(name = "success", type = "freemarker", location = "srvc-filtro.ftl") }) })
    public String filtro() {
        Preconditions.checkNotNull(itemCriterio);
        Preconditions.checkNotNull(itemCriterio.getEntiId());

        enti = TipoServicioProxy.select(itemCriterio.getEntiId());

        loadLabelValuesMap();

        return SUCCESS;
    }

    /**
     * Editar lupa.
     *
     * @return the string
     */
    @Action(value = "srvc-editar-lupa")
    public String editarLupa() {
        Preconditions.checkNotNull(itemCriterio);
        Preconditions.checkNotNull(itemCriterio.getEntiId());

        enti = TipoServicioProxy.select(itemCriterio.getEntiId());

        return SUCCESS;
    }

    /**
     * Listado.
     *
     * @return the string
     */
    @Actions({
            @Action(value = "srvc-listado"),
            @Action(value = "srvc-listado-json", results = { @Result(name = "success", type = "json", params = {
                    "excludeNullProperties", "true" }) }) })
    public String listado() {
        Preconditions.checkNotNull(itemCriterio);
        Preconditions.checkNotNull(itemCriterio.getEntiId());

        final Servicio srvcBO = BOFactory.getInjector().getInstance(Servicio.class);

        enti = TipoServicioProxy.select(itemCriterio.getEntiId());

        // Traemos solo los datos 'gridables' de los parametros (Minimiza el
        // trafico con la BD)
        itemCriterio.setSoloDatosGrid(true);

        itemList = srvcBO.selectList(itemCriterio, PaginatedList.getOffset(getPage(), getLimit()), getLimit());

        return SUCCESS;
    }

    // get /set

    /**
     * Gets the subps.
     *
     * @return the subps
     */
    public List<LabelValueVO> getSubpList() {
        if (subpList == null) {
            subpList = new ArrayList<>();

            final Parametro prmtBO = BOFactory.getInjector().getInstance(Parametro.class);
            final Set<Long> tpprIds = new HashSet<>();

            tpprIds.add(Entidad.SUBPUERTO.getId());

            subpList.addAll(prmtBO.selectLabelValues(tpprIds, itemCriterio.getFechaVigencia(), getIdioma()).get(
                    Entidad.SUBPUERTO.getId()));
        }

        return subpList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ServicioCriterioVO getItemCriterio() {
        return itemCriterio;
    }

    /**
     * Sets the item criterio.
     *
     * @param value
     *            the new item criterio
     */
    public void setItemCriterio(final ServicioCriterioVO value) {
        itemCriterio = value;
    }

    /**
     * Gets the item list.
     *
     * @return the item list
     */
    public PaginatedList<ServicioVO> getItemList() {
        return itemList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TipoServicioVO getEnti() {
        return enti;
    }

}
