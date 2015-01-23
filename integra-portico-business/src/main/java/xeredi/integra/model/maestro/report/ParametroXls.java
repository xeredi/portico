package xeredi.integra.model.maestro.report;

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
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroXls.
 */
public final class ParametroXls extends BaseXls {

    /** The bundle. */
    private final ResourceBundle bundle;

    /**
     * Instantiates a new parametro xls.
     *
     * @param locale
     *            the locale
     */
    public ParametroXls(final Locale locale) {
        super(locale);

        bundle = PorticoResourceBundle.getBundle(locale);
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
     * @throws InternalErrorException
     *             Si ocurre algun error grave.
     */
    public void generarMaestros(final List<ParametroVO> prmtList, final TipoParametroVO tpprVO,
            final OutputStream stream) throws InternalErrorException {
        Preconditions.checkNotNull(prmtList);
        Preconditions.checkNotNull(tpprVO);
        Preconditions.checkNotNull(stream);

        try (final HSSFWorkbook workbook = new HSSFWorkbook()) {
            final HSSFSheet sheet = workbook.createSheet(bundle.getString("enti_" + tpprVO.getId()));

            // Cabecera XLS
            int rownum = 0;

            final HSSFRow rowhead = sheet.createRow(rownum++);
            int i = 0;

            setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.prmt_parametro.name()));

            if (tpprVO.getI18n()) {
                setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.i18n_text.name()));
            }

            setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.prmt_fini.name()));
            setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.prmt_ffin.name()));

            if (tpprVO.getEntdList() != null) {
                for (final EntidadTipoDatoVO entd : tpprVO.getEntdList()) {
                    setCellValue(rowhead, i++, bundle.getString("entd_" + entd.getId()));
                }
            }

            // Filas XLS
            for (final ParametroVO prmtVO : prmtList) {
                final HSSFRow row = sheet.createRow(rownum++);

                int j = 0;

                setCellValue(row, j++, prmtVO.getParametro());

                if (tpprVO.getI18n()) {
                    setCellValue(row, j++, prmtVO.getTexto());
                }

                setCellValue(row, j++, prmtVO.getPrvr().getFini());
                setCellValue(row, j++, prmtVO.getPrvr().getFfin());

                if (tpprVO.getEntdList() != null) {
                    for (final EntidadTipoDatoVO entd : tpprVO.getEntdList()) {
                        final ItemDatoVO itdt = prmtVO.getItdtMap().get(entd.getTpdt().getId());

                        setCellValue(row, j, entd, itdt);

                        j++;
                    }
                }
            }

            autoSizeColumns(sheet, rowhead);
            workbook.write(stream);
        } catch (final IOException ex) {
            throw new InternalErrorException(ex);
        }
    }

}
