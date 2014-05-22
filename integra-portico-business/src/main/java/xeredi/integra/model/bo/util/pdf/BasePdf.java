package xeredi.integra.model.bo.util.pdf;

import java.util.Locale;
import java.util.ResourceBundle;

import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import xeredi.integra.model.util.GlobalNames;
import xeredi.integra.model.vo.comun.ItemDatoVO;
import xeredi.integra.model.vo.metamodelo.EntidadTipoDatoVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class BasePdf.
 */
public abstract class BasePdf {
	/** The locale. */
	protected final Locale locale;

	/** The bundle. */
	protected final ResourceBundle bundle;

	/**
	 * Instantiates a new pdf util.
	 * 
	 * @param alocale
	 *            the alocale
	 */
	public BasePdf(final Locale alocale) {
		super();
		locale = alocale;
		bundle = ResourceBundle.getBundle(GlobalNames.MESSAGES, locale);
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
	public final String getItdtValue(final EntidadTipoDatoVO entdVO,
			final ItemDatoVO itdtVO) {
		Preconditions.checkNotNull(entdVO);
		Preconditions.checkNotNull(entdVO.getTpdt());
		Preconditions.checkNotNull(entdVO.getTpdt().getTipoElemento());
		Preconditions.checkNotNull(itdtVO);

		String value = "";

		switch (entdVO.getTpdt().getTipoElemento()) {
		case BO:
			value = bundle.getString("boolean."
					+ (itdtVO.getCantidadEntera() == null ? false : itdtVO
							.getCantidadEntera() == 1));
			break;
		case TX:
		case CR:
			if (itdtVO.getCadena() != null) {
				value = itdtVO.getCadena();
			}
			break;
		case ND:
			if (itdtVO.getCantidadDecimal() != null) {
				value = PdfConstants.DOUBLE_FORMAT.format(itdtVO
						.getCantidadDecimal());
			}
			break;
		case NE:
			if (itdtVO.getCantidadEntera() != null) {
				value = PdfConstants.INTEGER_FORMAT.format(itdtVO
						.getCantidadEntera());
			}
			break;
		case FE:
			if (itdtVO.getFecha() != null) {
				value = PdfConstants.DATE_FORMAT.format(itdtVO.getFecha());
			}
			break;
		case FH:
			if (itdtVO.getFecha() != null) {
				value = PdfConstants.DATETIME_FORMAT.format(itdtVO.getFecha());
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
			throw new Error("Tipo de dato no soportado: "
					+ entdVO.getTpdt().getTipoElemento());
		}

		return value;
	}

	/**
	 * Gets the label.
	 * 
	 * @param pdfCell
	 *            the pdf cell
	 * @return the label
	 */
	public final TextFieldBuilder<String> getFieldLabel(final PdfCell pdfCell) {
		final TextFieldBuilder<String> label = DynamicReports.cmp
				.text(pdfCell.getLabel()).setFixedWidth(pdfCell.getWidth())
				.setStyle(PdfConstants.LABEL_STYLE);

		return label;
	}

	/**
	 * Gets the data.
	 * 
	 * @param pdfCell
	 *            the pdf cell
	 * @return the data
	 */
	public final TextFieldBuilder<String> getFieldValue(final PdfCell pdfCell) {
		final TextFieldBuilder<String> data = DynamicReports.cmp
				.text(pdfCell.getValue()).setFixedWidth(pdfCell.getWidth())
				.setStyle(PdfConstants.VALUE_STYLE);

		return data;
	}

}
