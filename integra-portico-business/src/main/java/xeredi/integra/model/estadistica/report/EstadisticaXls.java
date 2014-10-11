package xeredi.integra.model.estadistica.report;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import xeredi.integra.model.comun.report.BaseXls;
import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.estadistica.vo.EstadisticaVO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticaXls.
 */
public final class EstadisticaXls extends BaseXls {

    /**
     * Instantiates a new estadistica xls.
     *
     * @param alocale
     *            the alocale
     */
    public EstadisticaXls(final Locale alocale) {
        super(alocale);
    }

    /**
     * Generar estadisticas.
     *
     * @param estdList
     *            the estd list
     * @param tpesVO
     *            the tpes vo
     * @param stream
     *            the stream
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public void generarEstadisticas(final List<EstadisticaVO> estdList, final TipoEstadisticaVO tpesVO,
            final OutputStream stream) throws IOException {
        Preconditions.checkNotNull(estdList);
        Preconditions.checkNotNull(tpesVO);
        Preconditions.checkNotNull(stream);

        final HSSFWorkbook workbook = new HSSFWorkbook();
        final HSSFSheet sheet = workbook.createSheet(tpesVO.getNombre());

        // Cabecera XLS
        int rownum = 0;

        final HSSFRow rowhead = sheet.createRow(rownum++);
        int i = 0;

        setCellValue(rowhead, i++, bundle.getString("estd_tpes"));
        setCellValue(rowhead, i++, bundle.getString("estd_pepr"));
        setCellValue(rowhead, i++, bundle.getString("estd_subp"));

        for (final Long tpdtId : tpesVO.getEntdList()) {
            setCellValue(rowhead, i++, tpesVO.getEntdMap().get(tpdtId).getEtiqueta());
        }

        // Filas XLS
        for (final EstadisticaVO estdVO : estdList) {
            final HSSFRow row = sheet.createRow(rownum++);

            int j = 0;

            setCellValue(row, j++, tpesVO.getNombre());
            setCellValue(row, j++, estdVO.getPepr().getEtiqueta());
            setCellValue(row, j++, estdVO.getSubp().getEtiqueta());

            for (final Long tpdtId : tpesVO.getEntdList()) {
                final EntidadTipoDatoVO entdVO = tpesVO.getEntdMap().get(tpdtId);
                final ItemDatoVO itdtVO = estdVO.getItdtMap().get(tpdtId);

                setCellValue(row, j, entdVO, itdtVO);

                j++;
            }
        }

        autoSizeColumns(sheet, rowhead);
        workbook.write(stream);
    }

}
