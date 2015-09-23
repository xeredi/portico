package xeredi.argo.http.controller.action.servicio;

import java.util.Calendar;
import java.util.List;

import xeredi.argo.http.controller.action.item.ItemEditAction;
import xeredi.argo.http.util.FieldFiller;
import xeredi.argo.model.comun.bo.PuertoBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.argo.model.metamodelo.vo.TipoServicioDetailVO;
import xeredi.argo.model.servicio.bo.ServicioBO;
import xeredi.argo.model.servicio.bo.ServicioBOFactory;
import xeredi.argo.model.servicio.vo.ServicioVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioEditAction.
 */
public final class ServicioEditAction extends ItemEditAction<ServicioVO, TipoServicioDetailVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8810469278894148887L;

    /** The prto list. */
    private List<PuertoVO> prtoList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificEdit() throws ApplicationException {
        final ServicioBO srvcBO = ServicioBOFactory.newInstance(model.getEntiId());

        enti = TipoServicioProxy.select(model.getEntiId());

        switch (accion) {
        case create:
            model.setFref(Calendar.getInstance().getTime());
            model.setAnno(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
            model.setEstado(enti.getEnti().getEstadoDef());

            FieldFiller.fillDefaultValues(model, enti);

            break;
        case duplicate:
            Preconditions.checkNotNull(model.getId());

            model = srvcBO.select(model.getId(), getIdioma());
            model.setEstado(enti.getEnti().getEstadoDef());

            break;
        case edit:
            Preconditions.checkNotNull(model.getId());

            model = srvcBO.select(model.getId(), getIdioma());

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
        final PuertoBO prtoBO = new PuertoBO();
        final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

        prtoCriterio.setSprtId(getSprtId());
        prtoCriterio.setIdioma(getIdioma());

        prtoList = prtoBO.selectList(prtoCriterio);
    }

    /**
     * Gets the prto list.
     *
     * @return the prto list
     */
    public List<PuertoVO> getPrtoList() {
        return prtoList;
    }
}
