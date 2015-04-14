package xeredi.integra.http.controller.action.servicio;

import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.PaginableAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.maestro.bo.DefaultParametroBO;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoHtml;
import xeredi.integra.model.servicio.bo.SubservicioBO;
import xeredi.integra.model.servicio.bo.SubservicioBOFactory;
import xeredi.integra.model.servicio.vo.SubservicioCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioListadoAction.
 */
public final class SubservicioListadoAction extends PaginableAction implements ModelDriven<SubservicioCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -325205517324020646L;

    /** The srvc criterio form. */
    private SubservicioCriterioVO model;

    /** The enti. */
    private TipoSubservicioDetailVO enti;

    /** The srvcs. */
    private PaginatedList<SubservicioVO> itemList;

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
    @Action("ssrv-filter")
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
    @Action("ssrv-list")
    public String listado() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getEntiId());

        final SubservicioBO ssrvBO = SubservicioBOFactory.newInstance(model.getEntiId());

        // Traemos solo los datos 'gridables' de los parametros (Minimiza el
        // trafico con la BD)
        model.setSoloDatosGrid(true);
        model.setIdioma(getIdioma());

        itemList = ssrvBO.selectList(model, getOffset(), getLimit());

        enti = TipoSubservicioProxy.select(model.getEntiId());

        return SUCCESS;
    }

    // get /set

    /**
     * Load label values map.
     *
     * @throws ApplicationException
     *             the application exception
     */
    private void loadLabelValuesMap() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getEntiId());
        Preconditions.checkNotNull(model.getIdioma());

        if (labelValuesMap == null) {
            labelValuesMap = new HashMap<>();

            enti = TipoSubservicioProxy.select(model.getEntiId());

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
                final ParametroBO prmtBO = new DefaultParametroBO();

                labelValuesMap.putAll(prmtBO.selectLabelValues(tpprIds, Calendar.getInstance().getTime(), getModel()
                        .getIdioma()));
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SubservicioCriterioVO getModel() {
        return model;
    }

    /**
     * Sets the item criterio.
     *
     * @param value
     *            the new item criterio
     */
    public void setModel(final SubservicioCriterioVO value) {
        model = value;
    }

    /**
     * Gets the item list.
     *
     * @return the item list
     */
    public PaginatedList<SubservicioVO> getItemList() {
        return itemList;
    }

    /**
     * Gets the enti.
     *
     * @return the enti
     */
    public TipoSubservicioDetailVO getEnti() {
        return enti;
    }

}
