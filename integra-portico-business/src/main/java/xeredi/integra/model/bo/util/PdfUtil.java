package xeredi.integra.model.bo.util;

import java.awt.Color;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.component.HorizontalListBuilder;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import xeredi.integra.model.util.GlobalNames;
import xeredi.integra.model.vo.comun.ItemDatoVO;
import xeredi.integra.model.vo.maestro.ParametroVO;
import xeredi.integra.model.vo.maestro.SubparametroVO;
import xeredi.integra.model.vo.metamodelo.EntidadTipoDatoVO;
import xeredi.integra.model.vo.metamodelo.TipoElemento;
import xeredi.integra.model.vo.metamodelo.TipoParametroVO;
import xeredi.integra.model.vo.metamodelo.TipoSubparametroVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class PdfUtil.
 */
public final class PdfUtil {

    /** The Constant DATE_FORMAT. */
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    /** The Constant DATETIME_FORMAT. */
    private static final DateFormat DATETIME_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    /** The Constant INTEGER_FORMAT. */
    private static final DecimalFormat INTEGER_FORMAT = new DecimalFormat("###,###,##0");

    /** The Constant DOUBLE_FORMAT. */
    private static final DecimalFormat DOUBLE_FORMAT = new DecimalFormat("###,###,##0.00####");

    /** The Constant MAX_SPAN. */
    private static final int MAX_SPAN = 12;

    /** The Constant SPAN_SIZE. */
    private static final int SPAN_SIZE = 800 / MAX_SPAN;

    /** The Constant labelStyle. */
    private static final StyleBuilder LABEL_STYLE = DynamicReports.stl.style().setFontSize(9)
            .setBorder(DynamicReports.stl.pen1Point().setLineColor(Color.WHITE)).setBackgroundColor(Color.LIGHT_GRAY)
            .setPadding(3);

    /** The Constant VALUE_STYLE. */
    private static final StyleBuilder VALUE_STYLE = DynamicReports.stl.style().setFontSize(9).setPadding(3);

    /** The Constant TH_STYLE. */
    private static final StyleBuilder TH_STYLE = DynamicReports.stl.style().setFontSize(9)
            .setBorder(DynamicReports.stl.pen1Point().setLineColor(Color.WHITE)).setBackgroundColor(Color.LIGHT_GRAY)
            .setPadding(2);

    /** The Constant TD_STYLE. */
    private static final StyleBuilder TD_STYLE = DynamicReports.stl.style().setFontSize(9).setPadding(2);

    /** The Constant H1_STYLE. */
    private static final StyleBuilder H1_STYLE = DynamicReports.stl.style().setFontSize(14).setTopPadding(20)
            .setBottomPadding(5);

    /** The locale. */
    private final Locale locale;

    /** The bundle. */
    private final ResourceBundle bundle;

    /**
     * Instantiates a new pdf util.
     *
     * @param alocale
     *            the alocale
     */
    public PdfUtil(final Locale alocale) {
        super();
        locale = alocale;
        bundle = ResourceBundle.getBundle(GlobalNames.MESSAGES, locale);
    }

