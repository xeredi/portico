package xeredi.argo.http.controller.action.facturacion;

import java.util.List;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.bo.AspectoBO;
import xeredi.argo.model.facturacion.bo.ValoracionBO;
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
import xeredi.argo.model.seguridad.vo.AccionPrefix;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionLineaEditAction.
 */
public final class ValoracionLineaEditAction extends CrudEditAction<ValoracionLineaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1498921008270553150L;

    /** The vlrl padre. */
    @Getter
    private ValoracionLineaVO vlrlPadre;

    /** The aspc. */
    @Getter
    private AspectoVO aspc;

    /** The impuesto list. */
    @Getter
    private List<ParametroVO> impuestoList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        Preconditions.checkNotNull(model.getVlrcId());

        final ValoracionBO vlrcBO = new ValoracionBO();

        switch (accion) {
        case create:
            final ValoracionVO vlrc = vlrcBO.select(model.getVlrcId(), getIdioma());

            model.setFref(vlrc.getFref());

            break;
        case edit:
            Preconditions.checkNotNull(model.getId());

            {
                final ValoracionLineaCriterioVO vlrlCriterio = new ValoracionLineaCriterioVO();

                vlrlCriterio.setId(model.getId());
                vlrlCriterio.setIdioma(getIdioma());

                model = vlrcBO.selectVlrlObject(vlrlCriterio);
            }

            if (model.getId() == model.getPadreId()) {
                vlrlPadre = model;
            } else {
                final ValoracionLineaCriterioVO vlrlCriterio = new ValoracionLineaCriterioVO();

                vlrlCriterio.setId(model.getPadreId());
                vlrlCriterio.setIdioma(getIdioma());

                vlrlPadre = vlrcBO.selectVlrlObject(vlrlCriterio);
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

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.vlrl;
    }
}
