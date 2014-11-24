package xeredi.integra.model.estadistica.report;

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
import xeredi.integra.model.estadistica.vo.EstadisticaVO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticaXls.
 */
public final class EstadisticaXls extends BaseXls {

    /** The bundle. */
    private final ResourceBundle bundle;

    /**
     * Instantiates a new estadistica xls.
     *
     * @param locale
     *            the locale
     */
    public EstadisticaXls(final Locale locale) {
        super(locale);

        bundle = PorticoResourceBundle.getBundle(locale);
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
     * @throws InternalErrorException
     *             the internal error exception
     */
    public void generarEstadisticas(final List<EstadisticaVO> estdList, final TipoEstadisticaVO tpesVO,
            final OutputStream stream) throws InternalErrorException {
        Preconditions.checkNotNull(estdList);
        Preconditions.checkNotNull(tpesVO);
        Preconditions.checkNotNull(stream);

        try {
            final HSSFWorkbook workbook = new HSSFWorkbook();
            final HSSFSheet sheet = workbook.createSheet(bundle.getString("enti_" + tpesVO.getId()));

            // Cabecera XLS
            int rownum = 0;

            final HSSFRow rowhead = sheet.createRow(rownum++);
            int i = 0;

            setCellValue(rowhead, i++, bundle.getString("estd_tpes"));
            setCellValue(rowhead, i++, bundle.getString("estd_pepr"));
            setCellValue(rowhead, i++, bundle.getString("estd_subp"));

            for (final EntidadTipoDatoVO entd : tpesVO.getEntdList()) {
                setCellValue(rowhead, i++, bundle.getString("entd_" + entd.getId()));
            }

            // Filas XLS
            for (final EstadisticaVO estdVO : estdList) {
                final HSSFRow row = sheet.createRow(rownum++);

                int j = 0;

                setCellValue(row, j++, bundle.getString("enti_" + tpesVO.getId()));
                setCellValue(row, j++, estdVO.getPepr().getEtiqueta());
                setCellValue(row, j++, estdVO.getSubp().getEtiqueta());

                for (final EntidadTipoDatoVO entd : tpesVO.getEntdList()) {
                    final ItemDatoVO itdtVO = estdVO.getItdtMap().get(entd.getTpdt().getId());

                    setCellValue(row, j, entd, itdtVO);

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
