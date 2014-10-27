package xeredi.integra.http.controller.action.metamodelo;

import java.util.Map;

import org.apache.commons.validator.GenericValidator;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.util.I18nValidator;
import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.bo.TipoSubparametroBO;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroVO;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubparametroAction.
 */
public final class TipoSubparametroAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5302381394776687182L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The tpsp. */
    private TipoSubparametroVO enti;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    // Acciones Web
    /**
     * Alta.
     *
     * @return the string
     */
    @Action("tpsp-create")
    public String create() {
        Preconditions.checkNotNull(enti);
        Preconditions.checkNotNull(enti.getTpprId());

        accion = ACCION_EDICION.create;

        return SUCCESS;
    }

    /**
     * Modificar.
     *
     * @return the string
     */
    @Action("tpsp-edit")
    public String edit() {
        Preconditions.checkNotNull(enti);
        Preconditions.checkNotNull(enti.getId());

        accion = ACCION_EDICION.edit;

        if (enti.getId() == null) {
            throw new Error("Identificador de tipo de subparametro no especificado");
        }

        final TipoSubparametroBO tpspBO = new TipoSubparametroBO();
        final I18nBO i18nBO = new I18nBO();

        enti = tpspBO.select(enti.getId(), getIdioma());
        i18nMap = i18nBO.selectMap(I18nPrefix.enti, enti.getId());

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     */
    @Action("tpsp-save")
    public String save() {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(enti);

        // Validaciones
        if (accion == ACCION_EDICION.create) {
            if (GenericValidator.isBlankOrNull(enti.getCodigo())) {
                addActionError(getText(MessageI18nKey.E00001.name(),
                        new String[] { getText(MessageI18nKey.enti_codigo.name()) }));
            }
        } else {
            Preconditions.checkNotNull(enti.getId());
        }

        I18nValidator.validate(this, i18nMap);

        if (enti.getTpprAsociado() == null || enti.getTpprAsociado().getId() == null) {
            addActionError(getText(MessageI18nKey.E00001.name(),
                    new String[] { getText(MessageI18nKey.enti_tpprAsociado.name()) }));
        }
        if (enti.getCmdAlta() == null) {
            addActionError(getText(MessageI18nKey.E00001.name(),
                    new String[] { getText(MessageI18nKey.enti_cmdAlta.name()) }));
        }
        if (enti.getCmdBaja() == null) {
            addActionError(getText(MessageI18nKey.E00001.name(),
                    new String[] { getText(MessageI18nKey.enti_cmdBaja.name()) }));
        }
        if (enti.getCmdEdicion() == null) {
            addActionError(getText(MessageI18nKey.E00001.name(),
                    new String[] { getText(MessageI18nKey.enti_cmdEdicion.name()) }));
        }
        if (enti.getCmdDuplicado() == null) {
            addActionError(getText(MessageI18nKey.E00001.name(),
                    new String[] { getText(MessageI18nKey.enti_cmdDuplicado.name()) }));
        }
        if (enti.getI18n() == null) {
            addActionError(getText(MessageI18nKey.E00001.name(),
                    new String[] { getText(MessageI18nKey.enti_i18n.name()) }));
        }
        if (enti.getTempExp() == null) {
            addActionError(getText(MessageI18nKey.E00001.name(),
                    new String[] { getText(MessageI18nKey.enti_tempExp.name()) }));
        }

        if (hasErrors()) {
            return SUCCESS;
        }

        final TipoSubparametroBO tpspBO = new TipoSubparametroBO();

        if (accion == ACCION_EDICION.create) {
            enti.setCodigo(enti.getCodigo().toUpperCase());

            try {
                tpspBO.insert(enti, i18nMap);
            } catch (final DuplicateInstanceException ex) {
                addActionError(getText(MessageI18nKey.E00005.name(),
                        new String[] { getText(MessageI18nKey.tpsp.name()) }));
            }
        } else {
            try {
                tpspBO.update(enti, i18nMap);
            } catch (final InstanceNotFoundException ex) {
                addActionError(getText(MessageI18nKey.E00008.name(), new String[] {
                    getText(MessageI18nKey.tpsp.name()), String.valueOf(enti.getId()) }));
            }
        }

        return SUCCESS;
    }

    /**
     * Removes the.
     *
     * @return the string
     */
    @Action("tpsp-remove")
    public String remove() {
        Preconditions.checkNotNull(enti);
        Preconditions.checkNotNull(enti.getId());

        final TipoSubparametroBO tpspBO = new TipoSubparametroBO();

        try {
            tpspBO.delete(enti.getId());
        } catch (final InstanceNotFoundException ex) {
            addActionError(getText(MessageI18nKey.E00008.name(), new String[] { getText(MessageI18nKey.tpsp.name()),
                String.valueOf(enti.getId()) }));
        }

        return SUCCESS;
    }

    /**
     * Detalle.
     *
     * @return the string
     */
    @Action("tpsp-detail")
    public String detail() {
        Preconditions.checkNotNull(enti);
        Preconditions.checkNotNull(enti.getId());

        final TipoSubparametroBO tpspBO = new TipoSubparametroBO();
        final I18nBO i18nBO = new I18nBO();

        enti = tpspBO.select(enti.getId(), getIdioma());
        i18nMap = i18nBO.selectMap(I18nPrefix.enti, enti.getId());

        return SUCCESS;
    }

    // get / set
    /**
     * Gets the accion.
     *
     * @return the accion
     */
    public ACCION_EDICION getAccion() {
        return accion;
    }

    /**
     * Sets the accion.
     *
     * @param value
     *            the new accion
     */
    public void setAccion(final ACCION_EDICION value) {
        accion = value;
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
     * Sets the enti.
     *
     * @param value
     *            the enti
     */
    public void setEnti(final TipoSubparametroVO value) {
        enti = value;
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

}
