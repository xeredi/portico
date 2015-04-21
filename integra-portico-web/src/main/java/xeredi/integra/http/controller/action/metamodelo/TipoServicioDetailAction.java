package xeredi.integra.http.controller.action.metamodelo;

import java.util.List;

import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.metamodelo.bo.EntidadBO;
import xeredi.integra.model.metamodelo.bo.TipoServicioBO;
import xeredi.integra.model.metamodelo.bo.TipoSubservicioBO;
import xeredi.integra.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadVO;
import xeredi.integra.model.metamodelo.vo.TipoServicioVO;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioVO;

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
            entiCriterio.setIdioma(getIdioma());

            entiHijasList = entiBO.selectList(entiCriterio);
        }
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
}