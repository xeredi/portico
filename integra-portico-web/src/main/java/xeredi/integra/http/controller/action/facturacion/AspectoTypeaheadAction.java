package xeredi.integra.http.controller.action.facturacion;

import xeredi.integra.http.controller.action.TypeaheadAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.AspectoBO;
import xeredi.integra.model.facturacion.vo.AspectoTypeaheadCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoTypeaheadAction.
 */
public final class AspectoTypeaheadAction extends TypeaheadAction<AspectoTypeaheadCriterioVO, AspectoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6939730418443092158L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doTypeahead() throws ApplicationException {
        Preconditions.checkNotNull(model.getTpsrId());
        Preconditions.checkNotNull(model.getFechaVigencia());

        final AspectoBO aspcBO = new AspectoBO();

        resultList = aspcBO.selectList(model, limit);
    }
}
