package xeredi.argo.model.facturacion.report;

import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import lombok.NonNull;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.component.MultiPageListBuilder;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.constant.SplitType;
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
import xeredi.argo.model.metamodelo.vo.TipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TipoElemento;

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
    public ValoracionPdf(final @NonNull Locale alocale) {
        super(alocale);

        bundle = PorticoResourceBundle.getBundle(locale);
    }

    /**
     * Imprimir.
     *
     * @param vlrc
     *            the vlrc
     * @param tpdtCodExencion
     *            the tpdt cod exencion
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
    public void imprimir(final @NonNull ValoracionVO vlrc, final @NonNull TipoDatoVO tpdtCodExencion,
            final @NonNull List<ValoracionCargoVO> vlrgList, final @NonNull List<ValoracionImpuestoVO> vlriList,
            final @NonNull List<ValoracionLineaVO> vlrlList, final @NonNull OutputStream stream)
                    throws InternalErrorException {
        try {
            final JasperReportBuilder report = DynamicReports.report();

            report.setPageFormat(PageType.A4, PageOrientation.LANDSCAPE);
            report.pageFooter(DynamicReports.cmp.pageXslashY());

            {
                final List<ValoracionLineaVO> vlrlPrecioList = new ArrayList<>();
                final Map<Long, List<ValoracionLineaVO>> vlrlMap = new HashMap<>();

                for (final ValoracionLineaVO vlrl : vlrlList) {
                    if (vlrl.getRgla().getTipo() == ReglaTipo.T) {
                        vlrlPrecioList.add(vlrl);
                        vlrlMap.put(vlrl.getId(), new ArrayList<ValoracionLineaVO>());
                    } else {
                        vlrlMap.get(vlrl.getPadreId()).add(vlrl);
                    }
                }

                final Iterator<ValoracionLineaVO> vlrlPrecioIterator = vlrlPrecioList.iterator();
                final MultiPageListBuilder list = DynamicReports.cmp.multiPageList();

                while (vlrlPrecioIterator.hasNext()) {
                    final ValoracionLineaVO vlrlPrecio = vlrlPrecioIterator.next();

                    list.add(
                            DynamicReports.cmp.subreport(getSubreportVlrl(vlrlPrecio, vlrlMap.get(vlrlPrecio.getId()))),
                            DynamicReports.cmp.verticalGap(15));
                }

                report.title(
                        DynamicReports.cmp.text(bundle.getString(MessageI18nKey.vlrc.name())).setStyle(
                                PdfConstants.H1_STYLE), getSubreportVlrc(vlrc, tpdtCodExencion),
                                DynamicReports.cmp.verticalGap(20), getSubreportPagador(vlrc.getPagador()),
                                DynamicReports.cmp.verticalGap(20),
                                DynamicReports.cmp.subreport(getSubreportVlrgList(vlrgList)),
                                DynamicReports.cmp.verticalGap(20),
                                DynamicReports.cmp.subreport(getSubreportVlriList(vlriList)),
                                DynamicReports.cmp.verticalGap(20))
                                .setTitleSplitType(SplitType.PREVENT)
                                .summary(
                                        DynamicReports.cmp.text(bundle.getString(MessageI18nKey.vlrlList.name())).setStyle(
                                                PdfConstants.H2_STYLE), list).setSummarySplitType(SplitType.PREVENT);
            }

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
     * @param tpdtCodExencion
     *            the tpdt cod exencion
     * @return the subreport vlrc
     */
    private ComponentBuilder<?, ?> getSubreportVlrc(final @NonNull ValoracionVO vlrc,
            final @NonNull TipoDatoVO tpdtCodExencion) {
        final List<List<PdfCell>> listCells = new ArrayList<>();

        {
            final List<PdfCell> rowCells = new ArrayList<>();

            rowCells.add(new PdfCell(bundle.getString(MessageI18nKey.vlrc_id.name()), String.valueOf(vlrc.getId()), 1,
                    TipoElemento.TX));
            rowCells.add(new PdfCell(bundle.getString("enti_" + vlrc.getSrvc().getEntiId()), vlrc.getSrvc()
                    .getEtiqueta(), 3, TipoElemento.TX));
            rowCells.add(new PdfCell(bundle.getString(MessageI18nKey.vlrc_fliq.name()), formatDate(vlrc.getFliq()), 1,
                    TipoElemento.FH));
            rowCells.add(new PdfCell(bundle.getString(MessageI18nKey.aspc.name()), vlrc.getAspc().getEtiqueta(), 3,
                    TipoElemento.TX));

            listCells.add(rowCells);
        }

        {
            final List<PdfCell> rowCells = new ArrayList<>();

            rowCells.add(new PdfCell(bundle.getString(MessageI18nKey.vlrc_importe.name()), formatCurrency(vlrc
                    .getImporte()), 1, TipoElemento.ND));
            rowCells.add(new PdfCell(bundle.getString(MessageI18nKey.vlrc_impuesto.name()), formatCurrency(vlrc
                    .getImpuesto()), 1, TipoElemento.ND));
            rowCells.add(new PdfCell(bundle.getString("tpdt_" + tpdtCodExencion.getId()), bundle.getString("cdrf_"
                    + tpdtCodExencion.getId() + "_" + vlrc.getCodExencion()), 2, TipoElemento.TX));

            listCells.add(rowCells);
        }

        {
            final List<PdfCell> rowCells = new ArrayList<>();

            rowCells.add(new PdfCell(bundle.getString(MessageI18nKey.vlrc_pagador.name()), vlrc.getPagador()
                    .getEtiqueta(), 3, TipoElemento.TX));
            rowCells.add(new PdfCell(bundle.getString(MessageI18nKey.vlrc_sujPasivo.name()), vlrc.getSujPasivo() ? "1"
                    : "0", 1, TipoElemento.BO));
            rowCells.add(new PdfCell(bundle.getString(MessageI18nKey.vlrc_falta.name()),
                    formatDatetime(vlrc.getFalta()), 2, TipoElemento.FH));
            rowCells.add(new PdfCell(bundle.getString(MessageI18nKey.vlrc_fliq.name()), formatDate(vlrc.getFliq()), 1,
                    TipoElemento.FE));
            rowCells.add(new PdfCell(bundle.getString(MessageI18nKey.fref.name()), formatDatetime(vlrc.getFref()), 2,
                    TipoElemento.FH));

            listCells.add(rowCells);
        }

        {
            final List<PdfCell> rowCells = new ArrayList<>();

            if (vlrc.getAspc().getVersion().getCetiqInfo1() != null) {
                rowCells.add(new PdfCell(vlrc.getAspc().getVersion().getCetiqInfo1(), vlrc.getInfo1(), 4,
                        TipoElemento.TX));
            }
            if (vlrc.getAspc().getVersion().getCetiqInfo2() != null) {
                rowCells.add(new PdfCell(vlrc.getAspc().getVersion().getCetiqInfo2(), vlrc.getInfo2(), 4,
                        TipoElemento.TX));
            }
            if (vlrc.getAspc().getVersion().getCetiqInfo3() != null) {
                rowCells.add(new PdfCell(vlrc.getAspc().getVersion().getCetiqInfo3(), vlrc.getInfo3(), 4,
                        TipoElemento.TX));
            }
            if (vlrc.getAspc().getVersion().getCetiqInfo4() != null) {
                rowCells.add(new PdfCell(vlrc.getAspc().getVersion().getCetiqInfo4(), vlrc.getInfo4(), 4,
                        TipoElemento.TX));
            }
            if (vlrc.getAspc().getVersion().getCetiqInfo5() != null) {
                rowCells.add(new PdfCell(vlrc.getAspc().getVersion().getCetiqInfo5(), vlrc.getInfo5(), 4,
                        TipoElemento.TX));
            }
            if (vlrc.getAspc().getVersion().getCetiqInfo6() != null) {
                rowCells.add(new PdfCell(vlrc.getAspc().getVersion().getCetiqInfo6(), vlrc.getInfo6(), 4,
                        TipoElemento.TX));
            }

            listCells.add(rowCells);
        }

        return getForm(bundle.getString(MessageI18nKey.vlrc.name()), listCells);
    }

    /**
     * Gets the subreport.
     *
     * @param pagador
     *            the pagador
     * @return the subreport
     */
    private ComponentBuilder<?, ?> getSubreportPagador(final @NonNull ParametroVO pagador) {
        final List<List<PdfCell>> listCells = new ArrayList<>();

        {
            final List<PdfCell> rowCells = new ArrayList<>();

            rowCells.add(new PdfCell(bundle.getString(MessageI18nKey.prmn_codigo.name()), String.valueOf(pagador
                    .getParametro()), 1, TipoElemento.TX));

            listCells.add(rowCells);
        }

        return getForm(bundle.getString(MessageI18nKey.vlrc_pagador.name()), listCells);
    }

    /**
     * Gets the subreport vlrg list.
     *
     * @param vlrgList
     *            the vlrg list
     * @return the subreport vlrg list
     */
    private JasperReportBuilder getSubreportVlrgList(final @NonNull List<ValoracionCargoVO> vlrgList) {
        final JasperReportBuilder report = DynamicReports.report();

        final TextColumnBuilder<String> cargoCol = DynamicReports.col.column(
                bundle.getString(MessageI18nKey.crgo.name()), MessageI18nKey.crgo.name(),
                DynamicReports.type.stringType()).setWidth(10);
        final TextColumnBuilder<BigDecimal> importeCol = DynamicReports.col.column(
                bundle.getString(MessageI18nKey.vlrg_importe.name()), MessageI18nKey.vlrg_importe.name(),
                DynamicReports.type.bigDecimalType()).setWidth(2);

        report.title(DynamicReports.cmp.text(bundle.getString(MessageI18nKey.vlrgList.name())).setStyle(
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
    private JasperReportBuilder getSubreportVlriList(final @NonNull List<ValoracionImpuestoVO> vlriList) {
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

        report.title(DynamicReports.cmp.text(bundle.getString(MessageI18nKey.vlriList.name())).setStyle(
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
     * Gets the subreport vlrl info.
     *
     * @param vlrlPrecio
     *            the vlrl precio
     * @return the subreport vlrl info
     */
    private ComponentBuilder<?, ?> getSubreportVlrlInfo(final @NonNull ValoracionLineaVO vlrlPrecio) {
        final List<List<PdfCell>> listCells = new ArrayList<>();

        {
            final List<PdfCell> rowCells = new ArrayList<>();

            rowCells.add(new PdfCell(bundle.getString(MessageI18nKey.crgo.name()), vlrlPrecio.getRgla().getCrgo()
                    .getEtiqueta(), 4, TipoElemento.TX));
            rowCells.add(new PdfCell(bundle.getString(MessageI18nKey.enti.name()), bundle.getString("enti_"
                    + vlrlPrecio.getRgla().getEnti().getId()), 4, TipoElemento.TX));
            rowCells.add(new PdfCell(bundle.getString(MessageI18nKey.vlrl_subtotal.name()), formatCurrency(vlrlPrecio
                    .getSubtotal()), 2, TipoElemento.ND));
            rowCells.add(new PdfCell(bundle.getString(MessageI18nKey.vlrl_impuesto.name()), vlrlPrecio.getImpuesto()
                    .getEtiqueta(), 2, TipoElemento.TX));

            listCells.add(rowCells);
        }

        {
            final List<PdfCell> rowCells = new ArrayList<>();

            if (vlrlPrecio.getRgla().getVersion().getEtiqInfo1() != null) {
                rowCells.add(new PdfCell(vlrlPrecio.getRgla().getVersion().getEtiqInfo1(), vlrlPrecio.getInfo1(), 4,
                        TipoElemento.TX));
            }
            if (vlrlPrecio.getRgla().getVersion().getEtiqInfo2() != null) {
                rowCells.add(new PdfCell(vlrlPrecio.getRgla().getVersion().getEtiqInfo2(), vlrlPrecio.getInfo2(), 4,
                        TipoElemento.TX));
            }
            if (vlrlPrecio.getRgla().getVersion().getEtiqInfo3() != null) {
                rowCells.add(new PdfCell(vlrlPrecio.getRgla().getVersion().getEtiqInfo3(), vlrlPrecio.getInfo3(), 4,
                        TipoElemento.TX));
            }

            if (!rowCells.isEmpty()) {
                listCells.add(rowCells);
            }
        }

        {
            final List<PdfCell> rowCells = new ArrayList<>();

            if (vlrlPrecio.getRgla().getVersion().getEtiqInfo4() != null) {
                rowCells.add(new PdfCell(vlrlPrecio.getRgla().getVersion().getEtiqInfo4(), vlrlPrecio.getInfo4(), 4,
                        TipoElemento.TX));
            }
            if (vlrlPrecio.getRgla().getVersion().getEtiqInfo5() != null) {
                rowCells.add(new PdfCell(vlrlPrecio.getRgla().getVersion().getEtiqInfo5(), vlrlPrecio.getInfo5(), 4,
                        TipoElemento.TX));
            }
            if (vlrlPrecio.getRgla().getVersion().getEtiqInfo6() != null) {
                rowCells.add(new PdfCell(vlrlPrecio.getRgla().getVersion().getEtiqInfo6(), vlrlPrecio.getInfo6(), 4,
                        TipoElemento.TX));
            }

            if (!rowCells.isEmpty()) {
                listCells.add(rowCells);
            }
        }

        return getForm(listCells);
    }

    /**
     * Gets the subreport vlrl.
     *
     * @param vlrlPrecio
     *            the vlrl precio
     * @param vlrlList
     *            the vlrl list
     * @return the subreport vlrl
     */
    private JasperReportBuilder getSubreportVlrl(final @NonNull ValoracionLineaVO vlrlPrecio,
            final @NonNull List<ValoracionLineaVO> vlrlList) {
        final JasperReportBuilder report = DynamicReports.report();

        final TextColumnBuilder<String> rglaCol = DynamicReports.col.column(
                bundle.getString(MessageI18nKey.rgla.name()), MessageI18nKey.rgla.name(),
                DynamicReports.type.stringType()).setWidth(3);

        final TextColumnBuilder<Double> cuant1Col = DynamicReports.col.column(
                vlrlPrecio.getRgla().getVersion().getEtiqCuant1() == null ? "" : vlrlPrecio.getRgla().getVersion()
                        .getEtiqCuant1(), MessageI18nKey.vlrl_cuant1.name(), DynamicReports.type.doubleType())
                        .setWidth(1);
        final TextColumnBuilder<Double> cuant2Col = DynamicReports.col.column(
                vlrlPrecio.getRgla().getVersion().getEtiqCuant2() == null ? "" : vlrlPrecio.getRgla().getVersion()
                        .getEtiqCuant2(), MessageI18nKey.vlrl_cuant2.name(), DynamicReports.type.doubleType())
                        .setWidth(1);
        final TextColumnBuilder<Double> cuant3Col = DynamicReports.col.column(
                vlrlPrecio.getRgla().getVersion().getEtiqCuant3() == null ? "" : vlrlPrecio.getRgla().getVersion()
                        .getEtiqCuant3(), MessageI18nKey.vlrl_cuant3.name(), DynamicReports.type.doubleType())
                        .setWidth(1);
        final TextColumnBuilder<Double> cuant4Col = DynamicReports.col.column(
                vlrlPrecio.getRgla().getVersion().getEtiqCuant4() == null ? "" : vlrlPrecio.getRgla().getVersion()
                        .getEtiqCuant4(), MessageI18nKey.vlrl_cuant4.name(), DynamicReports.type.doubleType())
                        .setWidth(1);
        final TextColumnBuilder<Double> cuant5Col = DynamicReports.col.column(
                vlrlPrecio.getRgla().getVersion().getEtiqCuant5() == null ? "" : vlrlPrecio.getRgla().getVersion()
                        .getEtiqCuant5(), MessageI18nKey.vlrl_cuant5.name(), DynamicReports.type.doubleType())
                        .setWidth(1);
        final TextColumnBuilder<Double> cuant6Col = DynamicReports.col.column(
                vlrlPrecio.getRgla().getVersion().getEtiqCuant6() == null ? "" : vlrlPrecio.getRgla().getVersion()
                        .getEtiqCuant6(), MessageI18nKey.vlrl_cuant6.name(), DynamicReports.type.doubleType())
                        .setWidth(1);

        final TextColumnBuilder<BigDecimal> importeBaseCol = DynamicReports.col.column(
                bundle.getString(MessageI18nKey.vlrl_importeBase.name()), MessageI18nKey.vlrl_importeBase.name(),
                DynamicReports.type.bigDecimalType()).setWidth(1);
        final TextColumnBuilder<BigDecimal> importeCol = DynamicReports.col.column(
                bundle.getString(MessageI18nKey.vlrl_importe.name()), MessageI18nKey.vlrl_importe.name(),
                DynamicReports.type.bigDecimalType()).setWidth(1);

        report.title(getSubreportVlrlInfo(vlrlPrecio));
        report.columns(rglaCol, cuant1Col, cuant2Col, cuant3Col, cuant4Col, cuant5Col, cuant6Col, importeBaseCol,
                importeCol);

        report.setColumnTitleStyle(PdfConstants.TH_STYLE);
        report.setColumnStyle(PdfConstants.TD_STYLE);

        final DRDataSource dataSource = new DRDataSource(MessageI18nKey.rgla.name(), MessageI18nKey.vlrl_cuant1.name(),
                MessageI18nKey.vlrl_cuant2.name(), MessageI18nKey.vlrl_cuant3.name(),
                MessageI18nKey.vlrl_cuant4.name(), MessageI18nKey.vlrl_cuant5.name(),
                MessageI18nKey.vlrl_cuant6.name(), MessageI18nKey.vlrl_importeBase.name(),
                MessageI18nKey.vlrl_importe.name());

        dataSource.add(vlrlPrecio.getRgla().getTipo().name() + " - " + vlrlPrecio.getRgla().getTexto(),
                vlrlPrecio.getCuant1(), vlrlPrecio.getCuant2(), vlrlPrecio.getCuant3(), vlrlPrecio.getCuant4(),
                vlrlPrecio.getCuant5(), vlrlPrecio.getCuant6(), null, new BigDecimal(vlrlPrecio.getImporte()));

        for (final ValoracionLineaVO vlrl : vlrlList) {
            dataSource.add(vlrl.getRgla().getTipo().name() + " - " + vlrl.getRgla().getTexto(), vlrl.getCuant1(),
                    vlrl.getCuant2(), vlrl.getCuant3(), vlrl.getCuant4(), vlrl.getCuant5(), vlrl.getCuant6(),
                    new BigDecimal(vlrl.getImporteBase()), new BigDecimal(vlrl.getImporte()));
        }

        report.setDataSource(dataSource);

        return report;
    }
}
