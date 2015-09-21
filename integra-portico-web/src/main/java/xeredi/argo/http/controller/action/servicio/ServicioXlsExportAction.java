package xeredi.argo.http.controller.action.servicio;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import xeredi.argo.http.controller.action.item.ItemXlsExportAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.argo.model.metamodelo.vo.TipoServicioDetailVO;
import xeredi.argo.model.servicio.bo.ServicioBO;
import xeredi.argo.model.servicio.bo.ServicioBOFactory;
import xeredi.argo.model.servicio.report.ServicioXls;
import xeredi.argo.model.servicio.vo.ServicioCriterioVO;

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
