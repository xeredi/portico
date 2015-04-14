package xeredi.integra.http.controller.action.servicio;

import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.ItemAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.maestro.bo.DefaultParametroBO;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoHtml;
import xeredi.integra.model.servicio.bo.ServicioBO;
import xeredi.integra.model.servicio.bo.ServicioBOFactory;
import xeredi.integra.model.servicio.bo.SubservicioBO;
import xeredi.integra.model.servicio.bo.SubservicioBOFactory;
import xeredi.integra.model.servicio.vo.SubservicioCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioAction.
 */
public final class SubservicioAction extends ItemAction implements ModelDriven<SubservicioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 9210521463729954776L;

    /** The srvc form. */
    private SubservicioVO model;

    /** The enti. */
    private TipoSubservicioDetailVO enti;

    /** The item padres map. */
    private Map<Long, LabelValueVO> itemPadresMap;

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
    @Action("ssrv-detail")
    public String detail() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());
        Preconditions.checkNotNull(model.getEntiId());

        final SubservicioBO ssrvBO = SubservicioBOFactory.newInstance(model.getEntiId());

        model = ssrvBO.select(model.getId(), getIdioma());
        enti = TipoSubservicioProxy.select(model.getEntiId());

        if (enti.getEntiPadresList() != null) {
            itemPadresMap = new HashMap<Long, LabelValueVO>();

            for (final Long entiId : enti.getEntiPadresList()) {
                if (!enti.getEnti().getTpsrId().equals(entiId)) {
                    final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

                    ssrvCriterioVO.setHijoId(model.getId());
                    ssrvCriterioVO.setEntiId(entiId);

                    itemPadresMap.put(entiId, ssrvBO.selectLabelValueObject(ssrvCriterioVO));
                }
            }
        }

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
    @Action("ssrv-edit")
    public String edit() throws ApplicationException {
        Preconditions.checkNotNull(getAccion());
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getEntiId());

        enti = TipoSubservicioProxy.select(model.getEntiId());

        if (getAccion() == ACCION_EDICION.create) {
            if (model.getSrvc() != null && model.getSrvc().getId() != null) {
                final ServicioBO srvcBO = ServicioBOFactory.newInstance(enti.getEnti().getTpsrId());

                model.setSrvc(srvcBO.select(model.getSrvc().getId(), getIdioma()));
                model.setFref(model.getSrvc().getFref());
            } else {
                model.setFref(Calendar.getInstance().getTime());
            }
        } else {
            Preconditions.checkNotNull(model.getSrvc());
            Preconditions.checkNotNull(model.getSrvc().getId());
            Preconditions.checkNotNull(model.getId());

            final SubservicioBO ssrvBO = SubservicioBOFactory.newInstance(model.getEntiId());

            model = ssrvBO.select(model.getId(), getIdioma());

            if (getAccion() == ACCION_EDICION.edit) {
                if (enti.getEntiPadresList() != null) {
                    itemPadresMap = new HashMap<Long, LabelValueVO>();

                    for (final Long entiId : enti.getEntiPadresList()) {
                        if (!enti.getEnti().getTpsrId().equals(entiId)) {
                            final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

                            ssrvCriterioVO.setHijoId(model.getId());
                            ssrvCriterioVO.setEntiId(entiId);

                            itemPadresMap.put(entiId, ssrvBO.selectLabelValueObject(ssrvCriterioVO));
                        }
                    }
                }
            }
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
    @Action("ssrv-save")
    public String save() throws ApplicationException {
        Preconditions.checkNotNull(getAccion());
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getEntiId());

        enti = TipoSubservicioProxy.select(model.getEntiId());

        if (getAccion() == ACCION_EDICION.create) {
            FieldValidator.validateRequired(this, MessageI18nKey.ssrv_srvc, model.getSrvc());
            FieldValidator.validateRequired(this, MessageI18nKey.ssrv_numero, model.getNumero());
        } else {
            Preconditions.checkNotNull(model.getId());
            Preconditions.checkNotNull(model.getSrvc());
            Preconditions.checkNotNull(model.getSrvc().getId());
            Preconditions.checkNotNull(model.getNumero());
        }

        if (enti.getEnti().getTpdtEstado() != null) {
            FieldValidator.validateRequired(this, MessageI18nKey.ssrv_estado, model.getEstado());
        }

        if (enti.getEnti().isTemporal()) {
            FieldValidator.validateRequired(this, MessageI18nKey.ssrv_fini, model.getFini());
            FieldValidator.validateRequired(this, MessageI18nKey.ssrv_ffin, model.getFfin());
        }

        FieldValidator.validateItem(this, enti, model);

        if (!hasErrors()) {
            final SubservicioBO ssrvBO = SubservicioBOFactory.newInstance(model.getEntiId());

            switch (getAccion()) {
            case create:
                ssrvBO.insert(model, enti, null);

                break;
            case edit:
                ssrvBO.update(model);

                break;
            case duplicate:
                ssrvBO.duplicate(model);

                break;
            default:
                throw new Error("Accion no valida: " + getAccion());
            }
        }

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
     * Gets the prto id.
     *
     * @return the prto id
     */
    public Long getPrtoId() {
        return model == null || model.getSrvc() == null || model.getSrvc().getPrto() == null ? null : model.getSrvc()
                .getPrto().getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final SubservicioVO getModel() {
        return model;
    }

    /**
     * Sets the item.
     *
     * @param value
     *            the new item
     */
    public final void setModel(final SubservicioVO value) {
        model = value;
    }

    /**
     * Gets the item padres map.
     *
     * @return the item padres map
     */
    public Map<Long, LabelValueVO> getItemPadresMap() {
        return itemPadresMap;
    }

    /**
     * Sets the item padres map.
     *
     * @param value
     *            the value
     */
    public void setItemPadresMap(final Map<Long, LabelValueVO> value) {
        itemPadresMap = value;
    }

    /**
     * Gets the enti.
     *
     * @return the enti
     */
    public TipoSubservicioDetailVO getEnti() {
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
