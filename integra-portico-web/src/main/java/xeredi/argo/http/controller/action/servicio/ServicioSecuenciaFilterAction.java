package xeredi.argo.http.controller.action.servicio;

import java.util.List;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.GridFilterAction;
import xeredi.argo.model.comun.bo.PuertoBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.metamodelo.bo.TipoServicioBO;
import xeredi.argo.model.metamodelo.vo.AccionPrefix;
import xeredi.argo.model.metamodelo.vo.TipoServicioCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoServicioVO;
import xeredi.argo.model.servicio.vo.ServicioSecuenciaCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioSecuenciaFilterAction.
 */
public final class ServicioSecuenciaFilterAction extends GridFilterAction<ServicioSecuenciaCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6314175196167234783L;

    /** The tpsr list. */
    @Getter
    private List<TipoServicioVO> tpsrList;

    /** The prto list. */
    @Getter
    private List<PuertoVO> prtoList;

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
        final PuertoBO prtoBO = new PuertoBO();
        final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

        prtoCriterio.setIdioma(getIdioma());
        prtoCriterio.setSprtId(getSprtId());

        prtoList = prtoBO.selectList(prtoCriterio);

        final TipoServicioBO tpsrBO = new TipoServicioBO();
        final TipoServicioCriterioVO tpsrCriterio = new TipoServicioCriterioVO();

        tpsrCriterio.setIdioma(getIdioma());

        tpsrList = tpsrBO.selectList(tpsrCriterio);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.srsc;
    }
}
