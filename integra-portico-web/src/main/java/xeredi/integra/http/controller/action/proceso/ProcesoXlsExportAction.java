package xeredi.integra.http.controller.action.proceso;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import xeredi.integra.http.controller.action.comun.GridXlsExportAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.proceso.bo.ProcesoBO;
import xeredi.integra.model.proceso.report.ProcesoXls;
import xeredi.integra.model.proceso.vo.ProcesoCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoXlsExportAction.
 */
public final class ProcesoXlsExportAction extends GridXlsExportAction<ProcesoCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1158663234899347739L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doXlsExport() throws ApplicationException, IOException {
        final ProcesoBO prbtBO = new ProcesoBO();

        try (final ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
            final ProcesoXls excelUtil = new ProcesoXls(getLocale());

            excelUtil.generarProcesos(prbtBO.selectList(criterio), baos);

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
