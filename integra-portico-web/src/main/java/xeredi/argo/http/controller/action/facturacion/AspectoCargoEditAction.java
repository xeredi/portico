package xeredi.argo.http.controller.action.facturacion;

import java.util.List;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.bo.AspectoBO;
import xeredi.argo.model.facturacion.bo.AspectoCargoBO;
import xeredi.argo.model.facturacion.bo.CargoBO;
import xeredi.argo.model.facturacion.vo.AspectoCargoCriterioVO;
import xeredi.argo.model.facturacion.vo.AspectoCargoVO;
import xeredi.argo.model.facturacion.vo.AspectoCriterioVO;
import xeredi.argo.model.facturacion.vo.AspectoVO;
import xeredi.argo.model.facturacion.vo.CargoCriterioVO;
import xeredi.argo.model.facturacion.vo.CargoVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoCargoEditAction.
 */
public final class AspectoCargoEditAction extends CrudEditAction<AspectoCargoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1292421221150084862L;

    /** The crgo list. */
    @Getter
    private List<CargoVO> crgoList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        if (accion == ACCION_EDICION.create) {
            Preconditions.checkNotNull(model.getAspcId());
        } else {
            Preconditions.checkNotNull(model.getId());

            final AspectoCargoBO ascrBO = new AspectoCargoBO();
            final AspectoCargoCriterioVO ascrCriterio = new AspectoCargoCriterioVO();

            ascrCriterio.setId(model.getId());
            ascrCriterio.setFechaVigencia(model.getFref());
            ascrCriterio.setIdioma(idioma);

            model = ascrBO.selectObject(ascrCriterio);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        if (accion == ACCION_EDICION.create) {
            Preconditions.checkNotNull(model.getAspcId());

            final AspectoBO aspcBO = new AspectoBO();
            final AspectoCriterioVO aspcCriterio = new AspectoCriterioVO();

            aspcCriterio.setId(model.getAspcId());
            aspcCriterio.setFechaVigencia(model.getFref());
            aspcCriterio.setIdioma(getIdioma());

            final AspectoVO aspc = aspcBO.selectObject(aspcCriterio);

            final CargoBO crgoBO = new CargoBO();
            final CargoCriterioVO crgoCriterio = new CargoCriterioVO();

            crgoCriterio.setTpsrId(aspc.getTpsr().getId());
            crgoCriterio.setFechaVigencia(model.getFref());
            crgoCriterio.setIdioma(getIdioma());

            crgoList = crgoBO.selectList(crgoCriterio);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.ascr;
    }
}
