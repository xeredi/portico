package xeredi.integra.http.controller.action.servicio;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.validator.GenericValidator;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.comun.ItemAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.integra.model.servicio.bo.ServicioBO;
import xeredi.integra.model.servicio.bo.SubservicioBO;
import xeredi.integra.model.servicio.vo.SubservicioVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioAction.
 */
public final class SubservicioAction extends ItemAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 9210521463729954776L;

    /** The srvc form. */
    private SubservicioVO item;

    /** The item padres map. */
    private Map<Long, SubservicioVO> itemPadresMap;

    /** The fecha vigencia. */
    private final Date fechaVigencia;

    /**
     * Instantiates a new servicio action.
     */
    public SubservicioAction() {
        super();

        fechaVigencia = new Date();
    }

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
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("ssrv-detail")
    public String detalle() throws InstanceNotFoundException {
        final SubservicioBO ssrvBO = new SubservicioBO();

        accion = ACCION_EDICION.edit;
        item = ssrvBO.select(item.getId(), getIdioma());

        return SUCCESS;
    }

    /**
     * Alta.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("ssrv-create")
    public String alta() throws InstanceNotFoundException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getEntiId());

        accion = ACCION_EDICION.create;

        final TipoSubservicioVO enti = TipoSubservicioProxy.select(item.getEntiId());

        if (item.getSrvc() != null && item.getSrvc().getId() != null) {
            final ServicioBO srvcBO = new ServicioBO();

            item.setSrvc(srvcBO.select(item.getSrvc().getId(), getIdioma()));
        }

        loadLabelValuesMap(enti);

        return SUCCESS;
    }

    /**
     * Modificar.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("ssrv-edit")
    public String modificar() throws InstanceNotFoundException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        accion = ACCION_EDICION.edit;

        final SubservicioBO ssrvBO = new SubservicioBO();

        item = ssrvBO.select(item.getId(), getIdioma());

        final TipoSubservicioVO enti = TipoSubservicioProxy.select(item.getEntiId());

        loadLabelValuesMap(enti);

        return SUCCESS;
    }

    /**
     * Duplicar.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("ssrv-duplicate")
    public String duplicar() throws InstanceNotFoundException {
        accion = ACCION_EDICION.duplicate;

        final SubservicioBO ssrvBO = new SubservicioBO();

        item = ssrvBO.select(item.getId(), getIdioma());

        final TipoSubservicioVO enti = TipoSubservicioProxy.select(item.getEntiId());

        loadLabelValuesMap(enti);

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     */
    @Action("ssrv-save")
    public String guardar() {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getEntiId());

        final TipoSubservicioVO enti = TipoSubservicioProxy.select(item.getEntiId());

        if (accion == ACCION_EDICION.create) {
            if (item.getSrvc() == null || item.getSrvc().getId() == null) {
                addActionError(MessageI18nKey.E00001, getText(MessageI18nKey.ssrv_srvc));
            }
            if (item.getNumero() == null) {
                addActionError(MessageI18nKey.E00001, getText(MessageI18nKey.ssrv_numero));
            }
        } else {
            Preconditions.checkNotNull(item.getId());
            Preconditions.checkNotNull(item.getSrvc());
            Preconditions.checkNotNull(item.getSrvc().getId());
            Preconditions.checkNotNull(item.getNumero());
        }

        if (enti.getTpdtEstado() != null) {
            if (GenericValidator.isBlankOrNull(item.getEstado())) {
                addActionError(MessageI18nKey.E00001, getText(MessageI18nKey.ssrv_estado));
            }
        }

        if (enti.getTemporal()) {
            if (item.getFini() == null) {
                addActionError(MessageI18nKey.E00001, getText(MessageI18nKey.ssrv_fini));
            }
            if (item.getFfin() == null) {
                addActionError(MessageI18nKey.E00001, getText(MessageI18nKey.ssrv_ffin));
            }
        }

        FieldValidator.validateItem(this, enti, item);

        if (hasErrors()) {
            return SUCCESS;
        }

        final SubservicioBO ssrvBO = new SubservicioBO();

        switch (accion) {
        case create:
            try {
                ssrvBO.insert(item, enti, null);
            } catch (final DuplicateInstanceException ex) {
                addActionError(MessageI18nKey.E00005, enti.getNombre());
            }

            break;
        case edit:
            try {
                ssrvBO.update(item);
            } catch (final InstanceNotFoundException ex) {
                addActionError(MessageI18nKey.E00008, enti.getNombre(), item.getId().toString());
            }

            break;
        case duplicate:
            throw new Error("No implementado");
        default:
            throw new Error("Accion no valida: " + accion);
        }

        if (hasErrors()) {
            return INPUT;
        }

        return SUCCESS;
    }

    // get / set

    /**
     * {@inheritDoc}
     */
    @Override
    public Date getFechaVigencia() {
        return fechaVigencia;
    }

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

}
