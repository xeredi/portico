package xeredi.argo.http.controller.action.metamodelo;

import java.util.List;

import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.CampoAgregacionBO;
import xeredi.argo.model.metamodelo.vo.CampoAgregacionVO;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class CampoAgregacionEditAction.
 */
public final class CampoAgregacionEditAction extends CrudEditAction<CampoAgregacionVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6163643952983909955L;

    /** The entd list. */
    private List<EntidadTipoDatoVO> entdList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        Preconditions.checkNotNull(model.getTpesId());

        if (accion == ACCION_EDICION.edit) {
            Preconditions.checkNotNull(model.getEntd());
            Preconditions.checkNotNull(model.getEntd().getId());

            final CampoAgregacionBO cmagBO = new CampoAgregacionBO();

            model = cmagBO.select(model.getTpesId(), model.getEntd().getId(), getIdioma());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        // FIXME Hay que cargar dependencias??
    }

    /**
     * Gets the entd list.
     *
     * @return the entd list
     */
    public List<EntidadTipoDatoVO> getEntdList() {
        return entdList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.cmag;
    }
}