package xeredi.integra.model.bo.util.pdf;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import xeredi.integra.model.vo.comun.ItemDatoVO;
import xeredi.integra.model.vo.maestro.ParametroI18nVO;
import xeredi.integra.model.vo.maestro.ParametroVO;
import xeredi.integra.model.vo.maestro.SubparametroVO;
import xeredi.integra.model.vo.metamodelo.EntidadTipoDatoVO;
import xeredi.integra.model.vo.metamodelo.TipoElemento;
import xeredi.integra.model.vo.metamodelo.TipoParametroVO;
import xeredi.integra.model.vo.metamodelo.TipoSubparametroVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroPdf.
 */
public final class ParametroPdf extends BasePdf {

    /**
     * Instantiates a new parametro pdf.
     *
     * @param alocale
     *            the alocale
     */
    public ParametroPdf(final Locale alocale) {
        super(alocale);
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
     * @param p18nMap
     *            the p18n map
     * @param stream
     *            the stream
     * @throws DRException
     *             the DR exception
     */
    public void imprimir(final ParametroVO prmtVO, final TipoParametroVO tpprVO,
            final Map<Long, TipoSubparametroVO> entiHijasMap, final Map<Long, List<SubparametroVO>> itemHijosMap,
            final Map<String, ParametroI18nVO> p18nMap, final OutputStream stream) throws DRException {
        Preconditions.checkNotNull(prmtVO);
        Preconditions.checkNotNull(tpprVO);

        final JasperReportBuilder report = DynamicReports.report();

        report.setPageFormat(PageType.A4, PageOrientation.LANDSCAPE);
        report.addTitle(DynamicReports.cmp.text(tpprVO.getNombre()).setStyle(PdfConstants.H1_STYLE));

        final List<List<PdfCell>> listCells = new ArrayList<>();

        List<PdfCell> rowCells = new ArrayList<>();
        int accWidth = 0;

        rowCells.add(new PdfCell(tpprVO.getNombre(), prmtVO.getEtiqueta(), 4, TipoElemento.TX));

        if (tpprVO.isTempExp()) {
            rowCells.add(new PdfCell("F. Inicio", PdfConstants.DATE_FORMAT.format(prmtVO.getPrvr().getFinicio()), 4,
                    TipoElemento.FE));
            rowCells.add(new PdfCell("F. Fin", prmtVO.getPrvr().getFfin() == null ? "" : PdfConstants.DATE_FORMAT
                    .format(prmtVO.getPrvr().getFfin()), 4, TipoElemento.FE));
        }

        listCells.add(rowCells);

        if (tpprVO.isI18n()) {
            for (final ParametroI18nVO p18nVO : p18nMap.values()) {
                rowCells = new ArrayList<>();

                rowCells.add(new PdfCell(p18nVO.getIdioma(), p18nVO.getTexto(), 10, TipoElemento.TX));
                listCells.add(rowCells);
            }
        }

        report.addTitle(getForm(listCells));
        listCells.clear();

        for (final Integer engdId : tpprVO.getEngdList()) {
            rowCells = new ArrayList<>();
            accWidth = 0;

            for (final Long tpdtId : tpprVO.getEngdEntdMap().get(engdId)) {
                final EntidadTipoDatoVO entdVO = tpprVO.getEntdMap().get(tpdtId);
                final ItemDatoVO itdtVO = prmtVO.getItdtMap().get(tpdtId);

                if (accWidth + entdVO.getSpan() > PdfConstants.MAX_SPAN) {
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

            report.addTitle(getForm(listCells), Components.pageBreak());
            listCells.clear();
        }

        if (tpprVO.getEntiHijasList() != null) {
            for (final Long entiId : tpprVO.getEntiHijasList()) {
                if (!itemHijosMap.get(entiId).isEmpty()) {
                    report.addTitle(DynamicReports.cmp.subreport(getSubreport(entiHijasMap.get(entiId),
                            itemHijosMap.get(entiId))));
                }
            }
        }

        report.toPdf(stream);
    }

    /**
     * Gets the subreport.
     *
     * @param entiVO
     *            the enti vo
     * @param prmtVO
     *            the prmt vo
     * @param engdId
     *            the engd id
     * @return the subreport
     */
    private JasperReportBuilder getSubreport(final TipoParametroVO entiVO, final ParametroVO prmtVO, final Long engdId) {
        return null;
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
        report.setColumnTitleStyle(PdfConstants.TH_STYLE);
        report.setColumnStyle(PdfConstants.TD_STYLE);
        report.addTitle(DynamicReports.cmp.text(entiVO.getNombre()).setStyle(PdfConstants.H1_STYLE));

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
                objects[i++] = itemVO.getSpvr().getFinicio() == null ? "" : PdfConstants.DATE_FORMAT.format(itemVO
                        .getSpvr().getFinicio());
                objects[i++] = itemVO.getSpvr().getFfin() == null ? "" : PdfConstants.DATE_FORMAT.format(itemVO
                        .getSpvr().getFfin());
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

}
