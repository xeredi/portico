package xeredi.argo.http.controller.action.estadistica;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import xeredi.argo.http.controller.action.item.ItemFilterAction;
import xeredi.argo.model.comun.bo.PuertoBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.estadistica.vo.EstadisticaCriterioVO;
import xeredi.argo.model.metamodelo.proxy.TipoEstadisticaProxy;
import xeredi.argo.model.metamodelo.vo.TipoEstadisticaDetailVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EstadisticaFilterAction.
 */
public final class EstadisticaFilterAction extends ItemFilterAction<EstadisticaCriterioVO, TipoEstadisticaDetailVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7668343371684180192L;

    /** The prto list. */
    private List<PuertoVO> prtoList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificPrepareFilter() throws ApplicationException {
        Preconditions.checkNotNull(model.getPepr());
        Preconditions.checkNotNull(model.getPepr().getId());
        Preconditions.checkNotNull(model.getPepr().getSprtId());
        Preconditions.checkNotNull(model.getIdioma());

        enti = TipoEstadisticaProxy.select(model.getEntiId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificLoadDependencies() throws ApplicationException {
        final PuertoBO prtoBO = new PuertoBO();
        final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

        prtoCriterio.setSprtId(getSprtId());
        prtoCriterio.setIdioma(idioma);

        prtoList = prtoBO.selectList(prtoCriterio);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date getFechaVigencia() {
        // FIXME Devolver fecha de referencia del periodo de proceso
        return Calendar.getInstance().getTime();
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
