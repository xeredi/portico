package xeredi.argo.http.controller.action.estadistica;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import lombok.Data;
import xeredi.argo.http.controller.action.item.ItemXlsExportAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.estadistica.bo.EstadisticaBO;
import xeredi.argo.model.estadistica.report.EstadisticaXls;
import xeredi.argo.model.estadistica.vo.EstadisticaCriterioVO;
import xeredi.argo.model.metamodelo.proxy.TipoEstadisticaProxy;
import xeredi.argo.model.metamodelo.vo.TipoEstadisticaDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticaXlsExportAction.
 */
@Data
public final class EstadisticaXlsExportAction extends ItemXlsExportAction<EstadisticaCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1981745354519002750L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificXlsExport() throws ApplicationException, IOException {
        final EstadisticaBO itemBO = new EstadisticaBO();
        final TipoEstadisticaDetailVO enti = TipoEstadisticaProxy.select(criterio.getEntiId());

        try (final ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
            final EstadisticaXls excelUtil = new EstadisticaXls(getLocale(), baos, itemBO.selectList(criterio), enti);

            excelUtil.generate();

            stream = new ByteArrayInputStream(baos.toByteArray());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getFilename() {
        return MessageI18nKey.estd.name() + '_' + criterio.getEntiId();
    }
}
