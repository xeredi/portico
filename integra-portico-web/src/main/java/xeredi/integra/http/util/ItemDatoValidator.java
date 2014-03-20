package xeredi.integra.http.util;

import xeredi.integra.model.vo.comun.ItemDatoVO;
import xeredi.integra.model.vo.comun.ItemVO;
import xeredi.integra.model.vo.metamodelo.EntidadTipoDatoVO;
import xeredi.integra.model.vo.metamodelo.EntidadVO;
import xeredi.util.struts.PropertyValidator;

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
            for (final EntidadTipoDatoVO entdVO : entiVO.getEntdMap().values()) {
                final String fieldname = "itdtMap[" + entdVO.getTpdt().getId() + "]";
                final ItemDatoVO itdtVO = itemVO.getItdtMap().get(entdVO.getTpdt().getId());

                if (entdVO.isObligatorio()) {
                    PropertyValidator.validateRequired(support, fieldname, itdtVO);
                }

                if (itdtVO != null) {
                    itdtVO.setTpdtId(entdVO.getTpdt().getId());
                    switch (entdVO.getTpdt().getTipoElemento()) {
                    case BO:
                        if (entdVO.isObligatorio()) {
                            PropertyValidator.validateRequired(support, entdVO.getEtiqueta(),
                                    itdtVO.getCantidadEntera());
                        }

                        break;
                    case ND:
                        if (entdVO.isObligatorio()) {
                            PropertyValidator.validateRequired(support, entdVO.getEtiqueta(),
                                    itdtVO.getCantidadDecimal());
                        }

                        break;
                    case NE:
                        if (entdVO.isObligatorio()) {
                            PropertyValidator.validateRequired(support, entdVO.getEtiqueta(),
                                    itdtVO.getCantidadEntera());
                        }

                        break;
                    case PR:
                        if (entdVO.isObligatorio()) {
                            PropertyValidator.validateRequired(support, entdVO.getEtiqueta(), itdtVO.getPrmt());
                        }

                        break;
                    case SR:
                        if (entdVO.isObligatorio()) {
                            PropertyValidator.validateRequired(support, entdVO.getEtiqueta(), itdtVO.getSrvc());
                        }

                        break;
                    case CR:
                    case TX:
                        if (entdVO.isObligatorio()) {
                            PropertyValidator.validateRequired(support, entdVO.getEtiqueta(), itdtVO.getCadena());
                        }

                        break;
                    case FE:
                    case FH:
                        if (entdVO.isObligatorio()) {
                            PropertyValidator.validateRequired(support, entdVO.getEtiqueta(), itdtVO.getFecha());
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
