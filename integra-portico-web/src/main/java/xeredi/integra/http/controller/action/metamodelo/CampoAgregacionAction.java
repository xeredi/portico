package xeredi.integra.http.controller.action.metamodelo;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.ItemAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.bo.CampoAgregacionBO;
import xeredi.integra.model.metamodelo.vo.CampoAgregacionVO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class CampoAgregacionAction.
 */
public final class CampoAgregacionAction extends ItemAction implements ModelDriven<CampoAgregacionVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -155844770147053708L;

    /** The model. */
    private CampoAgregacionVO model;

    /** The entd list. */
    private List<EntidadTipoDatoVO> entdList;

    // Acciones web
    /**
     * Edits the.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("cmag-edit")
    public String edit() throws ApplicationException {
        Preconditions.checkNotNull(getAccion());
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getTpesId());

        if (getAccion() == ACCION_EDICION.edit) {
            Preconditions.checkNotNull(model.getEntd());
            Preconditions.checkNotNull(model.getEntd().getId());

            final CampoAgregacionBO cmagBO = new CampoAgregacionBO();

            model = cmagBO.select(model.getTpesId(), model.getEntd().getId(), getIdioma());
        }

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
        Preconditions.checkNotNull(getAccion());
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getTpesId());

        // Validacion de datos
        if (getAccion() == ACCION_EDICION.create) {
            FieldValidator.validateRequired(this, MessageI18nKey.cmag_entd, model.getEntd());

            if (!hasErrors()) {
                FieldValidator.validateRequired(this, MessageI18nKey.cmag_entd, model.getEntd().getId());
            }
        } else {
            Preconditions.checkNotNull(model.getEntd());
            Preconditions.checkNotNull(model.getEntd().getId());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.cmag_nombre, model.getNombre());
        FieldValidator.validateRequired(this, MessageI18nKey.cmag_agregar, model.getAgregar());

        if (!hasErrors()) {
            final CampoAgregacionBO cmagBO = new CampoAgregacionBO();

            switch (getAccion()) {
            case create:
                cmagBO.insert(model);

                break;
            case edit:
                cmagBO.update(model);

                break;
            default:
                throw new Error("Accion " + getAccion() + " no implementada");
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
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getTpesId());
        Preconditions.checkNotNull(model.getEntd());
        Preconditions.checkNotNull(model.getEntd().getId());

        final CampoAgregacionBO cmagBO = new CampoAgregacionBO();

        cmagBO.delete(model);

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
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getTpesId());
        Preconditions.checkNotNull(model.getEntd());
        Preconditions.checkNotNull(model.getEntd().getId());

        final CampoAgregacionBO cmagBO = new CampoAgregacionBO();

        model = cmagBO.select(model.getTpesId(), model.getEntd().getId(), getIdioma());

        return SUCCESS;
    }

    // get / set

    /**
     * {@inheritDoc}
     */
    @Override
    public CampoAgregacionVO getModel() {
        return model;
    }

    /**
     * Sets the model.
     *
     * @param model
     *            the new model
     */
    public void setModel(final CampoAgregacionVO model) {
        this.model = model;
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
