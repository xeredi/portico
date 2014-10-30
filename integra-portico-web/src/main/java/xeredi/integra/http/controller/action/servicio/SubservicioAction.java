package xeredi.integra.http.controller.action.servicio;

import java.util.Date;
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
     */
    @Action("ssrv-detail")
    public String detalle() {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final SubservicioBO ssrvBO = new SubservicioBO();

        accion = ACCION_EDICION.edit;

        try {
            item = ssrvBO.select(item.getId(), getIdioma());
            enti = TipoSubservicioProxy.select(item.getEntiId());
        } catch (final InstanceNotFoundException ex) {
            addActionError(MessageI18nKey.E00008, getText(ex.getClassName()), ex.getObjId());
        }

        return SUCCESS;
    }

    /**
     * Alta.
     *
     * @return the string
     */
    @Action("ssrv-create")
    public String alta() {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getEntiId());

        accion = ACCION_EDICION.create;

        enti = TipoSubservicioProxy.select(item.getEntiId());

        if (item.getSrvc() != null && item.getSrvc().getId() != null) {
            try {
                final ServicioBO srvcBO = new ServicioBO();

                item.setSrvc(srvcBO.select(item.getSrvc().getId(), getIdioma()));
            } catch (final InstanceNotFoundException ex) {
                addActionError(MessageI18nKey.E00008, getText(ex.getClassName()), ex.getObjId());
            }
        }

        loadLabelValuesMap(enti);

        return SUCCESS;
    }

    /**
     * Modificar.
     *
     * @return the string
     */
    @Action("ssrv-edit")
    public String modificar() {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        try {
            accion = ACCION_EDICION.edit;

            final SubservicioBO ssrvBO = new SubservicioBO();

            item = ssrvBO.select(item.getId(), getIdioma());
            enti = TipoSubservicioProxy.select(item.getEntiId());

            loadLabelValuesMap(enti);
        } catch (final InstanceNotFoundException ex) {
            addActionError(MessageI18nKey.E00008, getText(ex.getClassName()), ex.getObjId());
        }

        return SUCCESS;
    }

    /**
     * Duplicar.
     *
     * @return the string
     */
    @Action("ssrv-duplicate")
    public String duplicar() {
        accion = ACCION_EDICION.duplicate;

        try {
            final SubservicioBO ssrvBO = new SubservicioBO();

            item = ssrvBO.select(item.getId(), getIdioma());
            enti = TipoSubservicioProxy.select(item.getEntiId());

            loadLabelValuesMap(enti);
        } catch (final InstanceNotFoundException ex) {
            addActionError(MessageI18nKey.E00008, getText(ex.getClassName()), ex.getObjId());
        }

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

        if (hasErrors()) {
            return SUCCESS;
        }

        final SubservicioBO ssrvBO = new SubservicioBO();

        switch (accion) {
        case create:
            try {
                ssrvBO.insert(item, enti, null);
            } catch (final DuplicateInstanceException ex) {
                addActionError(MessageI18nKey.E00005, getText(ex.getClassName()));
            }

            break;
        case edit:
            try {
                ssrvBO.update(item);
            } catch (final InstanceNotFoundException ex) {
                addActionError(MessageI18nKey.E00008, getText(ex.getClassName()), ex.getObjId());
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

    /**
     * Gets the enti.
     *
     * @return the enti
     */
    public TipoSubservicioVO getEnti() {
        return enti;
    }

}
