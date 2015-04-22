package xeredi.integra.http.controller.action.estadistica;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import xeredi.integra.http.controller.action.item.ItemXlsExportAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.estadistica.bo.EstadisticaBO;
import xeredi.integra.model.estadistica.report.EstadisticaXls;
import xeredi.integra.model.estadistica.vo.EstadisticaCriterioVO;
import xeredi.integra.model.metamodelo.proxy.TipoEstadisticaDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoEstadisticaProxy;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticaXlsExportAction.
 */
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
            final EstadisticaXls excelUtil = new EstadisticaXls(getLocale());

            excelUtil.generarEstadisticas(itemBO.selectList(criterio), enti, baos);

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
