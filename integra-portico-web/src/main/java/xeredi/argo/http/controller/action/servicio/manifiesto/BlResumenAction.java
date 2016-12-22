package xeredi.argo.http.controller.action.servicio.manifiesto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.servicio.bo.manifiesto.BlBO;
import xeredi.argo.model.servicio.vo.SubservicioVO;
import xeredi.argo.model.servicio.vo.manifiesto.ResumenTotalesVO;

// TODO: Auto-generated Javadoc
/**
 * The Class BlTotalDetailAction.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class BlResumenAction extends CrudDetailAction<SubservicioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3008689259701964426L;

    /** The total vo. */
    private ResumenTotalesVO resumen;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        final BlBO mablBO = new BlBO(usroId);

        model = mablBO.select(model.getId(), idioma);
        resumen = mablBO.selectResumen(model.getSrvc().getId(), model.getId());
    }
}
