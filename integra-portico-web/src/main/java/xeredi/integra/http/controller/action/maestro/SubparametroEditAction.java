package xeredi.integra.http.controller.action.maestro;

import java.util.Date;

import xeredi.integra.http.controller.action.item.ItemEditAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.maestro.bo.SubparametroBO;
import xeredi.integra.model.maestro.vo.SubparametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubparametroDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubparametroProxy;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class SubparametroEditAction.
 */
public final class SubparametroEditAction extends ItemEditAction<SubparametroVO, TipoSubparametroDetailVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6767667432126657718L;

    /** The fecha vigencia. */
    private Date fechaVigencia;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificEdit() throws ApplicationException {
        Preconditions.checkNotNull(fechaVigencia);
        Preconditions.checkNotNull(model.getPrmtId());

        enti = TipoSubparametroProxy.select(model.getEntiId());

        if (accion != ACCION_EDICION.create) {
            final SubparametroBO itemBO = new SubparametroBO();

            model = itemBO.selectObject(model.getId(), getIdioma(), getFechaVigencia());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadSpecificDependencies() throws ApplicationException {
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
