package xeredi.integra.http.controller.action.servicio;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import xeredi.integra.http.controller.action.item.ItemXlsExportAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioDetailVO;
import xeredi.integra.model.servicio.bo.SubservicioBO;
import xeredi.integra.model.servicio.bo.SubservicioBOFactory;
import xeredi.integra.model.servicio.report.SubservicioXls;
import xeredi.integra.model.servicio.vo.SubservicioCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioXlsExportAction.
 */
public final class SubservicioXlsExportAction extends ItemXlsExportAction<SubservicioCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8891503734091108175L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificXlsExport() throws ApplicationException, IOException {
        final TipoSubservicioDetailVO enti = TipoSubservicioProxy.select(criterio.getEntiId());

        try (final ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            final SubservicioBO itemBO = SubservicioBOFactory.newInstance(criterio.getEntiId());
            final SubservicioXls excelUtil = new SubservicioXls(getLocale());

            excelUtil.generarSubservicios(itemBO.selectList(criterio), enti, baos);

            stream = new ByteArrayInputStream(baos.toByteArray());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getFilename() {
        return MessageI18nKey.ssrv.name() + '_' + criterio.getEntiId();
    }
}
