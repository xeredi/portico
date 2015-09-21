package xeredi.argo.http.controller.action.maestro;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import xeredi.argo.http.controller.action.item.ItemFilterAction;
import xeredi.argo.model.comun.bo.PuertoBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.maestro.vo.ParametroCriterioVO;
import xeredi.argo.model.metamodelo.proxy.TipoParametroProxy;
import xeredi.argo.model.metamodelo.vo.TipoParametroDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroFilterAction.
 */
public final class ParametroFilterAction extends ItemFilterAction<ParametroCriterioVO, TipoParametroDetailVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1740124942966001653L;

    /** The prto list. */
    private List<PuertoVO> prtoList;

    /** The fecha vigencia. */
    private Date fechaVigencia;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificPrepareFilter() throws ApplicationException {
        enti = TipoParametroProxy.select(model.getEntiId());

        if (fechaVigencia == null) {
            fechaVigencia = Calendar.getInstance().getTime();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificLoadDependencies() throws ApplicationException {
        if (enti.getEnti().isPuerto()) {
            final PuertoBO prtoBO = new PuertoBO();
            final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

            prtoCriterio.setSprtId(getSprtId());
            prtoCriterio.setIdioma(getIdioma());

            prtoList = prtoBO.selectList(prtoCriterio);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date getFechaVigencia() {
        return fechaVigencia;
    }

    /**
     * Sets the fecha vigencia.
     *
     * @param value
     *            the new fecha vigencia
     */
    public void setFechaVigencia(final Date value) {
        fechaVigencia = value;
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
