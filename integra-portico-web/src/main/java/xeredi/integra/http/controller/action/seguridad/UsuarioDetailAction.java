package xeredi.integra.http.controller.action.seguridad;

import java.util.List;

import xeredi.integra.http.controller.action.comun.CrudDetailAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.seguridad.bo.GrupoBO;
import xeredi.integra.model.seguridad.bo.UsuarioBO;
import xeredi.integra.model.seguridad.vo.GrupoCriterioVO;
import xeredi.integra.model.seguridad.vo.GrupoVO;
import xeredi.integra.model.seguridad.vo.UsuarioCriterioVO;
import xeredi.integra.model.seguridad.vo.UsuarioVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioDetailAction.
 */
public final class UsuarioDetailAction extends CrudDetailAction<UsuarioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6846870204891602906L;

    /** The grpo list. */
    private List<GrupoVO> grpoList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final UsuarioBO usroBO = new UsuarioBO();
        final UsuarioCriterioVO usroCriterio = new UsuarioCriterioVO();

        usroCriterio.setIdioma(getIdioma());
        usroCriterio.setId(model.getId());

        model = usroBO.selectObject(usroCriterio);

        final GrupoBO grpoBO = new GrupoBO();
        final GrupoCriterioVO grpoCriterio = new GrupoCriterioVO();

        grpoCriterio.setUsroId(model.getId());

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
