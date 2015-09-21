package xeredi.argo.http.controller.action.metamodelo;

import java.util.List;

import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.EntidadBO;
import xeredi.argo.model.metamodelo.bo.TipoSubservicioBO;
import xeredi.argo.model.metamodelo.bo.TramiteBO;
import xeredi.argo.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.argo.model.metamodelo.vo.TramiteCriterioVO;
import xeredi.argo.model.metamodelo.vo.TramiteVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubservicioDetailAction.
 */
public final class TipoSubservicioDetailAction extends EntidadDetailAction<TipoSubservicioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2106629104252322129L;

    /** The enti hijas list. */
    private List<EntidadVO> entiHijasList;

    /** The enti padres list. */
    private List<EntidadVO> entiPadresList;

    /** The trmt list. */
    private List<TramiteVO> trmtList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificDetail() throws ApplicationException {
        final TipoSubservicioBO tpssBO = new TipoSubservicioBO();

        model = tpssBO.select(model.getId(), getIdioma());

        final EntidadBO entiBO = new EntidadBO();

        {
            final EntidadCriterioVO entiCriterio = new EntidadCriterioVO();

            entiCriterio.setEntiPadreId(model.getId());
            entiCriterio.setIdioma(idioma);

            entiHijasList = entiBO.selectList(entiCriterio);
        }

        {
            final EntidadCriterioVO entiCriterio = new EntidadCriterioVO();

            entiCriterio.setEntiHijaId(model.getId());
            entiCriterio.setIdioma(idioma);

            entiPadresList = entiBO.selectList(entiCriterio);
        }

        final TramiteBO trmtBO = new TramiteBO();
        final TramiteCriterioVO trmtCriterio = new TramiteCriterioVO();

        trmtCriterio.setEntiId(model.getId());
        trmtCriterio.setIdioma(idioma);

        trmtList = trmtBO.selectList(trmtCriterio);
    }

    /**
     * Gets the enti hijas list.
     *
     * @return the enti hijas list
     */
    public List<EntidadVO> getEntiHijasList() {
        return entiHijasList;
    }

    /**
     * Gets the enti padres list.
     *
     * @return the enti padres list
     */
    public List<EntidadVO> getEntiPadresList() {
        return entiPadresList;
    }

    /**
     * Gets the trmt list.
     *
     * @return the trmt list
     */
    public List<TramiteVO> getTrmtList() {
        return trmtList;
    }
}
