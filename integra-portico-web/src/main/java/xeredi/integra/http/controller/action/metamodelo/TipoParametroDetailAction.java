package xeredi.integra.http.controller.action.metamodelo;

import java.util.List;

import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.metamodelo.bo.TipoParametroBO;
import xeredi.integra.model.metamodelo.bo.TipoSubparametroBO;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroDetailAction.
 */
public final class TipoParametroDetailAction extends EntidadDetailAction<TipoParametroVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 9182419626664730526L;

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

    /**
     * Gets the subenti list.
     *
     * @return the subenti list
     */
    public List<TipoSubparametroVO> getSubentiList() {
        return subentiList;
    }

}
