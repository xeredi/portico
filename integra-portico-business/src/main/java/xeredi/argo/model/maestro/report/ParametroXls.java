package xeredi.argo.model.maestro.report;

import java.io.OutputStream;
import java.util.List;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

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

    /** The item list. */
    private final List<ParametroVO> itemList;

    /** The enti detail. */
    private final TipoParametroDetailVO entiDetail;

    /**
     * Instantiates a new parametro xls.
     *
     * @param locale
     *            the locale
     * @param stream
     *            the stream
     * @param itemList
     *            the item list
     * @param entiDetail
     *            the enti detail
     */
    public ParametroXls(final Locale locale, final OutputStream stream, final List<ParametroVO> itemList,
            final TipoParametroDetailVO entiDetail) {
        super(locale, stream);

        this.itemList = itemList;
        this.entiDetail = entiDetail;
    }

    /**
     * {@inheritDoc}
     */
    public void doGenerate(final HSSFWorkbook workbook) {
        final HSSFSheet sheet = workbook.createSheet(getBundle().getString("enti_" + entiDetail.getEnti().getId()));

        // Cabecera XLS
        int rownum = 0;

        final HSSFRow rowhead = sheet.createRow(rownum++);
        int i = 0;

        if (entiDetail.getEnti().getPuerto()) {
            setCellValue(rowhead, i++, getBundle().getString(MessageI18nKey.prto.name()));
        }

        setCellValue(rowhead, i++, getBundle().getString(MessageI18nKey.prmt_parametro.name()));

        if (entiDetail.getEnti().isI18n()) {
            setCellValue(rowhead, i++, getBundle().getString(MessageI18nKey.i18n_text.name()));
        }

        setCellValue(rowhead, i++, getBundle().getString(MessageI18nKey.fini.name()));
        setCellValue(rowhead, i++, getBundle().getString(MessageI18nKey.ffin.name()));

        if (entiDetail.getEnti().getGis()) {
            setCellValue(rowhead, i++, getBundle().getString(MessageI18nKey.prmt_lat.name()));
            setCellValue(rowhead, i++, getBundle().getString(MessageI18nKey.prmt_lon.name()));
        }

        if (entiDetail.getEntdList() != null) {
            for (final Long tpdtId : entiDetail.getEntdList()) {
                final EntidadTipoDatoVO entd = entiDetail.getEntdMap().get(tpdtId);

                setCellValue(rowhead, i++, getBundle().getString("entd_" + entd.getId()));
            }
        }

        // Filas XLS
        for (final ParametroVO item : itemList) {
            final HSSFRow row = sheet.createRow(rownum++);

            int j = 0;

            if (entiDetail.getEnti().getPuerto()) {
                setCellValue(row, j++, item.getPrto().getEtiqueta());
            }

            setCellValue(row, j++, item.getParametro());

            if (entiDetail.getEnti().isI18n()) {
                setCellValue(row, j++, item.getTexto());
            }

            setCellValue(row, j++, item.getVersion().getFini());
            setCellValue(row, j++, item.getVersion().getFfin());

            if (entiDetail.getEnti().getGis()) {
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
    }

}
