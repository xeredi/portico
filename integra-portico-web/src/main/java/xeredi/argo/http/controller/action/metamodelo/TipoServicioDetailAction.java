package xeredi.argo.http.controller.action.metamodelo;

import java.util.List;

import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.EntidadBO;
import xeredi.argo.model.metamodelo.bo.TipoServicioBO;
import xeredi.argo.model.metamodelo.bo.TipoSubservicioBO;
import xeredi.argo.model.metamodelo.bo.TramiteBO;
import xeredi.argo.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.argo.model.metamodelo.vo.TramiteCriterioVO;
import xeredi.argo.model.metamodelo.vo.TramiteVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoServicioDetailAction.
 */
public final class TipoServicioDetailAction extends EntidadDetailAction<TipoServicioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3574420037025529065L;

    /** The tpss list. */
    private List<TipoSubservicioVO> subentiList;

    /** The enti hijas list. */
    private List<EntidadVO> entiHijasList;

    /** The trmt list. */
    private List<TramiteVO> trmtList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificDetail() throws ApplicationException {
        final TipoServicioBO tpsrBO = new TipoServicioBO();

        model = tpsrBO.select(model.getId(), getIdioma());

        final TipoSubservicioBO tpssBO = new TipoSubservicioBO();
        final TipoSubservicioCriterioVO tpssCriterio = new TipoSubservicioCriterioVO();

        tpssCriterio.setTpsrId(model.getId());
        tpssCriterio.setIdioma(idioma);

        subentiList = tpssBO.selectList(tpssCriterio);

        if (subentiList != null && !subentiList.isEmpty()) {
            final EntidadBO entiBO = new EntidadBO();
            final EntidadCriterioVO entiCriterio = new EntidadCriterioVO();

            entiCriterio.setEntiPadreId(model.getId());
            entiCriterio.setIdioma(idioma);

            entiHijasList = entiBO.selectList(entiCriterio);
        }

        final TramiteBO trmtBO = new TramiteBO();
        final TramiteCriterioVO trmtCriterio = new TramiteCriterioVO();

        trmtCriterio.setEntiId(model.getId());
        trmtCriterio.setIdioma(idioma);

        trmtList = trmtBO.selectList(trmtCriterio);
    }

    /**
     * Gets the subenti list.
     *
     * @return the subenti list
     */
    public List<TipoSubservicioVO> getSubentiList() {
        return subentiList;
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
     * Gets the trmt list.
     *
     * @return the trmt list
     */
    public List<TramiteVO> getTrmtList() {
        return trmtList;
    }
}
