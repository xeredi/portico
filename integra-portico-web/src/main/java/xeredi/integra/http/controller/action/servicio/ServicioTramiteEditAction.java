package xeredi.integra.http.controller.action.servicio;

import java.util.Date;

import xeredi.integra.http.controller.action.item.ItemStatechangeEditAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.comun.vo.ItemTramiteDatoVO;
import xeredi.integra.model.metamodelo.proxy.TipoServicioDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.integra.model.servicio.bo.ServicioBO;
import xeredi.integra.model.servicio.bo.ServicioBOFactory;
import xeredi.integra.model.servicio.vo.ServicioTramiteVO;
import xeredi.integra.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioStatechangeEditAction.
 */
public final class ServicioTramiteEditAction extends
ItemStatechangeEditAction<ServicioTramiteVO, ServicioVO, TipoServicioDetailVO> {

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

        ittr = new ServicioTramiteVO();

        ittr.setSrvcId(item.getId());
        ittr.setTrmt(trmt.getTrmt());

        if (!trmt.getTpdtList().isEmpty()) {
            for (final Long tpdtId : trmt.getTpdtList()) {
                final ItemTramiteDatoVO ittrDato = new ItemTramiteDatoVO();

                ittrDato.setTpdtId(tpdtId);

                if (item.getItdtMap().containsKey(tpdtId)) {
                    final ItemDatoVO itdt = item.getItdtMap().get(tpdtId);

                    ittrDato.setOcadena(itdt.getCadena());
                    ittrDato.setOnentero(itdt.getCantidadEntera());
                    ittrDato.setOndecimal(itdt.getCantidadDecimal());
                    ittrDato.setOfecha(itdt.getFecha());
                    ittrDato.setOprmt(itdt.getPrmt());
                    ittrDato.setOsrvc(itdt.getSrvc());

                    ittrDato.setDcadena(itdt.getCadena());
                    ittrDato.setDnentero(itdt.getCantidadEntera());
                    ittrDato.setDndecimal(itdt.getCantidadDecimal());
                    ittrDato.setDfecha(itdt.getFecha());
                    ittrDato.setDprmt(itdt.getPrmt());
                    ittrDato.setDsrvc(itdt.getSrvc());
                }

                ittr.getItdtMap().put(tpdtId, ittrDato);
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
