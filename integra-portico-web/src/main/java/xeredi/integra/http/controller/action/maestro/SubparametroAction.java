package xeredi.integra.http.controller.action.maestro;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.comun.ItemAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.OverlapException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.maestro.bo.SubparametroBO;
import xeredi.integra.model.maestro.vo.SubparametroCriterioVO;
import xeredi.integra.model.maestro.vo.SubparametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubparametroProxy;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroVO;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
import xeredi.util.exception.InstanceNotFoundException;

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

    /**
     * Instantiates a new subparametro action.
     */
    public SubparametroAction() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

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
        Preconditions.checkNotNull(item.getFref());

        accion = ACCION_EDICION.edit;

        final SubparametroBO sprmBO = new SubparametroBO();
        final SubparametroCriterioVO sprmCriterioVO = new SubparametroCriterioVO();

        sprmCriterioVO.setId(item.getId());
        sprmCriterioVO.setFechaVigencia(item.getFref());
        sprmCriterioVO.setIdioma(getIdioma());

        item = sprmBO.selectObject(sprmCriterioVO);
        enti = TipoSubparametroProxy.select(item.getEntiId());

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
        Preconditions.checkNotNull(item.getFref());

        accion = ACCION_EDICION.duplicate;

        final SubparametroBO sprmBO = new SubparametroBO();
        final SubparametroCriterioVO sprmCriterioVO = new SubparametroCriterioVO();

        sprmCriterioVO.setId(item.getId());
        sprmCriterioVO.setFechaVigencia(item.getFref());
        sprmCriterioVO.setIdioma(getIdioma());

        item = sprmBO.selectObject(sprmCriterioVO);

        item.setFref(sprmCriterioVO.getFechaVigencia());

        enti = TipoSubparametroProxy.select(item.getEntiId());

        loadLabelValuesMap(enti);

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     */
    @Action("sprm-save")
    public String save() {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(item);

        final SubparametroBO sprmBO = new SubparametroBO();

        enti = TipoSubparametroProxy.select(item.getEntiId());

        // Validacion de Datos
        if (accion != ACCION_EDICION.edit) {
            if (item.getPrmtAsociado() == null || item.getPrmtAsociado().getId() == null) {
                addActionError(getText(MessageI18nKey.E00001.name(),
                        new Object[] { enti.getTpprAsociado().getNombre() }));
            }
        }

        if (accion != ACCION_EDICION.create) {
            Preconditions.checkNotNull(item.getId());
            Preconditions.checkNotNull(item.getSpvr());
            Preconditions.checkNotNull(item.getSpvr().getId());
        }

        if (item.getSpvr() == null || item.getSpvr().getFini() == null) {
            addActionError(getText(MessageI18nKey.E00001.name(),
                    new Object[] { getText(MessageI18nKey.sprm_fini.name()) }));
        } else {
            if (item.getSpvr().getFfin() != null && !item.getSpvr().getFini().before(item.getSpvr().getFfin())) {
                addActionError(getText(MessageI18nKey.E00006.name()));
            }
        }

        FieldValidator.validateItem(this, enti, item);

        // Fin de validacion de datos

        if (hasErrors()) {
            return SUCCESS;
        }

        try {
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
        } catch (final OverlapException ex) {
            addActionError(getText(MessageI18nKey.E00009.name(), new Object[] { enti.getNombre() }));
        } catch (final InstanceNotFoundException ex) {
            addActionError(getText(MessageI18nKey.E00008.name(),
                    new Object[] { enti.getNombre(), String.valueOf(item.getId()) }));
        }

        return SUCCESS;
    }

    /**
     * Borrar.
     *
     * @return the string
     */
    @Action("sprm-remove")
    public String remove() {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getSpvr());
        Preconditions.checkNotNull(item.getSpvr().getId());

        if (item.getSpvr() == null || item.getSpvr().getId() == null) {
            throw new Error("Identificador de version del subparametro no especificado");
        }

        final SubparametroBO sprmBO = new SubparametroBO();

        try {
            sprmBO.delete(item);
        } catch (final InstanceNotFoundException ex) {
            addActionError(getText(MessageI18nKey.E00008.name(),
                    new Object[] { String.valueOf(item.getSpvr().getId()) }));
        }

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
        Preconditions.checkNotNull(item.getFref());

        final SubparametroBO sprmBO = new SubparametroBO();
        final SubparametroCriterioVO sprmCriterioVO = new SubparametroCriterioVO();

        sprmCriterioVO.setId(item.getId());
        sprmCriterioVO.setFechaVigencia(item.getFref());
        sprmCriterioVO.setIdioma(getIdioma());

        if (item.getSpvr() != null) {
            sprmCriterioVO.setSpvrId(item.getSpvr().getId());
        }

        item = sprmBO.selectObject(sprmCriterioVO);

        item.setFref(sprmCriterioVO.getFechaVigencia());

        enti = TipoSubparametroProxy.select(item.getEntiId());

        return SUCCESS;
    }

    // get / set

    /**
     * {@inheritDoc}
     */
    @Override
    public Date getFechaVigencia() {
        return item == null ? Calendar.getInstance().getTime() : item.getFref();
    }

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
