package xeredi.argo.http.controller.action.seguridad;

import java.util.List;

import xeredi.argo.http.controller.action.comun.GridFilterAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.EntidadBO;
import xeredi.argo.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadVO;
import xeredi.argo.model.seguridad.bo.GrupoBO;
import xeredi.argo.model.seguridad.vo.AccionEntidadCriterioVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;
import xeredi.argo.model.seguridad.vo.GrupoCriterioVO;
import xeredi.argo.model.seguridad.vo.GrupoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionEntidadFilterAction.
 */
public final class AccionEntidadFilterAction extends GridFilterAction<AccionEntidadCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2393671879690210151L;

    /** The grpo list. */
    private List<GrupoVO> grpoList;

    /** The enti list. */
    private List<EntidadVO> entiList;

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
    public void doPrepareFilter() throws ApplicationException {
        // noop
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        final GrupoBO grpoBO = new GrupoBO();
        final GrupoCriterioVO grpoCriterio = new GrupoCriterioVO();

        grpoList = grpoBO.selectList(grpoCriterio);

        final EntidadBO entiBO = new EntidadBO();
        final EntidadCriterioVO entiCriterio = new EntidadCriterioVO();

        entiCriterio.setIdioma(getIdioma());

        entiList = entiBO.selectList(entiCriterio);
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
     * Gets the enti list.
     *
     * @return the enti list
     */
    public List<EntidadVO> getEntiList() {
        return entiList;
    }
}
