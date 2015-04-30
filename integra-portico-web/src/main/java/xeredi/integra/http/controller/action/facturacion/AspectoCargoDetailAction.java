package xeredi.integra.http.controller.action.facturacion;

import xeredi.integra.http.controller.action.comun.CrudDetailAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.AspectoCargoBO;
import xeredi.integra.model.facturacion.vo.AspectoCargoCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoCargoVO;

import com.google.common.base.Preconditions;

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
        ascrCriterio.setFechaVigencia(fechaVigencia);
        ascrCriterio.setIdioma(idioma);

        model = ascrBO.selectObject(ascrCriterio);
    }
}
