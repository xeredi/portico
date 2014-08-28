package xeredi.integra.model.servicio.grammar.manifiesto;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import xeredi.integra.model.servicio.grammar.manifiesto.IfcsumParser.IfcsumContext;
import xeredi.integra.model.util.Entidad;

// TODO: Auto-generated Javadoc
/**
 * The Class IfcsumLoader.
 */
public final class IfcsumLoader extends IfcsumBaseVisitor {

    /** The prmts. */
    private Map<Entidad, Set<String>> prmts;

    /**
     * {@inheritDoc}
     */
    @Override
    public Object visitIfcsum(IfcsumContext ctx) {
        prmts = new HashMap<Entidad, Set<String>>();

        // TODO Auto-generated method stub
        return super.visitIfcsum(ctx);
    }

}
