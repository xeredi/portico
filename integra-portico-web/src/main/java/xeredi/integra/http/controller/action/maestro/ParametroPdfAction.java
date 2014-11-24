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
import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.exception.InternalErrorException;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.bo.SubparametroBO;
import xeredi.integra.model.maestro.report.ParametroPdf;
import xeredi.integra.model.maestro.vo.ParametroCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.maestro.vo.SubparametroCriterioVO;
import xeredi.integra.model.maestro.vo.SubparametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoParametroProxy;
import xeredi.integra.model.metamodelo.proxy.TipoSubparametroProxy;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroVO;

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
    @Action(value = "prmt-print", results = { @Result(name = "success", type = "stream", params = { "contentType",
            "${type}", "inputName", "stream", "contentDisposition", "filename=${filename}" }) })
    public String imprimir() throws ApplicationException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        if (fechaVigencia == null) {
            fechaVigencia = Calendar.getInstance().getTime();
        }

        final ParametroBO prmtBO = new ParametroBO();
        final Map<Long, TipoSubparametroVO> entiHijasMap = new HashMap<>();

        item = prmtBO.select(item.getId(), getIdioma(), fechaVigencia);

        final TipoParametroVO enti = TipoParametroProxy.select(item.getEntiId());
        final Map<Long, List<SubparametroVO>> itemHijosMap = new HashMap<>();

        if (enti.getEntiHijasList() != null) {
            final SubparametroBO sprmBO = new SubparametroBO();
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

        final Map<String, I18nVO> i18nMap = new HashMap<>();

        if (enti.getI18n()) {
            i18nMap.putAll(I18nBO.selectMap(I18nPrefix.prvr, item.getPrvr().getId()));
        }

        try (final ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
            final ParametroPdf prmtPdf = new ParametroPdf(getLocale());

            prmtPdf.imprimir(item, enti, entiHijasMap, itemHijosMap, i18nMap, baos);

            stream = new ByteArrayInputStream(baos.toByteArray());
        } catch (final IOException ex) {
            throw new InternalErrorException(ex);
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
