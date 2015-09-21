package xeredi.argo.http.controller.action.servicio;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import xeredi.argo.http.controller.action.item.ItemFilterAction;
import xeredi.argo.model.comun.bo.PuertoBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.argo.model.metamodelo.vo.TipoServicioDetailVO;
import xeredi.argo.model.servicio.vo.ServicioCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioFilterAction.
 */
public final class ServicioFilterAction extends ItemFilterAction<ServicioCriterioVO, TipoServicioDetailVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1880833298596581117L;

    /** The subps. */
    private List<PuertoVO> prtoList;

    /** The fecha vigencia. */
    private Date fechaVigencia;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificPrepareFilter() throws ApplicationException {
        enti = TipoServicioProxy.select(model.getEntiId());

        if (fechaVigencia == null) {
            fechaVigencia = Calendar.getInstance().getTime();
        }
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
