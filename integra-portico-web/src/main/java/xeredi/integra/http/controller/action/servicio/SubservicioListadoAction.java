package xeredi.integra.http.controller.action.servicio;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.comun.ItemListadoAction;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoHtml;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.integra.model.servicio.bo.SubservicioBO;
import xeredi.integra.model.servicio.vo.SubservicioCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;
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
    @Action("ssrv-filter")
    public String filtro() {
        Preconditions.checkNotNull(itemCriterio);
        Preconditions.checkNotNull(itemCriterio.getEntiId());

        itemCriterio.setIdioma(getIdioma());

        loadLabelValuesMap();

        return SUCCESS;
    }

    /**
     * Listado.
     *
     * @return the string
     */
    @Action("ssrv-list")
    public String listado() {
        Preconditions.checkNotNull(itemCriterio);
        Preconditions.checkNotNull(itemCriterio.getEntiId());

        final SubservicioBO ssrvBO = new SubservicioBO();

        // Traemos solo los datos 'gridables' de los parametros (Minimiza el
        // trafico con la BD)
        itemCriterio.setSoloDatosGrid(true);
        itemCriterio.setIdioma(getIdioma());

        itemList = ssrvBO.selectList(itemCriterio, PaginatedList.getOffset(getPage(), getLimit()), getLimit());

        return SUCCESS;
    }

    // get /set

    /**
     * Load label values map.
     */
    protected final void loadLabelValuesMap() {
        Preconditions.checkNotNull(itemCriterio);
        Preconditions.checkNotNull(itemCriterio.getEntiId());
        Preconditions.checkNotNull(itemCriterio.getIdioma());

        if (labelValuesMap == null) {
            labelValuesMap = new HashMap<>();

            final TipoSubservicioVO enti = TipoSubservicioProxy.select(itemCriterio.getEntiId());

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

                labelValuesMap.putAll(prmtBO.selectLabelValues(tpprIds, Calendar.getInstance().getTime(),
                        getItemCriterio().getIdioma()));
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SubservicioCriterioVO getItemCriterio() {
        return itemCriterio;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date getFechaVigencia() {
        return Calendar.getInstance().getTime();
    }

    /**
     * Sets the item criterio.
     *
     * @param value
     *            the new item criterio
     */
    public void setItemCriterio(final SubservicioCriterioVO value) {
        itemCriterio = value;
    }

    /**
     * Gets the item list.
     *
     * @return the item list
     */
    public PaginatedList<SubservicioVO> getItemList() {
        return itemList;
    }

}
