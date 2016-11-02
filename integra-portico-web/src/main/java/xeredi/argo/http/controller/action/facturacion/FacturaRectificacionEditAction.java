package xeredi.argo.http.controller.action.facturacion;

import java.util.List;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.bo.FacturaBO;
import xeredi.argo.model.facturacion.bo.ValoracionBO;
import xeredi.argo.model.facturacion.vo.FacturaRectificacionVO;
import xeredi.argo.model.facturacion.vo.FacturaVO;
import xeredi.argo.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaRectificacionEditAction.
 */
@Data
public final class FacturaRectificacionEditAction extends CrudEditAction<FacturaRectificacionVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -9102133120619646073L;

    /** The vlrc list. */
    private List<ValoracionVO> vlrcList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        Preconditions.checkNotNull(model.getFctrId());

        final FacturaBO fctrBO = new FacturaBO();

        final FacturaVO fctr = fctrBO.select(model.getFctrId(), getIdioma());

        final ValoracionBO vlrcBO = new ValoracionBO();
        final ValoracionCriterioVO vlrcCriterio = new ValoracionCriterioVO();

        vlrcCriterio.setFctr(fctr);
        vlrcCriterio.setIdioma(getIdioma());

        vlrcList = vlrcBO.selectList(vlrcCriterio);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        // noop
    }
}
