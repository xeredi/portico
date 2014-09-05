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
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.comun.ItemAction;
import xeredi.integra.http.util.ItemDatoValidator;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.maestro.bo.Parametro;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.integra.model.metamodelo.vo.TipoServicioVO;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.integra.model.servicio.bo.Servicio;
import xeredi.integra.model.servicio.bo.ServicioBO;
import xeredi.integra.model.servicio.bo.Subservicio;
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
import xeredi.util.struts.PropertyValidator;

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
    @Actions({
            @Action(value = "srvc-detalle"),
            @Action(value = "srvc-detalle-json", results = { @Result(name = "success", type = "json", params = {
                    "excludeNullProperties", "true", "ignoreHierarchy", "false" }) }),
            @Action(value = "srvc-detalle-popup") })
    public String detalle() throws InstanceNotFoundException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final Servicio srvcBO = BOFactory.getInjector().getInstance(ServicioBO.class);
        final Subservicio ssrvBO = BOFactory.getInjector().getInstance(SubservicioBO.class);

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
    @Action(value = "srvc-alta-popup", results = { @Result(name = "success", location = "srvc-edicion.jsp") })
    public String alta() {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getEntiId());

        accion = ACCION_EDICION.create;
        enti = TipoServicioProxy.select(item.getEntiId());
        item = ServicioVO.newInstance(enti);

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
    @Action(value = "srvc-modificar-popup", results = { @Result(name = "success", location = "srvc-edicion.jsp") })
    public String modificar() throws InstanceNotFoundException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        accion = ACCION_EDICION.edit;

        final Servicio srvcBO = BOFactory.getInjector().getInstance(ServicioBO.class);

        item = srvcBO.select(item.getId(), getIdioma());
        enti = TipoServicioProxy.select(item.getEntiId());

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
    @Action(value = "srvc-duplicar-popup", results = { @Result(name = "success", location = "srvc-edicion.jsp") })
    public String duplicar() throws InstanceNotFoundException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        accion = ACCION_EDICION.duplicate;

        final Servicio srvcBO = BOFactory.getInjector().getInstance(ServicioBO.class);

        item = srvcBO.select(item.getId(), getIdioma());
        enti = TipoServicioProxy.select(item.getEntiId());

        loadLabelValuesMap();

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     */
    @Action(value = "srvc-guardar", results = {
            @Result(name = "success", type = "redirectAction", params = { "actionName", "srvc-listado",
                    "itemCriterio.entiId", "%{enti.id}" }), @Result(name = "input", location = "srvc-edicion.jsp") })
    public String guardar() {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getEntiId());

        enti = TipoServicioProxy.select(item.getEntiId());
        item = ServicioVO.newInstance(enti);

        if (accion == ACCION_EDICION.create) {
            PropertyValidator.validateRequired(this, "item.subp", item.getSubp());
            PropertyValidator.validateRequired(this, "item.numero", item.getNumero());
            PropertyValidator.validateRequired(this, "item.anno", item.getAnno());
        } else {
            Preconditions.checkNotNull(item.getId());
        }

        PropertyValidator.validateRequired(this, "item.freferencia", item.getFreferencia());
        ItemDatoValidator.validate(this, enti, item);

        // FIXME ACABAR
        final Servicio srvcBO = BOFactory.getInjector().getInstance(ServicioBO.class);

        if (accion == ACCION_EDICION.create) {
            try {
                srvcBO.insert(item, null);
            } catch (final DuplicateInstanceException ex) {
                throw new Error(ex);
            }
        } else if (accion == ACCION_EDICION.edit) {
            srvcBO.update(item);
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
    @Action(value = "srvc-borrar", results = { @Result(name = "success", type = "redirectAction", params = {
            "actionName", "srvc-listado", "itemCriterio.entiId", "%{enti.id}" }) })
    public String borrar() throws InstanceNotFoundException {
        enti = TipoServicioProxy.select(item.getEntiId());

        final Servicio srvcBO = BOFactory.getInjector().getInstance(ServicioBO.class);

        srvcBO.delete(item.getId());

        return SUCCESS;
    }

    // get / set

    /**
     * Gets the subps.
     *
     * @return the subps
     */
    public List<LabelValueVO> getSubpList() {
        if (subpList == null) {
            final Parametro prmtBO = BOFactory.getInjector().getInstance(ParametroBO.class);

            final Set<Long> tpprIds = new HashSet<>();

            tpprIds.add(Entidad.SUBPUERTO.getId());
            subpList = prmtBO.selectLabelValues(tpprIds, fechaVigencia, getIdioma()).get(Entidad.SUBPUERTO.getId());
        }

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
