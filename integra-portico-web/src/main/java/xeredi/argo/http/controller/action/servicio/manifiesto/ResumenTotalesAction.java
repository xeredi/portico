package xeredi.argo.http.controller.action.servicio.manifiesto;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.vo.AccionPrefix;
import xeredi.argo.model.servicio.bo.manifiesto.ManifiestoBO;
import xeredi.argo.model.servicio.vo.ServicioVO;
import xeredi.argo.model.servicio.vo.manifiesto.ResumenTotalesVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ManifiestoTotalDetailAction.
 */
public final class ResumenTotalesAction extends CrudDetailAction<ServicioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3964457625490510954L;

    /** The resumen. */
    @Getter
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
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.item;
    }
}
