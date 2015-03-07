package xeredi.integra.model.facturacion.report;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import xeredi.integra.model.comun.exception.InternalErrorException;
import xeredi.integra.model.comun.proxy.PorticoResourceBundle;
import xeredi.integra.model.comun.report.BasePdf;
import xeredi.integra.model.comun.report.PdfCell;
import xeredi.integra.model.comun.report.PdfConstants;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.facturacion.vo.AspectoVO;
import xeredi.integra.model.facturacion.vo.ValoracionCargoVO;
import xeredi.integra.model.facturacion.vo.ValoracionImpuestoVO;
import xeredi.integra.model.facturacion.vo.ValoracionLineaVO;
import xeredi.integra.model.facturacion.vo.ValoracionVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.vo.TipoElemento;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionPdf.
 */
public final class ValoracionPdf extends BasePdf {

    /** The bundle. */
    private final ResourceBundle bundle;

    /**
     * The Constructor.
     *
     * @param alocale
     *            the alocale
     */
    public ValoracionPdf(final Locale alocale) {
        super(alocale);

        bundle = PorticoResourceBundle.getBundle(locale);
    }

    /**
     * Imprimir.
     *
     * @param aspc
     *            the aspc
     * @param vlrc
     *            the vlrc
     * @param vlrgList
     *            the vlrg list
     * @param vlriList
     *            the vlri list
     * @param vlrlList
     *            the vlrl list
     * @param stream
     *            the stream
     * @throws InternalErrorException
     *             the internal error exception
     */
    public void imprimir(final AspectoVO aspc, final ValoracionVO vlrc, final List<ValoracionCargoVO> vlrgList,
            final List<ValoracionImpuestoVO> vlriList, final List<ValoracionLineaVO> vlrlList, final OutputStream stream)
            throws InternalErrorException {
        Preconditions.checkNotNull(aspc);
        Preconditions.checkNotNull(vlrc);
        Preconditions.checkNotNull(vlrgList);
        Preconditions.checkNotNull(vlriList);
        Preconditions.checkNotNull(vlrlList);
        Preconditions.checkNotNull(stream);

        try {
            final JasperReportBuilder report = DynamicReports.report();

            report.setPageFormat(PageType.A4, PageOrientation.PORTRAIT);
            report.addTitle(DynamicReports.cmp.text(bundle.getString(MessageI18nKey.vlrc.name())).setStyle(
                    PdfConstants.H1_STYLE));

            final List<List<PdfCell>> listCells = new ArrayList<>();

            {
                final List<PdfCell> rowCells = new ArrayList<>();

                rowCells.add(new PdfCell(bundle.getString(MessageI18nKey.vlrc_id.name()), String.valueOf(vlrc.getId()),
                        1, TipoElemento.TX));
                rowCells.add(new PdfCell(bundle.getString("enti_" + aspc.getTpsr().getId()), vlrc.getSrvc()
                        .getEtiqueta(), 3, TipoElemento.TX));
                rowCells.add(new PdfCell(bundle.getString(MessageI18nKey.vlrc_fliq.name()), PdfConstants.DATE_FORMAT
                        .format(vlrc.getFliq()), 1, TipoElemento.FH));

                listCells.add(rowCells);
            }

            {
                final List<PdfCell> rowCells = new ArrayList<>();

                rowCells.add(new PdfCell(bundle.getString(MessageI18nKey.vlrc_importe.name()),
                        PdfConstants.CURRENCY_FORMAT.format(vlrc.getImporte()), 1, TipoElemento.ND));
                rowCells.add(new PdfCell(bundle.getString(MessageI18nKey.vlrc_impuesto.name()),
                        PdfConstants.CURRENCY_FORMAT.format(vlrc.getImpuesto()), 1, TipoElemento.ND));

                listCells.add(rowCells);
            }

            report.addTitle(getForm(listCells));
            listCells.clear();

            report.addTitle(DynamicReports.cmp.subreport(getSubreportPagador(vlrc.getPagador())));
            report.addTitle(DynamicReports.cmp.subreport(getSubreportVlrgList(vlrgList)));
            report.addTitle(DynamicReports.cmp.subreport(getSubreportVlriList(vlriList)));
            report.addTitle(DynamicReports.cmp.subreport(getSubreportVlrlList(vlrlList)));

            report.toPdf(stream);
        } catch (final DRException ex) {
            throw new InternalErrorException(ex);
        }
    }

    /**
     * Gets the subreport.
     *
     * @param pagador
     *            the pagador
     * @return the subreport
     */
    private JasperReportBuilder getSubreportPagador(final ParametroVO pagador) {
        Preconditions.checkNotNull(pagador);

        final JasperReportBuilder report = DynamicReports.report();

        report.setTemplate(DynamicReports.template());
        report.addTitle(DynamicReports.cmp.text(bundle.getString(MessageI18nKey.vlrc_pagador.name())).setStyle(
                PdfConstants.H2_STYLE));

        final List<List<PdfCell>> listCells = new ArrayList<>();

        {
            final List<PdfCell> rowCells = new ArrayList<>();

            rowCells.add(new PdfCell(bundle.getString(MessageI18nKey.prmn_codigo.name()), String.valueOf(pagador
                    .getParametro()), 1, TipoElemento.TX));

            listCells.add(rowCells);
        }

        report.addTitle(getForm(listCells));

        return report;
    }

