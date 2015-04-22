package xeredi.integra.http.controller.action.maestro;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import xeredi.integra.http.controller.action.item.ItemXlsExportAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.bo.ParametroBOFactory;
import xeredi.integra.model.maestro.report.ParametroXls;
import xeredi.integra.model.maestro.vo.ParametroCriterioVO;
import xeredi.integra.model.metamodelo.proxy.TipoParametroDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoParametroProxy;

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
        final ParametroBO itemBO = ParametroBOFactory.newInstance(criterio.getEntiId());
        final TipoParametroDetailVO enti = TipoParametroProxy.select(criterio.getEntiId());

        try (final ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
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
