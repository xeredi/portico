package xeredi.integra.http.controller.action.metamodelo;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.bo.CodigoReferenciaBO;
import xeredi.integra.model.metamodelo.vo.CodigoReferenciaVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class CodigoReferenciaAction.
 */
public final class CodigoReferenciaAction extends BaseAction implements ModelDriven<CodigoReferenciaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4021150215007821288L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The cdrf form. */
    private CodigoReferenciaVO model;

    /** The cdri map. */
    private Map<String, I18nVO> i18nMap;

    // Acciones Web
    /**
     * Editar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("cdrf-edit")
    public String edit() throws ApplicationException {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getTpdtId());

        if (accion == ACCION_EDICION.edit) {
            Preconditions.checkNotNull(model.getId());

            final CodigoReferenciaBO cdrfBO = new CodigoReferenciaBO();

            model = cdrfBO.select(model.getId(), getIdioma());
            i18nMap = I18nBO.selectMap(I18nPrefix.cdrf, model.getId());
        } else {
            i18nMap = new HashMap<>();
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
    @Action("cdrf-save")
    public String save() throws ApplicationException {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getTpdtId());
        Preconditions.checkNotNull(i18nMap);

        // Validacion de datos
        if (accion == ACCION_EDICION.create) {
            FieldValidator.validateRequired(this, MessageI18nKey.cdrf_valor, model.getValor());
        } else {
            Preconditions.checkNotNull(model.getId());
            Preconditions.checkNotNull(model.getValor());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.cdrf_orden, model.getOrden());
        FieldValidator.validateI18n(this, i18nMap);

        if (!hasErrors()) {
            final CodigoReferenciaBO cdrfBO = new CodigoReferenciaBO();

            switch (accion) {
            case create:
                cdrfBO.insert(model, i18nMap);

                break;
            case edit:
                cdrfBO.update(model, i18nMap);

                break;
            default:
                throw new Error("Accion " + accion + " no implementada");
            }
        }

        return SUCCESS;
    }

    /**
     * Eliminar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("cdrf-remove")
    public String remove() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        final CodigoReferenciaBO cdrfBO = new CodigoReferenciaBO();

        cdrfBO.delete(model);

        return SUCCESS;
    }

    /**
     * Detalle.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("cdrf-detail")
    public String detail() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        final CodigoReferenciaBO cdrfBO = new CodigoReferenciaBO();

        model = cdrfBO.select(model.getId(), getIdioma());
        i18nMap = I18nBO.selectMap(I18nPrefix.cdrf, model.getId());

        return SUCCESS;
    }

    // get / set

    /**
     * {@inheritDoc}
     */
    @Override
    public CodigoReferenciaVO getModel() {
        return model;
    }

    /**
     * Sets the model.
     *
     * @param model
     *            the new model
     */
    public void setModel(final CodigoReferenciaVO value) {
        model = value;
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
