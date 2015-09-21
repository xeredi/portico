package xeredi.argo.http.controller.action.servicio.manifiesto;

import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.servicio.bo.manifiesto.BlBO;
import xeredi.argo.model.servicio.vo.SubservicioVO;
import xeredi.argo.model.servicio.vo.manifiesto.ResumenTotalesVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class BlTotalDetailAction.
 */
public final class BlTotalDetailAction extends CrudDetailAction<SubservicioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3008689259701964426L;

    /** The total vo. */
    private ResumenTotalesVO resumen;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());
        Preconditions.checkNotNull(model.getSrvc());
        Preconditions.checkNotNull(model.getSrvc().getId());

        final BlBO mablBO = new BlBO();

        model = mablBO.select(model.getId(), idioma);
        resumen = mablBO.selectResumen(model.getSrvc().getId(), model.getId());
    }

    /**
     * Gets the resumen.
     *
     * @return the resumen
     */
    public ResumenTotalesVO getResumen() {
        return resumen;
    }
}
