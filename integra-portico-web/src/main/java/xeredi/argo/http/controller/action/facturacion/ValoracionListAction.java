package xeredi.argo.http.controller.action.facturacion;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.bo.ValoracionBO;
import xeredi.argo.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionVO;
import xeredi.argo.model.metamodelo.proxy.TipoDatoProxy;
import xeredi.argo.model.metamodelo.vo.TipoDato;
import xeredi.argo.model.metamodelo.vo.TipoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionListAction.
 */
@Data
public final class ValoracionListAction extends GridListAction<ValoracionCriterioVO, ValoracionVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3608142356966434674L;

    /** The tpdt cod exencion. */
    private TipoDatoVO tpdtCodExencion;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        final ValoracionBO vlrcBO = new ValoracionBO();

        model.setPendienteFacturar(true);

        resultList = vlrcBO.selectList(model, getOffset(), limit);
        tpdtCodExencion = TipoDatoProxy.select(TipoDato.COD_EXEN.getId());
    }
}
