package xeredi.integra.http.controller.action.maestro;

import xeredi.integra.http.controller.action.TypeaheadAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.bo.ParametroBOFactory;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.maestro.vo.SubparametroTypeaheadCriterioVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubparametroDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubparametroProxy;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroTypeaheadSprmAction.
 */
public final class ParametroTypeaheadSprmAction extends TypeaheadAction<SubparametroTypeaheadCriterioVO, ParametroVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1585915543925314731L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doTypeahead() throws ApplicationException {
        Preconditions.checkNotNull(model.getTpspId());

        final TipoSubparametroDetailVO enti = TipoSubparametroProxy.select(model.getTpspId());
        final ParametroBO prmtBO = ParametroBOFactory.newInstance(enti.getEnti().getTpprAsociado().getId());

        resultList = prmtBO.selectTypeaheadSprmList(model, limit);
    }
}
