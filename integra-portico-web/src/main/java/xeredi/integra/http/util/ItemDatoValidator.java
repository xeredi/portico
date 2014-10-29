package xeredi.integra.http.util;

import java.util.Map;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.comun.vo.ItemVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.EntidadVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemDatoValidator.
 */
public final class ItemDatoValidator {// srdtMap
    /**
     * Validate.
     *
     * @param support
     *            the support
     * @param entiVO
     *            the enti vo
     * @param itemVO
     *            the item vo
     */
    public static void validate(final BaseAction support, final EntidadVO entiVO, final ItemVO itemVO) {
        if (entiVO.getEntdList() != null) {
            final Map<Long, ItemDatoVO> itdtMap = itemVO.getItdtMap();

            for (final EntidadTipoDatoVO entd : entiVO.getEntdList()) {
                final ItemDatoVO itdtVO = itdtMap == null ? null : itdtMap.get(entd.getTpdt().getId().toString());

                if (entd.getObligatorio() && itdtVO == null) {
                    support.addActionError(support.getText(MessageI18nKey.E00001.name(),
                            new Object[] { entd.getEtiqueta() }));
                }

                if (itdtVO != null) {
                    itdtVO.setTpdtId(entd.getTpdt().getId());
                    switch (entd.getTpdt().getTipoElemento()) {
                    case BO:
                        if (entd.getObligatorio() && itdtVO.getCantidadEntera() == null) {
                            support.addActionError(support.getText(MessageI18nKey.E00001.name(),
                                    new Object[] { entd.getEtiqueta() }));
                        }

                        break;
                    case NE:
                        if (entd.getObligatorio() && itdtVO.getCantidadEntera() == null) {
                            support.addActionError(support.getText(MessageI18nKey.E00001.name(),
                                    new Object[] { entd.getEtiqueta() }));
                        }

                        break;
                    case ND:
                        if (entd.getObligatorio() && itdtVO.getCantidadDecimal() == null) {
                            support.addActionError(support.getText(MessageI18nKey.E00001.name(),
                                    new Object[] { entd.getEtiqueta() }));
                        }

                        break;
                    case PR:
                        if (entd.getObligatorio() && (itdtVO.getPrmt() == null || itdtVO.getPrmt().getId() == null)) {
                            support.addActionError(support.getText(MessageI18nKey.E00001.name(),
                                    new Object[] { entd.getEtiqueta() }));
                        }

                        break;
                    case SR:
                        if (entd.getObligatorio() && (itdtVO.getSrvc() == null || itdtVO.getSrvc().getId() == null)) {
                            support.addActionError(support.getText(MessageI18nKey.E00001.name(),
                                    new Object[] { entd.getEtiqueta() }));
                        }

                        break;
                    case CR:
                    case TX:
                        if (entd.getObligatorio() && (itdtVO.getCadena() == null || itdtVO.getCadena().isEmpty())) {
                            support.addActionError(support.getText(MessageI18nKey.E00001.name(),
                                    new Object[] { entd.getEtiqueta() }));
                        }

                        break;
                    case FE:
                    case FH:
                        if (entd.getObligatorio() && itdtVO.getFecha() == null) {
                            support.addActionError(support.getText(MessageI18nKey.E00001.name(),
                                    new Object[] { entd.getEtiqueta() }));
                        }

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
}
