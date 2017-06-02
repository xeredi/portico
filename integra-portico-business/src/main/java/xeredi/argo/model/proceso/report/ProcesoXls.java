package xeredi.argo.model.proceso.report;

import java.io.OutputStream;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import xeredi.argo.model.comun.report.BaseXls;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.proceso.vo.ProcesoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoXls.
 */
public final class ProcesoXls extends BaseXls {

	/** The prbt list. */
	private final List<ProcesoVO> prbtList;

	/**
	 * Instantiates a new proceso xls.
	 *
	 * @param bundle
	 *            the bundle
	 * @param stream
	 *            the stream
	 * @param prbtList
	 *            the prbt list
	 */
	public ProcesoXls(final ResourceBundle bundle, final OutputStream stream, final List<ProcesoVO> prbtList) {
		super(bundle, stream);

		this.prbtList = prbtList;
	}

	/**
	 * {@inheritDoc}
	 */
	public void doGenerate(final HSSFWorkbook workbook) {
		final HSSFSheet sheet = workbook.createSheet("prbtList");

		// Cabecera XLS
		int rownum = 0;

		final HSSFRow rowhead = sheet.createRow(rownum++);
		int i = 0;

		setCellValue(rowhead, i++, getBundle().getString(MessageI18nKey.prbt_modulo.name()));
		setCellValue(rowhead, i++, getBundle().getString(MessageI18nKey.prbt_tipo.name()));
		setCellValue(rowhead, i++, getBundle().getString(MessageI18nKey.prbt_estado.name()));
		setCellValue(rowhead, i++, getBundle().getString(MessageI18nKey.prbt_falta.name()));
		setCellValue(rowhead, i++, getBundle().getString(MessageI18nKey.fini.name()));
		setCellValue(rowhead, i++, getBundle().getString(MessageI18nKey.ffin.name()));
		setCellValue(rowhead, i++, getBundle().getString(MessageI18nKey.prbt_duracion.name()));
		setCellValue(rowhead, i++, getBundle().getString(MessageI18nKey.prbt_erroresCnt.name()));
		setCellValue(rowhead, i++, getBundle().getString(MessageI18nKey.prbt_alertasCnt.name()));
		setCellValue(rowhead, i++, getBundle().getString(MessageI18nKey.prbt_mensajesCnt.name()));

		// Filas XLS
		for (final ProcesoVO prbtVO : prbtList) {
			final HSSFRow row = sheet.createRow(rownum++);

			int j = 0;

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
	}

}
