package xeredi.integra.http.controller.action.proceso;

import xeredi.integra.http.controller.action.comun.GridListAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.proceso.bo.ProcesoBO;
import xeredi.integra.model.proceso.vo.ProcesoMensajeCriterioVO;
import xeredi.integra.model.proceso.vo.ProcesoMensajeVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoMensajeListAction.
 */
public final class ProcesoMensajeListAction extends GridListAction<ProcesoMensajeCriterioVO, ProcesoMensajeVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5625987046816994729L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        Preconditions.checkNotNull(model.getPrbtId());

        final ProcesoBO prbtBO = new ProcesoBO();

        resultList = prbtBO.selectPrmnList(model, getOffset(), limit);
    }
}
