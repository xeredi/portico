package xeredi.argo.model.comun.report;

import java.awt.Color;

import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class PdfConstants.
 */
public final class PdfConstants {

    /**
     * Instantiates a new pdf constants.
     */
    private PdfConstants() {
        super();
    }

    /** The Constant MAX_SPAN. */
    public static final int MAX_SPAN = 12;

    /** The Constant SPAN_SIZE. */
    public static final int SPAN_SIZE = 800 / MAX_SPAN;

    /** The Constant labelStyle. */
    public static final StyleBuilder LABEL_STYLE = DynamicReports.stl.style().setFontSize(9)
            .setBorder(DynamicReports.stl.pen1Point().setLineColor(Color.WHITE)).setBackgroundColor(Color.LIGHT_GRAY)
            .setTopPadding(3).setBottomPadding(3).setLeftPadding(5).setRightPadding(5);

    /** The Constant VALUE_STYLE. */
    public static final StyleBuilder VALUE_STYLE = DynamicReports.stl.style().setFontSize(9).setTopPadding(3)
            .setBottomPadding(3).setLeftPadding(5).setRightPadding(5);

    /** The Constant TH_STYLE. */
    public static final StyleBuilder TH_STYLE = DynamicReports.stl.style().setFontSize(9)
            .setBorder(DynamicReports.stl.pen1Point().setLineColor(Color.WHITE)).setBackgroundColor(Color.LIGHT_GRAY)
            .setTopPadding(2).setBottomPadding(2).setLeftPadding(4).setRightPadding(4);

    /** The Constant TD_STYLE. */
    public static final StyleBuilder TD_STYLE = DynamicReports.stl.style().setFontSize(9).setTopPadding(2)
            .setBottomPadding(2).setLeftPadding(4).setRightPadding(4);

    /** The Constant H1_STYLE. */
    public static final StyleBuilder H1_STYLE = DynamicReports.stl.style().setFontSize(14).setTopPadding(10)
            .setBottomPadding(5);

    /** The Constant H2_STYLE. */
    public static final StyleBuilder H2_STYLE = DynamicReports.stl.style().setFontSize(12).setTopPadding(5)
            .setBottomPadding(3);

}
