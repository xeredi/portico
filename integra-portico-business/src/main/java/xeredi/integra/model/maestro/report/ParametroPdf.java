package xeredi.integra.model.maestro.report;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import xeredi.integra.model.comun.proxy.PorticoResourceBundle;
import xeredi.integra.model.comun.report.BasePdf;
import xeredi.integra.model.comun.report.PdfCell;
import xeredi.integra.model.comun.report.PdfConstants;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.maestro.vo.SubparametroVO;
import xeredi.integra.model.metamodelo.vo.EntidadGrupoDatoVO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoElemento;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroPdf.
 */
public final class ParametroPdf extends BasePdf {

    /** The bundle. */
    private final ResourceBundle bundle;

    /**
     * Instantiates a new parametro pdf.
     *
     * @param alocale
     *            the alocale
     */
    public ParametroPdf(final Locale alocale) {
        super(alocale);

        bundle = PorticoResourceBundle.getBundle(locale);
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
            final Map<String, I18nVO> i18nMap, final OutputStream stream) throws DRException {
        Preconditions.checkNotNull(prmtVO);
        Preconditions.checkNotNull(tpprVO);

        final String tpprLabel = bundle.getString("enti_" + tpprVO.getId());
        final String prmtFiniLabel = bundle.getString("prmt_fini");
        final String prmtFfinLabel = bundle.getString("prmt_ffin");

        final JasperReportBuilder report = DynamicReports.report();

        report.setPageFormat(PageType.A4, PageOrientation.LANDSCAPE);
        report.addTitle(DynamicReports.cmp.text(tpprLabel).setStyle(PdfConstants.H1_STYLE));

        final List<List<PdfCell>> listCells = new ArrayList<>();

        List<PdfCell> rowCells = new ArrayList<>();
        int accWidth = 0;

        rowCells.add(new PdfCell(tpprLabel, prmtVO.getEtiqueta(), 8, TipoElemento.TX));

        rowCells.add(new PdfCell(prmtFiniLabel, PdfConstants.DATE_FORMAT.format(prmtVO.getPrvr().getFini()), 2,
                TipoElemento.FE));
        rowCells.add(new PdfCell(prmtFfinLabel, prmtVO.getPrvr().getFfin() == null ? "" : PdfConstants.DATE_FORMAT
                .format(prmtVO.getPrvr().getFfin()), 2, TipoElemento.FE));

        listCells.add(rowCells);

        if (tpprVO.getI18n()) {
            for (final I18nVO i18nVO : i18nMap.values()) {
                rowCells = new ArrayList<>();

                rowCells.add(new PdfCell(i18nVO.getLanguage(), i18nVO.getText(), 10, TipoElemento.TX));
                listCells.add(rowCells);
            }
        }

        report.addTitle(getForm(listCells));
        listCells.clear();

        if (tpprVO.getEngdList() != null) {
            for (final EntidadGrupoDatoVO engd : tpprVO.getEngdList()) {
                rowCells = new ArrayList<>();
                accWidth = 0;

                if (tpprVO.getEntdList() != null) {
                    for (final EntidadTipoDatoVO entd : tpprVO.getEntdList()) {
                        if (entd.getGrupo() == engd.getNumero()) {
                            final ItemDatoVO itdt = prmtVO.getItdtMap().get(entd.getTpdt().getId());

                            if (accWidth + entd.getSpan() > PdfConstants.MAX_SPAN) {
                                listCells.add(rowCells);
                                rowCells = new ArrayList<>();
                                accWidth = 0;
                            }

                            final String entdLabel = bundle.getString("entd_" + entd.getId());

                            rowCells.add(new PdfCell(entdLabel, getItdtValue(entd, itdt), entd.getSpan(), entd
                                    .getTpdt().getTipoElemento()));
                            accWidth += entd.getSpan();
                        }
                    }
                }

                if (!rowCells.isEmpty()) {
                    listCells.add(rowCells);
                }

                report.addTitle(getForm(listCells), Components.pageBreak());
                listCells.clear();
            }
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

        final String tpspLabel = bundle.getString("enti_" + entiVO.getId());
        final String tpprAsociadoLabel = bundle.getString("enti_" + entiVO.getTpprAsociado().getId());
        final String sprmFiniLabel = bundle.getString("sprm_fini");
        final String sprmFfinLabel = bundle.getString("sprm_ffin");

        final JasperReportBuilder report = DynamicReports.report();
        final List<String> columns = new ArrayList<>();

        report.setTemplate(DynamicReports.template());
        report.setColumnTitleStyle(PdfConstants.TH_STYLE);
        report.setColumnStyle(PdfConstants.TD_STYLE);
        report.addTitle(DynamicReports.cmp.text(tpspLabel).setStyle(PdfConstants.H1_STYLE));

        columns.add(tpprAsociadoLabel);

        report.addColumn(DynamicReports.col.column(tpprAsociadoLabel, tpprAsociadoLabel,
                DynamicReports.type.stringType()).setWidth(4));

        columns.add("fini");
        columns.add("ffin");

        report.addColumn(DynamicReports.col.column(sprmFiniLabel, "fini", DynamicReports.type.stringType()).setWidth(2));
        report.addColumn(DynamicReports.col.column(sprmFfinLabel, "ffin", DynamicReports.type.stringType()).setWidth(2));

        if (entiVO.getEntdList() != null) {
            for (final EntidadTipoDatoVO entd : entiVO.getEntdList()) {
                final String entdLabel = bundle.getString("entd_" + entd.getId());

                columns.add(entdLabel);

                report.addColumn(DynamicReports.col.column(entdLabel, entdLabel, DynamicReports.type.stringType())
                        .setWidth(entd.getSpan()));
            }
        }

        final DRDataSource dataSource = new DRDataSource(columns.toArray(new String[] {}));

        for (final SubparametroVO itemVO : itemList) {
            final Object[] objects = new Object[columns.size()];
            int i = 0;

            objects[i++] = itemVO.getPrmtAsociado().getEtiqueta();

            objects[i++] = itemVO.getSpvr().getFini() == null ? "" : PdfConstants.DATE_FORMAT.format(itemVO.getSpvr()
                    .getFini());
            objects[i++] = itemVO.getSpvr().getFfin() == null ? "" : PdfConstants.DATE_FORMAT.format(itemVO.getSpvr()
                    .getFfin());

            if (entiVO.getEntdList() != null) {
                for (final EntidadTipoDatoVO entd : entiVO.getEntdList()) {
                    objects[i++] = getItdtValue(entd, itemVO.getItdtMap().get(entd.getTpdt().getId()));
                }
            }

            dataSource.add(objects);
        }

        report.setDataSource(dataSource);

        return report;
    }

}
