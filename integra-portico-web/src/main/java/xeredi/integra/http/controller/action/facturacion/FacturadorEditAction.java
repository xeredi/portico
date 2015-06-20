package xeredi.integra.http.controller.action.facturacion;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.google.common.base.Preconditions;

import xeredi.integra.http.controller.action.comun.BaseAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.AspectoBO;
import xeredi.integra.model.facturacion.bo.FacturaSerieBO;
import xeredi.integra.model.facturacion.bo.ValoracionBO;
import xeredi.integra.model.facturacion.vo.AspectoCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoVO;
import xeredi.integra.model.facturacion.vo.FacturaSerieCriterioVO;
import xeredi.integra.model.facturacion.vo.FacturaSerieVO;
import xeredi.integra.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturadorEditAction.
 */
public final class FacturadorEditAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1389260062489112937L;

    /** The vlrc. */
    private ValoracionVO vlrc;

    /** The ffac. */
    private Date ffac;

    /** The aspc list. */
    private List<AspectoVO> aspcList;

    /** The fcsr list. */
    private List<FacturaSerieVO> fcsrList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doExecute() throws ApplicationException {
        Preconditions.checkNotNull(vlrc);
        Preconditions.checkNotNull(vlrc.getId());

        final ValoracionBO vlrcBO = new ValoracionBO();
        final ValoracionCriterioVO vlrcCriterio = new ValoracionCriterioVO();

        vlrcCriterio.setId(vlrc.getId());
        vlrcCriterio.setIdioma(getIdioma());

        vlrc = vlrcBO.selectObject(vlrcCriterio);
        ffac = vlrc.getFref();

        final AspectoBO aspcBO = new AspectoBO();
        final AspectoCriterioVO aspcCriterio = new AspectoCriterioVO();

        aspcCriterio.setFechaVigencia(vlrc.getFref());
        aspcCriterio.setIdioma(getIdioma());
        aspcCriterio.setTpsrId(vlrc.getSrvc().getEntiId());

        aspcList = aspcBO.selectList(aspcCriterio);

        final FacturaSerieBO fcsrBO = new FacturaSerieBO();
        final FacturaSerieCriterioVO fcsrCriterio = new FacturaSerieCriterioVO();
        final Calendar calendar = Calendar.getInstance();

        calendar.setTime(ffac);
        fcsrCriterio.setAnio(calendar.get(Calendar.YEAR));

        fcsrList = fcsrBO.selectList(fcsrCriterio);
    }

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
     * Gets the aspc list.
     *
     * @return the aspc list
     */
    public List<AspectoVO> getAspcList() {
        return aspcList;
    }

    /**
     * Gets the fcsr list.
     *
     * @return the fcsr list
     */
    public List<FacturaSerieVO> getFcsrList() {
        return fcsrList;
    }
}
