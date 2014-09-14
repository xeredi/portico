package xeredi.integra.http.controller.action.maestro;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.comun.ItemAction;
import xeredi.integra.http.util.ItemDatoValidator;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.comun.exception.ErrorCode;
import xeredi.integra.model.comun.exception.OverlapException;
import xeredi.integra.model.maestro.bo.Subparametro;
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

    /** The item. */
    private SubparametroVO item;

    /** The enti. */
    private TipoSubparametroVO enti;

    /** The fecha vigencia. */
    private final Date fechaVigencia;

    /**
     * Instantiates a new subparametro action.
     */
    public SubparametroAction() {
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
        // item = SubparametroVO.newInstance(enti);

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
    @Action("sprm-edit")
    public String edit() throws InstanceNotFoundException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getSpvr());
        Preconditions.checkNotNull(item.getSpvr().getId());

        accion = ACCION_EDICION.edit;

        final Subparametro sprmBO = BOFactory.getInjector().getInstance(SubparametroBO.class);
        final SubparametroCriterioVO sprmCriterioVO = new SubparametroCriterioVO();

        sprmCriterioVO.setSpvrId(item.getSpvr().getId());
        sprmCriterioVO.setFechaVigencia(fechaVigencia);
        sprmCriterioVO.setIdioma(getIdioma());

        item = sprmBO.selectObject(sprmCriterioVO);
        enti = TipoSubparametroProxy.select(item.getEntiId());

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
    @Action("sprm-duplicate")
    public String duplicate() throws InstanceNotFoundException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getSpvr());
        Preconditions.checkNotNull(item.getSpvr().getId());

        accion = ACCION_EDICION.duplicate;

        final Subparametro sprmBO = BOFactory.getInjector().getInstance(SubparametroBO.class);
        final SubparametroCriterioVO sprmCriterioVO = new SubparametroCriterioVO();

        sprmCriterioVO.setSpvrId(item.getSpvr().getId());
        sprmCriterioVO.setFechaVigencia(fechaVigencia);
        sprmCriterioVO.setIdioma(getIdioma());

        item = sprmBO.selectObject(sprmCriterioVO);
        enti = TipoSubparametroProxy.select(item.getEntiId());

        loadLabelValuesMap();

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

        final Subparametro sprmBO = BOFactory.getInjector().getInstance(SubparametroBO.class);

        enti = TipoSubparametroProxy.select(item.getEntiId());

        // Validacion de Datos
        if (accion != ACCION_EDICION.edit) {
            if (item.getPrmtAsociado() == null || item.getPrmtAsociado().getId() == null) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { enti.getTpprAsociado().getNombre() }));
            }
        }

        if (accion != ACCION_EDICION.create) {
            Preconditions.checkNotNull(item.getId());
            Preconditions.checkNotNull(item.getSpvr());
            Preconditions.checkNotNull(item.getSpvr().getId());
        }

        if (item.getSpvr() == null || item.getSpvr().getFini() == null) {
            addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("sprm_fini") }));
        } else {
            if (item.getSpvr().getFfin() != null && !item.getSpvr().getFini().before(item.getSpvr().getFfin())) {
                addActionError(getText(ErrorCode.E00006.name()));
            }
        }

        ItemDatoValidator.validate(this, enti, item);

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
            addActionError(getText(ErrorCode.E00009.name(), new String[] { enti.getNombre() }));
        } catch (final InstanceNotFoundException ex) {
            addActionError(getText(ErrorCode.E00008.name(),
                    new String[] { enti.getNombre(), String.valueOf(item.getId()) }));
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
        Preconditions.checkNotNull(item.getEntiId());

        if (item.getSpvr() == null || item.getSpvr().getId() == null) {
            throw new Error("Identificador de version del subparametro no especificado");
        }

        final Subparametro sprmBO = BOFactory.getInjector().getInstance(SubparametroBO.class);

        enti = TipoSubparametroProxy.select(item.getEntiId());

        try {
            sprmBO.delete(item, enti);

            addActionMessage("Elemento del Maestro '" + enti.getNombre() + "' eliminado correctamente");
        } catch (final InstanceNotFoundException ex) {
            addActionError(getText("error.sprm.notFound"));
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
        Preconditions.checkNotNull(item.getSpvr());
        Preconditions.checkNotNull(item.getSpvr().getId());

        final Subparametro sprmBO = BOFactory.getInjector().getInstance(SubparametroBO.class);
        final SubparametroCriterioVO sprmCriterioVO = new SubparametroCriterioVO();

        sprmCriterioVO.setSpvrId(item.getSpvr().getId());
        sprmCriterioVO.setIdioma(getIdioma());

        item = sprmBO.selectObject(sprmCriterioVO);
        enti = TipoSubparametroProxy.select(item.getEntiId());

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
    public TipoSubparametroVO getEnti() {
        return enti;
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

}
