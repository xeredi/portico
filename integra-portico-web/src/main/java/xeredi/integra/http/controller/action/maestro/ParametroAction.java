package xeredi.integra.http.controller.action.maestro;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.validator.GenericValidator;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.comun.ItemAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.exception.OverlapException;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.vo.ParametroCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoParametroProxy;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
import xeredi.util.exception.InstanceNotFoundException;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroAction.
 */
public final class ParametroAction extends ItemAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 477492673223023219L;

    /** The enti. */
    private TipoParametroVO enti;

    /** The prmt . */
    private ParametroVO item;

    /** The p18n map. */
    private Map<String, I18nVO> i18nMap;

    /**
     * Instantiates a new parametro action.
     */
    public ParametroAction() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    // Acciones web
    /**
     * Alta.
     *
     * @return the string
     */
    @Action("prmt-create")
    public String create() {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getEntiId());

        accion = ACCION_EDICION.create;
        i18nMap = new HashMap<>();
        item.setFref(Calendar.getInstance().getTime());

        enti = TipoParametroProxy.select(item.getEntiId());

        loadLabelValuesMap(enti);

        return SUCCESS;
    }

    /**
     * Modificar.
     *
     * @return the string
     */
    @Action("prmt-edit")
    public String edit() {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        if (item.getFref() == null) {
            item.setFref(Calendar.getInstance().getTime());
        }

        accion = ACCION_EDICION.edit;

        final ParametroBO prmtBO = new ParametroBO();
        final I18nBO i18nBO = new I18nBO();
        final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

        prmtCriterioVO.setId(item.getId());
        prmtCriterioVO.setFechaVigencia(item.getFref());
        prmtCriterioVO.setIdioma(getIdioma());

        try {
            item = prmtBO.selectObject(prmtCriterioVO);

            item.setFref(prmtCriterioVO.getFechaVigencia());

            enti = TipoParametroProxy.select(item.getEntiId());

            if (enti.getI18n()) {
                i18nMap = i18nBO.selectMap(I18nPrefix.prvr, item.getPrvr().getId());
            }

            loadLabelValuesMap(enti);
        } catch (final InstanceNotFoundException ex) {
            addActionError(getText(MessageI18nKey.E00007.name(), new Object[] { String.valueOf(item.getId()) }));
        }

        return SUCCESS;
    }

    /**
     * Duplicar.
     *
     * @return the string
     */
    @Action("prmt-duplicate")
    public String duplicate() {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());
        Preconditions.checkNotNull(item.getFref());

        accion = ACCION_EDICION.duplicate;

        final ParametroBO prmtBO = new ParametroBO();
        final I18nBO i18nBO = new I18nBO();
        final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

        prmtCriterioVO.setId(item.getId());
        prmtCriterioVO.setFechaVigencia(item.getFref());
        prmtCriterioVO.setIdioma(getIdioma());

        try {
            item = prmtBO.selectObject(prmtCriterioVO);

            item.setFref(prmtCriterioVO.getFechaVigencia());

            enti = TipoParametroProxy.select(item.getEntiId());

            if (enti.getI18n()) {
                i18nMap = i18nBO.selectMap(I18nPrefix.prvr, item.getPrvr().getId());
            }

            loadLabelValuesMap(enti);
        } catch (final InstanceNotFoundException ex) {
            addActionError(getText(MessageI18nKey.E00007.name(), new Object[] { String.valueOf(item.getId()) }));
        }

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     */
    @Action("prmt-save")
    public String save() {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(item);

        final ParametroBO prmtBO = new ParametroBO();

        enti = TipoParametroProxy.select(item.getEntiId());

        // Validacion de Datos
        if (accion != ACCION_EDICION.edit) {
            if (GenericValidator.isBlankOrNull(item.getParametro())) {
                addActionError(getText(MessageI18nKey.E00001.name(),
                        new Object[] { getText(MessageI18nKey.prmt_parametro.name()) }));
            }
        }

        if (accion != ACCION_EDICION.create) {
            Preconditions.checkNotNull(item.getPrvr());
            Preconditions.checkNotNull(item.getId());
            Preconditions.checkNotNull(item.getPrvr().getId());
        }

        if (item.getPrvr() == null || item.getPrvr().getFini() == null) {
            addActionError(getText(MessageI18nKey.E00001.name(),
                    new Object[] { getText(MessageI18nKey.prmt_fini.name()) }));
        } else {
            if (item.getPrvr().getFfin() != null && !item.getPrvr().getFini().before(item.getPrvr().getFfin())) {
                addActionError(getText(MessageI18nKey.E00006.name()));
            }
        }

        if (enti.getI18n()) {
            FieldValidator.validateI18n(this, i18nMap);
        }

        FieldValidator.validateItem(this, enti, item);

        // Fin de validacion de datos

        if (hasErrors()) {
            return SUCCESS;
        }

        try {
            switch (accion) {
            case create:
                prmtBO.insert(item, enti, i18nMap);

                break;
            case edit:
                prmtBO.update(item, enti, i18nMap);

                break;
            case duplicate:
                prmtBO.duplicate(item, enti, i18nMap);

                break;

            default:
                throw new Error("Accion no valida: " + accion);
            }
        } catch (final OverlapException ex) {
            addActionError(getText(MessageI18nKey.E00009.name(), new Object[] { enti.getNombre() }));
        } catch (final InstanceNotFoundException ex) {
            addActionError(getText(MessageI18nKey.E00008.name(),
                    new Object[] { enti.getNombre(), String.valueOf(item.getId()) }));
        }

        if (hasErrors()) {
            return SUCCESS;
        }

        return SUCCESS;
    }

    /**
     * Borrar.
     *
     * @return the string
     */
    @Action("prmt-remove")
    public String remove() {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getPrvr());
        Preconditions.checkNotNull(item.getPrvr().getId());

        final ParametroBO prmtBO = new ParametroBO();

        try {
            prmtBO.delete(item);
        } catch (final InstanceNotFoundException ex) {
            addActionError(getText(MessageI18nKey.E00008.name(),
                    new Object[] { String.valueOf(item.getPrvr().getId()) }));
        }

        return SUCCESS;
    }

    /**
     * Detalle.
     *
     * @return the string
     */
    @Action("prmt-detail")
    public String detail() {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        if (item.getFref() == null) {
            item.setFref(Calendar.getInstance().getTime());
        }

        final ParametroBO prmtBO = new ParametroBO();
        final I18nBO i18nBO = new I18nBO();
        final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

        prmtCriterioVO.setId(item.getId());
        prmtCriterioVO.setFechaVigencia(item.getFref());
        prmtCriterioVO.setIdioma(getIdioma());

        try {
            item = prmtBO.selectObject(prmtCriterioVO);

            item.setFref(prmtCriterioVO.getFechaVigencia());
            enti = TipoParametroProxy.select(item.getEntiId());

            if (enti.getI18n()) {
                i18nMap = i18nBO.selectMap(I18nPrefix.prvr, item.getPrvr().getId());
            }
        } catch (final InstanceNotFoundException ex) {
            addActionError(getText(MessageI18nKey.E00007.name(), new Object[] { String.valueOf(prmtCriterioVO) }));
        }

        return SUCCESS;
    }

    // get / set

    /**
     * {@inheritDoc}
     */
    @Override
    public final ParametroVO getItem() {
        return item;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date getFechaVigencia() {
        return item == null ? Calendar.getInstance().getTime() : item.getFref();
    }

    /**
     * Sets the item.
     *
     * @param value
     *            the new item
     */
    public final void setItem(final ParametroVO value) {
        item = value;
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
    public TipoParametroVO getEnti() {
        return enti;
    }
}
