package xeredi.integra.http.controller.action.servicio;

import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.ItemAction;
import xeredi.integra.http.util.FieldFiller;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.bo.ArchivoBO;
import xeredi.integra.model.comun.bo.PuertoBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.ArchivoCriterioVO;
import xeredi.integra.model.comun.vo.ArchivoInfoVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
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
import xeredi.integra.model.servicio.vo.ServicioVO;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioAction.
 */
public final class ServicioAction extends ItemAction implements ModelDriven<ServicioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2809685065940465041L;

    /** The srvc form. */
    private ServicioVO model;

    /** The enti. */
    private TipoServicioDetailVO enti;

    /** The arin list. */
    private List<ArchivoInfoVO> arinList;

    /** The prto list. */
    private List<PuertoVO> prtoList;

    /** The label values map. */
    private Map<Long, List<LabelValueVO>> labelValuesMap;

    // Acciones web
    /**
     * Detalle.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("srvc-detail")
    public String detail() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());
        Preconditions.checkNotNull(model.getEntiId());

        enti = TipoServicioProxy.select(model.getEntiId());

        final ServicioBO srvcBO = ServicioBOFactory.newInstance(model.getEntiId());

        model = srvcBO.select(model.getId(), getIdioma());

        final ArchivoBO archBO = new ArchivoBO();
        final ArchivoCriterioVO archCriterio = new ArchivoCriterioVO();

        archCriterio.setSrvcId(model.getId());

        arinList = archBO.selectList(archCriterio);

        setFechaVigencia(model.getFref());

        return SUCCESS;
    }

    /**
     * Modificar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action(value = "srvc-edit")
    public String edit() throws ApplicationException {
        Preconditions.checkNotNull(getAccion());
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getEntiId());

        enti = TipoServicioProxy.select(model.getEntiId());

        if (getAccion() == ACCION_EDICION.create) {
            model.setFref(Calendar.getInstance().getTime());
            model.setAnno(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));

            FieldFiller.fillDefaultValues(model, enti);
        } else {
            Preconditions.checkNotNull(model.getId());

            final ServicioBO srvcBO = ServicioBOFactory.newInstance(model.getEntiId());

            model = srvcBO.select(model.getId(), getIdioma());
        }

        setFechaVigencia(model.getFref());
        loadLabelValuesMap();

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("srvc-save")
    public String save() throws ApplicationException {
        Preconditions.checkNotNull(getAccion());
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getEntiId());

        enti = TipoServicioProxy.select(model.getEntiId());

        if (getAccion() == ACCION_EDICION.create) {
            FieldValidator.validateRequired(this, MessageI18nKey.prto, model.getPrto());
            FieldValidator.validateRequired(this, MessageI18nKey.srvc_anno, model.getAnno());
            FieldValidator.validateRequired(this, MessageI18nKey.srvc_numero, model.getNumero());
        } else {
            Preconditions.checkNotNull(model.getId());
        }

        if (enti.getEnti().getTpdtEstado() != null) {
            FieldValidator.validateRequired(this, MessageI18nKey.srvc_estado, model.getEstado());
        }

        if (enti.getEnti().isTemporal()) {
            FieldValidator.validateRequired(this, MessageI18nKey.srvc_fini, model.getFini());
            FieldValidator.validateRequired(this, MessageI18nKey.srvc_ffin, model.getFfin());
        } else {
            FieldValidator.validateRequired(this, MessageI18nKey.srvc_fref, model.getFref());
        }

        FieldValidator.validateItem(this, enti, model);

        if (!hasErrors()) {
            // FIXME ACABAR
            final ServicioBO srvcBO = ServicioBOFactory.newInstance(model.getEntiId());

            switch (getAccion()) {
            case create:
                srvcBO.insert(model, null, null, null);

                break;
            case edit:
                srvcBO.update(model);

                break;
            case duplicate:
                srvcBO.duplicate(model);

                break;
            default:
                throw new Error("Accion no soportada: " + getAccion());
            }
        }

        return SUCCESS;
    }

    /**
     * Borrar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("srvc-remove")
    public String borrar() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());
        Preconditions.checkNotNull(model.getEntiId());

        final ServicioBO srvcBO = ServicioBOFactory.newInstance(model.getEntiId());

        srvcBO.delete(model.getId());

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

        final PuertoBO prtoBO = new PuertoBO();
        final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

        prtoCriterio.setSprtId(getSprtId());
        prtoCriterio.setIdioma(getIdioma());

        prtoList = prtoBO.selectList(prtoCriterio);

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

            labelValuesMap.putAll(prmtBO.selectLabelValues(tpprIds, getFechaVigencia(), getIdioma()));
        }
    }

    // get / set

    /**
     * {@inheritDoc}
     */
    @Override
    public ServicioVO getModel() {
        return model;
    }

    /**
     * Sets the item.
     *
     * @param value
     *            the new item
     */
    public void setModel(final ServicioVO value) {
        model = value;
    }

    /**
     * {@inheritDoc}
     */
    public Long getPrtoId() {
        return model == null || model.getPrto() == null ? null : model.getPrto().getId();
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
    public TipoServicioDetailVO getEnti() {
        return enti;
    }

    /**
     * Gets the arin list.
     *
     * @return the arin list
     */
    public List<ArchivoInfoVO> getArinList() {
        return arinList;
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
