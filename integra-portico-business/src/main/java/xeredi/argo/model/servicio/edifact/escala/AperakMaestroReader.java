package xeredi.argo.model.servicio.edifact.escala;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.edifact.grammar.AperakD14bBaseVisitor;
import xeredi.edifact.grammar.AperakD14bParser.AperakContext;

// TODO: Auto-generated Javadoc
/**
 * The Class AperakMaestroReader.
 */
public final class AperakMaestroReader extends AperakD14bBaseVisitor {

    /** The maestro codes map. */
    private final Map<Entidad, Set<String>> maestroCodesMap = new HashMap<>();

    /** The nif set. */
    private final Set<String> nifSet = new HashSet<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public Object visitAperak(final AperakContext ctx) {
        return super.visitAperak(ctx);
    }

    /**
     * Adds the codigo maestro.
     *
     * @param entidad
     *            the entidad
     * @param codigo
     *            the codigo
     */
    private void addCodigoMaestro(final Entidad entidad, final String codigo) {
        if (!maestroCodesMap.containsKey(entidad)) {
            maestroCodesMap.put(entidad, new HashSet<String>());
        }

        maestroCodesMap.get(entidad).add(codigo);
    }

    /**
     * Gets the maestro codes map.
     *
     * @return the maestro codes map
     */
    public Map<Entidad, Set<String>> getMaestroCodesMap() {
        return maestroCodesMap;
    }

    /**
     * Gets the nif set.
     *
     * @return the nif set
     */
    public Set<String> getNifSet() {
        return nifSet;
    }
}
