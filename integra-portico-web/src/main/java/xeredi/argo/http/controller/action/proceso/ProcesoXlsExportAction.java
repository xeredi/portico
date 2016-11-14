package xeredi.argo.http.controller.action.proceso;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.http.controller.action.comun.GridXlsExportAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.proceso.bo.ProcesoBO;
import xeredi.argo.model.proceso.report.ProcesoXls;
import xeredi.argo.model.proceso.vo.ProcesoCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoXlsExportAction.
 */
@Data
@EqualsAndHashCode(callSuper = true)
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
            final ProcesoXls excelUtil = new ProcesoXls(getLocale(), baos, prbtBO.selectList(criterio));

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
