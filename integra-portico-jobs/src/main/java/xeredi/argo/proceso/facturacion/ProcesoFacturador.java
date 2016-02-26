package xeredi.argo.proceso.facturacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import xeredi.argo.model.facturacion.bo.FacturadorBO;
import xeredi.argo.model.facturacion.vo.ValoracionGrupoCriterioVO;
import xeredi.argo.model.proceso.vo.MensajeCodigo;
import xeredi.argo.model.proceso.vo.ProcesoTipo;
import xeredi.argo.proceso.ProcesoTemplate;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoFacturador.
 */
public final class ProcesoFacturador extends ProcesoTemplate {

    /**
     * The Enum Params.
     */
    public enum Params {
        /** The ffac. */
        ffac,
        /** The fcsr. */
        fcsr,
        /** The pagador. */
        pagador,
        /** The prto. */
        prto,
        /** The tpsr. */
        tpsr,
        /** The srvc. */
        srvc,
        /** The vlrc. */
        vlrc
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void prepararProcesos() {
        // TODO Auto-generated method stub
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void ejecutarProceso() {
        final FacturadorBO fctrBO = new FacturadorBO(this);

        try {
            final ValoracionGrupoCriterioVO vgrpCriterio = new ValoracionGrupoCriterioVO();

            Date ffac = null;
            Long fcsrId = null;

            if (prbtData.getPrpmMap().containsKey(Params.ffac.name())) {
                ffac = new SimpleDateFormat("dd/MM/yyyy").parse(prbtData.getPrpmMap().get(Params.ffac.name())
                        .getValor());
            }
            if (prbtData.getPrpmMap().containsKey(Params.fcsr.name())) {
                fcsrId = Long.parseLong(prbtData.getPrpmMap().get(Params.fcsr.name()).getValor());
            }

            try {
                fctrBO.facturarValoraciones(vgrpCriterio, fcsrId, ffac);
            } catch (final Exception ex) {
                addError(MensajeCodigo.G_000, ex.getMessage());
            }
        } catch (final ParseException ex) {
            throw new Error(ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ProcesoTipo getProcesoTipo() {
        return ProcesoTipo.FACTURADOR;
    }

}
