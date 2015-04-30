package xeredi.integra.http.controller.action.facturacion;

import xeredi.integra.http.controller.action.TypeaheadAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.ReglaBO;
import xeredi.integra.model.facturacion.vo.ReglaCriterioVO;
import xeredi.integra.model.facturacion.vo.ReglaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class RegaLupaAction.
 */
public final class ReglaTypeaheadAction extends TypeaheadAction<ReglaCriterioVO, ReglaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -657608329114959872L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doTypeahead() throws ApplicationException {
        final ReglaBO rglaBO = new ReglaBO();

        resultList = rglaBO.selectList(model, limit);
    }
}
