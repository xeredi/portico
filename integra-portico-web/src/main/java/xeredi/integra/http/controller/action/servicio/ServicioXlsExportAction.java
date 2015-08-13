package xeredi.integra.http.controller.action.servicio;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import xeredi.integra.http.controller.action.item.ItemXlsExportAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.integra.model.metamodelo.vo.TipoServicioDetailVO;
import xeredi.integra.model.servicio.bo.ServicioBO;
import xeredi.integra.model.servicio.bo.ServicioBOFactory;
import xeredi.integra.model.servicio.report.ServicioXls;
import xeredi.integra.model.servicio.vo.ServicioCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioXlsExportAction.
 */
public final class ServicioXlsExportAction extends ItemXlsExportAction<ServicioCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4791188932107630324L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificXlsExport() throws ApplicationException, IOException {
        final TipoServicioDetailVO enti = TipoServicioProxy.select(criterio.getEntiId());

        try (final ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            final ServicioBO itemBO = ServicioBOFactory.newInstance(criterio.getEntiId());
            final ServicioXls excelUtil = new ServicioXls(getLocale());

            excelUtil.generarServicios(itemBO.selectList(criterio), enti, baos);

            stream = new ByteArrayInputStream(baos.toByteArray());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getFilename() {
        return MessageI18nKey.srvc.name() + '_' + criterio.getEntiId();
    }
}
