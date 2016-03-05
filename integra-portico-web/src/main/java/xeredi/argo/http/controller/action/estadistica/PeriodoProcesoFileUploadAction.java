package xeredi.argo.http.controller.action.estadistica;

import xeredi.argo.http.controller.action.comun.FileUploadAction;
import xeredi.argo.model.comun.bo.SuperpuertoBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.comun.vo.SuperpuertoCriterioVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodoProcesoFileUploadAction.
 */
public final class PeriodoProcesoFileUploadAction extends FileUploadAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6303062787273866040L;

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
            final SuperpuertoBO sprtBO = new SuperpuertoBO();
            final SuperpuertoCriterioVO sprtCriterio = new SuperpuertoCriterioVO();

            sprtCriterio.setCodigo(sprtCodigo);

            sprtBO.selectObject(sprtCriterio);
        } catch (final InstanceNotFoundException ex) {
            addActionError(MessageI18nKey.E00008, getText(MessageI18nKey.sprt), sprtCodigo);
        }
    }
}
