package xeredi.integra.http.controller.action.metamodelo;

import java.util.List;

import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.metamodelo.bo.EntidadBO;
import xeredi.integra.model.metamodelo.bo.TipoSubservicioBO;
import xeredi.integra.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadVO;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubservicioDetailAction.
 */
public final class TipoSubservicioDetailAction extends EntidadDetailAction<TipoSubservicioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2106629104252322129L;

    /** The enti hijas list. */
    private List<EntidadVO> entiHijasList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificDetail() throws ApplicationException {
        final TipoSubservicioBO tpssBO = new TipoSubservicioBO();

        model = tpssBO.select(model.getId(), getIdioma());

        final EntidadBO entiBO = new EntidadBO();
        final EntidadCriterioVO entiCriterio = new EntidadCriterioVO();

        entiCriterio.setEntiPadreId(model.getId());
        entiCriterio.setIdioma(getIdioma());

        entiHijasList = entiBO.selectList(entiCriterio);
    }

    /**
     * Gets the enti hijas list.
     *
     * @return the enti hijas list
     */
    public List<EntidadVO> getEntiHijasList() {
        return entiHijasList;
    }

}
