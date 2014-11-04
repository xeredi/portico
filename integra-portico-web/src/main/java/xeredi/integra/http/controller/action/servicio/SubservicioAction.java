package xeredi.integra.http.controller.action.servicio;

import java.util.Calendar;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.comun.ItemAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.integra.model.servicio.bo.ServicioBO;
import xeredi.integra.model.servicio.bo.SubservicioBO;
import xeredi.integra.model.servicio.vo.SubservicioVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioAction.
 */
public final class SubservicioAction extends ItemAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 9210521463729954776L;

    /** The enti. */
    private TipoSubservicioVO enti;

    /** The srvc form. */
    private SubservicioVO item;

    /** The item padres map. */
    private Map<Long, SubservicioVO> itemPadresMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    // Acciones web
    /**
     * Detalle.
     *
     * @return the string
     */
    @Action("ssrv-detail")
    public String detalle() throws InstanceNotFoundException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final SubservicioBO ssrvBO = new SubservicioBO();

        item = ssrvBO.select(item.getId(), getIdioma());
        enti = TipoSubservicioProxy.select(item.getEntiId());

        setFechaVigencia(item.getFref());

        return SUCCESS;
    }

    /**
     * Alta.
     *
     * @return the string
     */
    @Action("ssrv-create")
    public String alta() throws InstanceNotFoundException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getEntiId());

        accion = ACCION_EDICION.create;

        enti = TipoSubservicioProxy.select(item.getEntiId());
        item.setFref(Calendar.getInstance().getTime());

        if (item.getSrvc() != null && item.getSrvc().getId() != null) {
            final ServicioBO srvcBO = new ServicioBO();

            item.setSrvc(srvcBO.select(item.getSrvc().getId(), getIdioma()));
            item.setFref(item.getSrvc().getFref());
        } else {
            item.setSrvc(null);
        }

        setFechaVigencia(item.getFref());
        loadLabelValuesMap(enti);

        return SUCCESS;
    }

    /**
     * Modificar.
     *
     * @return the string
     */
    @Action("ssrv-edit")
    public String modificar() throws InstanceNotFoundException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final SubservicioBO ssrvBO = new SubservicioBO();

        item = ssrvBO.select(item.getId(), getIdioma());
        enti = TipoSubservicioProxy.select(item.getEntiId());
        accion = ACCION_EDICION.edit;

        setFechaVigencia(item.getFref());
        loadLabelValuesMap(enti);

        return SUCCESS;
    }

    /**
     * Duplicar.
     *
     * @return the string
     */
    @Action("ssrv-duplicate")
    public String duplicar() throws InstanceNotFoundException {
        final SubservicioBO ssrvBO = new SubservicioBO();

        item = ssrvBO.select(item.getId(), getIdioma());
        enti = TipoSubservicioProxy.select(item.getEntiId());
        accion = ACCION_EDICION.duplicate;

        setFechaVigencia(item.getFref());
        loadLabelValuesMap(enti);

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     */
    @Action("ssrv-save")
    public String guardar() throws InstanceNotFoundException, DuplicateInstanceException {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getEntiId());

        enti = TipoSubservicioProxy.select(item.getEntiId());

        if (accion == ACCION_EDICION.create) {
            FieldValidator.validateRequired(this, MessageI18nKey.ssrv_srvc, item.getSrvc());
            FieldValidator.validateRequired(this, MessageI18nKey.ssrv_numero, item.getNumero());
        } else {
            Preconditions.checkNotNull(item.getId());
            Preconditions.checkNotNull(item.getSrvc());
            Preconditions.checkNotNull(item.getSrvc().getId());
            Preconditions.checkNotNull(item.getNumero());
        }

        if (enti.getTpdtEstado() != null) {
            FieldValidator.validateRequired(this, MessageI18nKey.ssrv_estado, item.getEstado());
        }

        if (enti.getTemporal()) {
            FieldValidator.validateRequired(this, MessageI18nKey.ssrv_fini, item.getFini());
            FieldValidator.validateRequired(this, MessageI18nKey.ssrv_ffin, item.getFfin());
        }

        FieldValidator.validateItem(this, enti, item);

        if (!hasErrors()) {
            final SubservicioBO ssrvBO = new SubservicioBO();

            switch (accion) {
            case create:
                ssrvBO.insert(item, enti, null);

                break;
            case edit:
                ssrvBO.update(item);

                break;
            case duplicate:
                throw new Error("No implementado");
            default:
                throw new Error("Accion no valida: " + accion);
            }
        }

        return SUCCESS;
    }

    // get / set

    /**
     * {@inheritDoc}
     */
    @Override
    public final SubservicioVO getItem() {
        return item;
    }

    /**
     * Sets the item.
     *
     * @param value
     *            the new item
     */
    public final void setItem(final SubservicioVO value) {
        item = value;
    }

    /**
     * Gets the item padres map.
     *
     * @return the item padres map
     */
    public Map<Long, SubservicioVO> getItemPadresMap() {
        return itemPadresMap;
    }

    /**
     * Sets the item padres map.
     *
     * @param value
     *            the value
     */
    public void setItemPadresMap(final Map<Long, SubservicioVO> value) {
        itemPadresMap = value;
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
