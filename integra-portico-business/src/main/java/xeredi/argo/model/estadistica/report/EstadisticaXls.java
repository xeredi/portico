package xeredi.argo.model.estadistica.report;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import xeredi.argo.model.comun.exception.InternalErrorException;
import xeredi.argo.model.comun.proxy.PorticoResourceBundle;
import xeredi.argo.model.comun.report.BaseXls;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.estadistica.vo.EstadisticaVO;
import xeredi.argo.model.item.vo.ItemDatoVO;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TipoEstadisticaDetailVO;

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
     * @param tpesDetail
     *            the tpes detail
     * @param stream
     *            the stream
     * @throws InternalErrorException
     *             the internal error exception
     */
    public void generarEstadisticas(final List<EstadisticaVO> estdList, final TipoEstadisticaDetailVO tpesDetail,
            final OutputStream stream) throws InternalErrorException {
        Preconditions.checkNotNull(estdList);
        Preconditions.checkNotNull(tpesDetail);
        Preconditions.checkNotNull(stream);

        try (final HSSFWorkbook workbook = new HSSFWorkbook()) {
            final HSSFSheet sheet = workbook.createSheet(bundle.getString("enti_" + tpesDetail.getEnti().getId()));

            // Cabecera XLS
            int rownum = 0;

            final HSSFRow rowhead = sheet.createRow(rownum++);
            int i = 0;

            setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.tpes.name()));
            setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.pepr.name()));
            setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.prto.name()));

            for (final Long tpdtId : tpesDetail.getEntdList()) {
                final EntidadTipoDatoVO entd = tpesDetail.getEntdMap().get(tpdtId);

                setCellValue(rowhead, i++, bundle.getString("entd_" + entd.getId()));
            }

            // Filas XLS
            for (final EstadisticaVO estdVO : estdList) {
                final HSSFRow row = sheet.createRow(rownum++);

                int j = 0;

                setCellValue(row, j++, bundle.getString("enti_" + tpesDetail.getEnti().getId()));
                setCellValue(row, j++, estdVO.getPepr().getEtiqueta());
                setCellValue(row, j++, estdVO.getPrto().getEtiqueta());

                for (final Long tpdtId : tpesDetail.getEntdList()) {
                    final EntidadTipoDatoVO entd = tpesDetail.getEntdMap().get(tpdtId);
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