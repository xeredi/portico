package xeredi.integra.proceso.facturacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import xeredi.integra.model.facturacion.bo.FacturadorBO;
import xeredi.integra.model.proceso.vo.ItemTipo;
import xeredi.integra.model.proceso.vo.MensajeCodigo;
import xeredi.integra.model.proceso.vo.ProcesoItemVO;
import xeredi.integra.model.proceso.vo.ProcesoTipo;
import xeredi.integra.proceso.ProcesoTemplate;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoFacturador.
 */
public final class ProcesoFacturador extends ProcesoTemplate {

    /** The Constant FFAC_PARAM. */
    public static final String FFAC_PARAM = "ffac";

    /** The Constant ASPCID_PARAM. */
    public static final String ASPCID_PARAM = "aspcId";

    /** The Constant FCSRID_PARAM. */
    public static final String FCSRID_PARAM = "fcsrId";

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

        final String ffacString = prpmMap.get(FFAC_PARAM).getValor();
        final String aspcIdString = prpmMap.get(ASPCID_PARAM).getValor();
        final String fcsrIdString = prpmMap.get(FCSRID_PARAM).getValor();

        try {
            final Date ffac = new SimpleDateFormat("dd/MM/yyyy").parse(ffacString);
            final Long aspcId = Long.parseLong(aspcIdString);
            final Long fcsrId = Long.parseLong(fcsrIdString);

            final Set<Long> vlrcIds = new HashSet<>();

            for (final ProcesoItemVO pritEntrada : pritEntradaList) {
                vlrcIds.add(pritEntrada.getItemId());
            }

            try {
                fctrBO.facturarValoraciones(vlrcIds, aspcId, fcsrId, ffac);
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

    /**
     * {@inheritDoc}
     */
    @Override
    protected ItemTipo getItemTipoSalida() {
        return ItemTipo.fctr;
    }

}
