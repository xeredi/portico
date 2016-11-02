package xeredi.argo.http.controller.action.seguridad;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.seguridad.bo.GrupoBO;
import xeredi.argo.model.seguridad.vo.GrupoCriterioVO;
import xeredi.argo.model.seguridad.vo.GrupoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class GrupoListAction.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class GrupoListAction extends GridListAction<GrupoCriterioVO, GrupoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5074804383452913721L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        final GrupoBO grpoBO = new GrupoBO();

        resultList = grpoBO.selectList(model, getOffset(), limit);
    }
}
