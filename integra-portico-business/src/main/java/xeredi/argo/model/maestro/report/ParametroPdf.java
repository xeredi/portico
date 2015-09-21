package xeredi.argo.model.maestro.report;

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
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.exception.InternalErrorException;
import xeredi.argo.model.comun.proxy.PorticoResourceBundle;
import xeredi.argo.model.comun.report.BasePdf;
import xeredi.argo.model.comun.report.PdfCell;
import xeredi.argo.model.comun.report.PdfConstants;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.item.vo.ItemDatoVO;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.maestro.vo.SubparametroVO;
import xeredi.argo.model.metamodelo.vo.EntidadGrupoDatoVO;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TipoElemento;
import xeredi.argo.model.metamodelo.vo.TipoParametroDetailVO;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroDetailVO;

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
     * @param item
     *            the item
     * @param entiDetail
     *            the enti detail
     * @param entiHijasMap
     *            the enti hijas map
     * @param itemHijosMap
     *            the item hijos map
     * @param i18nMap
     *            the i18n map
     * @param stream
     *            the stream
     * @throws ApplicationException
     *             the ApplicationException
     */
    public void imprimir(final ParametroVO item, final TipoParametroDetailVO entiDetail,
            final Map<Long, TipoSubparametroDetailVO> entiHijasMap, final Map<Long, List<SubparametroVO>> itemHijosMap,
            final Map<String, I18nVO> i18nMap, final OutputStream stream) throws ApplicationException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(entiDetail);

        try {
            final String tpprLabel = bundle.getString("enti_" + entiDetail.getEnti().getId());
            final String prmtFiniLabel = bundle.getString(MessageI18nKey.fini.name());
            final String prmtFfinLabel = bundle.getString(MessageI18nKey.ffin.name());
            final String prmtLatLabel = bundle.getString(MessageI18nKey.prmt_lat.name());
            final String prmtLonLabel = bundle.getString(MessageI18nKey.prmt_lon.name());

            final JasperReportBuilder report = DynamicReports.report();

            report.setPageFormat(PageType.A4, PageOrientation.LANDSCAPE);
            report.addTitle(DynamicReports.cmp.text(tpprLabel).setStyle(PdfConstants.H1_STYLE));

            final List<List<PdfCell>> listCells = new ArrayList<>();

            List<PdfCell> rowCells = new ArrayList<>();
            int accWidth = 0;

            if (entiDetail.getEnti().isPuerto()) {
                rowCells.add(new PdfCell(bundle.getString(MessageI18nKey.prto.name()), item.getPrto().getEtiqueta(), 2,
                        TipoElemento.TX));
            }

            rowCells.add(new PdfCell(tpprLabel, item.getEtiqueta(), 6, TipoElemento.TX));

            rowCells.add(new PdfCell(prmtFiniLabel, formatDate(item.getVersion().getFini()), 1, TipoElemento.FE));
            rowCells.add(new PdfCell(prmtFfinLabel, formatDate(item.getVersion().getFfin()), 1, TipoElemento.FE));

            if (entiDetail.getEnti().isGis()) {
                rowCells.add(new PdfCell(prmtLatLabel, formatDouble(item.getVersion().getLat()), 1, TipoElemento.ND));
                rowCells.add(new PdfCell(prmtLonLabel, formatDouble(item.getVersion().getLon()), 1, TipoElemento.ND));
            }

            listCells.add(rowCells);

            if (entiDetail.getEnti().isI18n()) {
                for (final I18nVO i18nVO : i18nMap.values()) {
                    rowCells = new ArrayList<>();

                    rowCells.add(new PdfCell(i18nVO.getLanguage(), i18nVO.getText(), 10, TipoElemento.TX));
                    listCells.add(rowCells);
                }
            }

            report.addTitle(getForm(listCells));
            listCells.clear();

            if (entiDetail.getEngdList() != null) {
                for (final EntidadGrupoDatoVO engd : entiDetail.getEngdList()) {
                    rowCells = new ArrayList<>();
                    accWidth = 0;

                    if (entiDetail.getEntdList() != null) {
                        for (final Long tpdtId : entiDetail.getEntdList()) {
                            final EntidadTipoDatoVO entd = entiDetail.getEntdMap().get(tpdtId);

                            if (entd.getGrupo() == engd.getNumero()) {
                                final ItemDatoVO itdt = item.getItdtMap().get(entd.getTpdt().getId());

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

            if (entiDetail.getEntiHijasList() != null) {
                for (final Long entiId : entiDetail.getEntiHijasList()) {
                    if (!itemHijosMap.get(entiId).isEmpty()) {
                        report.addTitle(DynamicReports.cmp.subreport(getSubreport(entiHijasMap.get(entiId),
                                itemHijosMap.get(entiId))));
                    }
                }
            }

            report.toPdf(stream);
        } catch (final DRException ex) {
            throw new InternalErrorException(ex);
        }
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
    private JasperReportBuilder getSubreport(final TipoParametroDetailVO entiVO, final ParametroVO prmtVO,
            final Long engdId) {
        return null;
    }

    /**
     * Gets the data source.
     *
     * @param entiDetail
     *            the enti detail
     * @param itemList
     *            the item list
     * @return the data source
     */
    private JasperReportBuilder getSubreport(final TipoSubparametroDetailVO entiDetail,
            final List<SubparametroVO> itemList) {
        Preconditions.checkNotNull(entiDetail);
        Preconditions.checkNotNull(itemList);

        final String tpspLabel = bundle.getString("enti_" + entiDetail.getEnti().getId());
        final String tpprAsociadoLabel = bundle.getString("enti_" + entiDetail.getEnti().getTpprAsociado().getId());
        final String sprmFiniLabel = bundle.getString(MessageI18nKey.fini.name());
        final String sprmFfinLabel = bundle.getString(MessageI18nKey.ffin.name());

        final JasperReportBuilder report = DynamicReports.report();
        final List<String> columns = new ArrayList<>();

        report.setTemplate(DynamicReports.template());
        report.setColumnTitleStyle(PdfConstants.TH_STYLE);
        report.setColumnStyle(PdfConstants.TD_STYLE);
        report.addTitle(DynamicReports.cmp.text(tpspLabel).setStyle(PdfConstants.H1_STYLE));

        columns.add(tpprAsociadoLabel);

        report.addColumn(DynamicReports.col.column(tpprAsociadoLabel, tpprAsociadoLabel,
                DynamicReports.type.stringType()).setWidth(4));

        columns.add(MessageI18nKey.fini.name());
        columns.add(MessageI18nKey.ffin.name());

        report.addColumn(DynamicReports.col.column(sprmFiniLabel, MessageI18nKey.fini.name(),
                DynamicReports.type.stringType()).setWidth(2));
        report.addColumn(DynamicReports.col.column(sprmFfinLabel, MessageI18nKey.ffin.name(),
                DynamicReports.type.stringType()).setWidth(2));

        if (entiDetail.getEntdList() != null) {
            for (final Long tpdtId : entiDetail.getEntdList()) {
                final EntidadTipoDatoVO entd = entiDetail.getEntdMap().get(tpdtId);
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

            objects[i++] = formatDate(itemVO.getVersion().getFini());
            objects[i++] = formatDate(itemVO.getVersion().getFfin());

            if (entiDetail.getEntdList() != null) {
                for (final Long tpdtId : entiDetail.getEntdList()) {
                    final EntidadTipoDatoVO entd = entiDetail.getEntdMap().get(tpdtId);

                    objects[i++] = getItdtValue(entd, itemVO.getItdtMap().get(entd.getTpdt().getId()));
                }
            }

            dataSource.add(objects);
        }

        report.setDataSource(dataSource);

        return report;
    }
}
