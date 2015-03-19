package xeredi.integra.http.controller.action.metamodelo;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.bo.TipoEstadisticaBO;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaVO;

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

    // Acciones Web
    /**
     * Modificar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("tpes-edit")
    public String modificar() throws ApplicationException {
        Preconditions.checkNotNull(accion);

        if (accion == ACCION_EDICION.edit) {
            Preconditions.checkNotNull(enti);
            Preconditions.checkNotNull(enti.getId());

            final TipoEstadisticaBO tpesBO = new TipoEstadisticaBO();

            enti = tpesBO.select(enti.getId(), getIdioma());
            i18nMap = I18nBO.selectMap(I18nPrefix.enti, enti.getId());
        } else {
            enti = new TipoEstadisticaVO();
        }

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("tpes-save")
    public String save() throws ApplicationException {
        Preconditions.checkNotNull(accion);

        if (enti == null) {
            enti = new TipoEstadisticaVO();
        }

        // Validaciones
        if (accion == ACCION_EDICION.create) {
            FieldValidator.validateRequired(this, MessageI18nKey.enti_codigo, enti.getCodigo());
        } else {
            Preconditions.checkNotNull(enti.getId());
        }

        FieldValidator.validateI18n(this, i18nMap);

        if (!hasErrors()) {
            final TipoEstadisticaBO tpesBO = new TipoEstadisticaBO();

            switch (accion) {
            case create:
                enti.setCodigo(enti.getCodigo().toUpperCase());
                tpesBO.insert(enti, i18nMap);

                break;
            case edit:
                tpesBO.update(enti, i18nMap);

                break;
            default:
                throw new Error("Accion no soportada: " + accion);
            }
        }

        return SUCCESS;
    }

    /**
     * Removes the.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("tpes-remove")
    public String remove() throws ApplicationException {
        Preconditions.checkNotNull(enti);
        Preconditions.checkNotNull(enti.getId());

        final TipoEstadisticaBO tpesBO = new TipoEstadisticaBO();

        tpesBO.delete(enti.getId());

        return SUCCESS;
    }

    /**
     * Detalle.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("tpes-detail")
    public String detail() throws ApplicationException {
        Preconditions.checkNotNull(enti);
        Preconditions.checkNotNull(enti.getId());

        final TipoEstadisticaBO tpesBO = new TipoEstadisticaBO();

        enti = tpesBO.select(enti.getId(), getIdioma());
        i18nMap = I18nBO.selectMap(I18nPrefix.enti, enti.getId());

        return SUCCESS;
    }

    // get / set
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
