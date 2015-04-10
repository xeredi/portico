package xeredi.integra.http.controller.action.servicio;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.ItemAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.bo.PuertoBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.comun.vo.PuertoCriterioVO;
import xeredi.integra.model.comun.vo.PuertoVO;
import xeredi.integra.model.metamodelo.bo.TipoServicioBO;
import xeredi.integra.model.metamodelo.vo.TipoServicioCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoServicioVO;
import xeredi.integra.model.servicio.bo.ServicioSecuenciaBO;
import xeredi.integra.model.servicio.vo.ServicioSecuenciaCriterioVO;
import xeredi.integra.model.servicio.vo.ServicioSecuenciaVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioSecuenciaAction.
 */
public final class ServicioSecuenciaAction extends ItemAction implements ModelDriven<ServicioSecuenciaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2082170095218238933L;

    /** The srsc. */
    private ServicioSecuenciaVO model;

    /** The prto list. */
    private List<PuertoVO> prtoList;

    /** The tpsr list. */
    private List<TipoServicioVO> tpsrList;

    /**
     * Detail.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("srsc-detail")
    public String detail() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getPrto());
        Preconditions.checkNotNull(model.getPrto().getId());
        Preconditions.checkNotNull(model.getTpsr());
        Preconditions.checkNotNull(model.getTpsr().getId());
        Preconditions.checkNotNull(model.getAnno());

        final ServicioSecuenciaBO srscBO = new ServicioSecuenciaBO();
        final ServicioSecuenciaCriterioVO srscCriterio = new ServicioSecuenciaCriterioVO();

        srscCriterio.setPrtoId(model.getPrto().getId());
        srscCriterio.setTpsrId(model.getTpsr().getId());
        srscCriterio.setAnno(model.getAnno());
        srscCriterio.setIdioma(getIdioma());

        model = srscBO.select(srscCriterio);

        return SUCCESS;
    }

    /**
     * Edits the.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("srsc-edit")
    public String edit() throws ApplicationException {
        Preconditions.checkNotNull(getAccion());

        if (getAccion() == ACCION_EDICION.create) {
            final PuertoBO prtoBO = new PuertoBO();
            final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

            prtoCriterio.setIdioma(getIdioma());
            prtoCriterio.setSprtId(getSprtId());

            prtoList = prtoBO.selectList(prtoCriterio);

            final TipoServicioBO tpsrBO = new TipoServicioBO();
            final TipoServicioCriterioVO tpsrCriterio = new TipoServicioCriterioVO();

            tpsrCriterio.setIdioma(getIdioma());

            tpsrList = tpsrBO.selectList(tpsrCriterio);
        } else {
            Preconditions.checkNotNull(model);
            Preconditions.checkNotNull(model.getPrto());
            Preconditions.checkNotNull(model.getPrto().getId());
            Preconditions.checkNotNull(model.getTpsr());
            Preconditions.checkNotNull(model.getTpsr().getId());
            Preconditions.checkNotNull(model.getAnno());

            final ServicioSecuenciaBO srscBO = new ServicioSecuenciaBO();
            final ServicioSecuenciaCriterioVO srscCriterio = new ServicioSecuenciaCriterioVO();

            srscCriterio.setPrtoId(model.getPrto().getId());
            srscCriterio.setTpsrId(model.getTpsr().getId());
            srscCriterio.setAnno(model.getAnno());
            srscCriterio.setIdioma(getIdioma());

            model = srscBO.select(srscCriterio);
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
    @Action("srsc-save")
    public String save() throws ApplicationException {
        Preconditions.checkNotNull(getAccion());

        if (model == null) {
            model = new ServicioSecuenciaVO();
        }

        if (getAccion() == ACCION_EDICION.create) {
            FieldValidator.validateRequired(this, MessageI18nKey.tpsr, model.getTpsr());
            FieldValidator.validateRequired(this, MessageI18nKey.prto, model.getPrto());
            FieldValidator.validateRequired(this, MessageI18nKey.srsc_anno, model.getAnno());

            if (!hasErrors()) {
                FieldValidator.validateRequired(this, MessageI18nKey.tpsr, model.getTpsr().getId());
                FieldValidator.validateRequired(this, MessageI18nKey.prto, model.getPrto().getId());
            }
        } else {
            Preconditions.checkNotNull(model);
            Preconditions.checkNotNull(model.getPrto());
            Preconditions.checkNotNull(model.getPrto().getId());
            Preconditions.checkNotNull(model.getTpsr());
            Preconditions.checkNotNull(model.getTpsr().getId());
            Preconditions.checkNotNull(model.getAnno());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.srsc_ultimo_numero, model.getUltimoNumero());

        if (!hasErrors()) {
            final ServicioSecuenciaBO srscBO = new ServicioSecuenciaBO();

            switch (getAccion()) {
            case create:
                srscBO.insert(model);

                break;
            case edit:
                srscBO.update(model);

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
    @Action("srsc-remove")
    public String remove() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getPrto());
        Preconditions.checkNotNull(model.getPrto().getId());
        Preconditions.checkNotNull(model.getTpsr());
        Preconditions.checkNotNull(model.getTpsr().getId());
        Preconditions.checkNotNull(model.getAnno());

        final ServicioSecuenciaBO srscBO = new ServicioSecuenciaBO();

        srscBO.delete(model);

        return SUCCESS;
    }

    // get / set

    /**
     * {@inheritDoc}
     */
    @Override
    public ServicioSecuenciaVO getModel() {
        return model;
    }

    /**
     * Sets the model.
     *
     * @param value
     *            the new model
     */
    public void setModel(final ServicioSecuenciaVO value) {
        model = value;
    }

    /**
     * Gets the prto list.
     *
     * @return the prto list
     */
    public List<PuertoVO> getPrtoList() {
        return prtoList;
    }

    /**
     * Gets the tpsr list.
     *
     * @return the tpsr list
     */
    public List<TipoServicioVO> getTpsrList() {
        return tpsrList;
    }

}
