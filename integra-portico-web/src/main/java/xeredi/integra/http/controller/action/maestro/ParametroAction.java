package xeredi.integra.http.controller.action.maestro;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.comun.ItemAction;
import xeredi.integra.http.util.ItemDatoValidator;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.maestro.bo.Parametro;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.bo.Subparametro;
import xeredi.integra.model.maestro.bo.SubparametroBO;
import xeredi.integra.model.maestro.vo.ParametroCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroI18nVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.maestro.vo.SubparametroCriterioVO;
import xeredi.integra.model.maestro.vo.SubparametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoParametroProxy;
import xeredi.integra.model.metamodelo.proxy.TipoSubparametroProxy;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroVO;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.pagination.PaginatedList;
import xeredi.util.struts.PropertyValidator;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroAction.
 */
public final class ParametroAction extends ItemAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 477492673223023219L;

    /** The prmt . */
    private ParametroVO item;

    /** The tppr. */
    private TipoParametroVO enti;

    /** The tpst list. */
    private List<TipoSubparametroVO> entiHijasList;

    /** The sprm map. */
    private Map<Long, PaginatedList<SubparametroVO>> itemHijosMap;

    /** The p18n map. */
    private Map<String, ParametroI18nVO> p18nMap;

    /** The fecha vigencia. */
    private final Date fechaVigencia;

    /**
     * Instantiates a new parametro action.
     */
    public ParametroAction() {
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
     * Alta.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Actions({ @Action("prmt-crear"), @Action("prmt-crear-popup") })
    public String crear() throws InstanceNotFoundException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getEntiId());

        accion = ACCION_EDICION.alta;
        enti = TipoParametroProxy.select(item.getEntiId());
        item = ParametroVO.newInstance(enti);
        p18nMap = new HashMap<>();

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
    @Actions({ @Action("prmt-editar"), @Action("prmt-editar-popup") })
    public String editar() throws InstanceNotFoundException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        accion = ACCION_EDICION.modificar;

        final Parametro prmtBO = BOFactory.getInjector().getInstance(ParametroBO.class);
        final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

        prmtCriterioVO.setId(item.getId());
        prmtCriterioVO.setFechaVigencia(fechaVigencia);
        prmtCriterioVO.setIdioma(getIdioma());

        item = prmtBO.selectObject(prmtCriterioVO);
        enti = TipoParametroProxy.select(item.getEntiId());

        if (enti.isI18n()) {
            p18nMap = prmtBO.selectI18nMap(item.getPrvr().getId());
        }

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
    @Actions({ @Action("prmt-duplicar"), @Action("prmt-duplicar-popup") })
    public String duplicar() throws InstanceNotFoundException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        accion = ACCION_EDICION.duplicar;

        final Parametro prmtBO = BOFactory.getInjector().getInstance(ParametroBO.class);
        final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

        prmtCriterioVO.setId(item.getId());
        prmtCriterioVO.setFechaVigencia(fechaVigencia);
        prmtCriterioVO.setIdioma(getIdioma());

        item = prmtBO.selectObject(prmtCriterioVO);
        enti = TipoParametroProxy.select(item.getEntiId());

        if (enti.isI18n()) {
            p18nMap = prmtBO.selectI18nMap(item.getPrvr().getId());
        }

        loadLabelValuesMap();

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     */
    @Actions({ @Action("prmt-guardar") })
    public String guardar() {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(accion);

        final Parametro prmtBO = BOFactory.getInjector().getInstance(ParametroBO.class);

        enti = TipoParametroProxy.select(item.getEntiId());

        // Validacion de Datos
        if (accion == ACCION_EDICION.alta) {
            PropertyValidator.validateRequired(this, "parametro", item.getParametro());
        } else {
            PropertyValidator.validateRequired(this, "id", item.getId());
            PropertyValidator.validateRequired(this, "prvr.id", item.getPrvr().getId());
        }

        if (enti.isTempExp()) {
            PropertyValidator.validateRequired(this, "prvr.finicio", item.getPrvr().getFinicio());
        } else {
            if (accion == ACCION_EDICION.alta) {
                item.getPrvr().setFinicio(Calendar.getInstance().getTime());
            }
        }

        if (enti.isI18n()) {
            for (final String idioma : p18nMap.keySet()) {
                final ParametroI18nVO i18nVO = p18nMap.get(idioma);

                PropertyValidator.validateRequired(this, "p18nMap['" + idioma + "'].texto", i18nVO.getTexto());

                i18nVO.setIdioma(idioma);
            }
            // TODO Comprobar que los idiomas coinciden con la lista de idiomas
            // disponibles
        }

        ItemDatoValidator.validate(this, enti, item);

        // Fin de validacion de datos

        if (hasErrors()) {
            return ERROR;
        }

        try {
            switch (accion) {
            case alta:
                prmtBO.insert(item, enti, p18nMap);

                break;
            case modificar:
                prmtBO.update(item, enti, p18nMap);

                break;
            case duplicar:
                prmtBO.duplicate(item, enti, p18nMap);

                break;

            default:
                throw new Error("Accion no valida: " + accion);
            }

            addActionMessage("Parametro guardado correctamente!!");
        } catch (final DuplicateInstanceException ex) {
            addFieldError("prmt.parametro", getText("error.prmt.duplicate"));
        }

        if (hasErrors()) {
            return ERROR;
        }

        return SUCCESS;
    }

    /**
     * Borrar.
     *
     * @return the string
     */
    @Action(value = "prmt-borrar", results = { @Result(name = "success", type = "redirectAction", params = {
            "actionName", "prmt-listado", "itemCriterio.entiId", "%{enti.id}" }) })
    public String borrar() {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getEntiId());

        if (item.getPrvr() == null || item.getPrvr().getId() == null) {
            throw new Error("Identificador de version del parametro no especificado");
        }

        final Parametro prmtBO = BOFactory.getInjector().getInstance(ParametroBO.class);

        enti = TipoParametroProxy.select(item.getEntiId());

        try {
            prmtBO.delete(item.getPrvr().getId(), enti);

            addActionMessage("Elemento del Maestro '" + enti.getNombre() + "' eliminado correctamente");
        } catch (final InstanceNotFoundException ex) {
            addActionError(getText("error.prmt.notFound"));
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
    @Actions({ @Action("prmt-detalle"), @Action("prmt-detalle-popup") })
    public String detalle() throws InstanceNotFoundException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final Parametro prmtBO = BOFactory.getInjector().getInstance(ParametroBO.class);
        final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

        prmtCriterioVO.setId(item.getId());
        prmtCriterioVO.setFechaVigencia(fechaVigencia);
        prmtCriterioVO.setIdioma(getIdioma());

        item = prmtBO.selectObject(prmtCriterioVO);
        enti = TipoParametroProxy.select(item.getEntiId());

        // LOG.info(enti);

        if (enti.isI18n()) {
            p18nMap = prmtBO.selectI18nMap(item.getPrvr().getId());
        }

        if (enti.getEntiHijasList() != null && !enti.getEntiHijasList().isEmpty()) {
            final Subparametro sprmBO = BOFactory.getInjector().getInstance(SubparametroBO.class);

            entiHijasList = new ArrayList<>();
            itemHijosMap = new HashMap<>();

            for (final Long tpspId : enti.getEntiHijasList()) {
                final SubparametroCriterioVO sprmCriterioVO = new SubparametroCriterioVO();

                sprmCriterioVO.setEntiId(tpspId);
                sprmCriterioVO.setPrmt(new ParametroCriterioVO());
                sprmCriterioVO.getPrmt().setId(item.getId());
                sprmCriterioVO.setFechaVigencia(fechaVigencia);
                sprmCriterioVO.setIdioma(getIdioma());

                entiHijasList.add(TipoSubparametroProxy.select(tpspId));
                itemHijosMap.put(tpspId, sprmBO.selectList(sprmCriterioVO,
                        PaginatedList.getOffset(PaginatedList.FIRST_PAGE, ROWS), ROWS));
            }
        }

        return SUCCESS;
    }

    // get / set

    /**
     * {@inheritDoc}
     */
    @Override
    public TipoParametroVO getEnti() {
        return enti;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final ParametroVO getItem() {
        return item;
    }

    /**
     * Sets the item.
     *
     * @param value
     *            the new item
     */
    public final void setItem(final ParametroVO value) {
        item = value;
    }

    /**
     * Gets the p18n map.
     *
     * @return the p18n map
     */
    public Map<String, ParametroI18nVO> getP18nMap() {
        return p18nMap;
    }

    /**
     * Sets the p18n map.
     *
     * @param value
     *            the value
     */
    public void setP18nMap(final Map<String, ParametroI18nVO> value) {
        p18nMap = value;
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
    public final List<TipoSubparametroVO> getEntiHijasList() {
        return entiHijasList;
    }

    /**
     * Gets the item hijos map.
     *
     * @return the item hijos map
     */
    public final Map<Long, PaginatedList<SubparametroVO>> getItemHijosMap() {
        return itemHijosMap;
    }

}
