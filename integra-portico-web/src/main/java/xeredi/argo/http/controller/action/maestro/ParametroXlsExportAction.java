package xeredi.argo.http.controller.action.maestro;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.google.inject.Inject;

import xeredi.argo.http.controller.action.item.ItemXlsExportAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.maestro.report.ParametroXls;
import xeredi.argo.model.maestro.service.ParametroService;
import xeredi.argo.model.maestro.vo.ParametroCriterioVO;
import xeredi.argo.model.metamodelo.service.TipoParametroProxyService;
import xeredi.argo.model.metamodelo.vo.TipoParametroDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroXlsExportAction.
 */
public final class ParametroXlsExportAction extends ItemXlsExportAction<ParametroCriterioVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 674434379936795965L;

	@Inject
	private ParametroService prmtService;

	@Inject
	private TipoParametroProxyService tpprProxy;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificXlsExport() throws ApplicationException, IOException {
		final TipoParametroDetailVO enti = tpprProxy.select(criterio.getEntiId());

		try (final ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
			final ParametroXls excelUtil = new ParametroXls(getLocale(), baos, prmtService.selectList(criterio), enti);

			excelUtil.generate();

			stream = new ByteArrayInputStream(baos.toByteArray());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getFilename() {
		return MessageI18nKey.prmt.name() + '_' + criterio.getEntiId();
	}
}
