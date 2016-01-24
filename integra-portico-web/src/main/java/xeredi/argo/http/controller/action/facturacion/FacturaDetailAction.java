package xeredi.argo.http.controller.action.facturacion;

import java.util.List;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.bo.AspectoBO;
import xeredi.argo.model.facturacion.bo.FacturaBO;
import xeredi.argo.model.facturacion.vo.AspectoCriterioVO;
import xeredi.argo.model.facturacion.vo.AspectoVO;
import xeredi.argo.model.facturacion.vo.FacturaCargoVO;
import xeredi.argo.model.facturacion.vo.FacturaImpuestoVO;
import xeredi.argo.model.facturacion.vo.FacturaServicioVO;
import xeredi.argo.model.facturacion.vo.FacturaVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaDetailAction.
 */
public final class FacturaDetailAction extends CrudDetailAction<FacturaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5987039917634891480L;

    /** The aspc. */
    @Getter
    private AspectoVO aspc;

    /** The fcts list. */
    @Getter
    private List<FacturaServicioVO> fctsList;

    /** The fcti list. */
    @Getter
    private List<FacturaImpuestoVO> fctiList;

    /** The fctg list. */
    @Getter
    private List<FacturaCargoVO> fctgList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final FacturaBO fctrBO = new FacturaBO();

        model = fctrBO.select(model.getId(), getIdioma());
        fctsList = fctrBO.selectFctsList(model.getId(), getIdioma());
        fctiList = fctrBO.selectFctiList(model.getId(), getIdioma());
        fctgList = fctrBO.selectFctgList(model.getId(), getIdioma());

        final AspectoBO aspcBO = new AspectoBO();
        final AspectoCriterioVO aspcCriterio = new AspectoCriterioVO();

        aspcCriterio.setId(model.getAspc().getId());
        aspcCriterio.setFechaVigencia(model.getFref());

        aspc = aspcBO.selectObject(aspcCriterio);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.fctr;
    }
}
