package xeredi.integra.model.servicio.report;

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
import net.sf.dynamicreports.report.exception.DRException;
import xeredi.integra.model.comun.report.BasePdf;
import xeredi.integra.model.comun.report.PdfCell;
import xeredi.integra.model.comun.report.PdfConstants;
import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.metamodelo.vo.EntidadGrupoDatoVO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoElemento;
import xeredi.integra.model.metamodelo.vo.TipoServicioVO;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.integra.model.servicio.vo.ServicioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioPdf.
 */
public final class ServicioPdf extends BasePdf {

    /**
     * Instantiates a new servicio pdf.
     *
     * @param alocale
     *            the alocale
     */
    public ServicioPdf(final Locale alocale) {
        super(alocale);
    }

    /**
     * Imprimir.
     *
     * @param srvcVO
     *            the srvc vo
     * @param tpsrVO
     *            the tpsr vo
     * @param entiHijasMap
     *            the enti hijas map
     * @param itemHijosMap
     *            the item hijos map
     * @param stream
     *            the stream
     * @throws DRException
     *             the DR exception
     */
    public void imprimir(final ServicioVO srvcVO, final TipoServicioVO tpsrVO,
            final Map<Long, TipoSubservicioVO> entiHijasMap, final Map<Long, List<SubservicioVO>> itemHijosMap,
            final OutputStream stream) throws DRException {
        Preconditions.checkNotNull(srvcVO);
        Preconditions.checkNotNull(tpsrVO);

        final JasperReportBuilder report = DynamicReports.report();

        report.setPageFormat(PageType.A4, PageOrientation.LANDSCAPE);
        report.addTitle(DynamicReports.cmp.text(tpsrVO.getNombre()).setStyle(PdfConstants.H1_STYLE));

        final List<List<PdfCell>> listCells = new ArrayList<>();

        List<PdfCell> rowCells = new ArrayList<>();
        int accWidth = 0;

        rowCells.add(new PdfCell(tpsrVO.getNombre(), srvcVO.getEtiqueta(), 4, TipoElemento.TX));

        if (tpsrVO.getTemporal()) {
            rowCells.add(new PdfCell("F. Inicio", PdfConstants.DATE_FORMAT.format(srvcVO.getFini()), 4, TipoElemento.FE));
            rowCells.add(new PdfCell("F. Fin", srvcVO.getFfin() == null ? "" : PdfConstants.DATE_FORMAT.format(srvcVO
                    .getFfin()), 4, TipoElemento.FE));
        }

        listCells.add(rowCells);

        report.addTitle(getForm(listCells));
        listCells.clear();

        for (final EntidadGrupoDatoVO engd : tpsrVO.getEngdList()) {
            rowCells = new ArrayList<>();
            accWidth = 0;

            for (final EntidadTipoDatoVO entd : tpsrVO.getEntdList()) {
                if (entd.getGrupo() == engd.getNumero()) {
                    final ItemDatoVO itdt = srvcVO.getItdtMap().get(entd.getTpdt().getId());

                    if (accWidth + entd.getSpan() > PdfConstants.MAX_SPAN) {
                        listCells.add(rowCells);
                        rowCells = new ArrayList<>();
                        accWidth = 0;
                    }

                    rowCells.add(new PdfCell(entd.getEtiqueta(), getItdtValue(entd, itdt), entd.getSpan(), entd
                            .getTpdt().getTipoElemento()));
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
    }

}
