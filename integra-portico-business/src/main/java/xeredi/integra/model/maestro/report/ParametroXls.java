package xeredi.integra.model.maestro.report;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.annotation.Nonnull;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import xeredi.integra.model.comun.exception.InternalErrorException;
import xeredi.integra.model.comun.proxy.PorticoResourceBundle;
import xeredi.integra.model.comun.report.BaseXls;
import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoParametroDetailVO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;

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
     * @param prmtList
     *            the prmt list
     * @param tpprVO
     *            the tppr vo
     * @param stream
     *            the stream
     * @throws InternalErrorException
     *             Si ocurre algun error grave.
     */
    public void generarMaestros(final @Nonnull List<ParametroVO> prmtList,
            final @Nonnull TipoParametroDetailVO tpprDetail, final @Nonnull OutputStream stream)
            throws InternalErrorException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("XLS Generation start");
        }

        try (final HSSFWorkbook workbook = new HSSFWorkbook()) {
            final HSSFSheet sheet = workbook.createSheet(bundle.getString("enti_" + tpprDetail.getEnti().getId()));

            // Cabecera XLS
            int rownum = 0;

            final HSSFRow rowhead = sheet.createRow(rownum++);
            int i = 0;

            if (tpprDetail.getEnti().isPuerto()) {
                setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.prto.name()));
            }

            setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.prmt_parametro.name()));

            if (tpprDetail.getEnti().isI18n()) {
                setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.i18n_text.name()));
            }

            setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.prmt_fini.name()));
            setCellValue(rowhead, i++, bundle.getString(MessageI18nKey.prmt_ffin.name()));

            if (tpprDetail.getEntdList() != null) {
                for (final EntidadTipoDatoVO entd : tpprDetail.getEntdList()) {
                    setCellValue(rowhead, i++, bundle.getString("entd_" + entd.getId()));
                }
            }

            // Filas XLS
            for (final ParametroVO prmtVO : prmtList) {
                final HSSFRow row = sheet.createRow(rownum++);

                int j = 0;

                if (tpprDetail.getEnti().isPuerto()) {
                    setCellValue(row, j++, prmtVO.getPrto().getEtiqueta());
                }

                setCellValue(row, j++, prmtVO.getParametro());

                if (tpprDetail.getEnti().isI18n()) {
                    setCellValue(row, j++, prmtVO.getTexto());
                }

                setCellValue(row, j++, prmtVO.getVersion().getFini());
                setCellValue(row, j++, prmtVO.getVersion().getFfin());

                if (tpprDetail.getEntdList() != null) {
                    for (final EntidadTipoDatoVO entd : tpprDetail.getEntdList()) {
                        final ItemDatoVO itdt = prmtVO.getItdtMap().get(entd.getTpdt().getId());

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
