package xeredi.argo.http.controller.action.estadistica;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.inject.Inject;

import xeredi.argo.http.controller.action.item.ItemXlsExportAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.estadistica.report.EstadisticaXls;
import xeredi.argo.model.estadistica.service.EstadisticaService;
import xeredi.argo.model.estadistica.vo.EstadisticaCriterioVO;
import xeredi.argo.model.metamodelo.service.EntidadProxyService;
import xeredi.argo.model.metamodelo.vo.TipoEstadisticaDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticaXlsExportAction.
 */
public final class EstadisticaXlsExportAction extends ItemXlsExportAction<EstadisticaCriterioVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1981745354519002750L;

	/** The estd service. */
	@Inject
	private EstadisticaService estdService;

	@Inject
	private EntidadProxyService entiProxy;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificXlsExport() throws ApplicationException, IOException {
		final TipoEstadisticaDetailVO enti = entiProxy.selectTpes(criterio.getEntiId());

		try (final ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
			final EstadisticaXls excelUtil = new EstadisticaXls(getBundle(), baos, estdService.selectList(criterio),
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
		return MessageI18nKey.estd.name() + '_' + criterio.getEntiId();
	}
}
