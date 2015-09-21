package xeredi.argo.proceso.facturacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import xeredi.argo.model.facturacion.bo.FacturadorBO;
import xeredi.argo.model.proceso.vo.MensajeCodigo;
import xeredi.argo.model.proceso.vo.ProcesoItemVO;
import xeredi.argo.model.proceso.vo.ProcesoTipo;
import xeredi.argo.proceso.ProcesoTemplate;

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

        try {
            Date ffac = null;
            Long aspcId = null;
            Long fcsrId = null;

            if (prpmMap.containsKey(FFAC_PARAM)) {
                ffac = new SimpleDateFormat("dd/MM/yyyy").parse(prpmMap.get(FFAC_PARAM).getValor());
            }
            if (prpmMap.containsKey(ASPCID_PARAM)) {
                aspcId = Long.parseLong(prpmMap.get(ASPCID_PARAM).getValor());
            }
            if (prpmMap.containsKey(FCSRID_PARAM)) {
                fcsrId = Long.parseLong(prpmMap.get(FCSRID_PARAM).getValor());
            }

            final Set<Long> vlrcIds = new HashSet<>();

            for (final ProcesoItemVO pritEntrada : pritEntradaList) {
                vlrcIds.add(pritEntrada.getItemId());
            }

            if (!vlrcIds.isEmpty()) {
                try {
                    fctrBO.facturarValoraciones(vlrcIds, aspcId, fcsrId, ffac);
                } catch (final Exception ex) {
                    addError(MensajeCodigo.G_000, ex.getMessage());
                }
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
