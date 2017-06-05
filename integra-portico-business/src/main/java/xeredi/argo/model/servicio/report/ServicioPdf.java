package xeredi.argo.model.servicio.report;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.exception.DRException;
import xeredi.argo.model.comun.exception.InternalErrorException;
import xeredi.argo.model.comun.report.BasePdf;
import xeredi.argo.model.comun.report.PdfCell;
import xeredi.argo.model.comun.report.PdfConstants;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.item.vo.ItemDatoVO;
import xeredi.argo.model.metamodelo.vo.EntidadGrupoDatoVO;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TipoElemento;
import xeredi.argo.model.metamodelo.vo.TipoServicioDetailVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioDetailVO;
import xeredi.argo.model.servicio.vo.ServicioVO;
import xeredi.argo.model.servicio.vo.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioPdf.
 */
public final class ServicioPdf extends BasePdf {
	/**
	 * Imprimir.
	 *
	 * @param srvcVO
	 *            the srvc vo
	 * @param tpsrDetail
	 *            the tpsr detail
	 * @param entiHijasMap
	 *            the enti hijas map
	 * @param itemHijosMap
	 *            the item hijos map
	 * @param stream
	 *            the stream
	 * @throws InternalErrorException
	 *             the internal error exception
	 */
	public void imprimir(final ServicioVO srvcVO, final TipoServicioDetailVO tpsrDetail,
			final Map<Long, TipoSubservicioDetailVO> entiHijasMap, final Map<Long, List<SubservicioVO>> itemHijosMap,
			final OutputStream stream) throws InternalErrorException {
		try {
			final JasperReportBuilder report = DynamicReports.report();

			report.setPageFormat(PageType.A4, PageOrientation.LANDSCAPE);
			report.addTitle(DynamicReports.cmp.text(tpsrDetail.getEnti().getNombre()).setStyle(PdfConstants.H1_STYLE));

			final List<List<PdfCell>> listCells = new ArrayList<>();

			List<PdfCell> rowCells = new ArrayList<>();
			int accWidth = 0;

			rowCells.add(new PdfCell(tpsrDetail.getEnti().getNombre(), srvcVO.getEtiqueta(), 4, TipoElemento.TX));

			if (tpsrDetail.getEnti().isTemporal()) {
				rowCells.add(new PdfCell(MessageI18nKey.fini.name(), formatDate(srvcVO.getFini()), 4, TipoElemento.FE));
				rowCells.add(new PdfCell(MessageI18nKey.ffin.name(), formatDate(srvcVO.getFfin()), 4, TipoElemento.FE));
			}

			listCells.add(rowCells);

			report.addTitle(getForm(listCells));
			listCells.clear();

			for (final EntidadGrupoDatoVO engd : tpsrDetail.getEngdList()) {
				rowCells = new ArrayList<>();
				accWidth = 0;

				for (final Long tpdtId : tpsrDetail.getEntdList()) {
					final EntidadTipoDatoVO entd = tpsrDetail.getEntdMap().get(tpdtId);

					if (entd.getGrupo() == engd.getNumero()) {
						final ItemDatoVO itdt = srvcVO.getItdtMap().get(entd.getTpdt().getId());

						if (accWidth + entd.getSpan() > PdfConstants.MAX_SPAN) {
							listCells.add(rowCells);
							rowCells = new ArrayList<>();
							accWidth = 0;
						}

						rowCells.add(new PdfCell(entd.getEtiqueta(), getItdtValue(entd, itdt), entd.getSpan(),
								entd.getTpdt().getTipoElemento()));
						accWidth += entd.getSpan();
					}
				}

				if (!rowCells.isEmpty()) {
					listCells.add(rowCells);
				}

				report.addTitle(getForm(listCells), Components.pageBreak());
				listCells.clear();
			}

			// if (tpprVO.getEntiHijasList() != null) {
			// for (final Long entiId : tpprVO.getEntiHijasList()) {
			// if (!itemHijosMap.get(entiId).isEmpty()) {
			// report.addTitle(DynamicReports.cmp.subreport(getSubreport(
			// entiHijasMap.get(entiId), itemHijosMap.get(entiId))));
			// }
			// }
			// }

			report.toPdf(stream);
		} catch (final DRException ex) {
			throw new InternalErrorException(ex);
		}
	}

}
