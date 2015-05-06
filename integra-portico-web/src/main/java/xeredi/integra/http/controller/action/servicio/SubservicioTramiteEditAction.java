package xeredi.integra.http.controller.action.servicio;

import java.util.Date;

import xeredi.integra.http.controller.action.item.ItemStatechangeEditAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.comun.vo.ItemTramiteDatoVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.integra.model.servicio.bo.SubservicioBO;
import xeredi.integra.model.servicio.bo.SubservicioBOFactory;
import xeredi.integra.model.servicio.vo.SubservicioTramiteVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioTramiteEditAction.
 */
public final class SubservicioTramiteEditAction extends
        ItemStatechangeEditAction<SubservicioTramiteVO, SubservicioVO, TipoSubservicioDetailVO> {

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

        ittr = new SubservicioTramiteVO();

        ittr.setSsrvId(item.getId());
        ittr.setOssrvFini(item.getFini());
        ittr.setOssrvFfin(item.getFfin());
        ittr.setDssrvFini(item.getFini());
        ittr.setDssrvFfin(item.getFfin());
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
        return item.getSrvc().getPrto().getId();
    }
}
