package xeredi.integra.http.controller.action.metamodelo;

import java.util.List;

import xeredi.integra.http.controller.action.comun.CrudDetailAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.metamodelo.bo.TramiteBO;
import xeredi.integra.model.metamodelo.bo.TramiteTipoDatoBO;
import xeredi.integra.model.metamodelo.vo.TramiteTipoDatoCriterioVO;
import xeredi.integra.model.metamodelo.vo.TramiteTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TramiteVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class TramiteDetailAction.
 */
public final class TramiteDetailAction extends CrudDetailAction<TramiteVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8184203973522067742L;

    /** The trtd list. */
    private List<TramiteTipoDatoVO> trtdList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final TramiteBO trmtBO = new TramiteBO();

        model = trmtBO.select(model.getId(), idioma);

        final TramiteTipoDatoBO trtdBO = new TramiteTipoDatoBO();
        final TramiteTipoDatoCriterioVO trtdCriterio = new TramiteTipoDatoCriterioVO();

        trtdCriterio.setTrmtId(model.getId());
        trtdCriterio.setIdioma(idioma);

        trtdList = trtdBO.selectList(trtdCriterio);
    }

    /**
     * Gets the trtd list.
     *
     * @return the trtd list
     */
    public List<TramiteTipoDatoVO> getTrtdList() {
        return trtdList;
    }
}
