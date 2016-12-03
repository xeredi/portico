package xeredi.argo.model.facturacion.report;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import lombok.NonNull;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.component.HorizontalListBuilder;
import net.sf.dynamicreports.report.builder.component.ImageBuilder;
import net.sf.dynamicreports.report.builder.component.MultiPageListBuilder;
import net.sf.dynamicreports.report.builder.component.VerticalListBuilder;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.exception.DRException;
import xeredi.argo.model.comun.exception.InternalErrorException;
import xeredi.argo.model.comun.report.BasePdf;
import xeredi.argo.model.facturacion.bo.FacturaImpresionVO;
import xeredi.argo.model.facturacion.vo.FacturaVO;
import xeredi.argo.model.facturacion.vo.ReglaTipo;
import xeredi.argo.model.facturacion.vo.ValoracionImpuestoVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaVO;
import xeredi.argo.model.facturacion.vo.ValoracionVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaPdf.
 */
public final class FacturaPdf extends BasePdf {

    /** The Constant LOGO. */
    private static final ImageBuilder LOGO = DynamicReports.cmp.image("/temp/LogoAP.png");

    /** The Constant FIRMA. */
    private static final ImageBuilder FIRMA = DynamicReports.cmp.image("/temp/FirmaAP.png");

    /**
     * Instantiates a new factura pdf.
     *
     * @param alocale
     *            the alocale
     */
    public FacturaPdf(final Locale alocale) {
        super(alocale);
    }

    /**
     * Imprimir.
     *
     * @param vo
     *            the vo
     * @param os
     *            the os
     * @throws InternalErrorException
     *             the internal error exception
     */
    public void imprimir(final FacturaImpresionVO vo, final OutputStream os) throws InternalErrorException {
        Preconditions.checkNotNull(vo);
        Preconditions.checkNotNull(os);

        try {
            final JasperReportBuilder report = DynamicReports.report();

            report.setPageFormat(PageType.A4);
            report.pageHeader(LOGO);
            report.pageFooter(DynamicReports.cmp.pageXofY());
            // report.setVirtualizer(new JRFileVirtualizer(2));

            final MultiPageListBuilder builder = DynamicReports.cmp.multiPageList();

            builder.add(createCabeceraComponent(vo.getFctr()));
            builder.add(DynamicReports.cmp.horizontalList(
                    DynamicReports.cmp.verticalList(createImportesComponent(vo), FIRMA),
                    createDatosPagadorComponent(vo.getFctr())));
            builder.add(createServiciosComponent(vo.getVlrcMap()));
            // builder.add(createInfoCabeceraComponent(vo.getFctr()));

            ValoracionLineaVO vlrlPrec = null;
            List<ValoracionLineaVO> vlrlMods = null;

            for (final ValoracionLineaVO vlrl : vo.getVlrlList()) {
                if (vlrl.getRgla().getTipo() == ReglaTipo.T) {
                    if (vlrlPrec != null) {
                        // builder.add(createInfoLineasComponent(vlrlPrec, vlrlMods));
                    }

                    vlrlPrec = vlrl;
                    vlrlMods = new ArrayList<>();
                }

                vlrlMods.add(vlrl);
            }

            if (vlrlPrec != null) {
                // builder.add(createInfoLineasComponent(vlrlPrec, vlrlMods));
            }

            report.summary(builder);
            // report.rebuild();

            report.toPdf(os);
        } catch (final DRException ex) {
            throw new InternalErrorException(ex);
        }
    }

    /**
     * Gets the logo.
     *
     * @return the logo
     */
    private ImageBuilder createLogoComponent() {
        return DynamicReports.cmp.image("/temp/LogoAP.png");
    }

    /**
     * Creates the cabecera component.
     *
     * @param fctr
     *            the fctr
     * @return the component builder
     */
    private ComponentBuilder<?, ?> createCabeceraComponent(final FacturaVO fctr) {
        final HorizontalListBuilder content = DynamicReports.cmp.horizontalList();

        content.add(createEtiquetaValorComponent("Liquidación Provisional", fctr.getEtiqueta()));
        content.add(createEtiquetaValorComponent("Fecha", formatDate(fctr.getFref())));

        return content;
    }

    /**
     * Creates the importes component.
     *
     * @param vo
     *            the vo
     * @return the component builder
     */
    private ComponentBuilder<?, ?> createImportesComponent(final FacturaImpresionVO vo) {
        final VerticalListBuilder content = DynamicReports.cmp.verticalList();

        content.add(DynamicReports.cmp.text(formatCurrency(vo.getFctr().getImporte())));

        for (final ValoracionImpuestoVO vlri : vo.getVlriList()) {
            content.add(DynamicReports.cmp.text(formatCurrency(vlri.getImporteImpuesto())));
        }

        content.add(DynamicReports.cmp.text(formatCurrency(vo.getFctr().getImporte() + vo.getFctr().getImpuesto())));

        return content;
    }

