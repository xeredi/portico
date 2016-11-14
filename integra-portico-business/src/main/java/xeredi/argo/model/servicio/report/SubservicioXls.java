package xeredi.argo.model.servicio.report;

import java.io.OutputStream;
import java.util.List;
import java.util.Locale;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import xeredi.argo.model.comun.report.BaseXls;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.item.vo.ItemDatoVO;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioDetailVO;
import xeredi.argo.model.servicio.vo.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioXls.
 */
public final class SubservicioXls extends BaseXls {

    /** The ssrv list. */
    private final List<SubservicioVO> ssrvList;

    /** The tpss detail. */
    private final TipoSubservicioDetailVO tpssDetail;

    /**
     * Instantiates a new subservicio xls.
     *
     * @param locale
     *            the locale
     * @param stream
     *            the stream
     * @param ssrvList
     *            the ssrv list
     * @param tpssDetail
     *            the tpss detail
     */
    public SubservicioXls(final Locale locale, final OutputStream stream, final List<SubservicioVO> ssrvList,
            final TipoSubservicioDetailVO tpssDetail) {
        super(locale, stream);

        this.ssrvList = ssrvList;
        this.tpssDetail = tpssDetail;

    }

    /**
     * {@inheritDoc}
     */
    public void doGenerate(final HSSFWorkbook workbook) {
        final HSSFSheet sheet = workbook.createSheet(bundle.getString("enti_" + tpssDetail.getEnti().getId()));

        // Cabecera XLS
        int rownum = 0;

        final HSSFRow rowhead = sheet.createRow(rownum++);
        int i = 0;

        setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.tpss.name()));
        setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.srvc.name()));
        setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.ssrv_numero.name()));

        if (tpssDetail.getEnti().getTpdtEstado() != null) {
            setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.ssrv_estado.name()));
        }

        if (tpssDetail.getEnti().isTemporal()) {
            setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.fini.name()));
            setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.ffin.name()));
        }

        for (final Long tpdtId : tpssDetail.getEntdList()) {
            final EntidadTipoDatoVO entd = tpssDetail.getEntdMap().get(tpdtId);

            setCellValue(rowhead, i++, bundle.getString("entd_" + entd.getId()));
        }

        // Filas XLS
        for (final SubservicioVO ssrvVO : ssrvList) {
            final HSSFRow row = sheet.createRow(rownum++);

            int j = 0;

            setCellValue(row, j++, bundle.getString("enti_" + tpssDetail.getEnti().getId()));
            setCellValue(row, j++, ssrvVO.getSrvc().getEtiqueta());
            setCellValue(row, j++, ssrvVO.getNumero());

            if (tpssDetail.getEnti().getTpdtEstado() != null) {
                setCellValue(row, j++, ssrvVO.getEstado());
            }

            if (tpssDetail.getEnti().isTemporal()) {
                setCellValue(row, j++, ssrvVO.getFini());
                setCellValue(row, j++, ssrvVO.getFfin());
            }

            for (final Long tpdtId : tpssDetail.getEntdList()) {
                final EntidadTipoDatoVO entd = tpssDetail.getEntdMap().get(tpdtId);
                final ItemDatoVO itdt = ssrvVO.getItdtMap().get(entd.getTpdt().getId());

                setCellValue(row, j, entd, itdt);

                j++;
            }
        }

        autoSizeColumns(sheet, rowhead);
    }

}
