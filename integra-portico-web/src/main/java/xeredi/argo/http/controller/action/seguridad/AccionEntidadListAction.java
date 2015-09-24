package xeredi.argo.http.controller.action.seguridad;

import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.seguridad.bo.AccionEntidadBO;
import xeredi.argo.model.seguridad.vo.AccionEntidadCriterioVO;
import xeredi.argo.model.seguridad.vo.AccionEntidadVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionEntidadListAction.
 */
public final class AccionEntidadListAction extends GridListAction<AccionEntidadCriterioVO, AccionEntidadVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7136474056276957028L;

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.acen;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        final AccionEntidadBO acenBO = new AccionEntidadBO();

        model.setIdioma(getIdioma());

        resultList = acenBO.selectList(model, getOffset(), limit);
    }

}
