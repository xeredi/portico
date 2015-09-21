package xeredi.argo.http.controller.action.facturacion;

import java.util.List;

import com.google.common.base.Preconditions;

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

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaDetailAction.
 */
public final class FacturaDetailAction extends CrudDetailAction<FacturaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5987039917634891480L;

    /** The aspc. */
    private AspectoVO aspc;

    /** The fcts list. */
    private List<FacturaServicioVO> fctsList;

    /** The fcti list. */
    private List<FacturaImpuestoVO> fctiList;

    /** The fctg list. */
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
     * Gets the fcts list.
     *
     * @return the fcts list
     */
    public List<FacturaServicioVO> getFctsList() {
        return fctsList;
    }

    /**
     * Gets the fcti list.
     *
     * @return the fcti list
     */
    public List<FacturaImpuestoVO> getFctiList() {
        return fctiList;
    }

    /**
     * Gets the fctg list.
     *
     * @return the fctg list
     */
    public List<FacturaCargoVO> getFctgList() {
        return fctgList;
    }

    /**
     * Gets the aspc.
     *
     * @return the aspc
     */
    public AspectoVO getAspc() {
        return aspc;
    }
}
