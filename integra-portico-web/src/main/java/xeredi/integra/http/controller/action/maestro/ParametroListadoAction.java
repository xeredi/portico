package xeredi.integra.http.controller.action.maestro;

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
import xeredi.integra.model.maestro.bo.DefaultParametroBO;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.bo.ParametroBOFactory;
import xeredi.integra.model.maestro.vo.ParametroCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoParametroProxy;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoHtml;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroListadoAction.
 */
public final class ParametroListadoAction extends PaginableAction implements ModelDriven<ParametroCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4719886690588825194L;

    /** The criterio vo. */
    private ParametroCriterioVO model;

    /** The prmts. */
    private PaginatedList<ParametroVO> itemList;

    /** The enti id. */
    private TipoParametroVO enti;

    /** The prto list. */
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
    @Action("prmt-filter")
    public String filter() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getEntiId());

        if (model.getFechaVigencia() == null) {
            model.setFechaVigencia(Calendar.getInstance().getTime());
        }

        model.setIdioma(getIdioma());

        enti = TipoParametroProxy.select(model.getEntiId());

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
    @Action("prmt-list")
    public String list() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getEntiId());

        if (model.getFechaVigencia() == null) {
            model.setFechaVigencia(Calendar.getInstance().getTime());
        }

        model.setSoloDatosGrid(true);
        model.setIdioma(getIdioma());

        enti = TipoParametroProxy.select(model.getEntiId());

        final ParametroBO prmtBO = ParametroBOFactory.newInstance(model.getEntiId());

        itemList = prmtBO.selectList(model, PaginatedList.getOffset(getPage(), getLimit()), getLimit());

        return SUCCESS;
    }

    /**
     * Load label values map.
     *
     * @throws ApplicationException
     *             the application exception
     */
    private void loadLabelValuesMap() throws ApplicationException {
        Preconditions.checkNotNull(enti);

        if (enti.isPuerto()) {
            final PuertoBO prtoBO = new PuertoBO();
            final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

            prtoCriterio.setSprtId(getSprtId());
            prtoCriterio.setIdioma(getIdioma());

            prtoList = prtoBO.selectList(prtoCriterio);
        }

        // Carga de los labelValues (Si los hay)
        labelValuesMap = new HashMap<>();

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

            labelValuesMap.putAll(prmtBO.selectLabelValues(tpprIds, getModel().getFechaVigencia(), getModel()
                    .getIdioma()));
        }
    }

    // get / set

    /**
     * {@inheritDoc}
     */
    @Override
    public final ParametroCriterioVO getModel() {
        return model;
    }

    /**
     * Sets the item criterio.
     *
     * @param value
     *            the new item criterio
     */
    public final void setModel(final ParametroCriterioVO value) {
        model = value;
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
     * Gets the enti.
     *
     * @return the enti
     */
    public TipoParametroVO getEnti() {
        return enti;
    }

    /**
     * Sets the enti.
     *
     * @param value
     *            the new enti
     */
    public void setEnti(final TipoParametroVO value) {
        enti = value;
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
     * Gets the label values map.
     *
     * @return the label values map
     */
    public Map<Long, List<LabelValueVO>> getLabelValuesMap() {
        return labelValuesMap;
    }

}