    /**
     * Imprimir.
     *
     * @param prmtVO
     *            the prmt vo
     * @param tpprVO
     *            the tppr vo
     * @param entiHijasMap
     *            the enti hijas map
     * @param itemHijosMap
     *            the item hijos map
     * @param stream
     *            the stream
     * @throws DRException
     *             the DR exception
     */
    public void imprimir(final ParametroVO prmtVO, final TipoParametroVO tpprVO,
            final Map<Long, TipoSubparametroVO> entiHijasMap, final Map<Long, List<SubparametroVO>> itemHijosMap,
            final OutputStream stream) throws DRException {
        Preconditions.checkNotNull(prmtVO);
        Preconditions.checkNotNull(tpprVO);

        final List<List<PdfCell>> listCells = new ArrayList<>();

        List<PdfCell> rowCells = new ArrayList<>();
        int accWidth = 0;

        rowCells.add(new PdfCell(tpprVO.getNombre(), prmtVO.getEtiqueta(), 4, TipoElemento.TX));

        if (tpprVO.isTempExp()) {
            rowCells.add(new PdfCell("F. Inicio", DATE_FORMAT.format(prmtVO.getPrvr().getFinicio()), 4, TipoElemento.FE));
            rowCells.add(new PdfCell("F. Fin", prmtVO.getPrvr().getFfin() == null ? "" : DATE_FORMAT.format(prmtVO
                    .getPrvr().getFfin()), 4, TipoElemento.FE));
        }

        listCells.add(rowCells);
        rowCells = new ArrayList<>();
        accWidth = 0;

        for (final Long tpdtId : tpprVO.getEntdList()) {
            final EntidadTipoDatoVO entdVO = tpprVO.getEntdMap().get(tpdtId);
            final ItemDatoVO itdtVO = prmtVO.getItdtMap().get(tpdtId);

            if (accWidth + entdVO.getSpan() > MAX_SPAN) {
                listCells.add(rowCells);
                rowCells = new ArrayList<>();
                accWidth = 0;
            }

            rowCells.add(new PdfCell(entdVO.getEtiqueta(), getItdtValue(entdVO, itdtVO), entdVO.getSpan(), entdVO
                    .getTpdt().getTipoElemento()));
            accWidth += entdVO.getSpan();
        }

        if (!rowCells.isEmpty()) {
            listCells.add(rowCells);
        }

        HorizontalListBuilder list = DynamicReports.cmp.horizontalList();

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

        final JasperReportBuilder report = DynamicReports.report();

        report.setPageFormat(PageType.A4, PageOrientation.LANDSCAPE);
        report.addTitle(DynamicReports.cmp.text(tpprVO.getNombre()).setStyle(H1_STYLE));
        report.addTitle(list);
        // report.addDetail(list);

        if (tpprVO.getEntiHijasList() != null) {
            for (final Long entiId : tpprVO.getEntiHijasList()) {
                report.addTitle(DynamicReports.cmp.subreport(getSubreport(entiHijasMap.get(entiId),
                        itemHijosMap.get(entiId))));

                // DynamicReports.col.column(entiHijasMap.get(entiId).getEtiqueta(), String.class);
            }
        }

        report.toPdf(stream);
    }

    /**
     * Gets the label.
     *
     * @param pdfCell
     *            the pdf cell
     * @return the label
     */
    private TextFieldBuilder<String> getFieldLabel(final PdfCell pdfCell) {
        final TextFieldBuilder<String> label = DynamicReports.cmp.text(pdfCell.getLabel())
                .setFixedWidth(pdfCell.getWidth()).setStyle(LABEL_STYLE);

        return label;
    }

    /**
     * Gets the data.
     *
     * @param pdfCell
     *            the pdf cell
     * @return the data
     */
    private TextFieldBuilder<String> getFieldValue(final PdfCell pdfCell) {
        final TextFieldBuilder<String> data = DynamicReports.cmp.text(pdfCell.getValue())
                .setFixedWidth(pdfCell.getWidth()).setStyle(VALUE_STYLE);

        return data;
    }

