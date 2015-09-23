package xeredi.argo.model.facturacion.report;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
import xeredi.argo.model.facturacion.vo.FacturaImpuestoVO;
import xeredi.argo.model.facturacion.vo.FacturaLineaVO;
import xeredi.argo.model.facturacion.vo.FacturaServicioVO;
import xeredi.argo.model.facturacion.vo.FacturaVO;
import xeredi.argo.model.facturacion.vo.ReglaTipo;

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
            builder.add(createServiciosComponent(vo.getFctsMap()));
            // builder.add(createInfoCabeceraComponent(vo.getFctr()));

            FacturaLineaVO fctlPrec = null;
            List<FacturaLineaVO> fctlMods = null;

            for (final FacturaLineaVO fctl : vo.getFctlList()) {
                if (fctl.getRgla().getTipo() == ReglaTipo.T) {
                    if (fctlPrec != null) {
                        // builder.add(createInfoLineasComponent(fctlPrec, fctlMods));
                    }

                    fctlPrec = fctl;
                    fctlMods = new ArrayList<>();
                }

                fctlMods.add(fctl);
            }

            if (fctlPrec != null) {
                // builder.add(createInfoLineasComponent(fctlPrec, fctlMods));
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

        for (final FacturaImpuestoVO fcti : vo.getFctiList()) {
            content.add(DynamicReports.cmp.text(formatCurrency(fcti.getImporteImpuesto())));
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
     * @param fctsMap
     *            the fcts map
     * @return the component builder
     */
    private ComponentBuilder<?, ?> createServiciosComponent(final Map<Long, FacturaServicioVO> fctsMap) {
        final HorizontalListBuilder content = DynamicReports.cmp.horizontalList();

        content.add(DynamicReports.cmp.text("Servicios:"));

        final Iterator<FacturaServicioVO> fctsIterator = fctsMap.values().iterator();

        while (fctsIterator.hasNext()) {
            final FacturaServicioVO fcts = fctsIterator.next();

            content.add(DynamicReports.cmp.text(fcts.getSrvc().getEtiqueta() + (fctsIterator.hasNext() ? ", " : "")));
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
     * @param fctl
     *            the fctl
     * @param fctlMods
     *            the fctl mods
     * @return the component builder
     */
    private ComponentBuilder<?, ?> createInfoLineasComponent(final FacturaLineaVO fctl,
            final List<FacturaLineaVO> fctlMods) {
        final VerticalListBuilder linea = DynamicReports.cmp.verticalList();

        linea.add(DynamicReports.cmp.horizontalFlowList(
                createEtiquetaValorComponent("Concepto", fctl.getRgla().getCodigo()),
                createEtiquetaValorComponent("Cuota", formatDouble(fctl.getRgla().getVersion().getValorBase())),
                createEtiquetaValorComponent("IVA", fctl.getImpuesto().getEtiqueta()),
                createEtiquetaValorComponent("Importe", formatCurrency(fctl.getImporte()))));

        final HorizontalListBuilder infos = DynamicReports.cmp.horizontalList();

        infos.add(DynamicReports.cmp.gap(10, 1));

        if (fctl.getInfo1() != null) {
            infos.add(createEtiquetaValorComponent(fctl.getRgla().getVersion().getEtiqInfo1(), fctl.getInfo1()));
        }
        if (fctl.getInfo2() != null) {
            infos.add(createEtiquetaValorComponent(fctl.getRgla().getVersion().getEtiqInfo2(), fctl.getInfo2()));
        }
        if (fctl.getInfo3() != null) {
            infos.add(createEtiquetaValorComponent(fctl.getRgla().getVersion().getEtiqInfo3(), fctl.getInfo3()));
        }
        if (fctl.getInfo4() != null) {
            infos.add(createEtiquetaValorComponent(fctl.getRgla().getVersion().getEtiqInfo4(), fctl.getInfo4()));
        }
        if (fctl.getInfo5() != null) {
            infos.add(createEtiquetaValorComponent(fctl.getRgla().getVersion().getEtiqInfo5(), fctl.getInfo5()));
        }
        if (fctl.getInfo6() != null) {
            infos.add(createEtiquetaValorComponent(fctl.getRgla().getVersion().getEtiqInfo6(), fctl.getInfo6()));
        }

        linea.add(infos);

        final HorizontalListBuilder cuants = DynamicReports.cmp.horizontalList();

        cuants.add(DynamicReports.cmp.gap(10, 1));

        if (fctl.getCuant1() != null) {
            infos.add(createEtiquetaValorComponent(fctl.getRgla().getVersion().getEtiqCuant1(),
                    formatDouble(fctl.getCuant1())));
        }
        if (fctl.getCuant2() != null) {
            infos.add(createEtiquetaValorComponent(fctl.getRgla().getVersion().getEtiqCuant2(),
                    formatDouble(fctl.getCuant2())));
        }
        if (fctl.getCuant3() != null) {
            infos.add(createEtiquetaValorComponent(fctl.getRgla().getVersion().getEtiqCuant3(),
                    formatDouble(fctl.getCuant3())));
        }
        if (fctl.getCuant4() != null) {
            infos.add(createEtiquetaValorComponent(fctl.getRgla().getVersion().getEtiqCuant4(),
                    formatDouble(fctl.getCuant4())));
        }
        if (fctl.getCuant5() != null) {
            infos.add(createEtiquetaValorComponent(fctl.getRgla().getVersion().getEtiqCuant5(),
                    formatDouble(fctl.getCuant5())));
        }
        if (fctl.getCuant6() != null) {
            infos.add(createEtiquetaValorComponent(fctl.getRgla().getVersion().getEtiqCuant6(),
                    formatDouble(fctl.getCuant6())));
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