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
import net.sf.dynamicreports.report.exception.DRException;
import xeredi.integra.model.vo.comun.ItemDatoVO;
import xeredi.integra.model.vo.metamodelo.EntidadTipoDatoVO;
import xeredi.integra.model.vo.metamodelo.TipoElemento;
import xeredi.integra.model.vo.metamodelo.TipoServicioVO;
import xeredi.integra.model.vo.metamodelo.TipoSubservicioVO;
import xeredi.integra.model.vo.servicio.ServicioVO;
import xeredi.integra.model.vo.servicio.SubservicioVO;

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

        if (tpsrVO.isTemporal()) {
            rowCells.add(new PdfCell("F. Inicio", PdfConstants.DATE_FORMAT.format(srvcVO.getFinicio()), 4,
                    TipoElemento.FE));
            rowCells.add(new PdfCell("F. Fin", srvcVO.getFfin() == null ? "" : PdfConstants.DATE_FORMAT.format(srvcVO
                    .getFfin()), 4, TipoElemento.FE));
        }

        listCells.add(rowCells);

        report.addTitle(getForm(listCells));
        listCells.clear();

        for (final Integer engdId : tpsrVO.getEngdList()) {
            rowCells = new ArrayList<>();
            accWidth = 0;

            for (final Long tpdtId : tpsrVO.getEngdEntdMap().get(engdId)) {
                final EntidadTipoDatoVO entdVO = tpsrVO.getEntdMap().get(tpdtId);
                final ItemDatoVO itdtVO = srvcVO.getItdtMap().get(tpdtId);

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
