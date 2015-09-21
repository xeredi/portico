package xeredi.argo.model.maestro.report;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import xeredi.argo.model.comun.exception.InternalErrorException;
import xeredi.argo.model.comun.proxy.PorticoResourceBundle;
import xeredi.argo.model.comun.report.BaseXls;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.item.vo.ItemDatoVO;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TipoParametroDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroXls.
 */
public final class ParametroXls extends BaseXls {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ParametroXls.class);

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
     * @param itemList
     *            the item list
     * @param entiDetail
     *            the enti detail
     * @param stream
     *            the stream
     * @throws InternalErrorException
     *             Si ocurre algun error grave.
     */
    public void generarMaestros(final List<ParametroVO> itemList, final TipoParametroDetailVO entiDetail,
            final OutputStream stream) throws InternalErrorException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("XLS Generation start");
        }

        try (final HSSFWorkbook workbook = new HSSFWorkbook()) {
            final HSSFSheet sheet = workbook.createSheet(bundle.getString("enti_" + entiDetail.getEnti().getId()));

            // Cabecera XLS
            int rownum = 0;

            final HSSFRow rowhead = sheet.createRow(rownum++);
            int i = 0;

            if (entiDetail.getEnti().isPuerto()) {
                setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.prto.name()));
            }

            setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.prmt_parametro.name()));

            if (entiDetail.getEnti().isI18n()) {
                setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.i18n_text.name()));
            }

            setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.fini.name()));
            setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.ffin.name()));

            if (entiDetail.getEnti().isGis()) {
                setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.prmt_lat.name()));
                setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.prmt_lon.name()));
            }

            if (entiDetail.getEntdList() != null) {
                for (final Long tpdtId : entiDetail.getEntdList()) {
                    final EntidadTipoDatoVO entd = entiDetail.getEntdMap().get(tpdtId);

                    setCellValue(rowhead, i++, bundle.getString("entd_" + entd.getId()));
                }
            }

            // Filas XLS
            for (final ParametroVO item : itemList) {
                final HSSFRow row = sheet.createRow(rownum++);

                int j = 0;

                if (entiDetail.getEnti().isPuerto()) {
                    setCellValue(row, j++, item.getPrto().getEtiqueta());
                }

                setCellValue(row, j++, item.getParametro());

                if (entiDetail.getEnti().isI18n()) {
                    setCellValue(row, j++, item.getTexto());
                }

                setCellValue(row, j++, item.getVersion().getFini());
                setCellValue(row, j++, item.getVersion().getFfin());

                if (entiDetail.getEnti().isGis()) {
                    setCellValue(row, j++, item.getVersion().getLat());
                    setCellValue(row, j++, item.getVersion().getLon());
                }

                if (entiDetail.getEntdList() != null) {
                    for (final Long tpdtId : entiDetail.getEntdList()) {
                        final EntidadTipoDatoVO entd = entiDetail.getEntdMap().get(tpdtId);
                        final ItemDatoVO itdt = item.getItdtMap().get(entd.getTpdt().getId());

                        setCellValue(row, j, entd, itdt);

                        j++;
                    }
                }
            }

            if (LOG.isDebugEnabled()) {
                LOG.debug("XLS Autosize start");
            }

            autoSizeColumns(sheet, rowhead);
            workbook.write(stream);
        } catch (final IOException ex) {
            throw new InternalErrorException(ex);
        }

        if (LOG.isDebugEnabled()) {
            LOG.debug("XLS Generation end");
        }
    }

}
