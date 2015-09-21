package xeredi.argo.http.controller.action.maestro;

import java.util.Calendar;

import xeredi.argo.http.controller.action.item.ItemTypeaheadAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.maestro.bo.ParametroBO;
import xeredi.argo.model.maestro.bo.ParametroBOFactory;
import xeredi.argo.model.maestro.vo.ParametroCriterioVO;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.metamodelo.proxy.TipoParametroProxy;
import xeredi.argo.model.metamodelo.vo.TipoParametroDetailVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroTypeaheadAction.
 */
public final class ParametroTypeaheadAction extends ItemTypeaheadAction<ParametroCriterioVO, ParametroVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7639038275412903995L;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doSpecificTypeahead() throws ApplicationException {
        final ParametroBO prmtBO = ParametroBOFactory.newInstance(model.getEntiId());
        final TipoParametroDetailVO entiDetail = TipoParametroProxy.select(model.getEntiId());

        if (entiDetail.getEnti().isPuerto()) {
            Preconditions.checkNotNull(model.getPrto());
            Preconditions.checkNotNull(model.getPrto().getId());
        }

        if (model.getFechaVigencia() == null) {
            model.setFechaVigencia(Calendar.getInstance().getTime());
        }

        resultList = prmtBO.selectLupaList(model, limit);
    }
}
