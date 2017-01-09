package xeredi.argo.http.controller.action.proceso;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.GridXlsExportAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.proceso.report.ProcesoXls;
import xeredi.argo.model.proceso.service.ProcesoService;
import xeredi.argo.model.proceso.vo.ProcesoCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoXlsExportAction.
 */
public final class ProcesoXlsExportAction extends GridXlsExportAction<ProcesoCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1158663234899347739L;

	@Inject
	private ProcesoService prbtService;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doXlsExport() throws ApplicationException, IOException {
        try (final ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
            final ProcesoXls excelUtil = new ProcesoXls(getLocale(), baos, prbtService.selectList(criterio));

            excelUtil.generate();

            stream = new ByteArrayInputStream(baos.toByteArray());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getFilename() {
        return MessageI18nKey.prbt.name();
    }
}
