package xeredi.integra.http.controller.action.metamodelo;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.bo.CampoAgregacionBO;
import xeredi.integra.model.metamodelo.vo.CampoAgregacionVO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class CampoAgregacionAction.
 */
public final class CampoAgregacionAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -155844770147053708L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The cmag. */
    private CampoAgregacionVO cmag;

    /** The entd list. */
    private List<EntidadTipoDatoVO> entdList;

    // Acciones web
    /**
     * Creates the.
     *
     * @return the string
     */
    @Action("cmag-create")
    public String create() {
        Preconditions.checkNotNull(cmag);
        Preconditions.checkNotNull(cmag.getTpesId());

        accion = ACCION_EDICION.create;

        return SUCCESS;
    }

    /**
     * Edits the.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("cmag-edit")
    public String edit() throws ApplicationException {
        Preconditions.checkNotNull(cmag);
        Preconditions.checkNotNull(cmag.getTpesId());
        Preconditions.checkNotNull(cmag.getEntd());
        Preconditions.checkNotNull(cmag.getEntd().getId());

        final CampoAgregacionBO cmagBO = new CampoAgregacionBO();

        cmag = cmagBO.select(cmag.getTpesId(), cmag.getEntd().getId(), getIdioma());
        accion = ACCION_EDICION.edit;

        return SUCCESS;
    }

    /**
     * Save.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("cmag-save")
    public String save() throws ApplicationException {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(cmag.getTpesId());

        // Validacion de datos
        if (accion == ACCION_EDICION.create) {
            FieldValidator.validateRequired(this, MessageI18nKey.cmag_entd, cmag.getEntd());

            if (!hasErrors()) {
                FieldValidator.validateRequired(this, MessageI18nKey.cmag_entd, cmag.getEntd().getId());
            }
        } else {
            Preconditions.checkNotNull(cmag.getEntd());
            Preconditions.checkNotNull(cmag.getEntd().getId());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.cmag_nombre, cmag.getNombre());
        FieldValidator.validateRequired(this, MessageI18nKey.cmag_agregar, cmag.getAgregar());

        if (!hasErrors()) {
            final CampoAgregacionBO cmagBO = new CampoAgregacionBO();

            switch (accion) {
            case create:
                cmagBO.insert(cmag);

                break;
            case edit:
                cmagBO.update(cmag);

                break;
            default:
                throw new Error("Accion " + accion + " no implementada");
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
    @Action("cmag-remove")
    public String remove() throws ApplicationException {
        Preconditions.checkNotNull(cmag);
        Preconditions.checkNotNull(cmag.getTpesId());
        Preconditions.checkNotNull(cmag.getEntd());
        Preconditions.checkNotNull(cmag.getEntd().getId());

        final CampoAgregacionBO cmagBO = new CampoAgregacionBO();

        cmagBO.delete(cmag);

        return SUCCESS;
    }

    /**
     * Detail.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("cmag-detail")
    public String detail() throws ApplicationException {
        Preconditions.checkNotNull(cmag);
        Preconditions.checkNotNull(cmag.getTpesId());
        Preconditions.checkNotNull(cmag.getEntd());
        Preconditions.checkNotNull(cmag.getEntd().getId());

        final CampoAgregacionBO cmagBO = new CampoAgregacionBO();

        cmag = cmagBO.select(cmag.getTpesId(), cmag.getEntd().getId(), getIdioma());

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
     * Gets the cmag.
     *
     * @return the cmag
     */
    public CampoAgregacionVO getCmag() {
        return cmag;
    }

    /**
     * Sets the cmag.
     *
     * @param value
     *            the new cmag
     */
    public void setCmag(final CampoAgregacionVO value) {
        cmag = value;
    }

    /**
     * Gets the entd list.
     *
     * @return the entd list
     */
    public List<EntidadTipoDatoVO> getEntdList() {
        return entdList;
    }

}
