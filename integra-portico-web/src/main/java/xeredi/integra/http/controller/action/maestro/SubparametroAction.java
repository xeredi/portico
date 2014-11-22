package xeredi.integra.http.controller.action.maestro;

import java.util.Calendar;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.comun.ItemAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.exception.OverlapException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.maestro.bo.SubparametroBO;
import xeredi.integra.model.maestro.vo.SubparametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubparametroProxy;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class SubparametroAction.
 */
public final class SubparametroAction extends ItemAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2326503947837608186L;

    /** The enti. */
    private TipoSubparametroVO enti;

    /** The item. */
    private SubparametroVO item;

    // Acciones Web

    /**
     * Alta.
     *
     * @return the string
     */
    @Action("sprm-create")
    public String create() {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getEntiId());
        Preconditions.checkNotNull(item.getPrmtId());

        if (getFechaVigencia() == null) {
            setFechaVigencia(Calendar.getInstance().getTime());
        }

        accion = ACCION_EDICION.create;

        enti = TipoSubparametroProxy.select(item.getEntiId());

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
    @Action("sprm-edit")
    public String edit() throws InstanceNotFoundException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        if (getFechaVigencia() == null) {
            setFechaVigencia(Calendar.getInstance().getTime());
        }

        final SubparametroBO sprmBO = new SubparametroBO();

        item = sprmBO.selectObject(item.getId(), getIdioma(), getFechaVigencia());
        enti = TipoSubparametroProxy.select(item.getEntiId());
        accion = ACCION_EDICION.edit;

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
    @Action("sprm-duplicate")
    public String duplicate() throws InstanceNotFoundException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        if (getFechaVigencia() == null) {
            setFechaVigencia(Calendar.getInstance().getTime());
        }

        final SubparametroBO sprmBO = new SubparametroBO();

        item = sprmBO.selectObject(item.getId(), getIdioma(), getFechaVigencia());
        enti = TipoSubparametroProxy.select(item.getEntiId());
        accion = ACCION_EDICION.duplicate;

        loadLabelValuesMap(enti);

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OverlapException
     *             the overlap exception
     */
    @Action("sprm-save")
    public String save() throws InstanceNotFoundException, OverlapException {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(item);

        final SubparametroBO sprmBO = new SubparametroBO();

        enti = TipoSubparametroProxy.select(item.getEntiId());

        // Validacion de Datos
        if (accion != ACCION_EDICION.edit) {
            FieldValidator.validateRequired(this, getText("enti_" + enti.getTpprAsociado().getId()),
                    item.getPrmtAsociado());
        }

        if (accion != ACCION_EDICION.create) {
            Preconditions.checkNotNull(item.getId());
            Preconditions.checkNotNull(item.getSpvr());
            Preconditions.checkNotNull(item.getSpvr().getId());
        }

        if (item.getSpvr() == null) {
            FieldValidator.validateRequired(this, MessageI18nKey.sprm_fini, item.getSpvr());
        } else {
            FieldValidator.validateRequired(this, MessageI18nKey.sprm_fini, item.getSpvr().getFini());
            FieldValidator.validatePeriod(this, item.getSpvr().getFini(), item.getSpvr().getFfin());
        }

        FieldValidator.validateItem(this, enti, item);

        // Fin de validacion de datos

        if (!hasErrors()) {
            switch (accion) {
            case create:
                sprmBO.insert(item, enti);

                break;
            case edit:
                sprmBO.update(item, enti);

                break;
            case duplicate:
                sprmBO.duplicate(item, enti);

                break;
            default:
                throw new Error("Accion no valida: " + accion);
            }
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
    @Action("sprm-remove")
    public String remove() throws InstanceNotFoundException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getSpvr());
        Preconditions.checkNotNull(item.getSpvr().getId());

        final SubparametroBO sprmBO = new SubparametroBO();

        sprmBO.delete(item);

        return SUCCESS;
    }

    /**
     * Detalle.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("sprm-detail")
    public String detalle() throws InstanceNotFoundException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        if (getFechaVigencia() == null) {
            setFechaVigencia(Calendar.getInstance().getTime());
        }

        final SubparametroBO sprmBO = new SubparametroBO();

        item = sprmBO.selectObject(item.getId(), getIdioma(), getFechaVigencia());
        enti = TipoSubparametroProxy.select(item.getEntiId());

        return SUCCESS;
    }

    // get / set

    /**
     * {@inheritDoc}
     */
    @Override
    public SubparametroVO getItem() {
        return item;
    }

    /**
     * Sets the item.
     *
     * @param value
     *            the new item
     */
    public void setItem(final SubparametroVO value) {
        item = value;
    }

    /**
     * Gets the enti.
     *
     * @return the enti
     */
    public TipoSubparametroVO getEnti() {
        return enti;
    }

}
