package xeredi.argo.http.controller.action.seguridad;

import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.seguridad.bo.AccionBO;
import xeredi.argo.model.seguridad.bo.GrupoAccionBO;
import xeredi.argo.model.seguridad.bo.GrupoBO;
import xeredi.argo.model.seguridad.vo.AccionCriterioVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;
import xeredi.argo.model.seguridad.vo.AccionVO;
import xeredi.argo.model.seguridad.vo.GrupoAccionVO;
import xeredi.argo.model.seguridad.vo.GrupoCriterioVO;
import xeredi.argo.model.seguridad.vo.GrupoVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class GrupoAccionDetailAction.
 */
public final class GrupoAccionDetailAction extends CrudDetailAction<GrupoAccionVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8731840700086602249L;

    /** The accn. */
    private AccionVO accn;

    /** The grpo. */
    private GrupoVO grpo;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getGrpoId());
        Preconditions.checkNotNull(model.getAccnId());

        final GrupoAccionBO gracBO = new GrupoAccionBO();

        model = gracBO.select(model.getGrpoId(), model.getAccnId());

        final GrupoBO grpoBO = new GrupoBO();
        final GrupoCriterioVO grpoCriterio = new GrupoCriterioVO();

        grpoCriterio.setId(model.getGrpoId());
        grpoCriterio.setIdioma(getIdioma());

        grpo = grpoBO.selectObject(grpoCriterio);

        final AccionBO accnBO = new AccionBO();
        final AccionCriterioVO accnCriterio = new AccionCriterioVO();

        accnCriterio.setId(model.getAccnId());
        accnCriterio.setIdioma(getIdioma());

        accn = accnBO.selectObject(accnCriterio);
    }

    /**
     * Gets the accn.
     *
     * @return the accn
     */
    public AccionVO getAccn() {
        return accn;
    }

    /**
     * Gets the grpo.
     *
     * @return the grpo
     */
    public GrupoVO getGrpo() {
        return grpo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.grac;
    }
}
