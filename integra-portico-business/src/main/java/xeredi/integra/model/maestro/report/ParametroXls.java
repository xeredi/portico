package xeredi.integra.model.maestro.report;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import xeredi.integra.model.comun.report.BaseXls;
import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroXls.
 */
public final class ParametroXls extends BaseXls {

    /**
     * Instantiates a new parametro xls.
     *
     * @param locale
     *            the locale
     */
    public ParametroXls(final Locale locale) {
        super(locale);
    }

    /**
     * Generar maestros.
     *
     * @param prmtList
     *            the prmt list
     * @param tpprVO
     *            the tppr vo
     * @param stream
     *            the stream
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public void generarMaestros(final List<ParametroVO> prmtList, final TipoParametroVO tpprVO,
            final OutputStream stream) throws IOException {
        Preconditions.checkNotNull(prmtList);
        Preconditions.checkNotNull(tpprVO);
        Preconditions.checkNotNull(stream);

        final HSSFWorkbook workbook = new HSSFWorkbook();
        final HSSFSheet sheet = workbook.createSheet(tpprVO.getNombre());

        // Cabecera XLS
        int rownum = 0;

        final HSSFRow rowhead = sheet.createRow(rownum++);
        int i = 0;

        setCellValue(rowhead, i++, bundle.getString("prmt_parametro"));

        if (tpprVO.getI18n()) {
            setCellValue(rowhead, i++, bundle.getString("p18n_texto"));
        }

        setCellValue(rowhead, i++, bundle.getString("prmt_fini"));
        setCellValue(rowhead, i++, bundle.getString("prmt_ffin"));

        for (final Long tpdtId : tpprVO.getEntdList()) {
            setCellValue(rowhead, i++, tpprVO.getEntdMap().get(tpdtId).getEtiqueta());
        }

        // Filas XLS
        for (final ParametroVO prmtVO : prmtList) {
            final HSSFRow row = sheet.createRow(rownum++);

            int j = 0;

            setCellValue(row, j++, prmtVO.getParametro());

            if (tpprVO.getI18n()) {
                setCellValue(row, j++, prmtVO.getI18n().getTexto());
            }

            setCellValue(row, j++, prmtVO.getPrvr().getFini());
            setCellValue(row, j++, prmtVO.getPrvr().getFfin());

            for (final Long tpdtId : tpprVO.getEntdList()) {
                final EntidadTipoDatoVO entdVO = tpprVO.getEntdMap().get(tpdtId);
                final ItemDatoVO itdtVO = prmtVO.getItdtMap().get(tpdtId);

                setCellValue(row, j, entdVO, itdtVO);

                j++;
            }
        }

        autoSizeColumns(sheet, rowhead);
        workbook.write(stream);
    }

}
