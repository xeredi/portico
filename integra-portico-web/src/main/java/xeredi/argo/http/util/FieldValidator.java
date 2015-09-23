package xeredi.argo.http.util;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import lombok.NonNull;

import org.apache.commons.validator.GenericValidator;

import xeredi.argo.http.controller.action.comun.BaseAction;
import xeredi.argo.http.controller.action.comun.BaseAction.ACCION_EDICION;
import xeredi.argo.model.comun.proxy.ConfigurationProxy;
import xeredi.argo.model.comun.vo.ConfigurationKey;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.comun.vo.Versionable;
import xeredi.argo.model.item.vo.ItemDatoVO;
import xeredi.argo.model.item.vo.ItemTramiteDatoVO;
import xeredi.argo.model.item.vo.ItemTramiteVO;
import xeredi.argo.model.item.vo.ItemVO;
import xeredi.argo.model.metamodelo.vo.AbstractEntidadDetailVO;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TramiteDetailVO;
import xeredi.argo.model.metamodelo.vo.TramiteTipoDatoVO;

import com.google.common.base.Preconditions;

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
    public static void validateRequired(final @NonNull BaseAction action, final @NonNull MessageI18nKey fieldName,
            final Object fieldValue) {
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
    public static void validateRequired(final @NonNull BaseAction action, final MessageI18nKey fieldName,
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
    public static void validateRequired(final @NonNull BaseAction action, final @NonNull String fieldName,
            final ItemVO fieldValue) {
        if (fieldValue == null || fieldValue.getId() == null) {
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
    public static void validateRequired(final @NonNull BaseAction action, final @NonNull String fieldName,
            final ItemVO fieldValue, final boolean required) {
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
    public static void validateRequired(final @NonNull BaseAction action, final @NonNull String fieldName,
            final Object fieldValue) {
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
    public static void validateRequired(final @NonNull BaseAction action, final @NonNull String fieldName,
            final Object fieldValue, final boolean required) {
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
    public static void validatePeriod(final @NonNull BaseAction action, final Date startDate, final Date endDate) {
        if (startDate != null && endDate != null && startDate.after(endDate)) {
            action.addActionError(MessageI18nKey.E00006);
        }
    }

    /**
     * Validate cr.
     *
     * @param action
     *            the action
     * @param fieldName
     *            the field name
     * @param value
     *            the value
     * @param validValues
     *            the valid values
     */
    public static void validateCR(final @NonNull BaseAction action, final @NonNull String fieldName,
            final String value, final @NonNull Set<String> validValues) {
        if (value != null && !validValues.contains(value)) {
            action.addActionError(MessageI18nKey.E00012, fieldName, validValues.toString());
        }
    }

    /**
     * Validate version.
     *
     * @param action
     *            the action
     * @param accion
     *            the accion
     * @param versionable
     *            the versionable
     */
    public static void validateVersion(final @NonNull BaseAction action, final ACCION_EDICION accion,
            final Versionable<?> versionable) {
        Preconditions.checkNotNull(versionable);
        Preconditions.checkNotNull(versionable.getVersion());

        if (accion != ACCION_EDICION.create) {
            Preconditions.checkNotNull(versionable.getVersion().getId());
        }

        validateRequired(action, MessageI18nKey.fini, versionable.getVersion().getFini());
        validatePeriod(action, versionable.getVersion().getFini(), versionable.getVersion().getFfin());
    }

    /**
     * Validate i18n.
     *
     * @param action
     *            the action
     * @param i18nMap
     *            the i18n map
     */
    public static void validateI18n(final @NonNull BaseAction action, final Map<String, I18nVO> i18nMap) {
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
     * @param entiDetail
     *            the enti detail
     * @param itemVO
     *            the item vo
     */
    public static void validateItem(final @NonNull BaseAction action,
            final @NonNull AbstractEntidadDetailVO entiDetail, final @NonNull ItemVO itemVO) {
        if (entiDetail.getEntdList() != null) {
            final Map<Long, ItemDatoVO> itdtMap = itemVO.getItdtMap();

            for (final Long tpdtId : entiDetail.getEntdList()) {
                final EntidadTipoDatoVO entd = entiDetail.getEntdMap().get(tpdtId);
                final ItemDatoVO itdtVO = itdtMap == null ? null : itdtMap.get(entd.getTpdt().getId());
                final String fieldname = action.getText("entd_" + entd.getId());

                validateRequired(action, fieldname, itdtVO, entd.getObligatorio());

                if (itdtVO != null) {
                    itdtVO.setTpdtId(entd.getTpdt().getId());
                    switch (entd.getTpdt().getTipoElemento()) {
                    case BO:
                    case NE:
                        validateRequired(action, fieldname, itdtVO.getCantidadEntera(), entd.getObligatorio());

                        break;
                    case ND:
                        validateRequired(action, fieldname, itdtVO.getCantidadDecimal(), entd.getObligatorio());

                        break;
                    case PR:
                        validateRequired(action, fieldname, itdtVO.getPrmt(), entd.getObligatorio());

                        break;
                    case SR:
                        validateRequired(action, fieldname, itdtVO.getSrvc(), entd.getObligatorio());

                        break;
                    case CR:
                        validateRequired(action, fieldname, itdtVO.getCadena(), entd.getObligatorio());
                        validateCR(action, fieldname, itdtVO.getCadena(), entd.getTpdt().getCdrfCodeSet());

                        break;
                    case TX:
                        validateRequired(action, fieldname, itdtVO.getCadena(), entd.getObligatorio());

                        break;
                    case FE:
                    case FH:
                        validateRequired(action, fieldname, itdtVO.getFecha(), entd.getObligatorio());

                        break;
                    default:
                        throw new Error("Tipo de dato no soportado: " + entd.getTpdt().getTipoElemento()
                                + " en la entidad: " + entiDetail.getEnti().getNombre() + " y tipo de dato: "
                                + entd.getTpdt().getNombre());
                    }
                }
            }
        }
    }

    /**
     * Validate trmt.
     *
     * @param action
     *            the action
     * @param entiDetail
     *            the enti detail
     * @param trmtDetail
     *            the trmt detail
     * @param ittr
     *            the ittr
     */
    public static void validateTrmt(final @NonNull BaseAction action,
            final @NonNull AbstractEntidadDetailVO entiDetail, final @NonNull TramiteDetailVO trmtDetail,
            final @NonNull ItemTramiteVO ittr) {
        if (trmtDetail.getTpdtList() != null) {
            final Map<Long, ItemTramiteDatoVO> ittdMap = ittr.getIttdMap();

            for (final Long tpdtId : trmtDetail.getTpdtList()) {
                final TramiteTipoDatoVO trtd = trmtDetail.getTrtdMap().get(tpdtId);
                final ItemTramiteDatoVO ittd = ittdMap == null ? null : ittdMap.get(tpdtId);
                final String fieldname = action.getText("entd_" + trtd.getEntd().getId());
                final TipoDatoVO tpdt = entiDetail.getEntdMap().get(tpdtId).getTpdt();

                validateRequired(action, fieldname, ittd, trtd.isObligatorio());

                if (ittd != null) {
                    ittd.setTpdtId(tpdtId);
                    switch (tpdt.getTipoElemento()) {
                    case BO:
                    case NE:
                        validateRequired(action, fieldname, ittd.getDnentero(), trtd.isObligatorio());

                        break;
                    case ND:
                        validateRequired(action, fieldname, ittd.getDndecimal(), trtd.isObligatorio());

                        break;
                    case PR:
                        validateRequired(action, fieldname, ittd.getDprmt(), trtd.isObligatorio());

                        break;
                    case SR:
                        validateRequired(action, fieldname, ittd.getDsrvc(), trtd.isObligatorio());

                        break;
                    case CR:
                        validateRequired(action, fieldname, ittd.getDcadena(), trtd.isObligatorio());
                        validateCR(action, fieldname, ittd.getDcadena(), tpdt.getCdrfCodeSet());

                        break;
                    case TX:
                        validateRequired(action, fieldname, ittd.getDcadena(), trtd.isObligatorio());

                        break;
                    case FE:
                    case FH:
                        validateRequired(action, fieldname, ittd.getDfecha(), trtd.isObligatorio());

                        break;
                    default:
                        throw new Error("Tipo de dato no soportado: " + tpdt.getTipoElemento() + " en el tramite: "
                                + trmtDetail.getTrmt().getId() + " y tipo de dato: " + tpdt.getNombre());
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
    public static boolean isInList(final Object value, final @NonNull Object... validValues) {
        return Arrays.asList(validValues).contains(value);
    }

}