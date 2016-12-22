package xeredi.argo.http.controller.action.servicio.manifiesto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.servicio.bo.manifiesto.ManifiestoBO;
import xeredi.argo.model.servicio.vo.ServicioVO;
import xeredi.argo.model.servicio.vo.manifiesto.ResumenTotalesVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ManifiestoTotalDetailAction.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class ManifiestoResumenAction extends CrudDetailAction<ServicioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3964457625490510954L;

    /** The resumen. */
    private ResumenTotalesVO resumen;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        final ManifiestoBO maniBO = new ManifiestoBO(usroId);

        model = maniBO.select(model.getId(), idioma);
        resumen = maniBO.selectResumen(model.getId());
    }
}
