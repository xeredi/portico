package xeredi.integra.http.controller.action.servicio.manifiesto;

import xeredi.integra.http.controller.action.comun.CrudDetailAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.servicio.bo.manifiesto.ManifiestoBO;
import xeredi.integra.model.servicio.vo.ServicioVO;
import xeredi.integra.model.servicio.vo.manifiesto.ResumenTotalesVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ManifiestoTotalDetailAction.
 */
public final class ManifiestoTotalDetailAction extends CrudDetailAction<ServicioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3964457625490510954L;

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

    /**
     * Gets the resumen.
     *
     * @return the resumen
     */
    public ResumenTotalesVO getResumen() {
        return resumen;
    }
}
