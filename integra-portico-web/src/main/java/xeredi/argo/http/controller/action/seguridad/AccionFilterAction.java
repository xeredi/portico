package xeredi.argo.http.controller.action.seguridad;

import java.util.List;

import xeredi.argo.http.controller.action.comun.GridFilterAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.seguridad.bo.GrupoBO;
import xeredi.argo.model.seguridad.vo.AccionCriterioVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;
import xeredi.argo.model.seguridad.vo.GrupoCriterioVO;
import xeredi.argo.model.seguridad.vo.GrupoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionFilterAction.
 */
public final class AccionFilterAction extends GridFilterAction<AccionCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1741238545886942803L;

    /** The prefix list. */
    private AccionPrefix[] prefixList;

    /** The grpo list. */
    private List<GrupoVO> grpoList;

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
        prefixList = AccionPrefix.values();

        final GrupoBO grpoBO = new GrupoBO();
        final GrupoCriterioVO grpoCriterio = new GrupoCriterioVO();

        grpoList = grpoBO.selectList(grpoCriterio);
    }

    /**
     * Gets the prefix list.
     *
     * @return the prefix list
     */
    public AccionPrefix[] getPrefixList() {
        return prefixList;
    }

    /**
     * Gets the grpo list.
     *
     * @return the grpo list
     */
    public List<GrupoVO> getGrpoList() {
        return grpoList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.accn;
    }
}
