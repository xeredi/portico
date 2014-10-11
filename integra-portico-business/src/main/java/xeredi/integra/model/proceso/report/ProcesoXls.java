package xeredi.integra.model.proceso.report;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import xeredi.integra.model.comun.report.BaseXls;
import xeredi.integra.model.proceso.vo.ProcesoVO;

import com.google.common.base.Preconditions;

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
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public void generarProcesos(final List<ProcesoVO> prbtList, final OutputStream stream) throws IOException {
        Preconditions.checkNotNull(prbtList);
        Preconditions.checkNotNull(stream);

        final HSSFWorkbook workbook = new HSSFWorkbook();
        final HSSFSheet sheet = workbook.createSheet("prbtList");

        // Cabecera XLS
        int rownum = 0;

        final HSSFRow rowhead = sheet.createRow(rownum++);
        int i = 0;

        setCellValue(rowhead, i++, bundle.getString("prbt.id"));
        setCellValue(rowhead, i++, bundle.getString("prbt.modulo"));
        setCellValue(rowhead, i++, bundle.getString("prbt.tipo"));
        setCellValue(rowhead, i++, bundle.getString("prbt.estado"));
        setCellValue(rowhead, i++, bundle.getString("prbt.falta"));
        setCellValue(rowhead, i++, bundle.getString("prbt.finicio"));
        setCellValue(rowhead, i++, bundle.getString("prbt.ffin"));
        setCellValue(rowhead, i++, bundle.getString("prbt.duracion"));
        setCellValue(rowhead, i++, bundle.getString("prbt.erroresCnt"));
        setCellValue(rowhead, i++, bundle.getString("prbt.alertasCnt"));
        setCellValue(rowhead, i++, bundle.getString("prbt.mensajesCnt"));

        // Filas XLS
        for (final ProcesoVO prbtVO : prbtList) {
            final HSSFRow row = sheet.createRow(rownum++);

            int j = 0;

            setCellValue(row, j++, prbtVO.getId());
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
    }

}
