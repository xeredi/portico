package xeredi.argo.http.controller.action.servicio;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.inject.Inject;

import xeredi.argo.http.controller.action.item.ItemXlsExportAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.service.EntidadProxyService;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioDetailVO;
import xeredi.argo.model.servicio.report.SubservicioXls;
import xeredi.argo.model.servicio.service.SubservicioService;
import xeredi.argo.model.servicio.service.SubservicioServiceFactory;
import xeredi.argo.model.servicio.vo.SubservicioCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioXlsExportAction.
 */
public final class SubservicioXlsExportAction extends ItemXlsExportAction<SubservicioCriterioVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8891503734091108175L;

	@Inject
	private EntidadProxyService entiProxy;

	@Inject
	private SubservicioServiceFactory ssrvFactory;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificXlsExport() throws ApplicationException, IOException {
		final TipoSubservicioDetailVO enti = entiProxy.selectTpss(criterio.getEntiId());

		try (final ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
			final SubservicioService ssrvService = ssrvFactory.getInstance(criterio.getEntiId(), usroId);

			if (ssrvService.count(criterio) > 10000) {
				throw new Error("No se pueden generar Excels de mas de 10.000 filas");
			}

			final SubservicioXls excelUtil = new SubservicioXls(getBundle(), baos, ssrvService.selectList(criterio),
					enti);

			excelUtil.generate();

			stream = new ByteArrayInputStream(baos.toByteArray());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getFilename() {
		return MessageI18nKey.ssrv.name() + '_' + criterio.getEntiId();
	}
}
