package xeredi.integra.http.controller.action.servicio.escala;

import java.util.Calendar;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.comun.ItemAction;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.exception.OperacionNoPermitidaException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.metamodelo.vo.TipoDato;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.integra.model.servicio.bo.ServicioBO;
import xeredi.integra.model.servicio.bo.SubservicioBO;
import xeredi.integra.model.servicio.bo.escala.AtraqueBO;
import xeredi.integra.model.servicio.vo.SubservicioVO;

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

    /** The enti. */
    private TipoSubservicioVO enti;

    // Acciones Web

    /**
     * Autorizar.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OperacionNoPermitidaException
     *             the operacion no permitida exception
     */
    @Action(value = "atra-autorizar")
    public String autorizar() throws InstanceNotFoundException, OperacionNoPermitidaException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final SubservicioBO ssrvBO = new SubservicioBO();
        final ServicioBO srvcBO = new ServicioBO();
        final AtraqueBO atraBO = new AtraqueBO();

        item = ssrvBO.select(item.getId(), getIdioma());
        enti = TipoSubservicioProxy.select(item.getEntiId());

        if (!atraBO.isAutorizable(item.getId())) {
            throw new OperacionNoPermitidaException(Entidad.ATRAQUE.getId(), MessageI18nKey.atra_autorizar,
                    item.getId());
        }

        // Copiar los datos de solicitud a autorizacion
        item.getItdtMap().put(TipoDato.DECIMAL_07.getId(), item.getItdtMap().get(TipoDato.DECIMAL_01.getId()));
        item.getItdtMap().put(TipoDato.DECIMAL_08.getId(), item.getItdtMap().get(TipoDato.DECIMAL_02.getId()));
        item.getItdtMap().put(TipoDato.ALIN_2.getId(), item.getItdtMap().get(TipoDato.ALIN.getId()));
        item.getItdtMap().put(TipoDato.TIPO_ATR_EDI_2.getId(), item.getItdtMap().get(TipoDato.TIPO_ATR_EDI.getId()));
        item.getItdtMap()
        .put(TipoDato.TIPO_ESTAN_ATR_2.getId(), item.getItdtMap().get(TipoDato.TIPO_ESTAN_ATR.getId()));
        item.getItdtMap().put(TipoDato.DECIMAL_09.getId(), item.getItdtMap().get(TipoDato.DECIMAL_03.getId()));
        item.getItdtMap().put(TipoDato.DECIMAL_10.getId(), item.getItdtMap().get(TipoDato.DECIMAL_04.getId()));
        item.getItdtMap().put(TipoDato.TIPO_ACT_2.getId(), item.getItdtMap().get(TipoDato.TIPO_ACT.getId()));
        item.getItdtMap().put(TipoDato.TEXTO_02.getId(), item.getItdtMap().get(TipoDato.TEXTO_01.getId()));
        item.getItdtMap().get(TipoDato.FECHA_01.getId()).setFecha(Calendar.getInstance().getTime());

        item.setSrvc(srvcBO.select(item.getSrvc().getId(), getIdioma()));

        return SUCCESS;
    }

    /**
     * Autorizar guardar.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OperacionNoPermitidaException
     *             the operacion no permitida exception
     */
    @Action(value = "atra-autorizar-guardar", results = { @Result(name = "success", type = "redirectAction", params = {
            "actionName", "ssrv-detalle", "item.id", "%{item.id}" }) })
    public String autorizarGuardar() throws InstanceNotFoundException, OperacionNoPermitidaException {
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

        atraBO.autorizar(item.getId(), item.getItdtMap());

        return SUCCESS;
    }

    /**
     * Denegar.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OperacionNoPermitidaException
     *             the operacion no permitida exception
     */
    @Action(value = "atra-denegar")
    public String denegar() throws InstanceNotFoundException, OperacionNoPermitidaException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final SubservicioBO ssrvBO = new SubservicioBO();
        final ServicioBO srvcBO = new ServicioBO();
        final AtraqueBO atraBO = new AtraqueBO();

        item = ssrvBO.select(item.getId(), getIdioma());
        enti = TipoSubservicioProxy.select(item.getEntiId());

        if (!atraBO.isDenegable(item.getId())) {
            throw new OperacionNoPermitidaException(Entidad.ATRAQUE.getId(), MessageI18nKey.atra_denegar, item.getId());
        }

        item.getItdtMap().get(TipoDato.FECHA_01.getId()).setFecha(Calendar.getInstance().getTime());
        item.setSrvc(srvcBO.select(item.getSrvc().getId(), getIdioma()));

        return SUCCESS;
    }

    /**
     * Denegar guardar.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OperacionNoPermitidaException
     *             the operacion no permitida exception
     */
    @Action(value = "atra-denegar-guardar", results = { @Result(name = "success", type = "redirectAction", params = {
            "actionName", "ssrv-detalle", "item.id", "%{item.id}" }) })
    public String denegarGuardar() throws InstanceNotFoundException, OperacionNoPermitidaException {
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

        atraBO.denegar(item.getId(), item.getItdtMap());

        return SUCCESS;
    }

    /**
     * Anular.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OperacionNoPermitidaException
     *             the operacion no permitida exception
     */
    @Action(value = "atra-anular")
    public String anular() throws InstanceNotFoundException, OperacionNoPermitidaException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final SubservicioBO ssrvBO = new SubservicioBO();
        final ServicioBO srvcBO = new ServicioBO();
        final AtraqueBO atraBO = new AtraqueBO();

        item = ssrvBO.select(item.getId(), getIdioma());
        enti = TipoSubservicioProxy.select(item.getEntiId());

        if (!atraBO.isAnulable(item.getId())) {
            throw new OperacionNoPermitidaException(Entidad.ATRAQUE.getId(), MessageI18nKey.atra_anular, item.getId());
        }

        item.getItdtMap().get(TipoDato.FECHA_01.getId()).setFecha(Calendar.getInstance().getTime());
        item.setSrvc(srvcBO.select(item.getSrvc().getId(), getIdioma()));

        return SUCCESS;
    }

    /**
     * Anular guardar.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OperacionNoPermitidaException
     *             the operacion no permitida exception
     */
    @Action(value = "atra-anular-guardar", results = { @Result(name = "success", type = "redirectAction", params = {
            "actionName", "ssrv-detalle", "item.id", "%{item.id}" }) })
    public String anularGuardar() throws InstanceNotFoundException, OperacionNoPermitidaException {
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

        atraBO.anular(item.getId(), item.getItdtMap());

        return SUCCESS;
    }

    /**
     * Iniciar.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OperacionNoPermitidaException
     *             the operacion no permitida exception
     */
    @Action(value = "atra-iniciar")
    public String iniciar() throws InstanceNotFoundException, OperacionNoPermitidaException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final SubservicioBO ssrvBO = new SubservicioBO();
        final ServicioBO srvcBO = new ServicioBO();
        final AtraqueBO atraBO = new AtraqueBO();

        item = ssrvBO.select(item.getId(), getIdioma());
        enti = TipoSubservicioProxy.select(item.getEntiId());

        if (!atraBO.isIniciable(item.getId())) {
            throw new OperacionNoPermitidaException(Entidad.ATRAQUE.getId(), MessageI18nKey.atra_iniciar, item.getId());
        }

        // Copiar los datos de autorizacion a real
        item.getItdtMap().put(TipoDato.DECIMAL_13.getId(), item.getItdtMap().get(TipoDato.DECIMAL_07.getId()));
        item.getItdtMap().put(TipoDato.DECIMAL_14.getId(), item.getItdtMap().get(TipoDato.DECIMAL_08.getId()));
        item.getItdtMap().put(TipoDato.ALIN_3.getId(), item.getItdtMap().get(TipoDato.ALIN_2.getId()));
        item.getItdtMap().put(TipoDato.TIPO_ATR_EDI_3.getId(), item.getItdtMap().get(TipoDato.TIPO_ATR_EDI_2.getId()));
        item.getItdtMap().put(TipoDato.TIPO_ESTAN_ATR_3.getId(),
                item.getItdtMap().get(TipoDato.TIPO_ESTAN_ATR_2.getId()));
        item.getItdtMap().put(TipoDato.DECIMAL_15.getId(), item.getItdtMap().get(TipoDato.DECIMAL_09.getId()));
        item.getItdtMap().put(TipoDato.TIPO_ACT_3.getId(), item.getItdtMap().get(TipoDato.TIPO_ACT_2.getId()));
        item.getItdtMap().put(TipoDato.TEXTO_03.getId(), item.getItdtMap().get(TipoDato.TEXTO_02.getId()));

        item.setSrvc(srvcBO.select(item.getSrvc().getId(), getIdioma()));

        return SUCCESS;
    }

    /**
     * Anular iniciar.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OperacionNoPermitidaException
     *             the operacion no permitida exception
     */
    @Action(value = "atra-iniciar-guardar", results = { @Result(name = "success", type = "redirectAction", params = {
            "actionName", "ssrv-detalle", "item.id", "%{item.id}" }) })
    public String iniciarGuardar() throws InstanceNotFoundException, OperacionNoPermitidaException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());
        Preconditions.checkNotNull(item.getItdtMap());

        final TipoSubservicioVO tpssVO = TipoSubservicioProxy.select(Entidad.ATRAQUE.getId());

        item.setEntiId(tpssVO.getId());

        final AtraqueBO atraBO = new AtraqueBO();

        atraBO.iniciar(item.getId(), item.getItdtMap());

        return SUCCESS;
    }

    /**
     * Finalizar.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OperacionNoPermitidaException
     *             the operacion no permitida exception
     */
    @Action(value = "atra-finalizar")
    public String finalizar() throws InstanceNotFoundException, OperacionNoPermitidaException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final SubservicioBO ssrvBO = new SubservicioBO();
        final ServicioBO srvcBO = new ServicioBO();
        final AtraqueBO atraBO = new AtraqueBO();

        item = ssrvBO.select(item.getId(), getIdioma());
        enti = TipoSubservicioProxy.select(item.getEntiId());

        if (!atraBO.isFinalizable(item.getId())) {
            throw new OperacionNoPermitidaException(Entidad.ATRAQUE.getId(), MessageI18nKey.atra_finalizar,
                    item.getId());
        }

        item.setSrvc(srvcBO.select(item.getSrvc().getId(), getIdioma()));

        return SUCCESS;
    }

    /**
     * Finalizar guardar.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OperacionNoPermitidaException
     *             the operacion no permitida exception
     */
    @Action(value = "atra-finalizar-guardar", results = { @Result(name = "success", type = "redirectAction", params = {
            "actionName", "ssrv-detalle", "item.id", "%{item.id}" }) })
    public String finalizarGuardar() throws InstanceNotFoundException, OperacionNoPermitidaException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());
        Preconditions.checkNotNull(item.getItdtMap());

        final TipoSubservicioVO tpssVO = TipoSubservicioProxy.select(Entidad.ATRAQUE.getId());

        item.setEntiId(tpssVO.getId());

        final AtraqueBO atraBO = new AtraqueBO();

        atraBO.finalizar(item.getId(), item.getItdtMap());

        return SUCCESS;
    }

    /**
     * Autorizar fprevio.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OperacionNoPermitidaException
     *             the operacion no permitida exception
     */
    @Action(value = "atra-autorizar-fprevio")
    public String autorizarFprevio() throws InstanceNotFoundException, OperacionNoPermitidaException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final SubservicioBO ssrvBO = new SubservicioBO();
        final ServicioBO srvcBO = new ServicioBO();
        final AtraqueBO atraBO = new AtraqueBO();

        item = ssrvBO.select(item.getId(), getIdioma());
        enti = TipoSubservicioProxy.select(item.getEntiId());

        if (!atraBO.isAutorizableFprevio(item.getId())) {
            throw new OperacionNoPermitidaException(Entidad.ATRAQUE.getId(), MessageI18nKey.atra_autorizarFPrevio,
                    item.getId());
        }

        if ("S".equals(item.getEstado())) {
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
        }

        item.getItdtMap().get(TipoDato.FECHA_01.getId()).setFecha(Calendar.getInstance().getTime());
        item.setSrvc(srvcBO.select(item.getSrvc().getId(), getIdioma()));

        return SUCCESS;
    }

    /**
     * Cambiar muelle.
     *
     * @return the string
     */
    @Action(value = "atra-cambiar-muelle")
    public String cambiarMuelle() {
        return SUCCESS;
    }

    /**
     * Deshacer estado.
     *
     * @return the string
     */
    @Action(value = "atra-deshacer-estado")
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
     * Gets the enti.
     *
     * @return the enti
     */
    public TipoSubservicioVO getEnti() {
        return enti;
    }

}
