package xeredi.integra.http.controller.action.servicio;

import java.util.Calendar;
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
import xeredi.integra.model.maestro.bo.DefaultParametroBO;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.metamodelo.proxy.TipoServicioDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoHtml;
import xeredi.integra.model.servicio.bo.ServicioBO;
import xeredi.integra.model.servicio.bo.ServicioBOFactory;
import xeredi.integra.model.servicio.vo.ServicioCriterioVO;
import xeredi.integra.model.servicio.vo.ServicioVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioListadoAction.
 */
public final class ServicioListadoAction extends PaginableAction implements ModelDriven<ServicioCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6459367626812047036L;

    /** The srvc criterio form. */
    private ServicioCriterioVO model;

    /** The enti. */
    private TipoServicioDetailVO enti;

    /** The srvcs. */
    private PaginatedList<ServicioVO> itemList;

    /** The subps. */
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
    @Action("srvc-filter")
    public String filtro() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getEntiId());

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
    @Action("srvc-list")
    public String listado() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getEntiId());

        final ServicioBO srvcBO = ServicioBOFactory.newInstance(model.getEntiId());

        // Traemos solo los datos 'gridables' de los parametros (Minimiza el
        // trafico con la BD)
        model.setSoloDatosGrid(true);
        model.setIdioma(getIdioma());

        itemList = srvcBO.selectList(model, getOffset(), getLimit());

        enti = TipoServicioProxy.select(model.getEntiId());

        return SUCCESS;
    }

    // get /set

    /**
     * Load label values map.
     *
     * @throws ApplicationException
     *             the application exception
     */
    private final void loadLabelValuesMap() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getIdioma());
        Preconditions.checkNotNull(model.getEntiId());

        final ParametroBO prmtBO = new DefaultParametroBO();

        enti = TipoServicioProxy.select(model.getEntiId());
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
            labelValuesMap = prmtBO
                    .selectLabelValues(tpprIds, Calendar.getInstance().getTime(), getModel().getIdioma());
        }

        final PuertoBO prtoBO = new PuertoBO();
        final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

        prtoCriterio.setSprtId(getSprtId());
        prtoCriterio.setIdioma(getIdioma());

        prtoList = prtoBO.selectList(prtoCriterio);
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
     * {@inheritDoc}
     */
    @Override
    public ServicioCriterioVO getModel() {
        return model;
    }

    /**
     * Sets the item criterio.
     *
     * @param value
     *            the new item criterio
     */
    public void setModel(final ServicioCriterioVO value) {
        model = value;
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
    public TipoServicioDetailVO getEnti() {
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
