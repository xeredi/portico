package xeredi.integra.http.controller.action.maestro;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.validator.GenericValidator;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.comun.ItemAction;
import xeredi.integra.http.util.ItemDatoValidator;
import xeredi.integra.model.comun.exception.ErrorCode;
import xeredi.integra.model.comun.exception.OverlapException;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.bo.SubparametroBO;
import xeredi.integra.model.maestro.vo.ParametroCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroI18nVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.maestro.vo.SubparametroCriterioVO;
import xeredi.integra.model.maestro.vo.SubparametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoParametroProxy;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.pagination.PaginatedList;

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

    /** The sprm map. */
    private Map<Long, PaginatedList<SubparametroVO>> itemHijosMap;

    /** The p18n map. */
    private Map<String, ParametroI18nVO> p18nMap;

    /** The fecha vigencia. */
    private Date fechaVigencia;

    /**
     * Instantiates a new parametro action.
     */
    public ParametroAction() {
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
     * Alta.
     *
     * @return the string
     */
    @Action("prmt-create")
    public String create() {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getEntiId());

        accion = ACCION_EDICION.create;
        p18nMap = new HashMap<>();

        final TipoParametroVO enti = TipoParametroProxy.select(item.getEntiId());

        loadLabelValuesMap(enti);

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

        final ParametroBO prmtBO = new ParametroBO();
        final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

        try {
            prmtCriterioVO.setPrvrId(item.getPrvr().getId());
            prmtCriterioVO.setIdioma(getIdioma());

            item = prmtBO.selectObject(prmtCriterioVO);

            final TipoParametroVO enti = TipoParametroProxy.select(item.getEntiId());

            if (enti.getI18n()) {
                p18nMap = prmtBO.selectI18nMap(item.getPrvr().getId());
            }

            loadLabelValuesMap(enti);
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

        final ParametroBO prmtBO = new ParametroBO();
        final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

        prmtCriterioVO.setPrvrId(item.getPrvr().getId());
        prmtCriterioVO.setIdioma(getIdioma());

        try {
            item = prmtBO.selectObject(prmtCriterioVO);

            final TipoParametroVO enti = TipoParametroProxy.select(item.getEntiId());

            if (enti.getI18n()) {
                p18nMap = prmtBO.selectI18nMap(item.getPrvr().getId());
            }

            loadLabelValuesMap(enti);
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

        final ParametroBO prmtBO = new ParametroBO();

        final TipoParametroVO enti = TipoParametroProxy.select(item.getEntiId());

        // Validacion de Datos
        if (accion != ACCION_EDICION.edit) {
            if (GenericValidator.isBlankOrNull(item.getParametro())) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("prmt_parametro") }));
            }
        }

        if (accion != ACCION_EDICION.create) {
            Preconditions.checkNotNull(item.getId());
            Preconditions.checkNotNull(item.getPrvr().getId());
        }

        if (item.getPrvr().getFini() == null) {
            addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("prmt_fini") }));
        } else {
            if (item.getPrvr().getFfin() != null && !item.getPrvr().getFini().before(item.getPrvr().getFfin())) {
                addActionError(getText(ErrorCode.E00006.name()));
            }
        }

        if (enti.getI18n()) {
            for (final String idioma : getAvailableLanguages()) {
                final ParametroI18nVO i18nVO = p18nMap.get(idioma);

                if (i18nVO == null || i18nVO.getTexto() == null || i18nVO.getTexto().isEmpty()) {
                    addActionError(getText(ErrorCode.E00002.name(), new String[] { idioma }));
                } else {
                    i18nVO.setIdioma(idioma);
                }
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
        } catch (final OverlapException ex) {
            addActionError(getText(ErrorCode.E00009.name(), new String[] { enti.getNombre() }));
        } catch (final InstanceNotFoundException ex) {
            addActionError(getText(ErrorCode.E00008.name(),
                    new String[] { enti.getNombre(), String.valueOf(item.getId()) }));
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
        Preconditions.checkNotNull(item.getPrvr());
        Preconditions.checkNotNull(item.getPrvr().getId());

        final ParametroBO prmtBO = new ParametroBO();

        try {
            prmtBO.delete(item);
        } catch (final InstanceNotFoundException ex) {
            addActionError(getText(ErrorCode.E00008.name(), new String[] { String.valueOf(item.getPrvr().getId()) }));
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

        final ParametroBO prmtBO = new ParametroBO();
        final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

        prmtCriterioVO.setId(item.getId());
        prmtCriterioVO.setFechaVigencia(fechaVigencia);
        prmtCriterioVO.setIdioma(getIdioma());

        if (item.getPrvr() != null) {
            prmtCriterioVO.setPrvrId(item.getPrvr().getId());
        }

        try {
            item = prmtBO.selectObject(prmtCriterioVO);

            item.setFref(fechaVigencia);

            final TipoParametroVO enti = TipoParametroProxy.select(item.getEntiId());

            if (enti.getI18n()) {
                p18nMap = prmtBO.selectI18nMap(item.getPrvr().getId());
            }

            if (enti.getEntiHijasList() != null && !enti.getEntiHijasList().isEmpty()) {
                final SubparametroBO sprmBO = new SubparametroBO();

                itemHijosMap = new HashMap<>();

                for (final Long tpspId : enti.getEntiHijasList()) {
                    final SubparametroCriterioVO sprmCriterioVO = new SubparametroCriterioVO();

                    sprmCriterioVO.setEntiId(tpspId);
                    sprmCriterioVO.setPrmt(new ParametroCriterioVO());
                    sprmCriterioVO.getPrmt().setId(item.getId());
                    sprmCriterioVO.setFechaVigencia(fechaVigencia);
                    sprmCriterioVO.setIdioma(getIdioma());

                    itemHijosMap.put(tpspId, sprmBO.selectList(sprmCriterioVO,
                            PaginatedList.getOffset(PaginatedList.FIRST_PAGE, ROWS), ROWS));
                }
            }
        } catch (final InstanceNotFoundException ex) {
            addActionError(getText(ErrorCode.E00007.name(), new String[] { String.valueOf(prmtCriterioVO) }));
        }

        return SUCCESS;
    }

    // get / set

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
     * Sets the fecha vigencia.
     *
     * @param value
     *            the new fecha vigencia
     */
    public void setFechaVigencia(final Date value) {
        fechaVigencia = value;
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
