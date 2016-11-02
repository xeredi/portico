package xeredi.argo.http.controller.action.seguridad;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.seguridad.bo.GrupoBO;
import xeredi.argo.model.seguridad.bo.UsuarioBO;
import xeredi.argo.model.seguridad.vo.GrupoCriterioVO;
import xeredi.argo.model.seguridad.vo.GrupoVO;
import xeredi.argo.model.seguridad.vo.UsuarioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioDetailAction.
 */
@Data
@EqualsAndHashCode(callSuper = true)
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
        final UsuarioBO usroBO = new UsuarioBO();

        model = usroBO.select(model.getId(), getIdioma());

        final GrupoBO grpoBO = new GrupoBO();
        final GrupoCriterioVO grpoCriterio = new GrupoCriterioVO();

        grpoCriterio.setUsroId(model.getId());

        grpoList = grpoBO.selectList(grpoCriterio);
    }
}