    /**
     * Gets the firma.
     *
     * @return the firma
     */
    private ImageBuilder createFirmaComponent() {
        return DynamicReports.cmp.image("/temp/FirmaAP.png");
    }

    /**
     * Creates the datos pagador component.
     *
     * @param vo
     *            the vo
     * @return the component builder
     */
    private ComponentBuilder<?, ?> createDatosPagadorComponent(final FacturaVO vo) {
        final VerticalListBuilder content = DynamicReports.cmp.verticalList();

        content.add(DynamicReports.cmp.text("Pagador"));

        return content;
    }

    /**
     * Creates the servicios component.
     *
     * @param vlrcMap
     *            the vlrc map
     * @return the component builder
     */
    private ComponentBuilder<?, ?> createServiciosComponent(@NonNull final Map<Long, ValoracionVO> vlrcMap) {
        final HorizontalListBuilder content = DynamicReports.cmp.horizontalList();

        content.add(DynamicReports.cmp.text("Servicios:"));

        final Iterator<ValoracionVO> vlrcIterator = vlrcMap.values().iterator();

        while (vlrcIterator.hasNext()) {
            final ValoracionVO vlrc = vlrcIterator.next();

            content.add(DynamicReports.cmp.text(vlrc.getSrvc().getEtiqueta() + (vlrcIterator.hasNext() ? ", " : "")));
        }

        return content;
    }

    /**
     * Creates the info cabecera component.
     *
     * @param fctr
     *            the fctr
     * @return the component builder
     */
    private ComponentBuilder<?, ?> createInfoCabeceraComponent(final FacturaVO fctr) {
        final HorizontalListBuilder content = DynamicReports.cmp.horizontalList();

        if (fctr.getAspc().getVersion().getCetiqInfo1() != null) {
            content.add(createEtiquetaValorComponent(fctr.getAspc().getVersion().getCetiqInfo1(), fctr.getInfo1()));
        }
        if (fctr.getAspc().getVersion().getCetiqInfo2() != null) {
            content.add(createEtiquetaValorComponent(fctr.getAspc().getVersion().getCetiqInfo2(), fctr.getInfo2()));
        }
        if (fctr.getAspc().getVersion().getCetiqInfo3() != null) {
            content.add(createEtiquetaValorComponent(fctr.getAspc().getVersion().getCetiqInfo3(), fctr.getInfo3()));
        }
        if (fctr.getAspc().getVersion().getCetiqInfo4() != null) {
            content.add(createEtiquetaValorComponent(fctr.getAspc().getVersion().getCetiqInfo4(), fctr.getInfo4()));
        }
        if (fctr.getAspc().getVersion().getCetiqInfo5() != null) {
            content.add(createEtiquetaValorComponent(fctr.getAspc().getVersion().getCetiqInfo5(), fctr.getInfo5()));
        }
        if (fctr.getAspc().getVersion().getCetiqInfo6() != null) {
            content.add(createEtiquetaValorComponent(fctr.getAspc().getVersion().getCetiqInfo6(), fctr.getInfo6()));
        }

        return content;
    }

