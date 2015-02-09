package xeredi.integra.http.controller.action.servicio;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.comun.ItemAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.integra.model.servicio.bo.ServicioBO;
import xeredi.integra.model.servicio.bo.ServicioBOFactory;
import xeredi.integra.model.servicio.bo.SubservicioBO;
import xeredi.integra.model.servicio.bo.SubservicioBOFactory;
import xeredi.integra.model.servicio.vo.SubservicioCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;
import xeredi.util.applicationobjects.LabelValueVO;

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
    private Map<Long, LabelValueVO> itemPadresMap;

    // Acciones web
    /**
     * Detalle.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("ssrv-detail")
    public String detalle() throws ApplicationException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());
        Preconditions.checkNotNull(item.getEntiId());

        final SubservicioBO ssrvBO = SubservicioBOFactory.newInstance(item.getEntiId());

        item = ssrvBO.select(item.getId(), getIdioma());
        enti = TipoSubservicioProxy.select(item.getEntiId());

        if (enti.getEntiPadresList() != null) {
            itemPadresMap = new HashMap<Long, LabelValueVO>();

            for (final Long entiId : enti.getEntiPadresList()) {
                if (!enti.getTpsrId().equals(entiId)) {
                    final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

                    ssrvCriterioVO.setHijoId(item.getId());
                    ssrvCriterioVO.setEntiId(entiId);

                    itemPadresMap.put(entiId, ssrvBO.selectLabelValueObject(ssrvCriterioVO));
                }
            }
        }

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
    @Action("ssrv-create")
    public String alta() throws ApplicationException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getEntiId());

        accion = ACCION_EDICION.create;

        enti = TipoSubservicioProxy.select(item.getEntiId());
        item.setFref(Calendar.getInstance().getTime());

        if (item.getSrvc() != null && item.getSrvc().getId() != null) {
            final ServicioBO srvcBO = ServicioBOFactory.newInstance(enti.getTpsrId());

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
     * @throws ApplicationException
     *             the application exception
     */
    @Action("ssrv-edit")
    public String modificar() throws ApplicationException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());
        Preconditions.checkNotNull(item.getEntiId());

        final SubservicioBO ssrvBO = SubservicioBOFactory.newInstance(item.getEntiId());

        item = ssrvBO.select(item.getId(), getIdioma());
        enti = TipoSubservicioProxy.select(item.getEntiId());
        accion = ACCION_EDICION.edit;

        if (enti.getEntiPadresList() != null) {
            itemPadresMap = new HashMap<Long, LabelValueVO>();

            for (final Long entiId : enti.getEntiPadresList()) {
                if (!enti.getTpsrId().equals(entiId)) {
                    final SubservicioCriterioVO ssrvCriterioVO = new SubservicioCriterioVO();

                    ssrvCriterioVO.setHijoId(item.getId());
                    ssrvCriterioVO.setEntiId(entiId);

                    itemPadresMap.put(entiId, ssrvBO.selectLabelValueObject(ssrvCriterioVO));
                }
            }
        }

        setFechaVigencia(item.getFref());
        loadLabelValuesMap(enti);

        return SUCCESS;
    }

    /**
     * Duplicar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("ssrv-duplicate")
    public String duplicar() throws ApplicationException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());
        Preconditions.checkNotNull(item.getEntiId());

        final SubservicioBO ssrvBO = SubservicioBOFactory.newInstance(item.getEntiId());

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
     * @throws ApplicationException
     *             the application exception
     */
    @Action("ssrv-save")
    public String guardar() throws ApplicationException {
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
            final SubservicioBO ssrvBO = SubservicioBOFactory.newInstance(item.getEntiId());

            switch (accion) {
            case create:
                ssrvBO.insert(item, enti, null);

                break;
            case edit:
                ssrvBO.update(item);

                break;
            case duplicate:
                ssrvBO.duplicate(item);

                break;
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
    public Map<Long, LabelValueVO> getItemPadresMap() {
        return itemPadresMap;
    }

    /**
     * Sets the item padres map.
     *
     * @param value
     *            the value
     */
    public void setItemPadresMap(final Map<Long, LabelValueVO> value) {
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
