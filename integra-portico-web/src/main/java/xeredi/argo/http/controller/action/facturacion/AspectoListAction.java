package xeredi.argo.http.controller.action.facturacion;

import java.util.Calendar;

import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.bo.AspectoBO;
import xeredi.argo.model.facturacion.vo.AspectoCriterioVO;
import xeredi.argo.model.facturacion.vo.AspectoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoListAction.
 */
public final class AspectoListAction extends GridListAction<AspectoCriterioVO, AspectoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6610833697858691088L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        if (model.getFechaVigencia() == null) {
            model.setFechaVigencia(Calendar.getInstance().getTime());
        }

        final AspectoBO aspcBO = new AspectoBO();

        resultList = aspcBO.selectList(model, getOffset(), limit);
    }
}
