package xeredi.argo.http.controller.action.seguridad;

import java.util.List;

import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.seguridad.bo.AccionBO;
import xeredi.argo.model.seguridad.bo.GrupoBO;
import xeredi.argo.model.seguridad.vo.AccionCriterioVO;
import xeredi.argo.model.seguridad.vo.AccionVO;
import xeredi.argo.model.seguridad.vo.GrupoCriterioVO;
import xeredi.argo.model.seguridad.vo.GrupoVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class GrupoEditAction.
 */
public final class GrupoEditAction extends CrudEditAction<GrupoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5574343207861340756L;

    /** The accn list. */
    private List<AccionVO> accnList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        if (accion == ACCION_EDICION.create) {
            model = new GrupoVO();
        } else {
            Preconditions.checkNotNull(model.getId());

            final GrupoBO grpoBO = new GrupoBO();
            final GrupoCriterioVO grpoCriterio = new GrupoCriterioVO();

            grpoCriterio.setId(model.getId());

            model = grpoBO.selectObject(grpoCriterio);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        final AccionBO accnBO = new AccionBO();
        final AccionCriterioVO accnCriterio = new AccionCriterioVO();

        accnList = accnBO.selectList(accnCriterio);
    }

    /**
     * Gets the accn list.
     *
     * @return the accn list
     */
    public List<AccionVO> getAccnList() {
        return accnList;
    }

}
