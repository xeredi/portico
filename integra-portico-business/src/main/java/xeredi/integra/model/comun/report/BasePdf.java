package xeredi.integra.model.comun.report;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.component.HorizontalListBuilder;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import xeredi.integra.model.comun.proxy.PorticoResourceBundle;
import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class BasePdf.
 */
public abstract class BasePdf {
    /** The locale. */
    protected final Locale locale;

    /** The bundle. */
    protected final ResourceBundle bundle;

    /**
     * Instantiates a new pdf util.
     *
     * @param alocale
     *            the alocale
     */
    public BasePdf(final Locale alocale) {
        super();

        Preconditions.checkNotNull(alocale);

        locale = alocale;
        bundle = PorticoResourceBundle.getBundle(locale);
    }

    /**
     * Gets the itdt value.
     *
     * @param entdVO
     *            the entd vo
     * @param itdtVO
     *            the itdt vo
     * @return the itdt value
     */
    public final String getItdtValue(final EntidadTipoDatoVO entdVO, final ItemDatoVO itdtVO) {
        Preconditions.checkNotNull(entdVO);
        Preconditions.checkNotNull(entdVO.getTpdt());
        Preconditions.checkNotNull(entdVO.getTpdt().getTipoElemento());
        Preconditions.checkNotNull(itdtVO);

        String value = "";

        switch (entdVO.getTpdt().getTipoElemento()) {
        case BO:
            value = bundle.getString("format_"
                    + (itdtVO.getCantidadEntera() == null ? false : itdtVO.getCantidadEntera() == 1));
            break;
        case TX:
        case CR:
            if (itdtVO.getCadena() != null) {
                value = itdtVO.getCadena();
            }
            break;
        case ND:
            if (itdtVO.getCantidadDecimal() != null) {
                value = PdfConstants.DOUBLE_FORMAT.format(itdtVO.getCantidadDecimal());
            }
            break;
        case NE:
            if (itdtVO.getCantidadEntera() != null) {
                value = PdfConstants.INTEGER_FORMAT.format(itdtVO.getCantidadEntera());
            }
            break;
        case FE:
            if (itdtVO.getFecha() != null) {
                value = PdfConstants.DATE_FORMAT.format(itdtVO.getFecha());
            }
            break;
        case FH:
            if (itdtVO.getFecha() != null) {
                value = PdfConstants.DATETIME_FORMAT.format(itdtVO.getFecha());
            }
            break;
        case PR:
            if (itdtVO.getPrmt() != null) {
                value = itdtVO.getPrmt().getEtiqueta();
            }
            break;
        case SR:
            if (itdtVO.getSrvc() != null) {
                value = itdtVO.getSrvc().getEtiqueta();
            }
            break;
        default:
            throw new Error("Tipo de dato no soportado: " + entdVO.getTpdt().getTipoElemento());
        }

        return value;
    }

    /**
     * Gets the form.
     *
     * @param listCells
     *            the list cells
     * @return the form
     */
    public final HorizontalListBuilder getForm(final List<List<PdfCell>> listCells) {
        Preconditions.checkNotNull(listCells);

        final HorizontalListBuilder list = DynamicReports.cmp.horizontalList();

        for (final List<PdfCell> row : listCells) {
            for (final PdfCell pdfCell : row) {
                list.add(getFieldLabel(pdfCell));
            }

            list.newRow();

            for (final PdfCell pdfCell : row) {
                list.add(getFieldValue(pdfCell));
            }

            list.newRow();
        }

        return list;
    }

    /**
     * Gets the label.
     *
     * @param pdfCell
     *            the pdf cell
     * @return the label
     */
    public final TextFieldBuilder<String> getFieldLabel(final PdfCell pdfCell) {
        Preconditions.checkNotNull(pdfCell);

        final TextFieldBuilder<String> label = DynamicReports.cmp.text(pdfCell.getLabel())
                .setFixedWidth(pdfCell.getWidth()).setStyle(PdfConstants.LABEL_STYLE);

        return label;
    }

    /**
     * Gets the data.
     *
     * @param pdfCell
     *            the pdf cell
     * @return the data
     */
    public final TextFieldBuilder<String> getFieldValue(final PdfCell pdfCell) {
        Preconditions.checkNotNull(pdfCell);

        final TextFieldBuilder<String> data = DynamicReports.cmp.text(pdfCell.getValue())
                .setFixedWidth(pdfCell.getWidth()).setStyle(PdfConstants.VALUE_STYLE);

        return data;
    }

}
