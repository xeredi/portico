package xeredi.integra.http.controller.action.maestro;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.ItemAction;
import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.exception.InternalErrorException;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.bo.ParametroBOFactory;
import xeredi.integra.model.maestro.bo.SubparametroBO;
import xeredi.integra.model.maestro.report.ParametroPdf;
import xeredi.integra.model.maestro.vo.ParametroCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.maestro.vo.SubparametroCriterioVO;
import xeredi.integra.model.maestro.vo.SubparametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoParametroDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoParametroProxy;
import xeredi.integra.model.metamodelo.proxy.TipoSubparametroDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubparametroProxy;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroPdfAction.
 */
public final class ParametroPdfAction extends ItemAction implements ModelDriven<ParametroVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7734329938605849510L;

    /** The item report. */
    private ParametroVO model;

    /** The stream. */
    private InputStream stream;

    /**
     * Imprimir.
     *
     * @return the string
     * @throws ApplicationException
     *             Si ocurre algun error de aplicacion
     */
    @Action(value = "prmt-print", results = { @Result(name = "success", type = "stream", params = { "contentType",
            "application/pdf", "inputName", "stream", "contentDisposition", "filename=${model.entiId}_${model.id}.pdf" }) })
    public String imprimir() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());
        Preconditions.checkNotNull(model.getEntiId());

        final ParametroBO prmtBO = ParametroBOFactory.newInstance(model.getEntiId());
        final Map<Long, TipoSubparametroDetailVO> entiHijasMap = new HashMap<>();

        model = prmtBO.select(model.getId(), getIdioma(), getFechaVigencia());

        final TipoParametroDetailVO entiDetail = TipoParametroProxy.select(model.getEntiId());
        final Map<Long, List<SubparametroVO>> itemHijosMap = new HashMap<>();

        if (entiDetail.getEntiHijasList() != null) {
            final SubparametroBO sprmBO = new SubparametroBO();
            final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

            prmtCriterioVO.setId(model.getId());
            prmtCriterioVO.setFechaVigencia(getFechaVigencia());
            prmtCriterioVO.setIdioma(getIdioma());

            for (final Long entiId : entiDetail.getEntiHijasList()) {
                final SubparametroCriterioVO sprmCriterioVO = new SubparametroCriterioVO();

                sprmCriterioVO.setPrmt(prmtCriterioVO);
                sprmCriterioVO.setEntiId(entiId);
                sprmCriterioVO.setFechaVigencia(getFechaVigencia());
                sprmCriterioVO.setIdioma(getIdioma());

                entiHijasMap.put(entiId, TipoSubparametroProxy.select(entiId));
                itemHijosMap.put(entiId, sprmBO.selectList(sprmCriterioVO));
            }
        }

        final Map<String, I18nVO> i18nMap = new HashMap<>();

        if (entiDetail.getEnti().isI18n()) {
            i18nMap.putAll(I18nBO.selectMap(I18nPrefix.prvr, model.getPrvr().getId()));
        }

        try (final ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
            final ParametroPdf prmtPdf = new ParametroPdf(getLocale());

            prmtPdf.imprimir(model, entiDetail, entiHijasMap, itemHijosMap, i18nMap, baos);

            stream = new ByteArrayInputStream(baos.toByteArray());
        } catch (final IOException ex) {
            throw new InternalErrorException(ex);
        }

        return SUCCESS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParametroVO getModel() {
        return model;
    }

    /**
     * Sets the item.
     *
     * @param value
     *            the new item
     */
    public void setModel(final ParametroVO value) {
        model = value;
    }

    /**
     * Gets the stream.
     *
     * @return the stream
     */
    public InputStream getStream() {
        return stream;
    }
}
