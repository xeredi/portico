package xeredi.integra.model.comun.report;

import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.estadistica.vo.EstadisticaVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaVO;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;
import xeredi.integra.model.metamodelo.vo.TipoServicioVO;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.integra.model.proceso.vo.ProcesoVO;
import xeredi.integra.model.servicio.vo.ServicioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;
import xeredi.integra.model.util.GlobalNames;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ExcelUtil.
 */
public final class ExcelUtil {

    /** The locale. */
    private final Locale locale;

    /** The bundle. */
    private final ResourceBundle bundle;

    /** The datetime format. */
    private final DateFormat datetimeFormat;

    /** The date format. */
    private final DateFormat dateFormat;

    /**
     * Instantiates a new excel util.
     *
     * @param alocale
     *            the alocale
     */
    public ExcelUtil(final Locale alocale) {
        super();

        Preconditions.checkNotNull(alocale);

        locale = alocale;
        bundle = ResourceBundle.getBundle(GlobalNames.MESSAGES, locale);
        datetimeFormat = new SimpleDateFormat(bundle.getString(GlobalNames.DATETIME_FORMAT_KEY));
        dateFormat = new SimpleDateFormat(bundle.getString(GlobalNames.DATE_FORMAT_KEY));
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

        setCellValue(rowhead, i++, bundle.getString("prmt.parametro"));

        if (tpprVO.getI18n()) {
            setCellValue(rowhead, i++, bundle.getString("p18n.texto"));
        }

        if (tpprVO.getTempExp()) {
            setCellValue(rowhead, i++, bundle.getString("prmt.finicio"));
            setCellValue(rowhead, i++, bundle.getString("prmt.ffin"));
        }

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

            if (tpprVO.getTempExp()) {
                setCellValue(row, j++, prmtVO.getPrvr().getFini());
                setCellValue(row, j++, prmtVO.getPrvr().getFfin());
            }

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

    /**
     * Generar servicios.
     *
     * @param srvcList
     *            the srvc list
     * @param tpsrVO
     *            the tpsr vo
     * @param stream
     *            the stream
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public void generarServicios(final List<ServicioVO> srvcList, final TipoServicioVO tpsrVO, final OutputStream stream)
            throws IOException {
        Preconditions.checkNotNull(srvcList);
        Preconditions.checkNotNull(tpsrVO);
        Preconditions.checkNotNull(stream);

        final HSSFWorkbook workbook = new HSSFWorkbook();
        final HSSFSheet sheet = workbook.createSheet(tpsrVO.getNombre());

        // Cabecera XLS
        int rownum = 0;

        final HSSFRow rowhead = sheet.createRow(rownum++);
        int i = 0;

        setCellValue(rowhead, i++, bundle.getString("tpsr"));
        setCellValue(rowhead, i++, bundle.getString("srvc.subp"));
        setCellValue(rowhead, i++, bundle.getString("srvc.anno"));
        setCellValue(rowhead, i++, bundle.getString("srvc.numero"));
        setCellValue(rowhead, i++, bundle.getString("srvc.falta"));
        setCellValue(rowhead, i++, bundle.getString("srvc.freferencia"));

        if (tpsrVO.getTpdtEstado() != null) {
            setCellValue(rowhead, i++, bundle.getString("srvc.estado"));
        }

        if (tpsrVO.getTemporal()) {
            setCellValue(rowhead, i++, bundle.getString("srvc.finicio"));
            setCellValue(rowhead, i++, bundle.getString("srvc.ffin"));
        }

        for (final Long tpdtId : tpsrVO.getEntdList()) {
            setCellValue(rowhead, i++, tpsrVO.getEntdMap().get(tpdtId).getEtiqueta());
        }

        // Filas XLS
        for (final ServicioVO srvcVO : srvcList) {
            final HSSFRow row = sheet.createRow(rownum++);

            int j = 0;

            setCellValue(row, j++, tpsrVO.getNombre());
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

            for (final Long tpdtId : tpsrVO.getEntdList()) {
                final EntidadTipoDatoVO entdVO = tpsrVO.getEntdMap().get(tpdtId);
                final ItemDatoVO itdtVO = srvcVO.getItdtMap().get(tpdtId);

                setCellValue(row, j, entdVO, itdtVO);

                j++;
            }
        }

        autoSizeColumns(sheet, rowhead);
        workbook.write(stream);
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

        setCellValue(rowhead, i++, bundle.getString("tpss"));
        setCellValue(rowhead, i++, bundle.getString("ssrv.srvc"));
        setCellValue(rowhead, i++, bundle.getString("ssrv.numero"));

        if (tpssVO.getTpdtEstado() != null) {
            setCellValue(rowhead, i++, bundle.getString("ssrv.estado"));
        }

        if (tpssVO.getTemporal()) {
            setCellValue(rowhead, i++, bundle.getString("ssrv.finicio"));
            setCellValue(rowhead, i++, bundle.getString("ssrv.ffin"));
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

        setCellValue(rowhead, i++, bundle.getString("estd.pepr"));
        setCellValue(rowhead, i++, bundle.getString("estd.autp"));

        for (final Long tpdtId : tpesVO.getEntdList()) {
            setCellValue(rowhead, i++, tpesVO.getEntdMap().get(tpdtId).getEtiqueta());
        }

        // Filas XLS
        for (final EstadisticaVO estdVO : estdList) {
            final HSSFRow row = sheet.createRow(rownum++);

            int j = 0;

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

    /**
     * Generar procesos.
     *
     * @param prbtList
     *            the prbt list
     * @param stream
     *            the stream
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public void generarProcesos(final List<ProcesoVO> prbtList, final OutputStream stream) throws IOException {
        Preconditions.checkNotNull(prbtList);
        Preconditions.checkNotNull(stream);

        final HSSFWorkbook workbook = new HSSFWorkbook();
        final HSSFSheet sheet = workbook.createSheet("prbtList");

        // Cabecera XLS
        int rownum = 0;

        final HSSFRow rowhead = sheet.createRow(rownum++);
        int i = 0;

        setCellValue(rowhead, i++, bundle.getString("prbt.id"));
        setCellValue(rowhead, i++, bundle.getString("prbt.modulo"));
        setCellValue(rowhead, i++, bundle.getString("prbt.tipo"));
        setCellValue(rowhead, i++, bundle.getString("prbt.estado"));
        setCellValue(rowhead, i++, bundle.getString("prbt.falta"));
        setCellValue(rowhead, i++, bundle.getString("prbt.finicio"));
        setCellValue(rowhead, i++, bundle.getString("prbt.ffin"));
        setCellValue(rowhead, i++, bundle.getString("prbt.duracion"));
        setCellValue(rowhead, i++, bundle.getString("prbt.erroresCnt"));
        setCellValue(rowhead, i++, bundle.getString("prbt.alertasCnt"));
        setCellValue(rowhead, i++, bundle.getString("prbt.mensajesCnt"));

        // Filas XLS
        for (final ProcesoVO prbtVO : prbtList) {
            final HSSFRow row = sheet.createRow(rownum++);

            int j = 0;

            setCellValue(row, j++, prbtVO.getId());
            setCellValue(row, j++, prbtVO.getModulo().name());
            setCellValue(row, j++, prbtVO.getTipo().name());
            setCellValue(row, j++, prbtVO.getEstado().name());
            setCellValue(row, j++, prbtVO.getFalta());
            setCellValue(row, j++, prbtVO.getFinicio());
            setCellValue(row, j++, prbtVO.getFfin());
            setCellValue(row, j++, prbtVO.getDuracion());
            setCellValue(row, j++, prbtVO.getErroresCnt());
            setCellValue(row, j++, prbtVO.getAlertasCnt());
            setCellValue(row, j++, prbtVO.getMensajesCnt());
        }

        autoSizeColumns(sheet, rowhead);
        workbook.write(stream);
    }

    /**
     * Sets the cell value.
     *
     * @param row
     *            the row
     * @param position
     *            the position
     * @param entdVO
     *            the entd vo
     * @param itdtVO
     *            the itdt vo
     */
    private void setCellValue(final HSSFRow row, final int position, final EntidadTipoDatoVO entdVO,
            final ItemDatoVO itdtVO) {
        Preconditions.checkNotNull(row);
        Preconditions.checkNotNull(entdVO);

        if (itdtVO != null) {
            switch (entdVO.getTpdt().getTipoElemento()) {
            case BO:
                if (itdtVO.getBooleano() != null) {
                    row.createCell(position).setCellValue(bundle.getString("boolean." + itdtVO.getBooleano()));
                }

                break;
            case ND:
                if (itdtVO.getCantidadDecimal() != null) {
                    row.createCell(position).setCellValue(itdtVO.getCantidadDecimal());
                }

                break;
            case NE:
                if (itdtVO.getCantidadEntera() != null) {
                    row.createCell(position).setCellValue(itdtVO.getCantidadEntera());
                }

                break;
            case PR:
                if (itdtVO.getPrmt() != null) {
                    setCellValue(row, position, itdtVO.getPrmt().obtenerEtiquetaCSV());
                }

                break;
            case SR:
                if (itdtVO.getSrvc() != null) {
                    setCellValue(row, position, itdtVO.getSrvc().getEtiqueta());
                }

                break;
            case CR:
            case TX:
                if (itdtVO.getCadena() != null) {
                    row.createCell(position).setCellValue(itdtVO.getCadena());
                }

                break;
            case FE:
                if (itdtVO.getFecha() != null) {
                    row.createCell(position).setCellValue(dateFormat.format(itdtVO.getFecha()));
                }

                break;
            case FH:
                if (itdtVO.getFecha() != null) {
                    row.createCell(position).setCellValue(datetimeFormat.format(itdtVO.getFecha()));
                }

                break;
            default:
                throw new Error("Tipo de Elemento desconocido: " + entdVO.getTpdt().getTipoElemento());
            }
        }
    }

    /**
     * Sets the cell value.
     *
     * @param row
     *            the row
     * @param position
     *            the position
     * @param value
     *            the value
     */
    private void setCellValue(final HSSFRow row, final int position, final Object value) {
        Preconditions.checkNotNull(row);

        if (value != null) {
            if (value instanceof String) {
                row.createCell(position).setCellValue((String) value);
            } else if (value instanceof Date) {
                row.createCell(position).setCellValue(datetimeFormat.format((Date) value));
            } else if (value instanceof Calendar) {
                row.createCell(position).setCellValue(datetimeFormat.format(((Calendar) value).getTime()));
            } else if (value instanceof Integer) {
                row.createCell(position).setCellValue((Integer) value);
            } else if (value instanceof Long) {
                row.createCell(position).setCellValue((Long) value);
            } else if (value instanceof Double) {
                row.createCell(position).setCellValue((Double) value);
            } else if (value instanceof Boolean) {
                row.createCell(position).setCellValue((Boolean) value);
            } else {
                throw new Error("Valor no valido:" + value);
            }
        }
    }

    /**
     * Autosize columns.
     *
     * @param sheet
     *            the sheet
     * @param header
     *            the header
     */
    private void autoSizeColumns(final HSSFSheet sheet, final HSSFRow header) {
        Preconditions.checkNotNull(sheet);
        Preconditions.checkNotNull(header);

        for (int index = header.getFirstCellNum(); index < header.getLastCellNum(); index++) {
            sheet.autoSizeColumn(index);
        }
    }
}
