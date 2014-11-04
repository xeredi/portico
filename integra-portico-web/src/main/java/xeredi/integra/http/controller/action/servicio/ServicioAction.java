package xeredi.integra.http.controller.action.servicio;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.comun.ItemAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.integra.model.metamodelo.vo.TipoServicioVO;
import xeredi.integra.model.servicio.bo.ServicioBO;
import xeredi.integra.model.servicio.vo.ServicioVO;
import xeredi.integra.model.util.Entidad;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioAction.
 */
public final class ServicioAction extends ItemAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2809685065940465041L;

    /** The enti. */
    private TipoServicioVO enti;

    /** The srvc form. */
    private ServicioVO item;

    /** The subps. */
    private List<LabelValueVO> subpList;

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
    @Action("srvc-detail")
    public String detalle() throws InstanceNotFoundException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final ServicioBO srvcBO = new ServicioBO();

        item = srvcBO.select(item.getId(), getIdioma());
        enti = TipoServicioProxy.select(item.getEntiId());

        setFechaVigencia(item.getFref());

        return SUCCESS;
    }

    /**
     * Alta.
     *
     * @return the string
     */
    @Action("srvc-create")
    public String alta() {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getEntiId());

        accion = ACCION_EDICION.create;

        enti = TipoServicioProxy.select(item.getEntiId());

        item.setFref(Calendar.getInstance().getTime());
        item.setAnno(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));

        setFechaVigencia(item.getFref());
        loadLabelValuesMap(enti);
        loadSubpList();

        return SUCCESS;
    }

    /**
     * Modificar.
     *
     * @return the string
     */
    @Action(value = "srvc-edit")
    public String modificar() throws InstanceNotFoundException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final ServicioBO srvcBO = new ServicioBO();

        item = srvcBO.select(item.getId(), getIdioma());
        enti = TipoServicioProxy.select(item.getEntiId());
        accion = ACCION_EDICION.edit;

        setFechaVigencia(item.getFref());
        loadLabelValuesMap(enti);
        loadSubpList();

        return SUCCESS;
    }

    /**
     * Duplicar.
     *
     * @return the string
     */
    @Action("srvc-duplicate")
    public String duplicar() throws InstanceNotFoundException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final ServicioBO srvcBO = new ServicioBO();

        item = srvcBO.select(item.getId(), getIdioma());
        enti = TipoServicioProxy.select(item.getEntiId());
        accion = ACCION_EDICION.duplicate;

        setFechaVigencia(item.getFref());
        loadLabelValuesMap(enti);
        loadSubpList();

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     */
    @Action("srvc-save")
    public String guardar() throws InstanceNotFoundException, DuplicateInstanceException {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getEntiId());

        final TipoServicioVO enti = TipoServicioProxy.select(item.getEntiId());

        if (accion == ACCION_EDICION.create) {
            FieldValidator.validateRequired(this, MessageI18nKey.srvc_subp, item.getSubp());
            FieldValidator.validateRequired(this, MessageI18nKey.srvc_anno, item.getAnno());
            FieldValidator.validateRequired(this, MessageI18nKey.srvc_numero, item.getNumero());
        } else {
            Preconditions.checkNotNull(item.getId());
        }

        if (enti.getTpdtEstado() != null) {
            FieldValidator.validateRequired(this, MessageI18nKey.srvc_estado, item.getEstado());
        }

        if (enti.getTemporal()) {
            FieldValidator.validateRequired(this, MessageI18nKey.srvc_fini, item.getFini());
            FieldValidator.validateRequired(this, MessageI18nKey.srvc_ffin, item.getFfin());
        } else {
            FieldValidator.validateRequired(this, MessageI18nKey.srvc_fref, item.getFref());
        }

        FieldValidator.validateItem(this, enti, item);

        if (!hasErrors()) {
            // FIXME ACABAR
            final ServicioBO srvcBO = new ServicioBO();

            switch (accion) {
            case create:
                srvcBO.insert(item, enti, null);

                break;
            case edit:
                srvcBO.update(item);

                break;
            case duplicate:
                srvcBO.duplicate(item);

                break;
            default:
                throw new Error("Accion no soportada: " + accion);
            }
        }

        return SUCCESS;
    }

    /**
     * Borrar.
     *
     * @return the string
     */
    @Action("srvc-remove")
    public String borrar() throws InstanceNotFoundException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final ServicioBO srvcBO = new ServicioBO();

        srvcBO.delete(item.getId());

        return SUCCESS;
    }

    /**
     * Load subp list.
     */
    private void loadSubpList() {
        if (subpList == null) {
            final ParametroBO prmtBO = new ParametroBO();

            final Set<Long> tpprIds = new HashSet<>();

            tpprIds.add(Entidad.SUBPUERTO.getId());
            subpList = prmtBO.selectLabelValues(tpprIds, getFechaVigencia(), getIdioma())
                    .get(Entidad.SUBPUERTO.getId());
        }
    }

    // get / set

    /**
     * Gets the subps.
     *
     * @return the subps
     */
    public List<LabelValueVO> getSubpList() {
        return subpList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ServicioVO getItem() {
        return item;
    }

    /**
     * Sets the item.
     *
     * @param value
     *            the new item
     */
    public void setItem(final ServicioVO value) {
        item = value;
    }

    /**
     * Gets the enti.
     *
     * @return the enti
     */
    public TipoServicioVO getEnti() {
        return enti;
    }

}
