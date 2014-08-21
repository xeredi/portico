package xeredi.integra.http.controller.action.maestro;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.dynamicreports.report.exception.DRException;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.bo.maestro.Parametro;
import xeredi.integra.model.bo.maestro.Subparametro;
import xeredi.integra.model.bo.util.BOFactory;
import xeredi.integra.model.bo.util.pdf.ParametroPdf;
import xeredi.integra.model.maestro.vo.ParametroCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroI18nVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.maestro.vo.SubparametroCriterioVO;
import xeredi.integra.model.maestro.vo.SubparametroVO;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroVO;
import xeredi.integra.model.proxy.metamodelo.TipoParametroProxy;
import xeredi.integra.model.proxy.metamodelo.TipoSubparametroProxy;
import xeredi.util.exception.InstanceNotFoundException;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroPdfAction.
 */
public final class ParametroPdfAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7734329938605849510L;

    /** The Constant PDF_MIMETYPE. */
    public static final String PDF_MIMETYPE = "application/pdf";

    /** The item report. */
    private ParametroVO item;

    /** The fecha vigencia. */
    private Date fechaVigencia;

    /** The stream. */
    private InputStream stream;

    /** The filename. */
    private String filename;

    /**
     * Imprimir.
     *
     * @return the string
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     * @throws DRException
     *             the DR exception
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action(value = "prmt-imprimir", results = { @Result(name = "success", type = "stream", params = { "contentType",
            "${type}", "inputName", "stream", "contentDisposition", "filename=${filename}" }) })
    public String imprimir() throws IOException, DRException, InstanceNotFoundException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        if (fechaVigencia == null) {
            fechaVigencia = Calendar.getInstance().getTime();
        }

        final Parametro prmtBO = BOFactory.getInjector().getInstance(Parametro.class);
        final Map<Long, TipoSubparametroVO> entiHijasMap = new HashMap<>();

        item = prmtBO.select(item.getId(), getIdioma(), fechaVigencia);

        final TipoParametroVO enti = TipoParametroProxy.select(item.getEntiId());
        final Map<Long, List<SubparametroVO>> itemHijosMap = new HashMap<>();

        if (enti.getEntiHijasList() != null) {
            final Subparametro sprmBO = BOFactory.getInjector().getInstance(Subparametro.class);
            final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

            prmtCriterioVO.setId(item.getId());
            prmtCriterioVO.setFechaVigencia(fechaVigencia);
            prmtCriterioVO.setIdioma(getIdioma());

            for (final Long entiId : enti.getEntiHijasList()) {
                final SubparametroCriterioVO sprmCriterioVO = new SubparametroCriterioVO();

                sprmCriterioVO.setPrmt(prmtCriterioVO);
                sprmCriterioVO.setEntiId(entiId);
                sprmCriterioVO.setFechaVigencia(fechaVigencia);
                sprmCriterioVO.setIdioma(getIdioma());

                entiHijasMap.put(entiId, TipoSubparametroProxy.select(entiId));
                itemHijosMap.put(entiId, sprmBO.selectList(sprmCriterioVO));
            }
        }

        final Map<String, ParametroI18nVO> p18nMap = new HashMap<>();

        if (enti.isI18n()) {
            p18nMap.putAll(prmtBO.selectI18nMap(item.getPrvr().getId()));
        }

        try (final ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
            final ParametroPdf prmtPdf = new ParametroPdf(getLocale());

            prmtPdf.imprimir(item, enti, entiHijasMap, itemHijosMap, p18nMap, baos);

            stream = new ByteArrayInputStream(baos.toByteArray());
        }

        return SUCCESS;
    }

    /**
     * Sets the item.
     *
     * @param value
     *            the new item
     */
    public void setItem(final ParametroVO value) {
        item = value;
    }

    /**
     * Sets the fecha vigencia.
     *
     * @param value
     *            the new fecha vigencia
     */
    public void setFechaVigencia(final Date value) {
        this.fechaVigencia = value;
    }

    /**
     * Gets the stream.
     *
     * @return the stream
     */
    public InputStream getStream() {
        return stream;
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public String getType() {
        return PDF_MIMETYPE;
    }

    /**
     * Gets the filename.
     *
     * @return the filename
     */
    public String getFilename() {
        return filename;
    }

}
