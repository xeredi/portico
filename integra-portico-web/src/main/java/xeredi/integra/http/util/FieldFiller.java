package xeredi.integra.http.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.annotation.Nonnull;

import xeredi.integra.model.comun.vo.ItemVO;
import xeredi.integra.model.metamodelo.proxy.AbstractEntidadDetailVO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FieldFiller.
 */
public final class FieldFiller {

    /** The Constant DATE_FORMAT. */
    public static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    /** The Constant DATETIME_FORMAT. */
    public static final DateFormat DATETIME_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    /**
     * Fill default values.
     *
     * @param item
     *            the item
     * @param enti
     *            the enti
     */
    public static void fillDefaultValues(final @Nonnull ItemVO item, final @Nonnull AbstractEntidadDetailVO entiDetail) {
        if (entiDetail.getEntdList() != null) {
            for (final EntidadTipoDatoVO entd : entiDetail.getEntdList()) {
                if (entd.getValorDefecto() != null) {
                    switch (entd.getTpdt().getTipoElemento()) {
                    case BO:
                        item.addItdt(entd.getTpdt().getId(), "S".equals(entd.getValorDefecto()) ? 1L : 0L);

                        break;
                    case CR:
                        if (!entd.getTpdt().getCdrfCodeSet().contains(entd.getValorDefecto())) {
                            throw new Error("CR no válido: " + entd.getValorDefecto() + ", validos: "
                                    + entd.getTpdt().getCdrfCodeSet());
                        }

                        item.addItdt(entd.getTpdt().getId(), entd.getValorDefecto());

                        break;
                    case TX:
                        item.addItdt(entd.getTpdt().getId(), entd.getValorDefecto());

                        break;
                    case FE:
                        try {
                            item.addItdt(entd.getTpdt().getId(), DATE_FORMAT.parse(entd.getValorDefecto()));
                        } catch (final ParseException ex) {
                            throw new Error(ex);
                        }

                        break;
                    case FH:
                        try {
                            item.addItdt(entd.getTpdt().getId(), DATETIME_FORMAT.parse(entd.getValorDefecto()));
                        } catch (final ParseException ex) {
                            throw new Error(ex);
                        }

                        break;
                    case ND:
                        item.addItdt(entd.getTpdt().getId(), Double.valueOf(entd.getValorDefecto()));

                        break;
                    case NE:
                        item.addItdt(entd.getTpdt().getId(), Long.valueOf(entd.getValorDefecto()));

                        break;
                    case PR:
                    case SR:
                        throw new Error("No implementado");
                    default:
                        throw new Error("Tipo de elemento desconocido: " + entd.getTpdt().getTipoElemento());
                    }
                }
            }
        }
    }
}
