package xeredi.integra.model.servicio.report;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import xeredi.integra.model.comun.report.BaseXls;
import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioXls.
 */
public final class SubservicioXls extends BaseXls {

    /**
     * Instantiates a new subservicio xls.
     *
     * @param alocale
     *            the alocale
     */
    public SubservicioXls(final Locale alocale) {
        super(alocale);
    }

    /**
     * Generar subservicios.
     *
     * @param ssrvList
     *            the ssrv list
     * @param tpssVO
     *            the tpss vo
     * @param stream
     *            the stream
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public void generarSubservicios(final List<SubservicioVO> ssrvList, final TipoSubservicioVO tpssVO,
            final OutputStream stream) throws IOException {
        Preconditions.checkNotNull(ssrvList);
        Preconditions.checkNotNull(tpssVO);
        Preconditions.checkNotNull(stream);

        final HSSFWorkbook workbook = new HSSFWorkbook();
        final HSSFSheet sheet = workbook.createSheet(tpssVO.getNombre());

        // Cabecera XLS
        int rownum = 0;

        final HSSFRow rowhead = sheet.createRow(rownum++);
        int i = 0;

        setCellValue(rowhead, i++, bundle.getString("ssrv_tpss"));
        setCellValue(rowhead, i++, bundle.getString("ssrv_srvc"));
        setCellValue(rowhead, i++, bundle.getString("ssrv_numero"));

        if (tpssVO.getTpdtEstado() != null) {
            setCellValue(rowhead, i++, bundle.getString("ssrv_estado"));
        }

        if (tpssVO.getTemporal()) {
            setCellValue(rowhead, i++, bundle.getString("ssrv_fini"));
            setCellValue(rowhead, i++, bundle.getString("ssrv_ffin"));
        }

        for (final Long tpdtId : tpssVO.getEntdList()) {
            setCellValue(rowhead, i++, tpssVO.getEntdMap().get(tpdtId).getEtiqueta());
        }

        // Filas XLS
        for (final SubservicioVO ssrvVO : ssrvList) {
            final HSSFRow row = sheet.createRow(rownum++);

            int j = 0;

            setCellValue(row, j++, tpssVO.getNombre());
            setCellValue(row, j++, ssrvVO.getSrvc().getEtiqueta());
            setCellValue(row, j++, ssrvVO.getNumero());

            if (tpssVO.getTpdtEstado() != null) {
                setCellValue(row, j++, ssrvVO.getEstado());
            }

            if (tpssVO.getTemporal()) {
                setCellValue(row, j++, ssrvVO.getFini());
                setCellValue(row, j++, ssrvVO.getFfin());
            }

            for (final Long tpdtId : tpssVO.getEntdList()) {
                final EntidadTipoDatoVO entdVO = tpssVO.getEntdMap().get(tpdtId);
                final ItemDatoVO itdtVO = ssrvVO.getItdtMap().get(tpdtId);

                setCellValue(row, j, entdVO, itdtVO);

                j++;
            }
        }

        autoSizeColumns(sheet, rowhead);
        workbook.write(stream);
    }

}
