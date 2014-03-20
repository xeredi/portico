package xeredi.integra.model.bo.util;

import java.io.OutputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.component.HorizontalListBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import xeredi.integra.model.util.GlobalNames;
import xeredi.integra.model.vo.comun.ItemDatoVO;
import xeredi.integra.model.vo.maestro.ParametroVO;
import xeredi.integra.model.vo.maestro.SubparametroVO;
import xeredi.integra.model.vo.metamodelo.EntidadTipoDatoVO;
import xeredi.integra.model.vo.metamodelo.TipoParametroVO;
import xeredi.integra.model.vo.metamodelo.TipoSubparametroVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class PdfUtil.
 */
public final class PdfUtil {

    /** The Constant DATE_FORMAT. */
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    /** The Constant DATETIME_FORMAT. */
    private static final DateFormat DATETIME_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    /** The Constant INTEGER_FORMAT. */
    private static final DecimalFormat INTEGER_FORMAT = new DecimalFormat("###,###,##0");

    /** The Constant DOUBLE_FORMAT. */
    private static final DecimalFormat DOUBLE_FORMAT = new DecimalFormat("###,###,##0.00####");

    /** The locale. */
    private final Locale locale;

    /** The bundle. */
    private final ResourceBundle bundle;

    /**
     * Instantiates a new pdf util.
     * 
     * @param alocale
     *            the alocale
     */
    public PdfUtil(final Locale alocale) {
        super();
        locale = alocale;
        bundle = ResourceBundle.getBundle(GlobalNames.MESSAGES, locale);
    }

    /**
     * Imprimir.
     * 
     * @param prmtVO
     *            the prmt vo
     * @param tpprVO
     *            the tppr vo
     * @param entiHijasList
     *            the enti hijas list
     * @param itemHijosMap
     *            the item hijos map
     * @param stream
     *            the stream
     * @throws DRException
     *             the DR exception
     */
    public void imprimir(final ParametroVO prmtVO, final TipoParametroVO tpprVO,
            final List<TipoSubparametroVO> entiHijasList, final Map<Long, List<SubparametroVO>> itemHijosMap,
            final OutputStream stream) throws DRException {
        Preconditions.checkNotNull(prmtVO);
        Preconditions.checkNotNull(tpprVO);

        final JasperReportBuilder report = DynamicReports.report();

        // report.addPageFooter(Components.pageXofY());
        // report.addTitle(Components.text(tpprVO.getNombre() + ": " + prmtVO.getEtiqueta()));
        // report.setDataSource(getSubreport(entiVO, itemList));

        report.title(createItemComponent(tpprVO, prmtVO));

        report.toPdf(stream);
    }

    /**
     * Gets the data source.
     * 
     * @param entiVO
     *            the enti vo
     * @param itemList
     *            the item list
     * @return the data source
     */
    private JasperReportBuilder getSubreport(final TipoSubparametroVO entiVO, final List<SubparametroVO> itemList) {
        Preconditions.checkNotNull(entiVO);
        Preconditions.checkNotNull(itemList);

        final List<String> columns = new ArrayList<>();

        columns.add(entiVO.getTpprAsociado().getNombre());

        if (entiVO.isTempExp()) {
            columns.add("finicio");
            columns.add("ffin");
        }

        if (entiVO.getEntdList() != null) {
            for (final Long tpdtId : entiVO.getEntdList()) {
                columns.add(entiVO.getEntdMap().get(tpdtId).getEtiqueta());
            }
        }

        final DRDataSource dataSource = new DRDataSource(columns.toArray(new String[] {}));

        for (final SubparametroVO itemVO : itemList) {
            final Object[] objects = new Object[columns.size()];
            int i = 0;

            objects[i++] = itemVO.getPrmtAsociado().getEtiqueta();

            if (entiVO.isTempExp()) {
                objects[i++] = itemVO.getSpvr().getFinicio();
                objects[i++] = itemVO.getSpvr().getFfin();
            }

            if (entiVO.getEntdList() != null) {
                for (final Long tpdtId : entiVO.getEntdList()) {
                    objects[i++] = getItdtValue(entiVO.getEntdMap().get(tpdtId), itemVO.getItdtMap().get(tpdtId));
                }
            }

            dataSource.add(objects);
        }

        final JasperReportBuilder report = DynamicReports.report();

        report.setDataSource(dataSource);

        return report;

    }

