package xeredi.integra.http.controller.action.seguridad;

import java.util.List;

import xeredi.integra.http.controller.action.comun.CrudDetailAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.seguridad.bo.AccionBO;
import xeredi.integra.model.seguridad.bo.GrupoBO;
import xeredi.integra.model.seguridad.vo.AccionCriterioVO;
import xeredi.integra.model.seguridad.vo.AccionVO;
import xeredi.integra.model.seguridad.vo.GrupoCriterioVO;
import xeredi.integra.model.seguridad.vo.GrupoVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionDetailAction.
 */
public final class AccionDetailAction extends CrudDetailAction<AccionVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7336296287400722992L;

    /** The grpo list. */
    private List<GrupoVO> grpoList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final AccionBO accnBO = new AccionBO();
        final AccionCriterioVO accnCriterioVO = new AccionCriterioVO();

        accnCriterioVO.setId(model.getId());

        model = accnBO.selectObject(accnCriterioVO);

        final GrupoBO grpoBO = new GrupoBO();
        final GrupoCriterioVO grpoCriterio = new GrupoCriterioVO();

        grpoCriterio.setAccnId(model.getId());

        grpoList = grpoBO.selectList(grpoCriterio);
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
