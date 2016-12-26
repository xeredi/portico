package xeredi.argo.http.controller.action.metamodelo;

import java.util.List;

import com.google.inject.Inject;

import lombok.Getter;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.TipoSubservicioBO;
import xeredi.argo.model.metamodelo.bo.TramiteBO;
import xeredi.argo.model.metamodelo.service.EntidadService;
import xeredi.argo.model.metamodelo.service.TipoServicioService;
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
    @Getter
    private List<TipoSubservicioVO> subentiList;

    /** The enti hijas list. */
    @Getter
    private List<EntidadVO> entiHijasList;

    /** The trmt list. */
    @Getter
    private List<TramiteVO> trmtList;

	@Inject
	private TipoServicioService tpsrService;

    @Inject
	private EntidadService entiService;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificDetail() throws ApplicationException {
        model = tpsrService.select(model.getId(), getIdioma());

        final TipoSubservicioBO tpssBO = new TipoSubservicioBO();
        final TipoSubservicioCriterioVO tpssCriterio = new TipoSubservicioCriterioVO();

        tpssCriterio.setTpsrId(model.getId());
        tpssCriterio.setIdioma(getIdioma());

        subentiList = tpssBO.selectList(tpssCriterio);

        if (subentiList != null && !subentiList.isEmpty()) {
            final EntidadCriterioVO entiCriterio = new EntidadCriterioVO();

            entiCriterio.setEntiPadreId(model.getId());
            entiCriterio.setIdioma(getIdioma());

            entiHijasList = entiService.selectList(entiCriterio);
        }

        final TramiteBO trmtBO = new TramiteBO();
        final TramiteCriterioVO trmtCriterio = new TramiteCriterioVO();

        trmtCriterio.setEntiId(model.getId());
        trmtCriterio.setIdioma(getIdioma());

        trmtList = trmtBO.selectList(trmtCriterio);
    }
}
