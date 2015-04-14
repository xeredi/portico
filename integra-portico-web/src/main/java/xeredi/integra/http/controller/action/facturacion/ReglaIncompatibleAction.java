package xeredi.integra.http.controller.action.facturacion;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.ItemAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.facturacion.bo.ReglaBO;
import xeredi.integra.model.facturacion.bo.ReglaIncompatibleBO;
import xeredi.integra.model.facturacion.vo.ReglaCriterioVO;
import xeredi.integra.model.facturacion.vo.ReglaIncompatibleCriterioVO;
import xeredi.integra.model.facturacion.vo.ReglaIncompatibleVO;
import xeredi.integra.model.facturacion.vo.ReglaIncompatibleVersionVO;
import xeredi.integra.model.facturacion.vo.ReglaVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaIncompatibleAction.
 */
public final class ReglaIncompatibleAction extends ItemAction implements ModelDriven<ReglaIncompatibleVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8806246091503780542L;

    /** The crgo. */
    private ReglaIncompatibleVO model;

    /** The rgla2 list. */
    private List<ReglaVO> rgla2List = new ArrayList<>();

    // acciones web

    /**
     * Detail.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("rgin-detail")
    public String detail() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());
        Preconditions.checkNotNull(getFechaVigencia());

        final ReglaIncompatibleBO rginBO = new ReglaIncompatibleBO();
        final ReglaIncompatibleCriterioVO rginCriterio = new ReglaIncompatibleCriterioVO();

        rginCriterio.setId(model.getId());
        rginCriterio.setFechaVigencia(getFechaVigencia());

        model = rginBO.selectObject(rginCriterio);

        return SUCCESS;
    }

    /**
     * Edits the.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("rgin-edit")
    public String edit() throws ApplicationException {
        Preconditions.checkNotNull(getAccion());
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getRgla1Id());
        Preconditions.checkNotNull(getFechaVigencia());

        if (getAccion() == ACCION_EDICION.edit) {
            Preconditions.checkNotNull(model.getId());

            final ReglaIncompatibleBO rginBO = new ReglaIncompatibleBO();
            final ReglaIncompatibleCriterioVO rginCriterio = new ReglaIncompatibleCriterioVO();

            rginCriterio.setId(model.getId());
            rginCriterio.setFechaVigencia(getFechaVigencia());
            rginCriterio.setIdioma(getIdioma());

            model = rginBO.selectObject(rginCriterio);
        } else {
            model.setRgiv(new ReglaIncompatibleVersionVO());
            model.getRgiv().setFini(getFechaVigencia());

            {
                final ReglaBO rglaBO = new ReglaBO();
                final ReglaCriterioVO rgla1Criterio = new ReglaCriterioVO();

                rgla1Criterio.setId(model.getRgla1Id());
                rgla1Criterio.setFechaVigencia(getFechaVigencia());

                final ReglaVO rgla = rglaBO.selectObject(rgla1Criterio);

                final ReglaCriterioVO rgla2Criterio = new ReglaCriterioVO();

                rgla2Criterio.setCrgoId(rgla.getCrgo().getId());
                rgla2Criterio.setFechaVigencia(getFechaVigencia());

                rgla2List = rglaBO.selectList(rgla2Criterio);
            }
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
    @Action("rgin-save")
    public String save() throws ApplicationException {
        Preconditions.checkNotNull(getAccion());
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getRgiv());
        Preconditions.checkNotNull(model.getRgla1Id());

        if (getAccion() == ACCION_EDICION.create) {
            FieldValidator.validateRequired(this, MessageI18nKey.rgin_rgla2, model.getRgla2());
        } else {
            Preconditions.checkNotNull(model.getId());
            Preconditions.checkNotNull(model.getRgiv().getId());
            Preconditions.checkNotNull(model.getRgla2());
            Preconditions.checkNotNull(model.getRgla2().getId());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.rgin_fini, model.getRgiv().getFini());

        if (!hasErrors()) {
            final ReglaIncompatibleBO rginBO = new ReglaIncompatibleBO();

            switch (getAccion()) {
            case create:
                rginBO.insert(model);

                break;
            case edit:
                rginBO.update(model);

                break;

            default:
                throw new Error("Accion no valida: " + getAccion());
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
    @Action("rgin-remove")
    public String remove() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getRgiv().getId());

        final ReglaIncompatibleBO rginBO = new ReglaIncompatibleBO();

        rginBO.delete(model);

        return SUCCESS;
    }

    // get / set
    /**
     * {@inheritDoc}
     */
    @Override
    public ReglaIncompatibleVO getModel() {
        return model;
    }

    /**
     * Sets the rgin.
     *
     * @param value
     *            the new rgin
     */
    public void setModel(final ReglaIncompatibleVO value) {
        model = value;
    }

    /**
     * Gets the rgla2 list.
     *
     * @return the rgla2 list
     */
    public List<ReglaVO> getRgla2List() {
        return rgla2List;
    }
}
