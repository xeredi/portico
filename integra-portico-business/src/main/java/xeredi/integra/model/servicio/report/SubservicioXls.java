package xeredi.integra.model.servicio.report;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import xeredi.integra.model.comun.exception.InternalErrorException;
import xeredi.integra.model.comun.proxy.PorticoResourceBundle;
import xeredi.integra.model.comun.report.BaseXls;
import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioDetailVO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioXls.
 */
public final class SubservicioXls extends BaseXls {

    /** The bundle. */
    private final ResourceBundle bundle;

    /**
     * Instantiates a new subservicio xls.
     *
     * @param locale
     *            the locale
     */
    public SubservicioXls(final Locale locale) {
        super(locale);

        bundle = PorticoResourceBundle.getBundle(locale);
    }

    /**
     * Generar subservicios.
     *
     * @param ssrvList
     *            the ssrv list
     * @param tpssDetail
     *            the tpss detail
     * @param stream
     *            the stream
     * @throws InternalErrorException
     *             Si ocurre algun error grave.
     */
    public void generarSubservicios(final List<SubservicioVO> ssrvList, final TipoSubservicioDetailVO tpssDetail,
            final OutputStream stream) throws InternalErrorException {
        try (final HSSFWorkbook workbook = new HSSFWorkbook()) {
            final HSSFSheet sheet = workbook.createSheet(bundle.getString("enti_" + tpssDetail.getEnti().getId()));

            // Cabecera XLS
            int rownum = 0;

            final HSSFRow rowhead = sheet.createRow(rownum++);
            int i = 0;

            setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.ssrv_tpss.name()));
            setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.ssrv_srvc.name()));
            setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.ssrv_numero.name()));

            if (tpssDetail.getEnti().getTpdtEstado() != null) {
                setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.ssrv_estado.name()));
            }

            if (tpssDetail.getEnti().isTemporal()) {
                setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.ssrv_fini.name()));
                setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.ssrv_ffin.name()));
            }

            for (final EntidadTipoDatoVO entd : tpssDetail.getEntdList()) {
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

                for (final EntidadTipoDatoVO entd : tpssDetail.getEntdList()) {
                    final ItemDatoVO itdt = ssrvVO.getItdtMap().get(entd.getTpdt().getId());

                    setCellValue(row, j, entd, itdt);

                    j++;
                }
            }

            autoSizeColumns(sheet, rowhead);
            workbook.write(stream);
        } catch (final IOException ex) {
            throw new InternalErrorException(ex);
        }
    }

}
