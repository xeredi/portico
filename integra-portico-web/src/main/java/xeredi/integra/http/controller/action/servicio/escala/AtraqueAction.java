package xeredi.integra.http.controller.action.servicio.escala;

import java.util.Calendar;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.ItemAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.exception.OperacionNoPermitidaException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.metamodelo.vo.TipoDato;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioDetailVO;
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
