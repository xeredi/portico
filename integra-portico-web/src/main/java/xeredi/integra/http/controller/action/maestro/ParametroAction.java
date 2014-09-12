package xeredi.integra.http.controller.action.maestro;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.comun.ItemAction;
import xeredi.integra.http.util.ItemDatoValidator;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.comun.exception.ErrorCode;
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
     */
    @Action("prmt-create")
    public String create() {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getEntiId());

        accion = ACCION_EDICION.create;

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
     */
    @Action("prmt-edit")
    public String edit() {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getPrvr());
        Preconditions.checkNotNull(item.getPrvr().getId());

        accion = ACCION_EDICION.edit;

        final Parametro prmtBO = BOFactory.getInjector().getInstance(ParametroBO.class);
        final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

        try {
            prmtCriterioVO.setPrvrId(item.getPrvr().getId());
            prmtCriterioVO.setIdioma(getIdioma());

            item = prmtBO.selectObject(prmtCriterioVO);
            enti = TipoParametroProxy.select(item.getEntiId());

            if (enti.getI18n()) {
                p18nMap = prmtBO.selectI18nMap(item.getPrvr().getId());
            }

            loadLabelValuesMap();
        } catch (final InstanceNotFoundException ex) {
            addActionError(getText(ErrorCode.E00007.name(), new String[] { String.valueOf(item.getId()) }));
        }

        return SUCCESS;
    }

    /**
     * Duplicar.
     *
     * @return the string
     */
    @Action("prmt-duplicate")
    public String duplicate() {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getPrvr());
        Preconditions.checkNotNull(item.getPrvr().getId());

        accion = ACCION_EDICION.duplicate;

        final Parametro prmtBO = BOFactory.getInjector().getInstance(ParametroBO.class);
        final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

        prmtCriterioVO.setPrvrId(item.getPrvr().getId());
        prmtCriterioVO.setIdioma(getIdioma());

        try {
            item = prmtBO.selectObject(prmtCriterioVO);
            enti = TipoParametroProxy.select(item.getEntiId());

            if (enti.getI18n()) {
                p18nMap = prmtBO.selectI18nMap(item.getPrvr().getId());
            }

            loadLabelValuesMap();
        } catch (final InstanceNotFoundException ex) {
            addActionError(getText(ErrorCode.E00007.name(), new String[] { String.valueOf(item.getId()) }));
        }

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     */
    @Action("prmt-save")
    public String save() {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getPrvr());

        final Parametro prmtBO = BOFactory.getInjector().getInstance(ParametroBO.class);

        enti = TipoParametroProxy.select(item.getEntiId());

        // Validacion de Datos
        if (accion != ACCION_EDICION.edit) {
            if (item.getParametro() == null || item.getParametro().isEmpty()) {
                addActionError(getText(ErrorCode.E00004.name()));
            }
        }

        if (accion != ACCION_EDICION.create) {
            PropertyValidator.validateRequired(this, "id", item.getId());
            PropertyValidator.validateRequired(this, "prvr.id", item.getPrvr().getId());
        }

        if (item.getPrvr().getFini() != null && item.getPrvr().getFfin() != null
                && !item.getPrvr().getFini().before(item.getPrvr().getFfin())) {
            addActionError(getText(ErrorCode.E00006.name()));
        }

        if (enti.getTempExp()) {
            if (item.getPrvr().getFini() == null) {
                addActionError(getText(ErrorCode.E00003.name()));
            }
        } else {
            if (accion == ACCION_EDICION.create) {
                item.getPrvr().setFini(Calendar.getInstance().getTime());
            }
        }

        if (enti.getI18n()) {
            for (final String idioma : p18nMap.keySet()) {
                final ParametroI18nVO i18nVO = p18nMap.get(idioma);

                if (i18nVO == null || i18nVO.getTexto() == null || i18nVO.getTexto().isEmpty()) {
                    addActionError(getText(ErrorCode.E00002.name(), new String[] { idioma }));
                }

                i18nVO.setIdioma(idioma);
            }
            // TODO Comprobar que los idiomas coinciden con la lista de idiomas
            // disponibles
        }

        ItemDatoValidator.validate(this, enti, item);

        // Fin de validacion de datos

        if (hasErrors()) {
            return SUCCESS;
        }

        try {
            switch (accion) {
            case create:
                prmtBO.insert(item, enti, p18nMap);

                break;
            case edit:
                prmtBO.update(item, enti, p18nMap);

                break;
            case duplicate:
                prmtBO.duplicate(item, enti, p18nMap);

                break;

            default:
                throw new Error("Accion no valida: " + accion);
            }

            addActionMessage("Parametro guardado correctamente!!");
        } catch (final DuplicateInstanceException ex) {
            addActionError(getText(ErrorCode.E00005.name(), new String[] { enti.getNombre() }));
        }

        if (hasErrors()) {
            return SUCCESS;
        }

        return SUCCESS;
    }

    /**
     * Borrar.
     *
     * @return the string
     */
    @Action("prmt-remove")
    public String remove() {
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
     */
    @Action("prmt-detail")
    public String detail() {
        Preconditions.checkNotNull(item);
        Preconditions.checkArgument(item.getId() != null && fechaVigencia != null || item.getPrvr() != null
                && item.getPrvr().getId() != null);

        final Parametro prmtBO = BOFactory.getInjector().getInstance(ParametroBO.class);
        final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

        prmtCriterioVO.setId(item.getId());
        prmtCriterioVO.setFechaVigencia(fechaVigencia);
        prmtCriterioVO.setIdioma(getIdioma());

        if (item.getPrvr() != null) {
            prmtCriterioVO.setPrvrId(item.getPrvr().getId());
        }

        try {
            item = prmtBO.selectObject(prmtCriterioVO);
            enti = TipoParametroProxy.select(item.getEntiId());

            if (enti.getI18n()) {
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
        } catch (final InstanceNotFoundException ex) {
            addActionError(getText(ErrorCode.E00008.name(),
                    new String[] { enti.getNombre(), String.valueOf(prmtCriterioVO) }));
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
