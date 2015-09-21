package xeredi.argo.model.facturacion.report;

import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.group.CustomGroupBuilder;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import xeredi.argo.model.comun.exception.InternalErrorException;
import xeredi.argo.model.comun.proxy.PorticoResourceBundle;
import xeredi.argo.model.comun.report.BasePdf;
import xeredi.argo.model.comun.report.PdfCell;
import xeredi.argo.model.comun.report.PdfConstants;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.vo.ReglaTipo;
import xeredi.argo.model.facturacion.vo.ValoracionCargoVO;
import xeredi.argo.model.facturacion.vo.ValoracionImpuestoVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaVO;
import xeredi.argo.model.facturacion.vo.ValoracionVO;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.metamodelo.vo.TipoElemento;

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
    public void imprimir(final ValoracionVO vlrc, final List<ValoracionCargoVO> vlrgList,
            final List<ValoracionImpuestoVO> vlriList, final List<ValoracionLineaVO> vlrlList, final OutputStream stream)
            throws InternalErrorException {
        Preconditions.checkNotNull(vlrc);
        Preconditions.checkNotNull(vlrgList);
        Preconditions.checkNotNull(vlriList);
        Preconditions.checkNotNull(vlrlList);
        Preconditions.checkNotNull(stream);

        try {
            final JasperReportBuilder report = DynamicReports.report();

            report.setPageFormat(PageType.A4, PageOrientation.PORTRAIT);
            report.pageFooter(DynamicReports.cmp.pageXslashY());

            report.addTitle(DynamicReports.cmp.text(bundle.getString(MessageI18nKey.vlrc.name())).setStyle(
                    PdfConstants.H1_STYLE));

            report.addTitle(DynamicReports.cmp.subreport(getSubreportVlrc(vlrc)), DynamicReports.cmp.verticalGap(20));
            report.addTitle(DynamicReports.cmp.subreport(getSubreportPagador(vlrc.getPagador())),
                    DynamicReports.cmp.verticalGap(20));
            report.addTitle(DynamicReports.cmp.subreport(getSubreportVlrgList(vlrgList)),
                    DynamicReports.cmp.verticalGap(20));
            report.addTitle(DynamicReports.cmp.subreport(getSubreportVlriList(vlriList)),
                    DynamicReports.cmp.verticalGap(20));
            report.addTitle(DynamicReports.cmp.subreport(getSubreportVlrlList(vlrlList)),
                    DynamicReports.cmp.verticalGap(20));

            report.toPdf(stream);
        } catch (final DRException ex) {
            throw new InternalErrorException(ex);
        }
    }

    /**
     * Adds the subreport vlrc.
     *
     * @param vlrc
     *            the vlrc
     * @return the subreport vlrc
     */
    private JasperReportBuilder getSubreportVlrc(final ValoracionVO vlrc) {
        Preconditions.checkNotNull(vlrc);

        final JasperReportBuilder report = DynamicReports.report();

        final List<List<PdfCell>> listCells = new ArrayList<>();

        {
            final List<PdfCell> rowCells = new ArrayList<>();

            rowCells.add(new PdfCell(bundle.getString(MessageI18nKey.vlrc_id.name()), String.valueOf(vlrc.getId()), 1,
                    TipoElemento.TX));
            rowCells.add(new PdfCell(bundle.getString("enti_" + vlrc.getSrvc().getEntiId()), vlrc.getSrvc()
                    .getEtiqueta(), 3, TipoElemento.TX));
            rowCells.add(new PdfCell(bundle.getString(MessageI18nKey.vlrc_fliq.name()), formatDate(vlrc.getFliq()), 1,
                    TipoElemento.FH));

            listCells.add(rowCells);
        }

        {
            final List<PdfCell> rowCells = new ArrayList<>();

            rowCells.add(new PdfCell(bundle.getString(MessageI18nKey.vlrc_importe.name()), formatCurrency(vlrc
                    .getImporte()), 1, TipoElemento.ND));
            rowCells.add(new PdfCell(bundle.getString(MessageI18nKey.vlrc_impuesto.name()), formatCurrency(vlrc
                    .getImpuesto()), 1, TipoElemento.ND));

            listCells.add(rowCells);
        }

        report.addTitle(getForm(listCells));

        return report;
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

        final TextColumnBuilder<String> cargoCol = DynamicReports.col.column(
                bundle.getString(MessageI18nKey.crgo.name()), MessageI18nKey.crgo.name(),
                DynamicReports.type.stringType()).setWidth(10);
        final TextColumnBuilder<BigDecimal> importeCol = DynamicReports.col.column(
                bundle.getString(MessageI18nKey.vlrg_importe.name()), MessageI18nKey.vlrg_importe.name(),
                DynamicReports.type.bigDecimalType()).setWidth(2);

        report.addTitle(DynamicReports.cmp.text(bundle.getString(MessageI18nKey.vlrgList.name())).setStyle(
                PdfConstants.H2_STYLE));
        report.columns(cargoCol, importeCol);
        report.setColumnTitleStyle(PdfConstants.TH_STYLE);
        report.setColumnStyle(PdfConstants.TD_STYLE);

        final DRDataSource dataSource = new DRDataSource(MessageI18nKey.crgo.name(), MessageI18nKey.vlrg_importe.name());

        for (final ValoracionCargoVO vlrg : vlrgList) {
            dataSource.add(vlrg.getCrgo().getEtiqueta(), new BigDecimal(vlrg.getImporte()));
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

        final TextColumnBuilder<String> impuestoCol = DynamicReports.col.column(
                bundle.getString(MessageI18nKey.vlri_impuesto.name()), MessageI18nKey.vlri_impuesto.name(),
                DynamicReports.type.stringType()).setWidth(7);
        final TextColumnBuilder<BigDecimal> porcentajeCol = DynamicReports.col.column(
                bundle.getString(MessageI18nKey.vlri_porcentaje.name()), MessageI18nKey.vlri_porcentaje.name(),
                DynamicReports.type.bigDecimalType()).setWidth(1);
        final TextColumnBuilder<BigDecimal> importeBaseCol = DynamicReports.col.column(
                bundle.getString(MessageI18nKey.vlri_importe_base.name()), MessageI18nKey.vlri_importe_base.name(),
                DynamicReports.type.bigDecimalType()).setWidth(2);
        final TextColumnBuilder<BigDecimal> importeImpuestoCol = DynamicReports.col.column(
                bundle.getString(MessageI18nKey.vlri_importe_impuesto.name()),
                MessageI18nKey.vlri_importe_impuesto.name(), DynamicReports.type.bigDecimalType()).setWidth(2);

        report.addTitle(DynamicReports.cmp.text(bundle.getString(MessageI18nKey.vlriList.name())).setStyle(
                PdfConstants.H2_STYLE));
        report.columns(impuestoCol, porcentajeCol, importeBaseCol, importeImpuestoCol);
        report.setColumnTitleStyle(PdfConstants.TH_STYLE);
        report.setColumnStyle(PdfConstants.TD_STYLE);

        final DRDataSource dataSource = new DRDataSource(MessageI18nKey.vlri_impuesto.name(),
                MessageI18nKey.vlri_porcentaje.name(), MessageI18nKey.vlri_importe_base.name(),
                MessageI18nKey.vlri_importe_impuesto.name());

        for (final ValoracionImpuestoVO vlri : vlriList) {
            dataSource.add(vlri.getImpuesto().getEtiqueta(), new BigDecimal(vlri.getPorcentaje()),
                    new BigDecimal(vlri.getImporteBase()), new BigDecimal(vlri.getImporteImpuesto()));
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

        ValoracionLineaVO vlrlPrecio = null;

        for (final ValoracionLineaVO vlrl : vlrlList) {
            if (vlrl.getRgla().getTipo() == ReglaTipo.T) {
                vlrlPrecio = vlrl;
            }

            if (vlrlPrecio == null) {
                throw new Error("La primera linea ha de ser un precio");
            }
        }

        final JasperReportBuilder report = DynamicReports.report();

        final CustomGroupBuilder vlrlPadreGroup = DynamicReports.grp.group("vlrlPadreId", String.class)
                .headerWithSubtotal();

        final TextColumnBuilder<String> rglaCol = DynamicReports.col.column(
                bundle.getString(MessageI18nKey.rgla.name()), MessageI18nKey.rgla.name(),
                DynamicReports.type.stringType()).setWidth(2);

        final TextColumnBuilder<Double> cuant1Col = DynamicReports.col
                .column(vlrlPrecio.getRgla().getVersion().getEtiqCuant1() == null ? bundle.getString(MessageI18nKey.rgla
                        .name())
                        : vlrlPrecio.getRgla().getVersion().getEtiqCuant1(), MessageI18nKey.vlrl_cuant1.name(),
                        DynamicReports.type.doubleType()).setWidth(1);
        final TextColumnBuilder<Double> cuant2Col = DynamicReports.col.column(
                vlrlPrecio.getRgla().getVersion().getEtiqCuant2() == null ? "" : vlrlPrecio.getRgla().getVersion()
                        .getEtiqCuant2(), MessageI18nKey.vlrl_cuant2.name(), DynamicReports.type.doubleType())
                .setWidth(1);
        final TextColumnBuilder<Double> cuant3Col = DynamicReports.col.column(
                bundle.getString(MessageI18nKey.vlrl_cuant3.name()), MessageI18nKey.vlrl_cuant3.name(),
                DynamicReports.type.doubleType()).setWidth(1);
        final TextColumnBuilder<Double> cuant4Col = DynamicReports.col.column(
                bundle.getString(MessageI18nKey.vlrl_cuant4.name()), MessageI18nKey.vlrl_cuant4.name(),
                DynamicReports.type.doubleType()).setWidth(1);
        final TextColumnBuilder<Double> cuant5Col = DynamicReports.col.column(
                bundle.getString(MessageI18nKey.vlrl_cuant5.name()), MessageI18nKey.vlrl_cuant5.name(),
                DynamicReports.type.doubleType()).setWidth(1);
        final TextColumnBuilder<Double> cuant6Col = DynamicReports.col.column(
                bundle.getString(MessageI18nKey.vlrl_cuant6.name()), MessageI18nKey.vlrl_cuant6.name(),
                DynamicReports.type.doubleType()).setWidth(1);
        final TextColumnBuilder<BigDecimal> importeBaseCol = DynamicReports.col.column(
                bundle.getString(MessageI18nKey.vlrl_importeBase.name()), MessageI18nKey.vlrl_importeBase.name(),
                DynamicReports.type.bigDecimalType()).setWidth(1);
        final TextColumnBuilder<BigDecimal> importeCol = DynamicReports.col.column(
                bundle.getString(MessageI18nKey.vlrl_importe.name()), MessageI18nKey.vlrl_importe.name(),
                DynamicReports.type.bigDecimalType()).setWidth(1);

        report.addTitle(DynamicReports.cmp.text(bundle.getString(MessageI18nKey.vlrlList.name())).setStyle(
                PdfConstants.H2_STYLE));
        report.groupBy(vlrlPadreGroup);
        report.subtotalsAtGroupHeader(vlrlPadreGroup, DynamicReports.sbt.sum(importeCol)).setSubtotalStyle(
                DynamicReports.stl.style().bold());

        report.columns(rglaCol, cuant1Col, cuant2Col, cuant3Col, cuant4Col, cuant5Col, cuant6Col, importeBaseCol,
                importeCol);
        report.setColumnTitleStyle(PdfConstants.TH_STYLE);
        report.setColumnStyle(PdfConstants.TD_STYLE);

        final DRDataSource dataSource = new DRDataSource("vlrlPadreId", MessageI18nKey.rgla.name(),
                MessageI18nKey.vlrl_cuant1.name(), MessageI18nKey.vlrl_cuant2.name(),
                MessageI18nKey.vlrl_cuant3.name(), MessageI18nKey.vlrl_cuant4.name(),
                MessageI18nKey.vlrl_cuant5.name(), MessageI18nKey.vlrl_cuant6.name(),
                MessageI18nKey.vlrl_importeBase.name(), MessageI18nKey.vlrl_importe.name());

        for (final ValoracionLineaVO vlrl : vlrlList) {
            dataSource.add(vlrl.getPadreId().toString(), vlrl.getRgla().getTipo().name() + " - "
                    + vlrl.getRgla().getCodigo(), vlrl.getCuant1(), vlrl.getCuant2(), vlrl.getCuant3(), vlrl
                    .getCuant4(), vlrl.getCuant5(), vlrl.getCuant6(), vlrl.getRgla().getTipo() == ReglaTipo.T ? null
                    : new BigDecimal(vlrl.getImporteBase()), new BigDecimal(vlrl.getImporte()));
        }

        report.setDataSource(dataSource);

        return report;
    }

}
