package xeredi.argo.http.controller.action.facturacion;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.bo.ReglaIncompatibleBO;
import xeredi.argo.model.facturacion.vo.ReglaIncompatibleCriterioVO;
import xeredi.argo.model.facturacion.vo.ReglaIncompatibleVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaIncompatibleDetailAction.
 */
public final class ReglaIncompatibleDetailAction extends CrudDetailAction<ReglaIncompatibleVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7041617693291205414L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final ReglaIncompatibleBO rginBO = new ReglaIncompatibleBO();
        final ReglaIncompatibleCriterioVO rginCriterio = new ReglaIncompatibleCriterioVO();

        rginCriterio.setId(model.getId());
        rginCriterio.setFechaVigencia(model.getFref());

        model = rginBO.selectObject(rginCriterio);
    }
}
