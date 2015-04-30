package xeredi.integra.http.controller.action.facturacion;

import java.util.List;

import xeredi.integra.http.controller.action.CrudDetailAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.AspectoBO;
import xeredi.integra.model.facturacion.bo.ValoracionBO;
import xeredi.integra.model.facturacion.vo.AspectoCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoVO;
import xeredi.integra.model.facturacion.vo.ReglaTipo;
import xeredi.integra.model.facturacion.vo.ValoracionDetalleCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionDetalleVO;
import xeredi.integra.model.facturacion.vo.ValoracionLineaCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionLineaVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionDetalleDetailAction.
 */
public final class ValoracionDetalleDetailAction extends CrudDetailAction<ValoracionDetalleVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 340743883680134402L;

    /** The vlrl. */
    private ValoracionLineaVO vlrl;

    /** The vlrl padre. */
    private ValoracionLineaVO vlrlPadre;

    /** The vlrd hijos list. */
    private List<ValoracionDetalleVO> vlrdHijosList;

    /** The aspc. */
    private AspectoVO aspc;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getVlrcId());
        Preconditions.checkNotNull(model.getVlrlId());
        Preconditions.checkNotNull(model.getId());

        final ValoracionBO vlrcBO = new ValoracionBO();

        model = vlrcBO.selectVlrd(model.getId());

        // Busqueda de lineas hijas (coef/bonif)
        if (model.getRgla().getTipo() == ReglaTipo.T) {
            final ValoracionDetalleCriterioVO vlrdCriterio = new ValoracionDetalleCriterioVO();

            vlrdCriterio.setPadreId(model.getId());
            vlrdCriterio.setSoloHijos(true);

            vlrdHijosList = vlrcBO.selectVlrdList(vlrdCriterio);
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
     * Gets the vlrd hijos list.
     *
     * @return the vlrd hijos list
     */
    public List<ValoracionDetalleVO> getVlrdHijosList() {
        return vlrdHijosList;
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
