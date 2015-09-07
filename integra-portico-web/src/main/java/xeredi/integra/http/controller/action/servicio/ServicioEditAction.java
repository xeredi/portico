package xeredi.integra.http.controller.action.servicio;

import java.util.Calendar;
import java.util.List;

import com.google.common.base.Preconditions;

import xeredi.integra.http.controller.action.item.ItemEditAction;
import xeredi.integra.http.util.FieldFiller;
import xeredi.integra.model.comun.bo.PuertoBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.PuertoCriterioVO;
import xeredi.integra.model.comun.vo.PuertoVO;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.integra.model.metamodelo.vo.TipoServicioDetailVO;
import xeredi.integra.model.servicio.bo.ServicioBO;
import xeredi.integra.model.servicio.bo.ServicioBOFactory;
import xeredi.integra.model.servicio.vo.ServicioVO;

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

        setFechaVigencia(model.getFref());
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
