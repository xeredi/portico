package xeredi.argo.http.controller.action.maestro;

import xeredi.argo.http.controller.action.comun.TypeaheadAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.maestro.bo.ParametroBO;
import xeredi.argo.model.maestro.bo.ParametroBOFactory;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.maestro.vo.SubparametroCriterioVO;
import xeredi.argo.model.metamodelo.proxy.TipoSubparametroProxy;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroDetailVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroTypeaheadSprmAction.
 */
public final class ParametroTypeaheadSprmAction extends TypeaheadAction<SubparametroCriterioVO, ParametroVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1585915543925314731L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doTypeahead() throws ApplicationException {
        Preconditions.checkNotNull(model.getTpsp());
        Preconditions.checkNotNull(model.getTpsp().getId());

        final TipoSubparametroDetailVO enti = TipoSubparametroProxy.select(model.getTpsp().getId());
        final ParametroBO prmtBO = ParametroBOFactory.newInstance(enti.getEnti().getTpprAsociado().getId());

        resultList = prmtBO.selectTypeaheadSprmList(model, limit);
    }
}
