package xeredi.argo.http.controller.action.facturacion;

import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.bo.AspectoBO;
import xeredi.argo.model.facturacion.bo.ValoracionBO;
import xeredi.argo.model.facturacion.vo.AspectoCriterioVO;
import xeredi.argo.model.facturacion.vo.AspectoVO;
import xeredi.argo.model.facturacion.vo.ValoracionDetalleVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionDetalleEditAction.
 */
public final class ValoracionDetalleEditAction extends CrudEditAction<ValoracionDetalleVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2216528521567482950L;

    /** The vlrl. */
    private ValoracionLineaVO vlrl;

    /** The vlrl padre. */
    private ValoracionLineaVO vlrlPadre;

    /** The aspc. */
    private AspectoVO aspc;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        Preconditions.checkNotNull(model.getVlrcId());
        Preconditions.checkNotNull(model.getVlrlId());

        final ValoracionBO vlrcBO = new ValoracionBO();

        if (accion == ACCION_EDICION.edit) {
            Preconditions.checkNotNull(model.getId());

            model = vlrcBO.selectVlrd(model.getId());
        }

        final ValoracionLineaCriterioVO vlrlCriterio = new ValoracionLineaCriterioVO();

        vlrlCriterio.setId(model.getVlrlId());
        vlrlCriterio.setIdioma(idioma);

        vlrl = vlrcBO.selectVlrlObject(vlrlCriterio);

        if (vlrl.getId() == vlrl.getPadreId()) {
            vlrlPadre = vlrl;
        } else {
            final ValoracionLineaCriterioVO vlrlPadreCriterio = new ValoracionLineaCriterioVO();

            vlrlPadreCriterio.setId(vlrl.getPadreId());
            vlrlPadreCriterio.setIdioma(idioma);

            vlrlPadre = vlrcBO.selectVlrlObject(vlrlPadreCriterio);
        }

        final AspectoBO aspcBO = new AspectoBO();
        final AspectoCriterioVO aspcCriterio = new AspectoCriterioVO();

        aspcCriterio.setVlrcId(model.getVlrcId());
        aspcCriterio.setIdioma(getIdioma());

        aspc = aspcBO.selectObject(aspcCriterio);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        // noop
    }

    /**
     * Gets the vlrl.
     *
     * @return the vlrl
     */
    public ValoracionLineaVO getVlrl() {
        return vlrl;
    }

    /**
     * Gets the vlrl padre.
     *
     * @return the vlrl padre
     */
    public ValoracionLineaVO getVlrlPadre() {
        return vlrlPadre;
    }

    /**
     * Gets the aspc.
     *
     * @return the aspc
     */
    public AspectoVO getAspc() {
        return aspc;
    }
}
