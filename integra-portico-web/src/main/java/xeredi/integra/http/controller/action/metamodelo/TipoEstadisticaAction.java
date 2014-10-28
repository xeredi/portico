package xeredi.integra.http.controller.action.metamodelo;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.util.I18nValidator;
import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.bo.TipoEstadisticaBO;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaVO;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoEstadisticaAction.
 */
public final class TipoEstadisticaAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3174617805403065108L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The tpes form. */
    private TipoEstadisticaVO enti;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /**
     * Instantiates a new tipo estadistica action.
     */
    public TipoEstadisticaAction() {
        super();

        enti = new TipoEstadisticaVO();
    }

    // Acciones Web
    /**
     * Alta.
     *
     * @return the string
     */
    @Action("tpes-create")
    public String create() {
        accion = ACCION_EDICION.create;

        return SUCCESS;
    }

    /**
     * Modificar.
     *
     * @return the string
     */
    @Action("tpes-edit")
    public String modificar() {
        Preconditions.checkNotNull(enti);
        Preconditions.checkNotNull(enti.getId());

        accion = ACCION_EDICION.edit;

        final TipoEstadisticaBO tpesBO = new TipoEstadisticaBO();
        final I18nBO i18nBO = new I18nBO();

        enti = tpesBO.select(enti.getId(), getIdioma());
        i18nMap = i18nBO.selectMap(I18nPrefix.enti, enti.getId());

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     */
    @Action("tpes-save")
    public String save() {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(enti);

        // Validaciones
        if (accion == ACCION_EDICION.create) {
            if (enti.getCodigo() == null || enti.getCodigo().isEmpty()) {
                addActionError(getText(MessageI18nKey.E00001.name(),
                        new String[] { getText(MessageI18nKey.enti_codigo.name()) }));
            }
        } else {
            Preconditions.checkNotNull(enti.getId());
        }

        I18nValidator.validate(this, i18nMap);

        if (hasErrors()) {
            return SUCCESS;
        }

        final TipoEstadisticaBO tpesBO = new TipoEstadisticaBO();

        if (accion == ACCION_EDICION.create) {
            enti.setCodigo(enti.getCodigo().toUpperCase());

            try {
                tpesBO.insert(enti, i18nMap);
            } catch (final DuplicateInstanceException ex) {
                addActionError(getText(MessageI18nKey.E00005.name(),
                        new String[] { getText(MessageI18nKey.tpes.name()) }));
            }
        } else {
            try {
                tpesBO.update(enti, i18nMap);
            } catch (final InstanceNotFoundException ex) {
                addActionError(getText(MessageI18nKey.E00008.name(), new String[] {
                        getText(MessageI18nKey.tpes.name()), String.valueOf(enti.getId()) }));
            }
        }

        return SUCCESS;
    }

    /**
     * Removes the.
     *
     * @return the string
     */
    @Action("tpes-remove")
    public String remove() {
        Preconditions.checkNotNull(enti);
        Preconditions.checkNotNull(enti.getId());

        final TipoEstadisticaBO tpesBO = new TipoEstadisticaBO();

        try {
            tpesBO.delete(enti.getId());
        } catch (final InstanceNotFoundException ex) {
            addActionError(getText(MessageI18nKey.E00008.name(), new String[] { getText(MessageI18nKey.tpes.name()),
                    String.valueOf(enti.getId()) }));
        }

        return SUCCESS;
    }

    /**
     * Detalle.
     *
     * @return the string
     */
    @Action("tpes-detail")
    public String detail() {
        Preconditions.checkNotNull(enti);
        Preconditions.checkNotNull(enti.getId());

        final TipoEstadisticaBO tpesBO = new TipoEstadisticaBO();
        final I18nBO i18nBO = new I18nBO();

        enti = tpesBO.select(enti.getId(), getIdioma());
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
    public TipoEstadisticaVO getEnti() {
        return enti;
    }

    /**
     * Sets the enti.
     *
     * @param value
     *            the enti
     */
    public void setEnti(final TipoEstadisticaVO value) {
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
