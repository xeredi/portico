package xeredi.integra.http.controller.action.facturacion;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.ItemAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.facturacion.bo.AspectoBO;
import xeredi.integra.model.facturacion.bo.ValoracionBO;
import xeredi.integra.model.facturacion.vo.AspectoCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoVO;
import xeredi.integra.model.facturacion.vo.ValoracionCargoVO;
import xeredi.integra.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionImpuestoVO;
import xeredi.integra.model.facturacion.vo.ValoracionVO;
import xeredi.integra.model.metamodelo.proxy.TipoDatoProxy;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.metamodelo.vo.TipoDato;
import xeredi.integra.model.metamodelo.vo.TipoDatoVO;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionAction.
 */
public final class ValoracionAction extends ItemAction implements ModelDriven<ValoracionVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4129919965585365201L;

    /** The vlrc. */
    private ValoracionVO model;

    /** The aspc. */
    private AspectoVO aspc;

    /** The vlrg list. */
    private List<ValoracionCargoVO> vlrgList;

    /** The vlri list. */
    private List<ValoracionImpuestoVO> vlriList;

    /** The tpsr list. */
    private List<LabelValueVO> tpsrList;

    /** The pagador enti id. */
    private Long pagadorEntiId;

    /** The tpdt cod exencion. */
    private TipoDatoVO tpdtCodExencion;

    // acciones web

    /**
     * Listado.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("vlrc-detail")
    public String detalle() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        final ValoracionBO vlrcBO = new ValoracionBO();

        model = vlrcBO.select(model.getId(), getIdioma());
        vlriList = vlrcBO.selectVlriList(model.getId(), getIdioma());
        vlrgList = vlrcBO.selectVlrgList(model.getId(), getIdioma());
        tpdtCodExencion = TipoDatoProxy.select(TipoDato.COD_EXEN.getId());

        final AspectoBO aspcBO = new AspectoBO();
        final AspectoCriterioVO aspcCriterio = new AspectoCriterioVO();

        aspcCriterio.setId(model.getAspc().getId());
        aspcCriterio.setFechaVigencia(model.getFref());

        aspc = aspcBO.selectObject(aspcCriterio);

        return SUCCESS;
    }

    /**
     * Edits the.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("vlrc-edit")
    public String edit() throws ApplicationException {
        Preconditions.checkNotNull(getAccion());

        if (getAccion() == ACCION_EDICION.edit) {
            Preconditions.checkNotNull(model);
            Preconditions.checkNotNull(model.getId());

            final ValoracionBO vlrcBO = new ValoracionBO();
            final ValoracionCriterioVO vlrcCriterio = new ValoracionCriterioVO();

            vlrcCriterio.setId(model.getId());
            vlrcCriterio.setIdioma(getIdioma());

            model = vlrcBO.select(model.getId(), getIdioma());
        } else {
            tpsrList = TipoServicioProxy.selectLabelValues();
        }

        pagadorEntiId = Entidad.ORGANIZACION.getId();
        tpdtCodExencion = TipoDatoProxy.select(TipoDato.COD_EXEN.getId());

        return SUCCESS;
    }

    /**
     * Save.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("vlrc-save")
    public String save() throws ApplicationException {
        Preconditions.checkNotNull(getAccion());

        if (model == null) {
            model = new ValoracionVO();
        }

        if (getAccion() == ACCION_EDICION.edit) {
            Preconditions.checkNotNull(model.getId());
        }

        if (getAccion() == ACCION_EDICION.create) {
            FieldValidator.validateRequired(this, MessageI18nKey.vlrc_srvc, model.getSrvc());
            FieldValidator.validateRequired(this, MessageI18nKey.vlrc_aspc, model.getAspc());
            FieldValidator.validateRequired(this, MessageI18nKey.vlrc_fliq, model.getFliq());
            FieldValidator.validateRequired(this, MessageI18nKey.vlrc_fref, model.getFref());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.vlrc_pagador, model.getPagador());
        FieldValidator.validateRequired(this, MessageI18nKey.vlrc_sujPasivo, model.getSujPasivo());
        FieldValidator.validateRequired(this, MessageI18nKey.vlrc_codExencion, model.getCodExencion());

        if (!hasErrors()) {
            final ValoracionBO vlrcBO = new ValoracionBO();

            switch (getAccion()) {
            case create:
                vlrcBO.insert(model);

                break;
            case edit:
                vlrcBO.update(model);

                break;
            default:
                throw new Error("No implementado");
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
    @Action("vlrc-remove")
    public String remove() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        final ValoracionBO vlrcBO = new ValoracionBO();

        vlrcBO.delete(model.getId());

        return SUCCESS;
    }

    // get / set

    /**
     * Gets the vlrc.
     *
     * @return the vlrc
     */
    @Override
    public ValoracionVO getModel() {
        return model;
    }

    /**
     * Sets the vlrc.
     *
     * @param value
     *            the vlrc
     */
    public void setModel(final ValoracionVO value) {
        model = value;
    }

    /**
     * Gets the vlrg list.
     *
     * @return the vlrg list
     */
    public List<ValoracionCargoVO> getVlrgList() {
        return vlrgList;
    }

    /**
     * Gets the vlri list.
     *
     * @return the vlri list
     */
    public List<ValoracionImpuestoVO> getVlriList() {
        return vlriList;
    }

    /**
     * Gets the tpsr list.
     *
     * @return the tpsr list
     */
    public List<LabelValueVO> getTpsrList() {
        return tpsrList;
    }

    /**
     * Gets the pagador enti id.
     *
     * @return the pagador enti id
     */
    public Long getPagadorEntiId() {
        return pagadorEntiId;
    }

    /**
     * Gets the tpdt cod exencion.
     *
     * @return the tpdt cod exencion
     */
    public TipoDatoVO getTpdtCodExencion() {
        return tpdtCodExencion;
    }

    /**
     * Gets the aspc.
     *
     * @return the aspc
     */
    public AspectoVO getAspc() {
        return aspc;
    }
}
