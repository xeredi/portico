package xeredi.argo.model.maestro.report;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import lombok.NonNull;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.component.MultiPageListBuilder;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.constant.SplitType;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.exception.InternalErrorException;
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

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroPdf.
 */
public final class ParametroPdf extends BasePdf {

	/**
	 * Instantiates a new parametro pdf.
	 *
	 * @param abundle
	 *            the abundle
	 */
	public ParametroPdf(@NonNull final ResourceBundle abundle) {
		super(abundle);
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
	public void imprimir(@NonNull final ParametroVO item, @NonNull final TipoParametroDetailVO entiDetail,
			final Map<Long, TipoSubparametroDetailVO> entiHijasMap, final Map<Long, List<SubparametroVO>> itemHijosMap,
			final Map<String, I18nVO> i18nMap, final OutputStream stream) throws ApplicationException {
		try {
			final JasperReportBuilder report = DynamicReports.report();

			report.setPageFormat(PageType.A4, PageOrientation.LANDSCAPE);
			report.pageFooter(DynamicReports.cmp.pageXslashY());
			report.setTitleSplitType(SplitType.PREVENT);
			report.setSummarySplitType(SplitType.PREVENT);
			report.setSummaryWithPageHeaderAndFooter(true);

			final MultiPageListBuilder entiHijasList = DynamicReports.cmp.multiPageList();

			if (entiDetail.getEntiHijasList() != null) {
				for (final Long entiId : entiDetail.getEntiHijasList()) {
					if (!itemHijosMap.get(entiId).isEmpty()) {
						entiHijasList.add(DynamicReports.cmp.verticalGap(17), DynamicReports.cmp
								.subreport(getSubreport(entiHijasMap.get(entiId), itemHijosMap.get(entiId))));
					}
				}
			}

			report.title(DynamicReports.cmp.subreport(getSubreport(entiDetail, item, i18nMap))).summary(entiHijasList);

			report.toPdf(stream);
		} catch (final DRException ex) {
			throw new InternalErrorException(ex);
		}
	}

	/**
	 * Gets the subreport.
	 *
	 * @param entiDetail
	 *            the enti detail
	 * @param item
	 *            the item
	 * @param i18nMap
	 *            the i18n map
	 * @return the subreport
	 */
	private JasperReportBuilder getSubreport(final TipoParametroDetailVO entiDetail, final ParametroVO item,
			final Map<String, I18nVO> i18nMap) {
		final String tpprLabel = bundle.getString("enti_" + entiDetail.getEnti().getId());
		final String prmtFiniLabel = bundle.getString(MessageI18nKey.fini.name());
		final String prmtFfinLabel = bundle.getString(MessageI18nKey.ffin.name());
		final String prmtLatLabel = bundle.getString(MessageI18nKey.prmt_lat.name());
		final String prmtLonLabel = bundle.getString(MessageI18nKey.prmt_lon.name());

		final JasperReportBuilder report = DynamicReports.report();

		{
			final List<List<PdfCell>> listCells = new ArrayList<>();
			List<PdfCell> rowCells = new ArrayList<>();

			final int accWidth = 0;

			if (entiDetail.getEnti().getPuerto()) {
				rowCells.add(new PdfCell(bundle.getString(MessageI18nKey.prto.name()), item.getPrto().getEtiqueta(), 2,
						TipoElemento.TX));
			}

			rowCells.add(new PdfCell(tpprLabel, item.getEtiqueta(), 6, TipoElemento.TX));

			rowCells.add(new PdfCell(prmtFiniLabel, formatDate(item.getVersion().getFini()), 1, TipoElemento.FE));
			rowCells.add(new PdfCell(prmtFfinLabel, formatDate(item.getVersion().getFfin()), 1, TipoElemento.FE));

			if (entiDetail.getEnti().getGis()) {
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

			report.title(DynamicReports.cmp.text(tpprLabel).setStyle(PdfConstants.H1_STYLE), getForm(listCells));
		}

		final MultiPageListBuilder engdList = DynamicReports.cmp.multiPageList();

		{
			if (entiDetail.getEngdList() != null) {
				for (final EntidadGrupoDatoVO engd : entiDetail.getEngdList()) {
					final List<List<PdfCell>> listCells = new ArrayList<>();
					List<PdfCell> rowCells = new ArrayList<>();

					int accWidth = 0;

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

								rowCells.add(new PdfCell(entdLabel, getItdtValue(entd, itdt), entd.getSpan(),
										entd.getTpdt().getTipoElemento()));
								accWidth += entd.getSpan();
							}
						}
					}

					if (!rowCells.isEmpty()) {
						listCells.add(rowCells);
					}

					final String engdLabel = bundle.getString("engd_" + engd.getId());

					engdList.add(DynamicReports.cmp.verticalGap(17), getForm(engdLabel, listCells));
				}
			}
		}

		report.summary(engdList);

		return report;
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
	private JasperReportBuilder getSubreport(@NonNull final TipoSubparametroDetailVO entiDetail,
			@NonNull final List<SubparametroVO> itemList) {
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

		report.addColumn(DynamicReports.col
				.column(tpprAsociadoLabel, tpprAsociadoLabel, DynamicReports.type.stringType()).setWidth(4));

		columns.add(MessageI18nKey.fini.name());
		columns.add(MessageI18nKey.ffin.name());

		report.addColumn(DynamicReports.col
				.column(sprmFiniLabel, MessageI18nKey.fini.name(), DynamicReports.type.stringType()).setWidth(2));
		report.addColumn(DynamicReports.col
				.column(sprmFfinLabel, MessageI18nKey.ffin.name(), DynamicReports.type.stringType()).setWidth(2));

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
