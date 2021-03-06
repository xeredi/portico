package xeredi.argo.http.controller.action.servicio;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.inject.Inject;

import xeredi.argo.http.controller.action.item.ItemXlsExportAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.service.EntidadProxyService;
import xeredi.argo.model.metamodelo.vo.TipoServicioDetailVO;
import xeredi.argo.model.servicio.report.ServicioXls;
import xeredi.argo.model.servicio.service.ServicioService;
import xeredi.argo.model.servicio.service.ServicioServiceFactory;
import xeredi.argo.model.servicio.vo.ServicioCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioXlsExportAction.
 */
public final class ServicioXlsExportAction extends ItemXlsExportAction<ServicioCriterioVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4791188932107630324L;

	/** The srvc factory. */
	@Inject
	private ServicioServiceFactory srvcFactory;

	@Inject
	private EntidadProxyService entiProxy;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificXlsExport() throws ApplicationException, IOException {
		final TipoServicioDetailVO enti = entiProxy.selectTpsr(criterio.getEntiId());

		try (final ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
			final ServicioService srvcService = srvcFactory.getInstance(criterio.getEntiId(), usroId);
			final ServicioXls excelUtil = new ServicioXls(getBundle(), baos, srvcService.selectList(criterio), enti);

			excelUtil.generate();

			stream = new ByteArrayInputStream(baos.toByteArray());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getFilename() {
		return MessageI18nKey.srvc.name() + '_' + criterio.getEntiId();
	}
}
