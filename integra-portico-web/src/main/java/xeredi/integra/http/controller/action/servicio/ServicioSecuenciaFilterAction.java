package xeredi.integra.http.controller.action.servicio;

import java.util.List;

import xeredi.integra.http.controller.action.comun.GridFilterAction;
import xeredi.integra.model.comun.bo.PuertoBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.PuertoCriterioVO;
import xeredi.integra.model.comun.vo.PuertoVO;
import xeredi.integra.model.metamodelo.bo.TipoServicioBO;
import xeredi.integra.model.metamodelo.vo.TipoServicioCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoServicioVO;
import xeredi.integra.model.servicio.vo.ServicioSecuenciaCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioSecuenciaFilterAction.
 */
public final class ServicioSecuenciaFilterAction extends GridFilterAction<ServicioSecuenciaCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6314175196167234783L;

    /** The tpsr list. */
    private List<TipoServicioVO> tpsrList;

    /** The prto list. */
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
     * Gets the tpsr list.
     *
     * @return the tpsr list
     */
    public List<TipoServicioVO> getTpsrList() {
        return tpsrList;
    }

    /**
     * Gets the prto list.
     *
     * @return the prto list
     */
    public List<PuertoVO> getPrtoList() {
        return prtoList;
    }
}
