package xeredi.argo.http.controller.action.proceso;

import java.io.IOException;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.CrudFileExportAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.ArchivoService;
import xeredi.argo.model.comun.vo.ArchivoInfoVO;
import xeredi.argo.model.proceso.vo.ProcesoItemVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoArchivoZipExportAction.
 */
public final class ProcesoArchivoZipExportAction extends CrudFileExportAction<ProcesoItemVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1822556969160920692L;

	/** The arin. */
	private ArchivoInfoVO arin;

	@Inject
	private ArchivoService archService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doExport() throws ApplicationException, IOException {
		Preconditions.checkNotNull(model.getItemId());

		arin = archService.select(model.getItemId());
		stream = archService.selectStream(model.getItemId());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getFilename() {
		return arin.getNombre();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CrudFileExportAction.ContentType getContentType() {
		return ContentType.zip;
	}
}
