package xeredi.argo.http.controller.action.facturacion;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.facturacion.bo.ValoracionDetalleBO;
import xeredi.argo.model.facturacion.vo.ValoracionDetalleCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionDetalleVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionDetalleListAction.
 */
@Data
public final class ValoracionDetalleListAction extends GridListAction<ValoracionDetalleCriterioVO, ValoracionDetalleVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5836376477924004332L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.vlrd;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        Preconditions.checkNotNull(model.getVlrlId());

        final ValoracionDetalleBO vlrdBO = new ValoracionDetalleBO();

        resultList = vlrdBO.selectList(model, getOffset(), limit);
    }
}
