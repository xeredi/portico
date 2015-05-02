package xeredi.integra.http.controller.action.maestro;

import java.util.Calendar;

import xeredi.integra.http.controller.action.item.ItemTypeaheadAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.bo.ParametroBOFactory;
import xeredi.integra.model.maestro.vo.ParametroCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoParametroDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoParametroProxy;

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
