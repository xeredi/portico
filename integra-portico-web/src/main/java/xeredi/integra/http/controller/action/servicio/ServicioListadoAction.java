package xeredi.integra.http.controller.action.servicio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.comun.ItemListadoAction;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoHtml;
import xeredi.integra.model.metamodelo.vo.TipoServicioVO;
import xeredi.integra.model.servicio.bo.ServicioBO;
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

    /** The enti. */
    private TipoServicioVO enti;

    /** The srvcs. */
    private PaginatedList<ServicioVO> itemList;

    /** The srvc criterio form. */
    private ServicioCriterioVO itemCriterio;

    /** The subps. */
    private List<LabelValueVO> subpList;

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
    @Action("srvc-filter")
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
    @Action("srvc-list")
    public String listado() {
        Preconditions.checkNotNull(itemCriterio);
        Preconditions.checkNotNull(itemCriterio.getEntiId());

        final ServicioBO srvcBO = new ServicioBO();

        // Traemos solo los datos 'gridables' de los parametros (Minimiza el
        // trafico con la BD)
        itemCriterio.setSoloDatosGrid(true);
        itemCriterio.setIdioma(getIdioma());

        itemList = srvcBO.selectList(itemCriterio, PaginatedList.getOffset(getPage(), getLimit()), getLimit());

        enti = TipoServicioProxy.select(itemCriterio.getEntiId());

        return SUCCESS;
    }

    // get /set

    /**
     * Load label values map.
     */
    protected final void loadLabelValuesMap() {
        Preconditions.checkNotNull(itemCriterio);
        Preconditions.checkNotNull(itemCriterio.getIdioma());
        Preconditions.checkNotNull(itemCriterio.getEntiId());

        if (labelValuesMap == null) {
            labelValuesMap = new HashMap<>();

            final TipoServicioVO enti = TipoServicioProxy.select(itemCriterio.getEntiId());

            // Carga de los labelValues (Si los hay)
            final Set<Long> tpprIds = new HashSet<>();

            if (enti.getEntdList() != null) {
                for (final EntidadTipoDatoVO entdVO : enti.getEntdList()) {
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

        if (subpList == null) {
            subpList = new ArrayList<>();

            final ParametroBO prmtBO = new ParametroBO();
            final Set<Long> tpprIds = new HashSet<>();

            tpprIds.add(Entidad.SUBPUERTO.getId());

            subpList.addAll(prmtBO.selectLabelValues(tpprIds, Calendar.getInstance().getTime(), getIdioma()).get(
                    Entidad.SUBPUERTO.getId()));
        }
    }

    /**
     * Gets the subps.
     *
     * @return the subps
     */
    public List<LabelValueVO> getSubpList() {
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
     * Gets the enti.
     *
     * @return the enti
     */
    public TipoServicioVO getEnti() {
        return enti;
    }

}
