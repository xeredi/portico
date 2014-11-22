package xeredi.integra.http.controller.action.metamodelo;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.bo.TipoSubparametroBO;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroVO;

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
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("tpsp-edit")
    public String edit() throws InstanceNotFoundException {
        Preconditions.checkNotNull(enti);
        Preconditions.checkNotNull(enti.getId());

        final TipoSubparametroBO tpspBO = new TipoSubparametroBO();

        enti = tpspBO.select(enti.getId(), getIdioma());
        i18nMap = I18nBO.selectMap(I18nPrefix.enti, enti.getId());
        accion = ACCION_EDICION.edit;

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    @Action("tpsp-save")
    public String save() throws InstanceNotFoundException, DuplicateInstanceException {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(enti);

        // Validaciones
        if (accion == ACCION_EDICION.create) {
            FieldValidator.validateRequired(this, MessageI18nKey.enti_codigo, enti.getCodigo());
        } else {
            Preconditions.checkNotNull(enti.getId());
        }

        FieldValidator.validateI18n(this, i18nMap);

        FieldValidator.validateRequired(this, MessageI18nKey.enti_tpprAsociado, enti.getTpprAsociado());
        FieldValidator.validateRequired(this, MessageI18nKey.enti_cmdAlta, enti.getCmdAlta());
        FieldValidator.validateRequired(this, MessageI18nKey.enti_cmdBaja, enti.getCmdBaja());
        FieldValidator.validateRequired(this, MessageI18nKey.enti_cmdEdicion, enti.getCmdEdicion());
        FieldValidator.validateRequired(this, MessageI18nKey.enti_cmdDuplicado, enti.getCmdDuplicado());
        FieldValidator.validateRequired(this, MessageI18nKey.enti_i18n, enti.getI18n());
        FieldValidator.validateRequired(this, MessageI18nKey.enti_tempExp, enti.getTempExp());

        if (!hasErrors()) {
            final TipoSubparametroBO tpspBO = new TipoSubparametroBO();

            switch (accion) {
            case create:
                enti.setCodigo(enti.getCodigo().toUpperCase());
                tpspBO.insert(enti, i18nMap);

                break;
            case edit:
                tpspBO.update(enti, i18nMap);

                break;
            default:
                throw new Error("accion no soportada: " + accion);
            }
        }

        return SUCCESS;
    }

    /**
     * Removes the.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("tpsp-remove")
    public String remove() throws InstanceNotFoundException {
        Preconditions.checkNotNull(enti);
        Preconditions.checkNotNull(enti.getId());

        final TipoSubparametroBO tpspBO = new TipoSubparametroBO();

        tpspBO.delete(enti.getId());

        return SUCCESS;
    }

    /**
     * Detalle.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("tpsp-detail")
    public String detail() throws InstanceNotFoundException {
        Preconditions.checkNotNull(enti);
        Preconditions.checkNotNull(enti.getId());

        final TipoSubparametroBO tpspBO = new TipoSubparametroBO();

        enti = tpspBO.select(enti.getId(), getIdioma());
        i18nMap = I18nBO.selectMap(I18nPrefix.enti, enti.getId());

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
