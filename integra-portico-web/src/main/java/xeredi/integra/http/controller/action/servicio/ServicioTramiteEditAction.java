package xeredi.integra.http.controller.action.servicio;

import java.util.Date;

import xeredi.integra.http.controller.action.item.ItemStatechangeEditAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.item.vo.ItemTramiteDatoVO;
import xeredi.integra.model.item.vo.ItemTramiteVO;
import xeredi.integra.model.metamodelo.proxy.TipoServicioDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.integra.model.servicio.bo.ServicioBO;
import xeredi.integra.model.servicio.bo.ServicioBOFactory;
import xeredi.integra.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioStatechangeEditAction.
 */
public final class ServicioTramiteEditAction extends ItemStatechangeEditAction<ServicioVO, TipoServicioDetailVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7471950448846195873L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doStatechangeEdit() throws ApplicationException {
        enti = TipoServicioProxy.select(item.getEntiId());

        final ServicioBO srvcBO = ServicioBOFactory.newInstance(item.getEntiId());

        item = srvcBO.select(item.getId(), idioma);

        ittr = new ItemTramiteVO();

        ittr.setItemId(item.getId());
        ittr.setTrmt(trmt.getTrmt());

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

                ittr.getIttdMap().put(tpdtId, ittd);
            }
        }
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
        return item.getPrto().getId();
    }
}
