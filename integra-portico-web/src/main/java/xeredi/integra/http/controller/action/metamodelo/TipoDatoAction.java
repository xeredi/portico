package xeredi.integra.http.controller.action.metamodelo;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.exception.ErrorCode;
import xeredi.integra.model.metamodelo.bo.TipoDatoBO;
import xeredi.integra.model.metamodelo.vo.TipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoElemento;
import xeredi.integra.model.metamodelo.vo.TipoHtml;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
import xeredi.util.exception.DuplicateInstanceException;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoDatoAction.
 */
public final class TipoDatoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7405460701196255597L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The tppr. */
    private TipoDatoVO tpdt;

    /**
     * Instantiates a new tipo dato action.
     */
    public TipoDatoAction() {
        super();

        tpdt = new TipoDatoVO();
    }

    // Acciones Web
    /**
     * Alta.
     *
     * @return the string
     */
    @Action("tpdt-create")
    public String create() {
        accion = ACCION_EDICION.create;

        return SUCCESS;
    }

    /**
     * Modificar.
     *
     * @return the string
     */
    @Action("tpdt-edit")
    public String edit() {
        Preconditions.checkNotNull(tpdt);
        Preconditions.checkNotNull(tpdt.getId());

        accion = ACCION_EDICION.edit;

        final TipoDatoBO tpdtBO = new TipoDatoBO();

        tpdt = tpdtBO.select(tpdt.getId(), getIdioma());

        if (tpdt == null) {
            addActionError(getText(ErrorCode.E00008.name(),
                    new String[] { getText("tptd"), String.valueOf(tpdt.getId()) }));
        }

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     */
    @Action("tpdt-save")
    public String save() {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(tpdt);

        // Validacion de datos
        if (accion == ACCION_EDICION.create) {
            if (tpdt.getCodigo() == null || tpdt.getCodigo().isEmpty()) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("tpdt_codigo") }));
            }
        } else {
            if (tpdt.getId() == null) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("enti_id") }));
            }
        }

        if (tpdt.getNombre() == null || tpdt.getNombre().isEmpty()) {
            addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("tpdt_nombre") }));
        }
        if (tpdt.getTpht() == null) {
            addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("tpdt_tpht") }));
        }
        if (tpdt.getTipoElemento() == null) {
            addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("tpdt_tipoElemento") }));
        }

        if (tpdt.getTipoElemento() != null
                && (tpdt.getTipoElemento() == TipoElemento.PR || tpdt.getTipoElemento() == TipoElemento.SR)) {
            if (tpdt.getEnti() == null || tpdt.getEnti().getId() == null) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("tpdt_enti") }));
            }
        }

        if (hasErrors()) {
            return SUCCESS;
        }

        final TipoDatoBO tpdtBO = new TipoDatoBO();

        if (accion == ACCION_EDICION.create) {
            try {
                tpdtBO.insert(tpdt);
            } catch (final DuplicateInstanceException ex) {
                addActionError(getText(ErrorCode.E00005.name(), new String[] { getText("tpdt") }));
            }
        } else {
            tpdtBO.update(tpdt);
        }

        return SUCCESS;
    }

    /**
     * Removes the.
     *
     * @return the string
     */
    @Action("tpdt-remove")
    public String remove() {
        Preconditions.checkNotNull(tpdt);
        Preconditions.checkNotNull(tpdt.getId());

        final TipoDatoBO tpdtBO = new TipoDatoBO();

        tpdtBO.delete(tpdt);

        return SUCCESS;
    }

    /**
     * Detalle.
     *
     * @return the string
     */
    @Action("tpdt-detail")
    public String detail() {
        Preconditions.checkNotNull(tpdt);
        Preconditions.checkNotNull(tpdt.getId());

        final TipoDatoBO tpdtBO = new TipoDatoBO();

        tpdt = tpdtBO.select(tpdt.getId(), getIdioma());

        if (tpdt == null) {
            addActionError(getText(ErrorCode.E00008.name(),
                    new String[] { getText("tptd"), String.valueOf(tpdt.getId()) }));
        }

        return SUCCESS;
    }

    // get / set
    /**
     * Gets the tphts.
     *
     * @return the tphts
     */
    public TipoHtml[] getTphts() {
        return TipoHtml.values();
    }

    /**
     * Gets the tipos elemento.
     *
     * @return the tipos elemento
     */
    public TipoElemento[] getTiposElemento() {
        return TipoElemento.values();
    }

    /**
     * Gets the accion.
     *
     * @return the accion
     */
    public ACCION_EDICION getAccion() {
        return accion;
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
     * Gets the tpdt.
     *
     * @return the tpdt
     */
    public TipoDatoVO getTpdt() {
        return tpdt;
    }

    /**
     * Sets the tpdt.
     *
     * @param value
     *            the new tpdt
     */
    public void setTpdt(final TipoDatoVO value) {
        tpdt = value;
    }

}
