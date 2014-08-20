package xeredi.integra.model.bo.util.pdf;

import java.awt.Color;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class PdfConstants.
 */
public final class PdfConstants {
    /** The Constant DATE_FORMAT. */
    public static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    /** The Constant DATETIME_FORMAT. */
    public static final DateFormat DATETIME_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    /** The Constant INTEGER_FORMAT. */
    public static final DecimalFormat INTEGER_FORMAT = new DecimalFormat("###,###,##0");

    /** The Constant DOUBLE_FORMAT. */
    public static final DecimalFormat DOUBLE_FORMAT = new DecimalFormat("###,###,##0.00####");

    /** The Constant CURRENCY_FORMAT. */
    public static final DecimalFormat CURRENCY_FORMAT = new DecimalFormat("###,###,##0.00");

    /** The Constant MAX_SPAN. */
    public static final int MAX_SPAN = 12;

    /** The Constant SPAN_SIZE. */
    public static final int SPAN_SIZE = 800 / MAX_SPAN;

    /** The Constant labelStyle. */
    public static final StyleBuilder LABEL_STYLE = DynamicReports.stl.style().setFontSize(9)
            .setBorder(DynamicReports.stl.pen1Point().setLineColor(Color.WHITE)).setBackgroundColor(Color.LIGHT_GRAY)
            .setPadding(3);

    /** The Constant VALUE_STYLE. */
    public static final StyleBuilder VALUE_STYLE = DynamicReports.stl.style().setFontSize(9).setPadding(3);

    /** The Constant TH_STYLE. */
    public static final StyleBuilder TH_STYLE = DynamicReports.stl.style().setFontSize(9)
            .setBorder(DynamicReports.stl.pen1Point().setLineColor(Color.WHITE)).setBackgroundColor(Color.LIGHT_GRAY)
            .setPadding(2);

    /** The Constant TD_STYLE. */
    public static final StyleBuilder TD_STYLE = DynamicReports.stl.style().setFontSize(9).setPadding(2);

    /** The Constant H1_STYLE. */
    public static final StyleBuilder H1_STYLE = DynamicReports.stl.style().setFontSize(14).setTopPadding(10)
            .setBottomPadding(5);

    /** The Constant H2_STYLE. */
    public static final StyleBuilder H2_STYLE = DynamicReports.stl.style().setFontSize(12).setTopPadding(5)
            .setBottomPadding(3);

}
