package xeredi.argo.http.controller.action.administracion.puerto;

import java.util.List;

import xeredi.argo.http.controller.action.comun.GridFilterAction;
import xeredi.argo.model.comun.bo.SuperpuertoBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.SuperpuertoCriterioVO;
import xeredi.argo.model.comun.vo.SuperpuertoVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

// TODO: Auto-generated Javadoc
/**
 * The Class PuertoFilterAction.
 */
public final class PuertoFilterAction extends GridFilterAction<PuertoCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7596165170000341208L;

    /** The sprt list. */
    private List<SuperpuertoVO> sprtList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doPrepareFilter() throws ApplicationException {
        // noop
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        final SuperpuertoBO sprtBO = new SuperpuertoBO();
        final SuperpuertoCriterioVO sprtCriterio = new SuperpuertoCriterioVO();

        sprtCriterio.setIdioma(idioma);

        sprtList = sprtBO.selectList(sprtCriterio);
    }

    /**
     * Gets the sprt list.
     *
     * @return the sprt list
     */
    public final List<SuperpuertoVO> getSprtList() {
        return sprtList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.prto;
    }
}
