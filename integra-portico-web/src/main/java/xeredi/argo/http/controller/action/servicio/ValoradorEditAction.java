package xeredi.argo.http.controller.action.servicio;

import java.util.Calendar;
import java.util.List;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.bo.CargoBO;
import xeredi.argo.model.facturacion.vo.CargoCriterioVO;
import xeredi.argo.model.facturacion.vo.CargoVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;
import xeredi.argo.model.servicio.vo.ValoradorVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoradorEditAction.
 */
public final class ValoradorEditAction extends CrudEditAction<ValoradorVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7029860077578860054L;

    /** The crgo list. */
    @Getter
    private List<CargoVO> crgoList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        Preconditions.checkNotNull(model.getSrvc());
        Preconditions.checkNotNull(model.getSrvc().getId());
        Preconditions.checkNotNull(model.getSrvc().getEntiId());

        model.setFliq(Calendar.getInstance().getTime());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        Preconditions.checkNotNull(model.getSrvc().getEntiId());
        Preconditions.checkNotNull(model.getFliq());

        final CargoBO crgoBO = new CargoBO();
        final CargoCriterioVO crgoCriterio = new CargoCriterioVO();

        crgoCriterio.setTpsrId(model.getSrvc().getEntiId());
        crgoCriterio.setFechaVigencia(model.getFliq());

        crgoList = crgoBO.selectList(crgoCriterio);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.vldr;
    }
}
