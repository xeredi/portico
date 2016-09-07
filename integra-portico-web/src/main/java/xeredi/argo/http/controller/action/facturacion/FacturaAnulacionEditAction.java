package xeredi.argo.http.controller.action.facturacion;

import java.util.Calendar;
import java.util.List;

import com.google.common.base.Preconditions;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.bo.FacturaBO;
import xeredi.argo.model.facturacion.bo.FacturaSerieBO;
import xeredi.argo.model.facturacion.vo.FacturaAnulacionVO;
import xeredi.argo.model.facturacion.vo.FacturaSerieCriterioVO;
import xeredi.argo.model.facturacion.vo.FacturaSerieVO;
import xeredi.argo.model.facturacion.vo.FacturaVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaAnulacionEditAction.
 */
public final class FacturaAnulacionEditAction extends CrudEditAction<FacturaAnulacionVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3480470491984180806L;

    @Getter
    private List<FacturaSerieVO> fcsrList;

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.fcan;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        Preconditions.checkNotNull(model.getFctrId());

        final FacturaBO fctrBO = new FacturaBO();
        final FacturaVO fctr = fctrBO.select(model.getFctrId(), getIdioma());

        model.setFecha(Calendar.getInstance().getTime());
        model.setFcsrId(fctr.getFcsr().getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        final FacturaSerieBO fcsrBO = new FacturaSerieBO();
        final FacturaSerieCriterioVO fcsrCriterio = new FacturaSerieCriterioVO();

        fcsrCriterio.setAnio(Calendar.getInstance().get(Calendar.YEAR));

        fcsrList = fcsrBO.selectList(fcsrCriterio);
    }
}