package xeredi.argo.http.controller.action.servicio.bl;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.servicio.bo.manifiesto.BlBO;
import xeredi.argo.model.servicio.vo.SubservicioVO;
import xeredi.argo.model.servicio.vo.manifiesto.ResumenTotalesVO;

// TODO: Auto-generated Javadoc
/**
 * The Class BlTotalDetailAction.
 */
@Data
public final class ResumenTotalesAction extends CrudDetailAction<SubservicioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3008689259701964426L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.item;

    /** The total vo. */
    private ResumenTotalesVO resumen;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final BlBO mablBO = new BlBO();

        model = mablBO.select(model.getId(), idioma);
        resumen = mablBO.selectResumen(model.getSrvc().getId(), model.getId());
    }
}
