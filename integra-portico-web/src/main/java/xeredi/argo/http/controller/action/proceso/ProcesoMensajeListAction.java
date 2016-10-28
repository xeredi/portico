package xeredi.argo.http.controller.action.proceso;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.proceso.bo.ProcesoBO;
import xeredi.argo.model.proceso.vo.ProcesoMensajeCriterioVO;
import xeredi.argo.model.proceso.vo.ProcesoMensajeVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoMensajeListAction.
 */
@Data
public final class ProcesoMensajeListAction extends GridListAction<ProcesoMensajeCriterioVO, ProcesoMensajeVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5625987046816994729L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.prmn;

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
