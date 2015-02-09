package xeredi.integra.http.controller.action.servicio;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.comun.ItemAction;
import xeredi.integra.http.util.FieldFiller;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.bo.ArchivoBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.ArchivoCriterioVO;
import xeredi.integra.model.comun.vo.ArchivoInfoVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.bo.ParametroBOFactory;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.metamodelo.vo.TipoServicioVO;
import xeredi.integra.model.servicio.bo.ServicioBO;
import xeredi.integra.model.servicio.bo.ServicioBOFactory;
import xeredi.integra.model.servicio.vo.ServicioVO;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;

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

    /** The arin list. */
    private List<ArchivoInfoVO> arinList;

    /** The subps. */
    private List<LabelValueVO> subpList;

    // Acciones web
    /**
     * Detalle.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("srvc-detail")
    public String detalle() throws ApplicationException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());
        Preconditions.checkNotNull(item.getEntiId());

        enti = TipoServicioProxy.select(item.getEntiId());

        final ServicioBO srvcBO = ServicioBOFactory.newInstance(item.getEntiId());

        item = srvcBO.select(item.getId(), getIdioma());

        final ArchivoBO archBO = new ArchivoBO();
        final ArchivoCriterioVO archCriterio = new ArchivoCriterioVO();

        archCriterio.setSrvcId(item.getId());

        arinList = archBO.selectInfoList(archCriterio);

        setFechaVigencia(item.getFref());

        return SUCCESS;
    }

    /**
     * Alta.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("srvc-create")
    public String alta() throws ApplicationException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getEntiId());

        accion = ACCION_EDICION.create;
        enti = TipoServicioProxy.select(item.getEntiId());

        item.setFref(Calendar.getInstance().getTime());
        item.setAnno(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));

        FieldFiller.fillDefaultValues(item, enti);

        setFechaVigencia(item.getFref());
        loadLabelValuesMap(enti);
        loadSubpList();

        return SUCCESS;
    }

    /**
     * Modificar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action(value = "srvc-edit")
    public String modificar() throws ApplicationException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());
        Preconditions.checkNotNull(item.getEntiId());

        final ServicioBO srvcBO = ServicioBOFactory.newInstance(item.getEntiId());

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
     * @throws ApplicationException
     *             the application exception
     */
    @Action("srvc-duplicate")
    public String duplicar() throws ApplicationException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());
        Preconditions.checkNotNull(item.getEntiId());

        final ServicioBO srvcBO = ServicioBOFactory.newInstance(item.getEntiId());

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
     * @throws ApplicationException
     *             the application exception
     */
    @Action("srvc-save")
    public String guardar() throws ApplicationException {
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
            final ServicioBO srvcBO = ServicioBOFactory.newInstance(item.getEntiId());

            switch (accion) {
            case create:
                srvcBO.insert(item, null, null, null);

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
     * @throws ApplicationException
     *             the application exception
     */
    @Action("srvc-remove")
    public String borrar() throws ApplicationException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());
        Preconditions.checkNotNull(item.getEntiId());

        final ServicioBO srvcBO = ServicioBOFactory.newInstance(item.getEntiId());

        srvcBO.delete(item.getId());

        return SUCCESS;
    }

    /**
     * Load subp list.
     */
    private void loadSubpList() {
        if (subpList == null) {
            final ParametroBO prmtBO = ParametroBOFactory.newInstance(Entidad.SUBPUERTO.getId());
            final Set<Long> tpprIds = Sets.newHashSet(Entidad.SUBPUERTO.getId());

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

    /**
     * Gets the arin list.
     *
     * @return the arin list
     */
    public List<ArchivoInfoVO> getArinList() {
        return arinList;
    }

}
