package xeredi.argo.http.controller.action.servicio;

import java.util.Calendar;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.item.ItemEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioDetailVO;
import xeredi.argo.model.servicio.bo.ServicioBO;
import xeredi.argo.model.servicio.bo.ServicioBOFactory;
import xeredi.argo.model.servicio.bo.SubservicioBO;
import xeredi.argo.model.servicio.bo.SubservicioBOFactory;
import xeredi.argo.model.servicio.vo.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioEditAction.
 */
public final class SubservicioEditAction extends ItemEditAction<SubservicioVO, TipoSubservicioDetailVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3286199992331373729L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificEdit() throws ApplicationException {
        enti = TipoSubservicioProxy.select(model.getEntiId());

        final SubservicioBO ssrvBO = SubservicioBOFactory.newInstance(model.getEntiId(), usroId);

        switch (accion) {
        case create:
            if (model.getSrvc() != null && model.getSrvc().getId() != null) {
                final ServicioBO srvcBO = ServicioBOFactory.newInstance(enti.getEnti().getTpsrId(), usroId);

                model.setSrvc(srvcBO.select(model.getSrvc().getId(), idioma));
                model.setFref(model.getSrvc().getFref());

                // Si viene de un subservicio padre, lo buscamos
                for (final Long entiId : model.getSsrvPadreMap().keySet()) {
                    final SubservicioBO ssrvPadreBO = SubservicioBOFactory.newInstance(entiId, getUsroId());

                    model.getSsrvPadreMap().put(entiId,
                            ssrvPadreBO.select(model.getSsrvPadreMap().get(entiId).getId(), idioma));
                }
            } else {
                model.setFref(Calendar.getInstance().getTime());
            }

            model.setEstado(enti.getEnti().getEstadoDef());

            break;
        case edit:
        case duplicate:
            Preconditions.checkNotNull(model.getSrvc());
            Preconditions.checkNotNull(model.getSrvc().getId());

            model = ssrvBO.select(model.getId(), getIdioma());

            break;
        default:
            throw new Error("Invalid action: " + accion.name());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadSpecificDependencies() throws ApplicationException {
        // noop
    }
}
