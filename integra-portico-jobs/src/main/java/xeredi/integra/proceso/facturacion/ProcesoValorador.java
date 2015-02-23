package xeredi.integra.proceso.facturacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import xeredi.integra.model.comun.exception.ModelException;
import xeredi.integra.model.facturacion.bo.ValoradorBO;
import xeredi.integra.model.proceso.vo.ItemTipo;
import xeredi.integra.model.proceso.vo.MensajeCodigo;
import xeredi.integra.model.proceso.vo.ProcesoItemVO;
import xeredi.integra.model.proceso.vo.ProcesoTipo;
import xeredi.integra.proceso.ProcesoTemplate;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoValorador.
 */
public final class ProcesoValorador extends ProcesoTemplate {

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
        final ValoradorBO vldrBO = new ValoradorBO(this);

        final String crgoIdsString = prpmMap.get("crgoIdList").getValor();
        final String fliqString = prpmMap.get("fliq").getValor();

        try {
            final Date fliq = (new SimpleDateFormat("dd/MM/yyyy HH:mm")).parse(fliqString);
            final Set<Long> crgoIds = new HashSet<>();
            final StringTokenizer tokenizer = new StringTokenizer(crgoIdsString);

            while (tokenizer.hasMoreTokens()) {
                crgoIds.add(Long.parseLong(tokenizer.nextToken()));
            }

            for (final ProcesoItemVO pritEntrada : pritEntradaList) {
                try {
                    vldrBO.valorarServicio(pritEntrada.getItemId(), crgoIds, fliq);
                } catch (final ModelException ex) {
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
        return ProcesoTipo.VALORADOR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ItemTipo getItemTipoSalida() {
        return ItemTipo.vlrc;
    }

}
