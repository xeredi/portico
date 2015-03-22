package xeredi.integra.http.controller.action.facturacion;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.facturacion.bo.AspectoBO;
import xeredi.integra.model.facturacion.bo.ValoracionBO;
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

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionAction.
 */
public final class ValoracionAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4129919965585365201L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The vlrc. */
    private ValoracionVO vlrc;

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
        Preconditions.checkNotNull(vlrc);
        Preconditions.checkNotNull(vlrc.getId());

        final AspectoBO aspcBO = new AspectoBO();
        final ValoracionBO vlrcBO = new ValoracionBO();

        vlrc = vlrcBO.select(vlrc.getId(), getIdioma());
        vlriList = vlrcBO.selectVlriList(vlrc.getId(), getIdioma());
        vlrgList = vlrcBO.selectVlrgList(vlrc.getId(), getIdioma());
        aspc = aspcBO.select(vlrc.getAspc().getId(), vlrc.getFref(), getIdioma());
        tpdtCodExencion = TipoDatoProxy.select(TipoDato.COD_EXEN.getId());

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
        Preconditions.checkNotNull(accion);

        if (accion == ACCION_EDICION.edit) {
            Preconditions.checkNotNull(vlrc);
            Preconditions.checkNotNull(vlrc.getId());

            final ValoracionBO vlrcBO = new ValoracionBO();
            final ValoracionCriterioVO vlrcCriterio = new ValoracionCriterioVO();

            vlrcCriterio.setId(vlrc.getId());
            vlrcCriterio.setIdioma(getIdioma());

            vlrc = vlrcBO.select(vlrc.getId(), getIdioma());
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
     */
    @Action("vlrc-save")
    public String save() throws ApplicationException {
        Preconditions.checkNotNull(accion);

        if (vlrc == null) {
            vlrc = new ValoracionVO();
        }

        if (accion == ACCION_EDICION.edit) {
            Preconditions.checkNotNull(vlrc.getId());
        }

        if (accion == ACCION_EDICION.create) {
            FieldValidator.validateRequired(this, MessageI18nKey.vlrc_srvc, vlrc.getSrvc());
            FieldValidator.validateRequired(this, MessageI18nKey.vlrc_aspc, vlrc.getAspc());
            FieldValidator.validateRequired(this, MessageI18nKey.vlrc_fliq, vlrc.getFliq());
            FieldValidator.validateRequired(this, MessageI18nKey.vlrc_fref, vlrc.getFref());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.vlrc_pagador, vlrc.getPagador());
        FieldValidator.validateRequired(this, MessageI18nKey.vlrc_sujPasivo, vlrc.getSujPasivo());
        FieldValidator.validateRequired(this, MessageI18nKey.vlrc_codExencion, vlrc.getCodExencion());

        if (!hasErrors()) {
            final ValoracionBO vlrcBO = new ValoracionBO();

            switch (accion) {
            case create:
                vlrcBO.insert(vlrc);

                break;
            case edit:
                vlrcBO.update(vlrc);

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
        Preconditions.checkNotNull(vlrc);
        Preconditions.checkNotNull(vlrc.getId());

        final ValoracionBO vlrcBO = new ValoracionBO();

        vlrcBO.delete(vlrc.getId());

        return SUCCESS;
    }

    // get / set

    /**
     * Gets the vlrc.
     *
     * @return the vlrc
     */
    public ValoracionVO getVlrc() {
        return vlrc;
    }

    /**
     * Sets the vlrc.
     *
     * @param value
     *            the vlrc
     */
    public void setVlrc(final ValoracionVO value) {
        vlrc = value;
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
     * Sets the accion.
     *
     * @param value
     *            the new accion
     */
    public void setAccion(final ACCION_EDICION value) {
        accion = value;
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
     * Gets the aspc.
     *
     * @return the aspc
     */
    public AspectoVO getAspc() {
        return aspc;
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
}
