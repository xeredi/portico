package xeredi.argo.http.controller.action.facturacion;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.bo.AspectoCargoBO;
import xeredi.argo.model.facturacion.vo.AspectoCargoCriterioVO;
import xeredi.argo.model.facturacion.vo.AspectoCargoVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoCargoDetailAction.
 */
public final class AspectoCargoDetailAction extends CrudDetailAction<AspectoCargoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3728076328413890092L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final AspectoCargoBO ascrBO = new AspectoCargoBO();
        final AspectoCargoCriterioVO ascrCriterio = new AspectoCargoCriterioVO();

        ascrCriterio.setId(model.getId());
        ascrCriterio.setFechaVigencia(model.getFref());
        ascrCriterio.setIdioma(idioma);

        model = ascrBO.selectObject(ascrCriterio);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.ascr;
    }
}
