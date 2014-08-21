package xeredi.integra.http.controller.action.maestro;

import java.util.Calendar;
import java.util.HashMap;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.comun.ItemListadoAction;
import xeredi.integra.model.bo.maestro.Parametro;
import xeredi.integra.model.bo.util.BOFactory;
import xeredi.integra.model.comun.vo.ItemDatoCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;
import xeredi.integra.model.proxy.metamodelo.TipoParametroProxy;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroListadoAction.
 */
public final class ParametroListadoAction extends ItemListadoAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4719886690588825194L;

    /** The prmts. */
    private PaginatedList<ParametroVO> itemList;

    /** The tppr. */
    private TipoParametroVO enti;

    /** The criterio vo. */
    private ParametroCriterioVO itemCriterio;

    /**
     * Instantiates a new parametro listado action.
     */
    public ParametroListadoAction() {
        super();

        itemCriterio = new ParametroCriterioVO();

        final Calendar calendar = Calendar.getInstance();

        // FIXME Superñapa debido a que los borrados son demasiado rapidos
        calendar.add(Calendar.SECOND, 1);

        itemCriterio.setFechaVigencia(calendar.getTime());
        itemCriterio.setIdioma(getIdioma());
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
            @Action(value = "prmt-filtro"),
            @Action(value = "prmt-filtro-json", results = { @Result(name = "success", type = "json", params = {
                    "ignoreHierarchy", "false" }) }),
            @Action(value = "prmt-filtro-popup", results = { @Result(name = "success", location = "prmt-filtro.jsp") }) })
    public String filtro() {
        Preconditions.checkNotNull(itemCriterio);
        Preconditions.checkNotNull(itemCriterio.getEntiId());

        enti = TipoParametroProxy.select(itemCriterio.getEntiId());

        // Inicializar el filtro - Necesario para AngularJS
        if (itemCriterio.getItdtMap() == null) {
            itemCriterio.setItdtMap(new HashMap<Long, ItemDatoCriterioVO>());
        }

        for (final EntidadTipoDatoVO entdVO : enti.getEntdMap().values()) {
            if (entdVO.isFiltrable() && !itemCriterio.getItdtMap().containsKey(entdVO.getTpdt().getId())) {
                itemCriterio.getItdtMap().put(entdVO.getTpdt().getId(), new ItemDatoCriterioVO());
            }
        }

        loadLabelValuesMap();

        return SUCCESS;
    }

    /**
     * Listado.
     *
     * @return the string
     */
    @Actions({ @Action(value = "prmt-listado-json"), @Action(value = "prmt-listado-grid") })
    public String listado() {
        Preconditions.checkNotNull(itemCriterio);
        Preconditions.checkNotNull(itemCriterio.getEntiId());

        final Parametro prmtBO = BOFactory.getInjector().getInstance(Parametro.class);

        enti = TipoParametroProxy.select(itemCriterio.getEntiId());

        if (hasErrors()) {
            return INPUT;
        }

        // Traemos solo los datos 'gridables' de los parametros (Minimiza el
        // trafico con la BD)
        itemCriterio.setSoloDatosGrid(true);

        itemList = prmtBO.selectList(itemCriterio, PaginatedList.getOffset(getPage(), getLimit()), getLimit());

        return SUCCESS;
    }

    // get / set

    /**
     * {@inheritDoc}
     */
    @Override
    public final ParametroCriterioVO getItemCriterio() {
        return itemCriterio;
    }

    /**
     * Sets the item criterio.
     *
     * @param value
     *            the new item criterio
     */
    public final void setItemCriterio(final ParametroCriterioVO value) {
        itemCriterio = value;
    }

    /**
     * Gets the item list.
     *
     * @return the item list
     */
    public final PaginatedList<ParametroVO> getItemList() {
        return itemList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final TipoParametroVO getEnti() {
        return enti;
    }

}
