package xeredi.argo.http.controller.action.servicio;

import java.util.Calendar;
import java.util.Date;

import xeredi.argo.http.controller.action.item.ItemFilterAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioDetailVO;
import xeredi.argo.model.servicio.vo.SubservicioCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioFilterAction.
 */
public final class SubservicioFilterAction extends ItemFilterAction<SubservicioCriterioVO, TipoSubservicioDetailVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8222430396254969052L;

    /** The fecha vigencia. */
    private Date fechaVigencia;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificPrepareFilter() throws ApplicationException {
        enti = TipoSubservicioProxy.select(model.getEntiId());

        if (fechaVigencia == null) {
            fechaVigencia = Calendar.getInstance().getTime();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificLoadDependencies() throws ApplicationException {
        // noop
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
}
