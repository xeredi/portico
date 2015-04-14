package xeredi.integra.model.servicio.report;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.annotation.Nonnull;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import xeredi.integra.model.comun.exception.InternalErrorException;
import xeredi.integra.model.comun.proxy.PorticoResourceBundle;
import xeredi.integra.model.comun.report.BaseXls;
import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.proxy.TipoServicioDetailVO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioXls.
 */
public final class ServicioXls extends BaseXls {

    /** The bundle. */
    private final ResourceBundle bundle;

    /**
     * Instantiates a new servicio xls.
     *
     * @param locale
     *            the locale
     */
    public ServicioXls(final Locale locale) {
        super(locale);

        bundle = PorticoResourceBundle.getBundle(locale);
    }

    /**
     * Generar servicios.
     *
     * @param srvcList
     *            the srvc list
     * @param tpsrVO
     *            the tpsr vo
     * @param stream
     *            the stream
     * @throws InternalErrorException
     *             Si ocurre algun error grave.
     */
    public void generarServicios(final @Nonnull List<ServicioVO> srvcList,
            final @Nonnull TipoServicioDetailVO tpsrDetail, final @Nonnull OutputStream stream)
                    throws InternalErrorException {
        try (final HSSFWorkbook workbook = new HSSFWorkbook()) {
            final HSSFSheet sheet = workbook.createSheet(bundle.getString("enti_" + tpsrDetail.getEnti().getId()));

            // Cabecera XLS
            int rownum = 0;

            final HSSFRow rowhead = sheet.createRow(rownum++);
            int i = 0;

            setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.srvc_tpsr.name()));
            setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.prto.name()));
            setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.srvc_anno.name()));
            setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.srvc_numero.name()));
            setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.srvc_falta.name()));
            setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.srvc_fref.name()));

            if (tpsrDetail.getEnti().getTpdtEstado() != null) {
                setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.srvc_estado.name()));
            }

            if (tpsrDetail.getEnti().isTemporal()) {
                setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.srvc_fini.name()));
                setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.srvc_ffin.name()));
            }

            for (final EntidadTipoDatoVO entd : tpsrDetail.getEntdList()) {
                setCellValue(rowhead, i++, bundle.getString("entd_" + entd.getId()));
            }

            // Filas XLS
            for (final ServicioVO srvcVO : srvcList) {
                final HSSFRow row = sheet.createRow(rownum++);

                int j = 0;

                setCellValue(row, j++, bundle.getString("enti_" + tpsrDetail.getEnti().getId()));
                setCellValue(row, j++, srvcVO.getPrto().getCodigo());
                setCellValue(row, j++, srvcVO.getAnno());
                setCellValue(row, j++, srvcVO.getNumero());
                setCellValue(row, j++, srvcVO.getFalta());
                setCellValue(row, j++, srvcVO.getFref());

                if (tpsrDetail.getEnti().getTpdtEstado() != null) {
                    setCellValue(row, j++, srvcVO.getEstado());
                }

                if (tpsrDetail.getEnti().isTemporal()) {
                    setCellValue(row, j++, srvcVO.getFini());
                    setCellValue(row, j++, srvcVO.getFfin());
                }

                for (final EntidadTipoDatoVO entd : tpsrDetail.getEntdList()) {
                    final ItemDatoVO itdt = srvcVO.getItdtMap().get(entd.getTpdt().getId());

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
