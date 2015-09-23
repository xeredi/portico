package xeredi.argo.http.controller.action.maestro;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import xeredi.argo.http.controller.action.item.ItemXlsExportAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.maestro.bo.ParametroBO;
import xeredi.argo.model.maestro.bo.ParametroBOFactory;
import xeredi.argo.model.maestro.report.ParametroXls;
import xeredi.argo.model.maestro.vo.ParametroCriterioVO;
import xeredi.argo.model.metamodelo.proxy.TipoParametroProxy;
import xeredi.argo.model.metamodelo.vo.TipoParametroDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroXlsExportAction.
 */
public final class ParametroXlsExportAction extends ItemXlsExportAction<ParametroCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 674434379936795965L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificXlsExport() throws ApplicationException, IOException {
        final TipoParametroDetailVO enti = TipoParametroProxy.select(criterio.getEntiId());

        try (final ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
            final ParametroBO itemBO = ParametroBOFactory.newInstance(criterio.getEntiId());
            final ParametroXls excelUtil = new ParametroXls(getLocale());

            excelUtil.generarMaestros(itemBO.selectList(criterio), enti, baos);

            stream = new ByteArrayInputStream(baos.toByteArray());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getFilename() {
        return MessageI18nKey.prmt.name() + '_' + criterio.getEntiId();
    }
}