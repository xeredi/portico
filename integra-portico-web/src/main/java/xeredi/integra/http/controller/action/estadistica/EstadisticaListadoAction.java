package xeredi.integra.http.controller.action.estadistica;

import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.PaginableAction;
import xeredi.integra.model.comun.bo.PuertoBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.PuertoCriterioVO;
import xeredi.integra.model.comun.vo.PuertoVO;
import xeredi.integra.model.estadistica.bo.EstadisticaBO;
import xeredi.integra.model.estadistica.vo.EstadisticaCriterioVO;
import xeredi.integra.model.estadistica.vo.EstadisticaVO;
import xeredi.integra.model.maestro.bo.DefaultParametroBO;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.metamodelo.proxy.TipoEstadisticaDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoEstadisticaProxy;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoHtml;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticaListadoAction.
 */
public final class EstadisticaListadoAction extends PaginableAction implements ModelDriven<EstadisticaCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3980612360200744744L;

    /** The estd criterio form. */
    private EstadisticaCriterioVO model;

    /** The enti. */
    private TipoEstadisticaDetailVO enti;

    /** The estds. */
    private PaginatedList<EstadisticaVO> itemList;

    /** The subp list. */
    private List<PuertoVO> prtoList;

    /** The label values map. */
    private Map<Long, List<LabelValueVO>> labelValuesMap;

    // Acciones web
    /**
     * Editar filtro.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("estd-filter")
    public String filtro() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getEntiId());
        Preconditions.checkNotNull(model.getPepr());
        Preconditions.checkNotNull(model.getPepr().getId());
        Preconditions.checkNotNull(model.getPepr().getSprtId());

        model.setIdioma(getIdioma());

        loadLabelValuesMap();

        return SUCCESS;
    }

    /**
     * Listado.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("estd-list")
    public String listado() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getEntiId());
        Preconditions.checkNotNull(model.getPepr());
        Preconditions.checkNotNull(model.getPepr().getId());
        Preconditions.checkNotNull(model.getPepr().getSprtId());

        final EstadisticaBO estdBO = new EstadisticaBO();

        model.setSoloDatosGrid(true);
        model.setIdioma(getIdioma());

        itemList = estdBO.selectList(model, PaginatedList.getOffset(getPage(), getLimit()), getLimit());

        enti = TipoEstadisticaProxy.select(model.getEntiId());

        return SUCCESS;
    }

    // get / set

    /**
     * Load label values map.
     *
     * @throws ApplicationException
     *             the application exception
     */
    protected final void loadLabelValuesMap() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getEntiId());
        Preconditions.checkNotNull(model.getPepr());
        Preconditions.checkNotNull(model.getPepr().getId());
        Preconditions.checkNotNull(model.getPepr().getSprtId());
        Preconditions.checkNotNull(model.getIdioma());

        final ParametroBO prmtBO = new DefaultParametroBO();

        {
            enti = TipoEstadisticaProxy.select(model.getEntiId());

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
                labelValuesMap = new HashMap<>();
                labelValuesMap.putAll(prmtBO.selectLabelValues(tpprIds, Calendar.getInstance().getTime(), getModel()
                        .getIdioma()));
            }
        }

        {
            final PuertoBO prtoBO = new PuertoBO();
            final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

            prtoCriterio.setSprtId(getSprtId());
            prtoCriterio.setIdioma(getIdioma());

            prtoList = prtoBO.selectList(prtoCriterio);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final EstadisticaCriterioVO getModel() {
        return model;
    }

    /**
     * Sets the item criterio.
     *
     * @param value
     *            the new item criterio
     */
    public final void setModel(final EstadisticaCriterioVO value) {
        model = value;
    }

    /**
     * Gets the item list.
     *
     * @return the item list
     */
    public final PaginatedList<EstadisticaVO> getItemList() {
        return itemList;
    }

    /**
     * Gets the prto list.
     *
     * @return the prto list
     */
    public List<PuertoVO> getPrtoList() {
        return prtoList;
    }

    /**
     * Gets the enti.
     *
     * @return the enti
     */
    public TipoEstadisticaDetailVO getEnti() {
        return enti;
    }

    /**
     * Gets the label values map.
     *
     * @return the label values map
     */
    public Map<Long, List<LabelValueVO>> getLabelValuesMap() {
        return labelValuesMap;
    }

}
