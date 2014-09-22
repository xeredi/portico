package xeredi.integra.http.controller.action.servicio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.validator.GenericValidator;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.comun.ItemAction;
import xeredi.integra.http.util.ItemDatoValidator;
import xeredi.integra.model.comun.exception.ErrorCode;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.integra.model.metamodelo.vo.TipoServicioVO;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.integra.model.servicio.bo.ServicioBO;
import xeredi.integra.model.servicio.bo.SubservicioBO;
import xeredi.integra.model.servicio.vo.ServicioCriterioVO;
import xeredi.integra.model.servicio.vo.ServicioVO;
import xeredi.integra.model.servicio.vo.SubservicioCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;
import xeredi.integra.model.util.Entidad;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioAction.
 */
public final class ServicioAction extends ItemAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2809685065940465041L;

    /** The srvc form. */
    private ServicioVO item;

    /** The tpsr. */
    private TipoServicioVO enti;

    /** The fecha vigencia. */
    private final Date fechaVigencia;

    /** The subps. */
    private List<LabelValueVO> subpList;

    /** The tpss list. */
    private List<TipoSubservicioVO> entiHijasList;

    /** The ssrv map. */
    private Map<Long, PaginatedList<SubservicioVO>> itemHijosMap;

    /**
     * Instantiates a new servicio action.
     */
    public ServicioAction() {
        super();

        fechaVigencia = Calendar.getInstance().getTime();
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
    @Action(value = "srvc-detail")
    public String detalle() throws InstanceNotFoundException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final ServicioBO srvcBO = new ServicioBO();
        final SubservicioBO ssrvBO = new SubservicioBO();

        accion = ACCION_EDICION.edit;
        item = srvcBO.select(item.getId(), getIdioma());
        enti = TipoServicioProxy.select(item.getEntiId());
        entiHijasList = new ArrayList<>();
        itemHijosMap = new HashMap<>();

        for (final Long entiId : enti.getEntiHijasList()) {
            final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();
            final ServicioCriterioVO srvcCriterioVO = new ServicioCriterioVO();

            srvcCriterioVO.setId(item.getId());

            ssrvCriterioVO.setSrvc(srvcCriterioVO);
            ssrvCriterioVO.setEntiId(entiId);
            ssrvCriterioVO.setIdioma(getIdioma());

            itemHijosMap.put(entiId,
                    ssrvBO.selectList(ssrvCriterioVO, PaginatedList.getOffset(PaginatedList.FIRST_PAGE, ROWS), ROWS));
            entiHijasList.add(TipoSubservicioProxy.select(entiId));
        }

        return SUCCESS;
    }

    /**
     * Alta.
     *
     * @return the string
     */
    @Action(value = "srvc-create")
    public String alta() {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getEntiId());

        accion = ACCION_EDICION.create;
        enti = TipoServicioProxy.select(item.getEntiId());

        if (!enti.getTemporal()) {
            item.setFreferencia(Calendar.getInstance().getTime());
        }

        item.setAnno(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));

        loadLabelValuesMap();
        loadSubpList();

        return SUCCESS;
    }

    /**
     * Modificar.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action(value = "srvc-edit")
    public String modificar() throws InstanceNotFoundException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        accion = ACCION_EDICION.edit;

        final ServicioBO srvcBO = new ServicioBO();

        item = srvcBO.select(item.getId(), getIdioma());
        enti = TipoServicioProxy.select(item.getEntiId());

        loadLabelValuesMap();
        loadSubpList();

        return SUCCESS;
    }

    /**
     * Duplicar.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action(value = "srvc-duplicate")
    public String duplicar() throws InstanceNotFoundException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        accion = ACCION_EDICION.duplicate;

        final ServicioBO srvcBO = new ServicioBO();

        item = srvcBO.select(item.getId(), getIdioma());
        enti = TipoServicioProxy.select(item.getEntiId());

        loadLabelValuesMap();
        loadSubpList();

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     */
    @Action(value = "srvc-save")
    public String guardar() {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getEntiId());

        enti = TipoServicioProxy.select(item.getEntiId());

        if (accion == ACCION_EDICION.create) {
            if (item.getSubp() == null || item.getSubp().getId() == null) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("srvc_subp") }));
            }
            if (item.getAnno() == null) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("srvc_anno") }));
            }
            if (item.getNumero() == null) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("srvc_numero") }));
            }
        } else {
            Preconditions.checkNotNull(item.getId());
        }

        if (enti.getTpdtEstado() != null) {
            if (GenericValidator.isBlankOrNull(item.getEstado())) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("srvc_estado") }));
            }
        }

        if (enti.getTemporal()) {
            if (item.getFini() == null) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("srvc_fini") }));
            }
            if (item.getFfin() == null) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("srvc_ffin") }));
            }
        } else {
            if (item.getFreferencia() == null) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("srvc_freferencia") }));
            }
        }

        ItemDatoValidator.validate(this, enti, item);

        if (hasErrors()) {
            return SUCCESS;
        }

        // FIXME ACABAR
        final ServicioBO srvcBO = new ServicioBO();

        switch (accion) {
        case create:
            try {
                srvcBO.insert(item, null);
            } catch (final DuplicateInstanceException ex) {
                throw new Error(ex);
            }

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

        return SUCCESS;
    }

    /**
     * Borrar.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action(value = "srvc-remove")
    public String borrar() throws InstanceNotFoundException {
        enti = TipoServicioProxy.select(item.getEntiId());

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
            subpList = prmtBO.selectLabelValues(tpprIds, fechaVigencia, getIdioma()).get(Entidad.SUBPUERTO.getId());
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
     * {@inheritDoc}
     */
    @Override
    public TipoServicioVO getEnti() {
        return enti;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date getFechaVigencia() {
        return fechaVigencia;
    }

    /**
     * Gets the enti hijas list.
     *
     * @return the enti hijas list
     */
    public List<TipoSubservicioVO> getEntiHijasList() {
        return entiHijasList;
    }

    /**
     * Gets the item hijos map.
     *
     * @return the item hijos map
     */
    public Map<Long, PaginatedList<SubservicioVO>> getItemHijosMap() {
        return itemHijosMap;
    }

}
