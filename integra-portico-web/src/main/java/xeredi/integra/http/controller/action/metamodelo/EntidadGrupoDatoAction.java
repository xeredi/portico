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
import xeredi.integra.model.metamodelo.bo.EntidadGrupoDatoBO;
import xeredi.integra.model.metamodelo.vo.EntidadGrupoDatoVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadGrupoDatoAction.
 */
public final class EntidadGrupoDatoAction extends BaseAction implements ModelDriven<EntidadGrupoDatoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3556845527608258423L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The entd form. */
    private EntidadGrupoDatoVO model;

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
    @Action("engd-edit")
    public String edit() throws ApplicationException {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getEntiId());

        if (accion == ACCION_EDICION.edit) {
            Preconditions.checkNotNull(model.getId());

            final EntidadGrupoDatoBO engdBO = new EntidadGrupoDatoBO();

            model = engdBO.select(model.getId(), getIdioma());
            i18nMap = I18nBO.selectMap(I18nPrefix.engd, model.getId());
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
    @Action("engd-save")
    public String save() throws ApplicationException {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getEntiId());

        FieldValidator.validateRequired(this, MessageI18nKey.engd_numero, model.getNumero());
        FieldValidator.validateI18n(this, i18nMap);

        if (!hasErrors()) {
            final EntidadGrupoDatoBO engdBO = new EntidadGrupoDatoBO();

            switch (accion) {
            case create:
                engdBO.insert(model, i18nMap);

                break;
            case edit:
                engdBO.update(model, i18nMap);

                break;
            default:
                throw new Error("No implementado :" + accion);
            }
        }

        return SUCCESS;
    }

    /**
     * Detalle.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("engd-detail")
    public String detail() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        final EntidadGrupoDatoBO engdBO = new EntidadGrupoDatoBO();

        model = engdBO.select(model.getId(), getIdioma());
        i18nMap = I18nBO.selectMap(I18nPrefix.engd, model.getId());

        return SUCCESS;
    }

    /**
     * Removes the.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("engd-remove")
    public String remove() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        final EntidadGrupoDatoBO engdBO = new EntidadGrupoDatoBO();

        engdBO.delete(model.getId());

        return SUCCESS;
    }

    // get/set
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
     * {@inheritDoc}
     */
    @Override
    public EntidadGrupoDatoVO getModel() {
        return model;
    }

    /**
     * Sets the model.
     *
     * @param model
     *            the new model
     */
    public void setModel(final EntidadGrupoDatoVO value) {
        model = value;
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
