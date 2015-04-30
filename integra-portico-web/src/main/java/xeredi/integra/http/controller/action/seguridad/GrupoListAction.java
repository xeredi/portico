package xeredi.integra.http.controller.action.seguridad;

import xeredi.integra.http.controller.action.comun.GridListAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.seguridad.bo.GrupoBO;
import xeredi.integra.model.seguridad.vo.GrupoCriterioVO;
import xeredi.integra.model.seguridad.vo.GrupoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class GrupoListAction.
 */
public final class GrupoListAction extends GridListAction<GrupoCriterioVO, GrupoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5074804383452913721L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        if (model == null) {
            model = new GrupoCriterioVO();
        }

        final GrupoBO grpoBO = new GrupoBO();

        resultList = grpoBO.selectList(model, getOffset(), limit);
    }
}
