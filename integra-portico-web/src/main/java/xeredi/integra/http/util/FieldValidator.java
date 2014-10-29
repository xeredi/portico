package xeredi.integra.http.util;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.apache.commons.validator.GenericValidator;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.proxy.ConfigurationProxy;
import xeredi.integra.model.comun.vo.ConfigurationKey;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.comun.vo.ItemVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.EntidadVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FieldValidator.
 */
public final class FieldValidator {

    /**
     * Validate required.
     *
     * @param action
     *            the action
     * @param fieldName
     *            the field name
     * @param fieldValue
     *            the field value
     */
    public static void validateRequired(final BaseAction action, final MessageI18nKey fieldName, final Object fieldValue) {
        if (fieldValue == null || fieldValue instanceof String && ((String) fieldValue).isEmpty()) {
            action.addActionError(MessageI18nKey.E00001, action.getText(fieldName));
        }
    }

    /**
     * Validate required.
     *
     * @param action
     *            the action
     * @param fieldName
     *            the field name
     * @param fieldValue
     *            the field value
     * @param required
     *            the required
     */
    public static void validateRequired(final BaseAction action, final MessageI18nKey fieldName,
            final Object fieldValue, final boolean required) {
        if (required) {
            validateRequired(action, fieldName, fieldValue);
        }
    }

    /**
     * Validate required.
     *
     * @param action
     *            the action
     * @param fieldName
     *            the field name
     * @param fieldValue
     *            the field value
     */
    public static void validateRequired(final BaseAction action, final String fieldName, final Object fieldValue) {
        if (fieldValue == null || fieldValue instanceof String && ((String) fieldValue).isEmpty()) {
            action.addActionError(MessageI18nKey.E00001, fieldName);
        }
    }

    /**
     * Validate required.
     *
     * @param action
     *            the action
     * @param fieldName
     *            the field name
     * @param fieldValue
     *            the field value
     * @param required
     *            the required
     */
    public static void validateRequired(final BaseAction action, final String fieldName, final Object fieldValue,
            final boolean required) {
        if (required) {
            validateRequired(action, fieldName, fieldValue);
        }
    }

    /**
     * Validate period.
     *
     * @param action
     *            the action
     * @param startDate
     *            the start date
     * @param endDate
     *            the end date
     */
    public static void validatePeriod(final BaseAction action, final Date startDate, final Date endDate) {
        if (startDate != null && endDate != null && startDate.after(endDate)) {
            action.addActionError(MessageI18nKey.E00006);
        }
    }

    /**
     * Validate i18n.
     *
     * @param action
     *            the action
     * @param i18nMap
     *            the i18n map
     */
    public static void validateI18n(final BaseAction action, final Map<String, I18nVO> i18nMap) {
        final String language_default = ConfigurationProxy.getString(ConfigurationKey.language_default);

        if (i18nMap != null) {
            for (final String language : i18nMap.keySet()) {
                final I18nVO i18nVO = i18nMap.get(language);

                i18nVO.setLanguage(language);
            }
        }

        if (i18nMap == null || i18nMap.isEmpty() || !i18nMap.containsKey(language_default)
                || GenericValidator.isBlankOrNull(i18nMap.get(language_default).getText())) {
            action.addActionError(MessageI18nKey.E00002, language_default);
        }
    }

    /**
     * Validate item.
     *
     * @param action
     *            the action
     * @param entiVO
     *            the enti vo
     * @param itemVO
     *            the item vo
     */
    public static void validateItem(final BaseAction action, final EntidadVO entiVO, final ItemVO itemVO) {
        if (entiVO.getEntdList() != null) {
            final Map<Long, ItemDatoVO> itdtMap = itemVO.getItdtMap();

            for (final EntidadTipoDatoVO entd : entiVO.getEntdList()) {
                final ItemDatoVO itdtVO = itdtMap == null ? null : itdtMap.get(entd.getTpdt().getId().toString());

                validateRequired(action, entd.getEtiqueta(), itdtVO, entd.getObligatorio());

                if (itdtVO != null) {
                    itdtVO.setTpdtId(entd.getTpdt().getId());
                    switch (entd.getTpdt().getTipoElemento()) {
                    case BO:
                    case NE:
                        validateRequired(action, entd.getEtiqueta(), itdtVO.getCantidadEntera(), entd.getObligatorio());

                        break;
                    case ND:
                        validateRequired(action, entd.getEtiqueta(), itdtVO.getCantidadDecimal(), entd.getObligatorio());

                        break;
                    case PR:
                        validateRequired(action, entd.getEtiqueta(), itdtVO.getPrmt(), entd.getObligatorio());

                        break;
                    case SR:
                        validateRequired(action, entd.getEtiqueta(), itdtVO.getSrvc(), entd.getObligatorio());

                        break;
                    case CR:
                    case TX:
                        validateRequired(action, entd.getEtiqueta(), itdtVO.getCadena(), entd.getObligatorio());

                        break;
                    case FE:
                    case FH:
                        validateRequired(action, entd.getEtiqueta(), itdtVO.getFecha(), entd.getObligatorio());

                        break;
                    default:
                        throw new Error("Tipo de dato no soportado: " + entd.getTpdt().getTipoElemento()
                                + " en la entidad: " + entiVO.getNombre() + " y tipo de dato: "
                                + entd.getTpdt().getNombre());
                    }
                }
            }
        }
    }

    /**
     * Checks if is in list.
     *
     * @param value
     *            the value
     * @param validValues
     *            the valid values
     * @return true, if is in list
     */
    public static boolean isInList(final Object value, final Object... validValues) {
        return Arrays.asList(validValues).contains(value);
    }

}
