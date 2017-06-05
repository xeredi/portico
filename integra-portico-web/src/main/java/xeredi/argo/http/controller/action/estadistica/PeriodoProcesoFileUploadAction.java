package xeredi.argo.http.controller.action.estadistica;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.FileUploadAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.service.SuperpuertoService;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.comun.vo.SuperpuertoCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodoProcesoFileUploadAction.
 */
public final class PeriodoProcesoFileUploadAction extends FileUploadAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6303062787273866040L;

	@Inject
	private SuperpuertoService sprtService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doSpecificValidate() throws ApplicationException {
		Preconditions.checkNotNull(uploadedFile);
		Preconditions.checkNotNull(uploadedFileContentType);
		Preconditions.checkNotNull(uploadedFileFileName);

		final String sprtCodigo = uploadedFileFileName.substring(0, 2);
		final String anio = uploadedFileFileName.substring(2, 6);
		final String mes = uploadedFileFileName.substring(6, 8);

		try {
			final SuperpuertoCriterioVO sprtCriterio = new SuperpuertoCriterioVO();

			sprtCriterio.setCodigo(sprtCodigo);

			sprtService.selectObject(sprtCriterio);
		} catch (final InstanceNotFoundException ex) {
			addActionError(MessageI18nKey.E00008, getText(MessageI18nKey.sprt), sprtCodigo);
		}
	}
}
