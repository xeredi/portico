package xeredi.integra.http.controller.action.maestro;

import java.util.Calendar;

import xeredi.integra.http.controller.action.item.ItemListAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.maestro.bo.SubparametroBO;
import xeredi.integra.model.maestro.vo.SubparametroCriterioVO;
import xeredi.integra.model.maestro.vo.SubparametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubparametroDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubparametroProxy;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class SubparametroListAction.
 */
public final class SubparametroListAction extends
        ItemListAction<SubparametroCriterioVO, SubparametroVO, TipoSubparametroDetailVO> {

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

        final SubparametroBO itemBO = new SubparametroBO();

        resultList = itemBO.selectList(model, getOffset(), limit);
    }
}