    /**
     * Gets the data source.
     *
     * @param entiVO
     *            the enti vo
     * @param itemList
     *            the item list
     * @return the data source
     */
    private JasperReportBuilder getSubreport(final TipoSubparametroVO entiVO, final List<SubparametroVO> itemList) {
        Preconditions.checkNotNull(entiVO);
        Preconditions.checkNotNull(itemList);

        final JasperReportBuilder report = DynamicReports.report();
        final List<String> columns = new ArrayList<>();

        report.setTemplate(DynamicReports.template());
        report.setColumnTitleStyle(TH_STYLE);
        report.setColumnStyle(TD_STYLE);
        report.addTitle(DynamicReports.cmp.text(entiVO.getNombre()).setStyle(H1_STYLE));

        columns.add(entiVO.getTpprAsociado().getNombre());

        report.addColumn(DynamicReports.col.column(entiVO.getTpprAsociado().getNombre(),
                entiVO.getTpprAsociado().getNombre(), DynamicReports.type.stringType()).setWidth(4));

        if (entiVO.isTempExp()) {
            columns.add("finicio");
            columns.add("ffin");

            report.addColumn(DynamicReports.col.column("F. Inicio", "finicio", DynamicReports.type.stringType())
                    .setWidth(2));
            report.addColumn(DynamicReports.col.column("F. Fin", "ffin", DynamicReports.type.stringType()).setWidth(2));
        }

        if (entiVO.getEntdList() != null) {
            for (final Long tpdtId : entiVO.getEntdList()) {
                final EntidadTipoDatoVO entdVO = entiVO.getEntdMap().get(tpdtId);

                columns.add(entdVO.getEtiqueta());

                report.addColumn(DynamicReports.col.column(entdVO.getEtiqueta(), entdVO.getEtiqueta(),
                        DynamicReports.type.stringType()).setWidth(entdVO.getSpan()));
            }
        }

        final DRDataSource dataSource = new DRDataSource(columns.toArray(new String[] {}));

        for (final SubparametroVO itemVO : itemList) {
            final Object[] objects = new Object[columns.size()];
            int i = 0;

            objects[i++] = itemVO.getPrmtAsociado().getEtiqueta();

            if (entiVO.isTempExp()) {
                objects[i++] = itemVO.getSpvr().getFinicio() == null ? "" : DATE_FORMAT.format(itemVO.getSpvr()
                        .getFinicio());
                objects[i++] = itemVO.getSpvr().getFfin() == null ? "" : DATE_FORMAT.format(itemVO.getSpvr().getFfin());
            }

            if (entiVO.getEntdList() != null) {
                for (final Long tpdtId : entiVO.getEntdList()) {
                    objects[i++] = getItdtValue(entiVO.getEntdMap().get(tpdtId), itemVO.getItdtMap().get(tpdtId));
                }
            }

            dataSource.add(objects);
        }

        report.setDataSource(dataSource);

        return report;
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
    private String getItdtValue(final EntidadTipoDatoVO entdVO, final ItemDatoVO itdtVO) {
        Preconditions.checkNotNull(entdVO);
        Preconditions.checkNotNull(entdVO.getTpdt());
        Preconditions.checkNotNull(entdVO.getTpdt().getTipoElemento());
        Preconditions.checkNotNull(itdtVO);

        String value = "";

        switch (entdVO.getTpdt().getTipoElemento()) {
        case BO:
            value = bundle.getString("boolean."
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
                value = DOUBLE_FORMAT.format(itdtVO.getCantidadDecimal());
            }
            break;
        case NE:
            if (itdtVO.getCantidadEntera() != null) {
                value = INTEGER_FORMAT.format(itdtVO.getCantidadEntera());
            }
            break;
        case FE:
            if (itdtVO.getFecha() != null) {
                value = DATE_FORMAT.format(itdtVO.getFecha());
            }
            break;
        case FH:
            if (itdtVO.getFecha() != null) {
                value = DATETIME_FORMAT.format(itdtVO.getFecha());
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
     * The Class PdfCell.
     */
    class PdfCell {

        /** The label. */
        private final String label;

        /** The value. */
        private final String value;

        /** The span. */
        private final int span;

        /** The tpel. */
        private final TipoElemento tpel;

        /**
         * Instantiates a new pdf cell.
         *
         * @param alabel
         *            the alabel
         * @param avalue
         *            the avalue
         * @param aspan
         *            the aspan
         * @param atpel
         *            the atpel
         */
        public PdfCell(final String alabel, final String avalue, final int aspan, final TipoElemento atpel) {
            super();
            this.label = alabel;
            this.value = avalue;
            this.span = aspan;
            this.tpel = atpel;
        }

        /**
         * Gets the width.
         *
         * @return the width
         */
        public final int getWidth() {
            return span * SPAN_SIZE;
        }

        /**
         * Gets the label.
         *
         * @return the label
         */
        public final String getLabel() {
            return label;
        }

        /**
         * Gets the value.
         *
         * @return the value
         */
        public final String getValue() {
            return value;
        }

        /**
         * Gets the span.
         *
         * @return the span
         */
        public final int getSpan() {
            return span;
        }

        /**
         * Gets the tpel.
         *
         * @return the tpel
         */
        public final TipoElemento getTpel() {
            return tpel;
        }

    }

}
