package xeredi.integra.http.controller.action.servicio;

import java.util.Date;

import xeredi.integra.http.controller.action.item.ItemStatechangeEditAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.integra.model.servicio.bo.SubservicioBO;
import xeredi.integra.model.servicio.bo.SubservicioBOFactory;
import xeredi.integra.model.servicio.vo.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioTramiteEditAction.
 */
public final class SubservicioTramiteEditAction extends
        ItemStatechangeEditAction<SubservicioVO, TipoSubservicioDetailVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6881857585295487229L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doStatechangeEdit() throws ApplicationException {
        enti = TipoSubservicioProxy.select(item.getEntiId());

        final SubservicioBO ssrvBO = SubservicioBOFactory.newInstance(item.getEntiId());

        item = ssrvBO.select(item.getId(), idioma);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date getFechaVigencia() {
        return item.getFref();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long getPrtoId() {
        return item.getSrvc().getPrto().getId();
    }
}
