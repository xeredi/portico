package xeredi.integra.http.controller.action.item;

import com.google.common.base.Preconditions;

import xeredi.integra.http.controller.action.comun.CrudDetailAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.ItemVO;
import xeredi.integra.model.item.bo.ItemTramiteBO;
import xeredi.integra.model.item.vo.ItemTramiteVO;
import xeredi.integra.model.metamodelo.proxy.EntidadProxy;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.integra.model.metamodelo.proxy.TramiteProxy;
import xeredi.integra.model.metamodelo.vo.AbstractEntidadDetailVO;
import xeredi.integra.model.metamodelo.vo.TipoEntidad;
import xeredi.integra.model.metamodelo.vo.TipoServicioDetailVO;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioDetailVO;
import xeredi.integra.model.metamodelo.vo.TramiteDetailVO;
import xeredi.integra.model.servicio.bo.ServicioBO;
import xeredi.integra.model.servicio.bo.ServicioBOFactory;
import xeredi.integra.model.servicio.bo.SubservicioBO;
import xeredi.integra.model.servicio.bo.SubservicioBOFactory;
import xeredi.integra.model.servicio.vo.ServicioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemTramiteDetailAction.
 */
public final class ItemTramiteDetailAction extends CrudDetailAction<ItemTramiteVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2680320980030804227L;

    /** The trmt. */
    protected TramiteDetailVO trmt;

    /** The enti. */
    protected AbstractEntidadDetailVO enti;

    /** The item. */
    protected ItemVO item;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        final ItemTramiteBO ittrBO = new ItemTramiteBO();

        model = ittrBO.select(model.getId(), idioma);
        trmt = TramiteProxy.select(model.getTrmt().getId());

        final TipoEntidad tipoEntidad = EntidadProxy.select(model.getTrmt().getEntiId()).getEnti().getTipo();

        switch (tipoEntidad) {
        case T:
            final TipoServicioDetailVO tpsr = TipoServicioProxy.select(model.getTrmt().getEntiId());
            final ServicioBO srvcBO = ServicioBOFactory.newInstance(tpsr.getEnti().getId());
            final ServicioVO srvc = srvcBO.select(model.getItemId(), getIdioma());

            fechaVigencia = srvc.getFref();

            item = srvc;
            enti = tpsr;

            break;
        case S:
            final TipoSubservicioDetailVO tpss = TipoSubservicioProxy.select(model.getTrmt().getEntiId());
            final SubservicioBO ssrvBO = SubservicioBOFactory.newInstance(model.getTrmt().getEntiId());
            final SubservicioVO ssrv = ssrvBO.select(model.getItemId(), getIdioma());

            fechaVigencia = ssrv.getFref();

            item = ssrv;
            enti = tpss;

            break;
        case P:
            throw new Error("No implementado!!");
        default:
            throw new Error("Invalid entity type: " + tipoEntidad);
        }
    }

    /**
     * Gets the trmt.
     *
     * @return the trmt
     */
    public TramiteDetailVO getTrmt() {
        return trmt;
    }

    /**
     * Gets the enti.
     *
     * @return the enti
     */
    public AbstractEntidadDetailVO getEnti() {
        return enti;
    }

    /**
     * Gets the item.
     *
     * @return the item
     */
    public ItemVO getItem() {
        return item;
    }
}
