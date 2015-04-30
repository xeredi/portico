package xeredi.integra.http.controller.action.metamodelo;

import java.util.List;

import xeredi.integra.http.controller.action.comun.CrudEditAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.metamodelo.bo.CampoAgregacionBO;
import xeredi.integra.model.metamodelo.vo.CampoAgregacionVO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;

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
}
