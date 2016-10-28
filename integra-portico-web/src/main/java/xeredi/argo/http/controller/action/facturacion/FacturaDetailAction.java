package xeredi.argo.http.controller.action.facturacion;

import java.util.List;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.facturacion.bo.AspectoBO;
import xeredi.argo.model.facturacion.bo.FacturaBO;
import xeredi.argo.model.facturacion.bo.ValoracionBO;
import xeredi.argo.model.facturacion.bo.ValoracionCargoBO;
import xeredi.argo.model.facturacion.bo.ValoracionImpuestoBO;
import xeredi.argo.model.facturacion.vo.AspectoCriterioVO;
import xeredi.argo.model.facturacion.vo.AspectoVO;
import xeredi.argo.model.facturacion.vo.FacturaVO;
import xeredi.argo.model.facturacion.vo.ValoracionCargoVO;
import xeredi.argo.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionImpuestoVO;
import xeredi.argo.model.facturacion.vo.ValoracionVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaDetailAction.
 */
@Data
public final class FacturaDetailAction extends CrudDetailAction<FacturaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5987039917634891480L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.fctr;

    /** The aspc. */
    private AspectoVO aspc;

    /** The fcts list. */
    private List<ValoracionVO> vlrcList;

    /** The fcti list. */
    private List<ValoracionImpuestoVO> fctiList;

    /** The fctg list. */
    private List<ValoracionCargoVO> fctgList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final FacturaBO fctrBO = new FacturaBO();
        final ValoracionBO vlrcBO = new ValoracionBO();
        final ValoracionCargoBO vlrgBO = new ValoracionCargoBO();
        final ValoracionImpuestoBO vlriBO = new ValoracionImpuestoBO();
        final AspectoBO aspcBO = new AspectoBO();

        model = fctrBO.select(model.getId(), getIdioma());

        final ValoracionCriterioVO vlrcCriterio = new ValoracionCriterioVO();

        vlrcCriterio.setFctr(model);
        vlrcCriterio.setIdioma(getIdioma());

        vlrcList = vlrcBO.selectList(vlrcCriterio);
        fctgList = vlrgBO.selectList(vlrcCriterio);
        fctiList = vlriBO.selectList(vlrcCriterio);

        final AspectoCriterioVO aspcCriterio = new AspectoCriterioVO();

        aspcCriterio.setId(model.getAspc().getId());
        aspcCriterio.setFechaVigencia(model.getFref());
        aspcCriterio.setIdioma(getIdioma());

        aspc = aspcBO.selectObject(aspcCriterio);
    }
}
