package xeredi.integra.http.controller.action.facturacion;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.google.common.base.Preconditions;

import xeredi.integra.http.controller.action.comun.BaseAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.CargoBO;
import xeredi.integra.model.facturacion.vo.CargoCriterioVO;
import xeredi.integra.model.facturacion.vo.CargoVO;
import xeredi.integra.model.servicio.bo.ServicioBO;
import xeredi.integra.model.servicio.bo.ServicioBOFactory;
import xeredi.integra.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoradorEditAction.
 */
public final class ValoradorEditAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7029860077578860054L;

    /** The srvc. */
    private ServicioVO srvc;

    /** The fliq. */
    private Date fliq;

    /** The crgo list. */
    private List<CargoVO> crgoList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doExecute() throws ApplicationException {
        Preconditions.checkNotNull(srvc);
        Preconditions.checkNotNull(srvc.getId());
        Preconditions.checkNotNull(srvc.getEntiId());

        final ServicioBO srvcBO = ServicioBOFactory.newInstance(srvc.getEntiId());

        srvc = srvcBO.select(srvc.getId(), getIdioma());
        fliq = Calendar.getInstance().getTime();

        final CargoBO crgoBO = new CargoBO();
        final CargoCriterioVO crgoCriterio = new CargoCriterioVO();

        crgoCriterio.setTpsrId(srvc.getEntiId());
        crgoCriterio.setFechaVigencia(fliq);

        crgoList = crgoBO.selectList(crgoCriterio);
    }

    /**
     * Gets the srvc.
     *
     * @return the srvc
     */
    public ServicioVO getSrvc() {
        return srvc;
    }

    /**
     * Sets the srvc.
     *
     * @param value
     *            the new srvc
     */
    public void setSrvc(final ServicioVO value) {
        srvc = value;
    }

    /**
     * Gets the fliq.
     *
     * @return the fliq
     */
    public Date getFliq() {
        return fliq;
    }

    /**
     * Gets the crgo list.
     *
     * @return the crgo list
     */
    public List<CargoVO> getCrgoList() {
        return crgoList;
    }
}
