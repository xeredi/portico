package xeredi.argo.http.controller.action.facturacion;

import java.util.Calendar;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.TypeaheadAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.bo.AspectoBO;
import xeredi.argo.model.facturacion.vo.AspectoCriterioVO;
import xeredi.argo.model.facturacion.vo.AspectoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoTypeaheadAction.
 */
public final class AspectoTypeaheadAction extends TypeaheadAction<AspectoCriterioVO, AspectoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6939730418443092158L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doTypeahead() throws ApplicationException {
        Preconditions.checkNotNull(model.getTpsrId());

        final AspectoBO aspcBO = new AspectoBO();

        resultList = aspcBO.selectTypeaheadList(model, limit);
    }
}
