package xeredi.argo.http.controller.action.seguridad;

import java.util.List;

import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.EntidadBO;
import xeredi.argo.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadVO;
import xeredi.argo.model.seguridad.bo.AccionBO;
import xeredi.argo.model.seguridad.bo.AccionEntidadBO;
import xeredi.argo.model.seguridad.bo.GrupoBO;
import xeredi.argo.model.seguridad.vo.AccionCriterioVO;
import xeredi.argo.model.seguridad.vo.AccionEntidadCriterioVO;
import xeredi.argo.model.seguridad.vo.AccionEntidadVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;
import xeredi.argo.model.seguridad.vo.AccionVO;
import xeredi.argo.model.seguridad.vo.GrupoCriterioVO;
import xeredi.argo.model.seguridad.vo.GrupoVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionEntidadEditAction.
 */
public final class AccionEntidadEditAction extends CrudEditAction<AccionEntidadVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6298953902914627135L;

    /** The accn list. */
    private List<AccionVO> accnList;

    /** The enti list. */
    private List<EntidadVO> entiList;

    /** The grpo list. */
    private List<GrupoVO> grpoList;

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
    public void doEdit() throws ApplicationException {
        if (accion == ACCION_EDICION.create) {
            model = new AccionEntidadVO();
        } else {
            Preconditions.checkNotNull(model.getId());

            final AccionEntidadBO acenBO = new AccionEntidadBO();
            final AccionEntidadCriterioVO acenCriterio = new AccionEntidadCriterioVO();

            acenCriterio.setId(model.getId());

            model = acenBO.selectObject(acenCriterio);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        final AccionBO accnBO = new AccionBO();
        final AccionCriterioVO accnCriterio = new AccionCriterioVO();

        accnCriterio.setPrefix(AccionPrefix.item);

        accnList = accnBO.selectList(accnCriterio);

        final EntidadBO entiBO = new EntidadBO();
        final EntidadCriterioVO entiCriterio = new EntidadCriterioVO();

        entiCriterio.setIdioma(getIdioma());

        entiList = entiBO.selectList(entiCriterio);

        final GrupoBO grpoBO = new GrupoBO();
        final GrupoCriterioVO grpoCriterio = new GrupoCriterioVO();

        grpoList = grpoBO.selectList(grpoCriterio);
    }

    /**
     * Gets the accn list.
     *
     * @return the accn list
     */
    public List<AccionVO> getAccnList() {
        return accnList;
    }

    /**
     * Gets the enti list.
     *
     * @return the enti list
     */
    public List<EntidadVO> getEntiList() {
        return entiList;
    }

    /**
     * Gets the grpo list.
     *
     * @return the grpo list
     */
    public List<GrupoVO> getGrpoList() {
        return grpoList;
    }
}
