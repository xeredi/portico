package xeredi.integra.http.controller.action.metamodelo;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.util.I18nValidator;
import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.bo.TipoDatoBO;
import xeredi.integra.model.metamodelo.vo.TipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoElemento;
import xeredi.integra.model.metamodelo.vo.TipoHtml;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
import xeredi.util.exception.DuplicateInstanceException;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoDatoAction.
 */
public final class TipoDatoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7405460701196255597L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The tppr. */
    private TipoDatoVO tpdt;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /**
     * Instantiates a new tipo dato action.
     */
    public TipoDatoAction() {
        super();

        tpdt = new TipoDatoVO();
    }

    // Acciones Web
    /**
     * Alta.
     *
     * @return the string
     */
    @Action("tpdt-create")
    public String create() {
        accion = ACCION_EDICION.create;

        return SUCCESS;
    }

    /**
     * Modificar.
     *
     * @return the string
     */
    @Action("tpdt-edit")
    public String edit() {
        Preconditions.checkNotNull(tpdt);
        Preconditions.checkNotNull(tpdt.getId());

        accion = ACCION_EDICION.edit;

        final TipoDatoBO tpdtBO = new TipoDatoBO();
        final I18nBO i18nBO = new I18nBO();

        tpdt = tpdtBO.select(tpdt.getId(), getIdioma());

        if (tpdt == null) {
            addActionError(getText(MessageI18nKey.E00008.name(), new String[] { getText(MessageI18nKey.tpdt.name()),
                    String.valueOf(tpdt.getId()) }));
        }

        i18nMap = i18nBO.selectMap(I18nPrefix.tpdt, tpdt.getId());

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     */
    @Action("tpdt-save")
    public String save() {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(tpdt);

        // Validacion de datos
        if (accion == ACCION_EDICION.create) {
            if (tpdt.getCodigo() == null || tpdt.getCodigo().isEmpty()) {
                addActionError(getText(MessageI18nKey.E00001.name(),
                        new String[] { getText(MessageI18nKey.tpdt_codigo.name()) }));
            }
        } else {
            Preconditions.checkNotNull(tpdt.getId());
        }

        if (tpdt.getTpht() == null) {
            addActionError(getText(MessageI18nKey.E00001.name(),
                    new String[] { getText(MessageI18nKey.tpdt_tpht.name()) }));
        }
        if (tpdt.getTipoElemento() == null) {
            addActionError(getText(MessageI18nKey.E00001.name(),
                    new String[] { getText(MessageI18nKey.tpdt_tpel.name()) }));
        }

        if (tpdt.getTipoElemento() != null
                && (tpdt.getTipoElemento() == TipoElemento.PR || tpdt.getTipoElemento() == TipoElemento.SR)) {
            if (tpdt.getEnti() == null || tpdt.getEnti().getId() == null) {
                addActionError(getText(MessageI18nKey.E00001.name(),
                        new String[] { getText(MessageI18nKey.tpdt_enti.name()) }));
            }
        }

        I18nValidator.validate(this, i18nMap);

        if (hasErrors()) {
            return SUCCESS;
        }

        final TipoDatoBO tpdtBO = new TipoDatoBO();

        if (accion == ACCION_EDICION.create) {
            try {
                tpdtBO.insert(tpdt, i18nMap);
            } catch (final DuplicateInstanceException ex) {
                addActionError(getText(MessageI18nKey.E00005.name(),
                        new String[] { getText(MessageI18nKey.tpdt.name()) }));
            }
        } else {
            tpdtBO.update(tpdt, i18nMap);
        }

        return SUCCESS;
    }

    /**
     * Removes the.
     *
     * @return the string
     */
    @Action("tpdt-remove")
    public String remove() {
        Preconditions.checkNotNull(tpdt);
        Preconditions.checkNotNull(tpdt.getId());

        final TipoDatoBO tpdtBO = new TipoDatoBO();

        tpdtBO.delete(tpdt);

        return SUCCESS;
    }

    /**
     * Detalle.
     *
     * @return the string
     */
    @Action("tpdt-detail")
    public String detail() {
        Preconditions.checkNotNull(tpdt);
        Preconditions.checkNotNull(tpdt.getId());

        final TipoDatoBO tpdtBO = new TipoDatoBO();
        final I18nBO i18nBO = new I18nBO();

        tpdt = tpdtBO.select(tpdt.getId(), getIdioma());

        if (tpdt == null) {
            addActionError(getText(MessageI18nKey.E00008.name(), new String[] { getText(MessageI18nKey.tpdt.name()),
                    String.valueOf(tpdt.getId()) }));
        }

        i18nMap = i18nBO.selectMap(I18nPrefix.tpdt, tpdt.getId());

        return SUCCESS;
    }

    // get / set
    /**
     * Gets the tphts.
     *
     * @return the tphts
     */
    public TipoHtml[] getTphts() {
        return TipoHtml.values();
    }

    /**
     * Gets the tipos elemento.
     *
     * @return the tipos elemento
     */
    public TipoElemento[] getTiposElemento() {
        return TipoElemento.values();
    }

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
     * Gets the tpdt.
     *
     * @return the tpdt
     */
    public TipoDatoVO getTpdt() {
        return tpdt;
    }

    /**
     * Sets the tpdt.
     *
     * @param value
     *            the new tpdt
     */
    public void setTpdt(final TipoDatoVO value) {
        tpdt = value;
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
