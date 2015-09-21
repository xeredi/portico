package xeredi.argo.http.controller.action.facturacion;

import java.util.List;

import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.bo.AspectoBO;
import xeredi.argo.model.facturacion.bo.ValoracionBO;
import xeredi.argo.model.facturacion.vo.AspectoCriterioVO;
import xeredi.argo.model.facturacion.vo.AspectoVO;
import xeredi.argo.model.facturacion.vo.ReglaTipo;
import xeredi.argo.model.facturacion.vo.ValoracionLineaCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionLineaDetailAction.
 */
public final class ValoracionLineaDetailAction extends CrudDetailAction<ValoracionLineaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -157778002663429185L;

    /** The aspc. */
    private AspectoVO aspc;

    /** The vlrl padre. */
    private ValoracionLineaVO vlrlPadre;

    /** The vlrl hijos list. */
    private List<ValoracionLineaVO> vlrlHijosList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());
        Preconditions.checkNotNull(model.getVlrcId());

        final ValoracionBO vlrcBO = new ValoracionBO();

        {
            final ValoracionLineaCriterioVO vlrlCriterio = new ValoracionLineaCriterioVO();

            vlrlCriterio.setId(model.getId());
            vlrlCriterio.setIdioma(getIdioma());

            model = vlrcBO.selectVlrlObject(vlrlCriterio);
        }

        // Busqueda de la linea padre
        if (model.getId() == model.getPadreId()) {
            vlrlPadre = model;
        } else {
            final ValoracionLineaCriterioVO vlrlCriterio = new ValoracionLineaCriterioVO();

            vlrlCriterio.setId(model.getPadreId());
            vlrlCriterio.setIdioma(getIdioma());

            vlrlPadre = vlrcBO.selectVlrlObject(vlrlCriterio);
        }

        // Busqueda de las lineas hija (coef/bonif)
        if (model.getRgla().getTipo() == ReglaTipo.T) {
            final ValoracionLineaCriterioVO vlrlCriterio = new ValoracionLineaCriterioVO();

            vlrlCriterio.setPadreId(model.getId());
            vlrlCriterio.setSoloHijos(true);
            vlrlCriterio.setIdioma(getIdioma());

            vlrlHijosList = vlrcBO.selectVlrlList(vlrlCriterio);
        }

        final AspectoBO aspcBO = new AspectoBO();
        final AspectoCriterioVO aspcCriterio = new AspectoCriterioVO();

        aspcCriterio.setVlrcId(model.getVlrcId());
        aspcCriterio.setIdioma(getIdioma());

        aspc = aspcBO.selectObject(aspcCriterio);
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
     * Gets the vlrl hijos list.
     *
     * @return the vlrl hijos list
     */
    public List<ValoracionLineaVO> getVlrlHijosList() {
        return vlrlHijosList;
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