    /**
     * Creates the info lineas component.
     *
     * @param vlrl
     *            the vlrl
     * @param vlrlMods
     *            the vlrl mods
     * @return the component builder
     */
    private ComponentBuilder<?, ?> createInfoLineasComponent(@NonNull final ValoracionLineaVO vlrl,
            @NonNull final List<ValoracionLineaVO> vlrlMods) {
        final VerticalListBuilder linea = DynamicReports.cmp.verticalList();

        linea.add(DynamicReports.cmp.horizontalFlowList(
                createEtiquetaValorComponent("Concepto", vlrl.getRgla().getCodigo()),
                createEtiquetaValorComponent("Cuota", formatDouble(vlrl.getValorBase())),
                createEtiquetaValorComponent("IVA", vlrl.getImpuesto().getEtiqueta()),
                createEtiquetaValorComponent("Importe", formatCurrency(vlrl.getImporte()))));

        final HorizontalListBuilder infos = DynamicReports.cmp.horizontalList();

        infos.add(DynamicReports.cmp.gap(10, 1));

        if (vlrl.getInfo1() != null) {
            infos.add(createEtiquetaValorComponent(vlrl.getRgla().getVersion().getEtiqInfo1(), vlrl.getInfo1()));
        }
        if (vlrl.getInfo2() != null) {
            infos.add(createEtiquetaValorComponent(vlrl.getRgla().getVersion().getEtiqInfo2(), vlrl.getInfo2()));
        }
        if (vlrl.getInfo3() != null) {
            infos.add(createEtiquetaValorComponent(vlrl.getRgla().getVersion().getEtiqInfo3(), vlrl.getInfo3()));
        }
        if (vlrl.getInfo4() != null) {
            infos.add(createEtiquetaValorComponent(vlrl.getRgla().getVersion().getEtiqInfo4(), vlrl.getInfo4()));
        }
        if (vlrl.getInfo5() != null) {
            infos.add(createEtiquetaValorComponent(vlrl.getRgla().getVersion().getEtiqInfo5(), vlrl.getInfo5()));
        }
        if (vlrl.getInfo6() != null) {
            infos.add(createEtiquetaValorComponent(vlrl.getRgla().getVersion().getEtiqInfo6(), vlrl.getInfo6()));
        }

        linea.add(infos);

        final HorizontalListBuilder cuants = DynamicReports.cmp.horizontalList();

        cuants.add(DynamicReports.cmp.gap(10, 1));

        if (vlrl.getCuant1() != null) {
            infos.add(createEtiquetaValorComponent(vlrl.getRgla().getVersion().getEtiqCuant1(),
                    formatDouble(vlrl.getCuant1())));
        }
        if (vlrl.getCuant2() != null) {
            infos.add(createEtiquetaValorComponent(vlrl.getRgla().getVersion().getEtiqCuant2(),
                    formatDouble(vlrl.getCuant2())));
        }
        if (vlrl.getCuant3() != null) {
            infos.add(createEtiquetaValorComponent(vlrl.getRgla().getVersion().getEtiqCuant3(),
                    formatDouble(vlrl.getCuant3())));
        }
        if (vlrl.getCuant4() != null) {
            infos.add(createEtiquetaValorComponent(vlrl.getRgla().getVersion().getEtiqCuant4(),
                    formatDouble(vlrl.getCuant4())));
        }
        if (vlrl.getCuant5() != null) {
            infos.add(createEtiquetaValorComponent(vlrl.getRgla().getVersion().getEtiqCuant5(),
                    formatDouble(vlrl.getCuant5())));
        }
        if (vlrl.getCuant6() != null) {
            infos.add(createEtiquetaValorComponent(vlrl.getRgla().getVersion().getEtiqCuant6(),
                    formatDouble(vlrl.getCuant6())));
        }

        linea.add(cuants);

        // if (!fctlMods.isEmpty()) {
        // final JasperReportBuilder report = DynamicReports.report();
        // final List<String> columns = new ArrayList<>();
        //
        // report.setTemplate(DynamicReports.template());
        // report.setColumnTitleStyle(PdfConstants.TH_STYLE);
        // report.setColumnStyle(PdfConstants.TD_STYLE);
        //
        // columns.add("conceptoTributario");
        // columns.add("importeBase");
        // columns.add("valorRegla");
        // columns.add("importe");
        //
        // report.addColumn(DynamicReports.col.column("conceptoTributario", "conceptoTributario",
        // DynamicReports.type.stringType()).setWidth(6));
        // report.addColumn(DynamicReports.col.column("importeBase", "importeBase",
        // DynamicReports.type.stringType())
        // .setWidth(2));
        // report.addColumn(DynamicReports.col.column("valorRegla", "valorRegla",
        // DynamicReports.type.stringType())
        // .setWidth(2));
        // report.addColumn(DynamicReports.col.column("importe", "importe", DynamicReports.type.stringType())
        // .setWidth(2));
        //
        // final DRDataSource dataSource = new DRDataSource(columns.toArray(new String[] {}));
        //
        // for (final FacturaLineaVO fctlMod : fctlMods) {
        // linea.add(createEtiquetaValorComponent("Concepto Tributario", fctlMod.getRgla().getCodigo()));
        //
        // final Object[] objects = new Object[columns.size()];
        // int i = 0;
        //
        // objects[i++] = itemVO.getPrmtAsociado().getEtiqueta();
        //
        // if (entiVO.isTempExp()) {
        // objects[i++] = itemVO.getSpvr().getFinicio() == null ? "" : PdfConstants.DATE_FORMAT.format(itemVO
        // .getSpvr().getFinicio());
        // objects[i++] = itemVO.getSpvr().getFfin() == null ? "" : PdfConstants.DATE_FORMAT.format(itemVO
        // .getSpvr().getFfin());
        // }
        //
        // if (entiVO.getEntdList() != null) {
        // for (final Long tpdtId : entiVO.getEntdList()) {
        // objects[i++] = getItdtValue(entiVO.getEntdMap().get(tpdtId), itemVO.getItdtMap().get(tpdtId));
        // }
        // }
        //
        // dataSource.add(objects);
        // }
        //
        // report.setDataSource(dataSource);
        // linea.add(report);
        // }

        return linea;
    }

    /**
     * Creates the etiqueta valor component.
     *
     * @param etiqueta
     *            the etiqueta
     * @param valor
     *            the valor
     * @return the component builder
     */
    private ComponentBuilder<?, ?> createEtiquetaValorComponent(final String etiqueta, final String valor) {
        return DynamicReports.cmp.text(etiqueta + ": " + (valor == null ? "" : valor));
    }

}
