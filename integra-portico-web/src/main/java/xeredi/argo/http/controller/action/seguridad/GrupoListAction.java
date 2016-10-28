package xeredi.argo.http.controller.action.seguridad;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.seguridad.bo.GrupoBO;
import xeredi.argo.model.seguridad.vo.GrupoCriterioVO;
import xeredi.argo.model.seguridad.vo.GrupoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class GrupoListAction.
 */
@Data
public final class GrupoListAction extends GridListAction<GrupoCriterioVO, GrupoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5074804383452913721L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.grpo;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        final GrupoBO grpoBO = new GrupoBO();

        resultList = grpoBO.selectList(model, getOffset(), limit);
    }
}
