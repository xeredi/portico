package xeredi.argo.http.controller.action.item;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.item.bo.ItemTramiteBO;
import xeredi.argo.model.item.vo.ItemTramiteVO;
import xeredi.argo.model.item.vo.ItemVO;
import xeredi.argo.model.metamodelo.proxy.EntidadProxy;
import xeredi.argo.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.argo.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.argo.model.metamodelo.proxy.TramiteProxy;
import xeredi.argo.model.metamodelo.vo.AbstractEntidadDetailVO;
import xeredi.argo.model.metamodelo.vo.TipoEntidad;
import xeredi.argo.model.metamodelo.vo.TipoServicioDetailVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioDetailVO;
import xeredi.argo.model.metamodelo.vo.TramiteDetailVO;
import xeredi.argo.model.servicio.bo.ServicioBO;
import xeredi.argo.model.servicio.bo.ServicioBOFactory;
import xeredi.argo.model.servicio.bo.SubservicioBO;
import xeredi.argo.model.servicio.bo.SubservicioBOFactory;
import xeredi.argo.model.servicio.vo.ServicioVO;
import xeredi.argo.model.servicio.vo.SubservicioVO;

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

            item = srvc;
            enti = tpsr;

            break;
        case S:
            final TipoSubservicioDetailVO tpss = TipoSubservicioProxy.select(model.getTrmt().getEntiId());
            final SubservicioBO ssrvBO = SubservicioBOFactory.newInstance(model.getTrmt().getEntiId());
            final SubservicioVO ssrv = ssrvBO.select(model.getItemId(), getIdioma());

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
