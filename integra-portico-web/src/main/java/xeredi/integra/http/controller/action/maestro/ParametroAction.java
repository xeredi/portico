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
import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.bo.PuertoBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.comun.vo.PuertoCriterioVO;
import xeredi.integra.model.comun.vo.PuertoVO;
import xeredi.integra.model.maestro.bo.DefaultParametroBO;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.bo.ParametroBOFactory;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoParametroDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoParametroProxy;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoHtml;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroAction.
 */
public final class ParametroAction extends ItemAction implements ModelDriven<ParametroVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 477492673223023219L;

    /** The enti. */
    private TipoParametroDetailVO enti;

    /** The prmt . */
    private ParametroVO model;

    /** The p18n map. */
    private Map<String, I18nVO> i18nMap;

    /** The prto list. */
    private List<PuertoVO> prtoList;

    /** The label values map. */
    private Map<Long, List<LabelValueVO>> labelValuesMap;

    // Acciones web
    /**
     * Modificar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("prmt-edit")
    public String edit() throws ApplicationException {
        Preconditions.checkNotNull(getAccion());
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getEntiId());
        Preconditions.checkNotNull(getFechaVigencia());

        enti = TipoParametroProxy.select(model.getEntiId());

        if (getAccion() != ACCION_EDICION.create) {
            Preconditions.checkNotNull(model.getId());

            final ParametroBO prmtBO = ParametroBOFactory.newInstance(model.getEntiId());

            model = prmtBO.select(model.getId(), getIdioma(), getFechaVigencia());

            if (enti.getEnti().isI18n()) {
                i18nMap = I18nBO.selectMap(I18nPrefix.prvr, model.getPrvr().getId());
            }
        }

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
    @Action("prmt-save")
    public String save() throws ApplicationException {
        Preconditions.checkNotNull(getAccion());
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getEntiId());

        enti = TipoParametroProxy.select(model.getEntiId());

        // Validacion de Datos
        if (getAccion() != ACCION_EDICION.edit) {
            if (enti.getEnti().isPuerto()) {
                FieldValidator.validateRequired(this, MessageI18nKey.prto, model.getPrto());

                if (!hasErrors()) {
                    FieldValidator.validateRequired(this, MessageI18nKey.prto, model.getPrto().getId());
                }
            }

            FieldValidator.validateRequired(this, MessageI18nKey.prmt_parametro, model.getParametro());
        }

        if (getAccion() != ACCION_EDICION.create) {
            Preconditions.checkNotNull(model.getPrvr());
            Preconditions.checkNotNull(model.getId());
            Preconditions.checkNotNull(model.getPrvr().getId());
        }

        if (model.getPrvr() == null) {
            FieldValidator.validateRequired(this, MessageI18nKey.prmt_fini, model.getPrvr());
        } else {
            FieldValidator.validateRequired(this, MessageI18nKey.prmt_fini, model.getPrvr().getFini());
            FieldValidator.validatePeriod(this, model.getPrvr().getFini(), model.getPrvr().getFfin());
        }

        if (enti.getEnti().isI18n()) {
            FieldValidator.validateI18n(this, i18nMap);
        }

        FieldValidator.validateItem(this, enti, model);

        // Fin de validacion de datos

        if (!hasErrors()) {
            final ParametroBO prmtBO = ParametroBOFactory.newInstance(model.getEntiId());

            switch (getAccion()) {
            case create:
                prmtBO.insert(model, enti, i18nMap);

                break;
            case edit:
                prmtBO.update(model, enti, i18nMap);

                break;
            case duplicate:
                prmtBO.duplicate(model, enti, i18nMap);

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
    @Action("prmt-remove")
    public String remove() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getPrvr());
        Preconditions.checkNotNull(model.getPrvr().getId());
        Preconditions.checkNotNull(model.getEntiId());

        final ParametroBO prmtBO = ParametroBOFactory.newInstance(model.getEntiId());

        prmtBO.delete(model);

        return SUCCESS;
    }

    /**
     * Detalle.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("prmt-detail")
    public String detail() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());
        Preconditions.checkNotNull(model.getEntiId());

        if (getFechaVigencia() == null) {
            setFechaVigencia(Calendar.getInstance().getTime());
        }

        final ParametroBO prmtBO = ParametroBOFactory.newInstance(model.getEntiId());

        model = prmtBO.select(model.getId(), getIdioma(), getFechaVigencia());
        enti = TipoParametroProxy.select(model.getEntiId());

        if (enti.getEnti().isI18n()) {
            i18nMap = I18nBO.selectMap(I18nPrefix.prvr, model.getPrvr().getId());
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

        if (enti.getEnti().isPuerto()) {
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

            labelValuesMap.putAll(prmtBO.selectLabelValues(tpprIds, getFechaVigencia(), getIdioma()));
        }
    }

    // get / set

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
     * Gets the i18n map.
     *
     * @return the i18n map
     */
    public Map<String, I18nVO> getI18nMap() {
        return i18nMap;
    }

    /**
     * Sets the i18n map.
     *
     * @param value
     *            the value
     */
    public void setI18nMap(final Map<String, I18nVO> value) {
        i18nMap = value;
    }

    /**
     * Gets the enti.
     *
     * @return the enti
     */
    public TipoParametroDetailVO getEnti() {
        return enti;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParametroVO getModel() {
        return model;
    }

    /**
     * Sets the model.
     *
     * @param model
     *            the new model
     */
    public void setModel(final ParametroVO model) {
        this.model = model;
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
