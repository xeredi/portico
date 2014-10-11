package xeredi.integra.model.comun.report;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.util.GlobalNames;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ExcelUtil.
 */
public abstract class BaseXls {

    /** The locale. */
    private final Locale locale;

    /** The bundle. */
    protected final ResourceBundle bundle;

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
    public BaseXls(final Locale alocale) {
        super();

        Preconditions.checkNotNull(alocale);

        locale = alocale;
        bundle = ResourceBundle.getBundle(GlobalNames.MESSAGES, locale);
        datetimeFormat = new SimpleDateFormat(bundle.getString(GlobalNames.DATETIME_FORMAT_KEY));
        dateFormat = new SimpleDateFormat(bundle.getString(GlobalNames.DATE_FORMAT_KEY));
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
    protected void setCellValue(final HSSFRow row, final int position, final EntidadTipoDatoVO entdVO,
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
    protected void setCellValue(final HSSFRow row, final int position, final Object value) {
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
    protected void autoSizeColumns(final HSSFSheet sheet, final HSSFRow header) {
        Preconditions.checkNotNull(sheet);
        Preconditions.checkNotNull(header);

        for (int index = header.getFirstCellNum(); index < header.getLastCellNum(); index++) {
            sheet.autoSizeColumn(index);
        }
    }
}
