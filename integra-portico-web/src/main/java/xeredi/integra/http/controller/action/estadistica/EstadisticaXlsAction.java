package xeredi.integra.http.controller.action.estadistica;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.comun.report.ExcelUtil;
import xeredi.integra.model.estadistica.bo.Estadistica;
import xeredi.integra.model.estadistica.vo.EstadisticaCriterioVO;
import xeredi.integra.model.metamodelo.proxy.TipoEstadisticaProxy;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticaXlsAction.
 */
public final class EstadisticaXlsAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4908663634311214949L;

    /** The criterio vo. */
    private EstadisticaCriterioVO itemCriterio;

    /** The tppr. */
    private TipoEstadisticaVO enti;

    /** The stream. */
    private InputStream stream;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    // Acciones Web

    /**
     * Excel export.
     * 
     * @return the string
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    @Action(value = "estd-xls-export", results = { @Result(name = "success", type = "stream", params = { "contentType",
            "application/xls", "inputName", "stream", "contentDisposition", "filename=${enti.codigo}.xls" }) })
    public String xlsExport() throws IOException {
        Preconditions.checkNotNull(itemCriterio);
        Preconditions.checkNotNull(itemCriterio.getEntiId());

        final Estadistica estdBO = BOFactory.getInjector().getInstance(Estadistica.class);

        enti = TipoEstadisticaProxy.select(itemCriterio.getEntiId());
        itemCriterio.setSoloDatosGrid(false);

        try (final ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
            final ExcelUtil excelUtil = new ExcelUtil(getLocale());

            excelUtil.generarEstadisticas(estdBO.selectList(itemCriterio), enti, baos);

            stream = new ByteArrayInputStream(baos.toByteArray());
        }

        return SUCCESS;
    }

    // get / set

    /**
     * Gets the item criterio.
     * 
     * @return the item criterio
     */
    public final EstadisticaCriterioVO getItemCriterio() {
        return itemCriterio;
    }

    /**
     * Sets the item criterio.
     * 
     * @param itemCriterio
     *            the new item criterio
     */
    public final void setItemCriterio(final EstadisticaCriterioVO itemCriterio) {
        this.itemCriterio = itemCriterio;
    }

    /**
     * Gets the enti.
     * 
     * @return the enti
     */
    public final TipoEstadisticaVO getEnti() {
        return enti;
    }

    /**
     * Gets the stream.
     * 
     * @return the stream
     */
    public final InputStream getStream() {
        return stream;
    }

}
