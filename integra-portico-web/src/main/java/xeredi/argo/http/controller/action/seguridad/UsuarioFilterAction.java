package xeredi.argo.http.controller.action.seguridad;

import java.util.List;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.GridFilterAction;
import xeredi.argo.model.comun.bo.PuertoBO;
import xeredi.argo.model.comun.bo.SuperpuertoBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.comun.vo.SuperpuertoCriterioVO;
import xeredi.argo.model.comun.vo.SuperpuertoVO;
import xeredi.argo.model.seguridad.bo.GrupoBO;
import xeredi.argo.model.seguridad.vo.GrupoCriterioVO;
import xeredi.argo.model.seguridad.vo.GrupoVO;
import xeredi.argo.model.seguridad.vo.UsuarioCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioFilterAction.
 */
@Data
public final class UsuarioFilterAction extends GridFilterAction<UsuarioCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6193819984435577729L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.usro;

    /** The sprt list. */
    private List<SuperpuertoVO> sprtList;

    /** The prto list. */
    private List<PuertoVO> prtoList;

    private List<GrupoVO> grpoList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doPrepareFilter() throws ApplicationException {
        // noop
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        final SuperpuertoBO sprtBO = new SuperpuertoBO();
        final SuperpuertoCriterioVO sprtCriterio = new SuperpuertoCriterioVO();

        sprtCriterio.setIdioma(getIdioma());

        sprtList = sprtBO.selectList(sprtCriterio);

        final PuertoBO prtoBO = new PuertoBO();
        final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

        prtoCriterio.setIdioma(getIdioma());

        prtoList = prtoBO.selectList(prtoCriterio);

        final GrupoBO grpoBO = new GrupoBO();
        final GrupoCriterioVO grpoCriterio = new GrupoCriterioVO();

        grpoCriterio.setIdioma(getIdioma());

        grpoList = grpoBO.selectList(grpoCriterio);
    }
}
