package xeredi.argo.http.controller.action.item;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.item.vo.ItemDatoVO;
import xeredi.argo.model.item.vo.ItemTramiteDatoVO;
import xeredi.argo.model.item.vo.ItemTramiteVO;
import xeredi.argo.model.item.vo.ItemVO;
import xeredi.argo.model.maestro.bo.ParametroBO;
import xeredi.argo.model.maestro.bo.ParametroBOFactory;
import xeredi.argo.model.metamodelo.proxy.EntidadProxy;
import xeredi.argo.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.argo.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.argo.model.metamodelo.proxy.TramiteProxy;
import xeredi.argo.model.metamodelo.vo.AbstractEntidadDetailVO;
import xeredi.argo.model.metamodelo.vo.TipoEntidad;
import xeredi.argo.model.metamodelo.vo.TipoHtml;
import xeredi.argo.model.metamodelo.vo.TipoServicioDetailVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioDetailVO;
import xeredi.argo.model.metamodelo.vo.TramiteDetailVO;
import xeredi.argo.model.metamodelo.vo.TramiteTipoDatoVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;
import xeredi.argo.model.servicio.bo.ServicioBO;
import xeredi.argo.model.servicio.bo.ServicioBOFactory;
import xeredi.argo.model.servicio.bo.SubservicioBO;
import xeredi.argo.model.servicio.bo.SubservicioBOFactory;
import xeredi.argo.model.servicio.vo.ServicioVO;
import xeredi.argo.model.servicio.vo.SubservicioVO;
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemTramiteEditAction.
 */
public final class ItemTramiteEditAction extends CrudEditAction<ItemTramiteVO> implements ProtectedItemAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7371401403513787913L;

    /** The trmt. */
    protected TramiteDetailVO trmt;

    /** The item. */
    private ItemVO item;

    /** The enti. */
    private AbstractEntidadDetailVO enti;

    /** The label values map. */
    private HashMap<Long, List<LabelValueVO>> labelValuesMap;

    /** The prto id. */
    private Long prtoId;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doEdit() throws ApplicationException {
        Preconditions.checkNotNull(model.getItemId());
        Preconditions.checkNotNull(model.getTrmt().getId());

        trmt = TramiteProxy.select(model.getTrmt().getId());

        model.setTrmt(trmt.getTrmt());

        final TipoEntidad tipoEntidad = EntidadProxy.select(model.getTrmt().getEntiId()).getEnti().getTipo();

        switch (tipoEntidad) {
        case T:
            final TipoServicioDetailVO tpsr = TipoServicioProxy.select(model.getTrmt().getEntiId());
            final ServicioBO srvcBO = ServicioBOFactory.newInstance(tpsr.getEnti().getId());
            final ServicioVO srvc = srvcBO.select(model.getItemId(), getIdioma());

            prtoId = srvc.getPrto().getId();

            item = srvc;
            enti = tpsr;

            break;
        case S:
            final TipoSubservicioDetailVO tpss = TipoSubservicioProxy.select(model.getTrmt().getEntiId());
            final SubservicioBO ssrvBO = SubservicioBOFactory.newInstance(model.getTrmt().getEntiId());
            final SubservicioVO ssrv = ssrvBO.select(model.getItemId(), getIdioma());

            prtoId = ssrv.getSrvc().getPrto().getId();

            model.setOitemFini(ssrv.getFini());
            model.setOitemFfin(ssrv.getFfin());
            model.setDitemFini(ssrv.getFini());
            model.setDitemFfin(ssrv.getFfin());

            item = ssrv;
            enti = tpss;

            break;
        case P:
            throw new Error("No implementado!!");
        default:
            throw new Error("Invalid entity type: " + tipoEntidad);
        }

        if (!trmt.getTpdtList().isEmpty()) {
            for (final Long tpdtId : trmt.getTpdtList()) {
                final ItemTramiteDatoVO ittd = new ItemTramiteDatoVO();

                ittd.setTpdtId(tpdtId);

                if (item.getItdtMap().containsKey(tpdtId)) {
                    final ItemDatoVO itdt = item.getItdtMap().get(tpdtId);

                    ittd.setOcadena(itdt.getCadena());
                    ittd.setOnentero(itdt.getCantidadEntera());
                    ittd.setOndecimal(itdt.getCantidadDecimal());
                    ittd.setOfecha(itdt.getFecha());
                    ittd.setOprmt(itdt.getPrmt());
                    ittd.setOsrvc(itdt.getSrvc());

                    ittd.setDcadena(itdt.getCadena());
                    ittd.setDnentero(itdt.getCantidadEntera());
                    ittd.setDndecimal(itdt.getCantidadDecimal());
                    ittd.setDfecha(itdt.getFecha());
                    ittd.setDprmt(itdt.getPrmt());
                    ittd.setDsrvc(itdt.getSrvc());
                }

                model.getIttdMap().put(tpdtId, ittd);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doLoadDependencies() throws ApplicationException {
        Preconditions.checkNotNull(model.getTrmt().getEntiId());

        labelValuesMap = new HashMap<Long, List<LabelValueVO>>();

        final Set<Long> tpprIds = new HashSet<>();

        for (final TramiteTipoDatoVO trtd : trmt.getTrtdMap().values()) {
            if (trtd.getEntd().getTpdt().getTpht() != TipoHtml.F && trtd.getEntd().getTpdt().getEnti() != null
                    && trtd.getEntd().getTpdt().getEnti().getId() != null) {
                tpprIds.add(trtd.getEntd().getTpdt().getEnti().getId());
            }
        }

        if (!tpprIds.isEmpty()) {
            final ParametroBO prmtBO = ParametroBOFactory.newDefaultInstance();

            labelValuesMap.putAll(prmtBO.selectLabelValues(tpprIds, model.getFref(), idioma));
        }
    }

    /**
     * Gets the trmt.
     *
     * @return the trmt
     */
    public final TramiteDetailVO getTrmt() {
        return trmt;
    }

    /**
     * Gets the item.
     *
     * @return the item
     */
    public final ItemVO getItem() {
        return item;
    }

    /**
     * Gets the label values map.
     *
     * @return the label values map
     */
    public final HashMap<Long, List<LabelValueVO>> getLabelValuesMap() {
        return labelValuesMap;
    }

    /**
     * Gets the prto id.
     *
     * @return the prto id
     */
    public final Long getPrtoId() {
        return prtoId;
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
     * {@inheritDoc}
     */
    @Override
    public final Long getEntiId() {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getTrmt());
        Preconditions.checkNotNull(model.getTrmt().getEntiId());

        return model.getTrmt().getEntiId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final AccionPrefix getAccnPrefix() {
        return AccionPrefix.item;
    }
}
