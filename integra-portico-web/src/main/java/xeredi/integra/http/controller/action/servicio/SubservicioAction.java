package xeredi.integra.http.controller.action.servicio;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.validator.GenericValidator;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.comun.ItemAction;
import xeredi.integra.http.util.ItemDatoValidator;
import xeredi.integra.model.comun.exception.ErrorCode;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.integra.model.servicio.bo.ServicioBO;
import xeredi.integra.model.servicio.bo.SubservicioBO;
import xeredi.integra.model.servicio.vo.ServicioCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioAction.
 */
// @ParentPackage("json-default")
// @Result(name="success", type="json")
public final class SubservicioAction extends ItemAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 9210521463729954776L;

    /** The srvc form. */
    private SubservicioVO item;

    /** The tpsr. */
    private TipoSubservicioVO enti;

    /** The tpss list. */
    private List<TipoSubservicioVO> entiHijasList;

    /** The ssrv map. */
    private Map<Long, PaginatedList<SubservicioVO>> itemHijosMap;

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
    @Action(value = "ssrv-detail")
    public String detalle() throws InstanceNotFoundException {
        final SubservicioBO ssrvBO = new SubservicioBO();

        accion = ACCION_EDICION.edit;
        item = ssrvBO.select(item.getId(), getIdioma());
        enti = TipoSubservicioProxy.select(item.getEntiId());
        entiHijasList = new ArrayList<>();
        itemHijosMap = new HashMap<>();

        if (enti.getEntiHijasList() != null) {
            for (final Long entiId : enti.getEntiHijasList()) {
                final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();
                final ServicioCriterioVO srvcCriterioVO = new ServicioCriterioVO();

                srvcCriterioVO.setId(item.getSrvc().getId());

                ssrvCriterioVO.setSrvc(srvcCriterioVO);
                ssrvCriterioVO.setPadreId(item.getId());
                ssrvCriterioVO.setEntiId(entiId);
                ssrvCriterioVO.setIdioma(getIdioma());

                itemHijosMap.put(entiId, ssrvBO.selectList(ssrvCriterioVO,
                        PaginatedList.getOffset(PaginatedList.FIRST_PAGE, ROWS), ROWS));
                entiHijasList.add(TipoSubservicioProxy.select(entiId));
            }
        }

        LOG.info("Fin de la accion");
        // LOG.info(this);

        return SUCCESS;
    }

    /**
     * Alta.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action(value = "ssrv-create")
    public String alta() throws InstanceNotFoundException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getEntiId());

        accion = ACCION_EDICION.create;
        enti = TipoSubservicioProxy.select(item.getEntiId());

        if (item.getSrvc() != null && item.getSrvc().getId() != null) {
            final ServicioBO srvcBO = new ServicioBO();

            item.setSrvc(srvcBO.select(item.getSrvc().getId(), getIdioma()));
        }

        loadLabelValuesMap();

        return SUCCESS;
    }

    /**
     * Modificar.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action(value = "ssrv-edit")
    public String modificar() throws InstanceNotFoundException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        accion = ACCION_EDICION.edit;

        final SubservicioBO ssrvBO = new SubservicioBO();

        item = ssrvBO.select(item.getId(), getIdioma());
        enti = TipoSubservicioProxy.select(item.getEntiId());

        loadLabelValuesMap();

        return SUCCESS;
    }

    /**
     * Duplicar.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action(value = "ssrv-duplicate")
    public String duplicar() throws InstanceNotFoundException {
        accion = ACCION_EDICION.duplicate;

        final SubservicioBO ssrvBO = new SubservicioBO();

        item = ssrvBO.select(item.getId(), getIdioma());
        enti = TipoSubservicioProxy.select(item.getEntiId());

        loadLabelValuesMap();

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     */
    @Action(value = "ssrv-save")
    public String guardar() {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getEntiId());

        enti = TipoSubservicioProxy.select(item.getEntiId());

        if (accion == ACCION_EDICION.create) {
            if (item.getSrvc() == null || item.getSrvc().getId() == null) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("ssrv_srvc") }));
            }
            if (item.getNumero() == null) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("ssrv_numero") }));
            }
        } else {
            Preconditions.checkNotNull(item.getId());
            Preconditions.checkNotNull(item.getSrvc());
            Preconditions.checkNotNull(item.getSrvc().getId());
            Preconditions.checkNotNull(item.getNumero());
        }

        if (enti.getTpdtEstado() != null) {
            if (GenericValidator.isBlankOrNull(item.getEstado())) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("ssrv_estado") }));
            }
        }

        if (enti.getTemporal()) {
            if (item.getFini() == null) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("ssrv_fini") }));
            }
            if (item.getFfin() == null) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("ssrv_ffin") }));
            }
        }

        ItemDatoValidator.validate(this, enti, item);

        if (hasErrors()) {
            return SUCCESS;
        }

        final SubservicioBO ssrvBO = new SubservicioBO();

        switch (accion) {
        case create:
            try {
                ssrvBO.insert(item, null);
            } catch (final DuplicateInstanceException ex) {
                addActionError(getText(ErrorCode.E00005.name(), new String[] { enti.getNombre() }));
            }

            break;
        case edit:
            try {
                ssrvBO.update(item);
            } catch (final InstanceNotFoundException ex) {
                addActionError(getText(ErrorCode.E00008.name(), new String[] { enti.getNombre(),
                    item.getId().toString() }));
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
     * {@inheritDoc}
     */
    @Override
    public final TipoSubservicioVO getEnti() {
        return enti;
    }

    /**
     * Gets the enti hijas list.
     *
     * @return the enti hijas list
     */
    public final List<TipoSubservicioVO> getEntiHijasList() {
        return entiHijasList;
    }

    /**
     * Gets the item hijos map.
     *
     * @return the item hijos map
     */
    public final Map<Long, PaginatedList<SubservicioVO>> getItemHijosMap() {
        return itemHijosMap;
    }

}
