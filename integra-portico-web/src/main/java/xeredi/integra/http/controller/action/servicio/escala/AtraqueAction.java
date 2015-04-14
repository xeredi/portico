package xeredi.integra.http.controller.action.servicio.escala;

import java.util.Calendar;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.ItemAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.exception.OperacionNoPermitidaException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.metamodelo.vo.TipoDato;
import xeredi.integra.model.servicio.bo.escala.AtraqueBO;
import xeredi.integra.model.servicio.bo.escala.EscalaBO;
import xeredi.integra.model.servicio.vo.SubservicioVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class AtraqueAction.
 */
public final class AtraqueAction extends ItemAction implements ModelDriven<SubservicioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6685825766813769667L;

    /** The item. */
    private SubservicioVO model;

    /** The enti. */
    private TipoSubservicioDetailVO enti;

    // Acciones Web

    /**
     * Autorizar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action(value = "atra-autorizar")
    public String autorizar() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        enti = TipoSubservicioProxy.select(model.getEntiId());

        final EscalaBO srvcBO = new EscalaBO();
        final AtraqueBO atraBO = new AtraqueBO();

        model = atraBO.select(model.getId(), getIdioma());

        if (!atraBO.isAutorizable(model.getId())) {
            throw new OperacionNoPermitidaException(Entidad.ATRAQUE.getId(), MessageI18nKey.atra_autorizar,
                    model.getId());
        }

        // Copiar los datos de solicitud a autorizacion
        model.getItdtMap().put(TipoDato.DECIMAL_07.getId(), model.getItdtMap().get(TipoDato.DECIMAL_01.getId()));
        model.getItdtMap().put(TipoDato.DECIMAL_08.getId(), model.getItdtMap().get(TipoDato.DECIMAL_02.getId()));
        model.getItdtMap().put(TipoDato.ALIN_2.getId(), model.getItdtMap().get(TipoDato.ALIN.getId()));
        model.getItdtMap().put(TipoDato.TIPO_ATR_EDI_2.getId(), model.getItdtMap().get(TipoDato.TIPO_ATR_EDI.getId()));
        model.getItdtMap().put(TipoDato.TIPO_ESTAN_ATR_2.getId(),
                model.getItdtMap().get(TipoDato.TIPO_ESTAN_ATR.getId()));
        model.getItdtMap().put(TipoDato.DECIMAL_09.getId(), model.getItdtMap().get(TipoDato.DECIMAL_03.getId()));
        model.getItdtMap().put(TipoDato.DECIMAL_10.getId(), model.getItdtMap().get(TipoDato.DECIMAL_04.getId()));
        model.getItdtMap().put(TipoDato.TIPO_ACT_2.getId(), model.getItdtMap().get(TipoDato.TIPO_ACT.getId()));
        model.getItdtMap().put(TipoDato.TEXTO_02.getId(), model.getItdtMap().get(TipoDato.TEXTO_01.getId()));
        model.getItdtMap().get(TipoDato.FECHA_01.getId()).setFecha(Calendar.getInstance().getTime());

        model.setSrvc(srvcBO.select(model.getSrvc().getId(), getIdioma()));

        return SUCCESS;
    }

    /**
     * Autorizar guardar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action(value = "atra-autorizar-guardar", results = { @Result(name = "success", type = "redirectAction", params = {
            "actionName", "ssrv-detalle", "model.id", "%{model.id}" }) })
    public String autorizarGuardar() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());
        Preconditions.checkNotNull(model.getItdtMap());

        enti = TipoSubservicioProxy.select(Entidad.ATRAQUE.getId());

        model.setEntiId(enti.getEnti().getId());

        if (model.getItdtMap().get(TipoDato.FECHA_01.getId()).getFecha().getTime() < model.getItdtMap()
                .get(TipoDato.FECHA_02.getId()).getFecha().getTime()) {
            throw new Error("Fecha de Autorizacion ha de ser posterior a fecha de solicitud");
        }

        final AtraqueBO atraBO = new AtraqueBO();

        atraBO.autorizar(model.getId(), model.getItdtMap());

        return SUCCESS;
    }

    /**
     * Denegar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action(value = "atra-denegar")
    public String denegar() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        enti = TipoSubservicioProxy.select(model.getEntiId());

        final EscalaBO srvcBO = new EscalaBO();
        final AtraqueBO atraBO = new AtraqueBO();

        model = atraBO.select(model.getId(), getIdioma());

        if (!atraBO.isDenegable(model.getId())) {
            throw new OperacionNoPermitidaException(Entidad.ATRAQUE.getId(), MessageI18nKey.atra_denegar, model.getId());
        }

        model.getItdtMap().get(TipoDato.FECHA_01.getId()).setFecha(Calendar.getInstance().getTime());
        model.setSrvc(srvcBO.select(model.getSrvc().getId(), getIdioma()));

        return SUCCESS;
    }

    /**
     * Denegar guardar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action(value = "atra-denegar-guardar", results = { @Result(name = "success", type = "redirectAction", params = {
            "actionName", "ssrv-detalle", "model.id", "%{model.id}" }) })
    public String denegarGuardar() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());
        Preconditions.checkNotNull(model.getItdtMap());

        enti = TipoSubservicioProxy.select(Entidad.ATRAQUE.getId());

        model.setEntiId(enti.getEnti().getId());

        if (model.getItdtMap().get(TipoDato.FECHA_01.getId()).getFecha().getTime() < model.getItdtMap()
                .get(TipoDato.FECHA_02.getId()).getFecha().getTime()) {
            throw new Error("Fecha de Denegacion ha de ser posterior a fecha de solicitud");
        }

        final AtraqueBO atraBO = new AtraqueBO();

        atraBO.denegar(model.getId(), model.getItdtMap());

        return SUCCESS;
    }

    /**
     * Anular.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action(value = "atra-anular")
    public String anular() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        enti = TipoSubservicioProxy.select(model.getEntiId());

        final EscalaBO srvcBO = new EscalaBO();
        final AtraqueBO atraBO = new AtraqueBO();

        model = atraBO.select(model.getId(), getIdioma());

        if (!atraBO.isAnulable(model.getId())) {
            throw new OperacionNoPermitidaException(Entidad.ATRAQUE.getId(), MessageI18nKey.atra_anular, model.getId());
        }

        model.getItdtMap().get(TipoDato.FECHA_01.getId()).setFecha(Calendar.getInstance().getTime());
        model.setSrvc(srvcBO.select(model.getSrvc().getId(), getIdioma()));

        return SUCCESS;
    }

    /**
     * Anular guardar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action(value = "atra-anular-guardar", results = { @Result(name = "success", type = "redirectAction", params = {
            "actionName", "ssrv-detalle", "model.id", "%{model.id}" }) })
    public String anularGuardar() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());
        Preconditions.checkNotNull(model.getItdtMap());

        enti = TipoSubservicioProxy.select(Entidad.ATRAQUE.getId());

        model.setEntiId(enti.getEnti().getId());

        if (model.getItdtMap().get(TipoDato.FECHA_01.getId()).getFecha().getTime() < model.getItdtMap()
                .get(TipoDato.FECHA_02.getId()).getFecha().getTime()) {
            throw new Error("Fecha de Anulacion ha de ser posterior a fecha de solicitud");
        }

        final AtraqueBO atraBO = new AtraqueBO();

        atraBO.anular(model.getId(), model.getItdtMap());

        return SUCCESS;
    }

    /**
     * Iniciar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action(value = "atra-iniciar")
    public String iniciar() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        enti = TipoSubservicioProxy.select(model.getEntiId());

        final EscalaBO srvcBO = new EscalaBO();
        final AtraqueBO atraBO = new AtraqueBO();

        model = atraBO.select(model.getId(), getIdioma());

        if (!atraBO.isIniciable(model.getId())) {
            throw new OperacionNoPermitidaException(Entidad.ATRAQUE.getId(), MessageI18nKey.atra_iniciar, model.getId());
        }

        // Copiar los datos de autorizacion a real
        model.getItdtMap().put(TipoDato.DECIMAL_13.getId(), model.getItdtMap().get(TipoDato.DECIMAL_07.getId()));
        model.getItdtMap().put(TipoDato.DECIMAL_14.getId(), model.getItdtMap().get(TipoDato.DECIMAL_08.getId()));
        model.getItdtMap().put(TipoDato.ALIN_3.getId(), model.getItdtMap().get(TipoDato.ALIN_2.getId()));
        model.getItdtMap()
                .put(TipoDato.TIPO_ATR_EDI_3.getId(), model.getItdtMap().get(TipoDato.TIPO_ATR_EDI_2.getId()));
        model.getItdtMap().put(TipoDato.TIPO_ESTAN_ATR_3.getId(),
                model.getItdtMap().get(TipoDato.TIPO_ESTAN_ATR_2.getId()));
        model.getItdtMap().put(TipoDato.DECIMAL_15.getId(), model.getItdtMap().get(TipoDato.DECIMAL_09.getId()));
        model.getItdtMap().put(TipoDato.TIPO_ACT_3.getId(), model.getItdtMap().get(TipoDato.TIPO_ACT_2.getId()));
        model.getItdtMap().put(TipoDato.TEXTO_03.getId(), model.getItdtMap().get(TipoDato.TEXTO_02.getId()));

        model.setSrvc(srvcBO.select(model.getSrvc().getId(), getIdioma()));

        return SUCCESS;
    }

    /**
     * Anular iniciar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action(value = "atra-iniciar-guardar", results = { @Result(name = "success", type = "redirectAction", params = {
            "actionName", "ssrv-detalle", "model.id", "%{model.id}" }) })
    public String iniciarGuardar() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());
        Preconditions.checkNotNull(model.getItdtMap());

        enti = TipoSubservicioProxy.select(Entidad.ATRAQUE.getId());

        model.setEntiId(enti.getEnti().getId());

        final AtraqueBO atraBO = new AtraqueBO();

        atraBO.iniciar(model.getId(), model.getItdtMap());

        return SUCCESS;
    }

    /**
     * Finalizar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action(value = "atra-finalizar")
    public String finalizar() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        enti = TipoSubservicioProxy.select(model.getEntiId());

        final EscalaBO srvcBO = new EscalaBO();
        final AtraqueBO atraBO = new AtraqueBO();

        model = atraBO.select(model.getId(), getIdioma());

        if (!atraBO.isFinalizable(model.getId())) {
            throw new OperacionNoPermitidaException(Entidad.ATRAQUE.getId(), MessageI18nKey.atra_finalizar,
                    model.getId());
        }

        model.setSrvc(srvcBO.select(model.getSrvc().getId(), getIdioma()));

        return SUCCESS;
    }

    /**
     * Finalizar guardar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action(value = "atra-finalizar-guardar", results = { @Result(name = "success", type = "redirectAction", params = {
            "actionName", "ssrv-detalle", "model.id", "%{model.id}" }) })
    public String finalizarGuardar() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());
        Preconditions.checkNotNull(model.getItdtMap());

        enti = TipoSubservicioProxy.select(Entidad.ATRAQUE.getId());

        model.setEntiId(enti.getEnti().getId());

        final AtraqueBO atraBO = new AtraqueBO();

        atraBO.finalizar(model.getId(), model.getItdtMap());

        return SUCCESS;
    }

    /**
     * Autorizar fprevio.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action(value = "atra-autorizar-fprevio")
    public String autorizarFprevio() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        enti = TipoSubservicioProxy.select(model.getEntiId());

        final EscalaBO srvcBO = new EscalaBO();
        final AtraqueBO atraBO = new AtraqueBO();

        model = atraBO.select(model.getId(), getIdioma());

        if (!atraBO.isAutorizableFprevio(model.getId())) {
            throw new OperacionNoPermitidaException(Entidad.ATRAQUE.getId(), MessageI18nKey.atra_autorizarFPrevio,
                    model.getId());
        }

        if ("S".equals(model.getEstado())) {
            // Copiar los datos de solicitud a autorizacion
            model.getItdtMap().put(TipoDato.DECIMAL_07.getId(), model.getItdtMap().get(TipoDato.DECIMAL_01.getId()));
            model.getItdtMap().put(TipoDato.DECIMAL_08.getId(), model.getItdtMap().get(TipoDato.DECIMAL_02.getId()));
            model.getItdtMap().put(TipoDato.ALIN_2.getId(), model.getItdtMap().get(TipoDato.ALIN.getId()));
            model.getItdtMap().put(TipoDato.TIPO_ATR_EDI_2.getId(),
                    model.getItdtMap().get(TipoDato.TIPO_ATR_EDI.getId()));
            model.getItdtMap().put(TipoDato.TIPO_ESTAN_ATR_2.getId(),
                    model.getItdtMap().get(TipoDato.TIPO_ESTAN_ATR.getId()));
            model.getItdtMap().put(TipoDato.DECIMAL_09.getId(), model.getItdtMap().get(TipoDato.DECIMAL_03.getId()));
            model.getItdtMap().put(TipoDato.DECIMAL_10.getId(), model.getItdtMap().get(TipoDato.DECIMAL_04.getId()));
            model.getItdtMap().put(TipoDato.TIPO_ACT_2.getId(), model.getItdtMap().get(TipoDato.TIPO_ACT.getId()));
            model.getItdtMap().put(TipoDato.TEXTO_02.getId(), model.getItdtMap().get(TipoDato.TEXTO_01.getId()));
        }

        model.getItdtMap().get(TipoDato.FECHA_01.getId()).setFecha(Calendar.getInstance().getTime());
        model.setSrvc(srvcBO.select(model.getSrvc().getId(), getIdioma()));

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
    public SubservicioVO getModel() {
        return model;
    }

    /**
     * Sets the item.
     *
     * @param value
     *            the new item
     */
    public void setModel(final SubservicioVO value) {
        model = value;
    }

    /**
     * Gets the enti.
     *
     * @return the enti
     */
    public TipoSubservicioDetailVO getEnti() {
        return enti;
    }

}
