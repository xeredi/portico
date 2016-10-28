package xeredi.argo.http.controller.action.facturacion;

import java.util.List;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.bo.AspectoBO;
import xeredi.argo.model.facturacion.bo.ValoracionDetalleBO;
import xeredi.argo.model.facturacion.bo.ValoracionLineaBO;
import xeredi.argo.model.facturacion.vo.AspectoCriterioVO;
import xeredi.argo.model.facturacion.vo.AspectoVO;
import xeredi.argo.model.facturacion.vo.ReglaTipo;
import xeredi.argo.model.facturacion.vo.ValoracionDetalleCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionDetalleVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaVO;
import xeredi.argo.model.metamodelo.vo.AccionPrefix;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionDetalleDetailAction.
 */
public final class ValoracionDetalleDetailAction extends CrudDetailAction<ValoracionDetalleVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 340743883680134402L;

    /** The vlrl. */
    @Getter
    private ValoracionLineaVO vlrl;

    /** The vlrl padre. */
    @Getter
    private ValoracionLineaVO vlrlPadre;

    /** The vlrd hijos list. */
    @Getter
    private List<ValoracionDetalleVO> vlrdHijosList;

    /** The aspc. */
    @Getter
    private AspectoVO aspc;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final ValoracionDetalleBO vlrdBO = new ValoracionDetalleBO();

        model = vlrdBO.select(model.getId(), getIdioma());

        // Busqueda de lineas hijas (coef/bonif)
        if (model.getRgla().getTipo() == ReglaTipo.T) {
            final ValoracionDetalleCriterioVO vlrdCriterio = new ValoracionDetalleCriterioVO();

            vlrdCriterio.setPadreId(model.getId());
            vlrdCriterio.setIdioma(idioma);
            vlrdCriterio.setSoloHijos(true);

            vlrdHijosList = vlrdBO.selectList(vlrdCriterio);
        }

        final ValoracionLineaBO vlrlBO = new ValoracionLineaBO();
        final ValoracionLineaCriterioVO vlrlCriterio = new ValoracionLineaCriterioVO();

        vlrlCriterio.setId(model.getVlrlId());
        vlrlCriterio.setIdioma(idioma);

        vlrl = vlrlBO.selectObject(vlrlCriterio);

        if (vlrl.getId() == vlrl.getPadreId()) {
            vlrlPadre = vlrl;
        } else {
            final ValoracionLineaCriterioVO vlrlPadreCriterio = new ValoracionLineaCriterioVO();

            vlrlPadreCriterio.setId(vlrl.getPadreId());
            vlrlPadreCriterio.setIdioma(idioma);

            vlrlPadre = vlrlBO.selectObject(vlrlPadreCriterio);
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
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.vlrd;
    }
}
