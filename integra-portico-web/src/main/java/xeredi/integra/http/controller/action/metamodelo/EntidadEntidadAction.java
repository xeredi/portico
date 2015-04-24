package xeredi.integra.http.controller.action.metamodelo;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.ItemAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.bo.EntidadBO;
import xeredi.integra.model.metamodelo.bo.EntidadEntidadBO;
import xeredi.integra.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadEntidadCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadEntidadVO;
import xeredi.integra.model.metamodelo.vo.TipoEntidad;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadEntidadAction.
 */
public final class EntidadEntidadAction extends ItemAction implements ModelDriven<EntidadEntidadVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7902127201717597996L;

    /** The enen. */
    private EntidadEntidadVO model;

    /** The tppr list. */
    private List<LabelValueVO> tpssList;

    /**
     * Modificar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("enen-edit")
    public String edit() throws ApplicationException {
        Preconditions.checkNotNull(getAccion());
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getEntiPadreId());

        if (getAccion() == ACCION_EDICION.edit) {
            Preconditions.checkNotNull(model.getEntiHija());
            Preconditions.checkNotNull(model.getEntiHija().getId());

            final EntidadEntidadBO enenBO = new EntidadEntidadBO();
            final EntidadEntidadCriterioVO enenCriterioVO = new EntidadEntidadCriterioVO();

            enenCriterioVO.setEntiPadreId(model.getEntiPadreId());
            enenCriterioVO.setEntiHijaId(model.getEntiHija().getId());

            model = enenBO.selectObject(enenCriterioVO);
        }

        loadLabelValues();

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("enen-save")
    public String save() throws ApplicationException {
        Preconditions.checkNotNull(getAccion());
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getEntiPadreId());

        if (getAccion() == ACCION_EDICION.create) {
            FieldValidator.validateRequired(this, MessageI18nKey.enen_entiHija, model.getEntiHija());
        } else {
            Preconditions.checkNotNull(model.getEntiHija());
            Preconditions.checkNotNull(model.getEntiHija().getId());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.enen_orden, model.getOrden());

        if (!hasErrors()) {
            final EntidadEntidadBO enenBO = new EntidadEntidadBO();

            if (getAccion() == ACCION_EDICION.create) {
                enenBO.insert(model);
            } else {
                enenBO.update(model);
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
    @Action("enen-remove")
    public String remove() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getEntiPadreId());
        Preconditions.checkNotNull(model.getEntiHija());
        Preconditions.checkNotNull(model.getEntiHija().getId());

        final EntidadEntidadBO enenBO = new EntidadEntidadBO();

        enenBO.delete(model);

        return SUCCESS;
    }

    /**
     * Detail.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("enen-detail")
    public String detail() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getEntiPadreId());
        Preconditions.checkNotNull(model.getEntiHija());
        Preconditions.checkNotNull(model.getEntiHija().getId());

        final EntidadEntidadBO enenBO = new EntidadEntidadBO();
        final EntidadEntidadCriterioVO enenCriterioVO = new EntidadEntidadCriterioVO();

        enenCriterioVO.setEntiPadreId(model.getEntiPadreId());
        enenCriterioVO.setEntiHijaId(model.getEntiHija().getId());

        model = enenBO.selectObject(enenCriterioVO);

        return SUCCESS;
    }

    /**
     * Load label values.
     */
    private void loadLabelValues() {
        final EntidadBO entiBO = new EntidadBO();
        final EntidadCriterioVO entiCriterioVO = new EntidadCriterioVO();

        entiCriterioVO.setTipo(TipoEntidad.S);
        entiCriterioVO.setIdioma(getIdioma());

        tpssList = entiBO.selectLabelValues(entiCriterioVO);
    }

    // get / set

    /**
     * Gets the tpss list.
     *
     * @return the tpss list
     */
    public List<LabelValueVO> getTpssList() {
        return tpssList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntidadEntidadVO getModel() {
        return model;
    }

    /**
     * Sets the model.
     *
     * @param value
     *            the new model
     */
    public void setModel(final EntidadEntidadVO value) {
        model = value;
    }
}
