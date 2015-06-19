package xeredi.integra.http.controller.action.facturacion;

import java.util.List;

import com.google.common.base.Preconditions;

import xeredi.integra.http.controller.action.comun.CrudDetailAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.FacturaBO;
import xeredi.integra.model.facturacion.vo.FacturaCargoVO;
import xeredi.integra.model.facturacion.vo.FacturaImpuestoVO;
import xeredi.integra.model.facturacion.vo.FacturaServicioVO;
import xeredi.integra.model.facturacion.vo.FacturaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaDetailAction.
 */
public final class FacturaDetailAction extends CrudDetailAction<FacturaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5987039917634891480L;

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

        model = fctrBO.select(model.getId());
        fctsList = fctrBO.selectFctsList(model.getId());
        fctiList = fctrBO.selectFctiList(model.getId());
        fctgList = fctrBO.selectFctgList(model.getId());
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
}
