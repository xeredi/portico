package xeredi.argo.http.controller.action.comun;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.inject.Inject;

import lombok.Getter;
import lombok.Setter;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.exception.InternalErrorException;
import xeredi.argo.model.comun.service.ArchivoService;
import xeredi.argo.model.comun.vo.ArchivoSentido;
import xeredi.argo.model.comun.vo.ArchivoVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.util.GzipUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class FileUploadAction.
 */
public abstract class FileUploadAction extends BaseAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2921156808813882971L;

	@Setter
	protected File uploadedFile;

	@Setter
	protected String uploadedFileFileName;

	@Setter
	protected String uploadedFileContentType;

	@Getter
	private Long archId;

	@Inject
	private ArchivoService archService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void doExecute() throws ApplicationException {
		FieldValidator.validateRequired(this, MessageI18nKey.pepr_file, uploadedFile);

		if (!hasErrors()) {
			FieldValidator.validateRequired(this, MessageI18nKey.pepr_file, uploadedFileContentType);
			FieldValidator.validateRequired(this, MessageI18nKey.pepr_file, uploadedFileFileName);
		}

		if (!hasErrors()) {
			doSpecificValidate();
		}

		if (!hasErrors()) {
			try {
				final ArchivoVO arch = new ArchivoVO();

				arch.setArchivo(GzipUtil.compress(uploadedFile));

				arch.getArin().setFalta(Calendar.getInstance().getTime());
				arch.getArin().setNombre(uploadedFileFileName);
				arch.getArin().setSentido(ArchivoSentido.E);
				arch.getArin().setTamanio(uploadedFile.length());

				archService.insert(arch);

				archId = arch.getArin().getId();
			} catch (final IOException ex) {
				throw new InternalErrorException(ex);
			}
		}
	}

	protected abstract void doSpecificValidate() throws ApplicationException;
}
