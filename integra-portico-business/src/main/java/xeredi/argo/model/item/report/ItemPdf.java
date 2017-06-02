package xeredi.argo.model.item.report;

import java.util.ResourceBundle;

import lombok.NonNull;
import xeredi.argo.model.comun.report.BasePdf;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemPdf.
 */
public abstract class ItemPdf extends BasePdf {

	/**
	 * Instantiates a new item pdf.
	 *
	 * @param abundle
	 *            the abundle
	 */
	public ItemPdf(@NonNull final ResourceBundle abundle) {
		super(abundle);
	}

}