    /**
     * Creates the item component.
     * 
     * @param tpprVO
     *            the tppr vo
     * @param prmtVO
     *            the prmt vo
     * @return the component builder
     */
    private ComponentBuilder<?, ?> createItemComponent(final TipoParametroVO tpprVO, final ParametroVO prmtVO) {
        final HorizontalListBuilder list = DynamicReports.cmp.horizontalList();

        addItdtComponent(list, tpprVO.getNombre(), prmtVO.getEtiqueta());

        for (final Long tpdtId : tpprVO.getEntdList()) {
            final EntidadTipoDatoVO entdVO = tpprVO.getEntdMap().get(tpdtId);
            final ItemDatoVO itdtVO = prmtVO.getItdtMap().get(tpdtId);

            addItdtComponent(list, entdVO.getEtiqueta(), getItdtValue(entdVO, itdtVO));
        }

        return DynamicReports.cmp.verticalList(DynamicReports.cmp.text(tpprVO.getNombre()), list);
    }

    /**
     * Adds the itdt component.
     * 
     * @param list
     *            the list
     * @param label
     *            the label
     * @param value
     *            the value
     */
    private void addItdtComponent(final HorizontalListBuilder list, final String label, final String value) {
        Preconditions.checkNotNull(label);
        Preconditions.checkNotNull(value);

        list.add(DynamicReports.cmp.text(label + ":").setFixedColumns(8), DynamicReports.cmp.text(value)).newRow();
    }

    /**
     * Gets the itdt value.
     * 
     * @param entdVO
     *            the entd vo
     * @param itdtVO
     *            the itdt vo
     * @return the itdt value
     */
    private String getItdtValue(final EntidadTipoDatoVO entdVO, final ItemDatoVO itdtVO) {
        Preconditions.checkNotNull(entdVO);
        Preconditions.checkNotNull(entdVO.getTpdt());
        Preconditions.checkNotNull(entdVO.getTpdt().getTipoElemento());
        Preconditions.checkNotNull(itdtVO);

        String value = "";

        switch (entdVO.getTpdt().getTipoElemento()) {
        case BO:
            value = bundle.getString("boolean."
                    + (itdtVO.getCantidadEntera() == null ? false : itdtVO.getCantidadEntera() == 1));
            break;
        case TX:
        case CR:
            if (itdtVO.getCadena() != null) {
                value = itdtVO.getCadena();
            }
            break;
        case ND:
            if (itdtVO.getCantidadDecimal() != null) {
                value = DOUBLE_FORMAT.format(itdtVO.getCantidadDecimal());
            }
            break;
        case NE:
            if (itdtVO.getCantidadEntera() != null) {
                value = INTEGER_FORMAT.format(itdtVO.getCantidadEntera());
            }
            break;
        case FE:
            if (itdtVO.getFecha() != null) {
                value = DATE_FORMAT.format(itdtVO.getFecha());
            }
            break;
        case FH:
            if (itdtVO.getFecha() != null) {
                value = DATETIME_FORMAT.format(itdtVO.getFecha());
            }
            break;
        case PR:
            if (itdtVO.getPrmt() != null) {
                value = itdtVO.getPrmt().getEtiqueta();
            }
            break;
        case SR:
            if (itdtVO.getSrvc() != null) {
                value = itdtVO.getSrvc().getEtiqueta();
            }
            break;
        default:
            throw new Error("Tipo de dato no soportado: " + entdVO.getTpdt().getTipoElemento());
        }

        return value;
    }

}
