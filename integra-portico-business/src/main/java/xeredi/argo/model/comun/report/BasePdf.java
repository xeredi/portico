package xeredi.argo.model.comun.report;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import lombok.NonNull;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.component.HorizontalListBuilder;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import xeredi.argo.model.comun.proxy.PorticoResourceBundle;
import xeredi.argo.model.item.vo.ItemDatoVO;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TipoElemento;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class BasePdf.
 */
public abstract class BasePdf {
    /** The Constant DATE_FORMAT. */
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    /** The Constant DATETIME_FORMAT. */
    private static final DateFormat DATETIME_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    /** The Constant INTEGER_FORMAT. */
    private static final DecimalFormat INTEGER_FORMAT = new DecimalFormat("###,###,##0");

    /** The Constant DOUBLE_FORMAT. */
    private static final DecimalFormat DOUBLE_FORMAT = new DecimalFormat("###,###,##0.00####");

    /** The Constant CURRENCY_FORMAT. */
    private static final DecimalFormat CURRENCY_FORMAT = new DecimalFormat("###,###,##0.00");

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
        Preconditions.checkNotNull(entdVO.getTpdt());
        Preconditions.checkNotNull(entdVO.getTpdt().getTipoElemento());

        switch (entdVO.getTpdt().getTipoElemento()) {
        case BO:
            return formatBoolean(itdtVO.getCantidadEntera());

        case TX:
        case CR:
            return itdtVO.getCadena() == null ? "" : itdtVO.getCadena();

        case ND:
            return formatDouble(itdtVO.getCantidadDecimal());

        case NE:
            return formatInteger(itdtVO.getCantidadEntera());

        case FE:
            return formatDate(itdtVO.getFecha());

        case FH:
            return formatDatetime(itdtVO.getFecha());

        case PR:
            return itdtVO.getPrmt() == null ? "" : itdtVO.getPrmt().getEtiqueta();

        case SR:
            return itdtVO.getSrvc() == null ? "" : itdtVO.getSrvc().getEtiqueta();

        default:
            throw new Error("Tipo de dato no soportado: " + entdVO.getTpdt().getTipoElemento());
        }
    }

    /**
     * Gets the form.
     *
     * @param title the title
     * @param listCells            the list cells
     * @return the form
     */
    public final ComponentBuilder<?, ?> getForm(final String title, final @NonNull List<List<PdfCell>> listCells) {
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

        return title == null ? DynamicReports.cmp.verticalList(list) : DynamicReports.cmp.verticalList(
                DynamicReports.cmp.text(title), list);
    }

    /**
     * Gets the form.
     *
     * @param listCells the list cells
     * @return the form
     */
    public final ComponentBuilder<?, ?> getForm(final @NonNull List<List<PdfCell>> listCells) {
        return getForm(null, listCells);
    }

    /**
     * Gets the label.
     *
     * @param pdfCell
     *            the pdf cell
     * @return the label
     */
    public final TextFieldBuilder<String> getFieldLabel(final PdfCell pdfCell) {
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
        final TextFieldBuilder<String> data = DynamicReports.cmp.text(pdfCell.getValue())
                .setFixedWidth(pdfCell.getWidth()).setStyle(PdfConstants.VALUE_STYLE);

        if (pdfCell.getTpel() == TipoElemento.ND || pdfCell.getTpel() == TipoElemento.NE) {
            data.setHorizontalAlignment(HorizontalAlignment.RIGHT);
        }

        return data;
    }

    /**
     * Format date.
     *
     * @param value
     *            the value
     * @return the string
     */
    protected final String formatDate(final Date value) {
        return value == null ? "" : DATE_FORMAT.format(value);
    }

    /**
     * Format datetime.
     *
     * @param value
     *            the value
     * @return the string
     */
    protected final String formatDatetime(final Date value) {
        return value == null ? "" : DATETIME_FORMAT.format(value);
    }

    /**
     * Format integer.
     *
     * @param value
     *            the value
     * @return the string
     */
    protected final String formatInteger(final Number value) {
        return value == null ? "" : INTEGER_FORMAT.format(value);
    }

    /**
     * Format double.
     *
     * @param value
     *            the value
     * @return the string
     */
    protected final String formatDouble(final Double value) {
        return value == null ? "" : DOUBLE_FORMAT.format(value);
    }

    /**
     * Format currency.
     *
     * @param value
     *            the value
     * @return the string
     */
    protected final String formatCurrency(final Double value) {
        return value == null ? "" : CURRENCY_FORMAT.format(value);
    }

    /**
     * Format boolean.
     *
     * @param value
     *            the value
     * @return the string
     */
    protected final String formatBoolean(final Long value) {
        return value == null ? "" : bundle.getString("format_" + (1 == value));
    }
}
