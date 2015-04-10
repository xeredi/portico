package xeredi.integra.http.controller.action.metamodelo;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.ItemAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.bo.TipoEstadisticaBO;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoEstadisticaAction.
 */
public final class TipoEstadisticaAction extends ItemAction implements ModelDriven<TipoEstadisticaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3174617805403065108L;

    /** The tpes form. */
    private TipoEstadisticaVO model;

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
        Preconditions.checkNotNull(getAccion());

        if (getAccion() == ACCION_EDICION.edit) {
            Preconditions.checkNotNull(model);
            Preconditions.checkNotNull(model.getId());

            final TipoEstadisticaBO tpesBO = new TipoEstadisticaBO();

            model = tpesBO.select(model.getId(), getIdioma());
            i18nMap = I18nBO.selectMap(I18nPrefix.enti, model.getId());
        } else {
            model = new TipoEstadisticaVO();
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
        Preconditions.checkNotNull(getAccion());

        if (model == null) {
            model = new TipoEstadisticaVO();
        }

        // Validaciones
        if (getAccion() == ACCION_EDICION.create) {
            FieldValidator.validateRequired(this, MessageI18nKey.enti_codigo, model.getCodigo());
        } else {
            Preconditions.checkNotNull(model.getId());
        }

        FieldValidator.validateI18n(this, i18nMap);

        if (!hasErrors()) {
            final TipoEstadisticaBO tpesBO = new TipoEstadisticaBO();

            switch (getAccion()) {
            case create:
                model.setCodigo(model.getCodigo().toUpperCase());
                tpesBO.insert(model, i18nMap);

                break;
            case edit:
                tpesBO.update(model, i18nMap);

                break;
            default:
                throw new Error("Accion no soportada: " + getAccion());
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
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        final TipoEstadisticaBO tpesBO = new TipoEstadisticaBO();

        tpesBO.delete(model.getId());

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
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        final TipoEstadisticaBO tpesBO = new TipoEstadisticaBO();

        model = tpesBO.select(model.getId(), getIdioma());
        i18nMap = I18nBO.selectMap(I18nPrefix.enti, model.getId());

        return SUCCESS;
    }

    // get / set

    /**
     * {@inheritDoc}
     */
    @Override
    public TipoEstadisticaVO getModel() {
        return model;
    }

    /**
     * Sets the model.
     *
     * @param value
     *            the new model
     */
    public void setModel(final TipoEstadisticaVO value) {
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
