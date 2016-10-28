package xeredi.argo.http.controller.action.seguridad;

import java.util.List;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.bo.PuertoBO;
import xeredi.argo.model.comun.bo.SuperpuertoBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.comun.vo.SuperpuertoCriterioVO;
import xeredi.argo.model.comun.vo.SuperpuertoVO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.AccionPrefix;
import xeredi.argo.model.seguridad.bo.GrupoBO;
import xeredi.argo.model.seguridad.bo.UsuarioBO;
import xeredi.argo.model.seguridad.vo.GrupoCriterioVO;
import xeredi.argo.model.seguridad.vo.GrupoVO;
import xeredi.argo.model.seguridad.vo.UsuarioVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioEditAction.
 */
public final class UsuarioEditAction extends CrudEditAction<UsuarioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4943518127497768526L;

    /** The grpo list. */
    @Getter
    private List<GrupoVO> grpoList;

    /** The sprt list. */
    @Getter
    private List<SuperpuertoVO> sprtList;

    /** The prto list. */
    @Getter
    private List<PuertoVO> prtoList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        if (accion == AccionCodigo.create) {
            model = new UsuarioVO();
        } else {
            Preconditions.checkNotNull(model.getId());

            final UsuarioBO usroBO = new UsuarioBO();

            model = usroBO.select(model.getId(), getIdioma());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        final GrupoBO grpoBO = new GrupoBO();
        final GrupoCriterioVO grpoCriterio = new GrupoCriterioVO();

        grpoList = grpoBO.selectList(grpoCriterio);

        final SuperpuertoBO sprtBO = new SuperpuertoBO();
        final SuperpuertoCriterioVO sprtCriterio = new SuperpuertoCriterioVO();

        sprtCriterio.setIdioma(getIdioma());

        sprtList = sprtBO.selectList(sprtCriterio);

        final PuertoBO prtoBO = new PuertoBO();
        final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

        prtoCriterio.setIdioma(getIdioma());

        prtoList = prtoBO.selectList(prtoCriterio);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.usro;
    }
}
