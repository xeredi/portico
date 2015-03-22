package xeredi.integra.http.controller.action.maestro;

import java.util.Calendar;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.comun.ItemAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.bo.ParametroBOFactory;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoParametroProxy;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroAction.
 */
public final class ParametroAction extends ItemAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 477492673223023219L;

    /** The enti. */
    private TipoParametroVO enti;

    /** The prmt . */
    private ParametroVO item;

    /** The p18n map. */
    private Map<String, I18nVO> i18nMap;

    // Acciones web
    /**
     * Modificar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("prmt-edit")
    public String edit() throws ApplicationException {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getEntiId());
        Preconditions.checkNotNull(getFechaVigencia());

        enti = TipoParametroProxy.select(item.getEntiId());

        if (accion != ACCION_EDICION.create) {
            Preconditions.checkNotNull(item.getId());

            final ParametroBO prmtBO = ParametroBOFactory.newInstance(item.getEntiId());

            item = prmtBO.select(item.getId(), getIdioma(), getFechaVigencia());

            if (enti.getI18n()) {
                i18nMap = I18nBO.selectMap(I18nPrefix.prvr, item.getPrvr().getId());
            }
        }

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
    @Action("prmt-save")
    public String save() throws ApplicationException {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getEntiId());

        enti = TipoParametroProxy.select(item.getEntiId());

        // Validacion de Datos
        if (accion != ACCION_EDICION.edit) {
            FieldValidator.validateRequired(this, MessageI18nKey.prmt_parametro, item.getParametro());
        }

        if (accion != ACCION_EDICION.create) {
            Preconditions.checkNotNull(item.getPrvr());
            Preconditions.checkNotNull(item.getId());
            Preconditions.checkNotNull(item.getPrvr().getId());
        }

        if (item.getPrvr() == null) {
            FieldValidator.validateRequired(this, MessageI18nKey.prmt_fini, item.getPrvr());
        } else {
            FieldValidator.validateRequired(this, MessageI18nKey.prmt_fini, item.getPrvr().getFini());
            FieldValidator.validatePeriod(this, item.getPrvr().getFini(), item.getPrvr().getFfin());
        }

        if (enti.getI18n()) {
            FieldValidator.validateI18n(this, i18nMap);
        }

        FieldValidator.validateItem(this, enti, item);

        // Fin de validacion de datos

        if (!hasErrors()) {
            final ParametroBO prmtBO = ParametroBOFactory.newInstance(item.getEntiId());

            switch (accion) {
            case create:
                prmtBO.insert(item, enti, i18nMap);

                break;
            case edit:
                prmtBO.update(item, enti, i18nMap);

                break;
            case duplicate:
                prmtBO.duplicate(item, enti, i18nMap);

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
     * @throws ApplicationException
     *             the application exception
     */
    @Action("prmt-remove")
    public String remove() throws ApplicationException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getPrvr());
        Preconditions.checkNotNull(item.getPrvr().getId());
        Preconditions.checkNotNull(item.getEntiId());

        final ParametroBO prmtBO = ParametroBOFactory.newInstance(item.getEntiId());

        prmtBO.delete(item);

        return SUCCESS;
    }

    /**
     * Detalle.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("prmt-detail")
    public String detail() throws ApplicationException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());
        Preconditions.checkNotNull(item.getEntiId());

        if (getFechaVigencia() == null) {
            setFechaVigencia(Calendar.getInstance().getTime());
        }

        final ParametroBO prmtBO = ParametroBOFactory.newInstance(item.getEntiId());

        item = prmtBO.select(item.getId(), getIdioma(), getFechaVigencia());
        enti = TipoParametroProxy.select(item.getEntiId());

        if (enti.getI18n()) {
            i18nMap = I18nBO.selectMap(I18nPrefix.prvr, item.getPrvr().getId());
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
     * Gets the i18n map.
     *
     * @return the i18n map
     */
    public Map<String, I18nVO> getI18nMap() {
        return i18nMap;
    }

    /**
     * Sets the i18n map.
     *
     * @param value
     *            the value
     */
    public void setI18nMap(final Map<String, I18nVO> value) {
        i18nMap = value;
    }

    /**
     * Gets the enti.
     *
     * @return the enti
     */
    public TipoParametroVO getEnti() {
        return enti;
    }
}
