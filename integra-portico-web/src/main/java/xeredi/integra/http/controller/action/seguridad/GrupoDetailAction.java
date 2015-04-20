package xeredi.integra.http.controller.action.seguridad;

import xeredi.integra.http.controller.action.CrudDetailAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.seguridad.bo.GrupoBO;
import xeredi.integra.model.seguridad.vo.GrupoCriterioVO;
import xeredi.integra.model.seguridad.vo.GrupoVO;

import com.google.common.base.Preconditions;

/**
 * The Class GrupoDetailAction.
 */
public final class GrupoDetailAction extends CrudDetailAction<GrupoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1779406545837488228L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final GrupoBO grpoBO = new GrupoBO();
        final GrupoCriterioVO grpoCriterio = new GrupoCriterioVO();

        grpoCriterio.setId(model.getId());

        model = grpoBO.selectObject(grpoCriterio);
    }
}
