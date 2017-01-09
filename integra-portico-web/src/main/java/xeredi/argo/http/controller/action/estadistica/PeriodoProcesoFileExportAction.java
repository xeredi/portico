package xeredi.argo.http.controller.action.estadistica;

import java.io.IOException;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.CrudFileExportAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.ArchivoService;
import xeredi.argo.model.estadistica.service.PeriodoProcesoService;
import xeredi.argo.model.estadistica.vo.PeriodoProcesoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodoProcesoZipExportAction.
 */
public final class PeriodoProcesoFileExportAction extends CrudFileExportAction<PeriodoProcesoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -139099742146825401L;

	@Inject
	private ArchivoService archService;

	@Inject
	private PeriodoProcesoService peprService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doExport() throws ApplicationException, IOException {
		Preconditions.checkNotNull(model.getId());

		model = peprService.select(model.getId(), getIdioma());
		stream = archService.selectStream(model.getArin().getId());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getFilename() {
		return model.getFilename();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ContentType getContentType() {
		return ContentType.zip;
	}
}
