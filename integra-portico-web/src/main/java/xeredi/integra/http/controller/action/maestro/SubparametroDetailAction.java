package xeredi.integra.http.controller.action.maestro;

import java.util.Calendar;
import java.util.Date;

import xeredi.integra.http.controller.action.item.ItemDetailAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.maestro.bo.SubparametroBO;
import xeredi.integra.model.maestro.vo.SubparametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubparametroDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubparametroProxy;

// TODO: Auto-generated Javadoc
/**
 * The Class SubparametroDetailAction.
 */
public final class SubparametroDetailAction extends ItemDetailAction<SubparametroVO, TipoSubparametroDetailVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4494947768754537198L;

    /** The fecha vigencia. */
    private Date fechaVigencia;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificDetail() throws ApplicationException {
        if (fechaVigencia == null) {
            fechaVigencia = Calendar.getInstance().getTime();
        }

        final SubparametroBO itemBO = new SubparametroBO();

        model = itemBO.selectObject(model.getId(), idioma, fechaVigencia);
        enti = TipoSubparametroProxy.select(model.getEntiId());
    }

    /**
     * Gets the fecha vigencia.
     *
     * @return the fecha vigencia
     */
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
