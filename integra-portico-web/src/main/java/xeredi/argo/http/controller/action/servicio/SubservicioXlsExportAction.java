package xeredi.argo.http.controller.action.servicio;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import xeredi.argo.http.controller.action.item.ItemXlsExportAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioDetailVO;
import xeredi.argo.model.servicio.bo.SubservicioBO;
import xeredi.argo.model.servicio.bo.SubservicioBOFactory;
import xeredi.argo.model.servicio.report.SubservicioXls;
import xeredi.argo.model.servicio.vo.SubservicioCriterioVO;

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
            final SubservicioBO itemBO = SubservicioBOFactory.newInstance(criterio.getEntiId(), usroId);
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
