package xeredi.argo.model.proceso.report;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import xeredi.argo.model.comun.exception.InternalErrorException;
import xeredi.argo.model.comun.report.BaseXls;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.proceso.vo.ProcesoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoXls.
 */
public final class ProcesoXls extends BaseXls {

    /**
     * Instantiates a new proceso xls.
     *
     * @param alocale
     *            the alocale
     */
    public ProcesoXls(final Locale alocale) {
        super(alocale);
    }

    /**
     * Generar procesos.
     *
     * @param prbtList
     *            the prbt list
     * @param stream
     *            the stream
     * @throws InternalErrorException
     *             the internal error exception
     */
    public void generarProcesos(final List<ProcesoVO> prbtList, final OutputStream stream)
            throws InternalErrorException {
        try (final HSSFWorkbook workbook = new HSSFWorkbook()) {
            final HSSFSheet sheet = workbook.createSheet("prbtList");

            // Cabecera XLS
            int rownum = 0;

            final HSSFRow rowhead = sheet.createRow(rownum++);
            int i = 0;

            setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.prbt_modulo.name()));
            setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.prbt_tipo.name()));
            setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.prbt_estado.name()));
            setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.prbt_falta.name()));
            setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.fini.name()));
            setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.ffin.name()));
            setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.prbt_duracion.name()));
            setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.prbt_erroresCnt.name()));
            setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.prbt_alertasCnt.name()));
            setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.prbt_mensajesCnt.name()));

            // Filas XLS
            for (final ProcesoVO prbtVO : prbtList) {
                final HSSFRow row = sheet.createRow(rownum++);

                int j = 0;

                setCellValue(row, j++, prbtVO.getModulo().name());
                setCellValue(row, j++, prbtVO.getTipo().name());
                setCellValue(row, j++, prbtVO.getEstado().name());
                setCellValue(row, j++, prbtVO.getFalta());
                setCellValue(row, j++, prbtVO.getFinicio());
                setCellValue(row, j++, prbtVO.getFfin());
                setCellValue(row, j++, prbtVO.getDuracion());
                setCellValue(row, j++, prbtVO.getErroresCnt());
                setCellValue(row, j++, prbtVO.getAlertasCnt());
                setCellValue(row, j++, prbtVO.getMensajesCnt());
            }

            autoSizeColumns(sheet, rowhead);
            workbook.write(stream);
        } catch (final IOException ex) {
            throw new InternalErrorException(ex);
        }
    }

}