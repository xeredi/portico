package xeredi.argo.http.controller.action.servicio.manifiesto;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.servicio.bo.manifiesto.ManifiestoBO;
import xeredi.argo.model.servicio.vo.ServicioVO;
import xeredi.argo.model.servicio.vo.manifiesto.ResumenTotalesVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ManifiestoTotalDetailAction.
 */
@Data
public final class ResumenTotalesAction extends CrudDetailAction<ServicioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3964457625490510954L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.item;

    /** The resumen. */
    private ResumenTotalesVO resumen;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final ManifiestoBO maniBO = new ManifiestoBO();

        model = maniBO.select(model.getId(), idioma);
        resumen = maniBO.selectResumen(model.getId());
    }
}
