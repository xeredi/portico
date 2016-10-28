package xeredi.argo.http.controller.action.metamodelo;

import java.util.List;

import lombok.Data;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.metamodelo.bo.TipoParametroBO;
import xeredi.argo.model.metamodelo.bo.TipoSubparametroBO;
import xeredi.argo.model.metamodelo.vo.TipoParametroVO;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroDetailAction.
 */
@Data
public final class TipoParametroDetailAction extends EntidadDetailAction<TipoParametroVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 9182419626664730526L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.tppr;

    /** The tpsp list. */
    private List<TipoSubparametroVO> subentiList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificDetail() throws ApplicationException {
        final TipoParametroBO tpprBO = new TipoParametroBO();

        model = tpprBO.select(model.getId(), idioma);

        final TipoSubparametroBO tpspBO = new TipoSubparametroBO();
        final TipoSubparametroCriterioVO tpspCriterio = new TipoSubparametroCriterioVO();

        tpspCriterio.setTpprId(model.getId());
        tpspCriterio.setIdioma(idioma);

        subentiList = tpspBO.selectList(tpspCriterio);
    }
}