    /**
     * Gets the subreport vlrg list.
     *
     * @param vlrgList
     *            the vlrg list
     * @return the subreport vlrg list
     */
    private JasperReportBuilder getSubreportVlrgList(final List<ValoracionCargoVO> vlrgList) {
        Preconditions.checkNotNull(vlrgList);

        final JasperReportBuilder report = DynamicReports.report();
        final List<String> columns = new ArrayList<>();

        report.setTemplate(DynamicReports.template());
        report.addTitle(DynamicReports.cmp.text(bundle.getString(MessageI18nKey.vlrgList.name())).setStyle(
                PdfConstants.H2_STYLE));
        report.setColumnTitleStyle(PdfConstants.TH_STYLE);
        report.setColumnStyle(PdfConstants.TD_STYLE);

        columns.add(MessageI18nKey.vlrg_crgo.name());
        columns.add(MessageI18nKey.vlrg_importe.name());

        report.addColumn(DynamicReports.col.column(bundle.getString(MessageI18nKey.vlrg_crgo.name()),
                MessageI18nKey.vlrg_crgo.name(), DynamicReports.type.stringType()).setWidth(11));
        report.addColumn(DynamicReports.col
                .column(bundle.getString(MessageI18nKey.vlrg_importe.name()), MessageI18nKey.vlrg_importe.name(),
                        DynamicReports.type.stringType()).setWidth(1).setHorizontalAlignment(HorizontalAlignment.RIGHT));

        final DRDataSource dataSource = new DRDataSource(columns.toArray(new String[] {}));

        for (final ValoracionCargoVO vlrg : vlrgList) {
            final Object[] objects = new Object[columns.size()];
            int i = 0;

            objects[i++] = vlrg.getCrgo().getEtiqueta();
            objects[i++] = PdfConstants.CURRENCY_FORMAT.format(vlrg.getImporte());

            dataSource.add(objects);
        }

        report.setDataSource(dataSource);

        return report;
    }

    /**
     * Gets the subreport vlri list.
     *
     * @param vlriList
     *            the vlri list
     * @return the subreport vlri list
     */
    private JasperReportBuilder getSubreportVlriList(final List<ValoracionImpuestoVO> vlriList) {
        Preconditions.checkNotNull(vlriList);

        final JasperReportBuilder report = DynamicReports.report();
        final List<String> columns = new ArrayList<>();

        report.setTemplate(DynamicReports.template());
        report.addTitle(DynamicReports.cmp.text(bundle.getString(MessageI18nKey.vlriList.name())).setStyle(
                PdfConstants.H2_STYLE));
        report.setColumnTitleStyle(PdfConstants.TH_STYLE);
        report.setColumnStyle(PdfConstants.TD_STYLE);

        columns.add(MessageI18nKey.vlri_impuesto.name());
        columns.add(MessageI18nKey.vlri_porcentaje.name());
        columns.add(MessageI18nKey.vlri_importe_base.name());
        columns.add(MessageI18nKey.vlri_importe_impuesto.name());

        report.addColumn(DynamicReports.col.column(bundle.getString(MessageI18nKey.vlri_impuesto.name()),
                MessageI18nKey.vlri_impuesto.name(), DynamicReports.type.stringType()).setWidth(9));
        report.addColumn(DynamicReports.col
                .column(bundle.getString(MessageI18nKey.vlri_porcentaje.name()), MessageI18nKey.vlri_porcentaje.name(),
                        DynamicReports.type.stringType()).setWidth(1).setHorizontalAlignment(HorizontalAlignment.RIGHT));
        report.addColumn(DynamicReports.col
                .column(bundle.getString(MessageI18nKey.vlri_importe_base.name()),
                        MessageI18nKey.vlri_importe_base.name(), DynamicReports.type.stringType()).setWidth(1)
                .setHorizontalAlignment(HorizontalAlignment.RIGHT));
        report.addColumn(DynamicReports.col
                .column(bundle.getString(MessageI18nKey.vlri_importe_impuesto.name()),
                        MessageI18nKey.vlri_importe_impuesto.name(), DynamicReports.type.stringType()).setWidth(1)
                .setHorizontalAlignment(HorizontalAlignment.RIGHT));

        final DRDataSource dataSource = new DRDataSource(columns.toArray(new String[] {}));

        for (final ValoracionImpuestoVO vlri : vlriList) {
            final Object[] objects = new Object[columns.size()];
            int i = 0;

            objects[i++] = vlri.getImpuesto().getEtiqueta();
            objects[i++] = PdfConstants.DOUBLE_FORMAT.format(vlri.getPorcentaje());
            objects[i++] = PdfConstants.CURRENCY_FORMAT.format(vlri.getImporteBase());
            objects[i++] = PdfConstants.CURRENCY_FORMAT.format(vlri.getImporteImpuesto());

            dataSource.add(objects);
        }

        report.setDataSource(dataSource);

        return report;
    }

    /**
     * Gets the subreport vlrl list.
     *
     * @param vlrlList
     *            the vlrl list
     * @return the subreport vlrl list
     */
    private JasperReportBuilder getSubreportVlrlList(final List<ValoracionLineaVO> vlrlList) {
        Preconditions.checkNotNull(vlrlList);

        final JasperReportBuilder report = DynamicReports.report();

        report.setTemplate(DynamicReports.template());
        report.addTitle(DynamicReports.cmp.text(bundle.getString(MessageI18nKey.vlrlList.name())).setStyle(
                PdfConstants.H2_STYLE));

        final List<List<PdfCell>> listCells = new ArrayList<>();

        report.addTitle(getForm(listCells));

        return report;
    }

}
