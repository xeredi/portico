package xeredi.integra.http.controller.action.servicio.escala;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.comun.ItemAction;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.exception.OperacionNoPermitidaException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.integra.model.servicio.bo.ServicioBO;
import xeredi.integra.model.servicio.bo.SubservicioBO;
import xeredi.integra.model.servicio.bo.escala.AtraqueBO;
import xeredi.integra.model.servicio.vo.SubservicioVO;
import xeredi.integra.model.util.Entidad;
import xeredi.integra.model.util.TipoDato;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class AtraqueAction.
 */
public final class AtraqueAction extends ItemAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6685825766813769667L;

    /** The item. */
    private SubservicioVO item;

    /** The fecha vigencia. */
    private Date fechaVigencia;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    // Acciones Web

    /**
     * Autorizar.
     *
     * @return the string
     */
    @Action(value = "atra-autorizar-popup", results = {
            @Result(name = "success", location = "escala/atra-autorizar.jsp"),
            @Result(name = "error", location = "/WEB-INF/content/comun/item-action-result.jsp") })
    public String autorizar() {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        try {
            final SubservicioBO ssrvBO = new SubservicioBO();
            final ServicioBO srvcBO = new ServicioBO();
            final AtraqueBO atraBO = new AtraqueBO();

            item = ssrvBO.select(item.getId(), getIdioma());

            if (!atraBO.isAutorizable(item.getId())) {
                addActionError(MessageI18nKey.E00011, item.getEstado());

                return ERROR;
            }

            // Copiar los datos de solicitud a autorizacion
            item.getItdtMap().put(TipoDato.DECIMAL_07.getId(), item.getItdtMap().get(TipoDato.DECIMAL_01.getId()));
            item.getItdtMap().put(TipoDato.DECIMAL_08.getId(), item.getItdtMap().get(TipoDato.DECIMAL_02.getId()));
            item.getItdtMap().put(TipoDato.ALIN_2.getId(), item.getItdtMap().get(TipoDato.ALIN.getId()));
            item.getItdtMap()
                    .put(TipoDato.TIPO_ATR_EDI_2.getId(), item.getItdtMap().get(TipoDato.TIPO_ATR_EDI.getId()));
            item.getItdtMap().put(TipoDato.TIPO_ESTAN_ATR_2.getId(),
                    item.getItdtMap().get(TipoDato.TIPO_ESTAN_ATR.getId()));
            item.getItdtMap().put(TipoDato.DECIMAL_09.getId(), item.getItdtMap().get(TipoDato.DECIMAL_03.getId()));
            item.getItdtMap().put(TipoDato.DECIMAL_10.getId(), item.getItdtMap().get(TipoDato.DECIMAL_04.getId()));
            item.getItdtMap().put(TipoDato.TIPO_ACT_2.getId(), item.getItdtMap().get(TipoDato.TIPO_ACT.getId()));
            item.getItdtMap().put(TipoDato.TEXTO_02.getId(), item.getItdtMap().get(TipoDato.TEXTO_01.getId()));
            item.getItdtMap().get(TipoDato.FECHA_01.getId()).setFecha(Calendar.getInstance().getTime());

            item.setSrvc(srvcBO.select(item.getSrvc().getId(), getIdioma()));
        } catch (final InstanceNotFoundException ex) {
            addActionError(MessageI18nKey.E00008, getText(ex.getClassName()), ex.getObjId());
        }

        return SUCCESS;
    }

    /**
     * Autorizar guardar.
     *
     * @return the string
     */
    @Action(value = "atra-autorizar-guardar", results = { @Result(name = "success", type = "redirectAction", params = {
            "actionName", "ssrv-detalle", "item.id", "%{item.id}" }) })
    public String autorizarGuardar() {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());
        Preconditions.checkNotNull(item.getItdtMap());

        final TipoSubservicioVO tpssVO = TipoSubservicioProxy.select(Entidad.ATRAQUE.getId());

        item.setEntiId(tpssVO.getId());

        if (item.getItdtMap().get(TipoDato.FECHA_01.getId()).getFecha().getTime() < item.getItdtMap()
                .get(TipoDato.FECHA_02.getId()).getFecha().getTime()) {
            throw new Error("Fecha de Autorizacion ha de ser posterior a fecha de solicitud");
        }

        final AtraqueBO atraBO = new AtraqueBO();

        try {
            atraBO.autorizar(item.getId(), item.getItdtMap());
        } catch (final InstanceNotFoundException ex) {
            addActionError(MessageI18nKey.E00008, getText(ex.getClassName()), ex.getObjId());
        } catch (final OperacionNoPermitidaException ex) {
            addActionError(MessageI18nKey.E00013, getText(ex.getClassName()), ex.getObjId());
        }

        return SUCCESS;
    }

    /**
     * Denegar.
     *
     * @return the string
     */
    @Action(value = "atra-denegar-popup", results = { @Result(name = "success", location = "escala/atra-denegar.jsp"),
            @Result(name = "error", location = "/WEB-INF/content/comun/item-action-result.jsp") })
    public String denegar() {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        try {
            final SubservicioBO ssrvBO = new SubservicioBO();
            final ServicioBO srvcBO = new ServicioBO();
            final AtraqueBO atraBO = new AtraqueBO();

            item = ssrvBO.select(item.getId(), getIdioma());

            if (!atraBO.isDenegable(item.getId())) {
                addActionError(MessageI18nKey.E00011, item.getEstado());

                return ERROR;
            }

            item.getItdtMap().get(TipoDato.FECHA_01.getId()).setFecha(Calendar.getInstance().getTime());
            item.setSrvc(srvcBO.select(item.getSrvc().getId(), getIdioma()));
        } catch (final InstanceNotFoundException ex) {
            addActionError(MessageI18nKey.E00008, getText(ex.getClassName()), ex.getObjId());
        }

        return SUCCESS;
    }

    /**
     * Denegar guardar.
     *
     * @return the string
     */
    @Action(value = "atra-denegar-guardar", results = { @Result(name = "success", type = "redirectAction", params = {
            "actionName", "ssrv-detalle", "item.id", "%{item.id}" }) })
    public String denegarGuardar() {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());
        Preconditions.checkNotNull(item.getItdtMap());

        final TipoSubservicioVO tpssVO = TipoSubservicioProxy.select(Entidad.ATRAQUE.getId());

        item.setEntiId(tpssVO.getId());

        if (item.getItdtMap().get(TipoDato.FECHA_01.getId()).getFecha().getTime() < item.getItdtMap()
                .get(TipoDato.FECHA_02.getId()).getFecha().getTime()) {
            throw new Error("Fecha de Denegacion ha de ser posterior a fecha de solicitud");
        }

        final AtraqueBO atraBO = new AtraqueBO();

        try {
            atraBO.denegar(item.getId(), item.getItdtMap());
        } catch (final InstanceNotFoundException ex) {
            addActionError(MessageI18nKey.E00008, getText(ex.getClassName()), ex.getObjId());
        } catch (final OperacionNoPermitidaException ex) {
            addActionError(MessageI18nKey.E00013, getText(ex.getClassName()), ex.getObjId());
        }

        return SUCCESS;
    }

    /**
     * Anular.
     *
     * @return the string
     */
    @Action(value = "atra-anular-popup", results = { @Result(name = "success", location = "escala/atra-anular.jsp"),
            @Result(name = "error", location = "/WEB-INF/content/comun/item-action-result.jsp") })
    public String anular() {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        try {
            final SubservicioBO ssrvBO = new SubservicioBO();
            final ServicioBO srvcBO = new ServicioBO();
            final AtraqueBO atraBO = new AtraqueBO();

            item = ssrvBO.select(item.getId(), getIdioma());

            if (!atraBO.isAnulable(item.getId())) {
                addActionError(MessageI18nKey.E00011, item.getEstado());

                return ERROR;
            }

            item.getItdtMap().get(TipoDato.FECHA_01.getId()).setFecha(Calendar.getInstance().getTime());
            item.setSrvc(srvcBO.select(item.getSrvc().getId(), getIdioma()));
        } catch (final InstanceNotFoundException ex) {
            addActionError(MessageI18nKey.E00008, getText(ex.getClassName()), ex.getObjId());
        }

        return SUCCESS;
    }

    /**
     * Anular guardar.
     *
     * @return the string
     */
    @Action(value = "atra-anular-guardar", results = { @Result(name = "success", type = "redirectAction", params = {
            "actionName", "ssrv-detalle", "item.id", "%{item.id}" }) })
    public String anularGuardar() {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());
        Preconditions.checkNotNull(item.getItdtMap());

        final TipoSubservicioVO tpssVO = TipoSubservicioProxy.select(Entidad.ATRAQUE.getId());

        item.setEntiId(tpssVO.getId());

        if (item.getItdtMap().get(TipoDato.FECHA_01.getId()).getFecha().getTime() < item.getItdtMap()
                .get(TipoDato.FECHA_02.getId()).getFecha().getTime()) {
            throw new Error("Fecha de Anulacion ha de ser posterior a fecha de solicitud");
        }

        final AtraqueBO atraBO = new AtraqueBO();

        try {
            atraBO.anular(item.getId(), item.getItdtMap());
        } catch (final InstanceNotFoundException ex) {
            addActionError(MessageI18nKey.E00008, getText(ex.getClassName()), ex.getObjId());
        } catch (final OperacionNoPermitidaException ex) {
            addActionError(MessageI18nKey.E00013, getText(ex.getClassName()), ex.getObjId());
        }

        return SUCCESS;
    }

    /**
     * Iniciar.
     *
     * @return the string
     */
    @Action(value = "atra-iniciar-popup", results = { @Result(name = "success", location = "escala/atra-iniciar.jsp"),
            @Result(name = "error", location = "/WEB-INF/content/comun/item-action-result.jsp") })
    public String iniciar() {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        try {
            final SubservicioBO ssrvBO = new SubservicioBO();
            final ServicioBO srvcBO = new ServicioBO();
            final AtraqueBO atraBO = new AtraqueBO();

            item = ssrvBO.select(item.getId(), getIdioma());

            if (!atraBO.isIniciable(item.getId())) {
                addActionError(MessageI18nKey.E00011, item.getEstado());

                return ERROR;
            }

            // Copiar los datos de autorizacion a real
            item.getItdtMap().put(TipoDato.DECIMAL_13.getId(), item.getItdtMap().get(TipoDato.DECIMAL_07.getId()));
            item.getItdtMap().put(TipoDato.DECIMAL_14.getId(), item.getItdtMap().get(TipoDato.DECIMAL_08.getId()));
            item.getItdtMap().put(TipoDato.ALIN_3.getId(), item.getItdtMap().get(TipoDato.ALIN_2.getId()));
            item.getItdtMap().put(TipoDato.TIPO_ATR_EDI_3.getId(),
                    item.getItdtMap().get(TipoDato.TIPO_ATR_EDI_2.getId()));
            item.getItdtMap().put(TipoDato.TIPO_ESTAN_ATR_3.getId(),
                    item.getItdtMap().get(TipoDato.TIPO_ESTAN_ATR_2.getId()));
            item.getItdtMap().put(TipoDato.DECIMAL_15.getId(), item.getItdtMap().get(TipoDato.DECIMAL_09.getId()));
            item.getItdtMap().put(TipoDato.TIPO_ACT_3.getId(), item.getItdtMap().get(TipoDato.TIPO_ACT_2.getId()));
            item.getItdtMap().put(TipoDato.TEXTO_03.getId(), item.getItdtMap().get(TipoDato.TEXTO_02.getId()));

            item.setSrvc(srvcBO.select(item.getSrvc().getId(), getIdioma()));
        } catch (final InstanceNotFoundException ex) {
            addActionError(MessageI18nKey.E00008, getText(ex.getClassName()), ex.getObjId());
        }

        return SUCCESS;
    }

    /**
     * Anular iniciar.
     *
     * @return the string
     */
    @Action(value = "atra-iniciar-guardar", results = { @Result(name = "success", type = "redirectAction", params = {
            "actionName", "ssrv-detalle", "item.id", "%{item.id}" }) })
    public String iniciarGuardar() {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());
        Preconditions.checkNotNull(item.getItdtMap());

        final TipoSubservicioVO tpssVO = TipoSubservicioProxy.select(Entidad.ATRAQUE.getId());

        item.setEntiId(tpssVO.getId());

        final AtraqueBO atraBO = new AtraqueBO();

        try {
            atraBO.iniciar(item.getId(), item.getItdtMap());
        } catch (final InstanceNotFoundException ex) {
            addActionError(MessageI18nKey.E00008, getText(ex.getClassName()), ex.getObjId());
        } catch (final OperacionNoPermitidaException ex) {
            addActionError(MessageI18nKey.E00013, getText(ex.getClassName()), ex.getObjId());
        }

        return SUCCESS;
    }

    /**
     * Finalizar.
     *
     * @return the string
     */
    @Action(value = "atra-finalizar-popup", results = {
            @Result(name = "success", location = "escala/atra-finalizar.jsp"),
            @Result(name = "error", location = "/WEB-INF/content/comun/item-action-result.jsp") })
    public String finalizar() {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        try {
            final SubservicioBO ssrvBO = new SubservicioBO();
            final ServicioBO srvcBO = new ServicioBO();
            final AtraqueBO atraBO = new AtraqueBO();

            item = ssrvBO.select(item.getId(), getIdioma());

            if (!atraBO.isFinalizable(item.getId())) {
                addActionError(MessageI18nKey.E00011, item.getEstado());

                return ERROR;
            }

            item.setSrvc(srvcBO.select(item.getSrvc().getId(), getIdioma()));
        } catch (final InstanceNotFoundException ex) {
            addActionError(MessageI18nKey.E00008, getText(ex.getClassName()), ex.getObjId());
        }

        return SUCCESS;
    }

    /**
     * Finalizar guardar.
     *
     * @return the string
     */
    @Action(value = "atra-finalizar-guardar", results = { @Result(name = "success", type = "redirectAction", params = {
            "actionName", "ssrv-detalle", "item.id", "%{item.id}" }) })
    public String finalizarGuardar() {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());
        Preconditions.checkNotNull(item.getItdtMap());

        final TipoSubservicioVO tpssVO = TipoSubservicioProxy.select(Entidad.ATRAQUE.getId());

        item.setEntiId(tpssVO.getId());

        final AtraqueBO atraBO = new AtraqueBO();

        try {
            atraBO.finalizar(item.getId(), item.getItdtMap());
        } catch (final InstanceNotFoundException ex) {
            addActionError(MessageI18nKey.E00008, getText(ex.getClassName()), ex.getObjId());
        } catch (final OperacionNoPermitidaException ex) {
            addActionError(MessageI18nKey.E00013, getText(ex.getClassName()), ex.getObjId());
        }

        return SUCCESS;
    }

    /**
     * Autorizar fprevio.
     *
     * @return the string
     */
    @Action(value = "atra-autorizar-fprevio-popup", results = {
            @Result(name = "success", location = "escala/atra-autorizar-fprevio.jsp"),
            @Result(name = "error", location = "/WEB-INF/content/comun/item-action-result.jsp") })
    public String autorizarFprevio() {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        try {
            final SubservicioBO ssrvBO = new SubservicioBO();
            final ServicioBO srvcBO = new ServicioBO();
            final AtraqueBO atraBO = new AtraqueBO();

            item = ssrvBO.select(item.getId(), getIdioma());

            if (!atraBO.isAutorizableFprevio(item.getId())) {
                addActionError(MessageI18nKey.E00011, item.getEstado());

                return ERROR;
            }

            if ("S".equals(item.getEstado())) {
                // Copiar los datos de solicitud a autorizacion
                item.getItdtMap().put(TipoDato.DECIMAL_07.getId(), item.getItdtMap().get(TipoDato.DECIMAL_01.getId()));
                item.getItdtMap().put(TipoDato.DECIMAL_08.getId(), item.getItdtMap().get(TipoDato.DECIMAL_02.getId()));
                item.getItdtMap().put(TipoDato.ALIN_2.getId(), item.getItdtMap().get(TipoDato.ALIN.getId()));
                item.getItdtMap().put(TipoDato.TIPO_ATR_EDI_2.getId(),
                        item.getItdtMap().get(TipoDato.TIPO_ATR_EDI.getId()));
                item.getItdtMap().put(TipoDato.TIPO_ESTAN_ATR_2.getId(),
                        item.getItdtMap().get(TipoDato.TIPO_ESTAN_ATR.getId()));
                item.getItdtMap().put(TipoDato.DECIMAL_09.getId(), item.getItdtMap().get(TipoDato.DECIMAL_03.getId()));
                item.getItdtMap().put(TipoDato.DECIMAL_10.getId(), item.getItdtMap().get(TipoDato.DECIMAL_04.getId()));
                item.getItdtMap().put(TipoDato.TIPO_ACT_2.getId(), item.getItdtMap().get(TipoDato.TIPO_ACT.getId()));
                item.getItdtMap().put(TipoDato.TEXTO_02.getId(), item.getItdtMap().get(TipoDato.TEXTO_01.getId()));
            }

            item.getItdtMap().get(TipoDato.FECHA_01.getId()).setFecha(Calendar.getInstance().getTime());
            item.setSrvc(srvcBO.select(item.getSrvc().getId(), getIdioma()));
        } catch (final InstanceNotFoundException ex) {
            addActionError(MessageI18nKey.E00008, getText(ex.getClassName()), ex.getObjId());
        }

        return SUCCESS;
    }

    /**
     * Cambiar muelle.
     *
     * @return the string
     */
    @Action(value = "atra-cambiar-muelle-popup", results = { @Result(name = "success", location = "escala/atra-cambiar-muelle.jsp") })
    public String cambiarMuelle() {
        return SUCCESS;
    }

    /**
     * Deshacer estado.
     *
     * @return the string
     */
    @Action(value = "atra-deshacer-estado-popup", results = { @Result(name = "success", location = "escala/atra-deshacer-estado.jsp") })
    public String deshacerEstado() {
        return SUCCESS;
    }

    // get / set

    /**
     * {@inheritDoc}
     */
    @Override
    public SubservicioVO getItem() {
        return item;
    }

    /**
     * Sets the item.
     *
     * @param value
     *            the new item
     */
    public void setItem(final SubservicioVO value) {
        item = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date getFechaVigencia() {
        return item == null || item.getSrvc() == null ? Calendar.getInstance().getTime() : item.getSrvc().getFref();
    }

}
