package xeredi.integra.http.controller.action.maestro;

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
import xeredi.integra.model.maestro.bo.SubparametroBO;
import xeredi.integra.model.maestro.vo.SubparametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubparametroProxy;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoHtml;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroVO;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class SubparametroAction.
 */
public final class SubparametroAction extends ItemAction implements ModelDriven<SubparametroVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2326503947837608186L;

    /** The item. */
    private SubparametroVO model;

    /** The enti. */
    private TipoSubparametroVO enti;

    /** The label values map. */
    private Map<Long, List<LabelValueVO>> labelValuesMap;

    // Acciones Web
    /**
     * Modificar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("sprm-edit")
    public String edit() throws ApplicationException {
        Preconditions.checkNotNull(getAccion());
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getEntiId());
        Preconditions.checkNotNull(model.getPrmtId());
        Preconditions.checkNotNull(getFechaVigencia());

        if (getAccion() != ACCION_EDICION.create) {
            Preconditions.checkNotNull(model.getId());

            final SubparametroBO sprmBO = new SubparametroBO();

            model = sprmBO.selectObject(model.getId(), getIdioma(), getFechaVigencia());
        }

        enti = TipoSubparametroProxy.select(model.getEntiId());

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
    @Action("sprm-save")
    public String save() throws ApplicationException {
        Preconditions.checkNotNull(getAccion());
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getEntiId());

        final SubparametroBO sprmBO = new SubparametroBO();

        enti = TipoSubparametroProxy.select(model.getEntiId());

        // Validacion de Datos
        if (getAccion() != ACCION_EDICION.edit) {
            FieldValidator.validateRequired(this, getText("enti_" + enti.getTpprAsociado().getId()),
                    model.getPrmtAsociado());
        }

        if (getAccion() != ACCION_EDICION.create) {
            Preconditions.checkNotNull(model.getId());
            Preconditions.checkNotNull(model.getSpvr());
            Preconditions.checkNotNull(model.getSpvr().getId());
        }

        if (model.getSpvr() == null) {
            FieldValidator.validateRequired(this, MessageI18nKey.sprm_fini, model.getSpvr());
        } else {
            FieldValidator.validateRequired(this, MessageI18nKey.sprm_fini, model.getSpvr().getFini());
            FieldValidator.validatePeriod(this, model.getSpvr().getFini(), model.getSpvr().getFfin());
        }

        FieldValidator.validateItem(this, enti, model);

        // Fin de validacion de datos

        if (!hasErrors()) {
            switch (getAccion()) {
            case create:
                sprmBO.insert(model, enti);

                break;
            case edit:
                sprmBO.update(model, enti);

                break;
            case duplicate:
                sprmBO.duplicate(model, enti);

                break;
            default:
                throw new Error("Accion no valida: " + getAccion());
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
    @Action("sprm-remove")
    public String remove() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getSpvr());
        Preconditions.checkNotNull(model.getSpvr().getId());

        final SubparametroBO sprmBO = new SubparametroBO();

        sprmBO.delete(model);

        return SUCCESS;
    }

    /**
     * Detalle.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("sprm-detail")
    public String detalle() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        if (getFechaVigencia() == null) {
            setFechaVigencia(Calendar.getInstance().getTime());
        }

        final SubparametroBO sprmBO = new SubparametroBO();

        model = sprmBO.selectObject(model.getId(), getIdioma(), getFechaVigencia());
        enti = TipoSubparametroProxy.select(model.getEntiId());

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
     * {@inheritDoc}
     */
    @Override
    public SubparametroVO getModel() {
        return model;
    }

    /**
     * Sets the item.
     *
     * @param value
     *            the new item
     */
    public void setModel(final SubparametroVO value) {
        model = value;
    }

    /**
     * {@inheritDoc}
     */
    public Long getPrtoId() {
        // FIXME Implementar

        return null;
    }

    /**
     * Gets the enti.
     *
     * @return the enti
     */
    public TipoSubparametroVO getEnti() {
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
