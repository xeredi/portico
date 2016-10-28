package xeredi.argo.http.controller.action.facturacion;

import java.util.List;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.bo.AspectoBO;
import xeredi.argo.model.facturacion.bo.ValoracionLineaBO;
import xeredi.argo.model.facturacion.vo.AspectoCriterioVO;
import xeredi.argo.model.facturacion.vo.AspectoVO;
import xeredi.argo.model.facturacion.vo.ReglaTipo;
import xeredi.argo.model.facturacion.vo.ValoracionLineaCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaVO;
import xeredi.argo.model.metamodelo.vo.AccionPrefix;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionLineaDetailAction.
 */
public final class ValoracionLineaDetailAction extends CrudDetailAction<ValoracionLineaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -157778002663429185L;

    /** The aspc. */
    @Getter
    private AspectoVO aspc;

    /** The vlrl padre. */
    @Getter
    private ValoracionLineaVO vlrlPadre;

    /** The vlrl hijos list. */
    @Getter
    private List<ValoracionLineaVO> vlrlHijosList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final ValoracionLineaBO vlrlBO = new ValoracionLineaBO();

        {
            final ValoracionLineaCriterioVO vlrlCriterio = new ValoracionLineaCriterioVO();

            vlrlCriterio.setId(model.getId());
            vlrlCriterio.setIdioma(getIdioma());

            model = vlrlBO.selectObject(vlrlCriterio);
        }

        // Busqueda de la linea padre
        if (model.getId() == model.getPadreId()) {
            vlrlPadre = model;
        } else {
            final ValoracionLineaCriterioVO vlrlCriterio = new ValoracionLineaCriterioVO();

            vlrlCriterio.setId(model.getPadreId());
            vlrlCriterio.setIdioma(getIdioma());

            vlrlPadre = vlrlBO.selectObject(vlrlCriterio);
        }

        // Busqueda de las lineas hija (coef/bonif)
        if (model.getRgla().getTipo() == ReglaTipo.T) {
            final ValoracionLineaCriterioVO vlrlCriterio = new ValoracionLineaCriterioVO();

            vlrlCriterio.setPadreId(model.getId());
            vlrlCriterio.setSoloHijos(true);
            vlrlCriterio.setIdioma(getIdioma());

            vlrlHijosList = vlrlBO.selectList(vlrlCriterio);
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
        return AccionPrefix.vlrl;
    }
}
