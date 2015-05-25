package xeredi.integra.http.controller.action.servicio;

import java.util.Date;

import xeredi.integra.http.controller.action.item.ItemStatechangeEditAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.item.vo.ItemTramiteDatoVO;
import xeredi.integra.model.item.vo.ItemTramiteVO;
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

        ittr = new ItemTramiteVO();

        ittr.setItemId(item.getId());
        ittr.setOitemFini(item.getFini());
        ittr.setOitemFfin(item.getFfin());
        ittr.setDitemFini(item.getFini());
        ittr.setDitemFfin(item.getFfin());
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
        return item.getSrvc().getPrto().getId();
    }
}
