package xeredi.argo.http.controller.action.seguridad;

import java.util.List;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
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
public final class UsuarioDetailAction extends CrudDetailAction<UsuarioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6846870204891602906L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.usro;

    /** The grpo list. */
    private List<GrupoVO> grpoList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final UsuarioBO usroBO = new UsuarioBO();

        model = usroBO.select(model.getId(), getIdioma());

        final GrupoBO grpoBO = new GrupoBO();
        final GrupoCriterioVO grpoCriterio = new GrupoCriterioVO();

        grpoCriterio.setUsroId(model.getId());

        grpoList = grpoBO.selectList(grpoCriterio);
    }
}
