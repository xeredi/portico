package xeredi.integra.model.servicio.report;

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
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoServicioVO;
import xeredi.integra.model.servicio.vo.ServicioVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioXls.
 */
public final class ServicioXls extends BaseXls {

    /** The bundle. */
    private final ResourceBundle bundle;

    /**
     * Instantiates a new servicio xls.
     *
     * @param locale
     *            the locale
     */
    public ServicioXls(final Locale locale) {
        super(locale);

        bundle = PorticoResourceBundle.getBundle(locale);
    }

    /**
     * Generar servicios.
     *
     * @param srvcList
     *            the srvc list
     * @param tpsrVO
     *            the tpsr vo
     * @param stream
     *            the stream
     * @throws InternalErrorException
     *             Si ocurre algun error grave.
     */
    public void generarServicios(final List<ServicioVO> srvcList, final TipoServicioVO tpsrVO, final OutputStream stream)
            throws InternalErrorException {
        Preconditions.checkNotNull(srvcList);
        Preconditions.checkNotNull(tpsrVO);
        Preconditions.checkNotNull(stream);

        try (final HSSFWorkbook workbook = new HSSFWorkbook()) {
            final HSSFSheet sheet = workbook.createSheet(bundle.getString("enti_" + tpsrVO.getId()));

            // Cabecera XLS
            int rownum = 0;

            final HSSFRow rowhead = sheet.createRow(rownum++);
            int i = 0;

            setCellValue(rowhead, i++, bundle.getString("srvc_tpsr"));
            setCellValue(rowhead, i++, bundle.getString("srvc_subp"));
            setCellValue(rowhead, i++, bundle.getString("srvc_anno"));
            setCellValue(rowhead, i++, bundle.getString("srvc_numero"));
            setCellValue(rowhead, i++, bundle.getString("srvc_falta"));
            setCellValue(rowhead, i++, bundle.getString("srvc_fref"));

            if (tpsrVO.getTpdtEstado() != null) {
                setCellValue(rowhead, i++, bundle.getString("srvc_estado"));
            }

            if (tpsrVO.getTemporal()) {
                setCellValue(rowhead, i++, bundle.getString("srvc_fini"));
                setCellValue(rowhead, i++, bundle.getString("srvc_ffin"));
            }

            for (final EntidadTipoDatoVO entd : tpsrVO.getEntdList()) {
                setCellValue(rowhead, i++, bundle.getString("entd_" + entd.getId()));
            }

            // Filas XLS
            for (final ServicioVO srvcVO : srvcList) {
                final HSSFRow row = sheet.createRow(rownum++);

                int j = 0;

                setCellValue(row, j++, bundle.getString("enti_" + tpsrVO.getId()));
                setCellValue(row, j++, srvcVO.getSubp().getParametro());
                setCellValue(row, j++, srvcVO.getAnno());
                setCellValue(row, j++, srvcVO.getNumero());
                setCellValue(row, j++, srvcVO.getFalta());
                setCellValue(row, j++, srvcVO.getFref());

                if (tpsrVO.getTpdtEstado() != null) {
                    setCellValue(row, j++, srvcVO.getEstado());
                }

                if (tpsrVO.getTemporal()) {
                    setCellValue(row, j++, srvcVO.getFini());
                    setCellValue(row, j++, srvcVO.getFfin());
                }

                for (final EntidadTipoDatoVO entd : tpsrVO.getEntdList()) {
                    final ItemDatoVO itdt = srvcVO.getItdtMap().get(entd.getTpdt().getId());

                    setCellValue(row, j, entd, itdt);

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
