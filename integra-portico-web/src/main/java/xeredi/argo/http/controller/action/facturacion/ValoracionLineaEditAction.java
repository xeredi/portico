package xeredi.argo.http.controller.action.facturacion;

import java.util.List;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.bo.AspectoBO;
import xeredi.argo.model.facturacion.bo.ValoracionBO;
import xeredi.argo.model.facturacion.bo.ValoracionLineaBO;
import xeredi.argo.model.facturacion.vo.AspectoCriterioVO;
import xeredi.argo.model.facturacion.vo.AspectoVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaVO;
import xeredi.argo.model.facturacion.vo.ValoracionVO;
import xeredi.argo.model.maestro.bo.ParametroBO;
import xeredi.argo.model.maestro.bo.ParametroBOFactory;
import xeredi.argo.model.maestro.vo.ParametroCriterioVO;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.metamodelo.vo.Entidad;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionLineaEditAction.
 */
@Data
public final class ValoracionLineaEditAction extends CrudEditAction<ValoracionLineaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1498921008270553150L;

    /** The vlrl padre. */
    private ValoracionLineaVO vlrlPadre;

    /** The aspc. */
    private AspectoVO aspc;

    /** The impuesto list. */
    private List<ParametroVO> impuestoList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        Preconditions.checkNotNull(model.getVlrcId());

        switch (accion) {
        case create:
            final ValoracionBO vlrcBO = new ValoracionBO();
            final ValoracionVO vlrc = vlrcBO.select(model.getVlrcId(), getIdioma());

            model.setFref(vlrc.getFref());

            break;
        case edit:
            Preconditions.checkNotNull(model.getId());

            final ValoracionLineaBO vlrlBO = new ValoracionLineaBO();

            {
                final ValoracionLineaCriterioVO vlrlCriterio = new ValoracionLineaCriterioVO();

                vlrlCriterio.setId(model.getId());
                vlrlCriterio.setIdioma(getIdioma());

                model = vlrlBO.selectObject(vlrlCriterio);
            }

            if (model.getId() == model.getPadreId()) {
                vlrlPadre = model;
            } else {
                final ValoracionLineaCriterioVO vlrlCriterio = new ValoracionLineaCriterioVO();

                vlrlCriterio.setId(model.getPadreId());
                vlrlCriterio.setIdioma(getIdioma());

                vlrlPadre = vlrlBO.selectObject(vlrlCriterio);
            }

            break;
        default:
            throw new Error("Accion no valida: " + accion);
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
        Preconditions.checkNotNull(model.getFref());

        final ParametroCriterioVO prmtCriterio = new ParametroCriterioVO();

        prmtCriterio.setEntiId(Entidad.TIPO_IVA.getId());
        prmtCriterio.setFechaVigencia(model.getFref());
        prmtCriterio.setIdioma(getIdioma());

        final ParametroBO prmtBO = ParametroBOFactory.newInstance(prmtCriterio.getEntiId());

        impuestoList = prmtBO.selectList(prmtCriterio);
    }
}
