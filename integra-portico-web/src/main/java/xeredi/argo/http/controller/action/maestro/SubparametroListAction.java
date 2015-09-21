package xeredi.argo.http.controller.action.maestro;

import java.util.Calendar;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.item.ItemListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.maestro.bo.SubparametroBO;
import xeredi.argo.model.maestro.bo.SubparametroBOFactory;
import xeredi.argo.model.maestro.vo.SubparametroCriterioVO;
import xeredi.argo.model.maestro.vo.SubparametroVO;
import xeredi.argo.model.metamodelo.proxy.TipoSubparametroProxy;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubparametroListAction.
 */
public final class SubparametroListAction
        extends ItemListAction<SubparametroCriterioVO, SubparametroVO, TipoSubparametroDetailVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -9034875553888656160L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificList() throws ApplicationException {
        Preconditions.checkNotNull(model.getPrmt().getId());

        if (model.getFechaVigencia() == null) {
            model.setFechaVigencia(Calendar.getInstance().getTime());
        }

        enti = TipoSubparametroProxy.select(model.getEntiId());

        final SubparametroBO itemBO = SubparametroBOFactory.newInstance(model.getEntiId());

        resultList = itemBO.selectList(model, getOffset(), limit);
    }
}
