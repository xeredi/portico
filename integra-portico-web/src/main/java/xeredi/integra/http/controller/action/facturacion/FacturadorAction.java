package xeredi.integra.http.controller.action.facturacion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.facturacion.bo.AspectoBO;
import xeredi.integra.model.facturacion.bo.FacturaSerieBO;
import xeredi.integra.model.facturacion.bo.ValoracionBO;
import xeredi.integra.model.facturacion.vo.AspectoCriterioVO;
import xeredi.integra.model.facturacion.vo.FacturaSerieCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionVO;
import xeredi.integra.model.proceso.bo.ProcesoBO;
import xeredi.integra.model.proceso.vo.ItemTipo;
import xeredi.integra.model.proceso.vo.ProcesoTipo;
import xeredi.integra.proceso.facturacion.ProcesoFacturador;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturadorAction.
 */
public final class FacturadorAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2006641628607625624L;

    /** The vlrc. */
    private ValoracionVO vlrc;

    /** The ffac. */
    private Date ffac;

    /** The aspc id. */
    private Long aspcId;

    /** The fcsr id. */
    private Long fcsrId;

    /** The aspc list. */
    private List<LabelValueVO> aspcList;

    /** The fcsr list. */
    private List<LabelValueVO> fcsrList;

    // Actiones Web

    /**
     * Prepare.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("fctr-prepare")
    public String prepare() throws ApplicationException {
        Preconditions.checkNotNull(vlrc);
        Preconditions.checkNotNull(vlrc.getId());

        final ValoracionBO vlrcBO = new ValoracionBO();
        final AspectoBO aspcBO = new AspectoBO();
        final FacturaSerieBO fcsrBO = new FacturaSerieBO();

        vlrc = vlrcBO.select(vlrc.getId(), getIdioma());
        ffac = vlrc.getFref();

        final AspectoCriterioVO aspcCriterio = new AspectoCriterioVO();

        aspcCriterio.setFechaVigencia(vlrc.getFref());
        aspcCriterio.setIdioma(getIdioma());
        aspcCriterio.setTpsrId(vlrc.getSrvc().getEntiId());

        aspcList = aspcBO.selectLabelValueList(aspcCriterio);

        final FacturaSerieCriterioVO fcsrCriterio = new FacturaSerieCriterioVO();
        final Calendar calendar = Calendar.getInstance();

        calendar.setTime(ffac);
        fcsrCriterio.setAnio(calendar.get(Calendar.YEAR));

        fcsrList = fcsrBO.selectLabelValueList(fcsrCriterio);

        return SUCCESS;
    }

    /**
     * Facturar.
     *
     * @return the string
     */
    @Action("fctr-facturar")
    public String facturar() {
        Preconditions.checkNotNull(vlrc);
        Preconditions.checkNotNull(vlrc.getId());

        FieldValidator.validateRequired(this, MessageI18nKey.fctr_ffac, ffac);
        FieldValidator.validateRequired(this, MessageI18nKey.fcsr, fcsrId);

        if (!hasErrors()) {
            final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            final ProcesoBO prbtBO = new ProcesoBO();
            final List<Long> itemEntradaList = Arrays.asList(vlrc.getId());
            final Map<String, String> parametroMap = new HashMap<>();

            parametroMap.put(ProcesoFacturador.FFAC_PARAM, dateFormat.format(ffac));
            parametroMap.put(ProcesoFacturador.FCSRID_PARAM, fcsrId.toString());

            if (aspcId != null) {
                parametroMap.put(ProcesoFacturador.ASPCID_PARAM, aspcId.toString());
            }

            prbtBO.crear(ProcesoTipo.FACTURADOR, parametroMap, ItemTipo.vlrc, itemEntradaList, null);
        }

        return SUCCESS;
    }

    // get / set

    /**
     * Gets the vlrc.
     *
     * @return the vlrc
     */
    public ValoracionVO getVlrc() {
        return vlrc;
    }

    /**
     * Sets the vlrc.
     *
     * @param value
     *            the new vlrc
     */
    public void setVlrc(final ValoracionVO value) {
        vlrc = value;
    }

    /**
     * Gets the ffac.
     *
     * @return the ffac
     */
    public Date getFfac() {
        return ffac;
    }

    /**
     * Sets the ffac.
     *
     * @param value
     *            the new ffac
     */
    public void setFfac(final Date value) {
        ffac = value;
    }

    /**
     * Gets the aspc list.
     *
     * @return the aspc list
     */
    public List<LabelValueVO> getAspcList() {
        return aspcList;
    }

    /**
     * Gets the aspc id.
     *
     * @return the aspc id
     */
    public Long getAspcId() {
        return aspcId;
    }

    /**
     * Sets the aspc id.
     *
     * @param value
     *            the new aspc id
     */
    public void setAspcId(final Long value) {
        aspcId = value;
    }

    /**
     * Gets the fcsr id.
     *
     * @return the fcsr id
     */
    public Long getFcsrId() {
        return fcsrId;
    }

    /**
     * Sets the fcsr id.
     *
     * @param value
     *            the new fcsr id
     */
    public void setFcsrId(final Long value) {
        fcsrId = value;
    }

    /**
     * Gets the fcsr list.
     *
     * @return the fcsr list
     */
    public List<LabelValueVO> getFcsrList() {
        return fcsrList;
    }

}
