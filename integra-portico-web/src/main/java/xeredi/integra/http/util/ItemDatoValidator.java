package xeredi.integra.http.util;

import java.util.Map;

import xeredi.integra.model.comun.exception.ErrorCode;
import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.comun.vo.ItemVO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.EntidadVO;

import com.opensymphony.xwork2.ActionSupport;

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
    public static void validate(final ActionSupport support, final EntidadVO entiVO, final ItemVO itemVO) {
        if (entiVO.getEntdMap() != null) {
            final Map<Long, ItemDatoVO> itdtMap = itemVO.getItdtMap();

            for (final EntidadTipoDatoVO entdVO : entiVO.getEntdMap().values()) {
                final Long tpdtId = entdVO.getTpdt().getId();
                final ItemDatoVO itdtVO = itdtMap.get(tpdtId);

                if (entdVO.getObligatorio() && itdtVO == null) {
                    support.addActionError(support.getText(ErrorCode.E00001.name(),
                            new String[] { entdVO.getEtiqueta() }));
                }

                if (itdtVO != null) {
                    itdtVO.setTpdtId(entdVO.getTpdt().getId());
                    switch (entdVO.getTpdt().getTipoElemento()) {
                    case BO:
                    case NE:
                        if (entdVO.getObligatorio() && itdtVO.getCantidadEntera() == null) {
                            support.addActionError(support.getText(ErrorCode.E00001.name(),
                                    new String[] { entdVO.getEtiqueta() }));
                        }

                        break;
                    case ND:
                        if (entdVO.getObligatorio() && itdtVO.getCantidadDecimal() == null) {
                            support.addActionError(support.getText(ErrorCode.E00001.name(),
                                    new String[] { entdVO.getEtiqueta() }));
                        }

                        break;
                    case PR:
                        if (entdVO.getObligatorio() && (itdtVO.getPrmt() == null || itdtVO.getPrmt().getId() == null)) {
                            support.addActionError(support.getText(ErrorCode.E00001.name(),
                                    new String[] { entdVO.getEtiqueta() }));
                        }

                        break;
                    case SR:
                        if (entdVO.getObligatorio() && (itdtVO.getSrvc() == null || itdtVO.getSrvc().getId() == null)) {
                            support.addActionError(support.getText(ErrorCode.E00001.name(),
                                    new String[] { entdVO.getEtiqueta() }));
                        }

                        break;
                    case CR:
                    case TX:
                        if (entdVO.getObligatorio() && (itdtVO.getCadena() == null || itdtVO.getCadena().isEmpty())) {
                            support.addActionError(support.getText(ErrorCode.E00001.name(),
                                    new String[] { entdVO.getEtiqueta() }));
                        }

                        break;
                    case FE:
                    case FH:
                        if (entdVO.getObligatorio() && itdtVO.getFecha() == null) {
                            support.addActionError(support.getText(ErrorCode.E00001.name(),
                                    new String[] { entdVO.getEtiqueta() }));
                        }

                        break;
                    default:
                        throw new Error("Tipo de dato no soportado: " + entdVO.getTpdt().getTipoElemento()
                                + " en la entidad: " + entiVO.getNombre() + " y tipo de dato: "
                                + entdVO.getTpdt().getNombre());
                    }
                }
            }
        }
    }
}
