package xeredi.integra.http.controller.action.metamodelo;

import java.util.HashMap;
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
import xeredi.integra.model.metamodelo.bo.CodigoReferenciaBO;
import xeredi.integra.model.metamodelo.vo.CodigoReferenciaVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class CodigoReferenciaAction.
 */
public final class CodigoReferenciaAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4021150215007821288L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The cdrf form. */
    private CodigoReferenciaVO cdrf;

    /** The cdri map. */
    private Map<String, I18nVO> i18nMap;

    // Acciones Web
    /**
     * Alta.
     *
     * @return the string
     */
    @Action("cdrf-create")
    public String create() {
        Preconditions.checkNotNull(cdrf);
        Preconditions.checkNotNull(cdrf.getTpdtId());

        i18nMap = new HashMap<>();
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
    @Action("cdrf-edit")
    public String edit() throws InstanceNotFoundException {
        Preconditions.checkNotNull(cdrf);
        Preconditions.checkNotNull(cdrf.getId());

        final CodigoReferenciaBO cdrfBO = new CodigoReferenciaBO();

        cdrf = cdrfBO.select(cdrf.getId(), getIdioma());
        i18nMap = I18nBO.selectMap(I18nPrefix.cdrf, cdrf.getId());
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
    @Action("cdrf-save")
    public String save() throws InstanceNotFoundException, DuplicateInstanceException {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(cdrf);
        Preconditions.checkNotNull(cdrf.getTpdtId());
        Preconditions.checkNotNull(i18nMap);

        // Validacion de datos
        if (accion == ACCION_EDICION.create) {
            FieldValidator.validateRequired(this, MessageI18nKey.cdrf_valor, cdrf.getValor());
        } else {
            Preconditions.checkNotNull(cdrf.getId());
            Preconditions.checkNotNull(cdrf.getValor());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.cdrf_orden, cdrf.getOrden());
        FieldValidator.validateI18n(this, i18nMap);

        if (!hasErrors()) {
            final CodigoReferenciaBO cdrfBO = new CodigoReferenciaBO();

            switch (accion) {
            case create:
                cdrfBO.insert(cdrf, i18nMap);

                break;
            case edit:
                cdrfBO.update(cdrf, i18nMap);

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
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("cdrf-remove")
    public String remove() throws InstanceNotFoundException {
        Preconditions.checkNotNull(cdrf);
        Preconditions.checkNotNull(cdrf.getId());

        final CodigoReferenciaBO cdrfBO = new CodigoReferenciaBO();

        cdrfBO.delete(cdrf);

        return SUCCESS;
    }

    /**
     * Detalle.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("cdrf-detail")
    public String detail() throws InstanceNotFoundException {
        Preconditions.checkNotNull(cdrf);
        Preconditions.checkNotNull(cdrf.getId());

        final CodigoReferenciaBO cdrfBO = new CodigoReferenciaBO();

        cdrf = cdrfBO.select(cdrf.getId(), getIdioma());
        i18nMap = I18nBO.selectMap(I18nPrefix.cdrf, cdrf.getId());

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
     * Gets the cdrf.
     *
     * @return the cdrf
     */
    public CodigoReferenciaVO getCdrf() {
        return cdrf;
    }

    /**
     * Sets the cdrf.
     *
     * @param value
     *            the new cdrf
     */
    public void setCdrf(final CodigoReferenciaVO value) {
        cdrf = value;
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
