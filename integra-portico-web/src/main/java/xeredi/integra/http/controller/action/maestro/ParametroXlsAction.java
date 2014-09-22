package xeredi.integra.http.controller.action.maestro;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.report.ExcelUtil;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.vo.ParametroCriterioVO;
import xeredi.integra.model.metamodelo.proxy.TipoParametroProxy;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroXlsAction.
 */
public final class ParametroXlsAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3600500596378173543L;

    /** The criterio vo. */
    private ParametroCriterioVO itemCriterio;

    /** The tppr. */
    private TipoParametroVO enti;

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
    @Action(value = "prmt-xls-export", results = { @Result(name = "success", type = "stream", params = { "contentType",
            "application/xls", "inputName", "stream", "contentDisposition", "filename=${enti.codigo}.xls" }) })
    public String xlsExport() throws IOException {
        Preconditions.checkNotNull(itemCriterio);
        Preconditions.checkNotNull(itemCriterio.getEntiId());

        final ParametroBO prmtBO = new ParametroBO();

        enti = TipoParametroProxy.select(itemCriterio.getEntiId());
        itemCriterio.setSoloDatosGrid(false);

        try (final ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
            final ExcelUtil excelUtil = new ExcelUtil(getLocale());

            excelUtil.generarMaestros(prmtBO.selectList(itemCriterio), enti, baos);

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
    public final ParametroCriterioVO getItemCriterio() {
        return itemCriterio;
    }

    /**
     * Sets the item criterio.
     *
     * @param value
     *            the new item criterio
     */
    public final void setItemCriterio(final ParametroCriterioVO value) {
        itemCriterio = value;
    }

    /**
     * Gets the enti.
     *
     * @return the enti
     */
    public final TipoParametroVO getEnti() {
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
