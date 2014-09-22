package xeredi.integra.http.controller.action.estadistica;

import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.comun.ItemListadoAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.estadistica.bo.Estadistica;
import xeredi.integra.model.estadistica.bo.EstadisticaBO;
import xeredi.integra.model.estadistica.vo.EstadisticaCriterioVO;
import xeredi.integra.model.estadistica.vo.EstadisticaVO;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.metamodelo.proxy.TipoEstadisticaProxy;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaVO;
import xeredi.integra.model.metamodelo.vo.TipoHtml;
import xeredi.integra.model.util.Entidad;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticaListadoAction.
 */
public final class EstadisticaListadoAction extends ItemListadoAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3980612360200744744L;

    /** The estds. */
    private PaginatedList<EstadisticaVO> itemList;

    /** The estd criterio form. */
    private EstadisticaCriterioVO itemCriterio;

    /**
     * Instantiates a new estadistica listado action.
     */
    public EstadisticaListadoAction() {
        super();

        itemCriterio = new EstadisticaCriterioVO();
        itemCriterio.setFechaVigencia(Calendar.getInstance().getTime());
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
    @Actions({ @Action(value = "estd-filtro"),
        @Action(value = "estd-filtro-popup", results = { @Result(name = "success", location = "estd-filtro.jsp") }) })
    public String filtro() {
        Preconditions.checkNotNull(itemCriterio);
        Preconditions.checkNotNull(itemCriterio.getEntiId());

        loadLabelValuesMap();

        return SUCCESS;
    }

    /**
     * Listado.
     *
     * @return the string
     */
    @Action(value = "estd-listado")
    public String listado() {
        Preconditions.checkNotNull(itemCriterio);
        Preconditions.checkNotNull(itemCriterio.getEntiId());

        final Estadistica estdBO = BOFactory.getInjector().getInstance(EstadisticaBO.class);

        itemCriterio.setSoloDatosGrid(true);

        if (hasErrors()) {
            return INPUT;
        }

        itemList = estdBO.selectList(itemCriterio, PaginatedList.getOffset(getPage(), getLimit()), getLimit());

        return SUCCESS;
    }

    // get / set

    /**
     * Load label values map.
     */
    protected final void loadLabelValuesMap() {
        if (labelValuesMap == null) {
            labelValuesMap = new HashMap<>();

            final TipoEstadisticaVO enti = TipoEstadisticaProxy.select(itemCriterio.getEntiId());

            // Carga de los labelValues (Si los hay)
            final Set<Long> tpprIds = new HashSet<>();

            if (enti.getEntdMap() != null) {
                for (final EntidadTipoDatoVO entdVO : enti.getEntdMap().values()) {
                    if (entdVO.getFiltrable() && entdVO.getTpdt().getTpht() != TipoHtml.F
                            && entdVO.getTpdt().getEnti() != null && entdVO.getTpdt().getEnti().getId() != null) {
                        tpprIds.add(entdVO.getTpdt().getEnti().getId());
                    }
                }
            }

            if (!tpprIds.isEmpty()) {
                final ParametroBO prmtBO = new ParametroBO();

                labelValuesMap.putAll(prmtBO.selectLabelValues(tpprIds, getItemCriterio().getFechaVigencia(),
                        getItemCriterio().getIdioma()));
            }
        }
    }

    /**
     * Gets the autps.
     *
     * @return the autps
     */
    public List<LabelValueVO> getAutpList() {
        final ParametroBO prmtBO = new ParametroBO();
        final Set<Long> tpprIds = new HashSet<>();

        tpprIds.add(Entidad.AUTORIDAD_PORTUARIA.getId());

        return prmtBO.selectLabelValues(tpprIds, Calendar.getInstance().getTime(), getIdioma()).get(
                Entidad.AUTORIDAD_PORTUARIA.getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final EstadisticaCriterioVO getItemCriterio() {
        return itemCriterio;
    }

    /**
     * Sets the item criterio.
     *
     * @param value
     *            the new item criterio
     */
    public final void setItemCriterio(final EstadisticaCriterioVO value) {
        itemCriterio = value;
    }

    /**
     * Gets the item list.
     *
     * @return the item list
     */
    public final PaginatedList<EstadisticaVO> getItemList() {
        return itemList;
    }

}
